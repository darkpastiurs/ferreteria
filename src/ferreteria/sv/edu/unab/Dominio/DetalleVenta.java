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
@Table(schema = "op",name = "detalleventa")
@SequenceGenerator(schema = "op",sequenceName = "detalleventa_id_seq",name = "DetalleVenta_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "DetalleVenta.findAll",query = "SELECT dv FROM DetalleVenta dv order by dv.id")
})
public class DetalleVenta implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DetalleVenta_seq_id")
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
    
    //referencia a tabla ventas
    @ManyToOne(targetEntity = Venta.class)
    @JoinColumn(name = "idventa")
    private Venta datosVenta;
    
    //referencia a tabla Inventario
    @ManyToOne(targetEntity = Inventario.class)
    @JoinColumn(name = "idcompra")
    private Inventario datosInventario;

    public DetalleVenta() {
    }

    public DetalleVenta(Double precio, Double cantidad, Double total, Venta datosVenta, Inventario datosInventario) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.datosVenta = datosVenta;
        this.datosInventario = datosInventario;
    }

    public DetalleVenta(Long id, Double precio, Double cantidad, Double total, Venta datosVenta, Inventario datosInventario) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
        this.datosVenta = datosVenta;
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

    public Venta getDatosVenta() {
        return datosVenta;
    }

    public void setDatosVenta(Venta datosVenta) {
        this.datosVenta = datosVenta;
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
        final DetalleVenta other = (DetalleVenta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "id=" + id + ", precio=" + precio + ", cantidad=" + cantidad + ", total=" + total + ", datosVenta=" + datosVenta + ", datosInventario=" + datosInventario + '}';
    }
    
    
}
