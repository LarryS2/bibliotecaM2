package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Horarios;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Time;
import logico.Conexion;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import logico.Horario;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import logico.Dia;

public class ModeloHorario {
    
    
    public ArrayList<Horario> getHorario() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Horario> listaHorarios = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_hor, hora_inicio_hor, hora_fin_hor FROM horario WHERE estado_hor = False");
            
            while(rs.next()){
                Horario hor = new Horario();
                hor.setId(rs.getInt("id_hor"));
                hor.setHora_inicio( rs.getTime("hora_inicio_hor").toLocalTime());
                hor.setHora_fin(rs.getTime("hora_fin_hor").toLocalTime());
                listaHorarios.add(hor);
            }
        }catch(SQLException e){
            System.err.println(e); 
        }
        return listaHorarios;
    }

    
    public ArrayList<Dia> getDias() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Dia> listaDias = new ArrayList<>();
        
        try{
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM dia ORDER BY id_dia");
            
            while(rs.next()){
                Dia dia = new Dia();
                dia.setId_dia(rs.getInt("id_dia"));
                dia.setNom_dia(rs.getString("nombre_dia"));
//                hor.setHora_inicio(rs.getTime("hora_inico_hor"));
//                hor.setHora_fin(rs.getTime("hora_fin_horario"));
                listaDias.add(dia);
            }
        }catch(SQLException e){
            
        }
        return listaDias;
    }
    
    
    public boolean RegistrarHorario(Horario hor){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO horario (codigo_hor, hora_inicio_hor, hora_fin_hor, dia_hor, estado_hor)"
            + " VALUES(?,?,?,?,?)";
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, hor.getCodigo());
            ps.setTime(2, Time.valueOf(hor.getHora_inicio()));
            ps.setTime(3, Time.valueOf(hor.getHora_fin()));
            ps.setInt(4, hor.getId_dia());
            ps.setBoolean(5, hor.isEstado());
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
    
    
    public boolean ActualizarHorario(Horario hor){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE horario SET codigo_hor = ?, hora_inico_hor = ?, hora_fin_horario = ?, descripcion_hor=? WHERE Id_hor = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, hor.getCodigo());
            ps.setTime(2, Time.valueOf(hor.getHora_inicio()));
            ps.setTime(3, Time.valueOf(hor.getHora_fin()));
            ps.setInt(4, hor.getId_dia());
            ps.setInt(5, hor.getId());
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

    public boolean ConsultarHorario(Horario hor){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "SELECT * FROM horario WHERE codigo_hor=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, hor.getCodigo());
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
    
    public static void getTablaConsultaCodigo(Horario hor){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM horario WHERE codigo_hor=?";
        modelo = new DefaultTableModel();
        Ventana_Horarios.tablahorario.setModel(modelo);
        
        try{
            
            st = con.prepareStatement(sql);
            st.setString(1, hor.getCodigo());
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
