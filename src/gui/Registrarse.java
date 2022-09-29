package gui;

import Modelo.ModeloEstudiante;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.Date;
import javax.swing.JTextField;
import logico.ControladorUsuario;
import logico.Estudiante;
import logico.Validador_Cedula;

public class Registrarse extends javax.swing.JFrame {

    /**
     * Creates new form Registrarse
     * @param parent
     * @param modal
     */
    Validador_Cedula vali_c;
    ControladorUsuario control;
    ModeloEstudiante me = new ModeloEstudiante();
    public Registrarse(java.awt.Frame parent, boolean modal) {
        initComponents();
    }
    
    public void Registro(){
        try{
            Estudiante estudiante = new Estudiante();
            String cedula = txtcedula.getText().trim();
            String nombre_pr = txtprimernombre.getText().trim();
            String nombre_se = txtnombresegundo.getText().trim();
            String apellido_pr = txtprimerapellido.getText().trim();
            String apellido_se = txtapellidosegundo.getText().trim();
            String email = txtemail.getText().trim();
            String telefono = txttelefono.getText().trim();
            String fecha_ini = ((JTextField) fecha_nac_chooser.getDateEditor().getUiComponent()).getText();
            String direccion = txtdireccion.getText().trim();
            boolean estado = false;
            
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
            String tipo_user = "INVITADO";

            if (cedula.isEmpty() ||  nombre_pr.isEmpty() || apellido_pr.isEmpty() || 
                email.isEmpty() || telefono.isEmpty() || fecha_ini.isEmpty() || gen.isEmpty() ||
                password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "RELLENE TODOS LOS CAMPOS");

            } else {
                if(tipo_sangre.equalsIgnoreCase("SELECCIONAR")) {
                    JOptionPane.showMessageDialog(null, "VERIFQUE LOS CAMPOS DE SELECCIÓN");
                } else {
                    if (estudiante.ValidarNombreYapellido(nombre_pr)==false || estudiante.ValidarNombreYapellido(apellido_pr)==false
                            || estudiante.ValidarCorreo(email)==false || estudiante.ValidarTelefono(telefono)==false) {
                        JOptionPane.showMessageDialog(null, "HAY CAMPOS CON INFORMACIÓN NO VÁLIDA");
                    } else {
                        if(estudiante.ValidarCedula(cedula)){
                            if(Validar_no_Rep(cedula)) {
                                if (estudiante.ValidarPassword(password)==false) {
                                    JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres, que incluyen una letra en minúscula, una en mayúscula y números, no contiene símbolos especiales");
                                } else {
                                    if(password.equals(password_rep)){
                                            estudiante.setCedula(cedula);
                                            estudiante.setPrimer_nombre(nombre_pr);
                                            estudiante.setSegundo_nombre(nombre_se);
                                            estudiante.setPrimer_apellido(apellido_pr);
                                            estudiante.setSegundo_apellido(apellido_se);
                                            estudiante.setEmail(email);
                                            estudiante.setTelefono(telefono);
                                            estudiante.setFecha_nac(Date.valueOf(fecha_ini));
                                            estudiante.setGenero(gen);
                                            estudiante.setTipo_sangre(tipo_sangre);
                                            estudiante.setTipo_usuario(tipo_user);
                                            estudiante.setPassword(password);
                                            estudiante.setEstado(estado); 
                                            estudiante.setDireccion(direccion);
                                        if(me.RegistrarEstudiante(estudiante)){
                                            
                                            
                                            this.Vaciar_Campos();
                                            Mensaje("REGISTRO COMPLETADO", "REGISTRO");
                                        } else {
                                            JOptionPane.showMessageDialog(null, "NO SE PUDO REGISTRAR");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "LAS CONTRASEÑAS NO COINCIDEN");
                                    }
                                }
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "EL NÚMERO DE CÉDULA NO ES VÁLIDO");
                        }
                    }
                }
            }
        }catch(HeadlessException e){
            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupogenero = new javax.swing.ButtonGroup();
        backround = new javax.swing.JPanel();
        panelsuperior = new javax.swing.JPanel();
        labelreg = new javax.swing.JLabel();
        labelced = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        labelnom = new javax.swing.JLabel();
        txtprimernombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        labelape = new javax.swing.JLabel();
        txtprimerapellido = new javax.swing.JTextField();
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
        jSeparator6 = new javax.swing.JSeparator();
        txtpassword = new javax.swing.JPasswordField();
        jSeparator7 = new javax.swing.JSeparator();
        txtpasswordrep = new javax.swing.JPasswordField();
        labeltiposa2 = new javax.swing.JLabel();
        btnregistro = new javax.swing.JPanel();
        btnlabelregistro = new javax.swing.JLabel();
        btnpanelcancelar = new javax.swing.JPanel();
        labelbtncancelar = new javax.swing.JLabel();
        labeldire = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        labelnomsegundo = new javax.swing.JLabel();
        txtnombresegundo = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        labelapesegundo = new javax.swing.JLabel();
        txtapellidosegundo = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backround.setBackground(new java.awt.Color(255, 255, 255));

        panelsuperior.setBackground(new java.awt.Color(0, 153, 153));

        labelreg.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        labelreg.setForeground(new java.awt.Color(255, 255, 255));
        labelreg.setText("REGISTRO INVITADO");

        javax.swing.GroupLayout panelsuperiorLayout = new javax.swing.GroupLayout(panelsuperior);
        panelsuperior.setLayout(panelsuperiorLayout);
        panelsuperiorLayout.setHorizontalGroup(
            panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuperiorLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(labelreg)
                .addContainerGap(377, Short.MAX_VALUE))
        );
        panelsuperiorLayout.setVerticalGroup(
            panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuperiorLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelreg)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        labelced.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelced.setForeground(new java.awt.Color(102, 102, 102));
        labelced.setText("CÉDULA:");

