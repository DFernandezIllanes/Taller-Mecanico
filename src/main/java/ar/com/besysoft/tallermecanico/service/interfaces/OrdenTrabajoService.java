package ar.com.besysoft.tallermecanico.service.interfaces;

import ar.com.besysoft.tallermecanico.dtos.PagoRequestDTO;
import ar.com.besysoft.tallermecanico.model.Mecanico;
import ar.com.besysoft.tallermecanico.model.OrdenTrabajo;

import java.math.BigInteger;
import java.util.List;

public interface OrdenTrabajoService {

    OrdenTrabajo generar(OrdenTrabajo ordenTrabajo);
    List<OrdenTrabajo> getAll();
    OrdenTrabajo asignarMecanico(BigInteger ordenTrabajoId, BigInteger mecanicoId);
    OrdenTrabajo getById(BigInteger id);
    OrdenTrabajo generateBill(BigInteger ordenTrabajoId, PagoRequestDTO pagoRequestDTO);
}
