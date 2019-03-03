/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.Articulo;
import ferreteria.sv.edu.unab.Negocio.ArticuloN;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author anton
 */
public class Articuloi {
    List<Articulo> listadoModel;
    
    ArticuloN an=new ArticuloN();
    
    public Supplier<List<Articulo>> listadoarticulos=an.listadoArticulos::get;
    
    public Consumer<Articulo> guardarArticulo= a -> {
        new ArticuloN().guardarArticulo.accept(a);
    };
    public Consumer<Articulo> actualizarArticulo= a -> {
        new ArticuloN().actualizarArticulo.accept(a);
    };
    public Consumer<Articulo> eliminarArticulo= a -> {
        new ArticuloN().eliminarArticulo.accept(a);
    };
    
    public BiConsumer<JTable, List<Articulo>> cargarTabla=(tabla, listado)->{
        try {
            DefaultTableModel model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("CODIGO");
            model.addColumn("Nombre");
            model.addColumn("Descripcion");
            model.addColumn("Marca");
            model.addColumn("Categoria");
            model.addColumn("Unidad");

            listado.stream().forEach(m->{
                model.addRow(new Object[]{
                        m.getId(),
                        m.getCodigo(),
                        m.getNombre(),
                        m.getDescripcion(),
                        m.getDatosMarca().getNombre(),
                        m.getDatosCategoria().getNombre(),
                        m.getDatosUnidad().getNombre()
                });
            });
            tabla.setModel(model);
        }catch (Exception e){}

    };
    public Function<JTable,List<Articulo>> actualizarDatos= tabla->{
        try{
            listadoModel=an.listadoArticulos.get();
            cargarTabla.accept(tabla, listadoModel);
            TableColumn columna = tabla.getColumnModel().getColumn(0);
            columna.setMaxWidth(0);
            columna.setMinWidth(0);
            columna.setPreferredWidth(0);
            tabla.doLayout();
        }catch (Exception e){

        }
        return listadoModel;
    };
    public BiConsumer<JTable, List<Articulo>> mostrarCoincidencias=(tabla, listado)->{
        cargarTabla.accept(tabla,listado);
        TableColumn columna = tabla.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        tabla.doLayout();
    };
}
