package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Editorial;
import java.sql.PreparedStatement;
import logico.Conexion;
import java.sql.Connection;
import logico.Editorial;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;

public class ModeloEditorial {

    public ArrayList<Editorial> getEditorial() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Editorial> listaEditorial = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_edi, nombre_edi FROM editorial WHERE estado_edi = False");
            
            while(rs.next()){
                Editorial edi = new Editorial();
                edi.setId(rs.getInt("id_edi"));
                edi.setNombre(rs.getString("nombre_edi"));
                listaEditorial.add(edi);
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
        return listaEditorial;
    }
    
    public ArrayList<Editorial> getEditorialEliminado() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Editorial> listaEditorial = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_edi, nombre_edi FROM editorial WHERE estado_edi = True");
            
            while(rs.next()){
                Editorial edi = new Editorial();
                edi.setId(rs.getInt("id_edi"));
                edi.setNombre(rs.getString("nombre_edi"));
                listaEditorial.add(edi);
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
        return listaEditorial;
    }
    
    public boolean RegistrarCategoria(Editorial edi){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO editorial (codigo_edi, nombre_edi, DIRECCION, TIPO, NOMBRE_R, APELLIDO_R, URL, ESTADO) VALUES (?,?,?,?,?,?,?,False)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, edi.getCodigo());
            ps.setString(2, edi.getNombre());
            ps.setString(3, edi.getDireccion());
            ps.setString(4, edi.getTipo_editorial());
            ps.setString(5, edi.getNombre_rep());
            ps.setString(6, edi.getApellido_rep());
            ps.setString(7, edi.getUrl_editorial());
            ps.execute();
            return true;
        } catch (SQLException sqle) {
            System.err.println(sqle);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    public boolean ModificarCategoria(Editorial edi){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE editorial SET CODIGO = ?, NOMBRE = ?, DIRECCION = ?, TIPO = ?, NOMBRE_R = ?, APELLIDO_R = ?, URL = ? WHERE ID = ?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, edi.getCodigo());
            ps.setString(2, edi.getNombre());
            ps.setString(3, edi.getDireccion());
            ps.setString(4, edi.getTipo_editorial());
            ps.setString(5, edi.getNombre_rep());
            ps.setString(6, edi.getApellido_rep());
            ps.setString(7, edi.getUrl_editorial());
            ps.setInt(8, edi.getId());
            ps.execute();
            return true;
        } catch (SQLException sqle) {
            System.err.println(sqle);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    public boolean Eliminar(Editorial edi){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE editoriaL SET ESTADO = True WHERE ID = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, edi.getId());
            ps.execute();
            return true;
        } catch (SQLException sqle) {
            System.err.println(sqle);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    public boolean ModificarCategoriaEliminado(Editorial edi){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE editorial SET CODIGO = ?, NOMBRE = ?, DIRECCION = ?, TIPO = ?, NOMBRE_R = ?, APELLIDO_R = ?, URL = ?, ESTADO = ? WHERE ID = ?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, edi.getCodigo());
            ps.setString(2, edi.getNombre());
            ps.setString(3, edi.getDireccion());
            ps.setString(4, edi.getTipo_editorial());
            ps.setString(5, edi.getNombre_rep());
            ps.setString(6, edi.getApellido_rep());
            ps.setString(7, edi.getUrl_editorial());
            ps.setBoolean(8, edi.isEstado());
            ps.setInt(9, edi.getId());
            ps.execute();
            return true;
        } catch (SQLException sqle) {
            System.err.println(sqle);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    static DefaultTableModel modelo;
    public static void getTabla(){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT ID, CODIGO, NOMBRE, DIRECCION, TIPO, NOMBRE_R, APELLIDO_R, URL FROM editorial WHERE ESTADO = False";
        modelo = new DefaultTableModel();
        Ventana_Editorial.tablaEditorial.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DIRECCIÓN");
            modelo.addColumn("TIPO");
            modelo.addColumn("NOMBRE REPRESENTANTE");
            modelo.addColumn("APELLIDO REPRESENTANTE");
            modelo.addColumn("URL");
            while(rs.next()){
                Object[] filas = new Object[columns];
                
                for(int i = 0; i < columns; i++){
                    filas[i] = rs.getObject(i+1);
                }   
                modelo.addRow(filas);
            }    
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    public static void getTablaEliminado(){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT ID, CODIGO, NOMBRE, DIRECCION, TIPO, NOMBRE_R, APELLIDO_R, URL FROM editorial WHERE ESTADO = True";
        modelo = new DefaultTableModel();
        Ventana_Editorial.tablaEditorial.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DIRECCIÓN");
            modelo.addColumn("TIPO");
            modelo.addColumn("NOMBRE REPRESENTANTE");
            modelo.addColumn("APELLIDO REPRESENTANTE");
            modelo.addColumn("URL");
            while(rs.next()){
                Object[] filas = new Object[columns];
                
                for(int i = 0; i < columns; i++){
                    filas[i] = rs.getObject(i+1);
                }   
                modelo.addRow(filas);
            }    
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    public static void Limpiar_Tabla(){
        for (int i = 0; i < Ventana_Editorial.tablaEditorial.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
   
   
   
}
