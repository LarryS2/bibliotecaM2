package gui;

import Modelo.ModeloPais;
import Modelo.Modeloidioma;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logico.Idioma;
import logico.Pais;

public class Ventana_Idiomas extends javax.swing.JDialog {

    /**
     * Creates new form Ventana_Idiomas
     *
     * @param parent
     * @param modal
     */
    Modeloidioma mi = new Modeloidioma();
    int idi;
    public Ventana_Idiomas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Modeloidioma.getTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        backround = new javax.swing.JPanel();
        panelsuperior2 = new javax.swing.JPanel();
        labelidioma = new javax.swing.JLabel();
        labelcodidioma = new javax.swing.JLabel();
        txtcodigoidioma = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        labelnomidioma = new javax.swing.JLabel();
        txtnombreidioma = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIdiomas = new javax.swing.JTable();
        btnagregar = new javax.swing.JPanel();
        btnlabeagregar = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JPanel();
        btnlabelactualizar = new javax.swing.JLabel();
        btneliminar = new javax.swing.JPanel();
        btnlabeleliminar = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JPanel();
        btnlabellimpiar = new javax.swing.JLabel();
        btnrvolver = new javax.swing.JPanel();
        btnlabelvolver = new javax.swing.JLabel();
        txtdescidioma = new javax.swing.JTextField();
        labeldescidioma = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        labelid = new javax.swing.JLabel();
        labelididioma = new javax.swing.JLabel();
        checkFiltro = new javax.swing.JCheckBox();
        checkCancelDelete = new javax.swing.JCheckBox();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        backround.setBackground(new java.awt.Color(255, 255, 255));

        panelsuperior2.setBackground(new java.awt.Color(0, 153, 153));

        labelidioma.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        labelidioma.setForeground(new java.awt.Color(255, 255, 255));
        labelidioma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelidioma.setText("REGISTRAR IDIOMAS");

