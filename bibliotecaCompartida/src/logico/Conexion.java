package logico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Conexion {
    static String bd = "biblioteca";
    static String url = "jdbc:mysql://localhost:3306/";
    static String user = "root";
    static String password = "";
    static String driver = "com.mysql.cj.jdbc.Driver";
    
    static Connection con;
    
    public Conexion(){
    }
    
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url+bd, user, password);
            System.out.println("CONEXIÓN ESTABLECIDA");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex);
            System.out.println("FALLÓ LA CONEXIÓN");
        }
        return con;
    }
    
    public static void Desconectar(){
        try {
            con.close();
            System.out.println("CONEXIÓN CERRADA");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR INESPERADO AL CERRAR");
        }
    }
}
