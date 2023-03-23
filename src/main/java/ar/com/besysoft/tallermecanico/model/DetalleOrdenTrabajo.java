package ar.com.besysoft.tallermecanico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "detalle_ordenes_trabajo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetalleOrdenTrabajo {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orden_trabajo_id", referencedColumnName = "id")
    private OrdenTrabajo ordenTrabajo;
    @ManyToOne
    @JoinColumn(name = "repuesto_id", referencedColumnName = "id")
    private Repuesto repuesto;

    public void calcularValorTotal() {
        this.valorTotal = this.repuesto.getValor().multiply(BigDecimal.valueOf(cantidad.longValue()));
    }

}
