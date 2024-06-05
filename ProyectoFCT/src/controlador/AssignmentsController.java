package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionSQL;
import modelo.AsignacionesEntity;
import vista.AssignmentsManagementWindow;

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

		} else if (e.getSource() == assignmentsWindow.getModifyButton()) {

		}
	}

}
