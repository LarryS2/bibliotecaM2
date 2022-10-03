/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Modelo.ModeloDevolucion;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import logico.Detalle_Devolucion;
import logico.Devolucion;
import logico.Estudiante;
import logico.Libro;

/**
 *
 * @author Fiction
 */
public class Ventana_Devolucion extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Devolucion
     */
    
    
    DefaultTableModel modelo;
    ModeloDevolucion  md = new ModeloDevolucion();
    public Ventana_Devolucion() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.Frameclientes.setLocationRelativeTo(null);
        this.Frameclientes.setAlwaysOnTop(true);
        ModeloDevolucion.getTabla();
    }

    
    public void NuevoModelo() {
        modelo = new DefaultTableModel();
        modelo.addColumn("CÓDIGO");
        modelo.addColumn("TÍTULO");
        modelo.addColumn("ISBN");
        tabladevolucion.setModel(modelo);
        ModeloDevolucion.getTablaDetalles();
    }
    
    public void detalles(){
        try {
            Devolucion dev = new Devolucion();
            String cedula = txtcedula.getText().trim();
            Date fecha_dev = java.sql.Date.valueOf(txtfechadev.getText().trim());
            
            int id_per = ModeloDevolucion.getIdPerson(cedula);
            if(id_per>0){
                System.out.println(id_per);
                boolean estado = false;
                dev.setFecha_dev(fecha_dev);
                dev.setId_est_dev(id_per);
                dev.setEstado(estado);
                if(md.RegistrarEncaDevolucion(dev)) {
                    limpiar_texto(paneltxt);
                }
            } else {
            }
            
        } catch (NullPointerException e) {
        }
    }
    
    public void guardarDetalleDev(){
        try {
            int a = 0;
            Detalle_Devolucion dd = new Detalle_Devolucion();
            String idd = ModeloDevolucion.idDevolucion();
            int iddev = Integer.parseInt(idd);
            for (int i = 0; i < tabladevolucion.getRowCount(); i++) {
                String cod = tabladevolucion.getValueAt(i, 0).toString();
                dd.setId_lib(ModeloDevolucion.idLibro(new Libro(cod)));
                dd.setId_enc_dev(iddev);
                if (md.registrarDetalleDev(dd)) {
                    a++;
                }
            }
            if (a != 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO COMPLETADO");
                for(int i = 0; i < tabladevolucion.getRowCount(); i++){
                    modelo.removeRow(i);
                }
            }
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(e);
        }
    }
    
    public void TablaDetalles(){
        Estudiante est = new Estudiante();
        String cedula = txtcedula.getText();
        est.setCedula(cedula);
        ModeloDevolucion.getTablaDetalles();
    }

    public void limpiar_texto(JPanel panel) {
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JTextField) {
                ((JTextField) panel.getComponents()[i]).setText("");
            } else if (panel.getComponents()[i] instanceof JDateChooser) {
                ((JDateChooser) panel.getComponents()[i]).setCalendar(null);
            }
        }
    }
    
    public void mt(){
        Frameclientes.setLocationRelativeTo(null);
        Frameclientes.setVisible(true);
        ModeloDevolucion.getTablaDetalles();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Frameclientes = new javax.swing.JFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabladet = new javax.swing.JTable();
        backround = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idlabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladevolucion = new javax.swing.JTable();
        paneltxt = new javax.swing.JPanel();
        labelnom = new javax.swing.JLabel();
        txrnombrecli = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        buttonCliente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtfechadev = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtisbn = new javax.swing.JTextField();
        txtcodlib = new javax.swing.JTextField();
        txtitulolibr = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btndevolver = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        Frameclientes.setMinimumSize(new java.awt.Dimension(680, 240));
        Frameclientes.setResizable(false);

        tabladet.setModel(new javax.swing.table.DefaultTableModel(
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
        tabladet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladetMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabladet);

        javax.swing.GroupLayout FrameclientesLayout = new javax.swing.GroupLayout(Frameclientes.getContentPane());
        Frameclientes.getContentPane().setLayout(FrameclientesLayout);
        FrameclientesLayout.setHorizontalGroup(
            FrameclientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameclientesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        FrameclientesLayout.setVerticalGroup(
            FrameclientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameclientesLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setText("DEVOLUCIONES");

        jLabel3.setText("ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idlabel))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabladevolucion.setModel(new javax.swing.table.DefaultTableModel(
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
        tabladevolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladevolucionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabladevolucion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        paneltxt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelnom.setText("NOMBRES:");

        txrnombrecli.setFocusable(false);
        txrnombrecli.setRequestFocusEnabled(false);

        jLabel2.setText("CÉDULA:");

        txtcedula.setFocusable(false);
        txtcedula.setRequestFocusEnabled(false);

        buttonCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        buttonCliente.setText("Cargar pedidos");
        buttonCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClienteMouseClicked(evt);
            }
        });

        jLabel4.setText("FECHA: ");

        txtfechadev.setFocusable(false);
        txtfechadev.setRequestFocusEnabled(false);

        jLabel5.setText("CODIGO LIBRO");

        jLabel6.setText("ISBN");

        jLabel7.setText("TITULO");

        txtisbn.setFocusable(false);
        txtisbn.setRequestFocusEnabled(false);

        txtcodlib.setFocusable(false);
        txtcodlib.setRequestFocusEnabled(false);

        javax.swing.GroupLayout paneltxtLayout = new javax.swing.GroupLayout(paneltxt);
        paneltxt.setLayout(paneltxtLayout);
        paneltxtLayout.setHorizontalGroup(
            paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltxtLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelnom)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneltxtLayout.createSequentialGroup()
                        .addComponent(txrnombrecli, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(buttonCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(paneltxtLayout.createSequentialGroup()
                        .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfechadev, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(paneltxtLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcodlib, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(paneltxtLayout.createSequentialGroup()
                                .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(48, 48, 48)
                                .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtisbn)
                                    .addComponent(txtitulolibr, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        paneltxtLayout.setVerticalGroup(
            paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltxtLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnom)
                    .addComponent(txrnombrecli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneltxtLayout.createSequentialGroup()
                        .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtfechadev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneltxtLayout.createSequentialGroup()
                        .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtcodlib, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(paneltxtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtitulolibr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/return.png"))); // NOI18N
        btndevolver.setText("DEVOLVER");
        btndevolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndevolverMouseClicked(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(btncancelar)
                .addGap(28, 28, 28)
                .addComponent(btndevolver)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncancelar)
                    .addComponent(btndevolver)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paneltxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(paneltxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        backround.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(backround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backround, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClienteMouseClicked
        mt();
    }//GEN-LAST:event_buttonClienteMouseClicked

    private void tabladevolucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladevolucionMouseClicked
        try{
            int fila = tabladevolucion.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "NO HAY UNA FILA SELECCIONADA");
            } else {
                txrnombrecli.isEditable();
                String cedula = ((String) tabladevolucion.getValueAt(fila, 0).toString());
                String pri_nom = (String) tabladevolucion.getValueAt(fila, 1);
                String seg_nombre = (String) tabladevolucion.getValueAt(fila, 2);
                
                String pr_ap = (String) tabladevolucion.getValueAt(fila, 3);
                String seg_ap = (String) tabladevolucion.getValueAt(fila, 4);

                txtcedula.setText(cedula);
                txrnombrecli.setText(pri_nom+" "+seg_nombre+" "+pr_ap+" "+seg_ap);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                txtfechadev.setText(formatter.format(new Date()));
            }
        }catch(HeadlessException  | ArrayIndexOutOfBoundsException | NullPointerException | IllegalArgumentException e){
            System.err.println(e);
        }
    }//GEN-LAST:event_tabladevolucionMouseClicked

    private void btncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btncancelarMouseClicked

    private void btndevolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndevolverMouseClicked
        detalles();
    }//GEN-LAST:event_btndevolverMouseClicked

    private void tabladetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladetMouseClicked
        try{
            int fila = tabladet.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "NO HAY UNA FILA SELECCIONADA");
            } else {
                txrnombrecli.isEditable();
                String codigo = ((String) tabladet.getValueAt(fila, 0).toString());
                String isbn = (String) tabladet.getValueAt(fila, 1);
                String titulo = (String) tabladet.getValueAt(fila, 2);
                
                txtcodlib.setText(codigo);
                txtisbn.setText(isbn);
                txtitulolibr.setText(titulo);
            }
        }catch(HeadlessException  | ArrayIndexOutOfBoundsException | NullPointerException | IllegalArgumentException e){
            System.err.println(e);
        }
    }//GEN-LAST:event_tabladetMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame Frameclientes;
    private javax.swing.JScrollPane backround;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btndevolver;
    private javax.swing.JLabel buttonCliente;
    private javax.swing.JLabel idlabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelnom;
    private javax.swing.JPanel paneltxt;
    public static javax.swing.JTable tabladet;
    public static javax.swing.JTable tabladevolucion;
    private javax.swing.JTextField txrnombrecli;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtcodlib;
    private javax.swing.JTextField txtfechadev;
    private javax.swing.JTextField txtisbn;
    private javax.swing.JTextField txtitulolibr;
    // End of variables declaration//GEN-END:variables
}
