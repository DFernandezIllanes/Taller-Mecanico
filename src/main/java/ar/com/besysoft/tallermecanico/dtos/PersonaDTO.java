package ar.com.besysoft.tallermecanico.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class PersonaDTO{

    protected BigInteger id;
    @Length(max = 15)
    protected String celular;
    protected String calle;
    protected String codigoPostal;
    protected String departamento;
    protected String localidad;
    protected String numero;
    protected String piso;
}
