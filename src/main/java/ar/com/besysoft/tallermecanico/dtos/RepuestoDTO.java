package ar.com.besysoft.tallermecanico.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RepuestoDTO {
    private BigInteger id;
    @NotNull
    @NotEmpty
    private String marca;
    @NotNull
    @NotEmpty
    private String modelo;
    @NotNull
    @NotEmpty
    private String repuesto;
    @NotNull
    private BigDecimal valor;
}
