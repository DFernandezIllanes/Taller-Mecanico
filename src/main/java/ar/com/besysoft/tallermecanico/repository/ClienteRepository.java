package ar.com.besysoft.tallermecanico.repository;

import ar.com.besysoft.tallermecanico.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, BigInteger> {

    Optional<Cliente> findByApellidoAndNombres(String apellido, String nombres);
    Optional<Cliente> findByCorreoElectronico(String correoElectronico);
}
