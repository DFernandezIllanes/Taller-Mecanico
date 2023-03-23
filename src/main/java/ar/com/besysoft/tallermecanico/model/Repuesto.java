package ar.com.besysoft.tallermecanico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repuestos")
public class Repuesto {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "repuesto")
    private String repuesto;
    @Column(name = "valor")
    private BigDecimal valor;
}
