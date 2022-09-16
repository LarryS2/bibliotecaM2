package logico;

import java.sql.Date;

public class Autor {
    
    private int id_autor;
    private String cod_autor;
    private String nombre_autor;
    private String segundo_nombre_autor;
    private String apellido_autor;
    private String segundo_apellido_autor;
    private Date fecha_nac;
    private String lengua_materna;
    private String pais_origen;

    public Autor() {
    }

    public Autor(int id_autor) {
        this.id_autor = id_autor;
    }    

    public Autor(int id_autor, String nombre_autor, String apellido_autor) {
        this.id_autor = id_autor;
        this.cod_autor = cod_autor;
        this.nombre_autor = nombre_autor;
        this.apellido_autor = apellido_autor;
        this.pais_origen = pais_origen;
    }

    public Autor(int id_autor, String cod_autor, String nombre_autor, String segundo_nombre_autor, String apellido_autor, String segundo_apellido_autor, Date fecha_nac, String lengua_materna, String pais_origen) {
        this.id_autor = id_autor;
        this.cod_autor = cod_autor;
        this.nombre_autor = nombre_autor;
        this.segundo_nombre_autor = segundo_nombre_autor;
        this.apellido_autor = apellido_autor;
        this.segundo_apellido_autor = segundo_apellido_autor;
        this.fecha_nac = fecha_nac;
        this.lengua_materna = lengua_materna;
        this.pais_origen = pais_origen;
    }

    
    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre_autor() {
        return nombre_autor;
    }

    public void setNombre_autor(String nombre_autor) {
        this.nombre_autor = nombre_autor;
    }

    public String getApellido_autor() {
        return apellido_autor;
    }

    public String getSegundo_nombre_autor() {
        return segundo_nombre_autor;
    }

    public void setSegundo_nombre_autor(String segundo_nombre_autor) {
        this.segundo_nombre_autor = segundo_nombre_autor;
    }

    public String getSegundo_apellido_autor() {
        return segundo_apellido_autor;
    }

    public void setSegundo_apellido_autor(String segundo_apellido_autor) {
        this.segundo_apellido_autor = segundo_apellido_autor;
    }

    public void setApellido_autor(String apellido_autor) {
        this.apellido_autor = apellido_autor;
    }

    public String getPais_origen() {
        return pais_origen;
    }

    public void setPais_origen(String pais_origen) {
        this.pais_origen = pais_origen;
    }

    public String getCod_autor() {
        return cod_autor;
    }

    public void setCod_autor(String cod_autor) {
        this.cod_autor = cod_autor;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getLengua_materna() {
        return lengua_materna;
    }

    public void setLengua_materna(String lengua_materna) {
        this.lengua_materna = lengua_materna;
    }

    @Override
    public String toString() {
        return nombre_autor + " " + apellido_autor;
    }
    
    public String toString1(){
        return "Autor{" + "id_autor=" + id_autor + ", cod_autor=" + cod_autor + ", nombre_autor=" + nombre_autor + ", segundo_nombre_autor=" + segundo_nombre_autor + ", apellido_autor=" + apellido_autor + ", segundo_apellido_autor=" + segundo_apellido_autor + ", fecha_nac=" + fecha_nac + ", lengua_materna=" + lengua_materna + ", pais_origen=" + pais_origen + '}';
    }
    
    public boolean ValidarNombresYapellidos(String nom)
    {
        return nom.matches("^[A-Za-z]{2,}");
    }
    
    
    
    
}
