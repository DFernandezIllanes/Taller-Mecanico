package ar.com.besysoft.tallermecanico.service.interfaces;

import ar.com.besysoft.tallermecanico.model.Mecanico;

import java.util.List;

public interface MecanicoService {

    List<Mecanico> getAll();
    Mecanico create(Mecanico mecanico);
}
