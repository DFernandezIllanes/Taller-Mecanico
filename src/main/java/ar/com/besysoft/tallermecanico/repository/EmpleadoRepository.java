package ar.com.besysoft.tallermecanico.repository;

import ar.com.besysoft.tallermecanico.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, BigInteger> {
    Optional<Empleado> findByIdAndTipoEmpleado(BigInteger id, String tipoEmpleado);
}
