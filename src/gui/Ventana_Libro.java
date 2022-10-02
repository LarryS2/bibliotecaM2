package gui;

import Modelo.ModeloAutores;
import Modelo.ModeloDewey;
import Modelo.ModeloEditorial;
import Modelo.ModeloLibro;
import Modelo.ModeloSeccion;
import Modelo.Modeloidioma;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Graphics2D;
import java.sql.Date;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logico.Autor;
import logico.Dewey;
import logico.Editorial;
import logico.Ejemplar;
import logico.Idioma;
import logico.Libro;
import logico.Seccion;

/**
 *
 * @author Fiction
 */
public final class Ventana_Libro extends javax.swing.JFrame {

    /**
     * Creates new form Libro
     */
    ModeloLibro ml = new ModeloLibro();
    int idl;

    public Ventana_Libro() {
        initComponents();
        AddHelp();
        llenarAutor();
        llenarDewey();
        llenarSeccion();
        llenarIdioma();
        llenarEditorial();
        ModeloLibro.getTabla();
    }

    public final void AddHelp() {
        txtcodigo.setToolTipText("Un código de 13 dígitos");
        txttitulo.setToolTipText("Título de la obra");
        comboAutor.setToolTipText("Elija el nombre del autor de la obra");
        txtisbn.setToolTipText("El ISBN de la obra deberá ser de 13 dígitos (Generalmente está inscrito en las primeras hojas)");
        combodewey.setToolTipText("El Dewey referencia la categoría del libro");
        txtpags.setToolTipText("El rango de es de 10 a 9999");
        comboeditorial.setToolTipText("Elija el nombre de la editorial del libro");
        txtareadescripcion.setToolTipText("Un breve resumen del contenido del libro (Opcional)");
    }

    public void llenarEditorial() {
        ModeloEditorial modedi = new ModeloEditorial();
        ArrayList<Editorial> listaedi = modedi.getEditorial();
        comboeditorial.removeAllItems();
        for (int i = 0; i < listaedi.size(); i++) {
            comboeditorial.addItem(new Editorial(listaedi.get(i).getId(), listaedi.get(i).getNombre()));
        }
    }

    public void llenarDewey() {
        ModeloDewey modde = new ModeloDewey();
        ArrayList<Dewey> listadew = modde.getDewey();
        combodewey.removeAllItems();
        for (int i = 0; i < listadew.size(); i++) {
            combodewey.addItem(new Dewey(listadew.get(i).getId(), listadew.get(i).getNombre_super_cat()));
        }
    }

    public void llenarSeccion() {
        ModeloSeccion modsec = new ModeloSeccion();
        ArrayList<Seccion> listcat = modsec.getSeccion();
        comboSeccion.removeAllItems();
        for (int i = 0; i < listcat.size(); i++) {
            comboSeccion.addItem(new Seccion(listcat.get(i).getId(), listcat.get(i).getNombre_zona()));
        }
    }

    public void llenarIdioma() {
        Modeloidioma modidioma = new Modeloidioma();
        ArrayList<Idioma> listaIdiomas = modidioma.getIdioma();
        comboidioma.removeAllItems();
        for (int i = 0; i < listaIdiomas.size(); i++) {
            comboidioma.addItem(new Idioma(listaIdiomas.get(i).getId_idioma(), listaIdiomas.get(i).getNombre_idioma()));
        }
    }

    public void llenarAutor() {
        ModeloAutores modaut = new ModeloAutores();
        ArrayList<Autor> listAutores = modaut.getAutor();

        for (int i = 0; i < listAutores.size(); i++) {
            comboAutor.addItem(new Autor(listAutores.get(i).getId_autor(), listAutores.get(i).getPrimer_nombre(), listAutores.get(i).getPrimer_apellido()));
        }
    }

