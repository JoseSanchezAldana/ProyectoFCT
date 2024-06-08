package controlador;

import java.util.List;

import conexion.ConexionSQL;
import modelo.MantenimientoEntity;
import modelo.Modelo;
import vista.UserMaintenanceWindow;

/**
 * La clase UserMaintenanceControlller gestiona las interacciones entre la
 * ventana de mantenimientos de usuario y la base de datos.
 */
public class UserMaintenanceControlller {
	UserMaintenanceWindow maintenanceUserWindow;
	ConexionSQL conexionSQL;
	Modelo modelo;

	/**
	 * Constructor de la clase UserMaintenanceControlller.
	 * 
	 * @param maintenanceUserWindow La ventana de mantenimientos de usuario.
	 * @param conexionSQL           La conexión a la base de datos.
	 * @param modelo                El modelo de la aplicación.
	 */
	public UserMaintenanceControlller(UserMaintenanceWindow maintenanceUserWindow, ConexionSQL conexionSQL,
			Modelo modelo) {
		this.conexionSQL = conexionSQL;
		this.maintenanceUserWindow = maintenanceUserWindow;
		this.modelo = modelo;
	}

	/**
	 * Carga los mantenimientos del usuario en la ventana de mantenimientos de
	 * usuario.
	 */
	public void loadMaintenance() {
		List<MantenimientoEntity> mantenimientos = conexionSQL
				.obtenerMantenimientosPorUsuario(modelo.getIdActiveUser());
		for (MantenimientoEntity mantenimiento : mantenimientos) {
			maintenanceUserWindow.getMaintenanceListModel()
					.addElement("ID: " + mantenimiento.getIdMantenimiento() + "   ||   Vehiculo: "
							+ conexionSQL.obtenerVehiculoPorId(mantenimiento.getIdVehiculo()).getMatricula()
							+ "   ||   Tipo de mantenimiento: " + mantenimiento.getTipoMantenimiento()
							+ "   ||   Fecha del mantenimiento: " + mantenimiento.getFechaProgramada());
		}
	}
}
