/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Presentacion.paneles;

import ferreteria.sv.edu.unab.Dominio.Proveedor;
import ferreteria.sv.edu.unab.Infraestructura.Proveedori;
import ferreteria.sv.edu.unab.Presentacion.paneles.Formularios.FrmProveedor;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public final class RegProveedor extends javax.swing.JPanel {

    /**
     * Creates new form RegProveedor
     */
    List<Proveedor> listadoModel;
    Long ID;
    Proveedori pi=new Proveedori(); 
    public RegProveedor() {
        initComponents();
        init();
    }
    public void init(){                  
        mostrarProveedores.accept(tblProveedores);
        tblProveedores.setFillsViewportHeight(true);
        if (listadoModel==null){
            listadoModel=new ArrayList<>();
        }
        
        btnNuevo.addActionListener(e->{
            FrmProveedor frm=new FrmProveedor(null);
            frm.setLocationRelativeTo(null);
            frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frm.setVisible(true);
            mostrarProveedores.accept(tblProveedores);
        });
        
        btnEditar.addActionListener(e->{
            listadoModel.forEach(m->{
                if(m.getId().equals(ID)){ 
                    FrmProveedor frm=new FrmProveedor(m);                   
                    frm.setLocationRelativeTo(null);
                    frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frm.setVisible(true);   
                    mostrarProveedores.accept(tblProveedores);
                }
            });
        });
        
        btnEliminar.addActionListener( e -> {
            if(JOptionPane.showConfirmDialog(null,"¿Desea Eliminar el Proveedor?")==JOptionPane.OK_OPTION){
                Proveedor p=new Proveedor();
                p.setId(ID);
                try {
                    pi.eliminarProveedor.accept(p);
                    mostrarProveedores.accept(tblProveedores);
                    JOptionPane.showMessageDialog(null,"Proveedor eliminado");
                } catch (HeadlessException e1) {
                }
            }
        });
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                listadoModel=pi.actualizarDatos.apply(tblProveedores);
                List<Proveedor> busqueda=listadoModel.stream().filter(m->{
                    boolean respuesta=false;
                    if (m.getDatosPersonales().getNombre().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getApellidopaterno().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getApellidomaterno().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getDui().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getNit().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getTelefono().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getDireccion().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getEmail().contains(txtBuscar.getText())
                    ){
                        respuesta=true;
                    }
                    return  respuesta;
                }).collect(Collectors.toList());
                mostrarCoincidencias.accept(tblProveedores,busqueda);
            }
        });
        tblProveedores.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    int i= tblProveedores.getSelectedRow();
                    ID =Long.valueOf(tblProveedores.getValueAt(i,0).toString());
                }catch(ArrayIndexOutOfBoundsException e1){
                }
            }
        });      
    }
   
    Consumer<JTable> mostrarProveedores=(t)->{
        listadoModel=pi.actualizarDatos.apply(t);
        pi.actualizarDatos.apply(t);
    };
    BiConsumer<JTable,List<Proveedor>> mostrarCoincidencias=(t, l)->{
            pi.mostrarCoincidencias.accept(t,l);
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnEliminar = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnEditar = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnNuevo = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        hh = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/pp.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setText("Inicio/Administración de Registros/Clientes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 7, 360, 30));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        lblBuscar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblBuscar.setText("Buscar Cliente");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
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

        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        hh.setViewportView(tblProveedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hh)
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
                .addComponent(hh, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnEditar;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnEliminar;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnNuevo;
    private javax.swing.JScrollPane hh;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
