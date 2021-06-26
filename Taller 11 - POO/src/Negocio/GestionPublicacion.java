package Negocio;

import Datos.*;
import Dominio.Publicacion;;
import java.io.IOException;
import java.util.List;

public class GestionPublicacion {
    private IAccesoDatos datos;

    public GestionPublicacion() {
        this.datos = new ArchivoObjetos();
    }

    public void insertaPublicacion(Publicacion p) throws IOException {
        if(p==null)
            throw new NullPointerException("Debe registrar un Jugador");
        
        if(p.getIsbn()==null || p.getIsbn().isEmpty() )
            throw new NullPointerException("Debe registrar isbn de la publicacion");
        
        if(p.getTitulo()==null || p.getIsbn().isEmpty())
            throw new NullPointerException("Debe registrar titulo de la publicacion");
        
        if(p.getAutor()==null || p.getAutor().isEmpty())
            throw new NullPointerException("Debe registrar autor de la publicacion");
        
        if(p.getAnio()<=0)
            throw new NullPointerException("Debe registrar año de la publicacion");
        
        if(p.getCosto()<=0)
            throw new NullPointerException("Debe registrar costo de la publicacion");
        
        if(p.getAudioLibro().getDuracion()<=0)
            throw new NullPointerException("Debe registrar duracion del Audiolibro");
        
        if(p.getAudioLibro().getFormato()==null || p.getIsbn().isEmpty())
            throw new NullPointerException("Debe registrar formato del Audiolibro");
        
        if(p.getAudioLibro().getPeso()<=0)
            throw new NullPointerException("Debe registrar peso del Audiolibro");
        
        if(p.getLibro().getnPaginas()<=0)
            throw new NullPointerException("Debe registrar numero de paginas del libro");
        
        if(p.getLibro().getaEdicion()<=0)
            throw new NullPointerException("Debe registrar año de edicion del libro");
       
        if(this.datos.buscarPublicacion(p.getIsbn())!=null)
            throw new NullPointerException("El Jugador ya se encuentra registrado");
        
        this.datos.insertaPublicacion(p);
    }

    public List<Publicacion> leerPublicaciones() throws IOException {
        return this.datos.leerPublicaciones();
    }

    public void eliminarPublicacion(String isbn) throws IOException {
        if(isbn==null || isbn.isEmpty())
            throw new NullPointerException("Se debe registrar el isbn de la publicacion a eliminar");
        this.datos.eliminarPublicacion(isbn);
    }

    public List<Publicacion> filtrarRegistroPublicaciones(String filtro)throws IOException{
        return this.datos.consultarPublicaciones(filtro);
    }

    public Publicacion buscarPublicacion(String isbn) throws IOException {
        return this.datos.buscarPublicacion(isbn);
    }
}
