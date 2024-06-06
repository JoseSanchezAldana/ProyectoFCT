package controlador;

import java.util.List;

import conexion.ConexionSQL;
import modelo.MantenimientoEntity;
import modelo.Modelo;
import vista.UserMaintenanceWindow;

public class UserMaintenanceControlller {
	UserMaintenanceWindow maintenanceUserWindow;
	ConexionSQL conexionSQL;
	Modelo modelo;
	
	public UserMaintenanceControlller(UserMaintenanceWindow maintenanceUserWindow, ConexionSQL conexionSQL, Modelo modelo) {
		this.conexionSQL = conexionSQL;
		this.maintenanceUserWindow = maintenanceUserWindow;
		this.modelo = modelo;
	}
	
	public void loadMaintenance() {
		List<MantenimientoEntity> mantenimientos = conexionSQL.obtenerMantenimientosPorUsuario(modelo.getIdActiveUser());
		for (MantenimientoEntity mantenimiento : mantenimientos) {
			maintenanceUserWindow.getMaintenanceListModel()
					.addElement("ID: " + mantenimiento.getIdMantenimiento() + "   ||   Vehiculo: "
							+ conexionSQL.obtenerVehiculoPorId(mantenimiento.getIdVehiculo()) .getMatricula() + "   ||   Tipo de mantenimiento: "
							+ mantenimiento.getTipoMantenimiento() + "   ||   Fecha del mantenimiento: "
							+ mantenimiento.getFechaProgramada());
		}
	}
}
