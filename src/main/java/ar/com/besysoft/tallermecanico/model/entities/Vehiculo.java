package ar.com.besysoft.tallermecanico.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    @Column(name = "anio")
    private Integer anio;
    @Column(name = "color")
    private String color;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "patente", unique = true)
    private String patente;
    @ManyToMany(mappedBy = "listaVehiculos", fetch = FetchType.LAZY)
    List<Cliente> clientes = new ArrayList<>();
}
