package ar.com.besysoft.tallermecanico.service.implementations;

import ar.com.besysoft.tallermecanico.model.Cliente;
import ar.com.besysoft.tallermecanico.repository.ClienteRepository;
import ar.com.besysoft.tallermecanico.service.interfaces.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAll() {
        return this.clienteRepository.findAll();
    }
}
