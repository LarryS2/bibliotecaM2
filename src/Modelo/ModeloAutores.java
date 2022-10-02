package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Autor;
import logico.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logico.Autor;

public class ModeloAutores {

    /*
    *
    *Método para mandar un objeto de tipo Autor al combobox de la vista Libros//
    *
     */
    public ArrayList<Autor> getAutor() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Autor> listaAutor = new ArrayList<>();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT a.id_aut, p.primer_nombre_per, p.primer_apellido_per FROM persona p, autor a WHERE p.id_per = a.id_per_aut AND p.estado_per = False");

            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId_autor(rs.getInt("a.id_aut"));
                autor.setPrimer_nombre(rs.getString("p.primer_nombre_per"));
                autor.setPrimer_apellido(rs.getString("p.primer_apellido_per"));
                listaAutor.add(autor);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
        return listaAutor;
    }

    public ArrayList<Autor> getAutorEliminado() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Autor> listaAutor = new ArrayList<>();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT p.id_per, p.primer_nombre_per, p.primer_apellido_per FROM persona p, autor a WHERE p.id_per = a.id_per_aut AND p.estado_per = True");

            while (rs.next()) {
                Autor autor = new Autor();
                autor.setId_autor(rs.getInt("p.id_per"));
                autor.setPrimer_nombre(rs.getString("p.primer_nombre_per"));
                autor.setPrimer_apellido(rs.getString("p.primer_apellido_per"));
                listaAutor.add(autor);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
        return listaAutor;
    }

    /*
    *
    *Método para hacer el insert en la base de datos.
    *
     */
    
    public boolean RegistrarAutorPer(Autor autor) {

        PreparedStatement ps;
        PreparedStatement psaut;
        Connection con = Conexion.getConnection();

        String sql = "INSERT INTO persona(cedula_per, primer_nombre_per, segundo_nombre_per, primer_apellido_per, segundo_apellido_per, fecha_nac_per, estado_per, email_per, id_rol_per) VALUES(?,?,?,?,?,?, False, '------',3)";

        String sqll = "INSERT INTO autor(id_per_aut, id_lengua_materna_aut, id_pais_origen_aut, estado_aut) VALUES ((SELECT id_per FROM persona ORDER BY id_per DESC LIMIT 1),?,?,False)";

        try {
            ps = con.prepareStatement(sql);
            psaut = con.prepareStatement(sqll);
            ps.setString(1, autor.getCedula());
            ps.setString(2, autor.getPrimer_nombre());
            ps.setString(3, autor.getSegundo_nombre());
            ps.setString(4, autor.getPrimer_apellido());
            ps.setString(5, autor.getSegundo_apellido());
            ps.setDate(6, (Date) autor.getFecha_nac());
            
            psaut.setInt(1, autor.getLengua_materna());
            psaut.setInt(2, autor.getPais_origen());
            
            
            return !ps.execute() && !psaut.execute();
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

    /*
    *
    *Método para modificar autor//
    *
     */
    
    public boolean ModificarAutor(Autor autor) {

        PreparedStatement ps;
        PreparedStatement psaut;
        Connection con = Conexion.getConnection();

        String sql = "UPDATE persona SET cedula_per=?, primer_nombre_per=?, segundo_nombre_per=?, primer_apellido_per=?, segundo_apellido_per=?, fecha_nac_per=? WHERE id_per=?";
        String sqll = "UPDATE autor SET id_lengua_materna_aut = ?, id_pais_origen_aut = ? WHERE id_per_aut = ?";
        try {
            ps = con.prepareStatement(sql);
            psaut = con.prepareStatement(sqll);
            
            ps.setString(1, autor.getCedula());
            ps.setString(2, autor.getPrimer_nombre());
            ps.setString(3, autor.getSegundo_nombre());
            ps.setString(4, autor.getPrimer_apellido());
            ps.setString(5, autor.getSegundo_apellido());
            ps.setDate(6, (Date) autor.getFecha_nac());
            ps.setInt(7, autor.getId_autor());
            
            psaut.setInt(1, autor.getLengua_materna());
            psaut.setInt(2, autor.getPais_origen());
            psaut.setInt(3, autor.getId_autor());
                
            System.out.println(ps);
            return ps.executeUpdate() != 0 && psaut.executeUpdate() != 0;
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

    /*
    *
    *Metodo para modificar a los autores eliminados
     */
    public boolean ModificarAutorEliminado(Autor autor) {
        
        PreparedStatement ps;
        PreparedStatement psaut;
        Connection con = Conexion.getConnection();

        String sql = "UPDATE persona SET cedula_per=?, primer_nombre_per=?, segundo_nombre_per=?, primer_apellido_per=?, segundo_apellido_per=?, fecha_nac_per=?, estado_per=? WHERE id_per=?";
        String sqll = "UPDATE autor SET id_lengua_materna_aut = ?, id_pais_origen_aut = ? WHERE id_per_aut = ?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, autor.getCedula());
            ps.setString(2, autor.getPrimer_nombre());
            ps.setString(3, autor.getSegundo_nombre());
            ps.setString(4, autor.getPrimer_apellido());
            ps.setString(5, autor.getSegundo_apellido());
            ps.setDate(6, (Date) autor.getFecha_nac());
            ps.setBoolean(7, autor.isEstado());
            ps.setInt(8, autor.getId_autor());
            
            psaut = con.prepareStatement(sqll);
            psaut.setInt(1, autor.getLengua_materna());
            psaut.setInt(2, autor.getPais_origen());
            psaut.setInt(3, autor.getId_autor());
           
            return ps.execute() && psaut.execute();
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

    /*
    *
    *Método para llenar la tabla de la vista autor//
    *
     */
    static DefaultTableModel modelo = new DefaultTableModel();

    public static void getTabla() {
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT p.id_per, p.cedula_per, p.primer_nombre_per, p.segundo_nombre_per, p.primer_apellido_per, p.segundo_apellido_per, p.fecha_nac_per, i.nombre_idi, pa.nombre_pais FROM autor a, persona p, pais pa, idioma i WHERE p.estado_per = False AND p.id_per = a.id_per_aut AND a.id_lengua_materna_aut = i.id_idi AND pa.id_pais = a.id_pais_origen_aut";

        modelo = new DefaultTableModel();
        Ventana_Autor.tablaautores.setModel(modelo);

        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CÓDIGO");
            modelo.addColumn("PRIMER NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("PRIMER APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");
            modelo.addColumn("FECHA NACIMIENTO");
            modelo.addColumn("LENGUA MATERNA");
            modelo.addColumn("PAÍS DE ORIGEN");

            while (rs.next()) {
                Object[] filas = new Object[columns];

                for (int i = 0; i < columns; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }

    public boolean ConsultarAutor(Autor aut) {

        PreparedStatement ps;
        Connection con = Conexion.getConnection();

        String sql = "SELECT * FROM autor WHERE CODIGO = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, aut.getCedula());
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

    public static void getTablaConsultaCod(Autor aut) {
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT * FROM autor WHERE CODIGO = ?";
        modelo = new DefaultTableModel();
        Ventana_Autor.tablaautores.setModel(modelo);
        try {
            st = con.prepareStatement(sql);
            st.setString(1, aut.getCedula());
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CÓDIGO");
            modelo.addColumn("PRIMER NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("PRIMER APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");
            modelo.addColumn("FECHA NACIMIENTO");
            modelo.addColumn("LENGUA MATERNA");
            modelo.addColumn("PAÍS DE ORIGEN");

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

    public static void getTablaEliminados() {
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT p.id_per, p.cedula_per, p.primer_nombre_per, p.segundo_nombre_per, p.primer_apellido_per, p.segundo_apellido_per, p.fecha_nac_per, i.nombre_idi, pa.nombre_pais FROM autor a, persona p, pais pa, idioma i WHERE p.estado_per = True AND p.id_per = a.id_per_aut AND a.id_lengua_materna_aut = i.id_idi AND pa.id_pais = a.id_pais_origen_aut";
        modelo = new DefaultTableModel();
        Ventana_Autor.tablaautores.setModel(modelo);

        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CÓDIGO");
            modelo.addColumn("PRIMER NOMBRE");
            modelo.addColumn("SEGUNDO NOMBRE");
            modelo.addColumn("PRIMER APELLIDO");
            modelo.addColumn("SEGUNDO APELLIDO");
            modelo.addColumn("FECHA NACIMIENTO");
            modelo.addColumn("LENGUA MATERNA");
            modelo.addColumn("PAÍS DE ORIGEN");

            while (rs.next()) {
                Object[] filas = new Object[columns];

                for (int i = 0; i < columns; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                modelo.addRow(filas);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }

    public static void Limpiar_Tabla() {
        for (int i = 0; i < Ventana_Autor.tablaautores.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    /*
    *
    *Método para eliminar autor//
    *
     */
    public boolean EliminarAutor(Autor autor) {

        PreparedStatement ps;
        Connection con = Conexion.getConnection();

        String sql = "UPDATE persona SET estado_per = True WHERE id_per = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, autor.getId());
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

    /*
    *
    *Método para buscar autor//
    *
     */
    public boolean BuscarAutor(Autor autor) {

        PreparedStatement ps;
        ResultSet rs = null;
        Connection con = Conexion.getConnection();

        String sql = "SELECT FROM autor WHERE =?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, autor.getCedula());
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
