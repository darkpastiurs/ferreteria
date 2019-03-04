/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Dominio;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author anton
 */
@Entity
@Table(schema = "op",name = "detallecompra")
@SequenceGenerator(schema = "op",sequenceName = "detallecompra_id_seq",name = "DetalleCompra_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "DetalleCompra.findAll",query = "SELECT dc FROM DetalleCompra dc order by dc.id")
})
public class DetalleCompra implements Serializable{
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DetalleCompra_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "precio")
    private Double precio;
    @NotNull
    @Column(name = "cantidad")
    private Double cantidad;
    @NotNull
    @Column(name = "total")
    private Double total;
    
    //referencia a tabla Compras
    @ManyToOne(targetEntity = Compra.class)
    @JoinColumn(name = "idcompra")
    private Compra datosCompra;
    
    //referencia a tabla Inventario
    @ManyToOne(targetEntity = Inventario.class)
    @JoinColumn(name = "idinventario")
    private Inventario datosInventario;

    public DetalleCompra() {
    }

    public DetalleCompra(Double precio, Double cantidad, Double total, Compra datosCompra, Inventario datosInventario) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.datosCompra = datosCompra;
        this.datosInventario = datosInventario;
    }

    public DetalleCompra(Long id, Double precio, Double cantidad, Double total, Compra datosCompra, Inventario datosInventario) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.datosCompra = datosCompra;
        this.datosInventario = datosInventario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Compra getDatosCompra() {
        return datosCompra;
    }

    public void setDatosCompra(Compra datosCompra) {
        this.datosCompra = datosCompra;
    }

    public Inventario getDatosInventario() {
        return datosInventario;
    }

    public void setDatosInventario(Inventario datosInventario) {
        this.datosInventario = datosInventario;
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
        final DetalleCompra other = (DetalleCompra) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" + "id=" + id + ", precio=" + precio + ", cantidad=" + cantidad + ", total=" + total + ", datosCompra=" + datosCompra + ", datosInventario=" + datosInventario + '}';
    }
    
    
    
}
