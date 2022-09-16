
package logico;

public class Detalle_Multa {
    
    private String id_det;
    private int enc_mult_id;
    private String descripcion_det;
    private boolean Estado;

    public Detalle_Multa() {
    }

    public Detalle_Multa(String id_det) {
        this.id_det = id_det;
    }

    public Detalle_Multa(String id_det, int enc_mult_id, String descripcion_det, boolean Estado) {
        this.id_det = id_det;
        this.enc_mult_id = enc_mult_id;
        this.descripcion_det = descripcion_det;
        this.Estado = Estado;
    }

    public Detalle_Multa(int enc_mult_id) {
        this.enc_mult_id = enc_mult_id;
    }

    public String getId_det() {
        return id_det;
    }

    public void setId_det(String id_det) {
        this.id_det = id_det;
    }

    public int getEnc_mult_id() {
        return enc_mult_id;
    }

    public void setEnc_mult_id(int enc_mult_id) {
        this.enc_mult_id = enc_mult_id;
    }

    public String getDescripcion_det() {
        return descripcion_det;
    }

    public void setDescripcion_det(String descripcion_det) {
        this.descripcion_det = descripcion_det;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Detalle_Multa{" + "id_det=" + id_det + ", enc_mult_id=" + enc_mult_id + ", descripcion_det=" + descripcion_det + '}';
    }
}
