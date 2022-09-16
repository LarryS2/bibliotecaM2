package logico;

public class Seccion {
    
    private int id;
    private String codigo_zona;
    private String descripcion;
    private String nombre_zona;

    public Seccion() {
    }

    public Seccion(String codigo_zona) {
        this.codigo_zona = codigo_zona;
    }

    public Seccion(int id, String codigo_zona, String descripcion, String nombre_zona) {
        this.id = id;
        this.codigo_zona = codigo_zona;
        this.descripcion = descripcion;
        this.nombre_zona = nombre_zona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_zona() {
        return codigo_zona;
    }

    public void setCodigo_zona(String codigo_zona) {
        this.codigo_zona = codigo_zona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre_zona() {
        return nombre_zona;
    }

    public void setNombre_zona(String nombre_zona) {
        this.nombre_zona = nombre_zona;
    }

    @Override
    public String toString() {
        return "Seccion{" + "id=" + id + ", codigo_zona=" + codigo_zona + ", descripcion=" + descripcion + ", nombre_zona=" + nombre_zona + '}';
    }
    
    public boolean ValidarNombre(String nom)
    {
        return nom.matches("^[A-Za-z]{2,}");
    }

    public boolean ValidarDescripcion(String desc)
    {
        return desc.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
    }
}
