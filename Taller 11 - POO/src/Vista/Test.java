package Vista;

import Datos.*;
import Dominio.Publicacion;
import Negocio.GestionPublicacion;
import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException {
        VentanaPrincipal principal = new VentanaPrincipal(); 
    }
    
    public static void imprimirListado(List<Publicacion> lista){
        for(Publicacion p : lista){
               System.out.println(p);
        }
        System.out.println(lista.size() + " Publicaiones registradas");
    }
}