        txtcedula.setBorder(null);
        txtcedula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcedulaFocusLost(evt);
            }
        });
        txtcedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcedulaKeyTyped(evt);
            }
        });

        labelnom.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelnom.setForeground(new java.awt.Color(102, 102, 102));
        labelnom.setText("NOMBRE:");

        txtprimernombre.setBorder(null);
        txtprimernombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprimernombreKeyTyped(evt);
            }
        });

        labelape.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labelape.setForeground(new java.awt.Color(102, 102, 102));
        labelape.setText("APELLIDO:");

        txtprimerapellido.setBorder(null);
        txtprimerapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprimerapellidoKeyTyped(evt);
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

        txtpasswordrep.setBorder(null);
        txtpasswordrep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpasswordrepKeyTyped(evt);
            }
        });

        labeltiposa2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeltiposa2.setForeground(new java.awt.Color(102, 102, 102));
        labeltiposa2.setText("REPETIR CONTRASEÑA:");

        btnregistro.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelregistro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelregistro.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelregistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelregistro.setText("REGISTRARSE");
        btnlabelregistro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnlabelregistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelregistroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlabelregistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlabelregistroMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnregistroLayout = new javax.swing.GroupLayout(btnregistro);
        btnregistro.setLayout(btnregistroLayout);
        btnregistroLayout.setHorizontalGroup(
            btnregistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelregistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnregistroLayout.setVerticalGroup(
            btnregistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelregistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnpanelcancelar.setBackground(new java.awt.Color(0, 153, 153));

        labelbtncancelar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelbtncancelar.setForeground(new java.awt.Color(255, 255, 255));
        labelbtncancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelbtncancelar.setText("CANCELAR");
        labelbtncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelbtncancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelbtncancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelbtncancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelbtncancelarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnpanelcancelarLayout = new javax.swing.GroupLayout(btnpanelcancelar);
        btnpanelcancelar.setLayout(btnpanelcancelarLayout);
        btnpanelcancelarLayout.setHorizontalGroup(
            btnpanelcancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelbtncancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        btnpanelcancelarLayout.setVerticalGroup(
            btnpanelcancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelbtncancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        labeldire.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        labeldire.setForeground(new java.awt.Color(102, 102, 102));
        labeldire.setText("DIRECCIÓN::");

        txtdireccion.setBorder(null);
        txtdireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdireccionKeyTyped(evt);
            }
        });

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

        javax.swing.GroupLayout backroundLayout = new javax.swing.GroupLayout(backround);
        backround.setLayout(backroundLayout);
        backroundLayout.setHorizontalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(backroundLayout.createSequentialGroup()
                            .addComponent(labeltel1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radiomasculino)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radiofemenino))
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha_nac_chooser, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(backroundLayout.createSequentialGroup()
                                    .addComponent(labelced, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator1)
                                        .addComponent(txtcedula, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))
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
                                    .addComponent(labelnom, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator2)
                                        .addComponent(txtprimernombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(backroundLayout.createSequentialGroup()
                                    .addComponent(labelape, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator3)
                                        .addComponent(txtprimerapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator9)
                                    .addComponent(txtnombresegundo, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addComponent(labelapesegundo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator10)
                            .addComponent(txtapellidosegundo, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))))
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labeltiposa1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labeltiposa2)
                            .addComponent(labeltiposa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combotiposangre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator6)
                            .addComponent(txtpassword)
                            .addComponent(txtpasswordrep)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backroundLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnregistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnpanelcancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(152, 152, 152))
            .addGroup(backroundLayout.createSequentialGroup()
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelsuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelnomsegundo)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labeldire, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backroundLayout.setVerticalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backroundLayout.createSequentialGroup()
                .addComponent(panelsuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelced, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labeltiposa)
                            .addComponent(combotiposangre, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelnom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtprimernombre, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelnomsegundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnombresegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelape, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtprimerapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labeltiposa1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtapellidosegundo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelapesegundo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addComponent(labeltiposa2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelmail, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backroundLayout.createSequentialGroup()
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labeltel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labeldire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fecha_nac_chooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labeltel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(radiomasculino)
                                    .addComponent(radiofemenino)))
                            .addComponent(btnregistro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnpanelcancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtpasswordrep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backround, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelbtncancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelbtncancelarMouseClicked
        Login log  = new Login();
        //JOptionPane.showConfirmDialog(null, "¿ESTÁ SEGURO QUE DESEA SALIR?");
        this.dispose();

        log.setLocationRelativeTo(null);
        log.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_labelbtncancelarMouseClicked

    private void btnlabelregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelregistroMouseClicked
        Registro();
    }//GEN-LAST:event_btnlabelregistroMouseClicked

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

    private void txtprimernombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprimernombreKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isDigit(validar)){
            evt.consume();
        }else{
            if (txtprimernombre.getText().length()>=50) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtprimernombreKeyTyped

    private void txtprimerapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprimerapellidoKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isDigit(validar)){
            evt.consume();
        }else {   
            if (txtprimerapellido.getText().length()>=50) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtprimerapellidoKeyTyped

    private void txtemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyTyped
        if (txtemail.getText().length()>=150) {
            evt.consume();
        }
    }//GEN-LAST:event_txtemailKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            evt.consume();
        }else{
            if (txttelefono.getText().length()>=10) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyTyped
        if (txtpassword.getPassword().length>=16) {
            evt.consume();
        }
    }//GEN-LAST:event_txtpasswordKeyTyped

    private void txtcedulaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcedulaFocusLost
