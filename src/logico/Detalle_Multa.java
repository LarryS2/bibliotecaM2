
package logico;

public class Detalle_Multa {
    
    private int id_det;
    private int enc_mult_id;
    private int id_lib_mul;
    private boolean Estado;

    public Detalle_Multa() {
    }

    public Detalle_Multa(int id_det) {
        this.id_det = id_det;
    }

    public Detalle_Multa(int enc_mult_id, int id_lib_mul) {
        this.enc_mult_id = enc_mult_id;
        this.id_lib_mul = id_lib_mul;
    }

    public Detalle_Multa(int id_det, int enc_mult_id, int id_lib_mul, boolean Estado) {
        this.id_det = id_det;
        this.enc_mult_id = enc_mult_id;
        this.id_lib_mul = id_lib_mul;
        this.Estado = Estado;
    }

    public int getId_det() {
        return id_det;
    }

    public void setId_det(int id_det) {
        this.id_det = id_det;
    }

    public int getEnc_mult_id() {
        return enc_mult_id;
    }

    public void setEnc_mult_id(int enc_mult_id) {
        this.enc_mult_id = enc_mult_id;
    }

    public int getId_lib_mul() {
        return id_lib_mul;
    }

    public void setId_lib_mul(int id_lib_mul) {
        this.id_lib_mul = id_lib_mul;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return id_det + " " + enc_mult_id + " " + id_lib_mul;
    }
}
