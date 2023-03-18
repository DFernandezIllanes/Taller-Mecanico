package ar.com.besysoft.tallermecanico.controller;

import ar.com.besysoft.tallermecanico.model.dtos.RecepcionRequestDTO;
import ar.com.besysoft.tallermecanico.model.dtos.mappers.ClienteMapper;
import ar.com.besysoft.tallermecanico.model.dtos.mappers.VehiculoMapper;
import ar.com.besysoft.tallermecanico.model.entities.Cliente;
import ar.com.besysoft.tallermecanico.model.entities.Vehiculo;
import ar.com.besysoft.tallermecanico.service.interfaces.IngresoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/ingresos")
public class IngresoController {

    private final IngresoService ingresoService;

    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @PostMapping()
    public ResponseEntity<?> registrarDatosIngreso(@Valid @RequestBody(required = true) RecepcionRequestDTO recepcionRequestDTO) {

        Cliente cliente = ClienteMapper.mapToEntity(recepcionRequestDTO.getClienteDTO());
        Vehiculo vehiculo = VehiculoMapper.mapToEntity(recepcionRequestDTO.getVehiculoDTO());
        cliente = this.ingresoService.registrarDatos(cliente, vehiculo);
        return new ResponseEntity<>(ClienteMapper.mapToDetailsDto(cliente), HttpStatus.OK);
    }
}
