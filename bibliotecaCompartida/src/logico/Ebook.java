package logico;


public class Ebook extends Libro{
    
    private int id_e;
    private String url;

    public Ebook() {
    }

    public Ebook(String codigo) {
        super(codigo);
    }

    public Ebook(int id_e, String url, String codigo, String isbn, String id_autor, String id_idioma, String id_categoria, String id_editorial, String titulo, String descripcion) {
        super(codigo, isbn, id_autor, id_idioma, id_categoria, id_editorial, titulo, descripcion);
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
