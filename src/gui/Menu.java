package gui;

import javax.swing.JOptionPane;
import logico.Tiempo;

/**
 *
 * @author santi
 */
public final class Menu extends javax.swing.JFrame{
    String hora, minutos,segundos;
    Thread hilo;
    
    public Menu() {
        initComponents();
        ShowTime();
    }
    
    Tiempo time = new Tiempo();
    
    public void ShowTime() {
        labelfecha.setText(time.fecha_completa); 
    }
    
    /*public void hora(){
        Calendar calendar = new GregorianCalendar();
        Date horaactual = new Date();
        calendar.setTime(horaactual);
        hora = calendar.get(Calendar.HOUR_OF_DAY)>9?""+calendar.get(Calendar.HOUR_OF_DAY):"0"+calendar.get(Calendar.HOUR_OF_DAY);
        minutos  = calendar.get(Calendar.MINUTE)>9?""+calendar.get(Calendar.MINUTE):"0"+calendar.get(Calendar.MINUTE);
        segundos = calendar.get(Calendar.SECOND)>9?""+calendar.get(Calendar.SECOND):"0"+calendar.get(Calendar.SECOND);
    }
    
    public void run(){
        Thread current = Thread.currentThread();
        
        while(current==hilo){
            hora();
            labelhora.setText(hora+":"+minutos+":"+segundos);
        }
    }*/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panemenu = new javax.swing.JPanel();
        btnregistrosalir = new javax.swing.JPanel();
        btnlabelsalir = new javax.swing.JLabel();
        btndewey = new javax.swing.JPanel();
        btnlabeldewey = new javax.swing.JLabel();
        backround = new javax.swing.JPanel();
        HideMenu = new javax.swing.JPanel();
        libro = new javax.swing.JLabel();
        Autor = new javax.swing.JLabel();
        Categoria = new javax.swing.JLabel();
        Editorial = new javax.swing.JLabel();
        Idioma = new javax.swing.JLabel();
        Multas = new javax.swing.JLabel();
        Seccion = new javax.swing.JLabel();
        Horario = new javax.swing.JLabel();
        Salir = new javax.swing.JLabel();
        Dewey = new javax.swing.JLabel();
        Pais = new javax.swing.JLabel();
        Usuario = new javax.swing.JLabel();
        panelsuperior = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        labelfecha = new javax.swing.JLabel();
        labelhora = new javax.swing.JLabel();
        Slide = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        panemenu.setBackground(new java.awt.Color(204, 204, 204));
        panemenu.setForeground(new java.awt.Color(153, 153, 153));

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

