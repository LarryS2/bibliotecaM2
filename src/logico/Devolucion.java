package logico;

import java.util.Date;

public class Devolucion {
    
    private int id_dv;
    private Date fecha_dev;
    private int id_est_dev;
    private boolean estado;

    public Devolucion() {
    }

    public Devolucion(int id_dv, Date fecha_dev, int id_est_dev, boolean estado) {
        this.id_dv = id_dv;
        this.fecha_dev = fecha_dev;
        this.id_est_dev = id_est_dev;
        this.estado = estado;
    }

    public int getId_dv() {
        return id_dv;
    }

    public void setId_dv(int id_dv) {
        this.id_dv = id_dv;
    }

    public Date getFecha_dev() {
        return fecha_dev;
    }

    public void setFecha_dev(Date fecha_dev) {
        this.fecha_dev = fecha_dev;
    }

    public int getId_est_dev() {
        return id_est_dev;
    }

    public void setId_est_dev(int id_est_dev) {
        this.id_est_dev = id_est_dev;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ModeloDevolucion{" + "id_dv=" + id_dv + ", fecha_dev=" + fecha_dev + ", id_est_dev=" + id_est_dev + ", estado=" + estado + '}';
    }
}
