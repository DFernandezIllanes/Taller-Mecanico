package ar.com.besysoft.tallermecanico.dtos.requests;

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
public class OrdenTrabajoRequestDTO {
    @NotNull
    @NotEmpty
    private String nivelCombustible;
    @NotNull
    @NotEmpty
    private BigInteger kilometraje;
    @NotNull
    @NotEmpty
    private String detalleFalla;
    @NotNull
    @NotEmpty
    private BigInteger recepcionistaId;
    @NotNull
    @NotEmpty
    private String patente;
}
