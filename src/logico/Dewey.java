package logico;

public class Dewey {

    private int id;
    private String codigo;
    private String nombre_super_cat;
    private String nombre_cat;
    private String descripcion;
    private boolean estado;

    public Dewey() {
    }

    public Dewey(String nombre_super_cat) {
        this.nombre_super_cat = nombre_super_cat;
    }

    public Dewey(int id, String nombre_super_cat) {
        this.id = id;
        this.nombre_super_cat = nombre_super_cat;
    }

    public Dewey(int id, String codigo, String nombre_super_cat, String nombre_cat, String descripcion, boolean estado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre_super_cat = nombre_super_cat;
        this.nombre_cat = nombre_cat;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre_super_cat() {
        return nombre_super_cat;
    }

    public void setNombre_super_cat(String nombre_super_cat) {
        this.nombre_super_cat = nombre_super_cat;
    }

    public String getNombre_cat() {
        return nombre_cat;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre_super_cat;
    }
    
    public boolean Validar_Nombre_Dewey(String nomcat)
    {
        return nomcat.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
    }
}
