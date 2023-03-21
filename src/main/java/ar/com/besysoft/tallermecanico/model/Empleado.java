package ar.com.besysoft.tallermecanico.model;

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
@Table(name = "empleados")
public class Empleado extends Persona {
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "tipo_empleado")
    private String tipoEmpleado;
}
