package ar.com.besysoft.tallermecanico.service.implementations;

import ar.com.besysoft.tallermecanico.model.ManoObra;
import ar.com.besysoft.tallermecanico.repository.ManoObraRepository;
import ar.com.besysoft.tallermecanico.service.interfaces.ManoObraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManoObraServiceImpl implements ManoObraService {

    private final ManoObraRepository manoObraRepository;

    public ManoObraServiceImpl(ManoObraRepository manoObraRepository) {
        this.manoObraRepository = manoObraRepository;
    }

    @Override
    public List<ManoObra> getAll() {
        return this.manoObraRepository.findAll();
    }
}
