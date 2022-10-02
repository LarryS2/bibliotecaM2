package logico;

public class Dia {
    
    private int id_dia;
    private String nom_dia;

    public Dia(int id_dia, String nom_dia) {
        this.id_dia = id_dia;
        this.nom_dia = nom_dia;
    }

    public Dia() {
    }

    public int getId_dia() {
        return id_dia;
    }

    public void setId_dia(int id_dia) {
        this.id_dia = id_dia;
    }

    public String getNom_dia() {
        return nom_dia;
    }

    public void setNom_dia(String nom_dia) {
        this.nom_dia = nom_dia;
    }

    @Override
    public String toString() {
        return nom_dia;
    }
}
