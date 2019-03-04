package ferreteria.sv.edu.unab.Dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "sis",name = "tipo_usuarios")
@SequenceGenerator(schema = "sis",sequenceName = "tipo_usuarios_id_seq",name = "Tipo_Usuario_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "TipoUsuario.findAll",query = "SELECT tu FROM TipoUsuario tu order by tu.id")
})
public class TipoUsuario implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Tipo_Usuario_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "tipo")
    private String tipoUsuarios;

    public TipoUsuario() {
    }

    public TipoUsuario(String tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

    public TipoUsuario(Long id, String tipoUsuarios) {
        this.id = id;
        this.tipoUsuarios = tipoUsuarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoUsuarios() {
        return tipoUsuarios;
    }

    public void setTipoUsuarios(String tipoUsuarios) {
        this.tipoUsuarios = tipoUsuarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        final TipoUsuario other = (TipoUsuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "id=" + id + ", tipoUsuarios=" + tipoUsuarios + '}';
    }
    
    
    
}