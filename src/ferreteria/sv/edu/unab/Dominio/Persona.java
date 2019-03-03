package ferreteria.sv.edu.unab.Dominio;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "flr", name = "personas")
@SequenceGenerator(schema = "flr",sequenceName = "personas_id_seq",name = "Persona_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Persona.findAll",query = "SELECT p FROM Persona  p"),
        @NamedQuery(name = "Persona.findByNombre",query = "SELECT p FROM Persona p where p.nombre =:nombre")
})
public class Persona implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Persona_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @NotNull
    @Size(min = 5,max = 50)
    @Column(name = "apellidopaterno")
    private String apellidopaterno;
    @Column(name = "apellidomaterno")
    private String apellidomaterno;
    @NotNull
    @Column(name = "dui")
    private String dui;
    @NotNull
    @Column(name = "nit")
    private String nit;
    @NotNull
    @Column(name = "fechanacimiento")
    private LocalDate fechaNacimiento;
    @NotNull
    @Size(min = 8)
    @Column(name = "telefono")
    private String telefono;
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "genero")
    private Character genero;
    @Lob
    @NotNull
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "email")
    @Pattern(regexp = "^[A-Za-z0-9_.-]+@(.+)$")
    private String email;

    @OneToOne(mappedBy = "datosPersonales",fetch = FetchType.LAZY,targetEntity = Empleado.class)
    private Empleado empleado;

    @OneToOne(mappedBy = "datosPersonales",fetch = FetchType.LAZY,targetEntity = Cliente.class)
    private Cliente cliente;

    public Persona() {
    }

    public Persona(Long id) {
        this.id = id;
    }

    public Persona(Long id, String nombre, String apellidopaterno, String apellidomaterno, String dui, String nit, LocalDate fechaNacimiento, String telefono, Character genero, String direccion, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidopaterno = apellidopaterno;
        this.apellidomaterno = apellidomaterno;
        this.dui = dui;
        this.nit = nit;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.genero=genero;
        this.direccion = direccion;
        this.email = email;
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

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidopaterno='" + apellidopaterno + '\'' +
                ", apellidomaterno='" + apellidomaterno + '\'' +
                ", dui='" + dui + '\'' +
                ", nit='" + nit + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", telefono='" + telefono + '\'' +
                ", genero=" + genero +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
