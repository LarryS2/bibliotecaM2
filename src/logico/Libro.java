package logico;

import java.util.Date;

public class Libro {
    private int id;
    private String codigo;
    private String isbn;
    private int dewey;
    private int id_autor;
    private int id_idioma;
    private int id_categoria;
    private int id_editorial;
    private String titulo;
    private String descripcion;
    private Date fecha_Publicacion;
    private int cantidad;
    private int numero_pags;
    private boolean Estado;

    public Libro() {
    }

    public Libro(String codigo) {
        this.codigo = codigo;
    }
    
    
    public Libro(String codigo, String isbn) {
        this.codigo = codigo;
        this.isbn = isbn;
    }

    public Libro(int id, String codigo, String isbn, int dewey, int id_autor, int id_idioma, int id_categoria, int id_editorial, String titulo, String descripcion, Date fecha_Publicacion, int cantidad, int numero_pags, boolean Estado) {
        this.id = id;
        this.codigo = codigo;
        this.isbn = isbn;
        this.dewey = dewey;
        this.id_autor = id_autor;
        this.id_idioma = id_idioma;
        this.id_categoria = id_categoria;
        this.id_editorial = id_editorial;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_Publicacion = fecha_Publicacion;
        this.cantidad = cantidad;
        this.numero_pags = numero_pags;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public int getId_idioma() {
        return id_idioma;
    }

    public void setId_idioma(int id_idioma) {
        this.id_idioma = id_idioma;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDewey() {
        return dewey;
    }

    public void setDewey(int dewey) {
        this.dewey = dewey;
    }

    public Date getFecha_Publicacion() {
        return fecha_Publicacion;
    }

    public void setFecha_Publicacion(Date fecha_Publicacion) {
        this.fecha_Publicacion = fecha_Publicacion;
    }

    public int getNumero_pags() {
        return numero_pags;
    }

    public void setNumero_pags(int numero_pags) {
        this.numero_pags = numero_pags;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Libro{" + "codigo=" + codigo + ", isbn=" + isbn + ", dewey=" + dewey + ", id_autor=" + id_autor + ", id_idioma=" + id_idioma + ", id_categoria=" + id_categoria + ", id_editorial=" + id_editorial + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fecha_Publicacion=" + fecha_Publicacion + ", cantidad=" + cantidad + ", numero_pags=" + numero_pags + '}';
    }
    
    /*6 números, comienza por cero*/
    public boolean Validar_Codigo_Libro(String cod) {
        return cod.matches("[0]{1}[1-9]{5}");
    }
    
    public boolean ValidarTitulo(String titulo)
    {
        return titulo.matches("^[A-Za-záéíóúñ\\s]{1,}[\\.]{0,1}[A-Za-záéíóúñ\\s]{0,}$");
    }
    
    public boolean Validar_Editorial(String dire)
    {
        return dire.matches("^[A-Za-záéíóúñ\\s]{1,}[\\.]{0,1}[A-Za-záéíóúñ\\s]{0,}$");
    }
    
    
    public boolean Validar_cantidad(int cant) {
        boolean valido = true;
        if (cant<=0 || cant>1000) {
            valido = false;
        }
        return valido;
    }
    
    
}
