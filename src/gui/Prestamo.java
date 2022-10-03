/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.ModeloGetTablas;
import logico.Persona;
import logico.Libro;
import logico.Pedido;
import java.sql.Date;
import Modelo.ModeloPedido;
import com.toedter.calendar.JDateChooser;
import java.awt.HeadlessException;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logico.Detalle_Pedido;

/**
 *
 * @author Lenin
 */
public class Prestamo extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ModeloPedido mp = new ModeloPedido();

    public Prestamo() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.VistaSelectBook.setLocationRelativeTo(null);
        this.VistaSelectCliente.setLocationRelativeTo(null);
        editableFalse();
        titleCol();
        DetallePedido.getColumnModel().getColumn(0).setPreferredWidth(20);
        generarNoSerie();
    }

    public void llenarCampos(Persona p1) {
        if (p1 != null) {
            txtNombre.setText(p1.getPrimer_nombre() + " " + p1.getSegundo_nombre() + " " + p1.getPrimer_apellido() + " " + p1.getSegundo_apellido());
            txtCedula.setText(p1.getCedula());
            txtTelefono.setText(p1.getTelefono());
            txtDireccion.setText(p1.getDireccion());
        }
    }

    public void titleCol() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Titulo");
        modelo.addColumn("ISBN");
        DetallePedido.setModel(modelo);
        ModeloGetTablas.getTablaCliente();
        ModeloGetTablas.getTablaLibro();
    }

    public void editableFalse() {
        txtNombre.setEditable(false);
        txtNombre.setEditable(false);
        txtDireccion.setEditable(false);
        txtTelefono.setEditable(false);
        txtCedula.setEditable(false);
    }

    public void agregarFila(Libro lib) {
        if (lib != null) {
            if (modelo.getRowCount() == 0) {
                String Datos[] = {lib.getCodigo(), lib.getTitulo(), lib.getIsbn()};
                modelo.addRow(Datos);
            } else {
                if (!evitarDuplicatedRows(lib)) {
                    JOptionPane.showMessageDialog(null, "LIBRO YA REGISTRADO");
                } else {
                    String Datos[] = {lib.getCodigo(), lib.getTitulo(), lib.getIsbn()};
                    modelo.addRow(Datos);
                }
            }
        }
    }

    public boolean evitarDuplicatedRows(Libro lib) {
        boolean bo1 = true;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (lib.getCodigo().equals(modelo.getValueAt(i, 0))) {
                bo1 = false;
                i = modelo.getRowCount();
            }
        }
        return bo1;
    }

    public void eliminarFila(int fila) {
        modelo.removeRow(fila);
    }

    public void enableDelete() {
        buttonEliminar.setEnabled(false);
        if (DetallePedido.getSelectedRow() != -1) {
            buttonEliminar.setEnabled(true);
        } else {
            buttonEliminar.setEnabled(false);
        }
    }
    
    public void generarNoSerie(){
        String serie = mp.NoSerie();
        
        if(serie == null){
            campoIdSerie.setText("000001");
        }else{
            int increment = Integer.parseInt(serie);
            increment++;
            campoIdSerie.setText("00000"+increment);
        }
    }

    public void guardarEnc() {
        try {
            Pedido pd;
            String fecha_ini = ((JTextField) fecha_in.getDateEditor().getUiComponent()).getText();
            String fecha_fi = ((JTextField) fecha_fin.getDateEditor().getUiComponent()).getText();
            String codigo = campoIdSerie.getText();
            int total = Integer.parseInt(ContarFilas.getText());

            if (!txtCedula.getText().isEmpty()) {
                int id = ModeloPedido.getIdPerson(txtCedula.getText());
                if (!fecha_ini.isEmpty() || !fecha_fi.isEmpty()) {
                    pd = new Pedido(id, codigo, Date.valueOf(fecha_ini), Date.valueOf(fecha_fi), total);
                    if (mp.RegistrarPedidoEnc(pd)) {
                        JOptionPane.showMessageDialog(null, "SE HA GENERADO EL PEDIDO CON ÉXITO");
                        limpiar_texto(Pedido);
                    } else {
                        JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR, REVISE SUS CAMPOS");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ASEGURESE DE LLENAR LOS CAMPOS DEPENDIENTES DE LAS FECHAS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "SELECCIONE EL ESTUDIANTE");
            }
        } catch (HeadlessException | NumberFormatException | NullPointerException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR");
        }
    }

    public void guardarDet() {
        try {
            int a = 0;
            Detalle_Pedido dpe = new Detalle_Pedido();
            String idp = ModeloPedido.idPedido();
            int idpe = Integer.parseInt(idp);
            for (int i = 0; i < DetallePedido.getRowCount(); i++) {
                String cod = DetallePedido.getValueAt(i, 0).toString();
                dpe.setDescripcion(String.valueOf(ModeloPedido.idLibro(new Libro(cod))));
                dpe.setId_pe(idpe);
                if (mp.registrarDetalle(dpe)) {
                    a++;
                }
            }
            if (a != 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO COMPLETADO");
                for(int i = 0; i < DetallePedido.getRowCount(); i++){
                    modelo.removeRow(i);
                }
            }
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(e);
        }
    }

    public void limpiar_texto(JPanel panel) {
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JTextField) {
                ((JTextField) panel.getComponents()[i]).setText("");
            } else if (panel.getComponents()[i] instanceof JDateChooser) {
                ((JDateChooser) panel.getComponents()[i]).setCalendar(null);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VistaSelectCliente = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        sCed = new javax.swing.JRadioButton();
        sNom = new javax.swing.JRadioButton();
        sApe = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        Cancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        ParBusqueda1 = new javax.swing.ButtonGroup();
        VistaSelectBook = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        buttCod = new javax.swing.JRadioButton();
        butTit = new javax.swing.JRadioButton();
        butCat = new javax.swing.JRadioButton();
        ContainBut = new javax.swing.JPanel();
        CancelButton = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibro = new javax.swing.JTable();
        Enc = new javax.swing.JPanel();
        lbelTitulo = new javax.swing.JLabel();
        lbelLogo = new javax.swing.JLabel();
        lbelSubtit = new javax.swing.JLabel();
        lbelTelInst = new javax.swing.JLabel();
        lbelID = new javax.swing.JLabel();
        campoIdSerie = new javax.swing.JLabel();
        separatorId = new javax.swing.JSeparator();
        Pedido = new javax.swing.JPanel();
        lbelCliente = new javax.swing.JLabel();
        lbelCedula = new javax.swing.JLabel();
        lbelDireccion = new javax.swing.JLabel();
        lbelTelefono = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        fecha_in = new com.toedter.calendar.JDateChooser();
        jPanel13 = new javax.swing.JPanel();
        buttonCliente = new javax.swing.JLabel();
        buttonLibro = new javax.swing.JLabel();
        buttonEliminar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fecha_fin = new com.toedter.calendar.JDateChooser();
        Detalle = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DetallePedido = new javax.swing.JTable();
        Buttons = new javax.swing.JPanel();
        DescarteDate = new javax.swing.JButton();
        SaveDate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ContarFilas = new javax.swing.JLabel();

        VistaSelectCliente.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        VistaSelectCliente.setAlwaysOnTop(true);
        VistaSelectCliente.setMinimumSize(new java.awt.Dimension(550, 300));
        VistaSelectCliente.setResizable(false);
        VistaSelectCliente.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                VistaSelectClienteWindowClosed(evt);
            }
        });

        ParBusqueda1.add(sCed);
        sCed.setText("Por Cédula");

        ParBusqueda1.add(sNom);
        sNom.setText("Por Nombre");

        ParBusqueda1.add(sApe);
        sApe.setText("Por Apellido");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Buscar Cliente:");

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(Cancelar)
                        .addGap(29, 29, 29)
                        .addComponent(sCed)
                        .addGap(42, 42, 42)
                        .addComponent(sNom)
                        .addGap(47, 47, 47)
                        .addComponent(sApe)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sCed)
                    .addComponent(sNom)
                    .addComponent(sApe)
                    .addComponent(Cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setPreferredSize(new java.awt.Dimension(520, 215));

        tablaCliente = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaCliente.setFocusable(false);
        tablaCliente.getTableHeader().setReorderingAllowed(false);
        tablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaCliente);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout VistaSelectClienteLayout = new javax.swing.GroupLayout(VistaSelectCliente.getContentPane());
        VistaSelectCliente.getContentPane().setLayout(VistaSelectClienteLayout);
        VistaSelectClienteLayout.setHorizontalGroup(
            VistaSelectClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        VistaSelectClienteLayout.setVerticalGroup(
            VistaSelectClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaSelectClienteLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        VistaSelectBook.setMinimumSize(new java.awt.Dimension(550, 331));
        VistaSelectBook.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                VistaSelectBookWindowClosed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("BUSCAR LIBRO:");

        buttCod.setText("POR CODIGO");

        butTit.setText("POR TÍTULO");

        butCat.setText("POR CATEGORÍA");

        ContainBut.setBackground(new java.awt.Color(225, 225, 225));

        CancelButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CancelButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CancelButton.setText("CANCELAR");
        CancelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ContainButLayout = new javax.swing.GroupLayout(ContainBut);
        ContainBut.setLayout(ContainButLayout);
        ContainButLayout.setHorizontalGroup(
            ContainButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
        );
        ContainButLayout.setVerticalGroup(
            ContainButLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(ContainBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(buttCod)
                        .addGap(18, 18, 18)
                        .addComponent(butTit)
                        .addGap(18, 18, 18)
                        .addComponent(butCat)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ContainBut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(butCat)
                        .addComponent(butTit)
                        .addComponent(buttCod)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaLibro = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tablaLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        tablaLibro.setFocusable(false);
        tablaLibro.getTableHeader().setReorderingAllowed(false);
        tablaLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLibroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLibro);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout VistaSelectBookLayout = new javax.swing.GroupLayout(VistaSelectBook.getContentPane());
        VistaSelectBook.getContentPane().setLayout(VistaSelectBookLayout);
        VistaSelectBookLayout.setHorizontalGroup(
            VistaSelectBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        VistaSelectBookLayout.setVerticalGroup(
            VistaSelectBookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VistaSelectBookLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 20));

        Enc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbelTitulo.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        lbelTitulo.setText("BIBLIO STATE");

        lbelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoista (2).png"))); // NOI18N

        lbelSubtit.setText("Préstamo de Libros Deseados");

        lbelTelInst.setText("Teléfono:07 2809 551");

        lbelID.setText("ID:");

        campoIdSerie.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout EncLayout = new javax.swing.GroupLayout(Enc);
        Enc.setLayout(EncLayout);
        EncLayout.setHorizontalGroup(
            EncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EncLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(EncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbelTitulo)
                    .addGroup(EncLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(EncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbelSubtit)
                            .addGroup(EncLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(EncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbelTelInst)
                                    .addGroup(EncLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lbelID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(EncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(separatorId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campoIdSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(50, 50, 50)
                .addComponent(lbelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        EncLayout.setVerticalGroup(
            EncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addGroup(EncLayout.createSequentialGroup()
                        .addComponent(lbelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbelSubtit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbelTelInst)
                        .addGap(17, 17, 17)
                        .addGroup(EncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbelID)
                            .addComponent(campoIdSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separatorId, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Pedido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbelCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbelCliente.setText("CLIENTE:");

        lbelCedula.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbelCedula.setText("CEDULA:");

        lbelDireccion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbelDireccion.setText("DIRECCION:");

        lbelTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbelTelefono.setText("TELEFONO:");

        txtNombre.setFocusable(false);

        txtCedula.setFocusable(false);

        txtTelefono.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("FECHA INICIO:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("FECHA FIN:");

        txtDireccion.setFocusable(false);

        fecha_in.setDateFormatString("yyyy-MM-dd");
        fecha_in.setMinSelectableDate(new java.util.Date(1577858464000L));

        buttonCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente.png"))); // NOI18N
        buttonCliente.setText("Elegir cliente");
        buttonCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClienteMouseClicked(evt);
            }
        });

        buttonLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/caja.png"))); // NOI18N
        buttonLibro.setText("Elegir libro");
        buttonLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonLibroMouseClicked(evt);
            }
        });

        buttonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/escritura.png"))); // NOI18N
        buttonEliminar.setText("Eliminar fila");
        buttonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonEliminar.setEnabled(false);
        buttonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEliminarMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelacion.png"))); // NOI18N
        jLabel3.setText("Cancelar");
        jLabel3.setToolTipText("");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(buttonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        fecha_fin.setDateFormatString("yyyy-MM-dd");
        fecha_fin.setMinSelectableDate(new java.util.Date(1577858464000L));

        javax.swing.GroupLayout PedidoLayout = new javax.swing.GroupLayout(Pedido);
        Pedido.setLayout(PedidoLayout);
        PedidoLayout.setHorizontalGroup(
            PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PedidoLayout.createSequentialGroup()
                        .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbelCedula)
                            .addComponent(lbelCliente)
                            .addComponent(lbelDireccion))
                        .addGap(24, 24, 24)
                        .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombre)
                            .addGroup(PedidoLayout.createSequentialGroup()
                                .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fecha_in, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PedidoLayout.createSequentialGroup()
                                        .addComponent(lbelTelefono)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                                    .addGroup(PedidoLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtDireccion)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PedidoLayout.setVerticalGroup(
            PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PedidoLayout.createSequentialGroup()
                        .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbelCliente)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbelCedula)
                            .addComponent(lbelTelefono)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbelDireccion)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addComponent(fecha_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecha_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Detalle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        DetallePedido = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        DetallePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Título", "ISBN"
            }
        ));
        DetallePedido.setFocusable(false);
        DetallePedido.getTableHeader().setReorderingAllowed(false);
        DetallePedido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DetallePedidoFocusLost(evt);
            }
        });
        DetallePedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DetallePedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(DetallePedido);
        if (DetallePedido.getColumnModel().getColumnCount() > 0) {
            DetallePedido.getColumnModel().getColumn(0).setPreferredWidth(115);
            DetallePedido.getColumnModel().getColumn(1).setPreferredWidth(425);
            DetallePedido.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        javax.swing.GroupLayout DetalleLayout = new javax.swing.GroupLayout(Detalle);
        Detalle.setLayout(DetalleLayout);
        DetalleLayout.setHorizontalGroup(
            DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetalleLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DetalleLayout.setVerticalGroup(
            DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DetalleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Buttons.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        DescarteDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/archivo.png"))); // NOI18N
        DescarteDate.setText("Descartar");
        DescarteDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DescarteDate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DescarteDate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DescarteDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescarteDateActionPerformed(evt);
            }
        });

        SaveDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/expediente.png"))); // NOI18N
        SaveDate.setText("Guardar");
        SaveDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SaveDate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SaveDate.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        SaveDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveDateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("TOTAL DE LIBROS:");

        ContarFilas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ContarFilas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout ButtonsLayout = new javax.swing.GroupLayout(Buttons);
        Buttons.setLayout(ButtonsLayout);
        ButtonsLayout.setHorizontalGroup(
            ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonsLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(DescarteDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(SaveDate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContarFilas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        ButtonsLayout.setVerticalGroup(
            ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SaveDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DescarteDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ContarFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Enc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Detalle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Enc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClienteMouseClicked
        this.VistaSelectCliente.setVisible(true);
    }//GEN-LAST:event_buttonClienteMouseClicked


    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        switch (JOptionPane.showConfirmDialog(rootPane, "¿Realmente quiere salir?\nSus datos no se guardarán.")) {
            case 0:
                this.dispose();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Sus datos se mantendrán.");
                break;
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void buttonLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonLibroMouseClicked
        this.VistaSelectBook.setVisible(true);
    }//GEN-LAST:event_buttonLibroMouseClicked

    private void buttonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEliminarMouseClicked
        try {
            int fila = DetallePedido.getSelectedRow();
            if(fila != -1){
                eliminarFila(fila);
                ContarFilas.setText(String.valueOf(DetallePedido.getRowCount()));
            }else{
                JOptionPane.showMessageDialog(null, "SELECCIONE UNA FILA","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException e) {
            System.out.println("Fallo algo");
        }
    }//GEN-LAST:event_buttonEliminarMouseClicked

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.VistaSelectCliente.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void tablaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseClicked
        if (evt.getClickCount() == 2) {
            int fila = tablaCliente.getSelectedRow();
            if (tablaCliente.getSelectedRow() != -1) {
                Persona p1;
                String cedula = (String) tablaCliente.getValueAt(fila, 0);
                String nombreu = (String) tablaCliente.getValueAt(fila, 1);
                String nombred = (String) tablaCliente.getValueAt(fila, 2);
                String apellidou = (String) tablaCliente.getValueAt(fila, 3);
                String apellidod = (String) tablaCliente.getValueAt(fila, 4);
                String telefono = (String) tablaCliente.getValueAt(fila, 5);
                String direccion = (String) tablaCliente.getValueAt(fila, 6);

                p1 = new Persona(cedula, nombreu, nombred, apellidou, apellidod, telefono, direccion);
                llenarCampos(p1);
                this.VistaSelectCliente.dispose();
            }
        }
    }//GEN-LAST:event_tablaClienteMouseClicked

    private void VistaSelectClienteWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_VistaSelectClienteWindowClosed
        //llenarCampos();
        //JOptionPane.showConfirmDialog(null, "Asd");
    }//GEN-LAST:event_VistaSelectClienteWindowClosed

    private void CancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseClicked
        this.VistaSelectBook.dispose();
    }//GEN-LAST:event_CancelButtonMouseClicked

    private void tablaLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLibroMouseClicked
        try {
            if (evt.getClickCount() == 2) {
                int fila = tablaLibro.getSelectedRow();
                if (tablaLibro.getSelectedRow() != -1) {
                    Libro lib = new Libro();
                    String codigo = tablaLibro.getValueAt(fila, 0).toString();
                    String titulo = tablaLibro.getValueAt(fila, 1).toString();
                    String isbn = tablaLibro.getValueAt(fila, 2).toString();

                    lib = new Libro(codigo, titulo, isbn);
                    agregarFila(lib);
                    ContarFilas.setText(String.valueOf(DetallePedido.getRowCount()));
                    this.VistaSelectBook.dispose();
                }
            }
        } catch (Exception e) {
            System.out.println("Fallo algo: " + e);
        }
    }//GEN-LAST:event_tablaLibroMouseClicked

    private void VistaSelectBookWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_VistaSelectBookWindowClosed

    }//GEN-LAST:event_VistaSelectBookWindowClosed

    private void DetallePedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DetallePedidoMouseClicked
        enableDelete();
    }//GEN-LAST:event_DetallePedidoMouseClicked

    private void DetallePedidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DetallePedidoFocusLost
        enableDelete();
    }//GEN-LAST:event_DetallePedidoFocusLost

    private void SaveDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveDateActionPerformed
        if(modelo.getRowCount() == 0){
            JOptionPane.showMessageDialog(null, "NO SE PUDO GUARDAR\nASEGURESE QUE EXISTAN LIBROS\nA SER PEDIDOS");
        }else{
            guardarEnc();
            guardarDet();
            generarNoSerie();
        }
    }//GEN-LAST:event_SaveDateActionPerformed

    private void DescarteDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescarteDateActionPerformed
        JOptionPane.showMessageDialog(null, ModeloPedido.getIdPerson(txtCedula.getText()));
    }//GEN-LAST:event_DescarteDateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Buttons;
    private javax.swing.JLabel CancelButton;
    private javax.swing.JButton Cancelar;
    private javax.swing.JPanel ContainBut;
    private javax.swing.JLabel ContarFilas;
    private javax.swing.JButton DescarteDate;
    private javax.swing.JPanel Detalle;
    public static javax.swing.JTable DetallePedido;
    private javax.swing.JPanel Enc;
    private javax.swing.ButtonGroup ParBusqueda1;
    private javax.swing.JPanel Pedido;
    private javax.swing.JButton SaveDate;
    private javax.swing.JFrame VistaSelectBook;
    private javax.swing.JFrame VistaSelectCliente;
    private javax.swing.JRadioButton butCat;
    private javax.swing.JRadioButton butTit;
    private javax.swing.JRadioButton buttCod;
    private javax.swing.JLabel buttonCliente;
    private javax.swing.JLabel buttonEliminar;
    private javax.swing.JLabel buttonLibro;
    private javax.swing.JLabel campoIdSerie;
    private com.toedter.calendar.JDateChooser fecha_fin;
    private com.toedter.calendar.JDateChooser fecha_in;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbelCedula;
    private javax.swing.JLabel lbelCliente;
    private javax.swing.JLabel lbelDireccion;
    private javax.swing.JLabel lbelID;
    private javax.swing.JLabel lbelLogo;
    private javax.swing.JLabel lbelSubtit;
    private javax.swing.JLabel lbelTelInst;
    private javax.swing.JLabel lbelTelefono;
    private javax.swing.JLabel lbelTitulo;
    private javax.swing.JRadioButton sApe;
    private javax.swing.JRadioButton sCed;
    private javax.swing.JRadioButton sNom;
    private javax.swing.JSeparator separatorId;
    public static javax.swing.JTable tablaCliente;
    public static javax.swing.JTable tablaLibro;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
