package ar.com.besysoft.tallermecanico.service.interfaces;

import ar.com.besysoft.tallermecanico.model.Repuesto;

import java.util.List;

public interface RepuestoService {
    List<Repuesto> getAll();
    Repuesto create(Repuesto repuesto);
}
