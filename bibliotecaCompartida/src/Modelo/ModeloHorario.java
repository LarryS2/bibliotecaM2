package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Horarios;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import logico.Conexion;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import logico.Horario;
import java.sql.ResultSet;

public class ModeloHorario {
    
    public boolean RegistrarHorario(Horario hor){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO horario (codigo_hor, hora_inico_hor, hora_fin_horario, descripcion_hor, estado_hor)"
            + " VALUES(?,?,?,?,?)";
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, hor.getCodigo());
            ps.setDate(2, (Date) hor.getHora_inicio());
            ps.setDate(3, (Date) hor.getHora_fin());
            ps.setString(4, hor.getDescripcion());

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
    
    
    
    
    static DefaultTableModel modelo = new DefaultTableModel();
    public static void getTabla(){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM horario";
        modelo = new DefaultTableModel();
        Ventana_Horarios.tablahorario.setModel(modelo);
        
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CÓDIGO");
            modelo.addColumn("HORA DE INICIO");
            modelo.addColumn("HORA DE FIN");
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
        for (int i = 0; i < Ventana_Horarios.tablahorario.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
}
