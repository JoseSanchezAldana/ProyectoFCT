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
import modelo.VehiculoEntity;
import vista.CreateVehicleWindow;
import vista.ModifyVehicleWindow;
import vista.VehicleManagementWindow;

public class VehicleController implements ActionListener {
	private VehicleManagementWindow vehicleManagementWindow;
	private ConexionSQL conexionSQL;

	public VehicleController(VehicleManagementWindow vehicleManagementWindow, ConexionSQL conexionSQL) {
		this.vehicleManagementWindow = vehicleManagementWindow;
		this.conexionSQL = conexionSQL;
		
		this.vehicleManagementWindow.getDeleteButton().addActionListener(this);
        this.vehicleManagementWindow.getCreateButton().addActionListener(this);
        this.vehicleManagementWindow.getModifyButton().addActionListener(this);
	}

	public void loadVehicles() {
		vehicleManagementWindow.getVehicleListModel().clear();
		List<VehiculoEntity> vehiculos = conexionSQL.obtenerVehiculos();
		for (VehiculoEntity vehiculo : vehiculos) {
			vehicleManagementWindow.getVehicleListModel()
					.addElement("ID: " + vehiculo.getIdVehiculos() + "   ||   Matricula: " + vehiculo.getMatricula()
							+ "   ||   Marca: " + vehiculo.getMarca() + "   ||   Modelo: " + vehiculo.getModelo()
							+ "   ||   Año de Matriculación: " + vehiculo.getAnoMatriculacion());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vehicleManagementWindow.getDeleteButton()) {
			int idVehiculo = vehicleManagementWindow.getSelectedVehicleId();
			if (idVehiculo != -1) {
				int response = JOptionPane.showConfirmDialog(vehicleManagementWindow.getFrame(),
						"¿Estás seguro de que deseas eliminar este vehículo?", "Confirmación de eliminación",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

				if (response == JOptionPane.YES_OPTION) {
					conexionSQL.eliminarVehiculo(idVehiculo);
					loadVehicles();
				} else {
					JOptionPane.showMessageDialog(vehicleManagementWindow.getFrame(),
							"No se ha seleccionado ningún vehículo para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (e.getSource() == vehicleManagementWindow.getCreateButton()) {
			CreateVehicleWindow createVehicleWindow = new CreateVehicleWindow();
			createVehicleWindow.getCancelButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					createVehicleWindow.dispose();
				}
			});
			createVehicleWindow.getCreateButton().addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String marca = createVehicleWindow.getMarcaField().getText();
			        String modelo = createVehicleWindow.getModeloField().getText();
			        String matricula = createVehicleWindow.getMatriculaField().getText();
			        int anoMatriculacion = Integer.parseInt(createVehicleWindow.getAnoMatriculacionField().getText());

			        VehiculoEntity vehiculo = new VehiculoEntity(0, marca, modelo, matricula, anoMatriculacion);
					conexionSQL.crearVehiculo(vehiculo);
					createVehicleWindow.dispose();
					loadVehicles();
				}
			});
			createVehicleWindow.setVisible(true);
		} else if (e.getSource() == vehicleManagementWindow.getModifyButton()) {
			int idVehiculo = vehicleManagementWindow.getSelectedVehicleId();
			if (idVehiculo != -1) {
				VehiculoEntity vehiculo = conexionSQL.obtenerVehiculoPorId(idVehiculo);
				if (vehiculo != null) {
					ModifyVehicleWindow modifyVehicleWindow = new ModifyVehicleWindow(vehiculo.getMarca(),
							vehiculo.getModelo(), vehiculo.getMatricula(), vehiculo.getAnoMatriculacion());
					modifyVehicleWindow.setVisible(true);
					modifyVehicleWindow.getModifyButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							String marca = modifyVehicleWindow.getMarcaField().getText();
					        String modelo = modifyVehicleWindow.getModeloField().getText();
					        String matricula = modifyVehicleWindow.getMatriculaField().getText();
					        int anoMatriculacion = Integer.parseInt(modifyVehicleWindow.getAnoMatriculacionField().getText());

					        VehiculoEntity vehiculo = new VehiculoEntity(idVehiculo, marca, modelo, matricula, anoMatriculacion);
							if (conexionSQL.modificarVehiculo(vehiculo)) {
								modifyVehicleWindow.dispose();
								loadVehicles();
							}
						}
					});
					modifyVehicleWindow.getCancelButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							modifyVehicleWindow.dispose();
						}
					});
				}
			} else {
				JOptionPane.showMessageDialog(vehicleManagementWindow.getFrame(),
						"No se ha seleccionado ningún vehículo para modificar.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
