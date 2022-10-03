package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import logico.Bibliotecario;
import logico.Conexion;
import logico.Estudiante;
import logico.Persona;


public class ModeloPersona {
    
    public int ExistePersona(String ced){

        Connection con = Conexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "SELECT COUNT(id_per) FROM persona WHERE cedula_per = ?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, ced);
            rs = ps.executeQuery();
            
            while (rs.next()) {      
                
                return rs.getInt(1);                
            }
            
            return 1;
        } catch (SQLException sqle) {
            System.err.println(sqle);
            return 1;
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }        
    }
    

    public boolean Login(Bibliotecario bib){

        Connection con = Conexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "SELECT p.cedula_per, b.password_bib, p.id_rol_per FROM persona p, bibliotecario b "
                + "WHERE (p.cedula_per=?) AND (p.id_per = b.id_per_bib) AND (p.id_rol_per=?)";
       
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, bib.getCedula());
            ps.setInt(2, bib.getTipo_usuario());
            rs = ps.executeQuery();
            boolean resultado = rs.next();
            if (resultado) {     
                if(bib.getPassword().equals(rs.getString(2))){
                    bib.setCedula(rs.getString(1));
                    bib.setPassword(rs.getString(2));
                    return true;
                }
                return false;                
            }
            return false;
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
    
    public boolean Login(Estudiante est){

        Connection con = Conexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "SELECT p.cedula_per, e.password_est, p.id_rol_per FROM persona p, estudiante e "
                + "WHERE (p.cedula_per=?) AND (p.id_per = e.id_per_est) AND (p.id_rol_per=?)";
       
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, est.getCedula());
            ps.setInt(2, est.getTipo_usuario());
            rs = ps.executeQuery();
            boolean resultado = rs.next();

            if (resultado) {     
                if(est.getPassword().equals(rs.getString(2))){
                    est.setCedula(rs.getString(1));
                    est.setPassword(rs.getString(2));
                    return true;
                }
                return false;                
            }
            return false;
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
    
    public static int getIdTipo(Persona persona){
        int id = 0;
        PreparedStatement ps;
        Connection con  = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT id_rol FROM rol WHERE nombre_rol = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, persona.getCedula());
            rs = ps.executeQuery();
            
            while(rs.next()){
                id = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
        return id;
    }
}
