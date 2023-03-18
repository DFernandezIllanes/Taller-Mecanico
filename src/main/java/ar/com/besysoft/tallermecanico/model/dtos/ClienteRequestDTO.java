package ar.com.besysoft.tallermecanico.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO {

    @NotNull
    @Length(max = 80)
    private String apellido;
    @NotNull
    @NotEmpty
    private String correoElectronico;
    @NotNull
    @Length(max = 100)
    private String nombres;
    @NotNull
    private String patente;
}
