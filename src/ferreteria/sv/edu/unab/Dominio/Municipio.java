package ferreteria.sv.edu.unab.Dominio;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(schema = "var",name = "municipios")
@SequenceGenerator(schema = "var",sequenceName = "municipios_id_seq",name = "Municipios_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Municipio.findAll",query = "SELECT m FROM Municipio m order by m.id")
})
public class Municipio {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Municipios_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "nombre")
    private String nombre;

    @ManyToOne(targetEntity = Departamento.class)
    @JoinColumn(name = "iddepartamento")
    private Departamento datosDepartamento;

    public Municipio() {
    }

    public Municipio( String nombre) {
        this.nombre = nombre;
    }
    public Municipio( Long id,String nombre) {
        this.id=id;
        this.nombre = nombre;
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

    public Departamento getDatosDepartamento() {
        return datosDepartamento;
    }

    public void setDatosDepartamento(Departamento datosDepartamento) {
        this.datosDepartamento = datosDepartamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipio municipio = (Municipio) o;
        return Objects.equals(id, municipio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", datosDepartamento=" + datosDepartamento +
                '}';
    }
}
