package logico;

import java.util.Date;

public class Horario {
    private int id;
    private Date hora_inicio;
    private Date hora_fin;
    private String descripcion;

    public Horario() {
    }

    public Horario(int id) {
        this.id = id;
    }
    
    public Horario(int id, Date hora_inicio, Date hora_fin, String descripcion) {
        this.id = id;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Date hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Date getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Date hora_fin) {
        this.hora_fin = hora_fin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", hora_inicio=" + hora_inicio + ", hora_fin=" + hora_fin + ", descripcion=" + descripcion + '}';
    }    
}
