package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Autor;
import logico.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logico.Autor;

/*
*
*Método para mandar un objeto de tipo Autor al combobox de la vista Libros//
*
*/
public class ModeloAutores {

    public ArrayList<Autor> getAutor() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Autor> listaAutor = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT ID, PRIMER_NOMBRE, PRIMER_APELLIDO FROM AUTOR WHERE ELIMINADO = 1");
            
            while(rs.next()){
                Autor autor = new Autor();
                autor.setId_autor(rs.getInt("ID"));
                autor.setNombre_autor(rs.getString("PRIMER_NOMBRE"));
                autor.setApellido_autor(rs.getString("PRIMER_APELLIDO"));
                listaAutor.add(autor);
            }
        }catch(SQLException e){
            
        }
        return listaAutor;
    }

    /*
    *
    *Método para hacer el insert en la base de datos.
    *
    */
    public boolean RegistrarAutor(Autor autor){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO autor (CODIGO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, FECHA_NAC, LENGUA_MATERNA, PAIS_ORIGEN, ELIMINADO) VALUES(?,?,?,?,?,?,?,?, 1)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, autor.getCod_autor());
            ps.setString(2, autor.getNombre_autor());
            ps.setString(3, autor.getSegundo_nombre_autor());
            ps.setString(4, autor.getApellido_autor());
            ps.setString(5, autor.getSegundo_apellido_autor());
            ps.setDate(6, (Date) autor.getFecha_nac());
            ps.setString(7, autor.getLengua_materna());
            ps.setString(8, autor.getPais_origen());
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
    *Método para modificar autor//
    *
    */
    public boolean ModificarAutor(Autor autor){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE autor SET CODIGO=?, PRIMER_NOMBRE=?, SEGUNDO_NOMBRE=?, PRIMER_APELLIDO=?, SEGUNDO_APELLIDO=?, FECHA_NAC=?, LENGUA_MATERNA=?, PAIS_ORIGEN=? WHERE ID=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, autor.getCod_autor());
            ps.setString(2, autor.getNombre_autor());
            ps.setString(3, autor.getSegundo_nombre_autor());
            ps.setString(4, autor.getApellido_autor());
            ps.setString(5, autor.getSegundo_apellido_autor());
            ps.setDate(6,  autor.getFecha_nac());
            ps.setString(7, autor.getLengua_materna());
            ps.setString(8, autor.getPais_origen());
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
    *Método para llenar la tabla de la vista autor//
    *
    */
    static DefaultTableModel modelo = new DefaultTableModel();
    
    public static void getTabla(){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM AUTOR WHERE ELIMINADO = 1";
        modelo = new DefaultTableModel();
        Ventana_Autor.tablaautores.setModel(modelo);
        
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CÓDIGO");
            modelo.addColumn("PRIMER NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("PRIMER APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");
            modelo.addColumn("FECHA NACIMIENTO");
            modelo.addColumn("LENGUA MATERNA");
            modelo.addColumn("PAÍS DE ORIGEN");
            
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
        String sql = "SELECT * FROM AUTOR WHERE ELIMINADO = 0";
        modelo = new DefaultTableModel();
        Ventana_Autor.tablaautores.setModel(modelo);
        
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CÓDIGO");
            modelo.addColumn("PRIMER NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("PRIMER APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");
            modelo.addColumn("FECHA NACIMIENTO");
            modelo.addColumn("LENGUA MATERNA");
            modelo.addColumn("PAÍS DE ORIGEN");
            
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
        for (int i = 0; i < Ventana_Autor.tablaautores.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    } 
    /*
    *
    *Método para eliminar autor//
    *
    */
    public boolean EliminarAutor(Autor autor){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE autor SET ELIMINADO = 0 WHERE ID=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, autor.getId_autor());
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
    public boolean BuscarAutor(Autor autor){
        
        PreparedStatement ps;
        ResultSet rs = null;
        Connection con = Conexion.getConnection();
        
        String sql = "SELECT FROM autor WHERE =?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, autor.getCod_autor());
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
    
}
