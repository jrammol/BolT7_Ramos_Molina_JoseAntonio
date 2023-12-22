package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import controlador.ReservasController;
import modelo.Reserva;

public class MenuContextual extends JPopupMenu {
	
	private ReservasController reservasController;
	private VentanaReservas ventanaReservas;
	
	public void setReservasController(ReservasController reservasController) {
        this.reservasController = reservasController;
    }

    public MenuContextual() {
        JMenuItem eliminarItem = new JMenuItem("Eliminar Reserva");
        eliminarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtén la reserva seleccionada de la JList
			    Reserva reservaSeleccionada = reservasController.obtenerReservaSeleccionada();

			    // Verifica si hay una reserva seleccionada
			    if (reservaSeleccionada != null) {
			        // Elimina la reserva del modelo y actualiza la lista
			        reservasController.eliminarReserva(reservaSeleccionada);
			    }else {
			    	// Muestra un mensaje indicando que no hay reserva seleccionada
			    	JOptionPane.showMessageDialog(ventanaReservas, "Por favor, selecciona una reserva para eliminar",
			                "Advertencia", JOptionPane.WARNING_MESSAGE);
			    }
				
			}
		});
        add(eliminarItem);
        
        JMenuItem limpiarCamposItem = new JMenuItem("Limpiar Campos");
        limpiarCamposItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    limpiarCampos();
			}
		});
        add(limpiarCamposItem);
    }
    
    private void limpiarCampos() {
        // Accede al controlador para limpiar los campos
        if (reservasController != null) {
            reservasController.limpiarCampos();
        }
    }
}