        javax.swing.GroupLayout panelsuperior2Layout = new javax.swing.GroupLayout(panelsuperior2);
        panelsuperior2.setLayout(panelsuperior2Layout);
        panelsuperior2Layout.setHorizontalGroup(
            panelsuperior2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuperior2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelidioma)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelsuperior2Layout.setVerticalGroup(
            panelsuperior2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuperior2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(labelidioma)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        labelcodidioma.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelcodidioma.setForeground(new java.awt.Color(102, 102, 102));
        labelcodidioma.setText("CÓDIGO:");

        txtcodigoidioma.setBorder(null);
        txtcodigoidioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoidiomaKeyTyped(evt);
            }
        });

        labelnomidioma.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelnomidioma.setForeground(new java.awt.Color(102, 102, 102));
        labelnomidioma.setText("NOMBRE IDIOMA:");

        txtnombreidioma.setBorder(null);
        txtnombreidioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreidiomaKeyTyped(evt);
            }
        });

        tablaIdiomas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaIdiomas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaIdiomas.getTableHeader().setReorderingAllowed(false);
        tablaIdiomas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaIdiomasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaIdiomas);

        btnagregar.setBackground(new java.awt.Color(0, 153, 153));

        btnlabeagregar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabeagregar.setForeground(new java.awt.Color(255, 255, 255));
        btnlabeagregar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabeagregar.setText("AGREGAR");
        btnlabeagregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        btnlabelactualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        btnlimpiar.setBackground(new java.awt.Color(0, 153, 153));

        btnlabellimpiar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabellimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlabellimpiar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabellimpiar.setText("LIMPIAR");
        btnlabellimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        txtdescidioma.setBorder(null);
        txtdescidioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescidiomaKeyTyped(evt);
            }
        });

        labeldescidioma.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeldescidioma.setForeground(new java.awt.Color(102, 102, 102));
        labeldescidioma.setText("DESCRIPCIÓN IDIOMA:");

        labelid.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelid.setForeground(new java.awt.Color(102, 102, 102));
        labelid.setText("ID:");

        labelididioma.setEnabled(false);

        checkFiltro.setText("FILTRAR ELIMINADOS");
        checkFiltro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkFiltroMouseClicked(evt);
            }
        });

        checkCancelDelete.setText("CANCELAR ELIMINACIÓN");
        checkCancelDelete.setEnabled(false);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lupa (2).png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar idioma:");

        javax.swing.GroupLayout backroundLayout = new javax.swing.GroupLayout(backround);
        backround.setLayout(backroundLayout);
        backroundLayout.setHorizontalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelsuperior2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labeldescidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdescidioma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(checkCancelDelete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelcodidioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelnomidioma, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(backroundLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(txtnombreidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                                    .addComponent(txtcodigoidioma, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                                    .addComponent(labelididioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addGap(122, 122, 122)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(checkFiltro)
                                            .addComponent(jLabel1)))))
                            .addComponent(labelid, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnagregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnrvolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        backroundLayout.setVerticalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backroundLayout.createSequentialGroup()
                .addComponent(panelsuperior2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnrvolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelid, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(labelididioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodigoidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelcodidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(checkFiltro)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtnombreidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelnomidioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtdescidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labeldescidioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(checkCancelDelete)))))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        jScrollPane2.setViewportView(backround);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void enableCheck(){
        checkCancelDelete.setEnabled(false);
        
        try{
            Modeloidioma modi = new Modeloidioma();
            ArrayList<Idioma> listaIdioma = modi.getIdiomaEliminado();
            int id = Integer.parseInt(labelididioma.getText().trim());
            
            for(int i = 0; i < listaIdioma.size(); i++){
                if(id == listaIdioma.get(i).getId_idioma()){
                    checkCancelDelete.setEnabled(true);
                    i = listaIdioma.size();
                }
            }
        }catch(NumberFormatException |NullPointerException e){
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA DE LA TABLA");
        }
    }
    public void BuscarID() {
        try {
            String buscar = txtBuscar.getText();
            if(!buscar.isEmpty()){
                Idioma idioma = new Idioma();
                idioma.setCodigo_idioma("%"+buscar+"%");
                if (mi.BuscarIdioma(idioma)) {
                    Modeloidioma.getTablaConsultaCodigoIdioma(idioma);
                    LimpiarCampos();
                }
            }else{
                Modeloidioma.getTabla();
            }
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            System.out.println(e);
        }
    }
    
    public void Agregar() {
        try {
            Idioma idioma = new Idioma();
            String codigo = txtcodigoidioma.getText().trim();
            String nombre = txtnombreidioma.getText().trim();
            String descripcion = txtdescidioma.getText().trim();

            if (codigo.isEmpty() || nombre.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            } else {
                if (idioma.ValidarNombre(nombre) == false) {
                    JOptionPane.showMessageDialog(null, "NOMBRE NO VÁLIDO");
                } else {
                    if (idioma.ValidarDesc(descripcion) == false) {
                        JOptionPane.showMessageDialog(null, "DESCRIPCIÓN NO VÁLIDA");
                    } else {
                        idioma.setCodigo_idioma(codigo);
                        idioma.setNombre_idioma(nombre);
                        idioma.setDescripcion(descripcion);
                        if (mi.RegistrarIdioma(idioma)) {
                            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                            Modeloidioma.Limpiar_Tabla();
                            Modeloidioma.getTabla();
                            LimpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR EL IDIOMA");
                            Modeloidioma.Limpiar_Tabla();
                            Modeloidioma.getTabla();
                        }
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
        }
    }

    public void Modificar() {
        try {
            Idioma idioma = new Idioma();
            int id = Integer.parseInt(labelididioma.getText().trim());
            String codigo = txtcodigoidioma.getText().trim();
            String nombre = txtnombreidioma.getText().trim();
            String descripcion = txtdescidioma.getText().trim();

            if (codigo.isEmpty() || nombre.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            } else {
                if (idioma.ValidarNombre(nombre) == false) {
                    JOptionPane.showMessageDialog(null, "NOMBRE NO VÁLIDO");
                } else {
                    if (idioma.ValidarDesc(descripcion) == false) {
                        JOptionPane.showMessageDialog(null, "DESCRIPCIÓN NO VÁLIDA");
                    } else {
                        idioma.setCodigo_idioma(codigo);
                        idioma.setId_idioma(id);
                        idioma.setNombre_idioma(nombre);
                        idioma.setDescripcion(descripcion);
                        if (mi.ActualizarIdioma(idioma)) {
                            JOptionPane.showMessageDialog(null, "MODFICACIÓN EXITOSA");
                            Modeloidioma.getTabla();
                            LimpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL IDIOMA");
                        }
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA DE LA TABLA");
        }
    }
    
    public void ModificarEliminado() {
        try {
            Idioma idioma = new Idioma();
            int id = Integer.parseInt(labelididioma.getText().trim());
            String codigo = txtcodigoidioma.getText().trim();
            String nombre = txtnombreidioma.getText().trim();
            String descripcion = txtdescidioma.getText().trim();
            boolean bo1;
            bo1 = !checkCancelDelete.isSelected();

            if (codigo.isEmpty() || nombre.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "LLENE TODOS LOS CAMPOS");
            } else {
                if (idioma.ValidarNombre(nombre) == false) {
                    JOptionPane.showMessageDialog(null, "NOMBRE NO VÁLIDO");
                } else {
                    if (idioma.ValidarDesc(descripcion) == false) {
                        JOptionPane.showMessageDialog(null, "DESCRIPCIÓN NO VÁLIDA");
                    } else {
                        idioma.setCodigo_idioma(codigo);
                        idioma.setId_idioma(id);
                        idioma.setNombre_idioma(nombre);
                        idioma.setDescripcion(descripcion);
                        idioma.setEstado(bo1);
                        if (mi.ActualizarIdiomaEliminado(idioma)) {
                            JOptionPane.showMessageDialog(null, "MODFICACIÓN EXITOSA");
                            Modeloidioma.getTablaEliminado();
                            LimpiarCampos();
                        } else {
                            JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL IDIOMA");
                        }
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA DE LA TABLA");
        }
    }

    public void Eliminar() {
        try {
            Idioma idioma = new Idioma();
            int id = Integer.parseInt(labelididioma.getText().trim());

            idioma.setId_idioma(id);
            if (mi.EliminarIdioma(idioma)) {
                JOptionPane.showMessageDialog(null, "ELIMINACIÓN EXITOSA");
                Modeloidioma.getTabla();
                LimpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "NO SE PUDO ELIMINAR EL IDIOMA");
            }
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA DE LA TABLA");
        }
    }
    
    public void LimpiarCampos() {
        labelididioma.setText(null);
        txtcodigoidioma.setText(null);
        txtdescidioma.setText(null);
        txtnombreidioma.setText(null);
        checkCancelDelete.setSelected(false);
    }
    
    private void txtcodigoidiomaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoidiomaKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        } else {
            if (txtcodigoidioma.getText().length() >= 3) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtcodigoidiomaKeyTyped

    private void txtnombreidiomaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreidiomaKeyTyped
        char validar = evt.getKeyChar();
        if (!Character.isLetter(validar)) {
            evt.consume();
        } else {
            if (txtnombreidioma.getText().length() >= 50) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtnombreidiomaKeyTyped
        
    private void btnlabeagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeagregarMouseClicked
        Agregar();
        LimpiarCampos();
    }//GEN-LAST:event_btnlabeagregarMouseClicked


    private void btnlabelactualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelactualizarMouseClicked
        if(!checkFiltro.isSelected()){
            Modificar();
            LimpiarCampos();
        }else{
            ModificarEliminado();
            LimpiarCampos();
        }
    }//GEN-LAST:event_btnlabelactualizarMouseClicked

    private void btnlabeleliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeleliminarMouseClicked
        if(!checkFiltro.isSelected()){
            Eliminar();
        }else{
            JOptionPane.showMessageDialog(null, "NO SE PUEDE ELIMINAR ESTANDO ACTIVO EL FILTRO DE ELIMINADOS");
        }
    }//GEN-LAST:event_btnlabeleliminarMouseClicked

    private void btnlabellimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabellimpiarMouseClicked
        LimpiarCampos();
        Modeloidioma.Limpiar_Tabla();
        Modeloidioma.getTabla();
    }//GEN-LAST:event_btnlabellimpiarMouseClicked

    private void btnlabelvolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelvolverMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnlabelvolverMouseClicked

    private void txtdescidiomaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescidiomaKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isDigit(validar)){
            evt.consume();
        }else{
            if(txtdescidioma.getText().length() >= 120){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtdescidiomaKeyTyped

    private void tablaIdiomasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIdiomasMouseClicked
        int fila = tablaIdiomas.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "NO HAY UNA FILA SELECCIONADA");
        } else {
            labelcodidioma.disable();
            checkCancelDelete.setEnabled(false);
            idi = Integer.parseInt((String) tablaIdiomas.getValueAt(fila, 0).toString());
            String codigo = (String) tablaIdiomas.getValueAt(fila, 1);
            String nombre = (String) tablaIdiomas.getValueAt(fila, 2);
            String descripcion = (String) tablaIdiomas.getValueAt(fila, 3);

            labelididioma.setText("" + idi);
            txtcodigoidioma.setText(codigo);
            txtnombreidioma.setText(nombre);
            txtdescidioma.setText(descripcion);
            enableCheck();
        }
    }//GEN-LAST:event_tablaIdiomasMouseClicked

    private void checkFiltroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkFiltroMouseClicked
        if(checkFiltro.isSelected()){
            Modeloidioma.getTablaEliminado();
            LimpiarCampos();
        }else{
            Modeloidioma.getTabla();
            checkCancelDelete.setEnabled(false);
            LimpiarCampos();
        }
    }//GEN-LAST:event_checkFiltroMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        BuscarID();
    }//GEN-LAST:event_txtBuscarKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backround;
    private javax.swing.JPanel btnactualizar;
    private javax.swing.JPanel btnagregar;
    private javax.swing.JPanel btneliminar;
    private javax.swing.JLabel btnlabeagregar;
    private javax.swing.JLabel btnlabelactualizar;
    private javax.swing.JLabel btnlabeleliminar;
    private javax.swing.JLabel btnlabellimpiar;
    private javax.swing.JLabel btnlabelvolver;
    private javax.swing.JPanel btnlimpiar;
    private javax.swing.JPanel btnrvolver;
    private javax.swing.JCheckBox checkCancelDelete;
    private javax.swing.JCheckBox checkFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelcodidioma;
    private javax.swing.JLabel labeldescidioma;
    private javax.swing.JLabel labelid;
    private javax.swing.JLabel labelididioma;
    private javax.swing.JLabel labelidioma;
    private javax.swing.JLabel labelnomidioma;
    private javax.swing.JPanel panelsuperior2;
    public static javax.swing.JTable tablaIdiomas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtcodigoidioma;
    private javax.swing.JTextField txtdescidioma;
    private javax.swing.JTextField txtnombreidioma;
    // End of variables declaration//GEN-END:variables
}
