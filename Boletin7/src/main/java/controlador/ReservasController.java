package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import modelo.Reserva;
import modelo.ReservasModel;
import vista.MenuContextual;
import vista.VentanaReservas;

public class ReservasController {

	private VentanaReservas ventanaReservas;
	private ReservasModel reservasModel;

	public ReservasController(VentanaReservas ventanaReservas, ReservasModel reservasModel) {
		this.ventanaReservas = ventanaReservas;
		this.reservasModel = reservasModel;
		this.configurarBotonGuardar();
		this.configurarMenuContextual();
	}

	public void configurarBotonGuardar() {
		ventanaReservas.getBtnGuardar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ventanaReservas.validarCampos()) {
					// Todos los campos son válidos, puedes obtener los datos y crear un objeto
					// Reserva
					Reserva nuevaReserva = new Reserva();
					nuevaReserva.setNombre(ventanaReservas.getNombreReserva());
					nuevaReserva.setNumComensales(ventanaReservas.getNumComensales());
					nuevaReserva.setFecha(ventanaReservas.getFechaReserva());
					nuevaReserva.setHora(ventanaReservas.getHoraReserva());

					// Agregar la nueva reserva al modelo
					reservasModel.agregarReserva(nuevaReserva);

					// Actualizar la JList con las reservas actuales
					actualizarListaReservas();

					System.out.println(reservasModel.toString());

				} else {
					// Mostrar un mensaje indicando que hay campos vacíos
					JOptionPane.showMessageDialog(ventanaReservas, "Todos los campos son obligatorios", "Error",
							JOptionPane.ERROR_MESSAGE);

					// Mostrar el mensaje de campos obligatorios
					ventanaReservas.getLblPopUpAsteriscos().setVisible(true);
				}
			}
		});
	}

	private void actualizarListaReservas() {
		DefaultListModel<Reserva> model = new DefaultListModel<Reserva>();
		for (Reserva reserva : reservasModel.getReservas()) {
			model.addElement(reserva);
		}
		
		ventanaReservas.getListaReservas().setModel(model);
	}
	
	private void configurarMenuContextual() {
        final MenuContextual menuContextual = ventanaReservas.crearMenuContextual();
        
        menuContextual.setReservasController(this);

        ventanaReservas.getListaReservas().setComponentPopupMenu(menuContextual);

        // Agrega un listener para mostrar el menú contextual al hacer clic derecho        
        ventanaReservas.getContentPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    menuContextual.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }
	
	// Método para obtener la reserva seleccionada de la JList
    public Reserva obtenerReservaSeleccionada() {
        return (Reserva) ventanaReservas.getListaReservas().getSelectedValue();
    }

    // Método para eliminar una reserva del modelo
    public void eliminarReserva(Reserva reserva) {
        if (reserva != null) {
            reservasModel.eliminarReserva(reserva);
            actualizarListaReservas();
        }
    }
	
	// Método para limpiar los campos
    public void limpiarCampos() {
        ventanaReservas.getTxtNombreReserva().setText("");
        ventanaReservas.getTxtNumComensales().setText("");
        ventanaReservas.getTxtFechaReserva().setText("");
        ventanaReservas.getTxtHoraReserva().setText("");
    }
	
	

}
