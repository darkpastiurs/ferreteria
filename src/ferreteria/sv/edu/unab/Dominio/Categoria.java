package ferreteria.sv.edu.unab.Dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(schema = "var",name = "categorias")
@SequenceGenerator(schema = "var",sequenceName = "categorias_id_seq",name = "Categorias_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Categoria.findAll",query = "SELECT c FROM Categoria c order by c.id")
})
public class Categoria implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Categorias_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "nombre")
    private String nombre;

    public Categoria() {
    }
    public Categoria(@NotNull String nombre) {
        this.nombre=nombre;
    }
    public Categoria(@NotNull Long id, @NotNull String nombre) {
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
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
