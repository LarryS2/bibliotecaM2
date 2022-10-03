package logico;

import java.time.LocalTime;

public class Horario {
   
    private int id;
    private String codigo;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    private int id_dia;
    private boolean Estado;

    public Horario() {
    }
    
    public Horario(int id, LocalTime hora_inicio, LocalTime hora_fin) {
        this.id = id;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
    }

    public Horario(int id, String codigo, LocalTime hora_inicio, LocalTime hora_fin, int id_dia, boolean Estado) {
        this.id = id;
        this.codigo = codigo;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.id_dia = id_dia;
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
    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getId_dia() {
        return id_dia;
    }

    public void setId_dia(int id_dia) {
        this.id_dia = id_dia;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return id+" "+hora_inicio +" "+ hora_fin;
        //return id+" ";
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
