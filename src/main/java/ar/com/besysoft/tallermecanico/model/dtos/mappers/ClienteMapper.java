package ar.com.besysoft.tallermecanico.model.dtos.mappers;

import ar.com.besysoft.tallermecanico.model.dtos.ClienteDTO;
import ar.com.besysoft.tallermecanico.model.dtos.ClienteDetailsDTO;
import ar.com.besysoft.tallermecanico.model.entities.Cliente;
import ar.com.besysoft.tallermecanico.model.entities.Vehiculo;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteMapper {

    public static ClienteDTO mapToDto(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getId());
        dto.setApellido(entity.getApellido());
        dto.setCalle(entity.getCalle());
        dto.setCelular(entity.getCelular());
        dto.setPiso(entity.getPiso());
        dto.setDepartamento(entity.getDepartamento());
        dto.setNombres(entity.getNombres());
        dto.setCodigoPostal(entity.getCodigoPostal());
        dto.setNumero(entity.getNumero());
        dto.setCorreoElectronico(entity.getCorreoElectronico());
        dto.setLocalidad(entity.getLocalidad());
        dto.setTelefonoLinea(entity.getTelefonoLinea());
        return dto;
    }

    public static Cliente mapToEntity(ClienteDTO dto) {
        Cliente entity = new Cliente();
        entity.setId(dto.getId());
        entity.setNombres(dto.getNombres());
        entity.setApellido(dto.getApellido());
        entity.setCalle(dto.getCalle());
        entity.setTelefonoLinea(dto.getTelefonoLinea());
        entity.setCelular(dto.getCelular());
        entity.setCorreoElectronico(dto.getCorreoElectronico());
        entity.setPiso(dto.getPiso());
        entity.setDepartamento(dto.getDepartamento());
        entity.setLocalidad(dto.getLocalidad());
        entity.setCodigoPostal(dto.getCodigoPostal());
        entity.setNumero(dto.getNumero());
        return entity;
    }

    public static List<ClienteDTO> mapListToDto(List<Cliente> entities) {
        return entities
                .stream()
                .map(ClienteMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public static ClienteDetailsDTO mapToDetailsDto(Cliente entity) {
        ClienteDetailsDTO dto = new ClienteDetailsDTO();
        dto.setId(entity.getId());
        dto.setApellido(entity.getApellido());
        dto.setCalle(entity.getCalle());
        dto.setCelular(entity.getCelular());
        dto.setPiso(entity.getPiso());
        dto.setDepartamento(entity.getDepartamento());
        dto.setNombres(entity.getNombres());
        dto.setCodigoPostal(entity.getCodigoPostal());
        dto.setNumero(entity.getNumero());
        dto.setCorreoElectronico(entity.getCorreoElectronico());
        dto.setLocalidad(entity.getLocalidad());
        dto.setTelefonoLinea(entity.getTelefonoLinea());
        dto.setVehiculos(entity
                .getListaVehiculos()
                .stream()
                .map(Vehiculo::getPatente)
                .collect(Collectors.toList())
        );
        return dto;
    }
}
