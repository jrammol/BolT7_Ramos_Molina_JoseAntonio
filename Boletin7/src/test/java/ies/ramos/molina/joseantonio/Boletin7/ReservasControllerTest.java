package ies.ramos.molina.joseantonio.Boletin7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Reserva;
import modelo.ReservasModel;
import vista.VentanaReservas;
import controlador.ReservasController;

class ReservasControllerTest {

	private VentanaReservas ventanaReservas;
    private ReservasModel reservasModel;
    private ReservasController reservasController;

    @BeforeEach
    void setUp() {
        ventanaReservas = new VentanaReservas();
        reservasModel = new ReservasModel();
        reservasController = new ReservasController(ventanaReservas, reservasModel);
    }

    @Test
    void testConfigurarBotonGuardar() {
    	
    	// Configuración de datos válidos
        ventanaReservas.getTxtNombreReserva().setText("Nombre");
        ventanaReservas.getTxtNumComensales().setText("5");
        ventanaReservas.getTxtFechaReserva().setText("2023-01-01");
        ventanaReservas.getTxtHoraReserva().setText("18:00");

        // Llamada al método que debería ser probado
        ventanaReservas.getBtnGuardar().doClick();

        // Verificación del resultado esperado
        assertEquals(1, reservasModel.getReservas().size());
        Reserva reservaGuardada = reservasModel.getReservas().get(0);
        assertEquals("Nombre", reservaGuardada.getNombre());
        
        // Convierte la cadena a un entero antes de realizar la comparación
        assertEquals(5, Integer.parseInt(reservaGuardada.getNumComensales()));
        
        assertEquals("2023-01-01", reservaGuardada.getFecha());
        assertEquals("18:00", reservaGuardada.getHora());
    }

    @Test
    void testValidarCampos() {
        // Test validation logic when fields are empty
        ventanaReservas.getTxtNombreReserva().setText("");
        ventanaReservas.getTxtNumComensales().setText("");
        ventanaReservas.getTxtFechaReserva().setText("");
        ventanaReservas.getTxtHoraReserva().setText("");

        assertFalse(ventanaReservas.validarCampos());

        // Test validation logic when fields are filled
        ventanaReservas.getTxtNombreReserva().setText("Nombre");
        ventanaReservas.getTxtNumComensales().setText("5");
        ventanaReservas.getTxtFechaReserva().setText("2023-01-01");
        ventanaReservas.getTxtHoraReserva().setText("18:00");

        assertTrue(ventanaReservas.validarCampos());
    }
}