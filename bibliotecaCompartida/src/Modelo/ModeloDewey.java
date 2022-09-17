package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Dewey;
import logico.Dewey;
import java.sql.PreparedStatement;
import logico.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class ModeloDewey {
    
    public ArrayList<Dewey> getDewey() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Dewey> listaDewey = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM dewey");
            
            while(rs.next()){
                Dewey dew = new Dewey();
                dew.setId(rs.getInt("id_dew"));
                dew.setNombre_cat(rs.getString("nombre_sup_cat_dew"));
                listaDewey.add(dew);
            }
        }catch(SQLException e){
            
        }
        return listaDewey;
    }   
    
    public boolean RegistrarDewey(Dewey dew){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO dewey (codigo_dew, nombre_sup_cat_dew, nombre_cat_dew, descripcion_dew)"
                + " VALUES (?, ?, ?, ?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, dew.getCodigo());
            ps.setString(2, dew.getNombre_super_cat());
            ps.setString(3, dew.getNombre_cat());
            ps.setString(4, dew.getDescripcion());
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
        String sql = "SELECT * FROM dewey";
        modelo = new DefaultTableModel();
        Ventana_Dewey.tabladewey.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("CATEGORÍA");
            modelo.addColumn("SUBCATEGORÍA");
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
        for (int i = 0; i < Ventana_Dewey.tabladewey.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }    
}
    

