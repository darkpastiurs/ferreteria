/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.sv.edu.unab.Presentacion.paneles.Formularios;

import ferreteria.sv.edu.unab.Dominio.Empleado;
import ferreteria.sv.edu.unab.Dominio.Persona;
import ferreteria.sv.edu.unab.Infraestructura.Empleadoi;
import java.awt.HeadlessException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author anton
 */
public final class FrmEmpleados extends javax.swing.JFrame {

    /**
     * Creates new form FrmEmpleados
     */
     List<Empleado> listadoModel;
    Long ID;
    Empleadoi ei=new Empleadoi(); 
    
    
    public FrmEmpleados(Empleado emp) {
        initComponents();
        init();
        if(emp!=null){
                    this.ID=emp.getId();
                    txtNombre1.setText(emp.getDatosPersonales().getNombre());
                    txtApellidoPaterno1.setText(emp.getDatosPersonales().getApellidopaterno());
                    txtApellidoMaterno1.setText(emp.getDatosPersonales().getApellidomaterno());
                    ftxDui1.setText(emp.getDatosPersonales().getDui());
                    ftxNit1.setText(emp.getDatosPersonales().getNit());
                    ftxTelefono1.setText(emp.getDatosPersonales().getTelefono());
                    txtDireccion1.setText(emp.getDatosPersonales().getDireccion());
                    txtEmail1.setText(emp.getDatosPersonales().getEmail());
                    /*LocalDate date=LocalDate.parse(emp.getDatosPersonales().getFechaNacimiento().format(dtf));
                    Date d=Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
                    dcFechaN.setDate(d);*/
                    txtAFP.setText(emp.getAfp());
                    txtSeguro.setText(emp.getIsss());
                    if(emp.getDatosPersonales().getGenero()=='M'){
                        rbMasculino1.setSelected(true);
                    }else{
                        rbFemenino1.setSelected(true);                   
                    }
        }
    }
    public void init(){
    btnGuardar.addActionListener(e->{
     if (txtNombre1.getText()!=null && txtApellidoPaterno1!=null){
                Empleado em=new Empleado();
                Persona p=new Persona();
                Character sexo=GrupoGenero.getSelection().getActionCommand().charAt(0);
                p.setId(ID);
                p.setNombre(txtNombre1.getText());
                p.setApellidopaterno(txtApellidoPaterno1.getText());
                p.setApellidomaterno(txtApellidoMaterno1.getText());
                p.setDui(ftxDui1.getText().replace("-",""));
                p.setNit(ftxNit1.getText().replace("-",""));
                Date date = dcFechaN1.getDate();
                LocalDate fecha = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                p.setFechaNacimiento(fecha);
                p.setTelefono(ftxTelefono1.getText().replace("-",""));
                p.setEmail(txtEmail1.getText());
                p.setDireccion(txtDireccion1.getText());
                p.setGenero(sexo);
                em.setId(ID);
                em.setAfp(txtAFP.getText());
                em.setIsss(txtSeguro.getText());
                em.setDatosPersonales(p);
                try {
                    //JOptionPane.showMessageDialog(null, c.toString());
                    if(em.getId()!=null){
                        ei.GuardarEmpleado.accept(em);
                        JOptionPane.showMessageDialog(null,"Empleado Actualizado Correctamente");
                        dispose();  
                    }
                    else{
                        ei.GuardarEmpleado.accept(em);
                        JOptionPane.showMessageDialog(null,"Empleado Insertado Correctamente");
                        limpiar();
                    }
                    
                } catch (HeadlessException e1) {
                }
            }else{
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }
    });
     FormatearTXT(ftxDui1, ftxNit1, ftxTelefono1);
    }
        static void FormatearTXT(JFormattedTextField ftxDui, JFormattedTextField ftxNit, JFormattedTextField ftxTelefono) {
        try{
            MaskFormatter mascara1=new MaskFormatter("########-#");
            mascara1.setPlaceholderCharacter(' ');
            MaskFormatter mascara2=new MaskFormatter("####-######-###-#");
            mascara2.setPlaceholderCharacter(' ');
            MaskFormatter mascara3=new MaskFormatter("####-####");
            mascara3.setPlaceholderCharacter(' ');
            ftxDui.setFormatterFactory(new DefaultFormatterFactory(mascara1));
            ftxNit.setFormatterFactory(new DefaultFormatterFactory(mascara2));
            ftxTelefono.setFormatterFactory(new DefaultFormatterFactory(mascara3));
        }catch(ParseException e){
        }
    }
    public void limpiar(){
        txtNombre1.setText(null);
        txtApellidoPaterno1.setText(null);
        txtApellidoMaterno1.setText(null);
        ftxDui1.setText(null);
        ftxNit1.setText(null);
        ftxTelefono1.setText(null);
        dcFechaN1.setDate(null);
        txtDireccion1.setText(null);
        txtEmail1.setText(null);
        txtAFP.setText(null);
        txtSeguro.setText(null);
    }
    

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
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtApellidoPaterno1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtApellidoMaterno1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtDireccion1 = new javax.swing.JTextField();
        ftxTelefono1 = new javax.swing.JFormattedTextField();
        ftxDui1 = new javax.swing.JFormattedTextField();
        ftxNit1 = new javax.swing.JFormattedTextField();
        rbMasculino1 = new javax.swing.JRadioButton();
        rbFemenino1 = new javax.swing.JRadioButton();
        dcFechaN1 = new com.toedter.calendar.JDateChooser();
        lblNSeguro = new javax.swing.JLabel();
        txtSeguro = new javax.swing.JTextField();
        lblNAFP = new javax.swing.JLabel();
        txtAFP = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnGuardar = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();
        btnCancelar = new ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Registro de Clientes");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 7, 880, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/p.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel17.setText("Nombre:");

