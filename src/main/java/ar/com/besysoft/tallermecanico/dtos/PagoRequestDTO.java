package ar.com.besysoft.tallermecanico.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagoRequestDTO {
    @NotNull
    private BigInteger administrativoId;
    @NotNull
    @NotEmpty
    private String formaPago;
    @NotNull
    @NotEmpty
    private String tipoTarjeta;
    @NotNull
    private Integer cantidadCuotas;
}
