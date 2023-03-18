package ar.com.besysoft.tallermecanico.controller;

import ar.com.besysoft.tallermecanico.model.dtos.mappers.VehiculoMapper;
import ar.com.besysoft.tallermecanico.model.entities.Vehiculo;
import ar.com.besysoft.tallermecanico.service.interfaces.VehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        List<Vehiculo> vehiculoList = this.vehiculoService.getAll();
        return ResponseEntity.ok(VehiculoMapper.mapListToDto(vehiculoList));
    }
}
