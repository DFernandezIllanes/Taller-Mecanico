package ar.com.besysoft.tallermecanico.service.interfaces;

import ar.com.besysoft.tallermecanico.model.Cliente;
import ar.com.besysoft.tallermecanico.model.Vehiculo;

public interface IngresoService {

    Cliente registrarDatos(Cliente cliente, Vehiculo vehiculo);
}
