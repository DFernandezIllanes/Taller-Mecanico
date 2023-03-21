package ar.com.besysoft.tallermecanico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class Persona {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected BigInteger id;
    @Column(name = "celular", columnDefinition = "VARCHAR(15)")
    protected String celular;
    @Column(name = "calle")
    protected String calle;
    @Column(name = "codigo_postal")
    protected String codigoPostal;
    @Column(name = "departamento")
    protected String departamento;
    @Column(name = "localidad")
    protected String localidad;
    @Column(name = "numero")
    protected String numero;
    @Column(name = "piso")
    protected String piso;
}
