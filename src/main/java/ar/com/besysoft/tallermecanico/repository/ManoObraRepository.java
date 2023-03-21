package ar.com.besysoft.tallermecanico.repository;

import ar.com.besysoft.tallermecanico.model.ManoObra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ManoObraRepository extends JpaRepository<ManoObra, BigInteger> {
}
