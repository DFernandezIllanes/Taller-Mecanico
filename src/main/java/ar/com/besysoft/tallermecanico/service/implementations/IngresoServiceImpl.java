package ar.com.besysoft.tallermecanico.service.implementations;

import ar.com.besysoft.tallermecanico.exception.mismatch.ClienteMismatchException;
import ar.com.besysoft.tallermecanico.model.entities.Cliente;
import ar.com.besysoft.tallermecanico.model.entities.Vehiculo;
import ar.com.besysoft.tallermecanico.repository.ClienteRepository;
import ar.com.besysoft.tallermecanico.repository.VehiculoRepository;
import ar.com.besysoft.tallermecanico.service.interfaces.IngresoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IngresoServiceImpl implements IngresoService {

    private final ClienteRepository clienteRepository;
    private final VehiculoRepository vehiculoRepository;

    public IngresoServiceImpl(ClienteRepository clienteRepository, VehiculoRepository vehiculoRepository) {
        this.clienteRepository = clienteRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    @Transactional(readOnly = false)
    public Cliente registrarDatos(Cliente cliente, Vehiculo vehiculo) {

        Optional<Vehiculo> vehiculoOptional = this.vehiculoRepository.findByPatente(vehiculo.getPatente());
        Optional<Cliente> clienteOptional = this.clienteRepository.findByCorreoElectronico(cliente.getCorreoElectronico());

        if(vehiculoOptional.isPresent()) {
            vehiculo = vehiculoOptional.get();

            if (clienteOptional.isPresent()) {
                if (!(compararDatosCliente(clienteOptional.get(), cliente))) {
                    throw new ClienteMismatchException(
                            String.format("Ya hay otro cliente registrado con el mail %s", cliente.getCorreoElectronico()),
                            new RuntimeException("Causa Original")
                    );
                }
                cliente = clienteOptional.get();
            }
        } else if (clienteOptional.isPresent()) {
            cliente = clienteOptional.get();
            vehiculo = this.vehiculoRepository.save(vehiculo);
        }

        cliente.addVehiculo(vehiculo);
        return this.clienteRepository.save(cliente);
    }

    private boolean compararDatosCliente(Cliente clienteGuardado, Cliente clienteIngresado) {
        return clienteGuardado.getNombres().equals(clienteIngresado.getNombres()) &&
                clienteGuardado.getApellido().equals(clienteIngresado.getApellido());
    }
}
