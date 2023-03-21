package ar.com.besysoft.tallermecanico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mano_obra")
public class ManoObra {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name = "detalle")
    private String detalle;
    @Column(name = "duracion_hs")
    private Time duracionEnHs;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "mecanico_id", referencedColumnName = "id")
    private Mecanico mecanico;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "orden_trabajo_id", referencedColumnName = "id")
    private OrdenTrabajo ordenTrabajo;
}
