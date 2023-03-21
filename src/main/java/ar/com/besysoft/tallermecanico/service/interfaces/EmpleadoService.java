package ar.com.besysoft.tallermecanico.service.interfaces;

import ar.com.besysoft.tallermecanico.model.Empleado;

import java.util.List;

public interface EmpleadoService {

    Empleado create(Empleado empleado);
    List<Empleado> getAll();
}
