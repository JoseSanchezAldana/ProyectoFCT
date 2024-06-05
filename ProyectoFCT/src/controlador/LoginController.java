package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionSQL;
import modelo.Modelo;
import modelo.UsuarioEntity;
import modelo.VehiculoEntity;
import vista.HomeWindow;
import vista.LoginWindow;

public class LoginController implements ActionListener {

	private LoginWindow loginView;
	private ConexionSQL conexionSQL;
	private Modelo modelo;

	public LoginController(LoginWindow loginView, ConexionSQL conexionSQL, Modelo modelo) {
		this.loginView = loginView;
		this.conexionSQL = conexionSQL;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginView.getLoginButton()) {
			try { 
				conexionSQL.query("SELECT nombre, password FROM usuarios WHERE nombre = '"
						+ loginView.getUserTextField().getText() + "';");
				if (conexionSQL.getRs().next()) { 
					System.out.println("Usuario introducido: " + loginView.getUserTextField().getText() + " || Usuario bd: " + conexionSQL.getRs().getString(1));
					System.out.println("Contraseña introducida: " + loginView.getPasswordField().getText() + " || Contraseña bd: " + conexionSQL.getRs().getString(2));
					if (conexionSQL.getRs().getString(1).equals(loginView.getUserTextField().getText())
							&& conexionSQL.getRs().getString(2).equals(loginView.getPasswordField().getText())) {
						System.out.println("Login correcto");
						loginView.getFrame().dispose();
						HomeWindow homeView = new HomeWindow(); 
						HomeController HomeController = new HomeController(homeView, conexionSQL ,modelo);
						homeView.getMntmGestionUsuarios().addActionListener(HomeController);
						homeView.getMntmGestionVehiculos().addActionListener(HomeController);
						homeView.getMntmAsignaciones().addActionListener(HomeController);
						homeView.getMntmMantenimientos().addActionListener(HomeController);
						
						homeView.getMenuButtonUsuarios().addActionListener(HomeController);
						homeView.getMenuButtonInicio().addActionListener(HomeController);
						homeView.getMenuButtonVehiculos().addActionListener(HomeController);
						homeView.getMenuButtonAsignaciones().addActionListener(HomeController);
						homeView.getMenuButtonMantenimientos().addActionListener(HomeController);
						
						VehiculoEntity vehiculo = new VehiculoEntity(1 , "Toyota", "Corolla", "ABC1234", 2018);
						UsuarioEntity usuario = new UsuarioEntity(1, "Juan Pérez", "juan.perez@example.com", "1234", "Admin");
						homeView.displayUserInfo(usuario);
					} else {
						System.out.println("Login incorrecto");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

}
