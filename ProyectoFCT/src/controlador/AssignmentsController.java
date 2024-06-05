package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import conexion.ConexionSQL;
import modelo.AsignacionesEntity;
import modelo.VehiculoEntity;
import vista.AssignmentsManagementWindow;
import vista.CreateAssignmentsWindow;
import vista.ModifyVehicleWindow;

public class AssignmentsController implements ActionListener {
	private AssignmentsManagementWindow assignmentsWindow;
	private ConexionSQL conexionSQL;

	public AssignmentsController(AssignmentsManagementWindow assignmentsWindow, ConexionSQL conexionSQL) {
		this.assignmentsWindow = assignmentsWindow;
		this.conexionSQL = conexionSQL;

		this.assignmentsWindow.getCreateButton().addActionListener(this);
		this.assignmentsWindow.getModifyButton().addActionListener(this);
	}

	public void loadAssignments() {
		List<AsignacionesEntity> asignaciones = conexionSQL.obtenerAsignaciones();
		for (AsignacionesEntity asignacion : asignaciones) {
			assignmentsWindow.getAssignmentsListModel()
					.addElement("ID: " + asignacion.getIdAsignacion() + "   ||   Vehiculo: "
							+ asignacion.getIdVehiculo() + "   ||   Conductor: " + asignacion.getIdConductor()
							+ "   ||   Fecha de asignación: " + asignacion.getFechaAsignacion());
		}
	}
	
	public boolean validarFormatoFecha(String fecha) {
        String formatoFechaRegex = "\\d{4}-\\d{2}-\\d{2}";
        Pattern pattern = Pattern.compile(formatoFechaRegex);
        Matcher matcher = pattern.matcher(fecha);
        return matcher.matches();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == assignmentsWindow.getDeleteButton()) {
			int idAsignacion = assignmentsWindow.getSelectedAssignmentsId();
			if (idAsignacion != -1) {
				int response = JOptionPane.showConfirmDialog(assignmentsWindow.getFrame(),
						"¿Estás seguro de que deseas eliminar esta asignación?", "Confirmación de eliminación",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (response == JOptionPane.YES_OPTION) {
					conexionSQL.eliminarAsignacion(idAsignacion);
					assignmentsWindow.getAssignmentsListModel().removeAllElements();
					loadAssignments();
				} else {
					JOptionPane.showMessageDialog(assignmentsWindow.getFrame(),
							"No se ha seleccionado ninguna asignación para eliminar.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (e.getSource() == assignmentsWindow.getCreateButton()) {
			CreateAssignmentsWindow createAssignmentsWindow = new CreateAssignmentsWindow();
			String[] vehiculos = conexionSQL.obtenerMatriculasVehiculos();
			for (String vehiculo : vehiculos) {
				createAssignmentsWindow.getVehiculoComboBox().addItem(vehiculo);
            }
			String[] conductores = conexionSQL.obtenerEmailUsuarios();
			for (String conductor : conductores) {
				createAssignmentsWindow.getConductorComboBox().addItem(conductor);
            }
			createAssignmentsWindow.getCancelButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					createAssignmentsWindow.dispose();
				}
			});
			createAssignmentsWindow.getAssignButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
			        int idVehiculo = conexionSQL.obtenerIdVehiculoPorMatricula(createAssignmentsWindow.getVehiculoComboBox().getSelectedItem().toString());
			        int idConductor = conexionSQL.obtenerIdUsuarioPorEmail(createAssignmentsWindow.getConductorComboBox().getSelectedItem().toString());
			        String fechaAsignacion = createAssignmentsWindow.getFechaField().getText();

			        if (!validarFormatoFecha(fechaAsignacion)) {
	                    JOptionPane.showMessageDialog(createAssignmentsWindow,
	                            "El formato de la fecha de asignación no es válido. Debe seguir el formato yyyy-MM-dd.",
	                            "Error de formato de fecha", JOptionPane.ERROR_MESSAGE);
	                    return;
			        }
			        AsignacionesEntity asignacion = new AsignacionesEntity(0, idVehiculo, idConductor, fechaAsignacion);
					conexionSQL.crearAsignacion(asignacion);
					createAssignmentsWindow.dispose();
					assignmentsWindow.getAssignmentsListModel().removeAllElements();
					loadAssignments();
				}
			});
		} else if (e.getSource() == assignmentsWindow.getModifyButton()) {
			int idAsignacion = assignmentsWindow.getSelectedAssignmentsId();
			if (idAsignacion != -1) {
				AsignacionesEntity asignacion = conexionSQL.obtenerAsignacionPorId(idAsignacion);
				if (asignacion != null) {
					CreateAssignmentsWindow createAssignmentsWindow = new CreateAssignmentsWindow();
					String[] vehiculos = conexionSQL.obtenerMatriculasVehiculos();
					for (String vehiculo : vehiculos) {
						createAssignmentsWindow.getVehiculoComboBox().addItem(vehiculo);
		            }
					String[] conductores = conexionSQL.obtenerEmailUsuarios();
					for (String conductor : conductores) {
						createAssignmentsWindow.getConductorComboBox().addItem(conductor);
		            }
					createAssignmentsWindow.setVisible(true);
					createAssignmentsWindow.getAssignButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							int idVehiculo = conexionSQL.obtenerIdVehiculoPorMatricula(createAssignmentsWindow.getVehiculoComboBox().getSelectedItem().toString());
					        int idConductor = conexionSQL.obtenerIdUsuarioPorEmail(createAssignmentsWindow.getConductorComboBox().getSelectedItem().toString());
					        String fechaAsignacion = createAssignmentsWindow.getFechaField().getText();

					        if (!validarFormatoFecha(fechaAsignacion)) {
			                    JOptionPane.showMessageDialog(createAssignmentsWindow,
			                            "El formato de la fecha de asignación no es válido. Debe seguir el formato yyyy-MM-dd.",
			                            "Error de formato de fecha", JOptionPane.ERROR_MESSAGE);
			                    return;
					        }
					        AsignacionesEntity asignacion = new AsignacionesEntity(idAsignacion, idVehiculo, idConductor, fechaAsignacion);
							conexionSQL.modificarAsignacion(asignacion);
							createAssignmentsWindow.dispose();
							assignmentsWindow.getAssignmentsListModel().removeAllElements();
							loadAssignments();
						}
					});
					createAssignmentsWindow.getCancelButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							createAssignmentsWindow.dispose();
						}
					});
				}
			} else {
				JOptionPane.showMessageDialog(assignmentsWindow.getFrame(),
						"No se ha seleccionado ningún vehículo para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
