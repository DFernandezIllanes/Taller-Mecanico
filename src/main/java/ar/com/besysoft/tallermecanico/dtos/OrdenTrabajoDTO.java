package ar.com.besysoft.tallermecanico.dtos;

import ar.com.besysoft.tallermecanico.model.Empleado;
import ar.com.besysoft.tallermecanico.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenTrabajoDTO {
    private BigInteger id;
    private Integer cantidadCuotas;
    private String detalleFalla;
    private String estado;
    private Timestamp fechaIngreso;
    private Timestamp fechaFinReparacion;
    private Timestamp fechaPago;
    private String formaPago;
    @DecimalMax("2")
    private BigDecimal importeTotal;
    private BigInteger kilometraje;
    private String nivelCombustible;
    private String tipoTarjeta;
    private String administrativo;
    private String recepcionista;
    private String vehiculo;
}
