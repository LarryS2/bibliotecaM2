package logico;

import java.util.Date;

public class Bibliotecario extends Persona{
    
    private int id_bib;
    private int id_horario;
    private String password;
    
    public Bibliotecario() {
    }

    public Bibliotecario(int id_bib) {
        this.id_bib = id_bib;
    }

    public Bibliotecario(String cedula) {
        super(cedula);
    }

    public Bibliotecario(String cedula, String tipo_usuario) {
        super(cedula, tipo_usuario);
    }
    
    public Bibliotecario(int id_bib, int id_horario) {
        this.id_bib = id_bib;
        this.id_horario = id_horario;
    }

    public Bibliotecario(int id_bib, int id_horario, String password, int id, String cedula, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String tipo_usuario, String email, String tipo_sangre, Date fecha_nac, String direccion, String genero, String telefono, boolean Estado) {
        super(id, cedula, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_usuario, email, tipo_sangre, fecha_nac, direccion, genero, telefono, Estado);
        this.id_bib = id_bib;
        this.id_horario = id_horario;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Bibliotecario{" + "id_bib=" + id_bib + ", id_horario=" + id_horario + '}';
    }
    
}
