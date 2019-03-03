/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.Proveedor;
import ferreteria.sv.edu.unab.Negocio.ProveedorN;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author anton
 */
public class Proveedori {
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    List<Proveedor> listadoModel;
    ProveedorN pn=new ProveedorN();

    public Consumer<Proveedor> guardarProveedor= (p) -> {
        new ProveedorN().guardarProveedor.accept(p);
    };
    public Consumer<Proveedor> eliminarProveedor= e -> {
        new ProveedorN().eliminarProveedor.accept(e);
    };
    public BiConsumer<JTable, List<Proveedor>> cargarTabla=(tabla, listado)->{
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombres");
        model.addColumn("Apellido P");
        model.addColumn("Apellido M");
        model.addColumn("DUI");
        model.addColumn("NIT");
        model.addColumn("FechaN");
        model.addColumn("Edad");
        model.addColumn("Genero");
        model.addColumn("Telefono");
        model.addColumn("Direccion");
        model.addColumn("Email");

        listado.stream().forEach(p->{
            model.addRow(new Object[]{
                    p.getId(),
                    p.getDatosPersonales().getNombre(),
                    p.getDatosPersonales().getApellidopaterno(),
                    p.getDatosPersonales().getApellidomaterno(),
                    p.getDatosPersonales().getDui(),
                    p.getDatosPersonales().getNit(),
                    p.getDatosPersonales().getFechaNacimiento().format(dtf),
                    p.getDatosPersonales().getFechaNacimiento().until(LocalDate.now(), ChronoUnit.YEARS),
                    p.getDatosPersonales().getGenero(),
                    p.getDatosPersonales().getTelefono(),
                    p.getDatosPersonales().getDireccion(),
                    p.getDatosPersonales().getEmail()
            });
        });
        tabla.setModel(model);
    };
    public Function<JTable,List<Proveedor>> actualizarDatos= tabla->{
        listadoModel=pn.listadoProveedores.get();
        cargarTabla.accept(tabla, listadoModel);
        TableColumn columna = tabla.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        ajustarColumnas(7,40,tabla);
        ajustarColumnas(2,60,tabla);
        ajustarColumnas(3,60,tabla);
        tabla.doLayout();
        return listadoModel;
    };
    private void ajustarColumnas(Integer c, Integer t, JTable tabla){
        TableColumn columna = tabla.getColumnModel().getColumn(c);
        columna.setPreferredWidth(t);
    }
    public BiConsumer<JTable, List<Proveedor>> mostrarCoincidencias=(tabla, list)->{
        cargarTabla.accept(tabla,list);
        TableColumn columna = tabla.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        tabla.doLayout();
    };
}
