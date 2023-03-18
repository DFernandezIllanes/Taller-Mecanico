package ar.com.besysoft.tallermecanico.service.implementations;

import ar.com.besysoft.tallermecanico.model.entities.Vehiculo;
import ar.com.besysoft.tallermecanico.repository.VehiculoRepository;
import ar.com.besysoft.tallermecanico.service.interfaces.VehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public List<Vehiculo> getAll() {
        return this.vehiculoRepository.findAll();
    }
}
