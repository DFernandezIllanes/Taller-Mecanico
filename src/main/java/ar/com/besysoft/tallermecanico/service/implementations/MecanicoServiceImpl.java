package ar.com.besysoft.tallermecanico.service.implementations;

import ar.com.besysoft.tallermecanico.exception.notAssigned.MecanicoNotAssignedException;
import ar.com.besysoft.tallermecanico.exception.notFound.ManoObraNotFoundException;
import ar.com.besysoft.tallermecanico.exception.notFound.MecanicoNotFoundException;
import ar.com.besysoft.tallermecanico.exception.notFound.OrdenTrabajoNotFoundException;
import ar.com.besysoft.tallermecanico.exception.notFound.RepuestoNotFoundException;
import ar.com.besysoft.tallermecanico.model.*;
import ar.com.besysoft.tallermecanico.repository.*;
import ar.com.besysoft.tallermecanico.service.interfaces.MecanicoService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MecanicoServiceImpl implements MecanicoService {

    private final MecanicoRepository mecanicoRepository;
    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final ManoObraRepository manoObraRepository;
    private final RepuestoRepository repuestoRepository;
    private final DetalleOrdenTrabajoRepository detalleRepository;

    public MecanicoServiceImpl(MecanicoRepository mecanicoRepository, OrdenTrabajoRepository ordenTrabajoRepository,
                               ManoObraRepository manoObraRepository, RepuestoRepository repuestoRepository,
                               DetalleOrdenTrabajoRepository detalleRepository) {
        this.mecanicoRepository = mecanicoRepository;
        this.ordenTrabajoRepository = ordenTrabajoRepository;
        this.manoObraRepository = manoObraRepository;
        this.repuestoRepository = repuestoRepository;
        this.detalleRepository = detalleRepository;
    }

    @Override
    public List<Mecanico> getAll() {
        return this.mecanicoRepository.findAll();
    }

    @Override
    public Mecanico create(Mecanico mecanico) {
        return this.mecanicoRepository.save(mecanico);
    }

    @Override
    public OrdenTrabajo startRepair(BigInteger id) {
        Mecanico mecanico = buscarMecanicoPorId(id);
        ManoObra manoObra = buscarUltimaManoObraAsignada(mecanico);
        OrdenTrabajo ordenTrabajo = buscarOrdenTrabajoPorId(manoObra.getOrdenTrabajo().getId());
        return cambiarEstadoOrdenTrabajoYGuardar(ordenTrabajo, "En reparacion");
    }

    @Override
    public OrdenTrabajo finRepair(BigInteger id, ManoObra manoObra, List<DetalleOrdenTrabajo> listaDetalles) {
        Mecanico mecanico = buscarMecanicoPorId(id);
        ManoObra manoObraAsignada = buscarUltimaManoObraAsignada(mecanico);
        manoObraAsignada = cargarDatosManoObra(manoObraAsignada, manoObra);
        OrdenTrabajo ordenTrabajo = buscarOrdenTrabajoPorId(manoObraAsignada.getOrdenTrabajo().getId());
        ordenTrabajo.setFechaFinReparacion(Timestamp.valueOf(LocalDateTime.now()));
        cargarDetallesOrdenTrabajo(listaDetalles, ordenTrabajo);
        return cambiarEstadoOrdenTrabajoYGuardar(ordenTrabajo, "Para facturar");
    }

    private Mecanico buscarMecanicoPorId(BigInteger id) {
        Optional<Mecanico> mecanicoOptional = this.mecanicoRepository.findById(id);
        if(!mecanicoOptional.isPresent()) {
            throw new MecanicoNotFoundException(String.format("No existe un mecanico con ID %d", id),
                    new RuntimeException("Causa Original")
            );
        }
        return mecanicoOptional.get();
    }

    private ManoObra buscarUltimaManoObraAsignada(Mecanico mecanico) {
        Optional<ManoObra> manoObraOptional = mecanico.getLastManoObra();
        if(!manoObraOptional.isPresent()) {
            throw new MecanicoNotAssignedException(String.format("El mecanico con ID %d no se le ha asignado tarea alguna", mecanico.getId()),
                    new RuntimeException("Causa Original")
            );
        }
        return manoObraOptional.get();
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

    private OrdenTrabajo cambiarEstadoOrdenTrabajoYGuardar(OrdenTrabajo ordenTrabajo, String nuevoEstado) {
        ordenTrabajo.setEstado(nuevoEstado);
        return this.ordenTrabajoRepository.save(ordenTrabajo);
    }

    private ManoObra cargarDatosManoObra(ManoObra manoObraAsignada, ManoObra datosManoObra) {
        manoObraAsignada = buscarManoObraPorId(manoObraAsignada.getId());
        manoObraAsignada.setDetalle(datosManoObra.getDetalle());
        manoObraAsignada.setDuracionEnHs(datosManoObra.getDuracionEnHs());
        return this.manoObraRepository.save(manoObraAsignada);
    }

    private ManoObra buscarManoObraPorId(BigInteger id) {
        Optional<ManoObra> manoObraOptional = this.manoObraRepository.findById(id);
        if(!manoObraOptional.isPresent()) {
            throw new ManoObraNotFoundException(String.format("No existe una mano de obra con ID %d", id),
                    new RuntimeException("Causa Original")
            );
        }
        return manoObraOptional.get();
    }

    private List<DetalleOrdenTrabajo> cargarDetallesOrdenTrabajo(List<DetalleOrdenTrabajo> listaDetalles, OrdenTrabajo ordenTrabajo) {
        listaDetalles.forEach(d -> {
            d.setOrdenTrabajo(ordenTrabajo);
            d.setRepuesto(buscarRepuesto(d.getRepuesto()));
            d.calcularValorTotal();
        });
        return this.detalleRepository.saveAll(listaDetalles);
    }

    private Repuesto buscarRepuesto(Repuesto repuesto) {
        Optional<Repuesto> repuestoOptional = this.repuestoRepository.findByMarcaAndModeloAndRepuesto(
                repuesto.getMarca(), repuesto.getModelo(), repuesto.getRepuesto());

        if(!repuestoOptional.isPresent()) {
            throw new RepuestoNotFoundException(
                    String.format("No existe un repuesto de marca: %s, modelo: %s, repuesto: %s",
                            repuesto.getMarca(), repuesto.getModelo(), repuesto.getRepuesto()),
                    new RuntimeException("Causa Original")
            );
        }
        return repuestoOptional.get();
    }
}
