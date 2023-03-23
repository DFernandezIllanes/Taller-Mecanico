package ar.com.besysoft.tallermecanico.dtos.mappers;

import ar.com.besysoft.tallermecanico.dtos.ManoObraDTO;
import ar.com.besysoft.tallermecanico.dtos.ManoObraInfoDTO;
import ar.com.besysoft.tallermecanico.model.ManoObra;

import java.util.List;
import java.util.stream.Collectors;

public class ManoObraMapper {

    public static ManoObraDTO mapToDto(ManoObra entity) {
        ManoObraDTO dto = new ManoObraDTO();
        dto.setId(entity.getId());
        dto.setDetalle(entity.getDetalle());
        dto.setDuracionEnHs(entity.getDuracionEnHs());
        dto.setMecanicoId(entity.getMecanico().getId());
        dto.setOrdenTrabajoId(entity.getOrdenTrabajo().getId());
        return dto;
    }

    public static List<ManoObraDTO> mapListToDto(List<ManoObra> entities) {
        return entities.stream()
                .map(ManoObraMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public static ManoObraInfoDTO mapToInfoDto(ManoObra entity) {
        ManoObraInfoDTO dto = new ManoObraInfoDTO();
        dto.setDetalle(entity.getDetalle());
        dto.setMecanicoId(entity.getMecanico().getId());
        dto.setDuracionEnHs(entity.getDuracionEnHs());
        return dto;
    }

    public static ManoObra mapInfoDtoToEntity(ManoObraInfoDTO dto) {
        ManoObra entity = new ManoObra();
        entity.setDetalle(dto.getDetalle());
        entity.setDuracionEnHs(dto.getDuracionEnHs());
        return entity;
    }

    public static List<ManoObraInfoDTO> mapListToInfoDto(List<ManoObra> entities) {
        return entities.stream()
                .map(ManoObraMapper::mapToInfoDto)
                .collect(Collectors.toList());
    }
}
