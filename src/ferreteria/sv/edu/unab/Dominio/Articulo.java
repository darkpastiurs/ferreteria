package ferreteria.sv.edu.unab.Dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(schema = "var",name = "articulos")
@SequenceGenerator(schema = "var",sequenceName = "articulos_id_seq",name = "Articulos_seq_id",allocationSize = 1)
@NamedQueries({
        @NamedQuery(name = "Articulo.findAll",query = "SELECT a FROM Articulo a order by a.id")
})
public class Articulo implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Articulos_seq_id")
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "codigo")
    private String codigo;
    @NotNull
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;

    //referencia a marca
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Marca.class)
    @JoinColumn(name = "idmarca")
    private Marca datosMarca;

    //referencia a categoria
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Categoria.class)
    @JoinColumn(name = "idcategoria")
    private Categoria datosCategoria;

    //referencia a unidades
    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Unidad.class)
    @JoinColumn(name = "idunidad")
    private Unidad datosUnidad;

    public Articulo() {
    }

    public Articulo(@NotNull String codigo, @NotNull String nombre, String descripcion, Marca datosMarca, Categoria datosCategoria, Unidad datosUnidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.datosMarca = datosMarca;
        this.datosCategoria = datosCategoria;
        this.datosUnidad = datosUnidad;
    }
    public Articulo(@NotNull Long id, @NotNull String codigo, @NotNull String nombre, String descripcion, Marca datosMarca, Categoria datosCategoria, Unidad datosUnidad) {
        this.id=id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.datosMarca = datosMarca;
        this.datosCategoria = datosCategoria;
        this.datosUnidad = datosUnidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Marca getDatosMarca() {
        return datosMarca;
    }

    public void setDatosMarca(Marca datosMarca) {
        this.datosMarca = datosMarca;
    }

    public Categoria getDatosCategoria() {
        return datosCategoria;
    }

    public void setDatosCategoria(Categoria datosCategoria) {
        this.datosCategoria = datosCategoria;
    }

    public Unidad getDatosUnidad() {
        return datosUnidad;
    }

    public void setDatosUnidad(Unidad datosUnidad) {
        this.datosUnidad = datosUnidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(id, articulo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", datosMarca=" + datosMarca +
                ", datosCategoria=" + datosCategoria +
                ", datosUnidad=" + datosUnidad +
                '}';
    }
}