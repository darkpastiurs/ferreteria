package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.Categoria;
import ferreteria.sv.edu.unab.Negocio.CategoriaN;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Categoriai {
    List<Categoria> listadoModel;
    CategoriaN cn=new CategoriaN();
    
    public Supplier<List<Categoria>> listadoCategorias= cn.listadoCategoria::get;
    
    public Consumer<Categoria> guardarCategoria= m -> {
        new CategoriaN().guardarCategoria.accept(m);
    };
    public Consumer<Categoria> eliminarCategoria= m -> {
        new CategoriaN().eliminarCategoria.accept(m);
    };
    public BiConsumer<JTable, List<Categoria>> cargarTabla=(tabla, listado)->{
        try {
            DefaultTableModel model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");

            listado.stream().forEach(c->{
                model.addRow(new Object[]{
                        c.getId(),
                        c.getNombre()
                });
            });
            tabla.setModel(model);
        }catch (Exception e){}

    };
    public Function<JTable,List<Categoria>> actualizarDatos= tabla->{
        try{
            listadoModel=cn.listadoCategoria.get();
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
    public BiConsumer<JTable, List<Categoria>> mostrarCoincidencias=(tabla, listado)->{
        cargarTabla.accept(tabla,listado);
        TableColumn columna = tabla.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        tabla.doLayout();
    };
}
