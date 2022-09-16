package logico;

import java.util.Date;

public class Estudiante extends Persona{
    
    private int id_est;
    private String codigo_est;
    private String password;
    public Estudiante() {
    }

    public Estudiante(int id) {
        super(id);
    }

    public Estudiante(String cedula) {
        super(cedula);
    }

    public Estudiante(String cedula, String tipo_usuario) {
        super(cedula, tipo_usuario);
    }

    public Estudiante(int id_est, String codigo_est, String password, int id, String cedula, String primer_nombre, String segundo_nombre, String primer_apellido, String segundo_apellido, String tipo_usuario, String email, String tipo_sangre, Date fecha_nac, String direccion, String genero, String telefono, boolean Estado) {
        super(id, cedula, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, tipo_usuario, email, tipo_sangre, fecha_nac, direccion, genero, telefono, Estado);
        this.id_est = id_est;
        this.codigo_est = codigo_est;
        this.password = password;
    }

    public int getId_est() {
        return id_est;
    }

    public void setId_est(int id_est) {
        this.id_est = id_est;
    }

    public String getCodigo_est() {
        return codigo_est;
    }

    public void setCodigo_est(String codigo_est) {
        this.codigo_est = codigo_est;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id_est=" + id_est + '}';
    }
}
