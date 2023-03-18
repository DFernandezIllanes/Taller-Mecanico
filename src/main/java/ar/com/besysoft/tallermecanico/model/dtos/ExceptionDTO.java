package ar.com.besysoft.tallermecanico.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ExceptionDTO {

    private int estado;
    private String mensaje;
    private Map<String, String> detalle;
}
