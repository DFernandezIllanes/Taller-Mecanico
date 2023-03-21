package ar.com.besysoft.tallermecanico.repository;

import ar.com.besysoft.tallermecanico.model.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, BigInteger> {
}
