
package Dominio;

public class Libro extends Publicacion {
    private int nPaginas;
    private int aedicion;
    
    public Libro(String isbn){
        super(isbn);
    }

    public Libro(int nPaginas, int edicion, String isbn, String titulo, String autor, int anio, Double costo) {
        super(isbn, titulo, autor, anio, costo);
        this.nPaginas = nPaginas;
        this.aedicion = aedicion;
    }

   
    public int getnPaginas() {
        return nPaginas;
    }

    public int getaEdicion() {
        return aedicion;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public void setEdicion(int aedicion) {
        this.aedicion = aedicion;
    }
    
   
    public String getInfo() {
        return "\nNumero de paginas: " +this.nPaginas + "\nAño de edicion: " + this.aedicion;
    }
}
