package ar.com.besysoft.tallermecanico.dtos.mappers;

import ar.com.besysoft.tallermecanico.dtos.DetalleOrdenInfoDTO;
import ar.com.besysoft.tallermecanico.dtos.ManoObraInfoDTO;
import ar.com.besysoft.tallermecanico.dtos.OrdenTrabajoDTO;
import ar.com.besysoft.tallermecanico.dtos.OrdenTrabajoDetailsDTO;
import ar.com.besysoft.tallermecanico.dtos.requests.OrdenTrabajoRequestDTO;
import ar.com.besysoft.tallermecanico.model.Empleado;
import ar.com.besysoft.tallermecanico.model.ManoObra;
import ar.com.besysoft.tallermecanico.model.OrdenTrabajo;
import ar.com.besysoft.tallermecanico.model.Vehiculo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenTrabajoMapper {

    public static OrdenTrabajo mapRequestDtoToEntity(OrdenTrabajoRequestDTO requestDTO) {
        OrdenTrabajo entity = new OrdenTrabajo();
        entity.setNivelCombustible(requestDTO.getNivelCombustible());
        entity.setKilometraje(requestDTO.getKilometraje());
        entity.setDetalleFalla(requestDTO.getDetalleFalla());
        entity.setEstado("creado");
        entity.setFechaIngreso(Timestamp.valueOf(LocalDateTime.now()));
        Empleado recepcionista = new Empleado();
        recepcionista.setId(requestDTO.getRecepcionistaId());
        entity.setRecepcionista(recepcionista);
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPatente(requestDTO.getPatente());
        entity.setVehiculo(vehiculo);
        return entity;
    }

    public static OrdenTrabajoDTO mapToDto(OrdenTrabajo entity) {
        OrdenTrabajoDTO dto = new OrdenTrabajoDTO();
        dto.setId(entity.getId());
        dto.setCantidadCuotas(entity.getCantidadCuotas());
        dto.setDetalleFalla(entity.getDetalleFalla());
        dto.setEstado(entity.getEstado());
        dto.setFechaIngreso(entity.getFechaIngreso());
        dto.setFechaFinReparacion(entity.getFechaFinReparacion());
        dto.setFechaPago(entity.getFechaPago());
        dto.setFormaPago(entity.getFormaPago());
        dto.setImporteTotal(entity.getImporteTotal());
        dto.setKilometraje(entity.getKilometraje());
        dto.setNivelCombustible(entity.getNivelCombustible());
        dto.setTipoTarjeta(entity.getTipoTarjeta());
        //dto.setAdministrativo(entity.getAdministrativo().getApellido() + " - " + entity.getAdministrativo().getNombres());
        dto.setAdministrativo("");
        dto.setRecepcionista(entity.getRecepcionista().getApellido() + " - " + entity.getRecepcionista().getNombres());
        dto.setVehiculo(entity.getVehiculo().getPatente());
        return dto;
    }

    public static List<OrdenTrabajoDTO> mapListToDto(List<OrdenTrabajo> entities) {
        return entities.stream()
                .map(OrdenTrabajoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public static OrdenTrabajoDetailsDTO mapToDetailsDto(OrdenTrabajo entity) {
        OrdenTrabajoDetailsDTO dto = new OrdenTrabajoDetailsDTO();
        dto.setId(entity.getId());
        dto.setCantidadCuotas(entity.getCantidadCuotas());
        dto.setDetalleFalla(entity.getDetalleFalla());
        dto.setEstado(entity.getEstado());
        dto.setFechaIngreso(entity.getFechaIngreso());
        dto.setFechaFinReparacion(entity.getFechaFinReparacion());
        dto.setFechaPago(entity.getFechaPago());
        dto.setFormaPago(entity.getFormaPago());
        dto.setImporteTotal(entity.getImporteTotal());
        dto.setKilometraje(entity.getKilometraje());
        dto.setNivelCombustible(entity.getNivelCombustible());
        dto.setTipoTarjeta(entity.getTipoTarjeta());
        dto.setAdministrativo("");
        dto.setRecepcionista(entity.getRecepcionista().getApellido() + " - " + entity.getRecepcionista().getNombres());
        dto.setVehiculo(entity.getVehiculo().getPatente());
        List<ManoObraInfoDTO> manoObraInfoDTOList = ManoObraMapper.mapListToInfoDto(entity.getManoObraList());
        dto.setManoObraInfoDTOList(manoObraInfoDTOList);
        if(!entity.getDetallesList().isEmpty()) {
            List<DetalleOrdenInfoDTO> detalleOrdenInfoDTOList = DetalleOrdenTrabajoMapper.mapListToInfoDto(entity.getDetallesList());
            dto.setDetalleOrdenInfoDTOList(detalleOrdenInfoDTOList);
        }
        return dto;
    }
}
