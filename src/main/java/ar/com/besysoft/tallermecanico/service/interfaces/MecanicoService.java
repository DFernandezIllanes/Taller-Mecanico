package ar.com.besysoft.tallermecanico.service.interfaces;

import ar.com.besysoft.tallermecanico.model.DetalleOrdenTrabajo;
import ar.com.besysoft.tallermecanico.model.ManoObra;
import ar.com.besysoft.tallermecanico.model.Mecanico;
import ar.com.besysoft.tallermecanico.model.OrdenTrabajo;

import java.math.BigInteger;
import java.util.List;

public interface MecanicoService {

    List<Mecanico> getAll();
    Mecanico create(Mecanico mecanico);
    OrdenTrabajo startRepair(BigInteger id);
    OrdenTrabajo finRepair(BigInteger id, ManoObra manoObra, List<DetalleOrdenTrabajo> listaDetalles);
}
