/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.Unidad;
import ferreteria.sv.edu.unab.Dominio.Usuario;
import ferreteria.sv.edu.unab.Negocio.UnidadN;
import ferreteria.sv.edu.unab.Negocio.UsuarioN;
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
public class Usuarioi {
    List<Usuario> listadoModel;   
    UsuarioN un=new UsuarioN();   
    
    public Supplier<List<Usuario>> listadoUsuarios=un.listadoUsuarios::get;

    public Consumer<Usuario> guardarUsuario= u -> {
        un.guardarUsuario.accept(u);
    };
    public Consumer<Usuario> eliminarUsuario= u -> {
        un.eliminarUsuario.accept(u);
    };
    public BiConsumer<JTable, List<Usuario>> cargarTabla=(tabla, listado)->{
        try {
            DefaultTableModel model=new DefaultTableModel();
            model.addColumn("Nombre");
            model.addColumn("Empleado");
            model.addColumn("Tipo");

            listado.stream().forEach(u->{
                model.addRow(new Object[]{
                        u.getNombre(),
                        u.getDatosEmpleado().getDatosPersonales().getNombre()+" "+u.getDatosEmpleado().getDatosPersonales().getApellidopaterno()+" "+u.getDatosEmpleado().getDatosPersonales().getApellidomaterno(),
                        u.getDatosTipoUsuario().getTipoUsuarios()
                });
            });
            tabla.setModel(model);
        }catch (Exception e){}

    };
    public Function<JTable,List<Usuario>> actualizarDatos= tabla->{
        try{
            listadoModel=un.listadoUsuarios.get();
            cargarTabla.accept(tabla, listadoModel);
            TableColumn columna = tabla.getColumnModel().getColumn(0);
            columna.setMaxWidth(100);
            columna.setMinWidth(100);
            columna.setPreferredWidth(100);
            tabla.doLayout();
        }catch (Exception e){

        }
        return listadoModel;
    };
    public BiConsumer<JTable, List<Usuario>> mostrarCoincidencias=(tabla, listado)->{
        cargarTabla.accept(tabla,listado);
        TableColumn columna = tabla.getColumnModel().getColumn(0);
        columna.setMaxWidth(100);
        columna.setMinWidth(100);
        columna.setPreferredWidth(100);
        tabla.doLayout();
    };
    
}
