package logico;

public class Dewey {

    private int id;
    private String codigo;
    private String nombre_super_cat;
    private String nombre_cat;
    private String descripcion;

    public Dewey() {
    }

    public Dewey(String nombre_super_cat) {
        this.nombre_super_cat = nombre_super_cat;
    }

    public Dewey(int id, String nombre_super_cat) {
        this.id = id;
        this.nombre_super_cat = nombre_super_cat;
    }

    public Dewey(int id, String codigo, String nombre_super_cat, String nombre_cat, String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.nombre_super_cat = nombre_super_cat;
        this.nombre_cat = nombre_cat;
        this.descripcion = descripcion;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre_super_cat
     */
    public String getNombre_super_cat() {
        return nombre_super_cat;
    }

    /**
     * @param nombre_super_cat the nombre_super_cat to set
     */
    public void setNombre_super_cat(String nombre_super_cat) {
        this.nombre_super_cat = nombre_super_cat;
    }

    /**
     * @return the nombre_cat
     */
    public String getNombre_cat() {
        return nombre_cat;
    }

    /**
     * @param nombre_cat the nombre_cat to set
     */
    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre_super_cat;
    }
    
    public boolean Validar_Nombre_Cat(String nomcat)
    {
        return nomcat.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
    }
}
