package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import conexion.ConexionSQL;
import modelo.AsignacionesEntity;
import modelo.Modelo;
import modelo.VehiculoEntity;
import modelo.UsuarioEntity;
import vista.AssignmentsManagementWindow;
import vista.CreateAssignmentsWindow;
import vista.HomeWindow;
import vista.MaintenanceManagementWindow;
import vista.UserMaintenanceWindow;
import vista.UserManagementWindow;
import vista.VehicleManagementWindow;

public class HomeController implements ActionListener {

	private ConexionSQL conexionSQL;
	private HomeWindow homeView;
	private Modelo modelo;

	public HomeController(HomeWindow homeView, ConexionSQL conexionSQL, Modelo modelo) {
		this.homeView = homeView;
		this.conexionSQL = conexionSQL;
		this.modelo = modelo;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Gestión de vehículos") {
			VehicleManagementWindow vehiculeWindow = new VehicleManagementWindow();
			VehicleController vehicleController = new VehicleController(vehiculeWindow, conexionSQL);
			vehiculeWindow.getDeleteButton().addActionListener(vehicleController);
			vehicleController.loadVehicles();
			System.out.println("MENU VEHICULOS");
		} else if (e.getActionCommand() == "Gestión de usuarios") {
			UserManagementWindow userWindow = new UserManagementWindow();
			UserController userController = new UserController(userWindow, conexionSQL);
			userWindow.getDeleteButton().addActionListener(userController);
			userController.loadUsuarios();
			System.out.println("MENU USUARIOS");
		} else if (e.getActionCommand() == "Asignación de vehículos") {
			AssignmentsManagementWindow assignmentsWindow = new AssignmentsManagementWindow();
			AssignmentsController assignmentsController = new AssignmentsController(assignmentsWindow, conexionSQL);
			assignmentsWindow.getDeleteButton().addActionListener(assignmentsController);
			assignmentsController.loadAssignments();
			System.out.println("Asignación de vehículos seleccionada");
		} else if (e.getActionCommand() == "Mantenimientos") {
			MaintenanceManagementWindow maintenanceWindow = new MaintenanceManagementWindow();
			MaintenanceController maintenanceController = new MaintenanceController(maintenanceWindow, conexionSQL);
			maintenanceWindow.getDeleteButton().addActionListener(maintenanceController);
			maintenanceController.loadMaintenance();;
			System.out.println("Mantenimientos seleccionado");
		} else if (e.getActionCommand() == "Salir") {
			System.exit(0);
		} else if (e.getActionCommand() == "Mantenimientos pendientes") {
			System.out.println("HOla");
			UserMaintenanceWindow maintenanceUserWindow = new UserMaintenanceWindow();
			UserMaintenanceControlller userMController = new UserMaintenanceControlller(maintenanceUserWindow, conexionSQL, modelo);
			userMController.loadMaintenance();
		}
	}
	}
