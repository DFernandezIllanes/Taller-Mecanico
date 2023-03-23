package ar.com.besysoft.tallermecanico.controller;

import ar.com.besysoft.tallermecanico.dtos.RepuestoDTO;
import ar.com.besysoft.tallermecanico.dtos.mappers.RepuestoMapper;
import ar.com.besysoft.tallermecanico.model.Repuesto;
import ar.com.besysoft.tallermecanico.service.interfaces.RepuestoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(path = "/repuestos")
public class RepuestoController {

    private final RepuestoService repuestoService;

    public RepuestoController(RepuestoService repuestoService) {
        this.repuestoService = repuestoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Repuesto> repuestoList = this.repuestoService.getAll();
        return ResponseEntity.ok(RepuestoMapper.mapListToDto(repuestoList));
    }

    @GetMapping(path = "/time")
    public ResponseEntity<?> getTime() {
        return ResponseEntity.ok(Time.valueOf(LocalTime.now()));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody(required = true)RepuestoDTO dto) {
        Repuesto repuesto = RepuestoMapper.mapToEntity(dto);
        repuesto = this.repuestoService.create(repuesto);
        return new ResponseEntity<>(RepuestoMapper.mapToDto(repuesto), HttpStatus.CREATED);
    }
}
