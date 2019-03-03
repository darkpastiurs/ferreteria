package ferreteria.sv.edu.unab.Infraestructura;

import ferreteria.sv.edu.unab.Dominio.Cliente;
import ferreteria.sv.edu.unab.Negocio.ClienteN;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class Clientei {
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    List<Cliente> listado;
    ClienteN cn=new ClienteN();

    public Consumer<Cliente> guardarCliente= c -> {
        new ClienteN().insertarCliente.accept(c);
    };
    public Consumer<Cliente> actualizarCliente= c -> {
        new ClienteN().actualizarCliente.accept(c);
    };
    public Consumer<Cliente> eliminarCliente= c -> {
        new ClienteN().eliminarCliente.accept(c);
    };
    public BiConsumer<JTable, List<Cliente>> cargarTabla=(tabla, listado)->{
        try {
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
            model.addColumn("Departamento");
            model.addColumn("Municipio");

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
                        p.getDatosMunicipio().getDatosDepartamento().getNombre(),
                        p.getDatosMunicipio().getNombre()
                });
            });
            tabla.setModel(model);
        }catch (Exception e){}

    };
    public Function<JTable,List<Cliente>> actualizarDatos= tabla->{
        try{
            ClienteN cn=new ClienteN();
            listado=cn.listadoClientes.get();
            cargarTabla.accept(tabla, listado);
            TableColumn columna = tabla.getColumnModel().getColumn(0);
            columna.setMaxWidth(0);
            columna.setMinWidth(0);
            columna.setPreferredWidth(0);
            tabla.doLayout();
        }catch (Exception e){

        }
        return listado;
    };

    public BiConsumer<JTable, List<Cliente>> mostrarCoincidencias=(tabla, listado)->{
        cargarTabla.accept(tabla,listado);
        TableColumn columna = tabla.getColumnModel().getColumn(0);
        columna.setMaxWidth(0);
        columna.setMinWidth(0);
        columna.setPreferredWidth(0);
        tabla.doLayout();
    };

}

