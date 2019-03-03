package ferreteria.sv.edu.unab.Dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(schema = "flr",name = "proveedores")
@SequenceGenerator(schema = "flr",sequenceName = "proveedores_id_seq",name = "Proveedor_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Proveedor.findAll",query = "SELECT p FROM Proveedor p order by p.id")
})
public class Proveedor implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    private Long id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Persona.class,optional = false)
    @MapsId
    @JoinColumn(name = "idpersona",referencedColumnName = "id",unique = true)
    private Persona datosPersonales;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(Persona datosPersonales) {
        this.datosPersonales = datosPersonales;
    }


    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proveedor other = (Proveedor) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", datosPersonales=" + datosPersonales +
                '}';
    }
}