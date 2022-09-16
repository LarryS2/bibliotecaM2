package logico;

public class Editorial {
    
    private int id;
    private String codigo;
    private String nombre;
    private String direccion;
    private String url_editorial;
    private String tipo_editorial;
    private String nombre_rep;
    private String apellido_rep;
    private boolean estado;
    

    public Editorial() {
    }

    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    public Editorial(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Editorial(int id, String codigo, String nombre, String direccion, String url_editorial, String tipo_editorial, String nombre_rep, String apellido_rep, boolean estado) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.url_editorial = url_editorial;
        this.tipo_editorial = tipo_editorial;
        this.nombre_rep = nombre_rep;
        this.apellido_rep = apellido_rep;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrl_editorial() {
        return url_editorial;
    }

    public void setUrl_editorial(String url_editorial) {
        this.url_editorial = url_editorial;
    }

    public String getTipo_editorial() {
        return tipo_editorial;
    }

    public void setTipo_editorial(String tipo_editorial) {
        this.tipo_editorial = tipo_editorial;
    }

    public String getNombre_rep() {
        return nombre_rep;
    }

    public void setNombre_rep(String nombre_rep) {
        this.nombre_rep = nombre_rep;
    }

    public String getApellido_rep() {
        return apellido_rep;
    }

    public void setApellido_rep(String apellido_rep) {
        this.apellido_rep = apellido_rep;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        //return id + " " + nombre;
        return nombre;
    }
    

    public boolean ValidarNombreEd(String ed)
    {
        return ed.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
    }
    public boolean ValidarNombreRep(String nom)
    {
        return nom.matches("^[A-Za-z]{2,}");
    }
    
    
    
}
