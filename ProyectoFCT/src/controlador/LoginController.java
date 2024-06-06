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
	public Modelo modelo;
	UsuarioEntity usuario;

	public LoginController(LoginWindow loginView, ConexionSQL conexionSQL, Modelo modelo) {
		this.loginView = loginView;
		this.conexionSQL = conexionSQL;
		this.modelo = modelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginView.getLoginButton()) {
			modelo.setIdActiveUser(conexionSQL.obtenerIdUsuarioPorNombre(loginView.getUserTextField().getText()));
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
						HomeWindow homeView = new HomeWindow(conexionSQL, modelo); 
						
						HomeController HomeController = new HomeController(homeView, conexionSQL ,modelo);
						
						usuario = conexionSQL.obtenerUsuarioPorId(modelo.getIdActiveUser());
						if (usuario.getRol().equals("admin")) {
							homeView.getMntmGestionUsuarios().addActionListener(HomeController);
							homeView.getMntmGestionVehiculos().addActionListener(HomeController);
							homeView.getMntmAsignaciones().addActionListener(HomeController);
							homeView.getMntmMantenimientos().addActionListener(HomeController);
							homeView.getMenuButtonUsuarios().addActionListener(HomeController);
							homeView.getMenuButtonVehiculos().addActionListener(HomeController);
							homeView.getMenuButtonAsignaciones().addActionListener(HomeController);
							homeView.getMenuButtonMantenimientos().addActionListener(HomeController);
						} else {
							homeView.getMenuButtonUserM().addActionListener(HomeController);
							homeView.getMntmUserM().addActionListener(HomeController);
						}
						
						homeView.getMntmSalir().addActionListener(HomeController);
						
						homeView.getMenuButtonSalir().addActionListener(HomeController);
						
						//homeView.getMenuButtonInicio().addActionListener(HomeController);
						
						homeView.displayUserInfo();
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
