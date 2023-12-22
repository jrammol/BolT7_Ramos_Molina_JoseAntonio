package ies.ramos.molina.joseantonio.Boletin7;

import static org.mockito.Mockito.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import controlador.MenuController;
import controlador.ReservasController;
import modelo.MenuModel;
import modelo.Reserva;
import modelo.ReservasModel;
import vista.VentanaMenu;
import vista.VentanaReservas;

class MenuControllerTest {

    @Test
    void testAbrirVistaReservasConAtajoDeTeclado() {
        // Crear mock para VentanaMenu
        VentanaMenu ventanaMenuMock = mock(VentanaMenu.class);

        JMenuItem mntmReservasMock = mock(JMenuItem.class);
        when(ventanaMenuMock.getMntmReservas()).thenReturn(mntmReservasMock);

        // Crear mock para VentanaReservas
        VentanaReservas ventanaReservasMock = mock(VentanaReservas.class);
        
        // Crear mock para ReservasModel
        ReservasModel reservasModelMock = mock(ReservasModel.class) ;

        // Crear mock para MenuModel (si es necesario)
        MenuModel menuModelMock = mock(MenuModel.class);

        // Crear una instancia de MenuController con el mock de VentanaReservas
        MenuController menuController = new MenuController(ventanaMenuMock, menuModelMock);
        ReservasController reservasController = new ReservasController(ventanaReservasMock, reservasModelMock);

        // Simular la acción de hacer clic en mntmReservas
        ventanaMenuMock.getMntmReservas().doClick();

        // Verificar que la VentanaReservas fue creada y configurada correctamente
        verify(ventanaReservasMock, times(1)).setVisible(true);
        verify(ventanaReservasMock).setTitle("Título esperado"); // Ajusta esto según la configuración real de tu VentanaReservas
        // Agrega más verificaciones según sea necesario

        // Simular el evento de teclado Alt+2 en la ventana de menú
        ArgumentCaptor<KeyListener> keyListenerCaptor = ArgumentCaptor.forClass(KeyListener.class);
        verify(ventanaMenuMock).addKeyListener(keyListenerCaptor.capture());

        KeyListener keyListener = keyListenerCaptor.getValue();
        keyListener.keyPressed(new KeyEvent(ventanaMenuMock, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_2, '2'));

        // Verificar que la VentanaReservas fue abierta nuevamente por el atajo de teclado
        verify(ventanaReservasMock, times(2)).setVisible(true);
    }
}
