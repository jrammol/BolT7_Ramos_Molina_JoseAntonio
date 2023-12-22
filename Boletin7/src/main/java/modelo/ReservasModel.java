package modelo;

import java.util.ArrayList;

public class ReservasModel {

	private ArrayList<Reserva> reservas;

	public ReservasModel() {
		reservas = new ArrayList<Reserva>();
	}

	//Método para agregar una reserva
	public void agregarReserva(Reserva reserva) {
		reservas.add(reserva);
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	// Método para eliminar una reserva
	public void eliminarReserva(Reserva reserva) {
		reservas.remove(reserva);
	}

	@Override
	public String toString() {
		return "ReservasModel [reservas=" + reservas + "]";
	}

}
