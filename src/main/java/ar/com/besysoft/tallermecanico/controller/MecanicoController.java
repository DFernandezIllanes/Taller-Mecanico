package ar.com.besysoft.tallermecanico.controller;

import ar.com.besysoft.tallermecanico.dtos.MecanicoDTO;
import ar.com.besysoft.tallermecanico.dtos.mappers.MecanicoMapper;
import ar.com.besysoft.tallermecanico.model.Mecanico;
import ar.com.besysoft.tallermecanico.service.interfaces.MecanicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/mecanicos")
public class MecanicoController {

    private final MecanicoService mecanicoService;

    public MecanicoController(MecanicoService mecanicoService) {
        this.mecanicoService = mecanicoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Mecanico> mecanicoList = this.mecanicoService.getAll();
        return ResponseEntity.ok(MecanicoMapper.mapListToDto(mecanicoList));
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody MecanicoDTO mecanicoDTO) {
        Mecanico mecanico = MecanicoMapper.mapToEntity(mecanicoDTO);
        mecanico = this.mecanicoService.create(mecanico);
        return new ResponseEntity<>(MecanicoMapper.mapToDto(mecanico), HttpStatus.CREATED);
    }
}
