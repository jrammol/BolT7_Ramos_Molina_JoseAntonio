package modelo;

public class Reserva {
	
	private String nombre;
    private String numComensales;
    private String fecha;
    private String hora;

	public Reserva() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumComensales() {
		return numComensales;
	}

	public void setNumComensales(String numComensales) {
		this.numComensales = numComensales;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	
		
	@Override
	public String toString() {
        
        return "<html><p width=\"380px\">" + "Nombre: " + nombre + ", Comensales: " + numComensales + ", Fecha: " + fecha + ", Hora: " + hora + "</p></html>";
	}
	
}
