package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.Unidad;
import ferreteria.sv.edu.unab.Negocio.UnidadN;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Unidadi {
    List<Unidad> listadoModel;
    
    UnidadN un=new UnidadN();
    
    public Supplier<List<Unidad>> listadoUnidades=un.listadoUnidades::get;

    public Consumer<Unidad> guardarUnidad= u -> {
        new UnidadN().guardarUnidad.accept(u);
    };
    public Consumer<Unidad> eliminarUnidad= u -> {
        new UnidadN().eliminarUnidad.accept(u);
    };
    public BiConsumer<JTable, List<Unidad>> cargarTabla=(tabla, listado)->{
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
    public Function<JTable,List<Unidad>> actualizarDatos= tabla->{
        try{
            listadoModel=un.listadoUnidades.get();
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
    public BiConsumer<JTable, List<Unidad>> mostrarCoincidencias=(tabla, listado)->{
        cargarTabla.accept(tabla,listado);
        TableColumn columna = tabla.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        tabla.doLayout();
    };
}
