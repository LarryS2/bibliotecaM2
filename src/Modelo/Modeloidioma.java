package Modelo;

import static Modelo.ModeloPais.modelo;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.sql.Statement;
import gui.Ventana_Idiomas;
import gui.Ventana_paises;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logico.Categoria;
import logico.Conexion;
import logico.Idioma;
import logico.Pais;

public class Modeloidioma {
       
    
    public boolean RegistrarIdioma(Idioma idioma){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO idioma (codigo_idi, nombre_idi, descr_idi, estado_idi) VALUES (?,?,?,False)";
        
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
        
        String sql = "UPDATE idioma SET codigo_idi=?, nombre_idi=?, descr_idi=? WHERE id_idi=? ";
        
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
    
    public static int getId(Idioma idioma){
        int id = 0;
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT id_idi FROM idioma WHERE nombre_idi = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, idioma.getNombre_idioma());
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try{
                con.close();
            }catch(SQLException se){
                System.out.println(se);
            }
        }
        return id;
    }
    
    public int evitarDeleteIdioma(Idioma idioma){
        int cantidad = 0;
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql= "SELECT COUNT(l.id_idioma_lib) FROM libro l, idioma i WHERE l.id_idioma_lib = i.id_idi AND l.id_idioma_lib = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, idioma.getId_idioma());
            rs = ps.executeQuery();
            
            while(rs.next()){
                cantidad = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println("");
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
        return cantidad;
    }
    
    public boolean ActualizarIdiomaEliminado(Idioma idioma){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE idioma SET codigo_idi=?, nombre_idi=?, descr_idi=?, estado_idi = ? WHERE id_idi=? ";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, idioma.getCodigo_idioma());
            ps.setString(2, idioma.getNombre_idioma());
            ps.setString(3, idioma.getDescripcion());
            ps.setBoolean(4, idioma.isEstado());
            ps.setInt(5, idioma.getId_idioma());
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
        
        String sql = "UPDATE idioma SET estado_idi = True WHERE id_idi = ?";
        
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
    
    
//    public boolean BuscarIdioma(Idioma idioma){
//        
//        PreparedStatement ps;
//        Connection con = Conexion.getConnection();
//        ResultSet rs;
//        String sql = "SELECT id_idi, codigo_idi, nombre_idi, descr_idi FROM idioma WHERE codigo_idi=?";
//        
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, idioma.getCodigo_idioma());
//            rs = ps.executeQuery();
//            
//            if(rs.next()){
//                idioma.setId_idioma(Integer.parseInt(rs.getString("id_idi")));
//                idioma.setCodigo_idioma(rs.getString("codigo_idi"));
//                idioma.setNombre_idioma(rs.getString("nombre_idi"));
//                idioma.setDescripcion(rs.getString("descr_idi"));
//                return true;
//            }
//            return false;
//        } catch (SQLException sqle) {
//            System.err.println(sqle);
//            return false;
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException sqle) {
//                System.err.println(sqle);
//            }
//        }
//    }
    public boolean BuscarIdioma(Idioma idioma){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "SELECT id_idi, codigo_idi, nombre_idi, descr_idi FROM idioma WHERE codigo_idi like ? OR nombre_idi like ?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, idioma.getCodigo_idioma());
            ps.setString(2, idioma.getCodigo_idioma());
            return ps.execute();
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
        String sql = "SELECT id_idi, codigo_idi, nombre_idi, descr_idi FROM idioma WHERE estado_idi = False";
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
        String sql = "SELECT id_idi, codigo_idi, nombre_idi, descr_idi FROM idioma WHERE estado_idi = True";
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
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    public ArrayList<Idioma> getIdioma() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Idioma> listaidiomas = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_idi, nombre_idi FROM idioma WHERE estado_idi = False");
            
            while(rs.next()){
                Idioma idioma = new Idioma();
                idioma.setId_idioma(rs.getInt("id_idi"));
                idioma.setNombre_idioma(rs.getString("nombre_idi"));
                listaidiomas.add(idioma);
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
        return listaidiomas;
    }
    
    public ArrayList<Idioma> getIdiomaEliminado() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Idioma> listaidiomas = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_idi, nombre_idi FROM idioma WHERE estado_idi = True");
            
            while(rs.next()){
                Idioma idioma = new Idioma();
                idioma.setId_idioma(rs.getInt("id_idi"));
                idioma.setNombre_idioma(rs.getString("nombre_idi"));
                listaidiomas.add(idioma);
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
        return listaidiomas;
    }
    
    public static void getTablaConsultaCodigoIdioma(Idioma idioma){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT id_idi, codigo_idi, nombre_idi, descr_idi FROM idioma WHERE codigo_idi like ? OR nombre_idi like ?";
        modelo = new DefaultTableModel();
        Ventana_Idiomas.tablaIdiomas.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
            st.setString(1, idioma.getCodigo_idioma());
            st.setString(2, idioma.getCodigo_idioma());
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DESCRIPCIÓN");
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
