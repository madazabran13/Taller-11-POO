
package Vista;
    
import Dominio.Publicacion;
import Negocio.GestionPublicacion;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public final class VentanaRegistro extends JDialog {
    private JLabel lPublicacion, lisbn, ltitulo, lanio, lautor, lcosto, lduracion, lformato, lpeso, lnpaginas, laedicion;
    private JTextField tPublicacion, tisbn, ttitulo, tanio, tautor, tcosto, tduracion, tformato, tpeso, tnpaginas, taedicion;
    private JButton bGuardar, bCancelar, bNuevo, bBuscar, bEliminar;
    
    private JFormattedTextField  ftcosto;
    private JRadioButton rAudiolibro, rLibro;
    private ButtonGroup grupoRadio;
    private JSpinner sanio, snpaginas, saedicion;
    
    private JPanel panelDatos, panelBotones;
    private Container contenedor;
    private GestionPublicacion gestor;
    
    public VentanaRegistro(JFrame frame, boolean bln) {
        super(frame, bln);
        this.gestor = new GestionPublicacion();
        this.setTitle("FORMULARIO DE PUBLICACIONES");
        this.setSize(450, 500);
        //this.pack();
        this.iniciarComponentes();
        //this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void iniciarComponentes(){
        this.contenedor = this.getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.iniciarPanelDatos();
        this.iniciarPanelBotones();
        
        //this.iniciarPanelBotones();

    }
    
    public void iniciarPanelDatos(){
        //se crea el panel de datos
        this.panelDatos = new  JPanel();
        this.panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.panelDatos.setLayout(new GridLayout(13, 2, 5,5));
        
        this.lPublicacion = new JLabel("Tipo de publicacion: ");
        this.lisbn = new JLabel("No Isbn: ");
        this.ltitulo = new JLabel("Titulo: ");
        this.lanio = new JLabel("Año de publicacion: ");
        this.lautor = new JLabel("Autor: ");
        this.lcosto = new JLabel("Precio: ");
        this.lduracion = new JLabel("Duracion: ");
        this.lformato = new JLabel("Formato: ");
        this.lpeso = new JLabel("Peso: ");
        this.lnpaginas = new JLabel("No Paginas: ");
        this.laedicion = new JLabel("Año de edicion: ");
        
        
        
        this.tisbn = new JTextField(null);
        this.tisbn.setEnabled(false);
        
        this.ttitulo = new JTextField(null);
        this.ttitulo.setEnabled(false);
        
        this.tanio = new JTextField(null);
        
        this.tautor = new JTextField(null);
        this.tautor.setEnabled(false);
        
        this.tcosto = new JTextField(null);
        
        this.tduracion = new JTextField(null);
        
        this.tformato = new JTextField(null);
        this.tformato.setEnabled(false);
        
        this.tpeso = new JTextField(null);
        
        this.tnpaginas = new JTextField(null);
        
        this.taedicion = new JTextField(null);
        
        NumberFormat formato = NumberFormat.getInstance();
        this.ftcosto = new JFormattedTextField(formato);
        this.ftcosto.setEnabled(false);
        
        SpinnerNumberModel modeloSpinner1 = new SpinnerNumberModel(2021,1000,2021,1);
        this.sanio = new JSpinner();
        this.sanio.setModel(modeloSpinner1);
        this.sanio.setEnabled(false);
        
        SpinnerNumberModel modeloSpinner2 = new SpinnerNumberModel(2021,1000,2021,1);
        this.saedicion = new JSpinner();
        this.saedicion.setModel(modeloSpinner2);
        this.saedicion.setEnabled(false);
        
        SpinnerNumberModel modeloSpinner = new SpinnerNumberModel();
        this.snpaginas = new JSpinner();
        this.snpaginas.setModel(modeloSpinner);
        this.snpaginas.setEnabled(false);
        
        
        this.rAudiolibro = new JRadioButton("Audiolibro");
        this.rAudiolibro.setSelected(true);
        this.rAudiolibro.setEnabled(false);
        this.rLibro = new JRadioButton("Libro");
        this.rLibro.setEnabled(false);
        this.grupoRadio = new ButtonGroup();
        this.grupoRadio.add(this.rAudiolibro);
        this.grupoRadio.add(this.rLibro);
        
        this.bGuardar = new JButton("Guardar");
        this.bGuardar.addActionListener(new ClickBotonGuardar());
        this.bGuardar.setEnabled(false);
        this.bCancelar = new JButton("Cancelar");
        this.bCancelar.addActionListener(new ClickBotonCancelar());
        this.bCancelar.setEnabled(false);
       
        JPanel panelRadio = new JPanel();
        panelRadio.setLayout(new FlowLayout());

        panelRadio.add(this.rAudiolibro);
        panelRadio.add(this.rLibro);

        this.panelDatos.add(this.lPublicacion);
        this.panelDatos.add(panelRadio);
        
        this.panelDatos.add(this.lisbn);
        this.panelDatos.add(this.tisbn);
        
        this.panelDatos.add(this.ltitulo);
        this.panelDatos.add(this.ttitulo);
        
        this.panelDatos.add(this.lanio);
        this.panelDatos.add(this.sanio);
        
        this.panelDatos.add(this.lautor);
        this.panelDatos.add(this.tautor);
        
        this.panelDatos.add(this.lcosto);
        this.panelDatos.add(this.tcosto);
        
        this.panelDatos.add(this.lduracion);
        this.panelDatos.add(this.tduracion);
        
        this.panelDatos.add(this.lformato);
        this.panelDatos.add(this.tformato);
        
        this.panelDatos.add(this.lpeso);
        this.panelDatos.add(this.tpeso);
        
        this.panelDatos.add(this.lnpaginas);
        this.panelDatos.add(this.snpaginas);
        
        this.panelDatos.add(this.laedicion);
        this.panelDatos.add(this.saedicion);
        
        this.panelDatos.add(this.bGuardar);
        this.panelDatos.add(this.bCancelar);
        
        //se le adiciona a nuestro panel de la ventana,para que sea visible
        this.contenedor.add(this.panelDatos,  BorderLayout.CENTER);
        
    }
    
    public void iniciarPanelBotones(){
        this.panelBotones = new JPanel();
        this.panelBotones.setLayout(new GridLayout(3, 1, 5, 5));
        
        this.bNuevo = new JButton("Nuevo");
        this.bNuevo.addActionListener(new clickBotonNuevo());

        this.bBuscar = new JButton("Buscar");
        this.bBuscar.addActionListener(new ClickBotonBuscar());
        this.bBuscar.setEnabled(false);
        this.bEliminar = new JButton("Eliminar");
        this.bEliminar.addActionListener(new ClickBotonEliminar());
        this.bEliminar.setEnabled(false);
        
        this.panelBotones.add(this.bNuevo);
        this.panelBotones.add(this.bBuscar);
        this.panelBotones.add(this.bEliminar);
        
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10,10, 10, 10));
        panel.add(this.panelBotones);

        this.contenedor.add(panel, BorderLayout.EAST);
        
    }
    
    public void activarComponentes(){
        this.rAudiolibro.setEnabled(true);
        this.rLibro.setEnabled(true);
        this.tisbn.setEnabled(true);
        this.ttitulo.setEnabled(true);
        this.sanio.setEnabled(true);
        this.tautor.setEnabled(true);
        this.tduracion.setEnabled(true);
        this.tformato.setEnabled(true);
        this.tpeso.setEnabled(true);
        this.snpaginas.setEnabled(true);
        this.saedicion.setEnabled(true);
        this.ftcosto.setEnabled(true);
        this.bGuardar.setEnabled(true);
        this.bCancelar.setEnabled(true);
        this.bBuscar.setEnabled(true);
        this.bEliminar.setEnabled(true);
        this.tisbn.grabFocus();
    }
    
    public void desactivarComponentes() {
        this.rAudiolibro.setEnabled(false);
        this.rLibro.setEnabled(false);
        this.tisbn.setEnabled(false);
        this.ttitulo.setEnabled(false);
        this.sanio.setEnabled(false);
        this.tautor.setEnabled(false);
        this.tduracion.setEnabled(false);
        this.tformato.setEnabled(false);
        this.tpeso.setEnabled(false);
        this.snpaginas.setEnabled(false);
        this.saedicion.setEnabled(false);
        this.ftcosto.setEnabled(false);
        this.bGuardar.setEnabled(false);
        this.bCancelar.setEnabled(false);
        this.bBuscar.setEnabled(false);
        this.bEliminar.setEnabled(false);
       
    }
    
    public void limpiarComponentes(){
        this.rAudiolibro.setSelected(true);
        this.tisbn.setText(null);
        this.ttitulo.setText(null);
        this.sanio.setValue(2021);
        this.tautor.setText(null);
        this.tduracion.setText(null);
        this.tformato.setText(null);
        this.tpeso.setText(null);
        this.snpaginas.setValue(1);
        this.saedicion.setValue(2021);
        this.ftcosto.setValue(null);
    }
    
    public Publicacion leerComponentes(){
        
        String publicacion = this.rAudiolibro.isSelected() ? "Libro" : "Audiolibro";
        String isbn = this.tisbn.getText();
        String titulo = this.ttitulo.getText();
        String autor = this.tautor.getText();
        int anio = (int)this.sanio.getValue();
        Object objectValue = this.ftcosto.getValue();
        double costo = Double.parseDouble(this.ftcosto.getValue().toString());;
        double duracion = Double.parseDouble(this.tduracion.toString());
        String formato = this.tformato.getText();
        double peso = Double.parseDouble(this.tpeso.toString());
        int npaginas = (int)this.snpaginas.getValue();
        int aedicion = (int)this.saedicion.getValue();
        
        Publicacion p = new Publicacion(isbn, titulo, autor, anio, costo).getAudioLibro().getLibro();
        return p;
        
    }
    
    public void guardarPublicacion(){
        try{
            Publicacion p = this.leerComponentes();
            this.gestor.insertaPublicacion(p);
            this.ventanaMsg("Datos guardados cone exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
            this.limpiarComponentes();
            this.tisbn.grabFocus();
        } catch (IOException | NumberFormatException | NullPointerException ex) {
            this.ventanaMsg(ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void actualizarValoresComponentes(Publicacion p){
                if(p.getAudioLibro().equals("Audiolibro"))
                    this.rAudiolibro.setSelected(true);
                else
                    this.rLibro.setSelected(true);
                this.tisbn.setText(p.getIsbn());
                this.ttitulo.setText(p.getTitulo());
                this.tautor.setText(p.getAutor());
                this.sanio.setValue(p.getAnio());
                this.ftcosto.setValue(p.getCosto());
                this.tduracion.setText(String.valueOf(p.getAudioLibro().getDuracion()));
                this.tformato.setText(p.getIsbn());
                this.tpeso.setText(String.valueOf(p.getAudioLibro().getPeso()));
                this.snpaginas.setValue(p.getLibro().getnPaginas());
                this.saedicion.setValue(p.getLibro().getaEdicion());
    }
    
    public void eliminarPublicacion(){
        try {
            String isbn = this.tisbn.getText();
            int confirma = JOptionPane.showConfirmDialog(this, "Desea confirmar la eliminacion del elemento", "Mensaje", JOptionPane.OK_CANCEL_OPTION);
            if(confirma==0){
               this.gestor.eliminarPublicacion(isbn);
               this.ventanaMsg("Datos eliminador con exito", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
               this.limpiarComponentes();
               this.bEliminar.setEnabled(false);
            }
        } catch (IOException ex) {
            this.limpiarComponentes();
            this.bEliminar.setEnabled(false);
            this.ventanaMsg(ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void buscarPublicacion() {
        try {
            String isbn = this.tisbn.getText();
            Publicacion p = this.gestor.buscarPublicacion(isbn);
            if(p!=null){
                this.actualizarValoresComponentes(p);
                //this.desactivarComponentes();
                this.bEliminar.setEnabled(true);
            }
            else{
                this.limpiarComponentes();
                this.bEliminar.setEnabled(true);
                this.tisbn.setText(isbn);
                this.bEliminar.setEnabled(false);
                this.ventanaMsg("La publicacion no está registrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException ex) {
           this.limpiarComponentes();
           this.bEliminar.setEnabled(false);
           this.ventanaMsg(ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void ventanaMsg(String msg, String titulo, int tipo){
      JOptionPane.showMessageDialog(this, msg, titulo, tipo);
    }

    
    class clickBotonNuevo implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            activarComponentes();
        }
    }
    
    class ClickBotonGuardar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            guardarPublicacion();
        }
    
    }
    
    class ClickBotonCancelar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            limpiarComponentes();
            desactivarComponentes();
            tisbn.grabFocus();
        }

    }
    
    class ClickBotonBuscar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            buscarPublicacion();
        }

    }
    class ClickBotonEliminar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            eliminarPublicacion();
        }

    }
}
