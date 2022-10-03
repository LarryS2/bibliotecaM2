package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import logico.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logico.Estudiante;
import java.sql.Statement;
import java.sql.ResultSet;

public class ModeloEstudiante {

    public boolean RegistrarEstudiante(Estudiante est) {
        PreparedStatement ps;
        PreparedStatement psest;
        Connection con = Conexion.getConnection();

        String sql = "INSERT INTO persona (cedula_per, primer_nombre_per, segundo_nombre_per, primer_apellido_per,"
                + " segundo_apellido_per, email_per, fecha_nac_per, genero_per, telefono_per, tipo_sangre, id_rol_per, "
                + "id_barrio_per, estado_per) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT id_bar "
                + "FROM barrio ORDER BY id_bar DESC LIMIT 1),"
                + " ?)";

        String sqlest = "INSERT INTO estudiante (id_per_est, password_est, estado_est)"
                + " VALUES ((SELECT id_per FROM persona ORDER BY id_per DESC LIMIT 1), ?, ?)";
        try {

            ps = con.prepareStatement(sql);
            psest = con.prepareStatement(sqlest);
            ps.setString(1, est.getCedula());
            ps.setString(2, est.getPrimer_nombre());
            ps.setString(3, est.getSegundo_nombre());
            ps.setString(4, est.getPrimer_apellido());
            ps.setString(5, est.getSegundo_apellido());
            ps.setString(6, est.getEmail());
            ps.setDate(7, (Date) est.getFecha_nac());
            ps.setString(8, String.valueOf(est.getGenero()));
            ps.setString(9, est.getTelefono());
            ps.setString(10, est.getTipo_sangre());
            ps.setInt(11, est.getTipo_usuario());
            //ps.setInt(12, Integer.parseInt(est.getDireccion()));
            ps.setBoolean(12, est.isEstado());
            psest.setString(1, est.getPassword());
            psest.setBoolean(2, est.isEstado());
            int n = ps.executeUpdate();
            if (n != 0) {
                int n2 = psest.executeUpdate();
                return n2 != 0;
            } else {
                return false;
            }
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

    public boolean RegistrarEst(Estudiante est) {

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

    
    /*EXPERIMENTAL*/
    public Estudiante VerPerfil(String ced) {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        Estudiante est = new Estudiante();
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT p.cedula_per, p.primer_nombre_per, p.segundo_nombre_per, p.primer_apellido_per, p.segundo_apellido_per, \n" +
            "p.email_per, p.telefono_per, p.fecha_nac_per, p.genero_per, p.tipo_sangre, c.nombre_ciu, b.nombre_bar, " +
            "b.calle_prin_bar, b.calle_sec_bar FROM persona p , ciudad c, barrio b WHERE (cedula_per=?) AND (p.id_barrio_per=b.id_bar)");
        while(rs.next()){
            est.setCedula(rs.getString("p.cedula_per"));
            est.setPrimer_nombre(rs.getString("p.primer_nombre_per"));
            est.setSegundo_nombre(rs.getString("p.segundo_nombre_per"));
            est.setPrimer_apellido(rs.getString("p.primer_apellido_per"));
            est.setSegundo_apellido(rs.getString("p.segundo_apellido_per"));
            est.setEmail(rs.getString("p.email_per"));
            est.setTelefono(rs.getString("p.telefono_per"));
            est.setFecha_nac(rs.getDate("fecha_nac_per"));
            est.setGenero(rs.getString("p.genero_per"));
            est.setTipo_sangre(rs.getString("p.tipo_sangre"));
            
            
        }

        } catch (SQLException ex) {
            Logger.getLogger(ModeloEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
        return est;
    }
//
//    public ArrayList<Horario> getHorario() {
//        Connection con = Conexion.getConnection();
//        Statement st;
//        ResultSet rs;
//        ArrayList<Horario> listaHorarios = new ArrayList<>();
//        
//        try{
//            st = con.createStatement();
//            rs = st.executeQuery("SELECT id_hor, hora_inicio_hor, hora_fin_hor FROM horario WHERE estado_hor = False");
//            
//            while(rs.next()){
//                Horario hor = new Horario();
//                hor.setId(rs.getInt("id_hor"));
//                hor.setHora_inicio( rs.getTime("hora_inicio_hor").toLocalTime());
//                hor.setHora_fin(rs.getTime("hora_fin_hor").toLocalTime());
//                listaHorarios.add(hor);
//            }
//        }catch(SQLException e){
//            System.err.println(e); 
//        }
//        return listaHorarios;
//    }
    
}
