package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Categoria;
import logico.Categoria;
import java.sql.PreparedStatement;
import logico.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ModeloCategoria {
    
    public ArrayList<Categoria> getCategoria() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Categoria> listaCategoria = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM categoria");
            
            while(rs.next()){
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("ID"));
                cat.setNombre_cat(rs.getString("NOMBRE"));
                listaCategoria.add(cat);
            }
        }catch(SQLException e){
            
        }
        return listaCategoria;
    }   
    
    public boolean RegistrarCategoria(Categoria cat){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO categoria (CODIGO, NOMBRE) VALUES (?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getCodigo_cat());
            ps.setString(2, cat.getNombre_cat());
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
        String sql = "SELECT * FROM categoria";
        modelo = new DefaultTableModel();
        Ventana_Categoria.tablacategoria.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            
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
    /*
    *
    *Método para modificar categoria//
    *
    */
    public boolean ModificarCategoria(Categoria cat){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE categoria SET CODIGO=?, NOMBRE=? WHERE ID=? ";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getCodigo_cat());
            ps.setString(2, cat.getNombre_cat());
            ps.setInt(3, cat.getId());
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
    
    /*
    *
    *Método para eliminar //
    *
    */
    public boolean EliminarCategoria(Categoria cat){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "DELETE FROM categoria WHERE ID=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getCodigo_cat());
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
    
    
    
    /*
    *
    *Método para buscar autor//
    *
    */  
    public boolean BuscarCategoria(Categoria cat){
        
        PreparedStatement ps;
        ResultSet rs = null;
        Connection con = Conexion.getConnection();
        
        String sql = "SELECT * FROM categoria WHERE CODIGO=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getCodigo_cat());
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
    
    
    public static void getTablaConsultaCodigo(Categoria cat){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM categoria WHERE CODIGO=?";
        modelo = new DefaultTableModel();
        Ventana_Categoria.tablacategoria.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
            st.setString(1, cat.getCodigo_cat());
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            
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
        for (int i = 0; i < Ventana_Categoria.tablacategoria.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
}
