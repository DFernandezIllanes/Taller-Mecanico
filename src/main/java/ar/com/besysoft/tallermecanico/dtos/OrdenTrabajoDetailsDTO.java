package ar.com.besysoft.tallermecanico.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrdenTrabajoDetailsDTO extends OrdenTrabajoDTO {

    private List<ManoObraInfoDTO> manoObraInfoDTOList = new ArrayList<>();

    public OrdenTrabajoDetailsDTO(BigInteger id, Integer cantidadCuotas, String detalleFalla, String estado,
                                  Timestamp fechaIngreso, Timestamp fechaFinReparacion, Timestamp fechaPago,
                                  String formaPago, @DecimalMax("2") BigDecimal importeTotal, BigInteger kilometraje,
                                  String nivelCombustible, String tipoTarjeta, String administrativo, String recepcionista,
                                  String vehiculo, List<ManoObraInfoDTO> manoObraInfoDTOList) {
        super(id, cantidadCuotas, detalleFalla, estado, fechaIngreso, fechaFinReparacion, fechaPago, formaPago, importeTotal, kilometraje, nivelCombustible, tipoTarjeta, administrativo, recepcionista, vehiculo);
        this.manoObraInfoDTOList = manoObraInfoDTOList;
    }
}
