
package Vista;

import Dominio.Publicacion;
import Negocio.GestionPublicacion;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaConsulta extends JDialog {
    private Container contenedor;
    private JPanel panelFiltro, panelBase;
    private JScrollPane panelResultado;
    private JLabel lFiltro;
    private JTextField tFiltro;
    private JTable tabla;
    private DefaultTableModel modelo; 
    private String titulos[]= {"ISBN","TITULO","AÑO DE PUBLICACION","AUTOR","PRECIO"
                              ,"DURACION","FORMATO","PESO","NPAGINAS","AÑO DE EDICION"}; 
    private GestionPublicacion gestor;
    

    public VentanaConsulta(JFrame frame, boolean bln){
        super(frame, bln);
        this.setTitle("Busqueda de publicaciones - V1");
        this.gestor = new GestionPublicacion();
        this.iniciarComponentes();
        //this.pack(); 
        this.setSize(1200, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.panelBase = new JPanel();
        this.panelBase.setLayout(new BorderLayout());
        this.panelBase.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.iniciarPanelFiltro();
        this.iniciarPanelResultado();
        this.mostraTotalRegistros();
        this.contenedor.add(this.panelBase);
    }
    
    public void iniciarPanelFiltro(){
        this.panelFiltro = new JPanel();
        this.panelFiltro.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        this.lFiltro = new JLabel("Filtro busqueda: ");
        this.tFiltro = new JTextField(10);
        this.tFiltro.addKeyListener(new EventoTecladoFiltro());
        
        this.panelFiltro.add(this.lFiltro);
        this.panelFiltro.add(this.tFiltro);
        
        this.panelBase.add(this.panelFiltro, BorderLayout.NORTH);
    }
    
    public void iniciarPanelResultado(){
        this.panelResultado = new JScrollPane();
        
        this.tabla = new JTable();
        this.modelo = new DefaultTableModel(null, this.titulos);
        this.tabla.setModel(modelo);
        this.panelResultado.setViewportView(this.tabla);
        
        this.panelBase.add(this.panelResultado, BorderLayout.CENTER);
        
    }
    
    public void mostraTotalRegistros(){
        try{
            List<Publicacion> lista = this.gestor.leerPublicaciones();
            
        }catch(IOException ioe){
            this.ventanaMsg("Error", ioe.getMessage(), JOptionPane.ERROR_MESSAGE);
        }     
        
    }
    
    public void actualizarTabla(List<Publicacion> lista){
        this.modelo.setNumRows(0);
        for(Publicacion p: lista){
            String linea[] ={p.getIsbn(), p.getTitulo(), ""+p.getAnio(),
                             p.getAutor(), ""+p.getCosto(), ""+p.getAudioLibro().getDuracion(), 
                             ""+p.getAudioLibro().getFormato(), ""+p.getAudioLibro().getPeso(),
                             ""+p.getLibro().getnPaginas(), ""+p.getLibro().getaEdicion()
                            };
            this.modelo.addRow(linea);
        }  
    }
    
    public void ventanaMsg(String msg, String titulo, int tipo) {
        JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }
    
    public void filtrarTabla(){
        String texto = this.tFiltro.getText();
        try{
            List<Publicacion> listaFiltrada = this.gestor.filtrarRegistroPublicaciones(texto);
            this.actualizarTabla(listaFiltrada);
            
        }catch(IOException ioe){
            this.ventanaMsg("Error", ioe.getMessage(), JOptionPane.ERROR_MESSAGE);
        }    
    }
    
    class EventoTecladoFiltro extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent ke) {
            filtrarTabla();
        }
    }
}
