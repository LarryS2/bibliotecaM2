/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Modelo.ModeloCategoria;
import Modelo.ModeloDewey;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import logico.Seccion;
import Modelo.ModeloSeccion;
import java.util.ArrayList;
import logico.Categoria;
import logico.Conexion;
import logico.Dewey;

/**
 *
 * @author Fiction
 */
public class Ventana_Seccion extends javax.swing.JDialog {

    /**
     * Creates new form Ventana_Zona
     */
    Conexion con = new Conexion();
    ModeloSeccion ms = new ModeloSeccion();
    int ids;

    public Ventana_Seccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenarCategoria();
        ModeloSeccion.getTabla();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labellibro = new javax.swing.JLabel();
        labelcod = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelnomb = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtdesc = new javax.swing.JTextField();
        labeldesc = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        txtnombrezona = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaseccion = new javax.swing.JTable();
        btnagregar = new javax.swing.JPanel();
        btnlabeagregar = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JPanel();
        btnlabelactualizar = new javax.swing.JLabel();
        btneliminar = new javax.swing.JPanel();
        btnlabeleliminar = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JPanel();
        btnlabelbuscar = new javax.swing.JLabel();
        btnrvolver = new javax.swing.JPanel();
        btnlabelvolver = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        campoid = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JPanel();
        btnlabellimpiar = new javax.swing.JLabel();
        checkCancellDelete = new javax.swing.JCheckBox();
        checkFiltro = new javax.swing.JCheckBox();
        combogenero = new javax.swing.JComboBox<>();
        labelnomb1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        labellibro.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        labellibro.setForeground(new java.awt.Color(255, 255, 255));
        labellibro.setText("SECCION");

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

        labelnomb.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelnomb.setForeground(new java.awt.Color(102, 102, 102));
        labelnomb.setText("NOMBRE ZONA:");

