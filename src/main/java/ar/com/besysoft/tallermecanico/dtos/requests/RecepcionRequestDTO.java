package ar.com.besysoft.tallermecanico.dtos.requests;

import ar.com.besysoft.tallermecanico.dtos.ClienteDTO;
import ar.com.besysoft.tallermecanico.dtos.VehiculoDTO;
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
