package ar.com.besysoft.tallermecanico.controller;

import ar.com.besysoft.tallermecanico.dtos.MecanicoDTO;
import ar.com.besysoft.tallermecanico.dtos.PagoRequestDTO;
import ar.com.besysoft.tallermecanico.dtos.mappers.MecanicoMapper;
import ar.com.besysoft.tallermecanico.dtos.mappers.OrdenTrabajoMapper;
import ar.com.besysoft.tallermecanico.dtos.requests.OrdenTrabajoRequestDTO;
import ar.com.besysoft.tallermecanico.model.Mecanico;
import ar.com.besysoft.tallermecanico.model.OrdenTrabajo;
import ar.com.besysoft.tallermecanico.service.interfaces.OrdenTrabajoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "/ordenes-trabajo")
public class OrdenTrabajoController {

    private final OrdenTrabajoService ordenTrabajoService;

    public OrdenTrabajoController(OrdenTrabajoService ordenTrabajoService) {
        this.ordenTrabajoService = ordenTrabajoService;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<OrdenTrabajo> ordenTrabajoList = this.ordenTrabajoService.getAll();
        return ResponseEntity.ok(OrdenTrabajoMapper.mapListToDto(ordenTrabajoList));
    }

    @GetMapping("/{id}/manoObra")
    public ResponseEntity<?> getById(@PathVariable(name = "id") BigInteger id) {
        OrdenTrabajo ordenTrabajo = this.ordenTrabajoService.getById(id);
        return ResponseEntity.ok(OrdenTrabajoMapper.mapToDetailsDto(ordenTrabajo));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrdenTrabajoRequestDTO requestDTO) {

        OrdenTrabajo ordenTrabajo = OrdenTrabajoMapper.mapRequestDtoToEntity(requestDTO);
        ordenTrabajo = this.ordenTrabajoService.generar(ordenTrabajo);
        return new ResponseEntity<>(OrdenTrabajoMapper.mapToDto(ordenTrabajo), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/factura")
    public ResponseEntity<?> bill(@PathVariable(required = true, name = "id") BigInteger ordenTrabajoId,
                                  @Valid @RequestBody(required = true) PagoRequestDTO pagoRequestDTO) {
        OrdenTrabajo factura = this.ordenTrabajoService.generateBill(ordenTrabajoId, pagoRequestDTO);
        return new ResponseEntity<>(OrdenTrabajoMapper.mapToDetailsDto(factura), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> assignMecanico(@PathVariable(name = "id") BigInteger ordenTrabajoId,
                                            @RequestBody BigInteger mecanicoId) {

        OrdenTrabajo ordenTrabajo = this.ordenTrabajoService.asignarMecanico(ordenTrabajoId, mecanicoId);
        return ResponseEntity.ok(OrdenTrabajoMapper.mapToDto(ordenTrabajo));
    }

    @PutMapping(path = "/{id}/cierre")
    public ResponseEntity<?> deliverVehicle(@PathVariable(required = true, name = "id") BigInteger ordenTrabajoId) {

        OrdenTrabajo ordenTrabajo = this.ordenTrabajoService.closeBill(ordenTrabajoId);
        return ResponseEntity.ok(OrdenTrabajoMapper.mapToDetailsDto(ordenTrabajo));
    }
}
