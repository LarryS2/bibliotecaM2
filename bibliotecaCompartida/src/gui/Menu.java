package gui;

import logico.Tiempo;

/**
 *
 * @author santi
 */
public final class Menu extends javax.swing.JFrame {


    public Menu() {
        initComponents();
        ShowTime();
    }
    
    Tiempo time = new Tiempo();
    
    public void ShowTime() {
        labelfecha.setText(time.fecha_completa); 
        labelhora.setText(time.hora_completa);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backround = new javax.swing.JPanel();
        panelsuperior = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        labelnombreuser = new javax.swing.JLabel();
        labelfecha = new javax.swing.JLabel();
        labelhora = new javax.swing.JLabel();
        panemenu = new javax.swing.JPanel();
        btnregistrolibros = new javax.swing.JPanel();
        btnlabellibros = new javax.swing.JLabel();
        btnregistrousers = new javax.swing.JPanel();
        btnlabeluser = new javax.swing.JLabel();
        btnregistrozonas = new javax.swing.JPanel();
        btnlabelzonas = new javax.swing.JLabel();
        btnregistroautores = new javax.swing.JPanel();
        btnlabelautor = new javax.swing.JLabel();
        btnregistrocat = new javax.swing.JPanel();
        btnlabeLcateg = new javax.swing.JLabel();
        btnregistroeditorial = new javax.swing.JPanel();
        btnlabeLeditorial = new javax.swing.JLabel();
        btnregistrosalir = new javax.swing.JPanel();
        btnlabelsalir = new javax.swing.JLabel();
        btnidioma = new javax.swing.JPanel();
        btnlabelidioma = new javax.swing.JLabel();
        btnmultas = new javax.swing.JPanel();
        btnlabelmultas = new javax.swing.JLabel();
        btnhorario = new javax.swing.JPanel();
        btnlabelhorario = new javax.swing.JLabel();
        btnpanelpais = new javax.swing.JPanel();
        btnlabelpais = new javax.swing.JLabel();
        btndewey = new javax.swing.JPanel();
        btnlabeldewey = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backround.setBackground(new java.awt.Color(255, 255, 255));

        panelsuperior.setBackground(new java.awt.Color(0, 153, 153));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/library control.png"))); // NOI18N

        labelnombreuser.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        labelnombreuser.setForeground(new java.awt.Color(255, 255, 255));

        labelfecha.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelfecha.setForeground(new java.awt.Color(255, 255, 255));

        labelhora.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelhora.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelsuperiorLayout = new javax.swing.GroupLayout(panelsuperior);
        panelsuperior.setLayout(panelsuperiorLayout);
        panelsuperiorLayout.setHorizontalGroup(
            panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsuperiorLayout.createSequentialGroup()
                        .addComponent(labelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelhora, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelnombreuser, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logo)
                .addGap(26, 26, 26))
        );
        panelsuperiorLayout.setVerticalGroup(
            panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuperiorLayout.createSequentialGroup()
                .addGroup(panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsuperiorLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(logo))
                    .addGroup(panelsuperiorLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(labelnombreuser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelfecha, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(labelhora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panemenu.setBackground(new java.awt.Color(204, 204, 204));
        panemenu.setForeground(new java.awt.Color(153, 153, 153));

        btnregistrolibros.setBackground(new java.awt.Color(0, 153, 153));

        btnlabellibros.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabellibros.setForeground(new java.awt.Color(255, 255, 255));
        btnlabellibros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabellibros.setText("LIBROS");
        btnlabellibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabellibros.setPreferredSize(new java.awt.Dimension(62, 17));
        btnlabellibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabellibrosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnregistrolibrosLayout = new javax.swing.GroupLayout(btnregistrolibros);
        btnregistrolibros.setLayout(btnregistrolibrosLayout);
        btnregistrolibrosLayout.setHorizontalGroup(
            btnregistrolibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabellibros, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btnregistrolibrosLayout.setVerticalGroup(
            btnregistrolibrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabellibros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnregistrousers.setBackground(new java.awt.Color(0, 153, 153));

        btnlabeluser.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabeluser.setForeground(new java.awt.Color(255, 255, 255));
        btnlabeluser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabeluser.setText("USUARIOS");
        btnlabeluser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabeluser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabeluserMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnregistrousersLayout = new javax.swing.GroupLayout(btnregistrousers);
        btnregistrousers.setLayout(btnregistrousersLayout);
        btnregistrousersLayout.setHorizontalGroup(
            btnregistrousersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeluser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        btnregistrousersLayout.setVerticalGroup(
            btnregistrousersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeluser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnregistrozonas.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelzonas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelzonas.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelzonas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelzonas.setText("SECCIONES");
        btnlabelzonas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelzonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelzonasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnregistrozonasLayout = new javax.swing.GroupLayout(btnregistrozonas);
        btnregistrozonas.setLayout(btnregistrozonasLayout);
        btnregistrozonasLayout.setHorizontalGroup(
            btnregistrozonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelzonas, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        btnregistrozonasLayout.setVerticalGroup(
            btnregistrozonasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelzonas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnregistroautores.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelautor.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelautor.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelautor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelautor.setText("AUTORES");
        btnlabelautor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelautor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelautorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnregistroautoresLayout = new javax.swing.GroupLayout(btnregistroautores);
        btnregistroautores.setLayout(btnregistroautoresLayout);
        btnregistroautoresLayout.setHorizontalGroup(
            btnregistroautoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelautor, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btnregistroautoresLayout.setVerticalGroup(
            btnregistroautoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelautor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnregistrocat.setBackground(new java.awt.Color(0, 153, 153));

        btnlabeLcateg.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabeLcateg.setForeground(new java.awt.Color(255, 255, 255));
        btnlabeLcateg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabeLcateg.setText("CATEGORIAS");
        btnlabeLcateg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabeLcateg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabeLcategMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlabeLcategMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout btnregistrocatLayout = new javax.swing.GroupLayout(btnregistrocat);
        btnregistrocat.setLayout(btnregistrocatLayout);
        btnregistrocatLayout.setHorizontalGroup(
            btnregistrocatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeLcateg, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btnregistrocatLayout.setVerticalGroup(
            btnregistrocatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeLcateg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnregistroeditorial.setBackground(new java.awt.Color(0, 153, 153));

        btnlabeLeditorial.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabeLeditorial.setForeground(new java.awt.Color(255, 255, 255));
        btnlabeLeditorial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabeLeditorial.setText("EDITORIALES");
        btnlabeLeditorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabeLeditorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabeLeditorialMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnregistroeditorialLayout = new javax.swing.GroupLayout(btnregistroeditorial);
        btnregistroeditorial.setLayout(btnregistroeditorialLayout);
        btnregistroeditorialLayout.setHorizontalGroup(
            btnregistroeditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeLeditorial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        btnregistroeditorialLayout.setVerticalGroup(
            btnregistroeditorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeLeditorial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnregistrosalir.setBackground(new java.awt.Color(0, 102, 102));

        btnlabelsalir.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelsalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelsalir.setText("LOG OUT");
        btnlabelsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelsalirMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnregistrosalirLayout = new javax.swing.GroupLayout(btnregistrosalir);
        btnregistrosalir.setLayout(btnregistrosalirLayout);
        btnregistrosalirLayout.setHorizontalGroup(
            btnregistrosalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelsalir, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );
        btnregistrosalirLayout.setVerticalGroup(
            btnregistrosalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnidioma.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelidioma.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelidioma.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelidioma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelidioma.setText("IDIOMAS");
        btnlabelidioma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelidioma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelidiomaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnidiomaLayout = new javax.swing.GroupLayout(btnidioma);
        btnidioma.setLayout(btnidiomaLayout);
        btnidiomaLayout.setHorizontalGroup(
            btnidiomaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelidioma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        btnidiomaLayout.setVerticalGroup(
            btnidiomaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelidioma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnmultas.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelmultas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelmultas.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelmultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelmultas.setText("MULTAS");
        btnlabelmultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelmultas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelmultasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnmultasLayout = new javax.swing.GroupLayout(btnmultas);
        btnmultas.setLayout(btnmultasLayout);
        btnmultasLayout.setHorizontalGroup(
            btnmultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelmultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );
        btnmultasLayout.setVerticalGroup(
            btnmultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelmultas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panemenuLayout = new javax.swing.GroupLayout(panemenu);
        panemenu.setLayout(panemenuLayout);
        panemenuLayout.setHorizontalGroup(
            panemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panemenuLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnregistrolibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnregistroautores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnregistrocat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnregistroeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnidioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnmultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnregistrousers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnregistrozonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnregistrosalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        panemenuLayout.setVerticalGroup(
            panemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panemenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnidioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistrosalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistroeditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistrocat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistroautores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistrozonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistrousers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnregistrolibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        btnhorario.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelhorario.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelhorario.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelhorario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelhorario.setText("HORARIOS");
        btnlabelhorario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelhorario.setPreferredSize(new java.awt.Dimension(62, 17));
        btnlabelhorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelhorarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnhorarioLayout = new javax.swing.GroupLayout(btnhorario);
        btnhorario.setLayout(btnhorarioLayout);
        btnhorarioLayout.setHorizontalGroup(
            btnhorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelhorario, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btnhorarioLayout.setVerticalGroup(
            btnhorarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelhorario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btnpanelpais.setBackground(new java.awt.Color(0, 153, 153));

        btnlabelpais.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabelpais.setForeground(new java.awt.Color(255, 255, 255));
        btnlabelpais.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabelpais.setText("PAÍSES");
        btnlabelpais.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabelpais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabelpaisMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btnpanelpaisLayout = new javax.swing.GroupLayout(btnpanelpais);
        btnpanelpais.setLayout(btnpanelpaisLayout);
        btnpanelpaisLayout.setHorizontalGroup(
            btnpanelpaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelpais, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btnpanelpaisLayout.setVerticalGroup(
            btnpanelpaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabelpais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        btndewey.setBackground(new java.awt.Color(0, 153, 153));

        btnlabeldewey.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnlabeldewey.setForeground(new java.awt.Color(255, 255, 255));
        btnlabeldewey.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlabeldewey.setText("DEWEY");
        btnlabeldewey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlabeldewey.setPreferredSize(new java.awt.Dimension(62, 17));
        btnlabeldewey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlabeldeweyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout btndeweyLayout = new javax.swing.GroupLayout(btndewey);
        btndewey.setLayout(btndeweyLayout);
        btndeweyLayout.setHorizontalGroup(
            btndeweyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeldewey, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        btndeweyLayout.setVerticalGroup(
            btndeweyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnlabeldewey, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backroundLayout = new javax.swing.GroupLayout(backround);
        backround.setLayout(backroundLayout);
        backroundLayout.setHorizontalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelsuperior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panemenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnhorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnpanelpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btndewey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backroundLayout.setVerticalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backroundLayout.createSequentialGroup()
                .addComponent(panelsuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panemenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnhorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpanelpais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndewey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
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

    private void btnlabellibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabellibrosMouseClicked
        Ventana_Libro ventana = new Ventana_Libro();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }//GEN-LAST:event_btnlabellibrosMouseClicked

    private void btnlabeluserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeluserMouseClicked
        Registrar_Administrador reg_adm = new Registrar_Administrador();
        reg_adm.setLocationRelativeTo(null);
        reg_adm.setVisible(true);
    }//GEN-LAST:event_btnlabeluserMouseClicked

    private void btnlabelzonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelzonasMouseClicked
        Ventana_Seccion zona = new Ventana_Seccion();
        zona.setLocationRelativeTo(null);
        zona.setVisible(true);
    }//GEN-LAST:event_btnlabelzonasMouseClicked

    private void btnlabelautorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelautorMouseClicked
        Ventana_Autor aut = new Ventana_Autor(null, true);
        aut.setLocationRelativeTo(null);
        aut.setVisible(true);
    }//GEN-LAST:event_btnlabelautorMouseClicked

    private void btnlabeLcategMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeLcategMouseClicked
        Ventana_Categoria cat = new Ventana_Categoria(null, true);
        cat.setLocationRelativeTo(null);
        cat.setVisible(true);
    }//GEN-LAST:event_btnlabeLcategMouseClicked

    private void btnlabeLeditorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeLeditorialMouseClicked
        Ventana_Editorial edi = new Ventana_Editorial(null, true);
        edi.setLocationRelativeTo(null);
        edi.setVisible(true);
    }//GEN-LAST:event_btnlabeLeditorialMouseClicked

    private void btnlabelsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelsalirMouseClicked
        Login log = new Login();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnlabelsalirMouseClicked

    private void btnlabeLcategMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeLcategMouseEntered
        //Futuro
    }//GEN-LAST:event_btnlabeLcategMouseEntered

    private void btnlabelmultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelmultasMouseClicked
        Ventana_Multas multa = new Ventana_Multas(null, true);
        multa.setLocationRelativeTo(null);
        multa.setVisible(true);
    }//GEN-LAST:event_btnlabelmultasMouseClicked

    private void btnlabelidiomaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelidiomaMouseClicked
        Ventana_Idiomas idioma = new Ventana_Idiomas(null, true);
        idioma.setLocationRelativeTo(null);
        idioma.setVisible(true);
    }//GEN-LAST:event_btnlabelidiomaMouseClicked

    private void btnlabelhorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelhorarioMouseClicked
        Ventana_Horarios horarios = new Ventana_Horarios(null, true);
        horarios.setLocationRelativeTo(null);
        horarios.setVisible(true);
    }//GEN-LAST:event_btnlabelhorarioMouseClicked

    private void btnlabelpaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelpaisMouseClicked
        Ventana_paises paises = new  Ventana_paises(null, true);
        paises.setLocationRelativeTo(null);
        paises.setVisible(true);
    }//GEN-LAST:event_btnlabelpaisMouseClicked

    private void btnlabeldeweyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeldeweyMouseClicked
        Ventana_Dewey dewey = new Ventana_Dewey(null, true);
        dewey.setLocationRelativeTo(null);
        dewey.setVisible(true);
    }//GEN-LAST:event_btnlabeldeweyMouseClicked

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backround;
    private javax.swing.JPanel btndewey;
    private javax.swing.JPanel btnhorario;
    private javax.swing.JPanel btnidioma;
    private javax.swing.JLabel btnlabeLcateg;
    private javax.swing.JLabel btnlabeLeditorial;
    private javax.swing.JLabel btnlabelautor;
    private javax.swing.JLabel btnlabelautor2;
    private javax.swing.JLabel btnlabeldewey;
    private javax.swing.JLabel btnlabelhorario;
    private javax.swing.JLabel btnlabelidioma;
    private javax.swing.JLabel btnlabellibros;
    private javax.swing.JLabel btnlabelmultas;
    private javax.swing.JLabel btnlabelpais;
    private javax.swing.JLabel btnlabelsalir;
    private javax.swing.JLabel btnlabeluser;
    private javax.swing.JLabel btnlabelzonas;
    private javax.swing.JPanel btnmultas;
    private javax.swing.JPanel btnpanelpais;
    private javax.swing.JPanel btnregistroautores;
    private javax.swing.JPanel btnregistroautores2;
    private javax.swing.JPanel btnregistrocat;
    private javax.swing.JPanel btnregistroeditorial;
    private javax.swing.JPanel btnregistrolibros;
    private javax.swing.JPanel btnregistrosalir;
    private javax.swing.JPanel btnregistrousers;
    private javax.swing.JPanel btnregistrozonas;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelhora;
    protected javax.swing.JLabel labelnombreuser;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelsuperior;
    private javax.swing.JPanel panemenu;
    // End of variables declaration//GEN-END:variables
}