    public void Agregar() {
        try {
            Libro libro = new Libro();
            String codigo = txtcodigo.getText().trim();
            String titulo = txttitulo.getText().trim();
            String descripcion = txtareadescripcion.getText().trim();
            String ISBN = txtisbn.getText().trim();
            int dewey = combodewey.getItemAt(combodewey.getSelectedIndex()).getId();
            String fecha_pub = ((JTextField) fecha_publi_chooser.getDateEditor().getUiComponent()).getText();
            int num_pags = Integer.parseInt(txtpags.getText().trim());
            int idioma = comboidioma.getItemAt(comboidioma.getSelectedIndex()).getId_idioma();
            Seccion seccion = comboSeccion.getItemAt(comboSeccion.getSelectedIndex());
            int editorial = comboeditorial.getItemAt(comboeditorial.getSelectedIndex()).getId();
            int autor = comboAutor.getItemAt(comboAutor.getSelectedIndex()).getId();
            boolean estado = false;

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "EL CÓDIGO ES OBLIGATORIO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            } else {
                if (titulo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "EL TÍTULO DEL LIBRO ES OBLIGATORIO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (ISBN.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "EL ISBN ES OBLIGATORIO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (libro.ValidarTitulo(titulo) == false) {
                            JOptionPane.showMessageDialog(null, "TÍTULO NO VÁLIDO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        } else {
                            if (num_pags < 10 || num_pags > 9999) {
                                JOptionPane.showMessageDialog(null, "NÚMERO DE PÁGINAS NO VÁLIDO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                            } else {
                                //REVISAR LA VALIDACIÓN DEL ISBN
                                libro.setCodigo(codigo);
                                libro.setTitulo(titulo);
                                libro.setDescripcion(descripcion);
                                libro.setIsbn(ISBN);
                                libro.setDewey(dewey);
                                libro.setFecha_Publicacion(Date.valueOf(fecha_pub));
                                libro.setNumero_pags(num_pags);
                                libro.setId_idioma(idioma);
                                libro.setId_seccion(seccion.getId());
                                libro.setId_editorial(editorial);
                                libro.setId_autor(autor);
                                libro.setEstado(estado);
                                if (!ml.RegistrarLibro(libro)) {
                                    registrarEjem();
                                    labelqrdes.setText("EL CÓDIGO QR DEL LIBRO ES:");
                                    QR();
                                    ModeloLibro.Limpiar_Tabla();
                                    ModeloLibro.getTabla();
                                    JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                                    LimpiarCampos();
                                } else {
                                    JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR EL LIBRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                                    ModeloLibro.Limpiar_Tabla();
                                    ModeloLibro.Limpiar_Tabla();
                                    ModeloLibro.getTabla();
                                }
                            }
                        }
                    }
                }
            }
        } catch (HeadlessException | IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    public void Modificar() {
        try {
            Libro libro = new Libro();
            int id = Integer.parseInt(labelidlibro.getText());
            String codigo = txtcodigo.getText().trim();
            String titulo = txttitulo.getText().trim();
            String descripcion = txtareadescripcion.getText().trim();
            String ISBN = txtisbn.getText().trim();
            int dewey = combodewey.getItemAt(combodewey.getSelectedIndex()).getId();
            String fecha_pub = ((JTextField) fecha_publi_chooser.getDateEditor().getUiComponent()).getText();
            int num_pags = Integer.parseInt(txtpags.getText().trim());
            int idioma = comboidioma.getItemAt(comboidioma.getSelectedIndex()).getId_idioma();
            Seccion seccion = comboSeccion.getItemAt(comboSeccion.getSelectedIndex());
            int editorial = comboeditorial.getItemAt(comboeditorial.getSelectedIndex()).getId();
            int autor = comboAutor.getItemAt(comboAutor.getSelectedIndex()).getId();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "EL CÓDIGO ES OBLIGATORIO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            } else {
                if (titulo.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "EL TÍTULO DEL LIBRO ES OBLIGATORIO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (libro.ValidarTitulo(titulo) == false) {
                        JOptionPane.showMessageDialog(null, "TÍTULO NO VÁLIDO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (num_pags < 10 || num_pags > 1000) {
                            JOptionPane.showMessageDialog(null, "NÚMERO DE PÁGINAS NO VÁLIDO", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        } else {
                            //REVISAR LA VALIDACIÓN DEL ISBN
                            libro.setId(id);
                            libro.setCodigo(codigo);
                            libro.setTitulo(titulo);
                            libro.setDescripcion(descripcion);
                            libro.setIsbn(ISBN);
                            libro.setDewey(dewey);
                            libro.setFecha_Publicacion(Date.valueOf(fecha_pub));
                            libro.setNumero_pags(num_pags);
                            libro.setId_idioma(idioma);
                            libro.setId_seccion(seccion.getId());
                            libro.setId_editorial(editorial);
                            libro.setId_autor(autor);
                            if (ml.ModificarLibro(libro)) {
                                labelqrdes.setText("EL CÓDIGO QR DEL LIBRO ES:");
                                QR();
                                ModeloLibro.Limpiar_Tabla();
                                ModeloLibro.getTabla();
                                JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS CON ÉXITO");
                                LimpiarCampos();
                            } else {
                                JOptionPane.showMessageDialog(null, "NO SE PUDO MODIFICAR EL LIBRO", "ERROR", JOptionPane.ERROR_MESSAGE);
                                ModeloLibro.Limpiar_Tabla();
                                ModeloLibro.getTabla();
                            }
                        }
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    public String generarNoSerie() {
        String serie = ml.NoSerie();
        String noserie;
        
        if (serie == null) {
            noserie = "0001";
        } else {
            int increment = Integer.parseInt(serie);
            increment++;
            noserie = "000" + increment;
        }
        return noserie;
    }

    public void registrarEjem() {
        try {
            Ejemplar ejem = new Ejemplar();
            int i = Integer.parseInt(txtnumEjem.getText().trim());
            System.out.println(i);
            int idl = ml.getIdMax();

            if (i == 0) {
                txtnumEjem.requestFocus();
                JOptionPane.showMessageDialog(null, "INGRESE EL NÚMERO DE EJEMPLARES EXISTENTES");
            } else {
                ejem.setCodigo(generarNoSerie());
                ejem.setCantidad(i);
                ejem.setCod_libro(idl);
                if(!ml.registrarEjemplar(ejem)){
                    JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                }else{
                    JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR");
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e);
        }
    }

    ///QR
    public void QR() {
        try {
            int size = 200;
            String FileType = "png";
            String FilePath = "";
            String codigo = txtcodigo.getText().trim();

            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                FilePath = chooser.getSelectedFile().getAbsolutePath();
            }

            UUID uid = UUID.randomUUID();
            String nombre = uid.toString();
            QRCodeWriter qrcode = new QRCodeWriter();

            try {
                BitMatrix matriz = qrcode.encode(codigo, BarcodeFormat.QR_CODE, size, size);
                File archivo = new File(FilePath + "/" + nombre + "." + FileType);
                int dimensionMatriz = matriz.getWidth();
                BufferedImage imagen = new BufferedImage(dimensionMatriz, dimensionMatriz, BufferedImage.TYPE_INT_BGR);
                imagen.createGraphics();

                Graphics2D qr = (Graphics2D) imagen.getGraphics();
                qr.setColor(Color.WHITE);
                qr.fillRect(0, 0, size, size);
                qr.setColor(Color.BLACK);

                for (int i = 0; i < dimensionMatriz; i++) {
                    for (int j = 0; j < dimensionMatriz; j++) {
                        if (matriz.get(i, j)) {
                            qr.fillRect(i, j, 1, 1);
                        }
                    }
                }

                //Imagen Generada
                ImageIO.write(imagen, FileType, archivo);
                Image MiQR = new ImageIcon(FilePath + "/" + nombre + "." + FileType).getImage();
                ImageIcon icon = new ImageIcon(MiQR.getScaledInstance(labelqr.getWidth(), labelqr.getHeight(), 0));
                labelqr.setIcon(icon);

            } catch (WriterException | IOException ex) {
                Logger.getLogger(Ventana_Libro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (HeadlessException e) {

        }
    }

    public void BusquedaDinamica() {
        try {
            String busqueda = txtbusqueda.getText().trim();
            ModeloLibro.Limpiar_Tabla();
            ModeloLibro.getTablaDinamica(busqueda);
        } catch (Exception e) {
        }
    }

    public void LimpiarCampos() {
        for (int i = 0; backround.getComponents().length > i; i++) {
            if (backround.getComponents()[i] instanceof JTextField) {
                ((JTextField) backround.getComponents()[i]).setText("");
            } else if (backround.getComponents()[i] instanceof JDateChooser) {
                ((JDateChooser) backround.getComponents()[i]).setCalendar(null);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        backround = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        labellibro = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        labelcod = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labeltitulo = new javax.swing.JLabel();
        txttitulo = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        labelautor = new javax.swing.JLabel();
        comboidioma = new javax.swing.JComboBox<>();
        labelidioma = new javax.swing.JLabel();
        labelgenero = new javax.swing.JLabel();
        comboSeccion = new javax.swing.JComboBox<>();
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
        txtnumEjem = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalibros = new javax.swing.JTable();
        labelisbn = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        labelfecha = new javax.swing.JLabel();
        btneliminar = new javax.swing.JPanel();
        btnlabeleliminar = new javax.swing.JLabel();
        comboeditorial = new javax.swing.JComboBox<>();
        comboAutor = new javax.swing.JComboBox<>();
        fecha_publi_chooser = new com.toedter.calendar.JDateChooser();
        labeldewey1 = new javax.swing.JLabel();
        txtpags = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        labelpags = new javax.swing.JLabel();
        labelid = new javax.swing.JLabel();
        labelidlibro = new javax.swing.JLabel();
        combodewey = new javax.swing.JComboBox<>();
        labelqrdes = new javax.swing.JLabel();
        labelqr = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        btnlabelbuscar = new javax.swing.JLabel();
        txtisbn = new javax.swing.JFormattedTextField();

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

        txtbusqueda.setBorder(null);
        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyReleased(evt);
            }
        });

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

        comboSeccion.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

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

        txtnumEjem.setBorder(null);
        txtnumEjem.setOpaque(false);

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
        tablalibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablalibros);
        if (tablalibros.getColumnModel().getColumnCount() > 0) {
            tablalibros.getColumnModel().getColumn(3).setResizable(false);
        }

        labelisbn.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelisbn.setForeground(new java.awt.Color(102, 102, 102));
        labelisbn.setText("ISBN:");

        labelfecha.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelfecha.setForeground(new java.awt.Color(102, 102, 102));
        labelfecha.setText("FECHA PUBLICACIÓN:");

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

        fecha_publi_chooser.setDateFormatString("yyyy-MM-dd");

        labeldewey1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeldewey1.setForeground(new java.awt.Color(102, 102, 102));
        labeldewey1.setText("DEWEY:");

        txtpags.setBorder(null);
        txtpags.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpagsKeyTyped(evt);
            }
        });

        labelpags.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelpags.setForeground(new java.awt.Color(102, 102, 102));
        labelpags.setText("Nº PÁGINAS:");

        labelid.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelid.setForeground(new java.awt.Color(102, 102, 102));
        labelid.setText("ID:");

        labelidlibro.setEnabled(false);

        labelqrdes.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelqrdes.setForeground(new java.awt.Color(102, 102, 102));

        labelqr.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtcodigo.setBorder(null);
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });

        btnlabelbuscar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelbuscar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelbuscar.setText("BUSCAR");
        btnlabelbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelbuscarMouseClicked(evt);
            }
        });

