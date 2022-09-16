package logico;

import java.util.Date;

public class Horario {
   
    private int id;
    private String codigo;
    private Date hora_inicio;
    private Date hora_fin;
    private String descripcion;
    private boolean Estado;

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

    public Horario(int id, String codigo, Date hora_inicio, Date hora_fin, String descripcion, boolean Estado) {
        this.id = id;
        this.codigo = codigo;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.descripcion = descripcion;
        this.Estado = Estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + ", codigo=" + codigo + ", hora_inicio=" + hora_inicio + ", hora_fin=" + hora_fin + ", descripcion=" + descripcion + ", Estado=" + Estado + '}';
    }
    
    public boolean Validar_Hora(String hora){
        boolean b;
        char [] a = hora.toCharArray();
        String [] c = hora.split(":");
        b = !((a[0] == ' ') || (a[1] == ' ') || (a[2] == ' ') || (a[3] == ' ') || (a[4] == ' ')
                || (getInteger(c[0]) > 24) || getInteger(c[1]) > 59);
        return b;
    }
    
    public int getInteger(String value){
        int integer = Integer.parseInt(value);
        return integer;
    } 
    
  
}
