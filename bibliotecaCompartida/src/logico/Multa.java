package logico;

import java.util.Date;

public class Multa {
    
    private int id_multa;
    private double cantidad_multa;
    private String ced_usuario;
    private Date fecha_aplicacion;
    private boolean Estado;

    public Multa() {
    }

    public Multa(int id_multa) {
        this.id_multa = id_multa;
    }

    public Multa(int id_multa, double cantidad_multa, String ced_usuario, Date fecha_aplicacion) {
        this.id_multa = id_multa;
        this.cantidad_multa = cantidad_multa;
        this.ced_usuario = ced_usuario;
        this.fecha_aplicacion = fecha_aplicacion;
    }
    
    public int getId_multa() {
        return id_multa;
    }

    public void setId_multa(int id_multa) {
        this.id_multa = id_multa;
    }

    public double getCantidad_multa() {
        return cantidad_multa;
    }

    public void setCantidad_multa(double cantidad_multa) {
        this.cantidad_multa = cantidad_multa;
    }

    public String getCed_usuario() {
        return ced_usuario;
    }

    public void setCed_usuario(String ced_usuario) {
        this.ced_usuario = ced_usuario;
    }

    public Date getFecha_aplicacion() {
        return fecha_aplicacion;
    }

    public void setFecha_aplicacion(Date fecha_aplicacion) {
        this.fecha_aplicacion = fecha_aplicacion;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Multa{" + "id_multa=" + id_multa + ", cantidad_multa=" + cantidad_multa + ", ced_usuario=" + ced_usuario + ", fecha_aplicacion=" + fecha_aplicacion + '}';
    }
}
