package ar.com.besysoft.tallermecanico.dtos.mappers;

import ar.com.besysoft.tallermecanico.dtos.MecanicoDTO;
import ar.com.besysoft.tallermecanico.model.Mecanico;

import java.util.List;
import java.util.stream.Collectors;

public class MecanicoMapper {

    public static Mecanico mapToEntity(MecanicoDTO dto) {
        Mecanico entity = new Mecanico();
        entity.setId(dto.getId());
        entity.setCelular(dto.getCelular());
        entity.setCalle(dto.getCalle());
        entity.setCodigoPostal(dto.getCodigoPostal());
        entity.setDepartamento(dto.getDepartamento());
        entity.setLocalidad(dto.getLocalidad());
        entity.setNumero(dto.getNumero());
        entity.setPiso(dto.getPiso());
        entity.setActivo(dto.getActivo());
        entity.setApellido(dto.getApellido());
        entity.setEspecialidad(dto.getEspecialidad());
        entity.setNombres(dto.getNombres());
        return entity;
    }

    public static MecanicoDTO mapToDto(Mecanico entity) {
        MecanicoDTO dto = new MecanicoDTO();
        dto.setId(entity.getId());
        dto.setCelular(entity.getCelular());
        dto.setCalle(entity.getCalle());
        dto.setCodigoPostal(entity.getCodigoPostal());
        dto.setDepartamento(entity.getDepartamento());
        dto.setLocalidad(entity.getLocalidad());
        dto.setNumero(entity.getNumero());
        dto.setPiso(entity.getPiso());
        dto.setActivo(entity.getActivo());
        dto.setApellido(entity.getApellido());
        dto.setEspecialidad(entity.getEspecialidad());
        dto.setNombres(entity.getNombres());
        return dto;
    }

    public static List<MecanicoDTO> mapListToDto(List<Mecanico> entities) {
        return entities.stream()
                .map(MecanicoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
