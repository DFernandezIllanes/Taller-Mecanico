package ar.com.besysoft.tallermecanico.repository;

import ar.com.besysoft.tallermecanico.model.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface VehiculoRepository extends JpaRepository<Vehiculo, BigInteger> {

    Optional<Vehiculo> findByPatente(String patente);
}
