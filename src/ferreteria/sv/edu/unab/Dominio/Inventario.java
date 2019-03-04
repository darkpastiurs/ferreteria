/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author antony
 */
@Entity
@Table(schema = "var",name = "inventario")
@NamedQueries({
        @NamedQuery(name = "Cliente.findAll",query = "SELECT c FROM Cliente c order by c.id")
})
public class Inventario implements Serializable {
    private static final long  serialVersionUID=1L;
    @Id
    private Long id;
    @NotNull
    @Column(name = "existencia")
    private Double existencia;
    @NotNull
    @Column(name="total")
    private Double precio;
    
    //relacion con la tabla de articulos de uno a uno
    @OneToOne(cascade = CascadeType.ALL,targetEntity = Articulo.class,optional = false)
    @MapsId
    @JoinColumn(name = "idarticulo",referencedColumnName = "id",unique = true)
    private Articulo datosArticulo;

    public Inventario() {
    }

    public Inventario(Double existencia, Double precio, Articulo datosArticulo) {
        this.existencia = existencia;
        this.precio = precio;
        this.datosArticulo = datosArticulo;
    }

    public Inventario(Long id, Double existencia, Double precio, Articulo datosArticulo) {
        this.id = id;
        this.existencia = existencia;
        this.precio = precio;
        this.datosArticulo = datosArticulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getExistencia() {
        return existencia;
    }

    public void setExistencia(Double existencia) {
        this.existencia = existencia;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Articulo getDatosArticulo() {
        return datosArticulo;
    }

    public void setDatosArticulo(Articulo datosArticulo) {
        this.datosArticulo = datosArticulo;
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
        final Inventario other = (Inventario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id=" + id + ", existencia=" + existencia + ", precio=" + precio + ", datosArticulo=" + datosArticulo + '}';
    }
    
    
}
