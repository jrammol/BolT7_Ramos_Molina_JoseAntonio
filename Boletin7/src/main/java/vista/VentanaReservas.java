package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ReservasController;
import modelo.ReservasModel;
import utiles.Utiles;

import javax.swing.JList;
import javax.swing.JTextArea;

public class VentanaReservas extends JFrame {
	
	private JPanel contentPane;
    private JTextField txtNombreReserva;
    private JTextField txtNumComensales;
    private JTextField txtFechaReserva;
    private JTextField txtHoraReserva;
    private JLabel lblAsteriscoNombre;
    private JLabel lblAsteriscoComensales;
    private JLabel lblAsteriscoFecha;
    private JLabel lblAsteriscoHora;
    private ReservasController reservasController;
    private JButton btnGuardar;
    private JList listReservas;
    private JLabel lblPopUpAsteriscos;

    

    /**
     * Create the frame.
     */
    public VentanaReservas() {
    	    	
        setTitle("Formulario de Reservas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana al presionar la "X"
        setBounds(100, 100, 1000, 307);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNombreReserva = new JLabel("Nombre de la Reserva:");
        lblNombreReserva.setBounds(20, 20, 150, 20);
        contentPane.add(lblNombreReserva);

        txtNombreReserva = new JTextField();
        txtNombreReserva.setBounds(180, 20, 180, 20);
        contentPane.add(txtNombreReserva);

        JLabel lblNumComensales = new JLabel("Número de Comensales:");
        lblNumComensales.setBounds(20, 60, 150, 20);
        contentPane.add(lblNumComensales);

        txtNumComensales = new JTextField();
        txtNumComensales.setBounds(180, 60, 180, 20);
        contentPane.add(txtNumComensales);

        JLabel lblFechaReserva = new JLabel("Fecha de la Reserva:");
        lblFechaReserva.setBounds(20, 100, 150, 20);
        contentPane.add(lblFechaReserva);

        txtFechaReserva = new JTextField();
        txtFechaReserva.setBounds(180, 100, 180, 20);
        contentPane.add(txtFechaReserva);

        JLabel lblHoraReserva = new JLabel("Hora de la Reserva:");
        lblHoraReserva.setBounds(20, 140, 150, 20);
        contentPane.add(lblHoraReserva);

        txtHoraReserva = new JTextField();
        txtHoraReserva.setBounds(180, 140, 180, 20);
        contentPane.add(txtHoraReserva);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 180, 100, 30);
        contentPane.add(btnGuardar);
        
        listReservas = new JList();
        listReservas.setBounds(448, 49, 500, 200);
        contentPane.add(listReservas);
        
        JLabel lblListaReservas = new JLabel("Lista Reservas");
        lblListaReservas.setBounds(667, 24, 110, 13);
        contentPane.add(lblListaReservas);
        
     // Inicializar los JLabels de los asteriscos
        lblAsteriscoNombre = new JLabel("*");
        lblAsteriscoNombre.setForeground(Color.RED);
        lblAsteriscoNombre.setBounds(370, 20, 10, 20);
        contentPane.add(lblAsteriscoNombre);
        lblAsteriscoNombre.setVisible(false);

        lblAsteriscoComensales = new JLabel("*");
        lblAsteriscoComensales.setForeground(Color.RED);
        lblAsteriscoComensales.setBounds(370, 60, 10, 20);
        contentPane.add(lblAsteriscoComensales);
        lblAsteriscoComensales.setVisible(false);

        lblAsteriscoFecha = new JLabel("*");
        lblAsteriscoFecha.setForeground(Color.RED);
        lblAsteriscoFecha.setBounds(370, 100, 10, 20);
        contentPane.add(lblAsteriscoFecha);
        lblAsteriscoFecha.setVisible(false);

        lblAsteriscoHora = new JLabel("*");
        lblAsteriscoHora.setForeground(Color.RED);
        lblAsteriscoHora.setBounds(370, 140, 10, 20);
        contentPane.add(lblAsteriscoHora);
        lblAsteriscoHora.setVisible(false);
        
        lblPopUpAsteriscos = new JLabel("* Campos obligatorios");
        lblPopUpAsteriscos.setBounds(122, 229, 170, 20);
        contentPane.add(lblPopUpAsteriscos);
        lblPopUpAsteriscos.setVisible(false);
        
     // Llamar al método para configurar colores
        Utiles.configurarColores(contentPane);
        Utiles.configurarColores(lblNombreReserva, lblNumComensales, lblFechaReserva, lblHoraReserva, lblListaReservas);
        Utiles.configurarColores(txtNombreReserva, txtNumComensales, txtFechaReserva, txtHoraReserva);
        
        
     // Configurar el JLabel lblPopUpAsteriscos
        Font fontPopUp = new Font("Tahoma", Font.BOLD, 14); // Puedes ajustar el tamaño de la fuente aquí
        lblPopUpAsteriscos.setFont(fontPopUp);
        lblPopUpAsteriscos.setForeground(Color.RED);
        
        ReservasModel reservasModel = new ReservasModel();
        reservasController = new ReservasController(this, reservasModel);

    }
    
    public boolean validarCampos() {
        boolean camposValidos = true;
        if (txtNombreReserva.getText().isEmpty()) {
            camposValidos = false;
            lblAsteriscoNombre.setVisible(true);
        } else {
            lblAsteriscoNombre.setVisible(false);
        }

        if (txtNumComensales.getText().isEmpty()) {
            camposValidos = false;
            lblAsteriscoComensales.setVisible(true);
        } else {
            lblAsteriscoComensales.setVisible(false);
        }

        if (txtFechaReserva.getText().isEmpty()) {
            camposValidos = false;
            lblAsteriscoFecha.setVisible(true);
            
            System.out.println(camposValidos);
        } else {
            lblAsteriscoFecha.setVisible(false);
        }

        if (txtHoraReserva.getText().isEmpty()) {
            camposValidos = false;
            lblAsteriscoHora.setVisible(true);
        } else {
            lblAsteriscoHora.setVisible(false);
        }

        return camposValidos;
    }
    
    public MenuContextual crearMenuContextual() {
        MenuContextual menuContextual = new MenuContextual();

        // Puedes agregar más elementos al menú contextual según tus necesidades

        return menuContextual;
    }
    
    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public String getNombreReserva() {
        return txtNombreReserva.getText();
    }

    public String getNumComensales() {
        return txtNumComensales.getText();
    }

    public String getFechaReserva() {
        return txtFechaReserva.getText();
    }

    public String getHoraReserva() {
        return txtHoraReserva.getText();
    }
    
    public JLabel getLblPopUpAsteriscos() {
        return lblPopUpAsteriscos;
    }
    
    public JList getListaReservas() {
        return listReservas;
    }

    public JTextField getTxtNombreReserva() {
        return txtNombreReserva;
    }

    public JTextField getTxtNumComensales() {
        return txtNumComensales;
    }

    public JTextField getTxtFechaReserva() {
        return txtFechaReserva;
    }

    public JTextField getTxtHoraReserva() {
        return txtHoraReserva;
    }
	
    
    
    
}
