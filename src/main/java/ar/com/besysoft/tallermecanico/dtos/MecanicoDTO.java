package ar.com.besysoft.tallermecanico.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class MecanicoDTO extends PersonaDTO {
    private Character activo;
    private String apellido;
    private String especialidad;
    private String nombres;

    public MecanicoDTO(BigInteger id, @Length(max = 15) String celular, String calle, String codigoPostal,
                       String departamento, String localidad, String numero, String piso, Character activo,
                       String apellido, String especialidad, String nombres) {
        super(id, celular, calle, codigoPostal, departamento, localidad, numero, piso);
        this.activo = activo;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.nombres = nombres;
    }
}
