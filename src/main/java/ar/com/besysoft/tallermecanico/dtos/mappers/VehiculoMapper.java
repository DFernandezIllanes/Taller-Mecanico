package ar.com.besysoft.tallermecanico.dtos.mappers;

import ar.com.besysoft.tallermecanico.dtos.VehiculoDTO;
import ar.com.besysoft.tallermecanico.model.Vehiculo;

import java.util.List;
import java.util.stream.Collectors;

public class VehiculoMapper {

    public static VehiculoDTO mapToDto(Vehiculo entity) {
        VehiculoDTO dto = new VehiculoDTO();
        dto.setId(entity.getId());
        dto.setAnio(entity.getAnio());
        dto.setColor(entity.getColor());
        dto.setPatente(entity.getPatente());
        dto.setMarca(entity.getMarca());
        dto.setModelo(entity.getModelo());
        return dto;
    }

    public static Vehiculo mapToEntity(VehiculoDTO dto) {
        Vehiculo entity = new Vehiculo();
        entity.setId(dto.getId());
        entity.setAnio(dto.getAnio());
        entity.setModelo(dto.getModelo());
        entity.setMarca(dto.getMarca());
        entity.setColor(dto.getColor());
        entity.setPatente(dto.getPatente());
        return entity;
    }

    public static List<VehiculoDTO> mapListToDto(List<Vehiculo> entities) {
        return entities
                .stream()
                .map(VehiculoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
