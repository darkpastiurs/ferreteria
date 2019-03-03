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
@Table(schema = "op",name = "ventas")
@SequenceGenerator(schema = "op",sequenceName = "ventas_id_seq",name = "Ventas_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Venta.findAll",query = "SELECT v FROM Venta v order by v.id")
})
public class Venta implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Compras_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    //@Convert (converter = Conversor.class)
    @Column(name = "fechaCompra")
    private LocalDate fechaVenta;
    @NotNull
    @Column(name = "factura")
    private Integer factura;
    @NotNull
    @Column(name="total")
    private Double total;
    
    //referencia a Cliente
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Cliente.class)
    @JoinColumn(name = "idcliente")
    private Cliente datosCliente;

    //referencia a Empleado
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Empleado.class)
    @JoinColumn(name = "idempleado")
    private Empleado datosEmpleado;

    public Venta() {
    }

    public Venta(LocalDate fechaVenta, Integer factura, Double total, Cliente datosCliente, Empleado datosEmpleado) {
        this.fechaVenta = fechaVenta;
        this.factura = factura;
        this.total = total;
        this.datosCliente = datosCliente;
        this.datosEmpleado = datosEmpleado;
    }

    public Venta(Long id, LocalDate fechaVenta, Integer factura, Double total, Cliente datosCliente, Empleado datosEmpleado) {
        this.id = id;
        this.fechaVenta = fechaVenta;
        this.factura = factura;
        this.total = total;
        this.datosCliente = datosCliente;
        this.datosEmpleado = datosEmpleado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaCompra() {
        return fechaVenta;
    }

    public void setFechaCompra(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
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

    public Cliente getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(Cliente datosCliente) {
        this.datosCliente = datosCliente;
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
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", fechaVenta=" + fechaVenta + ", factura=" + factura + ", total=" + total + ", datosCliente=" + datosCliente + ", datosEmpleado=" + datosEmpleado + '}';
    }

 
}
