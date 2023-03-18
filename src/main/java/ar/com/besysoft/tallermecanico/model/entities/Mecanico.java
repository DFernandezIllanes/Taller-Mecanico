package ar.com.besysoft.tallermecanico.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mecanicos")
public class Mecanico extends Persona {
    @Column(name = "activo")
    private Character activo;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "especialidad")
    private String especialidad;
    @Column(name = "nombres")
    private String nombres;
}
