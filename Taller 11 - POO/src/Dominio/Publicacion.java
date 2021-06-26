package Dominio;

public class Publicacion {
    public String isbn, titulo, autor;
    public int anio;
    public Double costo;
    
    private AudioLibro audioLibro;
    private Libro libro;

    
    public Publicacion() {
    }

    public Publicacion(String isbn) {
        this.isbn = isbn;
    }

    public Publicacion(String isbn, String titulo, String autor, int anio, Double costo) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.costo = costo;
    }

    
    public Publicacion(String isbn, String titulo, String autor, int anio, Double costo, AudioLibro audioLibro, Libro libro) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.costo = costo;
        this.audioLibro = audioLibro;
        this.libro = libro;
    }   
    
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public String getAutor() {
        return autor;
    }

    public Double getCosto() {
        return costo;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public AudioLibro getAudioLibro() {
        return audioLibro;
    }

    public void setAudioLibro(AudioLibro audioLibro) {
        this.audioLibro = audioLibro;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    @Override
    public String toString() {
        return  "\nISBN: " +isbn + 
                "\nTitulo: " + titulo + 
                "\nAño de publicacion: " + anio +
                "\nAutor: " + autor + 
                "\nPrecio: " + costo +
                "\nAudioLibro" + audioLibro +
                "\nLibro" +  libro;
    }
    
    
}
