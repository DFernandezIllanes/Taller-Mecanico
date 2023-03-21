package ar.com.besysoft.tallermecanico.repository;

import ar.com.besysoft.tallermecanico.model.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface MecanicoRepository extends JpaRepository<Mecanico, BigInteger> {
}
