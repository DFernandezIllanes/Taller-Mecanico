package ar.com.besysoft.tallermecanico.controller;

import ar.com.besysoft.tallermecanico.dtos.FinReparacionInfoDTO;
import ar.com.besysoft.tallermecanico.dtos.ManoObraInfoDTO;
import ar.com.besysoft.tallermecanico.dtos.MecanicoDTO;
import ar.com.besysoft.tallermecanico.dtos.mappers.DetalleOrdenTrabajoMapper;
import ar.com.besysoft.tallermecanico.dtos.mappers.ManoObraMapper;
import ar.com.besysoft.tallermecanico.dtos.mappers.MecanicoMapper;
import ar.com.besysoft.tallermecanico.dtos.mappers.OrdenTrabajoMapper;
import ar.com.besysoft.tallermecanico.model.DetalleOrdenTrabajo;
import ar.com.besysoft.tallermecanico.model.ManoObra;
import ar.com.besysoft.tallermecanico.model.Mecanico;
import ar.com.besysoft.tallermecanico.model.OrdenTrabajo;
import ar.com.besysoft.tallermecanico.service.interfaces.MecanicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
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

    @PutMapping("/{id}/manoObra")
    public ResponseEntity<?> startRepair(@PathVariable(required = true) BigInteger id,
                                         @Valid @RequestBody(required = false)FinReparacionInfoDTO infoDTO) {
        if(infoDTO == null) {
            OrdenTrabajo ordenTrabajo = this.mecanicoService.startRepair(id);
            return new ResponseEntity<>(OrdenTrabajoMapper.mapToDto(ordenTrabajo), HttpStatus.OK);
        }
        ManoObra manoObra = ManoObraMapper.mapInfoDtoToEntity(infoDTO.getManoObraInfoDTO());
        List<DetalleOrdenTrabajo> listaDetalles = DetalleOrdenTrabajoMapper.mapListRequestToEntity(infoDTO.getListaDetalles());
        OrdenTrabajo ordenTrabajo = this.mecanicoService.finRepair(id, manoObra, listaDetalles);
        return ResponseEntity.ok(OrdenTrabajoMapper.mapToDetailsDto(ordenTrabajo));
    }
}
