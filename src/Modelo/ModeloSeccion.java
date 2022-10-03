package Modelo;

import static Modelo.ModeloDewey.modelo;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Dewey;
import gui.Ventana_Seccion;
import logico.Seccion;
import java.sql.PreparedStatement;
import logico.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logico.Dewey;

public class ModeloSeccion {

    public ArrayList<Seccion> getSeccion() {

        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;

        ArrayList<Seccion> listaSeccion = new ArrayList<>();
        try {

            st = con.createStatement();
            rs = st.executeQuery("SELECT id_sec, nombre_sec FROM seccion WHERE estado_sec = False");
            while (rs.next()) {
                Seccion seccion = new Seccion();
                seccion.setId(rs.getInt("id_sec"));
                seccion.setNombre_zona(rs.getString("nombre_sec"));
                listaSeccion.add(seccion);
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
        return listaSeccion;
    }

    public ArrayList<Seccion> getSeccionEliminado() {
        Connection con = Conexion.getConnection();
        Statement st;
        ResultSet rs;
        ArrayList<Seccion> listaSeccion = new ArrayList<>();

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT id_sec, codigo_sec, nombre_sec, desc_sec FROM seccion WHERE estado_sec = True");

            while (rs.next()) {
                Seccion seccion = new Seccion();
                seccion.setId(rs.getInt("id_sec"));
                seccion.setCodigo_zona(rs.getString("codigo_sec"));
                seccion.setNombre_zona(rs.getString("nombre_sec"));
                seccion.setDescripcion(rs.getString("desc_sec"));
                listaSeccion.add(seccion);

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
        return listaSeccion;
    }

//
    public boolean RegistrarSeccion(Seccion sec) {

        PreparedStatement ps;
        Connection con = Conexion.getConnection();

        String sql = "INSERT INTO seccion (codigo_sec, nombre_sec, desc_sec, id_cat_sec, estado_sec) VALUES (?,?,?,?,False)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sec.getCodigo_zona());
            ps.setString(2, sec.getNombre_zona());
            ps.setString(3, sec.getDescripcion());
            ps.setInt(4, sec.getId_cate_zona());

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

    public boolean ModificarSeccion(Seccion sec) {

        PreparedStatement ps;
        Connection con = Conexion.getConnection();

        String sql = "UPDATE seccion SET codigo_sec=?, nombre_sec=?, desc_sec=? WHERE id_sec=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sec.getCodigo_zona());
            ps.setString(2, sec.getNombre_zona());
            ps.setString(3, sec.getDescripcion());
            ps.setInt(4, sec.getId());
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

    public boolean ModificarSeccionEliminado(Seccion sec) {

        PreparedStatement ps;
        Connection con = Conexion.getConnection();

        String sql = "UPDATE seccion SET codigo_sec=?, nombre_sec=?, desc_sec=? , estado_sec=? WHERE id_sec=?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, sec.getCodigo_zona());
            ps.setString(2, sec.getNombre_zona());
            ps.setString(3, sec.getDescripcion());
            ps.setBoolean(4, sec.isEstado());
            ps.setInt(5, sec.getId());
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

    public boolean EliminarSeccion(Seccion seccion) {

        PreparedStatement ps;
        Connection con = Conexion.getConnection();

        String sql = "UPDATE seccion SET estado_sec = True WHERE id_sec = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, seccion.getId());
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

    public boolean ConsultarSeccion(Seccion sec) {

        PreparedStatement ps;
        Connection con = Conexion.getConnection();

        String sql = "SELECT id_sec, codigo_sec, nombre_sec, desc_sec, id_cat_sec  FROM seccion WHERE codigo_sec like ? OR nombre_sec like ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, sec.getCodigo_zona());
            ps.setString(2, sec.getCodigo_zona());
            return ps.execute();

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

    public static void getTabla() {
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT id_sec, codigo_sec, nombre_sec, desc_sec, id_cat_sec FROM seccion WHERE estado_sec = False";
        modelo = new DefaultTableModel();
        Ventana_Seccion.tablaseccion.setModel(modelo);

        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DESCRIPCION");
            modelo.addColumn("CATEGORÍA");

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

    public static void getTablaElimado() {
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT id_sec,codigo_sec,nombre_sec,desc_sec FROM seccion WHERE estado_sec = True";
        modelo = new DefaultTableModel();
        Ventana_Seccion.tablaseccion.setModel(modelo);

        try {
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DESCRIPCION");

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

    public static void getTablaConsultaCod(Seccion sec) {
        Connection con = Conexion.getConnection();
        PreparedStatement st;
        ResultSet rs;
        String sql = "SELECT id_sec, codigo_sec, nombre_sec, desc_sec, id_cat_sec  FROM seccion WHERE codigo_sec like ? OR nombre_sec like ?";
        modelo = new DefaultTableModel();
        Ventana_Seccion.tablaseccion.setModel(modelo);
        try {
            st = con.prepareStatement(sql);
            st.setString(1, sec.getCodigo_zona());
            st.setString(2, sec.getCodigo_zona());
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("CODIGO");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("DESCRIPCION");

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
        for (int i = 0; i < Ventana_Seccion.tablaseccion.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

}