        txtisbn.setBorder(null);
        try {
            txtisbn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-##-###-####-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

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
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labeldewey1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addComponent(labelfecha)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fecha_publi_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(backroundLayout.createSequentialGroup()
                                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                                                        .addComponent(labelautor, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(6, 6, 6))
                                                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(labelcod, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labeltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(12, 12, 12))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backroundLayout.createSequentialGroup()
                                                .addComponent(labelisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator1)
                                            .addComponent(txttitulo)
                                            .addComponent(jSeparator2)
                                            .addComponent(comboAutor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtcodigo)
                                            .addComponent(txtisbn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(combodewey, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(backroundLayout.createSequentialGroup()
                                    .addComponent(labelgenero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(backroundLayout.createSequentialGroup()
                                    .addComponent(labelidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                        .addComponent(comboidioma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(backroundLayout.createSequentialGroup()
                                    .addComponent(labelpags)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtpags)))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labelid, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelidlibro, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                                .addComponent(btnlabelbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSeparator7)
                                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelqr, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                    .addComponent(txtnumEjem)
                                                    .addComponent(comboeditorial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(backroundLayout.createSequentialGroup()
                                            .addGap(101, 101, 101)
                                            .addComponent(labelqrdes, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(98, 98, 98)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnregistrolibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnmodificarlibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnrvolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        backroundLayout.setVerticalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backroundLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelidlibro, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnlabelbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labeleditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnregistrolibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelcod, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                    .addComponent(txtnumEjem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelautor1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnmodificarlibro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelautor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fecha_publi_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(combodewey, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labeldewey1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnrvolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelpags, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpags, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboidioma, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelidioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelgenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(104, 104, 104))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labeldescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelqrdes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelqr, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );

        jScrollPane3.setViewportView(backround);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlabelregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelregistroMouseClicked
        Agregar();
    }//GEN-LAST:event_btnlabelregistroMouseClicked


    private void btnlabelmodificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelmodificarMouseClicked
        Modificar();
    }//GEN-LAST:event_btnlabelmodificarMouseClicked

    private void btnlabelvolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelvolverMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnlabelvolverMouseClicked

    private void btnlabelbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelbuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlabelbuscarMouseClicked

    private void tablalibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalibrosMouseClicked
        try {
            int fila = tablalibros.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "NO HAY UNA FILA SELECCIONADA");
            } else {
                labelidlibro.disable();
                idl = Integer.parseInt((String) tablalibros.getValueAt(fila, 0).toString());
                String codigo = (String) tablalibros.getValueAt(fila, 1);
                String titulo = (String) tablalibros.getValueAt(fila, 2);
                String desc = (String) tablalibros.getValueAt(fila, 3);
                String isbn = (String) tablalibros.getValueAt(fila, 4);
                Dewey dewey = new Dewey();
                dewey.setNombre_super_cat((String) tablalibros.getValueAt(fila, 5).toString());
                Date fecha_p = Date.valueOf((String) tablalibros.getValueAt(fila, 6).toString());
                String desca = (String) tablalibros.getValueAt(fila, 7).toString();
                Idioma idi = new Idioma();
                Seccion sec = new Seccion();
                Autor aut = new Autor();
                Editorial edi = new Editorial();

                labelidlibro.setText("" + idl);
                txtcodigo.setText(codigo);
                txttitulo.setText(titulo);
                txtisbn.setText(isbn);
                combodewey.setSelectedItem(dewey);
                txtareadescripcion.setText(desc);
                fecha_publi_chooser.setDate(fecha_p);
                txtpags.setText(desca);
                
                idi.setNombre_idioma((String) tablalibros.getValueAt(fila, 9));
                String cadena = (String) tablalibros.getValueAt(fila, 8);
                String[] partes = cadena.split(" ");
                aut.setPrimer_nombre(partes[0]);
                edi.setNombre((String) tablalibros.getValueAt(fila, 10).toString());
                for (int i = 0; i < comboAutor.getMaximumRowCount(); i++) {
                    if (aut.getPrimer_nombre().equals(comboAutor.getItemAt(i).getPrimer_nombre())) {
                        comboAutor.setSelectedIndex(i);
                        i = comboAutor.getMaximumRowCount();
                    }
                }
                for (int i = 0; i < comboeditorial.getMaximumRowCount(); i++) {
                    if (edi.getNombre().equals(comboeditorial.getItemAt(i).getNombre())) {
                        comboeditorial.setSelectedIndex(i);
                        i = comboeditorial.getMaximumRowCount();
                    }
                }
                for (int i = 0; i < comboidioma.getMaximumRowCount(); i++) {
                    if (idi.getNombre_idioma().equals(comboidioma.getItemAt(i).getNombre_idioma())) {
                        comboidioma.setSelectedIndex(i);
                        i = comboidioma.getMaximumRowCount();
                    }
                }
                for (int i = 0; i < combodewey.getMaximumRowCount(); i++) {
                    if (dewey.getNombre_super_cat().equals(combodewey.getItemAt(i).getNombre_super_cat())) {
                        combodewey.setSelectedIndex(i);
                        i = combodewey.getMaximumRowCount();
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_tablalibrosMouseClicked

    private void txtpagsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpagsKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        } else {
            if (txtpags.getText().length() >= 4) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtpagsKeyTyped

    private void txtbusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyReleased
        BusquedaDinamica();
    }//GEN-LAST:event_txtbusquedaKeyReleased

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            evt.consume();
        } else {
            if (txtcodigo.getText().length() >= 13) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void btnlabeleliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeleliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlabeleliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backround;
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
    private javax.swing.JComboBox<Seccion> comboSeccion;
    private javax.swing.JComboBox<Dewey
    > combodewey;
    private javax.swing.JComboBox<Editorial> comboeditorial;
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
    private javax.swing.JLabel labelid;
    private javax.swing.JLabel labelidioma;
    private javax.swing.JLabel labelidlibro;
    private javax.swing.JLabel labelisbn;
    private javax.swing.JLabel labellibro;
    private javax.swing.JLabel labelpags;
    private javax.swing.JLabel labelqr;
    private javax.swing.JLabel labelqrdes;
    private javax.swing.JLabel labeltitulo;
    public static javax.swing.JTable tablalibros;
    private javax.swing.JTextArea txtareadescripcion;
    private javax.swing.JTextField txtbusqueda;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JFormattedTextField txtisbn;
    private javax.swing.JTextField txtnumEjem;
    private javax.swing.JTextField txtpags;
    private javax.swing.JTextField txttitulo;
    // End of variables declaration//GEN-END:variables
}
