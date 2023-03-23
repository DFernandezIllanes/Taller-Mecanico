package ar.com.besysoft.tallermecanico.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManoObraInfoDTO {
    @NotNull
    @NotEmpty
    private String detalle;
    @NotNull
    private Time duracionEnHs;
    private BigInteger mecanicoId;
}
