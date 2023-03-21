package ar.com.besysoft.tallermecanico.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private BigInteger id;
    private String celular;
    private String calle;
    private String codigoPostal;
    private String departamento;
    private String localidad;
    private String numero;
    private String piso;
    @NotNull
    @NotEmpty
    @Length(max = 80)
    private String apellido;
    @NotNull
    @NotEmpty
    private String correoElectronico;
    @NotNull
    @NotEmpty
    @Length(max = 100)
    private String nombres;
    private String telefonoLinea;
}
