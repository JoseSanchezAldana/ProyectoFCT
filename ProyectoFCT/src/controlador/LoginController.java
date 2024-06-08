package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import conexion.ConexionSQL;
import modelo.Modelo;
import modelo.UsuarioEntity;
import modelo.VehiculoEntity;
import vista.HomeWindow;
import vista.LoginWindow;

/**
 * El controlador LoginController gestiona las interacciones del usuario en la ventana de inicio de sesión.
 * Verifica las credenciales del usuario y, si son correctas, muestra la ventana principal de la aplicación.
 */
public class LoginController implements ActionListener {
	private LoginWindow loginView;
	private ConexionSQL conexionSQL;
	public Modelo modelo;
	UsuarioEntity usuario;

	/**
     * Constructor para el controlador LoginController.
     * @param loginView La ventana de inicio de sesión.
     * @param conexionSQL El objeto de conexión a la base de datos.
     * @param modelo El modelo de datos utilizado en la aplicación.
     */
	public LoginController(LoginWindow loginView, ConexionSQL conexionSQL, Modelo modelo) {
		this.loginView = loginView;
		this.conexionSQL = conexionSQL;
		this.modelo = modelo;
	}

	/**
     * Método que gestiona las acciones del usuario en la ventana de inicio de sesión.
     * Verifica las credenciales ingresadas por el usuario y muestra la ventana principal si son correctas.
     * @param e El evento que desencadena la acción.
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		SecurityUtilities security = new SecurityUtilities();
		if (e.getSource() == loginView.getLoginButton()) {
			modelo.setIdActiveUser(conexionSQL.obtenerIdUsuarioPorNombre(loginView.getUserTextField().getText()));
			try {
				conexionSQL.query("SELECT nombre, password FROM usuarios WHERE nombre = '"
						+ loginView.getUserTextField().getText() + "';");
				if (conexionSQL.getRs().next()) {
					System.out.println("Usuario introducido: " + loginView.getUserTextField().getText()
							+ " || Usuario bd: " + conexionSQL.getRs().getString(1));
					System.out.println("Contraseña introducida: " + loginView.getPasswordField().getText()
							+ " || Contraseña bd: " + conexionSQL.getRs().getString(2));
					if (conexionSQL.getRs().getString(1).equals(loginView.getUserTextField().getText())
							&& conexionSQL.getRs().getString(2).equals(security.encrypt(loginView.getPasswordField().getText(), modelo.getKey()))) {
						System.out.println("Login correcto");
						loginView.getFrame().dispose();
						HomeWindow homeView = new HomeWindow(conexionSQL, modelo);

						HomeController HomeController = new HomeController(homeView, conexionSQL, modelo);

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
