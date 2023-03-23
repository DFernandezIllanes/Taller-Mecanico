package ar.com.besysoft.tallermecanico.dtos.mappers;

import ar.com.besysoft.tallermecanico.dtos.DetalleOrdenInfoDTO;
import ar.com.besysoft.tallermecanico.dtos.requests.DetalleOrdenTrabajoRequestDTO;
import ar.com.besysoft.tallermecanico.model.DetalleOrdenTrabajo;
import ar.com.besysoft.tallermecanico.model.Repuesto;

import java.util.List;
import java.util.stream.Collectors;

public class DetalleOrdenTrabajoMapper {

    public static DetalleOrdenTrabajo mapRequestToEntity(DetalleOrdenTrabajoRequestDTO requestDTO) {
        DetalleOrdenTrabajo entity = new DetalleOrdenTrabajo();
        entity.setCantidad(requestDTO.getCantidad());
        Repuesto repuesto = new Repuesto();
        repuesto.setMarca(requestDTO.getMarca());
        repuesto.setModelo(requestDTO.getModelo());
        repuesto.setRepuesto(requestDTO.getRepuesto());
        entity.setRepuesto(repuesto);
        return entity;
    }

    public static List<DetalleOrdenTrabajo> mapListRequestToEntity(List<DetalleOrdenTrabajoRequestDTO> listRequestDTO) {
        return listRequestDTO.stream()
                .map(DetalleOrdenTrabajoMapper::mapRequestToEntity)
                .collect(Collectors.toList());
    }

    public static DetalleOrdenInfoDTO mapToInfoDto(DetalleOrdenTrabajo entity) {
        DetalleOrdenInfoDTO infoDTO = new DetalleOrdenInfoDTO();
        infoDTO.setCantidad(entity.getCantidad());
        infoDTO.setValorTotal(entity.getValorTotal());
        infoDTO.setMarca(entity.getRepuesto().getMarca());
        infoDTO.setModelo(entity.getRepuesto().getModelo());
        infoDTO.setRepuesto(entity.getRepuesto().getRepuesto());
        return infoDTO;
    }

    public static List<DetalleOrdenInfoDTO> mapListToInfoDto(List<DetalleOrdenTrabajo> entities) {
        return entities.stream()
                .map(DetalleOrdenTrabajoMapper::mapToInfoDto)
                .collect(Collectors.toList());
    }
}
