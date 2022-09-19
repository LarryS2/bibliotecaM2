package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Seccion;
import logico.Seccion;
import java.sql.PreparedStatement;
import logico.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class ModeloSeccion {
    
    public boolean RegistrarSeccion(Seccion sec){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO seccion (CODIGO, NOMBRE, DESCRIPCION) VALUES (?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sec.getCodigo_zona());
            ps.setString(2, sec.getNombre_zona());
            ps.setString(3, sec.getDescripcion());
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
    
    
    public boolean ModificarSeccion(Seccion sec){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE seccion SET CODIGO=?, NOMBRE=?, DESCRIPCION=? WHERE ID=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sec.getCodigo_zona());
            ps.setString(2, sec.getNombre_zona());
            ps.setString(3, sec.getDescripcion());
            ps.setInt(4, sec.getId());
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
    
    
    public boolean EliminarSeccion(Seccion sec){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "DELETE FROM seccion WHERE ID=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, sec.getId());
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
        String sql = "SELECT * FROM seccion";
        modelo = new DefaultTableModel();
        Ventana_Seccion.tablaseccion.setModel(modelo);
        
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
        for (int i = 0; i < Ventana_Seccion.tablaseccion.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    } 
    
}
