/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Presentacion.paneles;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class reg extends javax.swing.JPanel {

    /**
     * Creates new form reg
     */
    public reg() {
        initComponents();
        
    }
    public void ajustarPnl(JPanel p){
        p.setSize(1181,898);
        p.setLocation(5,5);        
        pnlRegPrin.removeAll();
        pnlRegPrin.add(p, BorderLayout.CENTER);
        pnlRegPrin.revalidate();
        pnlRegPrin.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlRegPrin = new javax.swing.JPanel();
        btnRegEmple = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnProveedor = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnClientes = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnRegCatg = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnArticulo = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnUsuario = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        RegMarcas = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnUnidades = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();

        pnlRegPrin.setPreferredSize(new java.awt.Dimension(1181, 898));

        btnRegEmple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/emp.png"))); // NOI18N
        btnRegEmple.setText("Empleados");
        btnRegEmple.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnRegEmple.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegEmpleMouseClicked(evt);
            }
        });

        btnProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/pro.png"))); // NOI18N
        btnProveedor.setText("Proveedores");
        btnProveedor.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedorActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/reg.png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Inicio/Administración de Registros");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 7, 360, 30));

        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/cli.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClientesMouseClicked(evt);
            }
        });

        btnRegCatg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/lista.png"))); // NOI18N
        btnRegCatg.setText("Categorias");
        btnRegCatg.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnRegCatg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegCatgMouseClicked(evt);
            }
        });
        btnRegCatg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegCatgActionPerformed(evt);
            }
        });

        btnArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/articulo.png"))); // NOI18N
        btnArticulo.setText("Articulos");
        btnArticulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticuloActionPerformed(evt);
            }
        });

        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/usuario.png"))); // NOI18N
        btnUsuario.setText("Usuarios");
        btnUsuario.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADMINISTRACION DE REGISTROS");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        RegMarcas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/marca.png"))); // NOI18N
        RegMarcas.setText("Marcas");
        RegMarcas.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        RegMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegMarcasActionPerformed(evt);
            }
        });

        btnUnidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/unidad.png"))); // NOI18N
        btnUnidades.setText("Unidades");
        btnUnidades.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        btnUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnidadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegPrinLayout = new javax.swing.GroupLayout(pnlRegPrin);
        pnlRegPrin.setLayout(pnlRegPrinLayout);
        pnlRegPrinLayout.setHorizontalGroup(
            pnlRegPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1181, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlRegPrinLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(pnlRegPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(RegMarcas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(147, 147, 147)
                .addGroup(pnlRegPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegCatg, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlRegPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnRegEmple, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlRegPrinLayout.setVerticalGroup(
            pnlRegPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegPrinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addGroup(pnlRegPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegEmple, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlRegPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(pnlRegPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegCatg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(pnlRegPrinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRegPrin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlRegPrin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegEmpleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegEmpleMouseClicked

        RegEmpleado e=new RegEmpleado();
        ajustarPnl(e);                     
    }//GEN-LAST:event_btnRegEmpleMouseClicked

    private void btnClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseClicked
        // TODO add your handling code here:
        RegClientes c=new RegClientes();
        ajustarPnl(c); 
    }//GEN-LAST:event_btnClientesMouseClicked

    private void btnRegCatgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegCatgMouseClicked
        // TODO add your handling code here:
        RegCategorias p=new RegCategorias();
        ajustarPnl(p); 
        
    }//GEN-LAST:event_btnRegCatgMouseClicked

    private void btnRegCatgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegCatgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegCatgActionPerformed

    private void btnArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticuloActionPerformed
        // TODO add your handling code here:
        RegArticulo a=new RegArticulo();
        ajustarPnl(a); 
    }//GEN-LAST:event_btnArticuloActionPerformed

    private void btnProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedorActionPerformed
        // TODO add your handling code here:
         RegProveedor pro=new RegProveedor();
         ajustarPnl(pro); 
    }//GEN-LAST:event_btnProveedorActionPerformed

    private void RegMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegMarcasActionPerformed
        // TODO add your handling code here:
          RegMarcas m=new RegMarcas();
          ajustarPnl(m); 
    }//GEN-LAST:event_RegMarcasActionPerformed

    private void btnUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnidadesActionPerformed
        // TODO add your handling code here:
        RegUnid u=new RegUnid();
        ajustarPnl(u); 
    }//GEN-LAST:event_btnUnidadesActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // TODO add your handling code here:
        RegUsuario us=new RegUsuario();
        ajustarPnl(us); 
    }//GEN-LAST:event_btnUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro RegMarcas;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnArticulo;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnClientes;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnProveedor;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnRegCatg;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnRegEmple;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnUnidades;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel pnlRegPrin;
    // End of variables declaration//GEN-END:variables
}
