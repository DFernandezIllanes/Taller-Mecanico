package ar.com.besysoft.tallermecanico.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @OneToMany(mappedBy = "mecanico")
    private List<ManoObra> manoObraList = new ArrayList<>();

    public Optional<ManoObra> getLastManoObra() {
        if(manoObraList.isEmpty()) {
            return Optional.empty();
        }
        ManoObra manoObra = this.manoObraList.get(this.manoObraList.size() - 1);
        return Optional.of(manoObra);
    }
}
