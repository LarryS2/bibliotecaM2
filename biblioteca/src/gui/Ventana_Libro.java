package gui;

import Modelo.ModeloAutores;
import Modelo.ModeloCategoria;
import Modelo.Modeloidioma;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logico.Autor;
import logico.Categoria;
import logico.Idioma;
//import logico.ControladorLibro;
import logico.Libro;

/**
 *
 * @author Fiction
 */
public final class Ventana_Libro extends javax.swing.JFrame {

    /**
     * Creates new form Libro
     */
    public Ventana_Libro() {
        initComponents();
        //TablaLibros.setModel(model);
        llenarAutor();
        llenarIdioma();
        llenarCategoria();
    }

    public void llenarIdioma(){
        Modeloidioma modidioma = new Modeloidioma();
        ArrayList<Idioma> listaIdiomas = modidioma.getIdioma();
        
        for(int i = 0; i < listaIdiomas.size(); i++){
            comboidioma.addItem(new Idioma(listaIdiomas.get(i).getNombre_idioma()));
        }  
    }
    
    
    public void llenarAutor(){
        ModeloAutores modaut = new ModeloAutores();
        ArrayList<Autor> listAutores = modaut.getAutor();
        
        for(int i = 0; i < listAutores.size(); i++){
            comboAutor.addItem(new Autor(listAutores.get(i).getId_autor(), listAutores.get(i).getNombre_autor(),listAutores.get(i).getApellido_autor()));
        }  
    }
    
