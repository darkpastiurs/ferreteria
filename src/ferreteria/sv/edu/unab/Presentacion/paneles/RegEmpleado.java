/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Presentacion.paneles;

import ferreteria.sv.edu.unab.Dominio.Cliente;
import ferreteria.sv.edu.unab.Dominio.Empleado;
import ferreteria.sv.edu.unab.Infraestructura.Empleadoi;
import ferreteria.sv.edu.unab.Presentacion.paneles.Formularios.FrmEmpleados;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author HP
 */

public final class RegEmpleado extends javax.swing.JPanel {

    /**
     * Creates new form RegEmpleado
     */
    
    List<Empleado> listadoModel;
    Long ID;
    Empleadoi ei=new Empleadoi();
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public RegEmpleado() {
        initComponents();
        init();
    }
    public void init(){
    mostrarEmpleados.accept(tblEmpleados);
        tblEmpleados.setFillsViewportHeight(true);
        if (listadoModel==null){
            listadoModel=new ArrayList<>();
        }
    btnNuevo.addActionListener(e->{
            FrmEmpleados frm=new FrmEmpleados(null);
            frm.setLocationRelativeTo(null);
            frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frm.setVisible(true);
            mostrarEmpleados.accept(tblEmpleados);
    });
   btnEditar.addActionListener(e->{
            listadoModel.forEach(m->{
                if(m.getId().equals(ID)){ 
                    FrmEmpleados frm=new FrmEmpleados(m);                   
                    frm.setLocationRelativeTo(null);
                    frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frm.setVisible(true);   
                }
            });
        });
        
        btnEliminar.addActionListener( e -> {
            if(JOptionPane.showConfirmDialog(null,"¿Desea Eliminar el Empleado?")==JOptionPane.OK_OPTION){
                Empleado em=new Empleado();
                em.setId(ID);
                try {
                    ei.eliminarEmpleado.accept(em);
                    mostrarEmpleados.accept(tblEmpleados);
                    JOptionPane.showMessageDialog(null,"Empleado eliminado");
                } catch (HeadlessException e1) {
                }
            }
        });
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                listadoModel=ei.actualizarDatos.apply(tblEmpleados);
                List<Empleado> busqueda=listadoModel.stream().filter(m->{
                    boolean respuesta=false;
                    if (m.getDatosPersonales().getNombre().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getApellidopaterno().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getApellidomaterno().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getDui().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getNit().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getTelefono().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getDireccion().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getEmail().contains(txtBuscar.getText())||
                            m.getAfp().contains(txtBuscar.getText())||
                            m.getIsss().contains(txtBuscar.getText())
                    ){
                        respuesta=true;
                    }
                    return  respuesta;
                }).collect(Collectors.toList());
                mostrarCoincidencias.accept(tblEmpleados,busqueda);
            }
        });
        tblEmpleados.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    int i= tblEmpleados.getSelectedRow();
                    ID =Long.valueOf(tblEmpleados.getValueAt(i,0).toString());
                }catch(ArrayIndexOutOfBoundsException e1){
                }
            }
        });   
    }
    Consumer<JTable> mostrarEmpleados=(t)->{
        listadoModel=ei.actualizarDatos.apply(t);
            ei.actualizarDatos.apply(t);
    };
    BiConsumer<JTable,List<Empleado>> mostrarCoincidencias=(t, l)->{
            ei.mostrarCoincidencias.accept(t,l);
    };
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        GrupoGenero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnEliminar = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnEditar = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnNuevo = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();

        jMenuItem1.setText("jMenuItem1");

        setPreferredSize(new java.awt.Dimension(1181, 898));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/pp.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setText("Inicio/Administración de Registros/Empleados");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 7, 390, 30));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblEmpleados);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        lblBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblBuscar.setText("Buscar Empleado");

        txtBuscar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/elimi.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1169, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoGenero;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnEditar;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnEliminar;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnNuevo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
