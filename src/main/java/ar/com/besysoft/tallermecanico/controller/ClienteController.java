package ar.com.besysoft.tallermecanico.controller;

import ar.com.besysoft.tallermecanico.model.dtos.mappers.ClienteMapper;
import ar.com.besysoft.tallermecanico.model.entities.Cliente;
import ar.com.besysoft.tallermecanico.service.interfaces.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<?> getClientes() {
        List<Cliente> clienteList = this.clienteService.getAll();
        return ResponseEntity.ok(ClienteMapper.mapListToDto(clienteList));
    }
}
