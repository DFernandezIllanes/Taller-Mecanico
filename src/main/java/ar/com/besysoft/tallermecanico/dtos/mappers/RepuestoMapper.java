package ar.com.besysoft.tallermecanico.dtos.mappers;

import ar.com.besysoft.tallermecanico.dtos.RepuestoDTO;
import ar.com.besysoft.tallermecanico.model.Repuesto;

import java.util.List;
import java.util.stream.Collectors;

public class RepuestoMapper {

    public static Repuesto mapToEntity(RepuestoDTO dto) {
        Repuesto entity = new Repuesto();
        entity.setId(dto.getId());
        entity.setMarca(dto.getMarca());
        entity.setModelo(dto.getModelo());
        entity.setRepuesto(dto.getRepuesto());
        entity.setValor(dto.getValor());
        return entity;
    }

    public static RepuestoDTO mapToDto(Repuesto entity) {
        RepuestoDTO dto = new RepuestoDTO();
        dto.setId(entity.getId());
        dto.setMarca(entity.getMarca());
        dto.setModelo(entity.getModelo());
        dto.setRepuesto(entity.getRepuesto());
        dto.setValor(entity.getValor());
        return dto;
    }

    public static List<RepuestoDTO> mapListToDto(List<Repuesto> entities) {
        return entities.stream()
                .map(RepuestoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
