package Datos;

import Dominio.Publicacion;
import java.io.*;
import java.util.*;

public class ArchivoTexto implements IAccesoDatos {
   
    private File archivo;
    private FileWriter modoEscritura; // abre el archivo para escritura
    private Scanner modoLectura; // abre el archivo en modo lectura

    public ArchivoTexto() {
        this.archivo = new File("Publicaciones.txt");
    }

    public ArchivoTexto(String nombreArchivo) {
        this.archivo = new File(nombreArchivo);
    }
    
    @Override
    public void insertaPublicacion(Publicacion p) throws IOException {
        PrintWriter pw = null;
        try {
            this.modoEscritura = new FileWriter(this.archivo, true); // modo edicion
            pw = new PrintWriter(this.modoEscritura);
            pw.println(p.toString()); 
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if(pw!=null)
               pw.close();
            this.modoEscritura.close();   
        }
    }
    

    private Publicacion crearPublicacion(String linea) {
        String datos[] = linea.split(";");
        Publicacion p = new Publicacion();
        p.setIsbn(datos[0]);
        p.setTitulo(datos[1]);
        p.setAnio(Integer.parseInt(datos[2]));
        p.setAutor(datos[3]);
        p.setCosto(Double.parseDouble(datos[4]));
        p.getAudioLibro().setDuracion(Double.parseDouble(datos[5]));
        p.getAudioLibro().setFormato(datos[6]);
        p.getAudioLibro().setPeso(Double.parseDouble(datos[7]));
        p.getLibro().setnPaginas(Integer.parseInt(datos[8]));
        p.getLibro().setEdicion(Integer.parseInt(datos[9]));
        return p;
    }
    
    @Override
    public List<Publicacion> leerPublicaciones() throws IOException {
        List<Publicacion> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Publicacion p = this.crearPublicacion(linea);
                listado.add(p);
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
        
    }
    
    @Override
    public Publicacion buscarPublicacion(String isbn) throws IOException {
        Publicacion encontrado = null;
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Publicacion p = this.crearPublicacion(linea);
                if (p.getIsbn().equalsIgnoreCase(isbn)) {
                    encontrado = p;
                    break;
                }
            }
            return encontrado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }
    
    private void renombrarArchivo(File nvoArchivo) throws IOException {
        // se crea el archivo temporal si no existe
        if (!nvoArchivo.exists()) {
            nvoArchivo.createNewFile();
        }

        //se elimina el archivo original
        if (!this.archivo.delete()) {
            throw new IOException("No fue posible eliminar el archivo original");
        }

        //se renombra el archivo temporal
        if (!nvoArchivo.renameTo(this.archivo)) {
            throw new IOException("No fue posible renombrar el archivo temporal");
        }

    }
    
    @Override
    public void eliminarPublicacion(String isbn) throws IOException {
        try {
            this.modoLectura = new Scanner(this.archivo);
            ArchivoTexto archivoTemporal = new ArchivoTexto("Temporal.txt");
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Publicacion p = this.crearPublicacion(linea);
                    if (!p.getIsbn().equalsIgnoreCase(isbn)) {// eliminar
                        archivoTemporal.insertaPublicacion(p);
                    }
            }
            this.modoLectura.close();
            this.renombrarArchivo(archivoTemporal.archivo);
            
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            this.modoLectura.close();
        }
    } 

    @Override
    public List<Publicacion> consultarPublicaciones(String filtroTexto) throws IOException {
        List<Publicacion> listado = new ArrayList();
        try {
            this.modoLectura = new Scanner(this.archivo);
            while (this.modoLectura.hasNext()) {
                String linea = this.modoLectura.nextLine();
                Publicacion p = this.crearPublicacion(linea);
                if (p.getIsbn().contains(filtroTexto) || 
                        p.getTitulo().contains(filtroTexto) ||
                        p.getAutor().contains(filtroTexto)) {
                    listado.add(p);
                }
                
            }
            return listado;
        } catch (IOException ioe) {
            throw ioe;
        } finally {
            if (this.modoLectura != null) {
                this.modoLectura.close();
            }
        }
    }

    

}
