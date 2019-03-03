package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.Empleado;
import ferreteria.sv.edu.unab.Negocio.EmpleadoN;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class Empleadoi {
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    List<Empleado> listado;
    EmpleadoN em=new EmpleadoN();

    public Consumer<Empleado> GuardarEmpleado= (e) -> {
        new EmpleadoN().guardarEmpleado.accept(e);
    };
    public Consumer<Empleado> eliminarEmpleado= e -> {
        new EmpleadoN().eliminarEmpleado.accept(e);
    };

    public BiConsumer<JTable, List<Empleado>> cargarTabla=(tabla, listado)->{
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
        model.addColumn("Seguro");
        model.addColumn("AFP");

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
                    p.getDatosPersonales().getEmail(),
                    p.getIsss(),
                    p.getAfp()
            });
        });
        tabla.setModel(model);
    };
    public Function<JTable,List<Empleado>> actualizarDatos= tabla->{
        EmpleadoN en=new EmpleadoN();
        listado=en.listadoEmpleados.get();
        cargarTabla.accept(tabla, listado);
        TableColumn columna = tabla.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        ajustarColumnas(7,40,tabla);
        ajustarColumnas(2,60,tabla);
        ajustarColumnas(3,60,tabla);
        tabla.doLayout();
        return listado;
    };
    private void ajustarColumnas(Integer c, Integer t, JTable tabla){
        TableColumn columna = tabla.getColumnModel().getColumn(c);
        columna.setPreferredWidth(t);
    }
    public BiConsumer<JTable, List<Empleado>> mostrarCoincidencias=(tabla, list)->{
        cargarTabla.accept(tabla,list);
        TableColumn columna = tabla.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        tabla.doLayout();
    };
}
