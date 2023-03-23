package ar.com.besysoft.tallermecanico.repository;

import ar.com.besysoft.tallermecanico.model.DetalleOrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface DetalleOrdenTrabajoRepository extends JpaRepository<DetalleOrdenTrabajo, BigInteger> {
}
