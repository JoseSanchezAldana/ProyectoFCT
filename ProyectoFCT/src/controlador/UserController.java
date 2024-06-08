package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import conexion.ConexionSQL;
import modelo.Modelo;
import modelo.UsuarioEntity;
import modelo.VehiculoEntity;
import vista.CreateUserWindow;
import vista.CreateVehicleWindow;
import vista.ModifyUserWindow;
import vista.ModifyVehicleWindow;
import vista.UserManagementWindow;
import vista.VehicleManagementWindow;

/**
 * La clase UserController gestiona las interacciones entre la ventana de gestión de usuarios y la base de datos.
 */
public class UserController implements ActionListener {
	private UserManagementWindow userManagementWindow;
	private ConexionSQL conexionSQL;
	private Modelo modelo;

	/**
     * Constructor de la clase UserController.
     * @param userManagementWindow La ventana de gestión de usuarios.
     * @param conexionSQL La conexión a la base de datos.
     * @param modelo El modelo de la aplicación.
     */
	public UserController(UserManagementWindow userManagementWindow, ConexionSQL conexionSQL, Modelo modelo) {
		this.userManagementWindow = userManagementWindow;
		this.conexionSQL = conexionSQL;
		this.modelo = modelo;

		this.userManagementWindow.getDeleteButton().addActionListener(this);
		this.userManagementWindow.getCreateButton().addActionListener(this);
		this.userManagementWindow.getModifyButton().addActionListener(this);
	}

	/**
     * Carga la lista de usuarios en la ventana de gestión de usuarios.
     */
	public void loadUsuarios() {
		userManagementWindow.getUserListModel().clear();
		List<UsuarioEntity> usuarios = conexionSQL.obtenerUsuarios();
		for (UsuarioEntity usuario : usuarios) {
			userManagementWindow.getUserListModel()
					.addElement("ID: " + usuario.getIdUsuario() + "   ||   Nombre: " + usuario.getNombre()
							+ "   ||   Email: " + usuario.getEmail() + "   ||   Rol: " + usuario.getRol());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == userManagementWindow.getDeleteButton()) {
			int idUsuario = userManagementWindow.getSelectedUserId();
			if (idUsuario != -1) {
				int response = JOptionPane.showConfirmDialog(userManagementWindow.getFrame(),
						"¿Estás seguro de que deseas eliminar este usuario?", "Confirmación de eliminación",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (response == JOptionPane.YES_OPTION) {
					conexionSQL.eliminarUsuario(idUsuario);
					loadUsuarios();
				} else {
					JOptionPane.showMessageDialog(userManagementWindow.getFrame(),
							"No se ha seleccionado ningún usuario para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (e.getSource() == userManagementWindow.getCreateButton()) {
			SecurityUtilities security = new SecurityUtilities();
			CreateUserWindow createUserWindow = new CreateUserWindow();
			createUserWindow.getCancelButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					createUserWindow.dispose();
				}
			});
			createUserWindow.getCreateButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String nombre = createUserWindow.getNombreField().getText();
			        String email = createUserWindow.getEmailField().getText();
			        String password = security.encrypt(createUserWindow.getPasswordField().getText(), modelo.getKey());
			        String rol = createUserWindow.getRolComboBox().getSelectedItem().toString();

			        UsuarioEntity usuario = new UsuarioEntity(0, nombre, email, password, rol);
					conexionSQL.crearUsuario(usuario);
					createUserWindow.dispose();
					loadUsuarios();
				}
			});
			createUserWindow.setVisible(true);
		} else if (e.getSource() == userManagementWindow.getModifyButton()) {
			SecurityUtilities security = new SecurityUtilities();
			int idUsuario = userManagementWindow.getSelectedUserId();
			if (idUsuario != -1) {
				UsuarioEntity usuario = conexionSQL.obtenerUsuarioPorId(idUsuario);
				if (usuario != null) {
					ModifyUserWindow modifyUserWindow = new ModifyUserWindow(usuario.getNombre(),
							usuario.getEmail(), security.decrypt(usuario.getPassword(), modelo.getKey()), usuario.getRol());
					modifyUserWindow.setVisible(true);
					modifyUserWindow.getModifyButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String nombre = modifyUserWindow.getNombreField().getText();
					        String email = modifyUserWindow.getEmailField().getText();
					        String password = security.encrypt(modifyUserWindow.getPasswordField().getText(), modelo.getKey());
					        String rol = modifyUserWindow.getRolComboBox().getSelectedItem().toString();

					        UsuarioEntity usuario = new UsuarioEntity(idUsuario, nombre, email, password, rol);
							if (conexionSQL.modificarUsuario(usuario)) {
								modifyUserWindow.dispose();
								loadUsuarios();
							}
						}
					});
					modifyUserWindow.getCancelButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							modifyUserWindow.dispose();
						}
					});
				}
			} else {
				JOptionPane.showMessageDialog(userManagementWindow.getFrame(),
						"No se ha seleccionado ningún vehículo para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
