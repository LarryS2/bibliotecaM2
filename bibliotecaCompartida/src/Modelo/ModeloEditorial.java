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
            rs = st.executeQuery("SELECT * FROM editorial");
            
            while(rs.next()){
                Editorial edi = new Editorial();
                edi.setId(rs.getInt("ID"));
                edi.setNombre(rs.getString("NOMBRE"));
                listaEditorial.add(edi);
            }
        }catch(SQLException e){
            
        }
        return listaEditorial;
    }
    
    
    
    public boolean RegistrarCategoria(Editorial edi){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO editorial (CODIGO, NOMBRE, DIRECCCION, TIPO, NOMBRE_R, APELLIDO_R, URL, ESTADO) VALUES (?,?,?,?,?,?,?,?)";
        
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
        String sql = "SELECT * FROM editorial";
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
            modelo.addColumn("ESTADO");
            while(rs.next()){
                Object[] filas = new Object[columns];
                
                for(int i = 0; i < columns; i++){
                    filas[i] = rs.getObject(i+1);
                }   
                modelo.addRow(filas);
            }    
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    
    public boolean ConsultarCategoriaCodigo(Editorial edi){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "SELECT * FROM editorial WHERE CODIGO=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, edi.getCodigo());
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
   

    public static void getTablaConsultaCodigo(Editorial edi){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM editorial WHERE CODIGO=?";
        modelo = new DefaultTableModel();
        Ventana_Editorial.tablaEditorial.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
            st.setString(1, edi.getCodigo());
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
            modelo.addColumn("ESTADO");
            while(rs.next()){
                Object[] filas = new Object[columns];
                
                for(int i = 0; i < columns; i++){
                    filas[i] = rs.getObject(i+1);
                }   
                modelo.addRow(filas);
            }    
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    
    public static void Limpiar_Tabla(){
        for (int i = 0; i < Ventana_Editorial.tablaEditorial.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
   
   
   
}
