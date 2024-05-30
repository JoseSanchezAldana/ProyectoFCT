package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import conexion.ConexionSQL;
import modelo.Modelo;
import vista.HomeWindow;

public class HomeController implements ActionListener {

	private ConexionSQL conexionSQL;
	private HomeWindow homeView;
	private Modelo modelo;

	public HomeController(HomeWindow homeView, ConexionSQL conexionSQL, Modelo modelo) {
		this.homeView = homeView;
		this.conexionSQL = conexionSQL;
		this.modelo = modelo;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Gestión de vehículos") {
			System.out.println("MENU VEHICULOS");
		} else if (e.getActionCommand() == "Gestión de usuarios") {
			System.out.println("MENU USUARIOS");
		} else if (e.getActionCommand() == "Configuración") {
			System.out.println("Configuración seleccionada");
		}
	}
}
