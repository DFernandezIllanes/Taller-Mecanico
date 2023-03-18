package ar.com.besysoft.tallermecanico.model.entities;

import ar.com.besysoft.tallermecanico.exception.alreadyAdded.VehiculoAlreadyAddedException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente extends Persona {
    @Column(name = "apellido", columnDefinition = "VARCHAR(80)", nullable = false)
    private String apellido;
    @Column(name = "correo_electronico", unique = true)
    private String correoElectronico;
    @Column(name = "nombres", columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombres;
    @Column(name = "telefono_linea", columnDefinition = "VARCHAR(15)")
    private String telefonoLinea;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "cliente_vehiculo",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "vehiculo_id")
    )
    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    public void addVehiculo(Vehiculo vehiculo) {
        if(this.listaVehiculos.stream().anyMatch(v -> v.getPatente().equals(vehiculo.getPatente()))) {
            throw new VehiculoAlreadyAddedException(
                    String.format("El cliente ya tiene vinculado un vehiculo con patente %s", vehiculo.getPatente()),
                    new RuntimeException("Causa Original")
            );
        }
        this.listaVehiculos.add(vehiculo);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "apellido='" + apellido + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", nombres='" + nombres + '\'' +
                ", telefonoLinea='" + telefonoLinea + '\'' +
                ", id=" + id +
                ", celular='" + celular + '\'' +
                ", calle='" + calle + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", departamento='" + departamento + '\'' +
                ", localidad='" + localidad + '\'' +
                ", numero='" + numero + '\'' +
                ", piso='" + piso + '\'' +
                '}';
    }
}

