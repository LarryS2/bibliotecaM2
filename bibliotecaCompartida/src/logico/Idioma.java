package logico;

public class Idioma {
    
    private int id_idioma;
    private String codigo_idioma;
    private String nombre_idioma;
    private String descripcion;
    private boolean Estado;

    public Idioma() {
    }

    public Idioma(int id_idioma) {
        this.id_idioma = id_idioma;
    }

    public Idioma(String nombre_idioma) {
        this.nombre_idioma = nombre_idioma;
    }

    
    public Idioma(int id_idioma, String nombre_idioma) {
        this.id_idioma = id_idioma;
        this.nombre_idioma = nombre_idioma;
    }

    public Idioma(int id_idioma, String nombre_idioma, String descripcion) {
        this.id_idioma = id_idioma;
        this.nombre_idioma = nombre_idioma;
        this.descripcion = descripcion;
    }
    
    
    public Idioma(int id_idioma, String codigo_idioma, String nombre_idioma, String descripcion) {
        this.id_idioma = id_idioma;
        this.codigo_idioma = codigo_idioma;
        this.nombre_idioma = nombre_idioma;
        this.descripcion = descripcion;
    }
    
    public int getId_idioma() {
        return id_idioma;
    }

    public void setId_idioma(int id_idioma) {
        this.id_idioma = id_idioma;
    }

    public String getNombre_idioma() {
        return nombre_idioma;
    }

    public void setNombre_idioma(String nombre_idioma) {
        this.nombre_idioma = nombre_idioma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo_idioma() {
        return codigo_idioma;
    }

    public void setCodigo_idioma(String codigo_idioma) {
        this.codigo_idioma = codigo_idioma;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        //return id_idioma + " " + " " + nombre_idioma + " "  + descripcion;
        return nombre_idioma;
    }
    
    

    
    public String MostrarVista(){
        return id_idioma+" "+nombre_idioma+" "+descripcion;
    }
    
    public boolean ValidarNombre(String nom)
    {
        return nom.matches("^[A-Za-z]{2,}");
    }
    
    public boolean ValidarDesc(String des)
    {
        return des.matches("^[A-Za-z]{2,}");
    }
    
}
