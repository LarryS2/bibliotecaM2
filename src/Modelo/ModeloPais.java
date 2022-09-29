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
    
    public boolean RegistrarPais(Pais pais){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO pais (codigo_pais, nombre_pais, descripcion_pais, estado_pais) VALUES (?, ?, ?, False)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, pais.getCodigo_pais());
            ps.setString(2, pais.getNombre_pais());
            ps.setString(3, pais.getDesc_pais());
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
        
        String sql = "UPDATE pais SET codigo_pais = ?, nombre_pais = ?, descripcion_pais = ? WHERE id_pais = ?";
        
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
        
        String sql = "UPDATE pais SET codigo_pais = ?, nombre_pais = ?, descripcion_pais = ?, estado_pais = ? WHERE id_pais = ?";
        
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
        String sql = "SELECT id_pais, codigo_pais, nombre_pais, descripcion_pais FROM pais WHERE estado_pais = false";
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
