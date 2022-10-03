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
import logico.Detalle_Devolucion;
import logico.Devolucion;
import logico.Estudiante;
import logico.Libro;

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


    public boolean registrarDetalleDev(Detalle_Devolucion dv){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO detalle_devolucion (id_enc_dev, id_lib_dev, estado_dev_mul) VALUES (?,?,False)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getId_enc_dev());
            ps.setInt(2, dv.getId_lib());
            ps.execute();
            return true;
        }catch(NumberFormatException | SQLException e){
            System.out.println(e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    
    
    public static int idLibro(Libro libro){
        int idl = 0;
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT id_lib FROM libro WHERE codigo_lib = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, libro.getCodigo());
            rs = ps.executeQuery();
            while(rs.next()){
                idl = rs.getInt(1);
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
        return idl;
    }    

    public static String idDevolucion(){
        String idd = "";
        String sql = "SELECT id_dev FROM encabezado_devolucion ORDER BY id_dev DESC LIMIT 1";
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               idd = rs.getString(1);
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
        return idd;
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

    public static void getTablaDetalles() {
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT l.codigo_lib, l.isbn_lib, l.titulo_lib FROM libro l, detalle_pedido dp, encabezado_pedido ec, ejemplar e "
                + "WHERE (ec.id_enc_ped=dp.id_enc_ped) AND (e.id_lib_ejem=l.id_lib)";
        modelo = new DefaultTableModel();

        Ventana_Devolucion.tabladet.setModel(modelo);
        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("CÓDIGO");
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
