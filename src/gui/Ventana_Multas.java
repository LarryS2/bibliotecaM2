/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Fiction
 */
public class Ventana_Multas extends javax.swing.JDialog {

    /**
     * Creates new form Ventana_Multas
     * @param parent
     * @param modal
     */
    public Ventana_Multas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backround = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labellibro = new javax.swing.JLabel();
        labelcod = new javax.swing.JLabel();
        labelced = new javax.swing.JLabel();
        labeltotal = new javax.swing.JLabel();
        labelfecha = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtcedmultado = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalibros = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        txtttotal = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtfecha = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        btnregistrolibro = new javax.swing.JPanel();
        btnlabelregistro = new javax.swing.JLabel();
        btnmodificarlibro = new javax.swing.JPanel();
        btnlabelmodificar = new javax.swing.JLabel();
        btneliminar = new javax.swing.JPanel();
        btnlabeleliminar = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JPanel();
        btnlabelbuscar = new javax.swing.JLabel();
        btnrvolver = new javax.swing.JPanel();
        btnlabelvolver = new javax.swing.JLabel();
        labeldetalles = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareadetalles = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backround.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        labellibro.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        labellibro.setForeground(new java.awt.Color(255, 255, 255));
        labellibro.setText("MULTAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labellibro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(labellibro)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        labelcod.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelcod.setForeground(new java.awt.Color(102, 102, 102));
        labelcod.setText("CÓDIGO:");

        labelced.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelced.setForeground(new java.awt.Color(102, 102, 102));
        labelced.setText("CÉDULA MULTADO:");

        labeltotal.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeltotal.setForeground(new java.awt.Color(102, 102, 102));
        labeltotal.setText("TOTAL $:");

        labelfecha.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelfecha.setForeground(new java.awt.Color(102, 102, 102));
        labelfecha.setText("FECHA APLICACIÓN:");

        txtcodigo.setBorder(null);

        txtcedmultado.setBorder(null);

        tablalibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablalibros);

        txtttotal.setBorder(null);

        txtfecha.setBorder(null);

        btnregistrolibro.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelregistro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelregistro.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelregistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelregistro.setText("REGISTRAR");
        btnlabelregistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelregistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelregistroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnregistrolibroLayout = new javax.swing.GroupLayout(btnregistrolibro);
        btnregistrolibro.setLayout(btnregistrolibroLayout);
        btnregistrolibroLayout.setHorizontalGroup(
            btnregistrolibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelregistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnregistrolibroLayout.setVerticalGroup(
            btnregistrolibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelregistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnmodificarlibro.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelmodificar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelmodificar.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelmodificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelmodificar.setText("MODIFICAR");
        btnlabelmodificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelmodificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelmodificarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnmodificarlibroLayout = new javax.swing.GroupLayout(btnmodificarlibro);
        btnmodificarlibro.setLayout(btnmodificarlibroLayout);
        btnmodificarlibroLayout.setHorizontalGroup(
            btnmodificarlibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelmodificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnmodificarlibroLayout.setVerticalGroup(
            btnmodificarlibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelmodificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btneliminar.setBackground(new java.awt.Color(0, 153, 153));

        btnlabeleliminar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabeleliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnlabeleliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabeleliminar.setText("ELIMINAR");
        btnlabeleliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabeleliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabeleliminarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btneliminarLayout = new javax.swing.GroupLayout(btneliminar);
        btneliminar.setLayout(btneliminarLayout);
        btneliminarLayout.setHorizontalGroup(
            btneliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeleliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btneliminarLayout.setVerticalGroup(
            btneliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeleliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnbuscar.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelbuscar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelbuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelbuscar.setText("BUSCAR");
        btnlabelbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelbuscarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnbuscarLayout = new javax.swing.GroupLayout(btnbuscar);
        btnbuscar.setLayout(btnbuscarLayout);
        btnbuscarLayout.setHorizontalGroup(
            btnbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnbuscarLayout.setVerticalGroup(
            btnbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnrvolver.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelvolver.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelvolver.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelvolver.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelvolver.setText("VOLVER");
        btnlabelvolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelvolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelvolverMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnrvolverLayout = new javax.swing.GroupLayout(btnrvolver);
        btnrvolver.setLayout(btnrvolverLayout);
        btnrvolverLayout.setHorizontalGroup(
            btnrvolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelvolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnrvolverLayout.setVerticalGroup(
            btnrvolverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelvolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        labeldetalles.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeldetalles.setForeground(new java.awt.Color(102, 102, 102));
        labeldetalles.setText("DETALLES:");

        txtareadetalles.setColumns(20);
        txtareadetalles.setRows(5);
        jScrollPane2.setViewportView(txtareadetalles);

        javax.swing.GroupLayout backroundLayout = new javax.swing.GroupLayout(backround);
        backround.setLayout(backroundLayout);
        backroundLayout.setHorizontalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelcod, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelced)
                            .addComponent(labeldetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator3)
                            .addComponent(txtcodigo)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(txtfecha)
                            .addComponent(jSeparator6)
                            .addComponent(jSeparator5)
                            .addComponent(txtttotal)
                            .addComponent(txtcedmultado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnregistrolibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmodificarlibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnrvolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        backroundLayout.setVerticalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backroundLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labelcod, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(labelced, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcedmultado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labeldetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(btnregistrolibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))
                            .addComponent(btnmodificarlibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnrvolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlabelregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelregistroMouseClicked
       
    }//GEN-LAST:event_btnlabelregistroMouseClicked

    private void btnlabelmodificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelmodificarMouseClicked

    }//GEN-LAST:event_btnlabelmodificarMouseClicked

    private void btnlabeleliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeleliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlabeleliminarMouseClicked

    private void btnlabelbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelbuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlabelbuscarMouseClicked

    private void btnlabelvolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelvolverMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnlabelvolverMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backround;
    private javax.swing.JPanel btnbuscar;
    private javax.swing.JPanel btneliminar;
    private javax.swing.JLabel btnlabelbuscar;
    private javax.swing.JLabel btnlabeleliminar;
    private javax.swing.JLabel btnlabelmodificar;
    private javax.swing.JLabel btnlabelregistro;
    private javax.swing.JLabel btnlabelvolver;
    private javax.swing.JPanel btnmodificarlibro;
    private javax.swing.JPanel btnregistrolibro;
    private javax.swing.JPanel btnrvolver;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel labelced;
    private javax.swing.JLabel labelcod;
    private javax.swing.JLabel labeldetalles;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labellibro;
    private javax.swing.JLabel labeltotal;
    private javax.swing.JTable tablalibros;
    private javax.swing.JTextArea txtareadetalles;
    private javax.swing.JTextField txtcedmultado;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txtttotal;
    // End of variables declaration//GEN-END:variables
}
