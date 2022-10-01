package logico;

public class Rol {
    
    private int id;
    private String nombre_rol;
    private String descp_rol;
    private boolean estado;

    public Rol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public String getDescp_rol() {
        return descp_rol;
    }

    public void setDescp_rol(String descp_rol) {
        this.descp_rol = descp_rol;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", nombre_rol=" + nombre_rol + ", descp_rol=" + descp_rol + ", estado=" + estado + '}';
    }
}
