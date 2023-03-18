package ar.com.besysoft.tallermecanico.service.interfaces;

import ar.com.besysoft.tallermecanico.model.entities.Cliente;
import ar.com.besysoft.tallermecanico.model.entities.Vehiculo;

public interface IngresoService {

    Cliente registrarDatos(Cliente cliente, Vehiculo vehiculo);
}
