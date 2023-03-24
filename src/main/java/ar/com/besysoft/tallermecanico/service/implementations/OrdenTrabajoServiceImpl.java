package ar.com.besysoft.tallermecanico.service.implementations;

import ar.com.besysoft.tallermecanico.dtos.PagoRequestDTO;
import ar.com.besysoft.tallermecanico.exception.mismatch.OrdenTrabajoMismatchException;
import ar.com.besysoft.tallermecanico.exception.notAvailable.MecanicoNotAvailableException;
import ar.com.besysoft.tallermecanico.exception.notFound.EmpleadoNotFoundException;
import ar.com.besysoft.tallermecanico.exception.notFound.OrdenTrabajoNotFoundException;
import ar.com.besysoft.tallermecanico.exception.notFound.VehiculoNotFoundException;
import ar.com.besysoft.tallermecanico.model.*;
import ar.com.besysoft.tallermecanico.repository.*;
import ar.com.besysoft.tallermecanico.service.interfaces.OrdenTrabajoService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenTrabajoServiceImpl implements OrdenTrabajoService {

    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final EmpleadoRepository empleadoRepository;
    private final VehiculoRepository vehiculoRepository;
    private final MecanicoRepository mecanicoRepository;
    private final ManoObraRepository manoObraRepository;

    public OrdenTrabajoServiceImpl(OrdenTrabajoRepository ordenTrabajoRepository, EmpleadoRepository empleadoRepository,
                                   VehiculoRepository vehiculoRepository, MecanicoRepository mecanicoRepository,
                                   ManoObraRepository manoObraRepository) {
        this.ordenTrabajoRepository = ordenTrabajoRepository;
        this.empleadoRepository = empleadoRepository;
        this.vehiculoRepository = vehiculoRepository;
        this.mecanicoRepository = mecanicoRepository;
        this.manoObraRepository = manoObraRepository;
    }

    @Override
    public OrdenTrabajo generar(OrdenTrabajo ordenTrabajo) {

        //TODO agregar validacion para no volver a ingresar un auto por patente que aun sigue en el taller

        Empleado recepcionista = validarEmpleadoPorIdyTipo(ordenTrabajo.getRecepcionista().getId(), "recepcionista");
        Vehiculo vehiculo = buscarVehiculoPorPatente(ordenTrabajo.getVehiculo().getPatente());
        return cargarDatosInicialesOrdenTrabajoYGuardar(ordenTrabajo, recepcionista, vehiculo);
    }

    @Override
    public List<OrdenTrabajo> getAll() {
        return this.ordenTrabajoRepository.findAll();
    }

    @Override
    public OrdenTrabajo asignarMecanico(BigInteger ordenTrabajoId, BigInteger mecanicoId) {
        OrdenTrabajo ordenTrabajo = buscarOrdenTrabajoPorId(ordenTrabajoId);
        Mecanico mecanico = buscarMecanicoPorId(mecanicoId);
        if( !comprobarDisponibilidadMecanico(mecanico)) {
            throw new MecanicoNotAvailableException(String.format("El mecanico con ID %d no esta disponible para realizar nuevas tareas", mecanicoId),
                    new RuntimeException("Causa Original")
            );
        }
        generarManoObra(ordenTrabajo, mecanico);
        return ordenTrabajo;
    }

    @Override
    public OrdenTrabajo getById(BigInteger id) {
        return buscarOrdenTrabajoPorId(id);
    }

    @Override
    public OrdenTrabajo generateBill(BigInteger ordenTrabajoId, PagoRequestDTO pagoRequestDTO) {
        OrdenTrabajo ordenTrabajo = buscarOrdenTrabajoPorId(ordenTrabajoId);
        ordenTrabajo = cargarDatosPago(ordenTrabajo, pagoRequestDTO);
        return cambiarEstadoOrdenTrabajoYGuardar(ordenTrabajo, "Facturada");
    }

    @Override
    public OrdenTrabajo closeBill(BigInteger ordenTrabajoId) {
        OrdenTrabajo ordenTrabajo = buscarOrdenTrabajoPorId(ordenTrabajoId);
        comprobarEstadoOrdenTrabajo(ordenTrabajo, "Facturada");
        return cambiarEstadoOrdenTrabajoYGuardar(ordenTrabajo, "Cerrada");
    }

    private OrdenTrabajo buscarOrdenTrabajoPorId(BigInteger id) {
        Optional<OrdenTrabajo> ordenTrabajoOptional = this.ordenTrabajoRepository.findById(id);
        if(!ordenTrabajoOptional.isPresent()) {
            throw new OrdenTrabajoNotFoundException(String.format("No existe una orden de trabajo con ID %d", id),
                    new RuntimeException("Causa Original")
            );
        }
        return ordenTrabajoOptional.get();
    }

    private Mecanico buscarMecanicoPorId(BigInteger id) {
        Optional<Mecanico> mecanicoOptional = this.mecanicoRepository.findById(id);
        if(!mecanicoOptional.isPresent()) {
            throw new OrdenTrabajoNotFoundException(String.format("No existe una orden de trabajo con ID %d", id),
                    new RuntimeException("Causa Original")
            );
        }
        return mecanicoOptional.get();
    }

    private OrdenTrabajo cargarDatosInicialesOrdenTrabajoYGuardar(OrdenTrabajo ordenTrabajo, Empleado recepcionista, Vehiculo vehiculo) {
        ordenTrabajo.setRecepcionista(recepcionista);
        ordenTrabajo.setVehiculo(vehiculo);
        return this.ordenTrabajoRepository.save(ordenTrabajo);
    }

    private Optional<Empleado> buscarEmpleadoPorIdYTipo(BigInteger empleadoId, String tipoEmpleado) {
        return this.empleadoRepository.findByIdAndTipoEmpleado(empleadoId, tipoEmpleado);
    }

    private boolean comprobarDisponibilidadMecanico(Mecanico mecanico) {
        Optional<ManoObra> manoObraOptional = mecanico.getLastManoObra();
        if(!manoObraOptional.isPresent()) {
            return true;
        }
        ManoObra manoObra = manoObraOptional.get();
        if(manoObra.getDetalle() == null || manoObra.getDetalle().isEmpty()) {
            return false;
        }
        return true;
    }

    private ManoObra generarManoObra(OrdenTrabajo ordenTrabajo, Mecanico mecanico) {
        ManoObra manoObra = new ManoObra();
        manoObra.setOrdenTrabajo(ordenTrabajo);
        manoObra.setMecanico(mecanico);
        return this.manoObraRepository.save(manoObra);
    }

    private OrdenTrabajo cargarDatosPago(OrdenTrabajo ordenTrabajo, PagoRequestDTO pagoRequestDTO) {
        Empleado administrativo = validarEmpleadoPorIdyTipo(pagoRequestDTO.getAdministrativoId(), "administrativo");
        ordenTrabajo.setAdministrativo(administrativo);
        ordenTrabajo.setFormaPago(pagoRequestDTO.getFormaPago());
        if(!pagoRequestDTO.getFormaPago().equalsIgnoreCase("efectivo")) {
            ordenTrabajo.setTipoTarjeta(pagoRequestDTO.getTipoTarjeta());
            if(pagoRequestDTO.getTipoTarjeta().equalsIgnoreCase("credito")) {
                ordenTrabajo.setCantidadCuotas(pagoRequestDTO.getCantidadCuotas());
            }
        }
        ordenTrabajo.setFechaPago(Timestamp.valueOf(LocalDateTime.now()));
        return ordenTrabajo;
    }

    private Empleado validarEmpleadoPorIdyTipo(BigInteger empleadoId, String tipoEmpleado) {
        Optional<Empleado> optionalEmpleado = buscarEmpleadoPorIdYTipo(empleadoId, tipoEmpleado);
        if(!optionalEmpleado.isPresent()) {
            throw new EmpleadoNotFoundException(String.format("No existe un empleado %s con ID %d", tipoEmpleado, empleadoId),
                    new RuntimeException("Causa Original")
            );
        }
        return optionalEmpleado.get();
    }

    private OrdenTrabajo cambiarEstadoOrdenTrabajoYGuardar(OrdenTrabajo ordenTrabajo, String nuevoEstado) {
        ordenTrabajo.setEstado(nuevoEstado);
        return this.ordenTrabajoRepository.save(ordenTrabajo);
    }

    private OrdenTrabajo comprobarEstadoOrdenTrabajo(OrdenTrabajo ordenTrabajo, String estado) {
        if(!ordenTrabajo.getEstado().equalsIgnoreCase(estado)) {
            throw new OrdenTrabajoMismatchException(String.format("La orden de trabajo no se encuentra en estado %s", estado),
                    new RuntimeException("Causa Original")
            );
        }
        return ordenTrabajo;
    }

    private Vehiculo buscarVehiculoPorPatente(String patente) {
        Optional<Vehiculo> vehiculoOptional = this.vehiculoRepository.findByPatente(patente);
        if(!vehiculoOptional.isPresent()) {
            throw new VehiculoNotFoundException(String.format("No existe un vehiculo con patente %s", patente),
                    new RuntimeException("Causa Original")
            );
        }
        return vehiculoOptional.get();
    }
}
