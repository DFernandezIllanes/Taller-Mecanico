package ar.com.besysoft.tallermecanico.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleOrdenTrabajoRequestDTO {
    @NotNull
    private Integer cantidad;
    @NotNull
    @NotEmpty
    private String marca;
    @NotNull
    @NotEmpty
    private String modelo;
    @NotNull
    @NotEmpty
    private String repuesto;
}
