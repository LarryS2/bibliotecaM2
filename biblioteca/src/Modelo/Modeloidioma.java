package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Statement;
import gui.Ventana_Idiomas;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logico.Conexion;
import logico.Idioma;

public class Modeloidioma {
       
    public ArrayList<Idioma> getIdioma() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Idioma> listaIdioma = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT ID, NOMBRE FROM IDIOMA WHERE ELIMINADO = 1");
            
            while(rs.next()){
                Idioma idio = new Idioma();
                idio.setId_idioma(rs.getInt("ID"));
                idio.setNombre_idioma(rs.getString("NOMBRE"));
                listaIdioma.add(idio);
            }
        }catch(SQLException e){
            
        }
        return listaIdioma;
    }
    
    public boolean RegistrarIdioma(Idioma idioma){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO idioma (CODIGO, NOMBRE, DESCRIPCION, ELIMINADO) VALUES (?,?,?,1)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, idioma.getCodigo_idioma());
            ps.setString(2, idioma.getNombre_idioma());
            ps.setString(3, idioma.getDescripcion());
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
    
        
    public boolean ActualizarIdioma(Idioma idioma){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE idioma SET CODIGO=?, NOMBRE=?, DESCRIPCION=? WHERE ID=? ";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, idioma.getCodigo_idioma());
            ps.setString(2, idioma.getNombre_idioma());
            ps.setString(3, idioma.getDescripcion());
            ps.setInt(4, idioma.getId_idioma());
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
    
    
    public boolean EliminarIdioma(Idioma idioma){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE idioma SET ELIMINADO = 0 WHERE ID = ?";
        //String sql = "DELETE FROM idioma WHERE ID=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idioma.getId_idioma());
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
    
    
    public boolean BuscarIdioma(Idioma idioma){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        String sql = "SELECT * FROM idioma WHERE CODIGO=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, idioma.getCodigo_idioma());
            rs = ps.executeQuery();
            
            if(rs.next()){
                idioma.setId_idioma(Integer.parseInt(rs.getString("ID")));
                idioma.setCodigo_idioma(rs.getString("CODIGO"));
                idioma.setNombre_idioma(rs.getString("NOMBRE"));
                idioma.setDescripcion(rs.getString("DESCRIPCION"));
                return true;
            }
            return false;
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
        String sql = "SELECT ID, CODIGO, NOMBRE, DESCRIPCION FROM IDIOMA WHERE ELIMINADO = 1";
        modelo = new DefaultTableModel();
        Ventana_Idiomas.tablaIdiomas.setModel(modelo);
        
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DESCRIPCION");
            
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
    
    public static void getTablaEliminados(){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT ID, CODIGO, NOMBRE, DESCRIPCION FROM IDIOMA WHERE ELIMINADO = 0";
        modelo = new DefaultTableModel();
        Ventana_Idiomas.tablaIdiomas.setModel(modelo);
        
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DESCRIPCION");
            
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
        for (int i = 0; i < Ventana_Idiomas.tablaIdiomas.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }  
}
