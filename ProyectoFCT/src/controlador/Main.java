package controlador;

import conexion.ConexionSQL;
import modelo.Modelo;
import vista.LoginWindow;

public class Main {
	static ConexionSQL conexionSQL;

	public static void main(String[] args) throws ClassNotFoundException {
		Modelo modelo = new Modelo();
		conexionSQL = new ConexionSQL(modelo);
		LoginWindow loginView = new LoginWindow(); 
		LoginController loginController = new LoginController(loginView, conexionSQL ,modelo);
		loginView.getLoginButton().addActionListener(loginController);
	}

}