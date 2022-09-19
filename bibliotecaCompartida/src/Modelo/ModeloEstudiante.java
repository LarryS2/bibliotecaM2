package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import logico.Conexion;
import java.sql.Statement;
import java.sql.SQLException;
import logico.Estudiante;


public class ModeloEstudiante {
    
    public boolean RegistrarEstudiante(Estudiante est){
        int id = 0;
        PreparedStatement ps;
        PreparedStatement psest;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO persona (id_per, cedula_per, primer_nombre_per, segundo_nombre_per, primer_apellido_per,"
                + " segundo_apellido_per, rol_per, email_per, tipo_sangre_per, fecha_nac_per, genero_per, direccion_per,"
                + "telefono_per, estado_per) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        String sqles = "INSERT INTO estudiante (id_per_est, password_est)"
                + " VALUES((SELECT MAX(id_per) FROM persona), ?)"; 
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, est.getId());
            ps.setString(2, est.getCedula());
            ps.setString(3, est.getPrimer_nombre());
            ps.setString(4, est.getSegundo_nombre());
            ps.setString(5, est.getPrimer_apellido());
            ps.setString(6, est.getSegundo_apellido());
            ps.setString(7, est.getTipo_usuario());
            ps.setString(8, est.getEmail());
            ps.setString(9, est.getTipo_sangre());
            ps.setDate(10, (Date) est.getFecha_nac());
            ps.setString(11, String.valueOf(est.getGenero()));
            ps.setString(12, est.getDireccion());
            ps.setString(13, est.getTelefono());
            ps.setBoolean(14, est.isEstado());
            
            //ps1.
            ps.execute();
//            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            String ide = String.valueOf(ps);
            //System.out.println(ide);
            //id = Integer.parseInt(ide);
            psest = con.prepareStatement(sqles);
            
            psest.setInt(1, est.getPer());
            psest.setString(2, est.getPassword());
            psest.execute();
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
    
    
    public boolean RegistrarEst(Estudiante est){
        
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO estudiante (id_per_est, password_est)"
                + " VALUES((SELECT id_per FROM persona WHERE id_per), ?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, est.getPersona());
            ps.setString(2, est.getPassword());
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
    
}
