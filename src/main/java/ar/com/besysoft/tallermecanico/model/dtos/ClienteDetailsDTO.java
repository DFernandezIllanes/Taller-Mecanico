package ar.com.besysoft.tallermecanico.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDetailsDTO {

    private BigInteger id;
    private String celular;
    private String calle;
    private String codigoPostal;
    private String departamento;
    private String localidad;
    private String numero;
    private String piso;
    private String apellido;
    private String correoElectronico;
    private String nombres;
    private String telefonoLinea;
    private List<String> vehiculos;
}
