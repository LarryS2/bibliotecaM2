package logico;

import java.util.Date;

public class Bibliotecario extends Persona{
    
    private int id_bib;
    private int id_horario;

    public Bibliotecario() {
    }

    public Bibliotecario(int id_bib) {
        this.id_bib = id_bib;
    }
    
    public Bibliotecario(int id_bib, int id_horario) {
        this.id_bib = id_bib;
        this.id_horario = id_horario;
    }

    public Bibliotecario(int id_bib, int id_horario, int id, String cedula, String nombre, String apellido, String tipo_usuario, String email, String tipo_sangre, Date fecha_nac, String direccion, String genero, String telefono, String password) {
        super(id, cedula, nombre, apellido, tipo_usuario, email, tipo_sangre, fecha_nac, direccion, genero, telefono, password);
        this.id_bib = id_bib;
        this.id_horario = id_horario;
    }

    public int getId_bib() {
        return id_bib;
    }

    public void setId_bib(int id_bib) {
        this.id_bib = id_bib;
    }

    public int getId_horario() {
        return id_horario;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "id_bib=" + id_bib + ", id_horario=" + id_horario + '}';
    }
    
}
