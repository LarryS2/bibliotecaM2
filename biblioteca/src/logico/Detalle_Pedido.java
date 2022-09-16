package logico;

public class Detalle_Pedido {
    
    private int id_det_pe;
    private int id_pe;
    private String descripcion;

    public Detalle_Pedido() {
    }

    public Detalle_Pedido(int id_det_pe) {
        this.id_det_pe = id_det_pe;
    }

    public Detalle_Pedido(int id_det_pe, int id_pe, String descripcion) {
        this.id_det_pe = id_det_pe;
        this.id_pe = id_pe;
        this.descripcion = descripcion;
    }

    public int getId_det_pe() {
        return id_det_pe;
    }

    public void setId_det_pe(int id_det_pe) {
        this.id_det_pe = id_det_pe;
    }

    public int getId_pe() {
        return id_pe;
    }

    public void setId_pe(int id_pe) {
        this.id_pe = id_pe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Detalle_Pedido{" + "id_det_pe=" + id_det_pe + ", id_pe=" + id_pe + ", descripcion=" + descripcion + '}';
    }
}
