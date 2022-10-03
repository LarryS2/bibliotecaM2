package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Libro;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import logico.Conexion;
import logico.Ejemplar;
import logico.Libro;

public class ModeloLibro {
    
    public boolean RegistrarLibro(Libro lib){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO libro (codigo_lib, titulo_lib, desc_lib, isbn_lib, fecha_pub_lib, num_pags,"
                + " id_aut_lib, id_dew_lib, id_idioma_lib, id_sec_lib, id_edi_lib) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, lib.getCodigo());
            ps.setString(2, lib.getTitulo());
            ps.setString(3, lib.getDescripcion());
            ps.setString(4, lib.getIsbn());
            ps.setDate(5, (Date) lib.getFecha_Publicacion());
            ps.setInt(6, lib.getNumero_pags());
            ps.setInt(7, lib.getId_autor());
            ps.setInt(8, lib.getDewey());
            ps.setInt(9, lib.getId_idioma());
            ps.setInt(10, lib.getId_seccion());
            ps.setInt(11, lib.getId_editorial());
            
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
     
    
    public boolean ModificarLibro(Libro lib){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE libro SET codigo_lib=?, titulo_lib=?, desc_lib=?, isbn_lib=?, id_dew_lib=?,"
                + " fecha_pub_lib=?, num_pags=?, id_aut_lib=?, id_idioma_lib=?, id_sec_lib=?, "
                + "id_edi_lib=? WHERE id_lib=?";
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, lib.getCodigo());
            ps.setString(2, lib.getTitulo());
            ps.setString(3, lib.getDescripcion());
            ps.setString(4, lib.getIsbn());
            ps.setInt(5, lib.getDewey());
            ps.setDate(6, (Date) lib.getFecha_Publicacion());
            ps.setInt(7, lib.getNumero_pags());
            ps.setInt(8, lib.getId_autor());
            ps.setInt(9, lib.getId_idioma());
            ps.setInt(10, lib.getId_seccion());
            ps.setInt(11, lib.getId_editorial());
            ps.setInt(12, lib.getId());
            ps.executeUpdate();
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
        String sql = "SELECT l.id_lib, l.codigo_lib, l.titulo_lib, l.desc_lib, l.isbn_lib, d.nombre_sup_cat_dew, l.fecha_pub_lib, l.num_pags, "
                + "CONCAT(p.primer_nombre_per, ' ', p.primer_apellido_per), i.nombre_idi, e.nombre_edi "
                + "FROM libro l, idioma i, dewey d, persona p, autor a, editorial e "
                + "WHERE p.id_per = a.id_per_aut AND a.id_aut = l.id_aut_lib AND l.id_dew_lib = d.id_dew AND e.id_edi = l.id_edi_lib AND i.id_idi = l.id_idioma_lib";
        modelo = new DefaultTableModel();
        Ventana_Libro.tablalibros.setModel(modelo);
        
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("TÍTULO");
            modelo.addColumn("DESCRIPCIÓN");
            modelo.addColumn("ISBN");
            modelo.addColumn("DEWEY");
            modelo.addColumn("FECHA PUBLICACIÓN");
            modelo.addColumn("Nº PÁGINAS");
            modelo.addColumn("AUTOR");
            modelo.addColumn("IDIOMA");
            modelo.addColumn("EDITORIAL");
            
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

    public static void getTablaDinamica(String bus){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
//        String sql = "SELECT CODIGO, TITULO, DESCRIPCION, ISBN, DEWEY, "
//                + "FECHA_PUBLICACION, NUM_PAGS, ID_AUTOR, "
//                + "ID_IDIOMA, ID_CATEGORIA, ID_EDITORIAL"
//                + " FROM libro WHERE TITULO OR DESCRIPCION LIKE '%"+bus+"%'";
        String sql = "SELECT * FROM LIBRO WHERE TITULO OR DESCRIPCION LIKE '%"+bus+"%'";
        modelo = new DefaultTableModel();
        Ventana_Libro.tablalibros.setModel(modelo);
        
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CÓDIGO");
            modelo.addColumn("TÍTULO");
            modelo.addColumn("DESCRIPCIÓN");
            modelo.addColumn("ISBN");
            modelo.addColumn("DEWEY");
            modelo.addColumn("FECHA PUBLICACIÓN");
            modelo.addColumn("Nº PÁGINAS");
            modelo.addColumn("AUTOR");
            modelo.addColumn("IDIOMA");
            modelo.addColumn("CATEGORÍA");
            modelo.addColumn("EDITORIAL");
            
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
        for (int i = 0; i < Ventana_Libro.tablalibros.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    } 
    
    public int getIdMax(){
        int idLib = 0;
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT MAX(id_lib) FROM libro";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                idLib = rs.getInt(1);
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
        return idLib;
    }
    
    public String NoSerie(){
        String serie = "";
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT MAX(cod_ejem) FROM ejemplar";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                serie = rs.getString(1);
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
        return serie;
    }
    
    public boolean registrarEjemplar(Ejemplar ejemplar){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO ejemplar(cod_ejem, id_lib_ejem, cantidad_ejem) VALUES (?, ?, ?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, ejemplar.getCodigo());
            ps.setInt(2, ejemplar.getCod_libro());
            ps.setInt(3, ejemplar.getCantidad());
            return ps.execute();
        }catch(SQLException e){
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
}
