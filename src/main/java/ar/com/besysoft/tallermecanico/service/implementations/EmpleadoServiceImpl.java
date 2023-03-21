package ar.com.besysoft.tallermecanico.service.implementations;

import ar.com.besysoft.tallermecanico.model.Empleado;
import ar.com.besysoft.tallermecanico.repository.EmpleadoRepository;
import ar.com.besysoft.tallermecanico.service.interfaces.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Empleado create(Empleado empleado) {
        return this.empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAll() {
        return this.empleadoRepository.findAll();
    }
}
