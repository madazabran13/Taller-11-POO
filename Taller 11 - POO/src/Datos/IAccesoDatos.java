package Datos;

import Dominio.Publicacion;
import java.io.IOException;
import java.util.List;

public interface IAccesoDatos {
    void insertaPublicacion(Publicacion p) throws IOException;
    List<Publicacion> leerPublicaciones() throws IOException;
    Publicacion buscarPublicacion(String isbn)throws IOException;
    List<Publicacion> consultarPublicaciones(String filtroTexto) throws IOException;
    void eliminarPublicacion(String isbn) throws IOException;
}
