package Modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import gui.Ventana_Multas;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logico.Conexion;
import logico.Detalle_Multa;
import logico.Multa;

public class ModeloMultaAutomatic {

    public Multa dia() {

        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        Multa multa = new Multa();
        String sql = "SELECT date_sub(fecha_fin_ped, INTERVAL DAY(now()) DAY) AS 'FECHA_RETRASO', id_cliente_ped, id_enc_ped FROM encabezado_pedido WHERE date_sub(fecha_fin_ped, INTERVAL DAY(now()) DAY) < fecha_inicio_ped AND estado_enc = False";
        
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                multa.setFecha_aplicacion(rs.getDate(1));
                multa.setCed_usuario(rs.getInt(2));
                multa.setId_multa(rs.getInt(3));
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
        return multa;
    }
    
    public void noDup(Multa multa){
        PreparedStatement psup;
        Connection con = Conexion.getConnection();
        String sql1 = "UPDATE encabezado_pedido SET estado_enc = True WHERE id_enc_ped = ?";
        try {
            psup = con.prepareStatement(sql1);
            psup.setInt(1, multa.getId_multa());
            System.out.println(psup);
            psup.execute();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }

    public Multa diaIn() {

        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        Multa multa = new Multa();
        String sql = "SELECT fecha_inicio_ped, id_cliente_ped FROM encabezado_pedido WHERE date_sub(fecha_fin_ped, INTERVAL DAY(now()) DAY) < fecha_inicio_ped";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                multa.setFecha_aplicacion(rs.getDate(1));
                multa.setCed_usuario(rs.getInt(2));
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
        return multa;
    }

    public boolean registrarEnc(Multa multa) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        String sql = "INSERT INTO encabezado_multa (id_est_mul, fecha_mul, total_mul) VALUES (?, DATE_FORMAT(NOW(), '%Y-%m-%d'), 5)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, multa.getCed_usuario());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }

    public int getIdEncMulta() {
        int idEnc = 0;
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        String sql = "SELECT MAX(id_enc_mul) FROM encabezado_multa";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idEnc = rs.getInt(1);
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
        return idEnc;
    }

    public ArrayList<Integer> getIdLib(int idped) {
        ArrayList<Integer> idLib = new ArrayList<>();
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        String sql = "SELECT id_lib_det FROM detalle_pedido WHERE id_enc_ped = ? AND estado_det_ped = False";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idped);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                idLib.add(rs.getInt(1));
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
        return idLib;
    }
    
    public int getIdEjem(int idped) {
        int idLib = 0;
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        String sql1 = "SELECT id_ejem FROM ejemplar WHERE id_lib_ejem = ?";
        try {
            ps = con.prepareStatement(sql1);
            ps.setInt(1, idped);
            rs = ps.executeQuery();

            while (rs.next()) {
                idLib = rs.getInt(1);
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
        return idLib;
    }

    public boolean addDet(Detalle_Multa det) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        String sql = "INSERT INTO detalle_multa (id_enc_mul, id_lib_mul, estado_det_mul) VALUES (?, ?, False)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, det.getEnc_mult_id());
            ps.setInt(2, det.getId_lib_mul());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
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
        String sql = "SELECT em.id_enc_mul, CONCAT(p.primer_nombre_per, ' ', p.primer_apellido_per), em.fecha_mul, em.total_mul  FROM encabezado_multa em, persona p, estudiante e WHERE em.id_est_mul = e.id_est AND e.id_per_est = p.id_per";
        modelo = new DefaultTableModel();
        Ventana_Multas.tablamulta.setModel(modelo);
        try{
            st = con.prepareStatement(sql);
            rs = st.executeQuery();
            ResultSetMetaData rsMd = (ResultSetMetaData) rs.getMetaData();
            int columns = rsMd.getColumnCount();
            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("FECHA APLICACION");
            modelo.addColumn("TOTAL");
            
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
        for (int i = 0; i < Ventana_Multas.tablamulta.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i-1;
        }
    }
}
