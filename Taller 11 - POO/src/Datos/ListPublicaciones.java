
package Datos;

import Dominio.Publicacion;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ListPublicaciones implements IAccesoDatos, Serializable  {

    private List<Publicacion> lista;

    public ListPublicaciones() {
    }

    public ListPublicaciones(List<Publicacion> lista) {
        this.lista = new ArrayList();
    }
    
    
    @Override
    public void insertaPublicacion(Publicacion p) throws IOException {
        this.lista.add(p);
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws IOException {
        return this.lista;
    }

    
    @Override
    public Publicacion buscarPublicacion(String isbn) {
        for(Publicacion p: this.lista){
                if(p.getIsbn().equalsIgnoreCase(isbn)) {
                    return p;
                }
            }
            return null;
    }
    
    @Override
    public void eliminarPublicacion(String isbn) throws IOException {
        int contador = 0;
        Iterator<Publicacion> i = this.lista.iterator();
        while (i.hasNext()) {
            Publicacion p = i.next();
            if (p.getIsbn().equalsIgnoreCase(isbn)) {
                i.remove();
            }
        }
    }
    
    @Override
    public List<Publicacion> consultarPublicaciones(String filtroTexto) throws IOException {
        List<Publicacion> encontrados = new ArrayList();
        for (Publicacion p: this.lista) {
            if (p.getIsbn().contains(filtroTexto) || 
                        p.getTitulo().contains(filtroTexto) ||
                        p.getAutor().contains(filtroTexto)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    
}
