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
    
    public boolean RegistrarBibliotecario(Bibliotecario bib) {
        PreparedStatement ps;
        PreparedStatement psbib;
        Connection con = Conexion.getConnection();

        String sql = "INSERT INTO persona (cedula_per, primer_nombre_per, segundo_nombre_per, primer_apellido_per,"
                + " segundo_apellido_per, email_per, fecha_nac_per, genero_per, telefono_per, tipo_sangre, id_rol_per, "
                + "id_barrio_per, estado_per) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, (SELECT id_bar "
                + "FROM barrio ORDER BY id_bar DESC LIMIT 1), ?)";

        String sqlbib = "INSERT INTO bibliotecario (password_bib, id_hor, id_per_bib, estado_bib)"
                + " VALUES (?, ?, (SELECT id_per FROM persona ORDER BY id_per DESC LIMIT 1), ?)";
        try {

            ps = con.prepareStatement(sql);
            psbib = con.prepareStatement(sqlbib);
            ps.setString(1, bib.getCedula());
            ps.setString(2, bib.getPrimer_nombre());
            ps.setString(3, bib.getSegundo_nombre());
            ps.setString(4, bib.getPrimer_apellido());
            ps.setString(5, bib.getSegundo_apellido());
            ps.setString(6, bib.getEmail());
            ps.setDate(7, (Date) bib.getFecha_nac());
            ps.setString(8, String.valueOf(bib.getGenero()));
            ps.setString(9, bib.getTelefono());
            ps.setString(10, bib.getTipo_sangre());
            ps.setInt(11, bib.getTipo_usuario());
            ps.setBoolean(12, bib.isEstado());

            psbib.setString(1, bib.getPassword());
            psbib.setInt(2, bib.getId_horario());
            psbib.setBoolean(3, bib.isEstado());

            int n = ps.executeUpdate();
            if (n != 0) {
                int n2 = psbib.executeUpdate();
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

    public static void getTabla() {
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM persona WHERE (id_rol_per = 1) OR (id_rol_per = 2) AND (estado_per = False)";
        modelo = new DefaultTableModel();
        Registrar_Administrador.tablaPersona.setModel(modelo);
        try {
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
            modelo.addColumn("E-MAIL");
            modelo.addColumn("FECHA NAC");
            modelo.addColumn("GÉNERO");
            modelo.addColumn("Nº TELÉFONO");
            modelo.addColumn("TIPO SANGRE");
            modelo.addColumn("ROL");
            modelo.addColumn("DIRECCIÓN");
            

            while (rs.next()) {
                Object[] filas = new Object[columns];

                for (int i = 0; i < columns; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public static void Limpiar_Tabla() {
        for (int i = 0; i < Registrar_Administrador.tablaPersona.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
}
