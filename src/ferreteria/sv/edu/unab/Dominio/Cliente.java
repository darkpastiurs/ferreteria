package ferreteria.sv.edu.unab.Dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "flr",name = "clientes")
@SequenceGenerator(schema = "flr",sequenceName = "clientes_id_seq",name = "Cliente_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Cliente.findAll",query = "SELECT c FROM Cliente c order by c.id")
})
public class Cliente implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    private Long id;
    @OneToOne(cascade = CascadeType.ALL,targetEntity = Persona.class,optional = false)
    @MapsId
    @JoinColumn(name = "idpersona",referencedColumnName = "id",unique = true)
    private Persona datosPersonales;

    @ManyToOne(targetEntity = Municipio.class)
    @JoinColumn(name = "idmunicipio")
    private Municipio datosMunicipio;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
    }

    public Persona getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(Persona datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Municipio getDatosMunicipio() {
        return datosMunicipio;
    }

    public void setDatosMunicipio(Municipio datosMunicipio) {
        Municipio oldDatosMunicipio = this.datosMunicipio;
        this.datosMunicipio = datosMunicipio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", datosPersonales=" + datosPersonales +
                ", datosMunicipio=" + datosMunicipio +
                '}';
    }

}
