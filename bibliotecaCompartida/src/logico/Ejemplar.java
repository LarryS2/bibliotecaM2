package logico;

public class Ejemplar {
    
    private int id;
    private String codigo;
    private String cod_libro;
    private int cantidad;

    public Ejemplar(int id, String codigo, String cod_libro, int cantidad) {
        this.id = id;
        this.codigo = codigo;
        this.cod_libro = cod_libro;
        this.cantidad = cantidad;
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

    public String getCod_libro() {
        return cod_libro;
    }

    public void setCod_libro(String cod_libro) {
        this.cod_libro = cod_libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "id=" + id + ", codigo=" + codigo + ", cod_libro=" + cod_libro + ", cantidad=" + cantidad + '}';
    }
}