//        Usuario user = new Usuario();
//        try {
//            if(user.ValidarCedula(txtcedula.getText().trim())==false){
//                JOptionPane.showMessageDialog(null, "NÚMERO NO VÁLIDO");
//            }
//        } catch (ArrayIndexOutOfBoundsException aiobe) {
//        }
    }//GEN-LAST:event_txtcedulaFocusLost

    private void btnlabelregistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelregistroMouseEntered
        btnregistro.setBackground(new Color(0, 120, 120));
    }//GEN-LAST:event_btnlabelregistroMouseEntered

    private void btnlabelregistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelregistroMouseExited
        btnregistro.setBackground(new Color(0, 153, 153));

    }//GEN-LAST:event_btnlabelregistroMouseExited

    private void labelbtncancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelbtncancelarMouseEntered
        btnpanelcancelar.setBackground(new Color(0, 120, 120));

    }//GEN-LAST:event_labelbtncancelarMouseEntered

    private void labelbtncancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelbtncancelarMouseExited
        btnpanelcancelar.setBackground(new Color(0, 153, 153));

    }//GEN-LAST:event_labelbtncancelarMouseExited

    private void txtdireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdireccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionKeyTyped

    private void txtpasswordrepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordrepKeyTyped
        if (txtpasswordrep.getPassword().length>=16) {
            evt.consume();
        }
    }//GEN-LAST:event_txtpasswordrepKeyTyped

    private void txtnombresegundoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombresegundoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresegundoKeyTyped

    private void txtapellidosegundoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidosegundoKeyTyped
        if (txtapellidosegundo.getText().length()>=50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtapellidosegundoKeyTyped

    
    private boolean Validar_no_Rep(String ced) {
        boolean rep = true;
        for (int i = 0; i < ControladorUsuario.listausuarios.size(); i++) {
            if (ced.equals(ControladorUsuario.listausuarios.get(i).getCedula())) {
                JOptionPane.showMessageDialog(null, "YA EXISTE UN REGISTRO CON ESA CÉDULA");
                rep = false;
                i = ControladorUsuario.listausuarios.size();
            }
        }
        return rep;
    }
    
    public static void Mensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void Vaciar_Campos() {
        txtcedula.setText("");
        txtprimernombre.setText("");
        txtnombresegundo.setText("");
        txtprimerapellido.setText("");
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backround;
    private javax.swing.JLabel btnlabelregistro;
    private javax.swing.JPanel btnpanelcancelar;
    private javax.swing.JPanel btnregistro;
    private javax.swing.JComboBox<String> combotiposangre;
    private com.toedter.calendar.JDateChooser fecha_nac_chooser;
    private javax.swing.ButtonGroup grupogenero;
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
    private javax.swing.JLabel labelbtncancelar;
    private javax.swing.JLabel labelced;
    private javax.swing.JLabel labeldire;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelmail;
    private javax.swing.JLabel labelnom;
    private javax.swing.JLabel labelnomsegundo;
    private javax.swing.JLabel labelreg;
    private javax.swing.JLabel labeltel;
    private javax.swing.JLabel labeltel1;
    private javax.swing.JLabel labeltiposa;
    private javax.swing.JLabel labeltiposa1;
    private javax.swing.JLabel labeltiposa2;
    private javax.swing.JPanel panelsuperior;
    private javax.swing.JRadioButton radiofemenino;
    private javax.swing.JRadioButton radiomasculino;
    private javax.swing.JTextField txtapellidosegundo;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnombresegundo;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JPasswordField txtpasswordrep;
    private javax.swing.JTextField txtprimerapellido;
    private javax.swing.JTextField txtprimernombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
