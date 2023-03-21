package ar.com.besysoft.tallermecanico.controller;

import ar.com.besysoft.tallermecanico.dtos.EmpleadoDTO;
import ar.com.besysoft.tallermecanico.dtos.mappers.EmpleadoMapper;
import ar.com.besysoft.tallermecanico.model.Empleado;
import ar.com.besysoft.tallermecanico.service.interfaces.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Empleado> empleadoList = this.empleadoService.getAll();
        return ResponseEntity.ok(EmpleadoMapper.mapListToDto(empleadoList));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody EmpleadoDTO empleadoDTO) {
        Empleado empleado = EmpleadoMapper.mapToEntity(empleadoDTO);
        empleado = this.empleadoService.create(empleado);
        return new ResponseEntity<>(EmpleadoMapper.mapToDto(empleado), HttpStatus.CREATED);
    }
}
