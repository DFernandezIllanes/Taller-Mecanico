package ar.com.besysoft.tallermecanico.dtos.mappers;

import ar.com.besysoft.tallermecanico.dtos.EmpleadoDTO;
import ar.com.besysoft.tallermecanico.model.Empleado;

import java.util.List;
import java.util.stream.Collectors;

public class EmpleadoMapper {

    public static EmpleadoDTO mapToDto(Empleado entity) {
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(entity.getId());
        dto.setCelular(entity.getCelular());
        dto.setApellido(entity.getApellido());
        dto.setCalle(entity.getCalle());
        dto.setNombres(entity.getNombres());
        dto.setDepartamento(entity.getDepartamento());
        dto.setNumero(entity.getNumero());
        dto.setPiso(entity.getPiso());
        dto.setTipoEmpleado(entity.getTipoEmpleado());
        dto.setCodigoPostal(entity.getCodigoPostal());
        dto.setLocalidad(entity.getLocalidad());
        return dto;
    }

    public static Empleado mapToEntity(EmpleadoDTO dto) {
        Empleado entity = new Empleado();
        entity.setId(dto.getId());
        entity.setCelular(dto.getCelular());
        entity.setApellido(dto.getApellido());
        entity.setCalle(dto.getCalle());
        entity.setNombres(dto.getNombres());
        entity.setDepartamento(dto.getDepartamento());
        entity.setNumero(dto.getNumero());
        entity.setPiso(dto.getPiso());
        entity.setTipoEmpleado(dto.getTipoEmpleado());
        entity.setCodigoPostal(dto.getCodigoPostal());
        entity.setLocalidad(dto.getLocalidad());
        return entity;
    }

    public static List<EmpleadoDTO> mapListToDto(List<Empleado> entities) {
        return entities.stream()
                .map(EmpleadoMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
