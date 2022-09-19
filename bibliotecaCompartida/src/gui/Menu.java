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

        panemenu = new javax.swing.JPanel();
        btnregistrosalir = new javax.swing.JPanel();
        btnlabelsalir = new javax.swing.JLabel();
        btndewey = new javax.swing.JPanel();
        btnlabeldewey = new javax.swing.JLabel();
        backround = new javax.swing.JPanel();
        Contenedor = new javax.swing.JPanel();
        panelsuperior = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        labelfecha = new javax.swing.JLabel();
        labelhora = new javax.swing.JLabel();
        HideMenu = new javax.swing.JPanel();
        Slide = new javax.swing.JLabel();
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

        panelsuperior.setBackground(new java.awt.Color(0, 153, 153));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/library control.png"))); // NOI18N

        labelfecha.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelfecha.setForeground(new java.awt.Color(255, 255, 255));
        labelfecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelfecha.setToolTipText("");

        labelhora.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        labelhora.setForeground(new java.awt.Color(255, 255, 255));
        labelhora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout panelsuperiorLayout = new javax.swing.GroupLayout(panelsuperior);
        panelsuperior.setLayout(panelsuperiorLayout);
        panelsuperiorLayout.setHorizontalGroup(
            panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelsuperiorLayout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addGroup(panelsuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelfecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelhora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        );

        javax.swing.GroupLayout ContenedorLayout = new javax.swing.GroupLayout(Contenedor);
        Contenedor.setLayout(ContenedorLayout);
        ContenedorLayout.setHorizontalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelsuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ContenedorLayout.setVerticalGroup(
            ContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContenedorLayout.createSequentialGroup()
                .addComponent(panelsuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(376, Short.MAX_VALUE))
        );

        HideMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HideMenu.setLayout(null);

        Slide.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Slide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/menu.png"))); // NOI18N
        Slide.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        HideMenu.add(Slide);
        Slide.setBounds(0, 0, 230, 40);

        libro.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        libro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/libro.png"))); // NOI18N
        libro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        libro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                libroMouseClicked(evt);
            }
        });
        HideMenu.add(libro);
        libro.setBounds(0, 40, 230, 40);

        Autor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Autor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pluma-pluma.png"))); // NOI18N
        Autor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Autor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AutorMouseClicked(evt);
            }
        });
        HideMenu.add(Autor);
        Autor.setBounds(0, 80, 230, 40);

        Categoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categoria.png"))); // NOI18N
        Categoria.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CategoriaMouseClicked(evt);
            }
        });
        HideMenu.add(Categoria);
        Categoria.setBounds(0, 120, 230, 40);

        Editorial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Editorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editorial.png"))); // NOI18N
        Editorial.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Editorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditorialMouseClicked(evt);
            }
        });
        HideMenu.add(Editorial);
        Editorial.setBounds(0, 160, 230, 40);

        Idioma.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Idioma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/idioma.png"))); // NOI18N
        Idioma.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Idioma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IdiomaMouseClicked(evt);
            }
        });
        HideMenu.add(Idioma);
        Idioma.setBounds(0, 200, 230, 40);

        Multas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Multas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/multa.png"))); // NOI18N
        Multas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Multas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MultasMouseClicked(evt);
            }
        });
        HideMenu.add(Multas);
        Multas.setBounds(0, 240, 230, 40);

        Seccion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Seccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/secciones.png"))); // NOI18N
        Seccion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Seccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeccionMouseClicked(evt);
            }
        });
        HideMenu.add(Seccion);
        Seccion.setBounds(0, 280, 230, 40);

        Horario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Horario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calendario.png"))); // NOI18N
        Horario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Horario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HorarioMouseClicked(evt);
            }
        });
        HideMenu.add(Horario);
        Horario.setBounds(0, 320, 230, 40);

        Salir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Salir.setText("SALIR");
        Salir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        HideMenu.add(Salir);
        Salir.setBounds(0, 480, 230, 40);

        Dewey.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Dewey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/8352653 (1).png"))); // NOI18N
        Dewey.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        HideMenu.add(Dewey);
        Dewey.setBounds(0, 400, 230, 40);

        Pais.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Pais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pais.png"))); // NOI18N
        Pais.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Pais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaisMouseClicked(evt);
            }
        });
        HideMenu.add(Pais);
        Pais.setBounds(0, 360, 230, 40);

        Usuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/921296 (1).png"))); // NOI18N
        Usuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 5));
        Usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsuarioMouseClicked(evt);
            }
        });
        HideMenu.add(Usuario);
        Usuario.setBounds(0, 440, 230, 40);

        javax.swing.GroupLayout backroundLayout = new javax.swing.GroupLayout(backround);
        backround.setLayout(backroundLayout);
        backroundLayout.setHorizontalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backroundLayout.createSequentialGroup()
                .addComponent(HideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backroundLayout.setVerticalGroup(
            backroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(HideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Autor;
    private javax.swing.JLabel Categoria;
    private javax.swing.JPanel Contenedor;
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
    private javax.swing.JLabel labelfecha;
    private javax.swing.JLabel labelhora;
    private javax.swing.JLabel libro;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelsuperior;
    private javax.swing.JPanel panemenu;
    // End of variables declaration//GEN-END:variables
}
