package ar.com.besysoft.tallermecanico.dtos;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
public class EmpleadoDTO extends PersonaDTO {
    @NotEmpty
    @NotNull
    private String apellido;
    @NotEmpty
    @NotNull
    private String nombres;
    @NotEmpty
    @NotNull
    private String tipoEmpleado;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(BigInteger id, @Length(max = 15) String celular, String calle, String codigoPostal,
                       String departamento, String localidad, String numero, String piso, String apellido,
                       String nombres, String tipoEmpleado) {
        super(id, celular, calle, codigoPostal, departamento, localidad, numero, piso);
        this.apellido = apellido;
        this.nombres = nombres;
        this.tipoEmpleado = tipoEmpleado;
    }
}
