package ar.com.besysoft.tallermecanico.service.implementations;

import ar.com.besysoft.tallermecanico.model.Mecanico;
import ar.com.besysoft.tallermecanico.repository.MecanicoRepository;
import ar.com.besysoft.tallermecanico.service.interfaces.MecanicoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicoServiceImpl implements MecanicoService {

    private final MecanicoRepository mecanicoRepository;

    public MecanicoServiceImpl(MecanicoRepository mecanicoRepository) {
        this.mecanicoRepository = mecanicoRepository;
    }

    @Override
    public List<Mecanico> getAll() {
        return this.mecanicoRepository.findAll();
    }

    @Override
    public Mecanico create(Mecanico mecanico) {
        return this.mecanicoRepository.save(mecanico);
    }
}
