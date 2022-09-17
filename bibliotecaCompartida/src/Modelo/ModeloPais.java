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
            rs = st.executeQuery("SELECT * FROM pais");
            
            while(rs.next()){
                Pais pa = new Pais();
                pa.setId_pais(rs.getInt("ID"));
                pa.setNombre_pais(rs.getString("NOMBRE"));
                listaPais.add(pa);
            }
        }catch(SQLException e){
            
        }
        return listaPais;
    }   
    
    public boolean RegistrarPais(Pais pais){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO pais (codigo_pais, nombre_pais, descripcion_pais)"
                + " VALUES (?, ?, ?)";
        
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
    
        
    static DefaultTableModel modelo;
    public static void getTabla(){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM pais";
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
        }
    }
    
    public static void Limpiar_Tabla(){
        for (int i = 0; i < Ventana_paises.tablapaises.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }     
    
}
