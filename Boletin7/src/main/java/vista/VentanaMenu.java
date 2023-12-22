package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import controlador.MenuController;
import modelo.MenuModel;
import utiles.Utiles;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class VentanaMenu extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem mntmPlatos, mntmBebidas, mntmReservas, mntmAlmacen, mntmEmpleados, mntmProveedores, mntmClientes, 
					  mntmFacturacion, mntmGastos, mntmImpuestos;
	private JPopupMenu popupMenuPlatos;
    private JPopupMenu popupMenuBebidas;
    private JMenu mnGestion, mnRestaurante, mnFinanzas; 
    private MenuController menuController;
    
	

	/**
	 * Create the frame.
	 */
	public VentanaMenu() {
		
		
		
		setTitle("Menú Lars Peeters Restaurant");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(VentanaMenu.class.getResource("/fotos/logoC.png")));
		lblLogo.setBounds(100, 75, 300, 300);
		contentPane.add(lblLogo);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 484, 22);
		contentPane.add(menuBar);
		
		mnRestaurante = new JMenu("Restaurante");
		menuBar.add(mnRestaurante);
		
		mntmPlatos = new JMenuItem("Platos");
		mnRestaurante.add(mntmPlatos);
		mntmPlatos.setToolTipText("Información sobre Platos");
		
		mntmBebidas = new JMenuItem("Bebidas");
		mnRestaurante.add(mntmBebidas);
		mntmBebidas.setToolTipText("Información sobre Bebidas");
		
		mntmReservas = new JMenuItem("Reservas");
		mnRestaurante.add(mntmReservas);
		mntmReservas.setToolTipText("Información sobre Reservas");
		// Añadir atajo de teclado Ctrl+2 a mntmReservas
        mntmReservas.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_DOWN_MASK));
		
		mnGestion = new JMenu("Gestión");
		menuBar.add(mnGestion);
		
		mntmAlmacen = new JMenuItem("Almacén");
		mnGestion.add(mntmAlmacen);
		mntmAlmacen.setToolTipText("Información sobre Almacén");
		
		mntmEmpleados = new JMenuItem("Empleados");
		mnGestion.add(mntmEmpleados);
		mntmEmpleados.setToolTipText("Información sobre Empleados");
		
		mntmProveedores = new JMenuItem("Proveedores");
		mnGestion.add(mntmProveedores);
		mntmProveedores.setToolTipText("Información sobre Proveedores");
		
		mntmClientes = new JMenuItem("Clientes");
		mnGestion.add(mntmClientes);
		mntmClientes.setToolTipText("Información sobre Clientes");
		
		mnFinanzas = new JMenu("Finanzas");
		menuBar.add(mnFinanzas);
		
		mntmFacturacion = new JMenuItem("Facturación");
		mnFinanzas.add(mntmFacturacion);
		mntmFacturacion.setToolTipText("Información sobre Facturación");
		
		mntmGastos = new JMenuItem("Gastos");
		mnFinanzas.add(mntmGastos);
		mntmGastos.setToolTipText("Información sobre Gastos");
		
		mntmImpuestos = new JMenuItem("Impuestos");
		mnFinanzas.add(mntmImpuestos);
		mntmImpuestos.setToolTipText("Información sobre Impuestos");
		
		
		// Configurar colores personalizados utilizando la clase Utiles
        Utiles.configurarColores(contentPane, menuBar, mnRestaurante, mnGestion, mnFinanzas);
        Utiles.configurarColores(mntmPlatos, mntmBebidas, mntmReservas, mntmAlmacen, mntmEmpleados,
                                 mntmProveedores, mntmClientes, mntmFacturacion, mntmGastos, mntmImpuestos);
        
        MenuModel menuModel = new MenuModel();
        menuController = new MenuController(this, menuModel);

	}
	
	public JMenuItem getMntmReservas() {
        return mntmReservas;
    }
	
	
	
	
}