        txtcodigo.setBorder(null);
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });

        txtdesc.setBorder(null);

        labeldesc.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeldesc.setForeground(new java.awt.Color(102, 102, 102));
        labeldesc.setText("DESCRIPCIÓN:");

        txtnombrezona.setBorder(null);

        tablaseccion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaseccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaseccion.setFocusable(false);
        tablaseccion.getTableHeader().setReorderingAllowed(false);
        tablaseccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaseccionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaseccion);

        btnagregar.setBackground(new java.awt.Color(0, 153, 153));

        btnlabeagregar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabeagregar.setForeground(new java.awt.Color(255, 255, 255));
        btnlabeagregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabeagregar.setText("AGREGAR");
        btnlabeagregar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnlabeagregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabeagregarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnagregarLayout = new javax.swing.GroupLayout(btnagregar);
        btnagregar.setLayout(btnagregarLayout);
        btnagregarLayout.setHorizontalGroup(
            btnagregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeagregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnagregarLayout.setVerticalGroup(
            btnagregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeagregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnactualizar.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelactualizar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelactualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelactualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelactualizar.setText("ACTUALIZAR");
        btnlabelactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnlabelactualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelactualizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnactualizarLayout = new javax.swing.GroupLayout(btnactualizar);
        btnactualizar.setLayout(btnactualizarLayout);
        btnactualizarLayout.setHorizontalGroup(
            btnactualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelactualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnactualizarLayout.setVerticalGroup(
            btnactualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelactualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btneliminar.setBackground(new java.awt.Color(0, 153, 153));

        btnlabeleliminar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabeleliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnlabeleliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabeleliminar.setText("ELIMINAR");
        btnlabeleliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnlabelbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        btnlabelvolver.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        labelid.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelid.setForeground(new java.awt.Color(102, 102, 102));
        labelid.setText("ID:");

        campoid.setEnabled(false);

        btnlimpiar.setBackground(new java.awt.Color(0, 153, 153));

        btnlabellimpiar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabellimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlabellimpiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabellimpiar.setText("LIMPIAR");
        btnlabellimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnlabellimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabellimpiarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnlimpiarLayout = new javax.swing.GroupLayout(btnlimpiar);
        btnlimpiar.setLayout(btnlimpiarLayout);
        btnlimpiarLayout.setHorizontalGroup(
            btnlimpiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabellimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnlimpiarLayout.setVerticalGroup(
            btnlimpiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabellimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        checkCancellDelete.setText("CANCELAR ELIMINACION");
        checkCancellDelete.setEnabled(false);

        checkFiltro.setText("FILTRAR ELIMINADOS");
        checkFiltro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkFiltroMouseClicked(evt);
            }
        });

        combogenero.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        labelnomb1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelnomb1.setForeground(new java.awt.Color(102, 102, 102));
        labelnomb1.setText("CATEGORÍA:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel1.setText("Buscar Seccion:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labeldesc)
                                .addComponent(labelnomb)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelid, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelcod, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(campoid, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(combogenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtdesc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                        .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtcodigo)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtnombrezona, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(88, 88, 88)
                                    .addComponent(checkFiltro))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(90, 90, 90)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(checkCancellDelete))
                    .addComponent(labelnomb1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnagregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnrvolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campoid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelcod, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnomb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombrezona, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelnomb1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combogenero, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labeldesc, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(checkCancellDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(15, 15, 15)
                                .addComponent(checkFiltro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnrvolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void llenarCategoria(){
        ModeloCategoria modcat = new ModeloCategoria();
        ArrayList<Categoria> listcat = modcat.getCategoria();
        combogenero.removeAllItems();
        for(int i = 0; i < listcat.size(); i++){
            combogenero.addItem(new Categoria(listcat.get(i).getId(), listcat.get(i).getNombre_cat()));
        }  
    }
    
    public void enableCheck() {
        checkCancellDelete.setEnabled(false);

        try {
            ModeloSeccion ms = new ModeloSeccion();
            ArrayList<Seccion> listaSeccion = ms.getSeccionEliminado();
            int id = Integer.parseInt(campoid.getText().trim());

            for (int i = 0; i < listaSeccion.size(); i++) {
                if (id == listaSeccion.get(i).getId()) {
                    checkCancellDelete.setEnabled(true);
                    i = listaSeccion.size();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA DE LA TABLA");
        }
    }

    public void Agregar() {
        try {
            Seccion seccion = new Seccion();
            String codigo = txtcodigo.getText().trim();
            String nombre = txtnombrezona.getText().trim();
            int categoria = combogenero.getItemAt(combogenero.getSelectedIndex()).getId();

            String descripcion = txtdesc.getText().trim();

            if (codigo.isEmpty() || nombre.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            } else {
                if (seccion.ValidarNombre(nombre) == false) {
                    JOptionPane.showMessageDialog(null, "NOMBRE NO VÁLIDO");
                } else {

                        seccion.setCodigo_zona(codigo);
                        seccion.setNombre_zona(nombre);
                        seccion.setDescripcion(descripcion);
                        seccion.setId_cate_zona(categoria);
                        if (ms.RegistrarSeccion(seccion)) {
                            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                            ModeloSeccion.Limpiar_Tabla();
                            ModeloSeccion.getTabla();
                            LimpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR ");
                            ModeloSeccion.Limpiar_Tabla();
                            ModeloSeccion.getTabla();
                        }
                    
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }

    public void Modificar() {
        try {
            Seccion seccion = new Seccion();
            int id = Integer.parseInt(campoid.getText().trim());
            String codigo = txtcodigo.getText().trim();
            String nombre = txtnombrezona.getText().trim();
            String descripcion = txtdesc.getText().trim();
            try {
                if (codigo.isEmpty() || nombre.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
                    LimpiarCampos();
                } else {
                    if (!seccion.ValidarNombre(nombre) || !seccion.ValidarDescripcion(descripcion)) {
                        JOptionPane.showMessageDialog(null, "VERIFIQUE LOS CAMPOS");
                        LimpiarCampos();
                    } else {

                        seccion.setCodigo_zona(codigo);
                        seccion.setId(id);
                        seccion.setNombre_zona(nombre);
                        seccion.setDescripcion(descripcion);
                        if (ms.ModificarSeccion(seccion)) {
                            JOptionPane.showMessageDialog(null, "MODIFICACIÓN EXITOSA");
                            ModeloSeccion.getTabla();
                            LimpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR ");
                        }
                    }
                }

            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "ERROR-NO SE PUDO MODIFICAR LA SECCION");
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    public void ModificarEliminado() {
        try {
            Seccion seccion = new Seccion();
            int id = Integer.parseInt(campoid.getText().trim());
            String codigo = txtcodigo.getText().trim();
            String nombre = txtnombrezona.getText().trim();
            String descripcion = txtdesc.getText().trim();
            boolean bo1;
            bo1 = !checkCancellDelete.isSelected();

            try {

                if (codigo.isEmpty() || nombre.isEmpty() || descripcion.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");

                } else {
                    if (!seccion.ValidarNombre(nombre) || !seccion.ValidarDescripcion(descripcion)) {
                        JOptionPane.showMessageDialog(null, "VERIFIQUE LOS CAMPOS");

                    } else {

                        seccion.setCodigo_zona(codigo);
                        seccion.setId(id);
                        seccion.setNombre_zona(nombre);
                        seccion.setDescripcion(descripcion);
                        seccion.setEstado(bo1);
                        if (ms.ModificarSeccionEliminado(seccion)) {
                            JOptionPane.showMessageDialog(null, "MODIFICACIÓN EXITOSA");
                            ModeloSeccion.getTabla();
                            ModeloSeccion.getTablaElimado();

                        } else {
                            JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR ");
                        }
                    }
                }

            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(null, "ERROR-NO SE PUDO MODIFICAR AL AUTOR");
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    public void Eliminar() {
        try {
            Seccion seccion = new Seccion();
            int id = Integer.parseInt(campoid.getText().trim());

            seccion.setId(id);

            if (ms.EliminarSeccion(seccion)) {
                JOptionPane.showMessageDialog(null, "ELIMINACIÓN EXITOSA");
                ModeloSeccion.getTabla();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR ");
                ModeloSeccion.getTabla();
            }
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            System.out.println(e);
        }
    }

    public void LimpiarCampos() {
        campoid.setText(null);
        txtcodigo.setText(null);
        txtnombrezona.setText(null);
        txtdesc.setText(null);
        checkCancellDelete.setSelected(false);
    }


    private void btnlabeagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeagregarMouseClicked
        Agregar();
    }//GEN-LAST:event_btnlabeagregarMouseClicked

    private void btnlabelactualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelactualizarMouseClicked
        if (checkCancellDelete.isEnabled()) {
            ModificarEliminado();
            LimpiarCampos();
        } else {
            Modificar();
            LimpiarCampos();
        }
    }//GEN-LAST:event_btnlabelactualizarMouseClicked

    private void btnlabeleliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeleliminarMouseClicked
        if (!checkFiltro.isSelected()) {
            Eliminar();
            LimpiarCampos();
        } else {
            JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR ESTANDO ACTIVO EL FILTRO DE ELIMINADOS");
        }
    }//GEN-LAST:event_btnlabeleliminarMouseClicked

    private void btnlabelbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelbuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlabelbuscarMouseClicked

    private void btnlabelvolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelvolverMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnlabelvolverMouseClicked

    private void btnlabellimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabellimpiarMouseClicked
        LimpiarCampos();
        ModeloSeccion.Limpiar_Tabla();
        ModeloSeccion.getTabla();
    }//GEN-LAST:event_btnlabellimpiarMouseClicked

    private void tablaseccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaseccionMouseClicked
        int fila = tablaseccion.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "NO HAY UNA FILA SELECCIONADA");
        } else {
            campoid.disable();
            checkCancellDelete.setEnabled(false);
            ids = Integer.parseInt((String) tablaseccion.getValueAt(fila, 0).toString());
            String codigo = (String) tablaseccion.getValueAt(fila, 1);
            String nombre = (String) tablaseccion.getValueAt(fila, 2);
            String descripcion = (String) tablaseccion.getValueAt(fila, 3);

            campoid.setText("" + ids);
            txtcodigo.setText(codigo);
            txtnombrezona.setText(nombre);
            txtdesc.setText(descripcion);
            enableCheck();
        }
    }//GEN-LAST:event_tablaseccionMouseClicked

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        } else {
            if (txtcodigo.getText().length() >= 6) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void checkFiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkFiltroMouseClicked
        if (checkFiltro.isSelected()) {
            ModeloSeccion.getTablaElimado();
        } else {
            ModeloSeccion.getTabla();
            checkCancellDelete.setEnabled(false);
        }
    }//GEN-LAST:event_checkFiltroMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        BuscarID();
    }//GEN-LAST:event_txtBuscarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnactualizar;
    private javax.swing.JPanel btnagregar;
    private javax.swing.JPanel btnbuscar;
    private javax.swing.JPanel btneliminar;
    private javax.swing.JLabel btnlabeagregar;
    private javax.swing.JLabel btnlabelactualizar;
    private javax.swing.JLabel btnlabelbuscar;
    private javax.swing.JLabel btnlabeleliminar;
    private javax.swing.JLabel btnlabellimpiar;
    private javax.swing.JLabel btnlabelvolver;
    private javax.swing.JPanel btnlimpiar;
    private javax.swing.JPanel btnrvolver;
    private javax.swing.JLabel campoid;
    private javax.swing.JCheckBox checkCancellDelete;
    private javax.swing.JCheckBox checkFiltro;
    private javax.swing.JComboBox<Categoria> combogenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel labelcod;
    private javax.swing.JLabel labeldesc;
    private javax.swing.JLabel labelid;
    private javax.swing.JLabel labellibro;
    private javax.swing.JLabel labelnomb;
    private javax.swing.JLabel labelnomb1;
    public static javax.swing.JTable tablaseccion;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtnombrezona;
    // End of variables declaration//GEN-END:variables

    private void BuscarID() {
       try {
            String buscar = txtBuscar.getText();
            if (!buscar.isEmpty()) {
                Seccion seccion = new Seccion();
                seccion.setCodigo_zona("%" + buscar + "%");
                if (ms.ConsultarSeccion(seccion)) {
                    ModeloSeccion.getTablaConsultaCod(seccion);
                    LimpiarCampos();
                }
            } else {
                ModeloCategoria.getTabla();
            }
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            System.out.println(e);
        }

    }
}
