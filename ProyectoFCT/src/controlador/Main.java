package controlador;

import conexion.ConexionSQL;
import modelo.Modelo;
import vista.LoginWindow;

/**
 * La clase Main es la entrada principal del programa. Inicializa la conexión a
 * la base de datos, crea la ventana de inicio de sesión y establece el
 * controlador para gestionar las acciones del usuario.
 */
public class Main {
	static ConexionSQL conexionSQL;

	/**
	 * Método principal que se ejecuta al iniciar la aplicación.
	 * 
	 * @param args Los argumentos de línea de comandos (no se utilizan).
	 * @throws ClassNotFoundException Si no se puede cargar el controlador JDBC.
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Modelo modelo = new Modelo();
		conexionSQL = new ConexionSQL(modelo.getDireccionBd(), modelo.getUsuarioBd(), modelo.getPasswordBd());
		LoginWindow loginView = new LoginWindow();
		LoginController loginController = new LoginController(loginView, conexionSQL, modelo);
		loginView.getLoginButton().addActionListener(loginController);
	}
}