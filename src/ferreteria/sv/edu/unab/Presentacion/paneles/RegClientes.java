/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Presentacion.paneles;

import ferreteria.sv.edu.unab.Dominio.Cliente;
import ferreteria.sv.edu.unab.Infraestructura.Clientei;
import ferreteria.sv.edu.unab.Presentacion.paneles.Formularios.FrmCliente;
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

public final class RegClientes extends javax.swing.JPanel {
    /**
     * Creates new form RegClientes
     */
    List<Cliente> listadoModel;
    Long ID;
    Clientei ci=new Clientei();     
    
    public RegClientes() {
        initComponents();
        init();                
    }
   public void init(){                  
        mostrarClientes.accept(tblCliente);
        tblCliente.setFillsViewportHeight(true);
        if (listadoModel==null){
            listadoModel=new ArrayList<>();
        }
        
        btnNuevo.addActionListener(e->{
            FrmCliente frm=new FrmCliente(null);
            frm.setLocationRelativeTo(null);
            frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frm.setVisible(true);
            mostrarClientes.accept(tblCliente);
        });
        
        btnEditar.addActionListener(e->{
            listadoModel.forEach(m->{
                if(m.getId().equals(ID)){ 
                    FrmCliente frm=new FrmCliente(m);                   
                    frm.setLocationRelativeTo(null);
                    frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frm.setVisible(true);   
                    mostrarClientes.accept(tblCliente);
                }
            });
        });
        
        btnEliminar.addActionListener( e -> {
            if(JOptionPane.showConfirmDialog(null,"¿Desea Eliminar el Cliente?")==JOptionPane.OK_OPTION){
                Cliente c=new Cliente();
                c.setId(ID);
                try {
                    ci.eliminarCliente.accept(c);
                    mostrarClientes.accept(tblCliente);
                    JOptionPane.showMessageDialog(null,"Cliente eliminado");
                } catch (HeadlessException e1) {
                }
            }
        });
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                listadoModel=ci.actualizarDatos.apply(tblCliente);
                List<Cliente> busqueda=listadoModel.stream().filter(m->{
                    boolean respuesta=false;
                    if (m.getDatosPersonales().getNombre().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getApellidopaterno().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getApellidomaterno().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getDui().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getNit().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getTelefono().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getDireccion().contains(txtBuscar.getText())||
                            m.getDatosPersonales().getEmail().contains(txtBuscar.getText())||
                            m.getDatosMunicipio().getDatosDepartamento().getNombre().contains(txtBuscar.getText())||
                            m.getDatosMunicipio().getNombre().contains(txtBuscar.getText())
                    ){
                        respuesta=true;
                    }
                    return  respuesta;
                }).collect(Collectors.toList());
                mostrarCoincidencias.accept(tblCliente,busqueda);
            }
        });
        tblCliente.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    int i= tblCliente.getSelectedRow();
                    ID =Long.valueOf(tblCliente.getValueAt(i,0).toString());
                }catch(ArrayIndexOutOfBoundsException e1){
                }
            }
        });      
    }
   
    Consumer<JTable> mostrarClientes=(t)->{
        listadoModel=ci.actualizarDatos.apply(t);
        ci.actualizarDatos.apply(t);
    };
    BiConsumer<JTable,List<Cliente>> mostrarCoincidencias=(t, l)->{
            ci.mostrarCoincidencias.accept(t,l);
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoGenero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnEliminar = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnEditar = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnNuevo = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();

        setPreferredSize(new java.awt.Dimension(1181, 898));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/p.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setText("Inicio/Administración de Registros/Clientes");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 7, 360, 30));

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCliente);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
