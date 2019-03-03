package ferreteria.sv.edu.unab.Dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "var",name = "departamentos")
@SequenceGenerator(schema = "var",sequenceName = "departamentos_id_seq",name = "Departamentos_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Departamento.findAll",query = "SELECT d FROM Departamento d order by d.id")
})
public class Departamento implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Municipios_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "nombre")
    private String nombre;

    public Departamento() {
    }

    public Departamento( String nombre) {
        this.nombre = nombre;
    }
    public Departamento( Long id,String nombre) {
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
}
