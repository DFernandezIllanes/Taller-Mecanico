package ar.com.besysoft.tallermecanico.service.implementations;

import ar.com.besysoft.tallermecanico.exception.repeat.RepuestoRepeatException;
import ar.com.besysoft.tallermecanico.model.Repuesto;
import ar.com.besysoft.tallermecanico.repository.RepuestoRepository;
import ar.com.besysoft.tallermecanico.service.interfaces.RepuestoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepuestoServiceImpl implements RepuestoService {

    private final RepuestoRepository repuestoRepository;

    public RepuestoServiceImpl(RepuestoRepository repuestoRepository) {
        this.repuestoRepository = repuestoRepository;
    }

    @Override
    public List<Repuesto> getAll() {
        return this.repuestoRepository.findAll();
    }

    @Override
    public Repuesto create(Repuesto repuesto) {
        Optional<Repuesto> repuestoOptional = this.repuestoRepository.findByMarcaAndModeloAndRepuesto(
                repuesto.getMarca(), repuesto.getModelo(), repuesto.getRepuesto());

        if(repuestoOptional.isPresent()) {
            throw new RepuestoRepeatException(String.format("El repuesto ingresado ya existe"),
                    new RuntimeException("Causa Original")
            );
        }
        return this.repuestoRepository.save(repuesto);
    }
}
