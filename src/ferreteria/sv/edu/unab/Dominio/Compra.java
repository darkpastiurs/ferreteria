/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Dominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
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
@Table(schema = "op",name = "compras")
@SequenceGenerator(schema = "op",sequenceName = "compras_id_seq",name = "Compras_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Compra.findAll",query = "SELECT c FROM Compra c order by c.id")
})
public class Compra implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Compras_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "fechaCompra")
    private LocalDate fechaCompra;
    @NotNull
    @Column(name = "factura")
    private Integer factura;
    @NotNull
    @Column(name="total")
    private Double total;
    
    //referencia a proveedor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproveedor")
    private Proveedor datosProveedor;

    //referencia a Empleado
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idempleado")
    private Empleado datosEmpleado;

    public Compra() {
    }

    public Compra(LocalDate fechaCompra, Integer factura, Double total, Proveedor datosProveedor, Empleado datosEmpleado) {
        this.fechaCompra = fechaCompra;
        this.factura = factura;
        this.total = total;
        this.datosProveedor = datosProveedor;
        this.datosEmpleado = datosEmpleado;
    }

    public Compra(Long id, LocalDate fechaCompra, Integer factura, Double total, Proveedor datosProveedor, Empleado datosEmpleado) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.factura = factura;
        this.total = total;
        this.datosProveedor = datosProveedor;
        this.datosEmpleado = datosEmpleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Integer getFactura() {
        return factura;
    }

    public void setFactura(Integer factura) {
        this.factura = factura;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Proveedor getDatosProveedor() {
        return datosProveedor;
    }

    public void setDatosProveedor(Proveedor datosProveedor) {
        this.datosProveedor = datosProveedor;
    }

    public Empleado getDatosEmpleado() {
        return datosEmpleado;
    }

    public void setDatosEmpleado(Empleado datosEmpleado) {
        this.datosEmpleado = datosEmpleado;
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
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", fechaCompra=" + fechaCompra + ", factura=" + factura + ", total=" + total + ", datosProveedor=" + datosProveedor + ", datosEmpleado=" + datosEmpleado + '}';
    }
    
    
    
}
