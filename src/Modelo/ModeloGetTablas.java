package Modelo;

import gui.Prestamo;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import logico.Conexion;

/**
 *
 * @author Lenin
 */
public class ModeloGetTablas {

    static DefaultTableModel modelo;

    public static void getTablaCliente() {

        //Cambiar sentencia sql, filtrar autores no personas!!!
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT cedula_per, primer_nombre_per, segundo_nombre_per, primer_apellido_per, segundo_apellido_per, telefono_per, id_barrio_per FROM persona p WHERE estado_per = False";
        modelo = new DefaultTableModel();
        Prestamo.tablaCliente.setModel(modelo);
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("Cédula");
            modelo.addColumn("Primer Nombre");
            modelo.addColumn("Segundo Nombre");
            modelo.addColumn("Primer Apellido");
            modelo.addColumn("Segundo Apellido");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Dirección");

            while (rs.next()) {
                Object[] filas = new Object[columns];

                for (int i = 0; i < columns; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }

    //Ingresar condición de eliminados
    public static void getTablaLibro() {

        //Adecuar sentencia sql a la nueva BD
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT l.codigo_lib, l.titulo_lib, l.isbn_lib, d.nombre_cat_dew, CONCAT(p.primer_nombre_per, ' ', p.primer_apellido_per), "
                + "l.fecha_pub_lib FROM libro l, dewey d, autor a, persona p WHERE l.id_aut_lib = a.id_aut AND l.id_dew_lib = d.id_dew AND a.id_per_aut = p.id_per;";
        modelo = new DefaultTableModel();
        Prestamo.tablaLibro.setModel(modelo);
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("Código");
            modelo.addColumn("Título");
            modelo.addColumn("ISBN");
            modelo.addColumn("Categoria");
            modelo.addColumn("Nombre Autor");
            modelo.addColumn("Fecha de Publicación");

            while (rs.next()) {
                Object[] filas = new Object[columns];

                for (int i = 0; i < columns; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
}
