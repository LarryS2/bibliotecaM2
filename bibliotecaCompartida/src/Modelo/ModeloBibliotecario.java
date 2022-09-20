package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Registrar_Administrador;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import logico.Conexion;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import logico.Bibliotecario;


public class ModeloBibliotecario {
    public boolean RegistrarBibliotecario(Bibliotecario bib){
            PreparedStatement ps;
        PreparedStatement psest;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO persona (cedula_per, primer_nombre_per, segundo_nombre_per, primer_apellido_per,"
                + " segundo_apellido_per, rol_per, email_per, tipo_sangre_per, fecha_nac_per, genero_per, direccion_per,"
                + "telefono_per, estado_per) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        String sqlbib = "INSERT INTO bibliotecario (id_per_bib, password_bib)"
                + " VALUES ((SELECT id_per FROM persona ORDER BY id_per DESC LIMIT 1), ?)"; 
//        String sql = "SELECT p.id_per, p.cedula_per, p.primer_nombre_per, p.segundo_nombre_per, "
//                + "p.primer_apellido_per, p.segundo_apellido_per, p.rol_per, p.email_per, p.tipo_sangre_per, "
//                + "p.fecha_nac_per, p.genero_per, p.direccion_per, p.telefono_per, p.estado_per ";
        try {
            
            ps = con.prepareStatement(sql);
            psest = con.prepareStatement(sqlbib);
            ps.setString(1, bib.getCedula());
            ps.setString(2, bib.getPrimer_nombre());
            ps.setString(3, bib.getSegundo_nombre());
            ps.setString(4, bib.getPrimer_apellido());
            ps.setString(5, bib.getSegundo_apellido());
            ps.setString(6, bib.getTipo_usuario());
            ps.setString(7, bib.getEmail());
            ps.setString(8, bib.getTipo_sangre());
            ps.setDate(9, (Date) bib.getFecha_nac());
            ps.setString(10, String.valueOf(bib.getGenero()));
            ps.setString(11, bib.getDireccion());
            ps.setString(12, bib.getTelefono());
            ps.setBoolean(13, bib.isEstado());
            
            psest.setString(1, bib.getPassword());
            
            int n = ps.executeUpdate();
            if(n != 0){
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

    
    static DefaultTableModel modelo;
    public static void getTabla(){
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM persona";
        modelo = new DefaultTableModel();
        Registrar_Administrador.tablaPersona.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CÉDULA");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");
            modelo.addColumn("ROL");
            modelo.addColumn("E-MAIL");
            modelo.addColumn("TIPO SA.");
            modelo.addColumn("FECHA NAC");
            modelo.addColumn("GÉNERO");
            modelo.addColumn("DIRECCIÓN");
            modelo.addColumn("Nº TELÉFONO");
            
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
        for (int i = 0; i < Registrar_Administrador.tablaPersona.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
}
