package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.Marca;
import ferreteria.sv.edu.unab.Negocio.MarcaN;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Marcai {
    List<Marca> listadoModel;
    
    MarcaN mn=new MarcaN();
    
    public Supplier<List<Marca>> listadomarcas=mn.listadoMarcas::get;

    public Consumer<Marca> guardarMarca= m -> {
        new MarcaN().guardarMarca.accept(m);
    };
    public Consumer<Marca> eliminarMarca= m -> {
        new MarcaN().eliminarMarca.accept(m);
    };
    public BiConsumer<JTable, List<Marca>> cargarTabla=(tabla, listado)->{
        try {
            DefaultTableModel model=new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("Nombre");

            listado.stream().forEach(m->{
                model.addRow(new Object[]{
                        m.getId(),
                        m.getNombre()
                });
            });
            tabla.setModel(model);
        }catch (Exception e){}

    };
    public Function<JTable,List<Marca>> actualizarDatos= tabla->{
        try{
            listadoModel=mn.listadoMarcas.get();
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
    public BiConsumer<JTable, List<Marca>> mostrarCoincidencias=(tabla, listado)->{
        cargarTabla.accept(tabla,listado);
        TableColumn columna = tabla.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        tabla.doLayout();
    };
}
