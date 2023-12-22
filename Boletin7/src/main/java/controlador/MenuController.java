package controlador;

import vista.VentanaMenu;
import vista.VentanaReservas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.MenuModel;

public class MenuController {

    private VentanaMenu ventanaMenu;
    private MenuModel menuModel;
    

    public MenuController(VentanaMenu ventanaMenu, MenuModel menuModel) {
        this.ventanaMenu = ventanaMenu;
        this.menuModel = menuModel;
        this.configurarVentana();
    }

    private void configurarVentana() {
        ventanaMenu.setDefaultCloseOperation(VentanaMenu.DO_NOTHING_ON_CLOSE);
        ventanaMenu.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                confirmarSalida();
            }
        });
        
     // Manejar la acción del elemento mntmReservas
        ventanaMenu.getMntmReservas().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirVistaReservas();
            }
        });
    }

    private void confirmarSalida() {
        int opcion = JOptionPane.showConfirmDialog(ventanaMenu, "¿Desea salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    private void abrirVistaReservas() {
        // Crear y mostrar la ventana FormularioReservas
       VentanaReservas formularioReservas = new VentanaReservas();
        formularioReservas.setVisible(true);
        
        
    }
    
 
}

