package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import logico.Conexion;
import java.sql.SQLException;
import logico.Bibliotecario;


public class ModeloBibliotecario {
    
//    public boolean RegistrarBibliotecario(Bibliotecario bib){
//        
//        PreparedStatement ps;
//        Connection con = Conexion.getConnection();
//        
//        String sql = "INSERT INTO autor (CODIGO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, PRIMER_APELLIDO, SEGUNDO_APELLIDO, FECHA_NAC, LENGUA_MATERNA, PAIS_ORIGEN) VALUES(?,?,?,?,?,?,?,?)";
//        
//        try {
//            
//            ps = con.prepareStatement(sql);
//            ps.setString(1, bib.getCedula());
//            ps.setString(2, Bibliotecario.getNombre_autor());
//            ps.setString(3, Bibliotecario.getSegundo_nombre_autor());
//            ps.setString(4, Bibliotecario.getApellido_autor());
//            ps.setString(5, Bibliotecario.getSegundo_apellido_autor());
//            ps.setDate(6, (Date) Bibliotecario.getFecha_nac());
//            ps.setString(7, Bibliotecario.getLengua_materna());
//            ps.setString(8, Bibliotecario.getPais_origen());
//            ps.execute();
//            return true;
//        } catch (SQLException sqle) {
//            System.err.println(sqle);
//            return false;
//        } finally {
//            try {
//                con.close();
//            } catch (SQLException sqle) {
//                System.err.println(sqle);
//            }
//        }
//    }
}
