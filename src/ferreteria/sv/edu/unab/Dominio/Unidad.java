package ferreteria.sv.edu.unab.Dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(schema = "var",name = "unidades")
@SequenceGenerator(schema = "var",sequenceName = "unidades_id_seq",name = "Unidades_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Unidad.findAll",query = "SELECT u FROM Unidad u order by u.id")
})
public class Unidad implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Unidades_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "nombre")
    private String nombre;

    public Unidad() {
    }
    public Unidad(@NotNull String nombre) {
        this.nombre=nombre;
    }
    public Unidad(@NotNull Long id, @NotNull String nombre) {
        this.id = id;
        this.nombre=nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unidad unidad = (Unidad) o;
        return Objects.equals(id, unidad.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
