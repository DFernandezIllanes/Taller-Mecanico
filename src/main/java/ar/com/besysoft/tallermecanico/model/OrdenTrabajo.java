package ar.com.besysoft.tallermecanico.model;

import ar.com.besysoft.tallermecanico.exception.alreadyAdded.ManoObraAlreadyAddedException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordenes_trabajo")
public class OrdenTrabajo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name = "cantidad_cuotas")
    private Integer cantidadCuotas;
    @Column(name = "detalle_falla")
    private String detalleFalla;
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_ingreso")
    private Timestamp fechaIngreso;
    @Column(name = "fecha_fin_reparacion")
    private Timestamp fechaFinReparacion;
    @Column(name = "fecha_pago")
    private Timestamp fechaPago;
    @Column(name = "forma_pago")
    private String formaPago;
    @Column(name = "importe_total", precision = 2)
    private BigDecimal importeTotal;
    @Column(name = "kilometraje")
    private BigInteger kilometraje;
    @Column(name = "nivel_combustible")
    private String nivelCombustible;
    @Column(name = "tipo_tarjeta")
    private String tipoTarjeta;
    @OneToOne
    @JoinColumn(name = "administrativo_id", referencedColumnName = "id")
    private Empleado administrativo;
    @OneToOne
    @JoinColumn(name = "recepcionista_id", referencedColumnName = "id")
    private Empleado recepcionista;
    @OneToOne
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    private Vehiculo vehiculo;
    @OneToMany(mappedBy = "ordenTrabajo")
    private List<ManoObra> manoObraList = new ArrayList<>();
    @OneToMany(mappedBy = "ordenTrabajo")
    private List<DetalleOrdenTrabajo> detallesList = new ArrayList<>();

    public void addManoObra(ManoObra manoObra) {
        if(this.manoObraList.stream().anyMatch(m -> m.getId().equals(manoObra.getId()))) {
            throw new ManoObraAlreadyAddedException(String.format("Ya esta agregada la mano de obra con ID %d", manoObra.getId()),
                    new RuntimeException("Causa Original")
            );
        }
        this.manoObraList.add(manoObra);
    }
}
