package ar.com.besysoft.tallermecanico.controller;

import ar.com.besysoft.tallermecanico.dtos.requests.RecepcionRequestDTO;
import ar.com.besysoft.tallermecanico.dtos.mappers.ClienteMapper;
import ar.com.besysoft.tallermecanico.dtos.mappers.VehiculoMapper;
import ar.com.besysoft.tallermecanico.model.Cliente;
import ar.com.besysoft.tallermecanico.model.Vehiculo;
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
