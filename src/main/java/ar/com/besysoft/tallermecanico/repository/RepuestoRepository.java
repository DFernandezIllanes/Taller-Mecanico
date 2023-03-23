package ar.com.besysoft.tallermecanico.repository;

import ar.com.besysoft.tallermecanico.model.Repuesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface RepuestoRepository extends JpaRepository<Repuesto, BigInteger> {

    Optional<Repuesto> findByMarcaAndModeloAndRepuesto(String marca, String modelo, String repuesto);
}
