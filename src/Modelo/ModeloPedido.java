package Modelo;

import logico.Conexion;
import logico.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import logico.Detalle_Pedido;
import logico.Ejemplar;
import logico.Libro;

public class ModeloPedido {
    
    public String NoSerie(){
        String serie = "";
        Connection con = Conexion.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql ="SELECT MAX(codigo_enc_ped) FROM encabezado_pedido";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                serie = rs.getString(1);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return serie;
    }
    
    public static int getIdPerson(String cedula){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT e.id_est FROM persona p, estudiante e WHERE cedula_per = ? AND p.id_per = e.id_per_est";
        
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

        String sql = "INSERT INTO encabezado_pedido (codigo_enc_ped, fecha_inicio_ped, fecha_fin_ped, id_cliente_ped, total_enc_ped, estado_enc) VALUES (?, ?, ?, ?, ?, False)";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, pedido.getCodigo_pedido());
            ps.setDate(2, pedido.getFecha_inicio_pedido());
            ps.setDate(3, pedido.getFecha_fin_pedido());
            ps.setInt(4, pedido.getId_est());
            ps.setInt(5, pedido.getTotal());
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
        
        String sql = "UPDATE encabezado_pedido SET id_cliente_ped = ?, fecha_inicio_ped = ?, fecha_fin_ped = ?, total_enc_ped = ? WHERE id_enc_ped = ?";
        
        try{
            ps = con.prepareCall(sql);
            ps.setInt(1, pedido.getId_est());
            ps.setDate(2, (Date) pedido.getFecha_inicio_pedido());
            ps.setDate(3, (Date) pedido.getFecha_fin_pedido());
            ps.setInt(4, pedido.getTotal());
            ps.setInt(5, pedido.getId_pedido());
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
        
        String sql = "UPDATE encabezado_pedido SET estado_enc = True WHERE id_enc_ped = ?";
        
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
        String sql = "SELECT MAX(id_enc_ped) FROM encabezado_pedido";
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
        
        String sql = "SELECT id_lib FROM libro WHERE codigo_lib = ?";
        
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
        
        String sql = "INSERT INTO detalle_pedido (id_enc_ped, id_lib_det, estado_det_ped) VALUES (?,?,False)";
        
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
    
    public Ejemplar getStock(Libro libro){
        Ejemplar lb = new Ejemplar();
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        ResultSet rs;
        
        String sql = "SELECT id_ejem, cantidad_ejem FROM ejemplar WHERE id_lib_ejem = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, libro.getId());
            rs = ps.executeQuery();
            
            while(rs.next()){
                lb.setId(rs.getInt(1));
                lb.setCantidad(rs.getInt(2));
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
        return lb;
    }
    
    public void actualizarStock(Ejemplar ejemplar){
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        
        String sql = "UPDATE ejemplar SET cantidad_ejem = ? WHERE id_ejem = ? ";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, ejemplar.getCantidad());
            ps.setInt(2, ejemplar.getId());
            ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }finally {
            try {
                con.close();
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
    }
}
