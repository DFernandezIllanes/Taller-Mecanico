package ar.com.besysoft.tallermecanico.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RecepcionRequestDTO {

    @Valid
    private ClienteDTO clienteDTO;
    @Valid
    private VehiculoDTO vehiculoDTO;
}
