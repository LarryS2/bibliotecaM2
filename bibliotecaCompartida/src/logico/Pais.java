package logico;

public class Pais {

    private int id_pais;
    private String codigo_pais;
    private String nombre_pais;
    private String desc_pais;
    
    /**
     * @return the id_pais
     */
    public int getId_pais() {
        return id_pais;
    }

    /**
     * @param id_pais the id_pais to set
     */
    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    /**
     * @return the codigo_pais
     */
    public String getCodigo_pais() {
        return codigo_pais;
    }

    /**
     * @param codigo_pais the codigo_pais to set
     */
    public void setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
    }

    /**
     * @return the nombre_pais
     */
    public String getNombre_pais() {
        return nombre_pais;
    }

    /**
     * @param nombre_pais the nombre_pais to set
     */
    public void setNombre_pais(String nombre_pais) {
        this.nombre_pais = nombre_pais;
    }

    /**
     * @return the desc_pais
     */
    public String getDesc_pais() {
        return desc_pais;
    }

    /**
     * @param desc_pais the desc_pais to set
     */
    public void setDesc_pais(String desc_pais) {
        this.desc_pais = desc_pais;
    }
    
    public boolean Validar_Nombre_Pais(String nompa)
    {
        return nompa.matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$");
    }
}
