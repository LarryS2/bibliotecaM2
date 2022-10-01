package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_paises;
import logico.Pais;
import java.sql.PreparedStatement;
import logico.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import logico.Ciudad;
import logico.Zona;

public class ModeloPais {
   
    public ArrayList<Pais> getPais() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Pais> listaPais = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_pais, nombre_pais FROM pais WHERE estado_pais = False");
            
            while(rs.next()){
                Pais pa = new Pais();
                pa.setId_pais(rs.getInt("id_pais"));
                pa.setNombre_pais(rs.getString("nombre_pais"));
                listaPais.add(pa);
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
        return listaPais;
    }
    
    
    public ArrayList<Ciudad> getCiudad() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Ciudad> listaCiudad = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_ciu, id_ciu_pais, nombre_ciu FROM ciudad WHERE estado_ciu = False");
            
            while(rs.next()){
                Ciudad ciudad = new Ciudad();
                ciudad.setId_ciudad(rs.getInt("id_ciu"));
                ciudad.setId_pais_ciu(rs.getInt("id_ciu_pais"));
                ciudad.setNombre_ciudad(rs.getString("nombre_ciu"));
                listaCiudad.add(ciudad);
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
        return listaCiudad;
    }
    
    
    public ArrayList<Pais> getPaisEliminado() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Pais> listaPais = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_pais, nombre_pais FROM pais WHERE estado_pais = True");
            
            while(rs.next()){
                Pais pa = new Pais();
                pa.setId_pais(rs.getInt("id_pais"));
                pa.setNombre_pais(rs.getString("nombre_pais"));
                listaPais.add(pa);
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
        return listaPais;
    }
    
    public static int getId(Pais pais){
        int id = 0;
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT id_pais FROM pais WHERE nombre_pais = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getNombre_pais());
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
    
    
    //Registro completo de país, ciudad y zona(barrio)
    
    
    public boolean RegistrarPais(Pais pais){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO pais (codigo_pais, nombre_pais, desc_pais, estado_pais) "
                + "VALUES (?, ?, ?, ?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getCodigo_pais());
            ps.setString(2, pais.getNombre_pais());
            ps.setString(3, pais.getDesc_pais());
            ps.setBoolean(4, pais.isEstado());
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
    
    
    public boolean RegistrarCiudad(Ciudad ciu){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO ciudad (id_ciu_pais, nombre_ciu, estado_ciu) "
                + " VALUES ((SELECT id_pais FROM pais ORDER BY id_pais DESC LIMIT 1), "
                + "?, ?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, ciu.getNombre_ciudad());
            ps.setBoolean(2, ciu.isEstado());
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
    

    public boolean RegistrarZona(Zona bar){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO barrio (id_ciu_bar, nombre_bar, calle_prin_bar, "
                + "calle_sec_bar, estado_bar) "
                + " VALUES ((SELECT id_ciu FROM ciudad ORDER BY id_ciu DESC LIMIT 1), "
                + "?, ?, ?, ?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, bar.getNombre_bar());
            ps.setString(2, bar.getCalle_prin());
            ps.setString(3, bar.getCalle_sec());
            ps.setBoolean(4, bar.isEstado_bar());
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
    
    
    public boolean ActualizarPais(Pais pais){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE pais SET codigo_pais = ?, nombre_pais = ?, desc_pais = ? WHERE id_pais = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getCodigo_pais());
            ps.setString(2, pais.getNombre_pais());
            ps.setString(3, pais.getDesc_pais());
            ps.setInt(4, pais.getId_pais());
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
    
    public boolean ActualizarPaisEliminado(Pais pais){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE pais SET codigo_pais = ?, nombre_pais = ?, desc_pais = ?, estado_pais = ? WHERE id_pais = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getCodigo_pais());
            ps.setString(2, pais.getNombre_pais());
            ps.setString(3, pais.getDesc_pais());
            ps.setBoolean(4, pais.isEstado());
            ps.setInt(5, pais.getId_pais());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException sqle){
                System.out.println(sqle);
            }
        }
    }
    
    public boolean EliminarPais(Pais pais){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE pais SET estado_pais = True WHERE id_pais = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, pais.getId_pais());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException sqle){
                System.out.println(sqle);
            }
        }
    }
    
        
    static DefaultTableModel modelo;
    public static void getTabla(){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT id_pais, codigo_pais, nombre_pais, desc_pais FROM pais WHERE estado_pais = false";
        modelo = new DefaultTableModel();
        Ventana_paises.tablapaises.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
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
        }finally{
            try{
                con.close();
            }catch(SQLException sqle){
                System.out.println(sqle);
            }
        }
    }
    
    public static void getTablaEliminados(){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT id_pais, codigo_pais, nombre_pais, descripcion_pais FROM pais WHERE estado_pais = True";
        modelo = new DefaultTableModel();
        Ventana_paises.tablapaises.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
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
        }finally{
            try{
                con.close();
            }catch(SQLException sqle){
                System.out.println(sqle);
            }
        }
    }
    
    public static void Limpiar_Tabla(){
        for (int i = 0; i < Ventana_paises.tablapaises.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }     
    
}
