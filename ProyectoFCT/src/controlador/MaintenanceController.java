package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import conexion.ConexionSQL;
import modelo.MantenimientoEntity;
import vista.MaintenanceManagementWindow;

public class MaintenanceController implements ActionListener {
	private MaintenanceManagementWindow maintenanceWindow;
	private ConexionSQL conexionSQL;

	public MaintenanceController(MaintenanceManagementWindow maintenanceWindow, ConexionSQL conexionSQL) {
		this.maintenanceWindow = maintenanceWindow;
		this.conexionSQL = conexionSQL;
	}

	public void loadMaintenance() {
		List<MantenimientoEntity> mantenimientos = conexionSQL.obtenerMantenimientos();
		for (MantenimientoEntity mantenimiento : mantenimientos) {
			maintenanceWindow.getMaintenanceListModel()
					.addElement("ID: " + mantenimiento.getIdMantenimiento() + "   ||   Vehiculo: "
							+ mantenimiento.getIdVehiculo() + "   ||   Tipo de mantenimiento: "
							+ mantenimiento.getTipoMantenimiento() + "   ||   Fecha del mantenimiento: "
							+ mantenimiento.getFechaProgramada());
		}
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

		} else if (e.getSource() == maintenanceWindow.getModifyButton()) {

		}

	}

}
