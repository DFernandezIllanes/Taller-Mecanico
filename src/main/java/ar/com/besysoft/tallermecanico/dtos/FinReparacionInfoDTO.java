package ar.com.besysoft.tallermecanico.dtos;

import ar.com.besysoft.tallermecanico.dtos.requests.DetalleOrdenTrabajoRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FinReparacionInfoDTO {
    @Valid
    private ManoObraInfoDTO manoObraInfoDTO;
    @Valid
    private List<DetalleOrdenTrabajoRequestDTO> listaDetalles = new ArrayList<>();
}
