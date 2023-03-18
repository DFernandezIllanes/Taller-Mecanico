package ar.com.besysoft.tallermecanico.model.dtos;

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
public class VehiculoDTO {
    private BigInteger id;
    private Integer anio;
    private String color;
    private String marca;
    private String modelo;
    @NotNull
    private String patente;
}
