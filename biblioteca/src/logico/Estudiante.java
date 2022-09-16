package logico;

import java.util.Date;

public class Estudiante extends Persona{
    
    private int id_est;

    public Estudiante() {
    }

    public Estudiante(String cedula) {
        super(cedula);
    }

    public Estudiante(int id_est, int id, String cedula, String nombre, String apellido, String tipo_usuario, String email, String tipo_sangre, Date fecha_nac, String direccion, String genero, String telefono, String password) {
        super(id, cedula, nombre, apellido, tipo_usuario, email, tipo_sangre, fecha_nac, direccion, genero, telefono, password);
        this.id_est = id_est;
    }
    public int getId_est() {
        return id_est;
    }

    public void setId_est(int id_est) {
        this.id_est = id_est;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id_est=" + id_est + '}';
    }
}
