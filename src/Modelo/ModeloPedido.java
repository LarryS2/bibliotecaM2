package Modelo;

import logico.Conexion;
import logico.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import logico.Detalle_Pedido;
import logico.Libro;

public class ModeloPedido {
    public static int getIdPerson(String cedula){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT id_per FROM persona WHERE cedula_per = ?";
        
        int idp = 0;
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cedula);
            rs = ps.executeQuery();
            while(rs.next()){
                idp = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
        return idp;
    }
    
    public boolean RegistrarPedidoEnc(Pedido pedido) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();

        String sql = "INSERT INTO pedido (id_est_ped, fecha_inicio_ped, fecha_fin_ped, estado_ped) VALUES (?, ?, ?, false)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getId_est());
            ps.setDate(2,(Date) pedido.getFecha_inicio_pedido());
            ps.setDate(3,(Date) pedido.getFecha_fin_pedido());
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
    
    public boolean Actualizar(Pedido pedido){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE pedido SET id_est_ped = ?, fecha_inicio_ped = ?, fecha_fin_ped = ? WHERE id_ped = ?";
        
        try{
            ps = con.prepareCall(sql);
            ps.setInt(1, pedido.getId_est());
            ps.setDate(2, (Date) pedido.getFecha_inicio_pedido());
            ps.setDate(3, (Date) pedido.getFecha_fin_pedido());
            ps.setInt(4, pedido.getId_pedido());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    public boolean ActualizarEliminado(Pedido pedido){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE pedido SET id_est_ped = ?, fecha_inicio_ped = ?, fecha_fin_ped = ?, estado_ped = ? WHERE id_ped = ?";
        
        try{
            ps = con.prepareCall(sql);
            ps.setInt(1, pedido.getId_est());
            ps.setDate(2, (Date) pedido.getFecha_inicio_pedido());
            ps.setDate(3, (Date) pedido.getFecha_fin_pedido());
            ps.setBoolean(4, pedido.isEstado());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    public boolean Eliminar(Pedido pedido){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE pedido SET estado_ped = True WHERE id_ped = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, pedido.getId_pedido());
            return true;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
    
    //Metodos para Detalle del pedido
    public static String idPedido(){
        String idp = "";
        String sql = "SELECT MAX(id_ped) FROM pedido";
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        try{
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               idp = rs.getString(1);
           }
        }catch(SQLException e){
            System.out.println(e);
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
        return idp;
    }
    
    public static int idLibro(Libro libro){
        int idl = 0;
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT ID FROM libro WHERE CODIGO_LIB = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, libro.getCodigo());
            rs = ps.executeQuery();
            while(rs.next()){
                idl = rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
        return idl;
    }
    
    public boolean registrarDetalle(Detalle_Pedido dp){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "INSERT INTO detalle_pedido (id_ped, descripcion_ped, estado_ped) VALUES (?,?,False)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, dp.getId_pe());
            ps.setInt(2, Integer.parseInt(dp.getDescripcion()));
            ps.execute();
            return true;
        }catch(NumberFormatException | SQLException e){
            System.out.println(e);
            return false;
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
}