        javax.swing.GroupLayout panemenuLayout = new javax.swing.GroupLayout(panemenu);
        panemenu.setLayout(panemenuLayout);
        panemenuLayout.setHorizontalGroup(
            panemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panemenuLayout.createSequentialGroup()
                .addContainerGap(1019, Short.MAX_VALUE)
                .addComponent(btnregistrosalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );
        panemenuLayout.setVerticalGroup(
            panemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panemenuLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(btnregistrosalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backround.setBackground(new java.awt.Color(255, 255, 255));

        HideMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HideMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        libro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        libro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libro.png"))); // NOI18N
        libro.setText("LIBRO");
        libro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        libro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                libroMouseClicked(evt);
            }
        });
        HideMenu.add(libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        Autor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Autor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pluma-pluma.png"))); // NOI18N
        Autor.setText("AUTOR");
        Autor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Autor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AutorMouseClicked(evt);
            }
        });
        HideMenu.add(Autor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 100, 40));

        Categoria.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categoria.png"))); // NOI18N
        Categoria.setText("CATEGORIA");
        Categoria.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoriaMouseClicked(evt);
            }
        });
        HideMenu.add(Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 100, 40));

        Editorial.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Editorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editorial.png"))); // NOI18N
        Editorial.setText("EDITORIAL");
        Editorial.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Editorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditorialMouseClicked(evt);
            }
        });
        HideMenu.add(Editorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 100, 40));

        Idioma.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Idioma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/idioma.png"))); // NOI18N
        Idioma.setText("IDIOMA");
        Idioma.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Idioma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IdiomaMouseClicked(evt);
            }
        });
        HideMenu.add(Idioma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 100, 40));

        Multas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Multas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/multa.png"))); // NOI18N
        Multas.setText("MULTA");
        Multas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Multas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MultasMouseClicked(evt);
            }
        });
        HideMenu.add(Multas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 100, 40));

        Seccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Seccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/secciones.png"))); // NOI18N
        Seccion.setText("SECCION");
        Seccion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Seccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeccionMouseClicked(evt);
            }
        });
        HideMenu.add(Seccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 100, 40));

        Horario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Horario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.png"))); // NOI18N
        Horario.setText("HORARIO");
        Horario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Horario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HorarioMouseClicked(evt);
            }
        });
        HideMenu.add(Horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 100, 40));

        Salir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/660350 (1).png"))); // NOI18N
        Salir.setText("SALIR");
        Salir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalirMouseClicked(evt);
            }
        });
        HideMenu.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 100, 40));

        Dewey.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Dewey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/8352653 (1).png"))); // NOI18N
        Dewey.setText("DEWEY");
        Dewey.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Dewey.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeweyMouseClicked(evt);
            }
        });
        HideMenu.add(Dewey, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 100, 40));

        Pais.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Pais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pais.png"))); // NOI18N
        Pais.setText("PAIS");
        Pais.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Pais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaisMouseClicked(evt);
            }
        });
        HideMenu.add(Pais, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 100, 40));

        Usuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/921296 (1).png"))); // NOI18N
        Usuario.setText("USUARIO");
        Usuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsuarioMouseClicked(evt);
            }
        });
        HideMenu.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 100, 40));

        panelsuperior.setBackground(new java.awt.Color(0, 153, 153));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/library control.png"))); // NOI18N

        labelfecha.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelfecha.setForeground(new java.awt.Color(255, 255, 255));
        labelfecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelfecha.setToolTipText("");

        labelhora.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelhora.setForeground(new java.awt.Color(255, 255, 255));
        labelhora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        Slide.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Slide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); // NOI18N
        Slide.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Slide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SlideMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelsuperiorLayout = new javax.swing.GroupLayout(panelsuperior);
        panelsuperior.setLayout(panelsuperiorLayout);
        panelsuperiorLayout.setHorizontalGroup(
            panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuperiorLayout.createSequentialGroup()
                .addGroup(panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelsuperiorLayout.createSequentialGroup()
                        .addComponent(Slide)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelsuperiorLayout.createSequentialGroup()
                        .addGap(361, 580, Short.MAX_VALUE)
                        .addGroup(panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelfecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelhora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addContainerGap()
                        .addComponent(labelfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelhora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelsuperiorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Slide))
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backroundLayout = new javax.swing.GroupLayout(backround);
        backround.setLayout(backroundLayout);
        backroundLayout.setHorizontalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelsuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backroundLayout.createSequentialGroup()
                .addComponent(HideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        backroundLayout.setVerticalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backroundLayout.createSequentialGroup()
                .addComponent(panelsuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(HideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backroundLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlabelsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabelsalirMouseClicked
        Login log = new Login();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnlabelsalirMouseClicked

    private void btnlabeldeweyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlabeldeweyMouseClicked
        Ventana_Dewey dewey = new Ventana_Dewey(null, true);
        dewey.setLocationRelativeTo(null);
        dewey.setVisible(true);
    }//GEN-LAST:event_btnlabeldeweyMouseClicked

    private void libroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libroMouseClicked
        Ventana_Libro ventana = new Ventana_Libro();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }//GEN-LAST:event_libroMouseClicked

    private void AutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AutorMouseClicked
        Ventana_Autor aut = new Ventana_Autor(null, true);
        aut.setLocationRelativeTo(null);
        aut.setVisible(true);
    }//GEN-LAST:event_AutorMouseClicked

    private void CategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CategoriaMouseClicked
        Ventana_Categoria cat = new Ventana_Categoria(null, true);
        cat.setLocationRelativeTo(null);
        cat.setVisible(true);
    }//GEN-LAST:event_CategoriaMouseClicked

    private void EditorialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditorialMouseClicked
        Ventana_Editorial edi = new Ventana_Editorial(null, true);
        edi.setLocationRelativeTo(null);
        edi.setVisible(true);
    }//GEN-LAST:event_EditorialMouseClicked

    private void IdiomaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IdiomaMouseClicked
        Ventana_Idiomas idioma = new Ventana_Idiomas(null, true);
        idioma.setLocationRelativeTo(null);
        idioma.setVisible(true);
    }//GEN-LAST:event_IdiomaMouseClicked

    private void MultasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MultasMouseClicked
        Ventana_Multas multa = new Ventana_Multas(null, true);
        multa.setLocationRelativeTo(null);
        multa.setVisible(true);
    }//GEN-LAST:event_MultasMouseClicked

    private void UsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsuarioMouseClicked
        Registrar_Administrador reg_adm = new Registrar_Administrador();
        reg_adm.setLocationRelativeTo(null);
        reg_adm.setVisible(true);
    }//GEN-LAST:event_UsuarioMouseClicked

    private void SeccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeccionMouseClicked
        Ventana_Seccion zona = new Ventana_Seccion(null, true);
        zona.setLocationRelativeTo(null);
        zona.setVisible(true);
    }//GEN-LAST:event_SeccionMouseClicked

    private void HorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HorarioMouseClicked
        Ventana_Horarios horarios = new Ventana_Horarios(null, true);
        horarios.setLocationRelativeTo(null);
        horarios.setVisible(true);
    }//GEN-LAST:event_HorarioMouseClicked

    private void PaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaisMouseClicked
        Ventana_paises paises = new  Ventana_paises(null, true);
        paises.setLocationRelativeTo(null);
        paises.setVisible(true);
    }//GEN-LAST:event_PaisMouseClicked
    
    
    int x = 100;
    int a = 0;
    private void SlideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SlideMouseClicked
        if ( x == 100 ) {
            HideMenu.setSize(100, 480);
            Thread th = new Thread() {
                @Override
                public void run(){
                    try {
                        
                        for ( int i = 100; i >= 28; i--){
                            Thread.sleep(1);
                            HideMenu.setSize(i, 480);
                            
                            a++;
                        }
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
            x=28;
        } else if( x == 28 ){
            HideMenu.setSize(x, 480);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try {
                        for (int i = 0; i <= x; i++){
                            Thread.sleep(1);
                            HideMenu.setSize(i, 480);
                        }
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
            x = 100;
        }
    }//GEN-LAST:event_SlideMouseClicked

    private void SalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseClicked
        Login log = new Login();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SalirMouseClicked

    private void DeweyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeweyMouseClicked
        Ventana_Dewey dew = new Ventana_Dewey(null, true);
        dew.setLocationRelativeTo(null);
        dew.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DeweyMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Prestamo pre = new Prestamo();
        pre.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Ventana_Devolucion vd = new Ventana_Devolucion();
        vd.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Autor;
    private javax.swing.JLabel Categoria;
    private javax.swing.JLabel Dewey;
    private javax.swing.JLabel Editorial;
    private javax.swing.JPanel HideMenu;
    private javax.swing.JLabel Horario;
    private javax.swing.JLabel Idioma;
    private javax.swing.JLabel Multas;
    private javax.swing.JLabel Pais;
    private javax.swing.JLabel Salir;
    private javax.swing.JLabel Seccion;
    private javax.swing.JLabel Slide;
    private javax.swing.JLabel Usuario;
    private javax.swing.JPanel backround;
    private javax.swing.JPanel btndewey;
    private javax.swing.JLabel btnlabeldewey;
    private javax.swing.JLabel btnlabelsalir;
    private javax.swing.JPanel btnregistrosalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelhora;
    private javax.swing.JLabel libro;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelsuperior;
    private javax.swing.JPanel panemenu;
    // End of variables declaration//GEN-END:variables
}
