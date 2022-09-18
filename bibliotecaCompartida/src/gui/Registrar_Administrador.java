/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Modelo.ModeloBibliotecario;
import Modelo.ModeloHorario;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logico.Bibliotecario;
import logico.Horario;

/**
 *
 * @author Fiction
 */
public final class Registrar_Administrador extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    ModeloBibliotecario mb = new ModeloBibliotecario();
    int idb;
    public Registrar_Administrador() {
        initComponents();
        btnlabeagregar.disable();
        llenarHorario();
        ModeloBibliotecario.getTabla();
    }
    
    public void llenarHorario(){
        ModeloHorario modho = new ModeloHorario();
        ArrayList<Horario> listaedi = modho.getHorario();
        combohorario.removeAllItems();
        for(int i = 0; i < listaedi.size(); i++){
            combohorario.addItem(new Horario(listaedi.get(i).getId()));
        }  
    }
    
    public void Registro(){
        try{
            String tipo = combotipouser.getSelectedItem().toString();
            if(!tipo.equalsIgnoreCase("SELECCIONAR")){
                if(tipo.equalsIgnoreCase("BIBLIOTECARIO")){
                    btnlabeagregar.enable();
                    btnagregar.setBackground(new Color(0, 153, 153));
                    Bibliotecario bibliotecario = new Bibliotecario();
                    String cedula = txtcedula.getText().trim();
                    String nombre_pr = txtnombre.getText().trim();
                    String nombre_se = txtnombresegundo.getText().trim();
                    String apellido_pr = txtapellido.getText().trim();
                    String apellido_se = txtapellidosegundo.getText().trim();
                    String email = txtemail.getText().trim();
                    String fecha_nac = ((JTextField) fecha_nac_chooser.getDateEditor().getUiComponent()).getText();
                    String telefono = txttelefono.getText().trim();
                    String direccion = txtdireccion.getText().trim();
                    boolean estado = true;

                    String gen = "";
                    if(radiomasculino.isSelected()){
                        gen = "M";
                    }
                    else {
                        if(radiofemenino.isSelected()){
                            gen = "F";
                        }
                    }
                    String tipo_sangre = combotiposangre.getSelectedItem().toString();
                    String password = txtpassword.getText().trim();
                    String password_rep = txtpasswordrep.getText().trim();

                    String tipo_user = combotipouser.getSelectedItem().toString();

                    if (cedula.isEmpty() ||  nombre_pr.isEmpty() || apellido_pr.isEmpty() || 
                        email.isEmpty() || telefono.isEmpty() || fecha_nac.isEmpty() || gen.isEmpty() ||
                        password.isBlank()) {
                            JOptionPane.showMessageDialog(null, "RELLENE TODOS LOS CAMPOS");

                    } else {
                        if(tipo_sangre.equalsIgnoreCase("SELECCIONAR")) {
                            JOptionPane.showMessageDialog(null, "SELECCIONE UN TIPO DE SANGRE");
                        } else {
                            if(tipo_user.equalsIgnoreCase("SELECCIONAR")){
                                JOptionPane.showMessageDialog(null, "SELECCIONE EL ROL DEL USUARIO");
                            } else{
                                if (bibliotecario.ValidarNombreYapellido(nombre_pr)==false || bibliotecario.ValidarNombreYapellido(apellido_pr)==false
                                        || bibliotecario.ValidarCorreo(email)==false || bibliotecario.ValidarTelefono(telefono)==false || bibliotecario.Validar_fecha(fecha_nac)) {
                                    JOptionPane.showMessageDialog(null, "HAY CAMPOS CON INFORMACIÓN NO VÁLIDA");
                                } else {
                                    if(bibliotecario.ValidarCedula(cedula)){
                                        if (bibliotecario.ValidarPassword(password)==false) {
                                            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres, que incluyen una letra en minúscula, una en mayúscula y números, no contiene símbolos especiales");
                                        } else {
                                            if(password.equals(password_rep)){
                                                bibliotecario.setCedula(cedula);
                                                bibliotecario.setPrimer_nombre(nombre_pr);
                                                bibliotecario.setSegundo_nombre(nombre_se);
                                                bibliotecario.setPrimer_apellido(apellido_pr);
                                                bibliotecario.setSegundo_apellido(apellido_se);
                                                bibliotecario.setEmail(email);
                                                bibliotecario.setDireccion(direccion);
                                                bibliotecario.setTelefono(telefono);
                                                bibliotecario.setFecha_nac(java.sql.Date.valueOf(fecha_nac));            
                                                bibliotecario.setGenero(gen);
                                                bibliotecario.setTipo_sangre(tipo_sangre);
                                                bibliotecario.setTipo_usuario(tipo_user);
                                                bibliotecario.setPassword(password);
                                                bibliotecario.setEstado(estado); 
                                                if(mb.RegistrarBibliotecario(bibliotecario)){
                                                    ModeloBibliotecario.Limpiar_Tabla();
                                                    ModeloBibliotecario.getTabla();
                                                    Vaciar_Campos();
                                                    JOptionPane.showMessageDialog(null, "REGISTRO COMPLETADO");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR");
                                                    ModeloBibliotecario.Limpiar_Tabla();
                                                    ModeloBibliotecario.getTabla();
                                                }
                                            }else{                                        
                                                JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
                                            }
                                        }
                                    }else {
                                        JOptionPane.showMessageDialog(null, "EL NÚMERO DE CÉDULA NO ES VÁLIDO");
                                    }
                                }
                            }
                        } 
                    }
                } else {
                    Registrarse reg = new Registrarse(null, false);
                    reg.Registro();
                }
            } else {
                btnlabeagregar.disable();
                btnagregar.setBackground(new Color(0, 140, 140));
            }
            }catch(HeadlessException e){

            }
    }
    
    

    public void Vaciar_Campos() {
        txtcedula.setText("");
        txtnombre.setText("");
        txtnombresegundo.setText("");
        txtapellido.setText("");
        txtapellidosegundo.setText("");
        txtemail.setText("");
        txttelefono.setText("");
        fecha_nac_chooser.setDateFormatString("");
        this.grupogenero.clearSelection();
        combotiposangre.setSelectedItem("SELECCIONAR");
        txtpassword.setText("");
        txtdireccion.setText("");
        txtpasswordrep.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupogenero = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        backround = new javax.swing.JPanel();
        labelced = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtnombre = new javax.swing.JTextField();
        labelnom = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelape = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        labelmail = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        labeltel = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        labelfecha = new javax.swing.JLabel();
        fecha_nac_chooser = new com.toedter.calendar.JDateChooser();
        labeltel1 = new javax.swing.JLabel();
        radiomasculino = new javax.swing.JRadioButton();
        radiofemenino = new javax.swing.JRadioButton();
        labeltiposa = new javax.swing.JLabel();
        combotiposangre = new javax.swing.JComboBox<>();
        labeltiposa1 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        labeltiposa2 = new javax.swing.JLabel();
        txtpasswordrep = new javax.swing.JPasswordField();
        labeltipouser = new javax.swing.JLabel();
        combotipouser = new javax.swing.JComboBox<>();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        panelsuperior = new javax.swing.JPanel();
        labelreg = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPersona = new javax.swing.JTable();
        btnrvolver = new javax.swing.JPanel();
        btnlabelvolver = new javax.swing.JLabel();
        labelnomsegundo = new javax.swing.JLabel();
        txtnombresegundo = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        labelapesegundo = new javax.swing.JLabel();
        txtapellidosegundo = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        txtdireccion = new javax.swing.JTextField();
        labeldire = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        btnagregar = new javax.swing.JPanel();
        btnlabeagregar = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JPanel();
        btnlabelactualizar = new javax.swing.JLabel();
        btneliminar = new javax.swing.JPanel();
        btnlabeleliminar = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JPanel();
        btnlabelbuscar = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JPanel();
        btnlabellimpiar = new javax.swing.JLabel();
        labelhorario = new javax.swing.JLabel();
        combohorario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backround.setBackground(new java.awt.Color(255, 255, 255));

        labelced.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelced.setForeground(new java.awt.Color(102, 102, 102));
        labelced.setText("CÉDULA:");

        txtcedula.setBorder(null);
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        txtnombre.setBorder(null);
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        labelnom.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelnom.setForeground(new java.awt.Color(102, 102, 102));
        labelnom.setText("NOMBRE:");

        labelape.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelape.setForeground(new java.awt.Color(102, 102, 102));
        labelape.setText("APELLIDO:");

        txtapellido.setBorder(null);
        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });

        labelmail.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelmail.setForeground(new java.awt.Color(102, 102, 102));
        labelmail.setText("EMAIL:");

        txtemail.setBorder(null);
        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtemailKeyTyped(evt);
            }
        });

        labeltel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeltel.setForeground(new java.awt.Color(102, 102, 102));
        labeltel.setText("TELÉFONO:");

        txttelefono.setBorder(null);
        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        labelfecha.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelfecha.setForeground(new java.awt.Color(102, 102, 102));
        labelfecha.setText("FECHA DE NACIMIENTO:");

        fecha_nac_chooser.setDateFormatString("yyyy-MM-dd");
        fecha_nac_chooser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fecha_nac_chooserKeyTyped(evt);
            }
        });

        labeltel1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeltel1.setForeground(new java.awt.Color(102, 102, 102));
        labeltel1.setText("GÉNERO:");

        grupogenero.add(radiomasculino);
        radiomasculino.setText("Masculino");

        grupogenero.add(radiofemenino);
        radiofemenino.setText("Femenino");

        labeltiposa.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeltiposa.setForeground(new java.awt.Color(102, 102, 102));
        labeltiposa.setText("TIPO DE SANGRE:");

        combotiposangre.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        combotiposangre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", " A+", " O+", " B+", " AB+", " A-", " O-", " B-", " AB-" }));

        labeltiposa1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeltiposa1.setForeground(new java.awt.Color(102, 102, 102));
        labeltiposa1.setText("CONTRASEÑA:");

        txtpassword.setBorder(null);
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpasswordKeyTyped(evt);
            }
        });

        labeltiposa2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeltiposa2.setForeground(new java.awt.Color(102, 102, 102));
        labeltiposa2.setText("REPETIR CON..");

        txtpasswordrep.setBorder(null);
        txtpasswordrep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpasswordrepKeyTyped(evt);
            }
        });

        labeltipouser.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeltipouser.setForeground(new java.awt.Color(102, 102, 102));
        labeltipouser.setText("TIPO DE USUARIO:");

        combotipouser.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        combotipouser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "BIBLIOTECARIO", "INVITADO" }));

        panelsuperior.setBackground(new java.awt.Color(0, 153, 153));

        labelreg.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        labelreg.setForeground(new java.awt.Color(255, 255, 255));
        labelreg.setText("REGISTRO DE USUARIOS");

        javax.swing.GroupLayout panelsuperiorLayout = new javax.swing.GroupLayout(panelsuperior);
        panelsuperior.setLayout(panelsuperiorLayout);
        panelsuperiorLayout.setHorizontalGroup(
            panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuperiorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelreg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelsuperiorLayout.setVerticalGroup(
            panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuperiorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelreg)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tablaPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cédula", "Nombre", "Apellido", "Género", "Rol", "Fecha de nacimiento"
            }
        ));
        jScrollPane2.setViewportView(tablaPersona);

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

        labelnomsegundo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelnomsegundo.setForeground(new java.awt.Color(102, 102, 102));
        labelnomsegundo.setText("SEGUNDO NOMBRE:");

        txtnombresegundo.setBorder(null);
        txtnombresegundo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombresegundoKeyTyped(evt);
            }
        });

        labelapesegundo.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelapesegundo.setForeground(new java.awt.Color(102, 102, 102));
        labelapesegundo.setText("SEGUNDO APELLIDO:");

        txtapellidosegundo.setBorder(null);
        txtapellidosegundo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidosegundoKeyTyped(evt);
            }
        });

        txtdireccion.setBorder(null);
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

        labeldire.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeldire.setForeground(new java.awt.Color(102, 102, 102));
        labeldire.setText("DIRECCIÓN::");

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

        labelhorario.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelhorario.setForeground(new java.awt.Color(102, 102, 102));
        labelhorario.setText("HORARIO:");

        combohorario.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N

        javax.swing.GroupLayout backroundLayout = new javax.swing.GroupLayout(backround);
        backround.setLayout(backroundLayout);
        backroundLayout.setHorizontalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelsuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(backroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(backroundLayout.createSequentialGroup()
                            .addComponent(labeltel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(radiomasculino)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radiofemenino))
                        .addGroup(backroundLayout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addComponent(labeltel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator5)
                                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addComponent(labelmail, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator4)
                                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addComponent(labelape, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator3)
                                            .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addComponent(labelnom, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator2)
                                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addComponent(labelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fecha_nac_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addComponent(labelnomsegundo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtnombresegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addComponent(labelapesegundo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator10)
                                            .addComponent(txtapellidosegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(backroundLayout.createSequentialGroup()
                                        .addComponent(labeldire, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(backroundLayout.createSequentialGroup()
                                    .addComponent(labelced, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addComponent(labeltipouser, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combotipouser, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labeltiposa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combotiposangre, 0, 225, Short.MAX_VALUE))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labeltiposa1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpassword))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labeltiposa2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator6)
                                    .addComponent(txtpasswordrep, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(jSeparator7)))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labelhorario, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(combohorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnagregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnactualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnbuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnrvolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        backroundLayout.setVerticalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backroundLayout.createSequentialGroup()
                .addComponent(panelsuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltipouser)
                    .addComponent(combotipouser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labeltiposa)
                            .addComponent(labelced, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combotiposangre, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelnom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelhorario)
                                .addComponent(combohorario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelnomsegundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtnombresegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelape, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtapellidosegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelapesegundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labeltiposa1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labeltiposa2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpasswordrep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator7)
                                .addGap(68, 68, 68)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelmail, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labeltel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnrvolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labeldire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fecha_nac_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labeltel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radiomasculino))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addComponent(radiofemenino)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(203, 203, 203))
        );

        jScrollPane1.setViewportView(backround);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlabelvolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelvolverMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnlabelvolverMouseClicked

    private void txtcedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcedulaKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
         evt.consume();
        } else{
            if(txtcedula.getText().length()>=10) {
                evt.consume();    
            }
        }
    }//GEN-LAST:event_txtcedulaKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isDigit(validar)){
            evt.consume();
        }else{
            if (txtnombre.getText().length()>=50) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isDigit(validar)){
            evt.consume();
        }else{
            if (txtapellido.getText().length()>=50) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
        if(txtemail.getText().trim().length()>=150){
            evt.consume();
        }
    }//GEN-LAST:event_txtemailKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
         evt.consume();
        } else{
            if(txttelefono.getText().trim().length()>=10) {
                evt.consume();    
            }
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyTyped
        if (txtpassword.getPassword().length>=16) {
            evt.consume();
        }
    }//GEN-LAST:event_txtpasswordKeyTyped

    private void txtpasswordrepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordrepKeyTyped
        if (txtpassword.getPassword().length>=16) {
            evt.consume();
        }
    }//GEN-LAST:event_txtpasswordrepKeyTyped

    private void fecha_nac_chooserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fecha_nac_chooserKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar) || Character.isDigit(validar)){
            evt.consume();
        }
    }//GEN-LAST:event_fecha_nac_chooserKeyTyped

    private void txtnombresegundoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresegundoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresegundoKeyTyped

    private void txtapellidosegundoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosegundoKeyTyped
        if (txtapellidosegundo.getText().length()>=50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidosegundoKeyTyped

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void btnlabeagregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeagregarMouseClicked
        Registro();
    }//GEN-LAST:event_btnlabeagregarMouseClicked

    private void btnlabelactualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelactualizarMouseClicked
        //Modificar();
    }//GEN-LAST:event_btnlabelactualizarMouseClicked

    private void btnlabeleliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeleliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlabeleliminarMouseClicked

    private void btnlabelbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelbuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlabelbuscarMouseClicked

    private void btnlabellimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabellimpiarMouseClicked
        Vaciar_Campos();
        ModeloBibliotecario.Limpiar_Tabla();
        ModeloBibliotecario.getTabla();
    }//GEN-LAST:event_btnlabellimpiarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backround;
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
    private javax.swing.JComboBox<Horario> combohorario;
    private javax.swing.JComboBox<String> combotiposangre;
    private javax.swing.JComboBox<String> combotipouser;
    private com.toedter.calendar.JDateChooser fecha_nac_chooser;
    private javax.swing.ButtonGroup grupogenero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel labelape;
    private javax.swing.JLabel labelapesegundo;
    private javax.swing.JLabel labelced;
    private javax.swing.JLabel labeldire;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelhorario;
    private javax.swing.JLabel labelmail;
    private javax.swing.JLabel labelnom;
    private javax.swing.JLabel labelnomsegundo;
    private javax.swing.JLabel labelreg;
    private javax.swing.JLabel labeltel;
    private javax.swing.JLabel labeltel1;
    private javax.swing.JLabel labeltiposa;
    private javax.swing.JLabel labeltiposa1;
    private javax.swing.JLabel labeltiposa2;
    private javax.swing.JLabel labeltipouser;
    private javax.swing.JPanel panelsuperior;
    private javax.swing.JRadioButton radiofemenino;
    private javax.swing.JRadioButton radiomasculino;
    public static javax.swing.JTable tablaPersona;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtapellidosegundo;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtnombresegundo;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JPasswordField txtpasswordrep;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
