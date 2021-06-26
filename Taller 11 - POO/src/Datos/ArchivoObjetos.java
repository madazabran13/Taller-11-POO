
package Datos;

import Dominio.Publicacion;
import java.io.*;
import java.util.List;

public class ArchivoObjetos implements IAccesoDatos{
    
    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    public ArchivoObjetos(String name) {
        this.archivo = new File(name);
    }

    public ArchivoObjetos() {
        this("Publicaciones.obj");
    }
    
    private void guardar(ListPublicaciones lista) throws IOException {
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo, false);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(lista);
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (oos != null) {
                oos.close();
            }

            if (this.aEscritura != null) {
                this.aEscritura.close();
            }
        }
    }
     
    private ListPublicaciones leer() throws IOException {
        ListPublicaciones lista = null;
        ObjectInputStream ois = null;

        if (this.archivo.exists()) {
            try {
                this.aLectura = new FileInputStream(this.archivo);
                ois = new ObjectInputStream(this.aLectura);
                lista = (ListPublicaciones) ois.readObject();
                return lista;
            } catch (IOException ioe) {
                throw ioe;
            } catch (ClassNotFoundException ex) {
                throw new IOException("La clase ListPublicaciones No existe");
            } finally {
                if (ois != null) {
                    ois.close();
                }
                if (this.aLectura != null) {
                    this.aLectura.close();
                }
            }
        }
        else{
            lista = new ListPublicaciones();
            return lista;
        }

    } 

    @Override
    public void insertaPublicacion(Publicacion p) throws IOException {
        ListPublicaciones lista = this.leer();
        lista.insertaPublicacion(p);
        this.guardar(lista);
    }

    @Override
    public List<Publicacion> leerPublicaciones() throws IOException {
        ListPublicaciones lista = this.leer();
        return lista.leerPublicaciones();
    }

    @Override
    public Publicacion buscarPublicacion(String isbn) throws IOException {
        ListPublicaciones lista = this.leer();
        return lista.buscarPublicacion(isbn);
    }

    @Override
    public void eliminarPublicacion(String isbn) throws IOException {
        ListPublicaciones lista = this.leer();
        lista.eliminarPublicacion(isbn);
        this.guardar(lista);
    }
    
    @Override
    public List<Publicacion> consultarPublicaciones(String filtroTexto) throws IOException {
        ListPublicaciones lista = this.leer();
        return  lista.consultarPublicaciones(filtroTexto);
    }
   
}
