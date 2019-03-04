/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Dominio;

/**
 *
 * @author anton
 */

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = "sis",name = "usuarios")
@NamedQueries({
        @NamedQuery(name = "Usuario.findAll",query = "SELECT u FROM Usuario u order by u.nombre asc")
})
public class Usuario implements Serializable {
    @Id
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    
    @NotNull
    @Column(name = "contrasena")
    private String contrasena;
    
     //referencia a tipo_usuario
    @ManyToOne(targetEntity = TipoUsuario.class)
    @JoinColumn(name = "idtipo")
    private TipoUsuario datosTipoUsuario;
    
     //referencia a Empleado(necesitamos definir la relacion bien)
    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "idempleado")
    private Empleado datosEmpleado;

    public Usuario() {
    }

    public Usuario(String nombre, String contrasena, TipoUsuario datosTipoUsuario, Empleado datosEmpleado) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.datosTipoUsuario = datosTipoUsuario;
        this.datosEmpleado = datosEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TipoUsuario getDatosTipoUsuario() {
        return datosTipoUsuario;
    }

    public void setDatosTipoUsuario(TipoUsuario datosTipoUsuario) {
        this.datosTipoUsuario = datosTipoUsuario;
    }

    public Empleado getDatosEmpleado() {
        return datosEmpleado;
    }

    public void setDatosEmpleado(Empleado datosEmpleado) {
        this.datosEmpleado = datosEmpleado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrasena=" + contrasena + ", datosTipoUsuario=" + datosTipoUsuario + ", datosEmpleado=" + datosEmpleado + '}';
    }
    
    
}
