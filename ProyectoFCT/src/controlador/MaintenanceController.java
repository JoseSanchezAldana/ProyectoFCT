package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import conexion.ConexionSQL;
import modelo.AsignacionesEntity;
import modelo.MantenimientoEntity;
import vista.CreateAssignmentsWindow;
import vista.CreateMaintenanceWindow;
import vista.MaintenanceManagementWindow;

/**
 * El controlador MaintenanceController gestiona las acciones relacionadas con la administración de mantenimientos.
 * Controla la creación, modificación y eliminación de mantenimientos, así como la carga inicial de la lista de mantenimientos.
 */
public class MaintenanceController implements ActionListener {
	private MaintenanceManagementWindow maintenanceWindow;
	private ConexionSQL conexionSQL;

	/**
     * Constructor de MaintenanceController.
     * @param maintenanceWindow La ventana de gestión de mantenimientos.
     * @param conexionSQL El objeto de conexión a la base de datos.
     */
	public MaintenanceController(MaintenanceManagementWindow maintenanceWindow, ConexionSQL conexionSQL) {
		this.maintenanceWindow = maintenanceWindow;
		this.conexionSQL = conexionSQL;

		this.maintenanceWindow.getCreateButton().addActionListener(this);
		this.maintenanceWindow.getModifyButton().addActionListener(this);
	}

	/**
     * Carga inicial de los mantenimientos desde la base de datos y los muestra en la ventana de gestión de mantenimientos.
     */
	public void loadMaintenance() {
		List<MantenimientoEntity> mantenimientos = conexionSQL.obtenerMantenimientos();
		for (MantenimientoEntity mantenimiento : mantenimientos) {
			maintenanceWindow.getMaintenanceListModel()
					.addElement("ID: " + mantenimiento.getIdMantenimiento() + "   ||   Vehiculo: "
							+ conexionSQL.obtenerVehiculoPorId(mantenimiento.getIdVehiculo()) .getMatricula() + "   ||   Tipo de mantenimiento: "
							+ mantenimiento.getTipoMantenimiento() + "   ||   Fecha del mantenimiento: "
							+ mantenimiento.getFechaProgramada());
		}
	}

	/**
     * Valida el formato de la fecha según el formato yyyy-MM-dd.
     * @param fecha La fecha a validar.
     * @return true si la fecha tiene el formato correcto, false de lo contrario.
     */
	public boolean validarFormatoFecha(String fecha) {
		String formatoFechaRegex = "\\d{4}-\\d{2}-\\d{2}";
		Pattern pattern = Pattern.compile(formatoFechaRegex);
		Matcher matcher = pattern.matcher(fecha);
		return matcher.matches();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == maintenanceWindow.getDeleteButton()) {
			int idMantenimiento = maintenanceWindow.getSelectedMaintenanceId();
			if (idMantenimiento != -1) {
				int response = JOptionPane.showConfirmDialog(maintenanceWindow.getFrame(),
						"¿Estás seguro de que deseas eliminar este mantenimiento?", "Confirmación de eliminación",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (response == JOptionPane.YES_OPTION) {
					conexionSQL.eliminarMantenimiento(idMantenimiento);
					maintenanceWindow.getMaintenanceListModel().removeAllElements();
					loadMaintenance();
				} else {
					JOptionPane.showMessageDialog(maintenanceWindow.getFrame(),
							"No se ha seleccionado ningun mantenimiento para eliminar.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (e.getSource() == maintenanceWindow.getCreateButton()) {
			CreateMaintenanceWindow createMaintenanceWindow = new CreateMaintenanceWindow();
			String[] vehiculos = conexionSQL.obtenerMatriculasVehiculos();
			for (String vehiculo : vehiculos) {
				createMaintenanceWindow.getVehiculoComboBox().addItem(vehiculo);
			}
			createMaintenanceWindow.getCancelButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					createMaintenanceWindow.dispose();
				}
			});
			createMaintenanceWindow.getAssignButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int idVehiculo = conexionSQL.obtenerIdVehiculoPorMatricula(
							createMaintenanceWindow.getVehiculoComboBox().getSelectedItem().toString());
					String tipoMantenimiento = createMaintenanceWindow.getTipoField().getText();
					String fechaMantenimiento = createMaintenanceWindow.getFechaField().getText();

					if (!validarFormatoFecha(fechaMantenimiento)) {
						JOptionPane.showMessageDialog(createMaintenanceWindow,
								"El formato de la fecha de mantenimiento no es válido. Debe seguir el formato yyyy-MM-dd.",
								"Error de formato de fecha", JOptionPane.ERROR_MESSAGE);
						return;
					}
					MantenimientoEntity mantenimiento = new MantenimientoEntity(0, idVehiculo, tipoMantenimiento, fechaMantenimiento);
					conexionSQL.crearMantenimiento(mantenimiento);
					createMaintenanceWindow.dispose();
					maintenanceWindow.getMaintenanceListModel().removeAllElements();
					loadMaintenance();
				}
			});
		} else if (e.getSource() == maintenanceWindow.getModifyButton()) {
			int IdMantenimiento = maintenanceWindow.getSelectedMaintenanceId();
			if (IdMantenimiento != -1) {
				MantenimientoEntity mantenimiento = conexionSQL.obtenerMantenimientoPorId(IdMantenimiento);
				if (mantenimiento != null) {
					CreateMaintenanceWindow createMaintenanceWindow = new CreateMaintenanceWindow();
					String[] vehiculos = conexionSQL.obtenerMatriculasVehiculos();
					for (String vehiculo : vehiculos) {
						createMaintenanceWindow.getVehiculoComboBox().addItem(vehiculo);
		            }
					createMaintenanceWindow.setVisible(true);
					createMaintenanceWindow.getAssignButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							int idVehiculo = conexionSQL.obtenerIdVehiculoPorMatricula(createMaintenanceWindow.getVehiculoComboBox().getSelectedItem().toString());
							String tipoMantenimiento = createMaintenanceWindow.getTipoField().getText();
					        String fechaMantenimiento = createMaintenanceWindow.getFechaField().getText();

					        if (!validarFormatoFecha(fechaMantenimiento)) {
			                    JOptionPane.showMessageDialog(createMaintenanceWindow,
			                            "El formato de la fecha deL mantenimiento no es válido. Debe seguir el formato yyyy-MM-dd.",
			                            "Error de formato de fecha", JOptionPane.ERROR_MESSAGE);
			                    return;
					        }
					        MantenimientoEntity mantenimiento = new MantenimientoEntity(IdMantenimiento, idVehiculo, tipoMantenimiento, fechaMantenimiento);
							conexionSQL.modificarMantenimiento(mantenimiento);
							createMaintenanceWindow.dispose();
							maintenanceWindow.getMaintenanceListModel().removeAllElements();;
							loadMaintenance();
						}
					});
					createMaintenanceWindow.getCancelButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							createMaintenanceWindow.dispose();
						}
					});
				}
			} else {
				JOptionPane.showMessageDialog(maintenanceWindow.getFrame(),
						"No se ha seleccionado ningún mantenimiento para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
