package logico;

public class Ciudad {
    private int id_ciudad;
    private int id_pais_ciu;
    private String nombre_ciudad;
    private boolean estado;

    public Ciudad() {
    }

    public Ciudad(int id_ciudad, String nombre_ciudad) {
        this.id_ciudad = id_ciudad;
        this.nombre_ciudad = nombre_ciudad;
    }
    
    
    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public int getId_pais_ciu() {
        return id_pais_ciu;
    }

    public void setId_pais_ciu(int id_pais_ciu) {
        this.id_pais_ciu = id_pais_ciu;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre_ciudad;
    }
    
    
    
}
    
