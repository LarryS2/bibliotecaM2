package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Devolucion;
import java.sql.Date;
import java.sql.PreparedStatement;
import logico.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import logico.Devolucion;
import logico.Estudiante;

public class ModeloDevolucion {

    public boolean RegistrarEncaDevolucion(Devolucion dev) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();

        String sql = "INSERT INTO encabezado_devolucion (fecha_dev, id_est_dev, estado_dev) "
                + "VALUES (?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, (Date) dev.getFecha_dev());
            ps.setInt(2, dev.getId_est_dev());
            ps.setBoolean(3, dev.isEstado());
            ps.execute();

            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

static DefaultTableModel modelo = new DefaultTableModel();

    
    public static int getIdPerson(String cedula){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT e.id_est  FROM persona p, estudiante e WHERE (p.cedula_per=?) AND "
                + "(p.id_per=e.id_per_est)";
        
        int idp = 0;
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            while(rs.next()){
                idp = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
        return idp;
    }


    public static void getTabla() {
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT cedula_per, primer_nombre_per, segundo_nombre_per, primer_apellido_per, "
                + "segundo_apellido_per  FROM persona WHERE (id_rol_per = 2) AND (estado_per = False)";
        modelo = new DefaultTableModel();

        Ventana_Devolucion.tabladevolucion.setModel(modelo);
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("CÉDULA");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");            

            while (rs.next()) {
                Object[] filas = new Object[columns];

                for (int i = 0; i < columns; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static void getTablaDetalles(Estudiante est) {
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT l.isbn_lib, l.titulo_lib FROM libro l, detalle_pedido dp, "
                + "encabezado_pedido ec WHERE l.id_lib=dp.id_lib_det AND  "
                + "(SELECT p.id_per FROM persona p WHERE p.cedula_per=?)=ec.id_cliente_ped";
        modelo = new DefaultTableModel();

        Ventana_Devolucion.tabladevolucion.setModel(modelo);
        try {
            st = con.prepareStatement(sql);
            st.setString(1, est.getCedula());
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ISBN");
            modelo.addColumn("TITULO");           

            while (rs.next()) {
                Object[] filas = new Object[columns];

                for (int i = 0; i < columns; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public static void Limpiar_Tabla() {
        for (int i = 0; i < Ventana_Devolucion.tabladevolucion.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

}
