package ar.com.besysoft.tallermecanico.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManoObraDTO {

    private BigInteger id;
    private String detalle;
    private Time duracionEnHs;
    private BigInteger mecanicoId;
    private BigInteger ordenTrabajoId;
}
