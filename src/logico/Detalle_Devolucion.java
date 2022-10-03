package logico;

public class Detalle_Devolucion {
    
    private int id_det_dev;
    private int id_enc_dev;
    private int id_lib;
    private boolean estado;

    public Detalle_Devolucion() {
    }

    public int getId_det_dev() {
        return id_det_dev;
    }

    public void setId_det_dev(int id_det_dev) {
        this.id_det_dev = id_det_dev;
    }

    public int getId_enc_dev() {
        return id_enc_dev;
    }

    public void setId_enc_dev(int id_enc_dev) {
        this.id_enc_dev = id_enc_dev;
    }

    public int getId_lib() {
        return id_lib;
    }

    public void setId_lib(int id_lib) {
        this.id_lib = id_lib;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Detalle_Devolucion{" + "id_det_dev=" + id_det_dev + ", id_enc_dev=" + id_enc_dev + ", id_lib=" + id_lib + ", estado=" + estado + '}';
    }
    
}
