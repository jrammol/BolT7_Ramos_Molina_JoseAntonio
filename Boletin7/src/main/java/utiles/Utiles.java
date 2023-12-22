package utiles;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Utiles {

	public static void configurarColores(JPanel panel, JMenuBar menuBar, JMenu... menus) {

		// Color del fondo del JPanel
		Color colorPanel = Color.decode("#F2ECFF");
		panel.setBackground(colorPanel);

		// Color del fondo del JMenuBar
		Color colorMenuBar = Color.decode("#F2ECFF");
		menuBar.setBackground(colorMenuBar);

		for (JMenu menu : menus) {
			// Color de fondo de los JMenu
			Color colorMenu = Color.decode("#C6C6C6");
			menu.setBackground(colorMenu);

			// Configurar color de la fuente para JMenu
			Font fontMenu = new Font("Tahoma", Font.BOLD, 16);
			menu.setFont(fontMenu);
			menu.setForeground(Color.decode("#005A34"));
		}
	}
	

	public static void configurarColores(JPanel panel) {

		// Color del fondo del JPanel
		Color colorPanel = Color.decode("#F2ECFF");
		panel.setBackground(colorPanel);
	}
	

	public static void configurarColores(JLabel... jLabel) {

		for (JLabel label : jLabel) {

			// Configurar color de fondo y fuente para JLabel
			Color colorLabel = Color.decode("#C6C6C6");
			label.setBackground(colorLabel);

			Font fontLabel = new Font("Tahoma", Font.BOLD, 12);
			label.setFont(fontLabel);
			label.setForeground(Color.decode("#005A34"));
		}
	}
	
	public static void configurarColores(JTextField...jTextFields) {

		for (JTextField field : jTextFields) {

			// Configurar color de fondo y fuente para JLabel
			Color colorfield = Color.decode("#C6C6C6");
			field.setBackground(colorfield);

			Font fontLabel = new Font("Tahoma", Font.BOLD, 16);
			field.setFont(fontLabel);
			field.setForeground(Color.decode("#005A34"));
		}
	}

	public static void configurarColores(JMenuItem... menuItems) {
		// Color de fondo de los JMenuItem
		Color colorMenuItem = Color.decode("#889FA5");
		for (JMenuItem menuItem : menuItems) {
			menuItem.setBackground(colorMenuItem);

			// Configurar color de texto y fuente
			Font fontMenuItem = new Font("Tahoma", Font.PLAIN, 12);
			menuItem.setFont(fontMenuItem);
			menuItem.setForeground(Color.decode("#005A34"));
		}
	}

}
