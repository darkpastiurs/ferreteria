package ferreteria.sv.edu.unab.Dominio;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(schema = "var",name = "marcas")
@SequenceGenerator(schema = "var",sequenceName = "marcas_id_seq",name = "Marcas_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Marca.findAll",query = "SELECT m FROM Marca m order by m.id")
})
public class Marca {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Marcas_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "nombre")
    private String nombre;

    public Marca() {
    }
    public Marca(@NotNull String nombre) {
        this.nombre=nombre;
    }
    public Marca(@NotNull Long id, @NotNull String nombre) {
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
        Marca marca = (Marca) o;
        return Objects.equals(id, marca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Marcas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}