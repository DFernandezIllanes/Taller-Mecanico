package ar.com.besysoft.tallermecanico.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrdenInfoDTO {
    private Integer cantidad;
    private BigDecimal valorTotal;
    private String marca;
    private String modelo;
    private String repuesto;
}
