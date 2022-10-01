package logico;

public class Seccion {
    
    private int id;
    private String codigo_zona;
    private String descripcion;
    private String nombre_zona;
    private int id_cate_zona;
    private boolean Estado;

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

    public Seccion(int id, String codigo_zona, String descripcion, String nombre_zona, int id_cate_zona, boolean Estado) {
        this.id = id;
        this.codigo_zona = codigo_zona;
        this.descripcion = descripcion;
        this.nombre_zona = nombre_zona;
        this.id_cate_zona = id_cate_zona;
        this.Estado = Estado;
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

    public int getId_cate_zona() {
        return id_cate_zona;
    }

    public void setId_cate_zona(int id_cate_zona) {
        this.id_cate_zona = id_cate_zona;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return nombre_zona;
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
