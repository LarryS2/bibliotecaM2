package logico;

public class Zona {
    
    private int id_barrio;
    private int id_ciu_bar;
    private String nombre_bar;
    private String calle_prin;
    private String calle_sec;
    private boolean estado_bar;

    public Zona() {
    }

    public int getId_barrio() {
        return id_barrio;
    }

    public void setId_barrio(int id_barrio) {
        this.id_barrio = id_barrio;
    }

    public int getId_ciu_bar() {
        return id_ciu_bar;
    }

    public void setId_ciu_bar(int id_ciu_bar) {
        this.id_ciu_bar = id_ciu_bar;
    }

    public String getNombre_bar() {
        return nombre_bar;
    }

    public void setNombre_bar(String nombre_bar) {
        this.nombre_bar = nombre_bar;
    }

    public String getCalle_prin() {
        return calle_prin;
    }

    public void setCalle_prin(String calle_prin) {
        this.calle_prin = calle_prin;
    }

    public String getCalle_sec() {
        return calle_sec;
    }

    public void setCalle_sec(String calle_sec) {
        this.calle_sec = calle_sec;
    }

    public boolean isEstado_bar() {
        return estado_bar;
    }

    public void setEstado_bar(boolean estado_bar) {
        this.estado_bar = estado_bar;
    }

    @Override
    public String toString() {
        return "Zona{" + "id_barrio=" + id_barrio + ", id_ciu_bar=" + id_ciu_bar + ", nombre_bar=" + nombre_bar + ", calle_prin=" + calle_prin + ", calle_sec=" + calle_sec + ", estado_bar=" + estado_bar + '}';
    }
}