    public void llenarCategoria(){
        ModeloCategoria modcat = new ModeloCategoria();
        ArrayList<Categoria> listCategorias = modcat.getCategoria();
        
        for(int i = 0; i < listCategorias.size(); i++){
            combogenero.addItem(new Categoria(listCategorias.get(i).getId(), listCategorias.get(i).getNombre_cat()));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        backround = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        labellibro = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        labelcod = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labeltitulo = new javax.swing.JLabel();
        txttitulo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        labelautor = new javax.swing.JLabel();
        comboidioma = new javax.swing.JComboBox<>();
        labelidioma = new javax.swing.JLabel();
        labelgenero = new javax.swing.JLabel();
        combogenero = new javax.swing.JComboBox<>();
        labeleditorial = new javax.swing.JLabel();
        labeldescripcion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareadescripcion = new javax.swing.JTextArea();
        btnregistrolibro = new javax.swing.JPanel();
        btnlabelregistro = new javax.swing.JLabel();
        btnmodificarlibro = new javax.swing.JPanel();
        btnlabelmodificar = new javax.swing.JLabel();
        btnrvolver = new javax.swing.JPanel();
        btnlabelvolver = new javax.swing.JLabel();
        labelautor1 = new javax.swing.JLabel();
        txtautor1 = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalibros = new javax.swing.JTable();
        labelisbn = new javax.swing.JLabel();
        txtisbn = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        labelfecha = new javax.swing.JLabel();
        txtdewey = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        btneliminar = new javax.swing.JPanel();
        btnlabeleliminar = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JPanel();
        btnlabelbuscar = new javax.swing.JLabel();
        comboeditorial = new javax.swing.JComboBox<>();
        comboAutor = new javax.swing.JComboBox<>();
        fecha_publi_chooser = new com.toedter.calendar.JDateChooser();
        labeldewey1 = new javax.swing.JLabel();
        txtpags = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        labelpags = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backround.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        labellibro.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        labellibro.setForeground(new java.awt.Color(255, 255, 255));
        labellibro.setText("LIBROS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labellibro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(labellibro)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        txtcodigo.setBorder(null);

        labelcod.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelcod.setForeground(new java.awt.Color(102, 102, 102));
        labelcod.setText("CÓDIGO:");

        labeltitulo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeltitulo.setForeground(new java.awt.Color(102, 102, 102));
        labeltitulo.setText("TÍTULO:");

        txttitulo.setBorder(null);

        labelautor.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelautor.setForeground(new java.awt.Color(102, 102, 102));
        labelautor.setText("AUTOR:");

        comboidioma.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        comboidioma.setForeground(new java.awt.Color(255, 255, 255));
        comboidioma.setBorder(null);

        labelidioma.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelidioma.setForeground(new java.awt.Color(102, 102, 102));
        labelidioma.setText("IDIOMA:");

        labelgenero.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelgenero.setForeground(new java.awt.Color(102, 102, 102));
        labelgenero.setText("CATEGORÍA:");

        combogenero.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        labeleditorial.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeleditorial.setForeground(new java.awt.Color(102, 102, 102));
        labeleditorial.setText("EDITORIAL:");

        labeldescripcion.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeldescripcion.setForeground(new java.awt.Color(102, 102, 102));
        labeldescripcion.setText("DESCRIPCIÓN:");

        txtareadescripcion.setColumns(20);
        txtareadescripcion.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtareadescripcion.setRows(5);
        jScrollPane2.setViewportView(txtareadescripcion);

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

        labelautor1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelautor1.setForeground(new java.awt.Color(102, 102, 102));
        labelautor1.setText("Nº EJEMPLARES:");

        txtautor1.setBorder(null);

        tablalibros.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablalibros);
        if (tablalibros.getColumnModel().getColumnCount() > 0) {
            tablalibros.getColumnModel().getColumn(3).setResizable(false);
        }

        labelisbn.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelisbn.setForeground(new java.awt.Color(102, 102, 102));
        labelisbn.setText("ISBN:");

        txtisbn.setBorder(null);
        txtisbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtisbnActionPerformed(evt);
            }
        });

        labelfecha.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelfecha.setForeground(new java.awt.Color(102, 102, 102));
        labelfecha.setText("FECHA PUBLICACIÓN:");

        txtdewey.setBorder(null);

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

        comboeditorial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR" }));

        fecha_publi_chooser.setDateFormatString("yyyy-MM-dd");

        labeldewey1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeldewey1.setForeground(new java.awt.Color(102, 102, 102));
        labeldewey1.setText("DEWEY:");

        txtpags.setBorder(null);

        labelpags.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelpags.setForeground(new java.awt.Color(102, 102, 102));
        labelpags.setText("Nº PÁGINAS:");

        javax.swing.GroupLayout backroundLayout = new javax.swing.GroupLayout(backround);
        backround.setLayout(backroundLayout);
        backroundLayout.setHorizontalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboidioma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(combogenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                                        .addComponent(labelautor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelcod, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labeltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1)
                                    .addComponent(txtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(txttitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(jSeparator2)
                                    .addComponent(comboAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labelfecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fecha_publi_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labeldewey1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtisbn)
                                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtdewey)
                                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                                .addComponent(labelpags)
                                .addGap(15, 15, 15)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator8)
                                    .addComponent(txtpags, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
                                .addGap(1, 1, 1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)))
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backroundLayout.createSequentialGroup()
                            .addComponent(labeldescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelautor1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labeleditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtautor1)
                            .addComponent(comboeditorial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(116, 116, 116)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnregistrolibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmodificarlibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnrvolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        backroundLayout.setVerticalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backroundLayout.createSequentialGroup()
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelcod, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labeleditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnregistrolibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txttitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labeltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtautor1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelautor1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnmodificarlibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labeldescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labeldewey1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnrvolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelautor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtdewey, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_publi_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpags, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelpags, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelidioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combogenero, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelgenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );

        jScrollPane3.setViewportView(backround);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlabelregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelregistroMouseClicked
        Libro libro = new Libro();
        int codigo = Integer.parseInt(txtcodigo.getText().trim());
        String titulo = txttitulo.getText().trim();
        String autor = comboAutor.getSelectedItem().toString();
        String idioma = comboidioma.getSelectedItem().toString();
        String genero = combogenero.getSelectedItem().toString();
        String editorial = comboeditorial.getSelectedItem().toString();
        String descripcion = txtareadescripcion.getText().trim();
        
        if (titulo.isEmpty() || autor.isEmpty() || idioma.equalsIgnoreCase("SELECCIONAR") || 
                genero.equalsIgnoreCase("SELECCIONAR") || editorial.isEmpty() || descripcion.isEmpty() ) {
            
            JOptionPane.showMessageDialog(null, "TODAVÍA HAY CAMPOS SIN COMPLETAR");
        } else {
            if (libro.Validar_Nombre_Autor(autor)==false ||
                    libro.Validar_Editorial(editorial)==false) {
                JOptionPane.showMessageDialog(null, "HAY CAMPOS CON INFORMACIÓN NO VÁLIDA");
            } else {
                //if (libro.Validar_Codigo_Libro(codigo)==false) {
                    //JOptionPane.showMessageDialog(null, "EL CÓDIGO DEBE COMENZAR POR 0 Y DESPUÉS CONTENER 5 NÚMEROS DISNTINTOS DE ESTE");
                //} else {
                    if (Validar_no_Rep(codigo)) {                        
                        //libro.setCodigo(codigo);
                        libro.setTitulo(titulo);
                        libro.setId_autor(autor);
                        libro.setId_idioma(idioma);
                        libro.setId_categoria(genero);
                        libro.setId_editorial(editorial);
                        libro.setDescripcion(descripcion);
                       // ControladorLibro.listalibros.add(libro);
                        this.Vaciar_Campos();
                        JOptionPane.showMessageDialog(null, "LIBRO REGISTRADO CON ÉXITO");
                    }else{
                        JOptionPane.showMessageDialog(null, "YA EXISTE UN REGISTRO CON ESE CÓDIGO");
                    }
                //}
            }
        }  
    }//GEN-LAST:event_btnlabelregistroMouseClicked
    
    private boolean Validar_no_Rep(int id) {
        boolean rep=true;
//        if(ControladorLibro.listalibros.isEmpty()==false) {
//            for (int i = 0; i < ControladorLibro.listalibros.size(); i++) {
//                //if (id==(ControladorLibro.listalibros.get(i).getCodigo())) {
//                    JOptionPane.showMessageDialog(null, "YA EXISTE UN REGISTRO CON ESE CÓDIGO");
//                    rep = false;
//                    i = ControladorLibro.listalibros.size();
//                //}
//            }
//        } else {
//            rep = true;
//        }
        return rep;
    }
    
    public void Vaciar_Campos() {
        txtcodigo.setText("");
        txttitulo.setText("");
        //comboAutor.setSelectedItem("");
        comboidioma.setSelectedItem("SELECCIONAR");
        comboidioma.setSelectedItem("SELECCIONAR");
        comboeditorial.setSelectedItem("SELECCIONAR");
        txtareadescripcion.setText(""); 
    }
    private void btnlabelmodificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelmodificarMouseClicked
        
    }//GEN-LAST:event_btnlabelmodificarMouseClicked

    private void btnlabelvolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelvolverMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnlabelvolverMouseClicked

    private void btnlabeleliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeleliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlabeleliminarMouseClicked

    private void btnlabelbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelbuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlabelbuscarMouseClicked

    private void txtisbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtisbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtisbnActionPerformed

    
    
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
    private javax.swing.JComboBox<Autor> comboAutor;
    private javax.swing.JComboBox<String> comboeditorial;
    private javax.swing.JComboBox<Categoria> combogenero;
    private javax.swing.JComboBox<Idioma> comboidioma;
    private com.toedter.calendar.JDateChooser fecha_publi_chooser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel labelautor;
    private javax.swing.JLabel labelautor1;
    private javax.swing.JLabel labelcod;
    private javax.swing.JLabel labeldescripcion;
    private javax.swing.JLabel labeldewey1;
    private javax.swing.JLabel labeleditorial;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelgenero;
    private javax.swing.JLabel labelidioma;
    private javax.swing.JLabel labelisbn;
    private javax.swing.JLabel labellibro;
    private javax.swing.JLabel labelpags;
    private javax.swing.JLabel labeltitulo;
    private javax.swing.JTable tablalibros;
    private javax.swing.JTextArea txtareadescripcion;
    private javax.swing.JTextField txtautor1;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdewey;
    private javax.swing.JTextField txtisbn;
    private javax.swing.JTextField txtpags;
    private javax.swing.JTextField txttitulo;
    // End of variables declaration//GEN-END:variables
}
