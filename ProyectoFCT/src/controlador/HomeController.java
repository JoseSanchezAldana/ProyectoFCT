package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import conexion.ConexionSQL;
import modelo.Modelo;
import modelo.VehiculoEntity;
import vista.HomeWindow;
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
			List<VehiculoEntity> vehiculos = conexionSQL.obtenerVehiculos();
			
			for (VehiculoEntity vehiculo : vehiculos) {
				vehiculeWindow.getVehicleListModel().addElement(
						"ID: " + vehiculo.getIdVehiculos() 
						+ "   ||   Matricula: " + vehiculo.getMatricula()
						+ "   ||   Marca: " + vehiculo.getMarca() 
						+ "   ||   Modelo: " + vehiculo.getModelo()
						+ "   ||   Matricula: " + vehiculo.getAnoMatriculacion());
			}
			System.out.println("MENU VEHICULOS");
		} else if (e.getActionCommand() == "Gestión de usuarios") {
			UserManagementWindow userWindow = new UserManagementWindow();
			System.out.println("MENU USUARIOS");
		} else if (e.getActionCommand() == "Configuración") {
			System.out.println("Configuración seleccionada");
		}
	}
}
