package logico;

import java.util.Date;


public class Ebook extends Libro{
    
    private int id_e;
    private String url;

    public Ebook() {
    }

    public Ebook(String codigo) {
        super(codigo);
    }

    public Ebook(int id_e, String url, int id, String codigo, String isbn, int dewey, int id_autor, int id_idioma, int id_categoria, int id_editorial, String titulo, String descripcion, Date fecha_Publicacion, int cantidad, int numero_pags, boolean Estado) {
        super(id, codigo, isbn, dewey, id_autor, id_idioma, id_categoria, id_editorial, titulo, descripcion, fecha_Publicacion, cantidad, numero_pags, Estado);
        this.id_e = id_e;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId_e() {
        return id_e;
    }

    public void setId_e(int id_e) {
        this.id_e = id_e;
    }

    @Override
    public String toString() {
        return "Ebook{" + "id_e=" + id_e + ", url=" + url + '}';
    }


}