        txtNombre1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel18.setText("Apellidos:");

        txtApellidoPaterno1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel19.setText("Paterno");

        txtApellidoMaterno1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel20.setText("Materno");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel21.setText("Genero:");

        jLabel22.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel22.setText("DUI:");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel23.setText("NIT:");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel24.setText("Telefono:");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel25.setText("E-mail:");

        txtEmail1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel27.setText("Fecha de Nacimiento:");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel28.setText("Direccion:");

        txtDireccion1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        ftxTelefono1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        ftxDui1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        ftxNit1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        GrupoGenero.add(rbMasculino1);
        rbMasculino1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        rbMasculino1.setText("M");
        rbMasculino1.setToolTipText("M");
        rbMasculino1.setActionCommand("Masculino");

        GrupoGenero.add(rbFemenino1);
        rbFemenino1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        rbFemenino1.setText("F");
        rbFemenino1.setActionCommand("Femenino");

        dcFechaN1.setDateFormatString("dd/MM/yyyy");
        dcFechaN1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N

        lblNSeguro.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNSeguro.setText("N° de Seguro");

        txtSeguro.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        lblNAFP.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblNAFP.setText("N° de AFP");

        txtAFP.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(lblNSeguro))
                                    .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAFP, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNAFP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcFechaN1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel24))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDireccion1)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(ftxTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel25))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(rbMasculino1)
                                                .addGap(17, 17, 17)
                                                .addComponent(rbFemenino1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel22)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(ftxDui1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                                .addComponent(jLabel23)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ftxNit1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtEmail1)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtApellidoPaterno1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtApellidoMaterno1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20)
                        .addGap(140, 140, 140)))
                .addGap(15, 15, 15))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel17)
                            .addGap(18, 18, 18)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(jLabel21))
                        .addComponent(jLabel18))
                    .addContainerGap(413, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidoPaterno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoMaterno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxDui1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxNit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbMasculino1)
                    .addComponent(rbFemenino1)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27)
                    .addComponent(dcFechaN1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNSeguro)
                            .addComponent(lblNAFP, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAFP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17))
                    .addGap(37, 37, 37)
                    .addComponent(jLabel18)
                    .addGap(20, 20, 20)
                    .addComponent(jLabel21)
                    .addContainerGap(204, Short.MAX_VALUE)))
        );

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ferreteria/sv/edu/unab/Presentacion/img/cancel.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmEmpleados(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoGenero;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnCancelar;
    private ferreteria.sv.edu.unab.Presentacion.rsbuttom.RSButtonMetro btnGuardar;
    private com.toedter.calendar.JDateChooser dcFechaN1;
    private javax.swing.JFormattedTextField ftxDui1;
    private javax.swing.JFormattedTextField ftxNit1;
    private javax.swing.JFormattedTextField ftxTelefono1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblNAFP;
    private javax.swing.JLabel lblNSeguro;
    private javax.swing.JRadioButton rbFemenino1;
    private javax.swing.JRadioButton rbMasculino1;
    private javax.swing.JTextField txtAFP;
    private javax.swing.JTextField txtApellidoMaterno1;
    private javax.swing.JTextField txtApellidoPaterno1;
    private javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtSeguro;
    // End of variables declaration//GEN-END:variables
}
