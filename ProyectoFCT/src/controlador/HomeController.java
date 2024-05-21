package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import conexion.ConexionSQL;
import modelo.Modelo;
import vista.HomeWindow;

public class HomeController implements ActionListener {

    private ConexionSQL conexionSQL;
    private HomeWindow homeView;

    public HomeController(HomeWindow homeView, ConexionSQL conexionSQL, Modelo modelo) {
        this.homeView = homeView;
        this.conexionSQL = conexionSQL;
        this.homeView.setController(this);  // Set the controller in HomeWindow
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Inicio seleccionado":
                // Acciones cuando se selecciona "Inicio"
                break;
            case "Vehículos seleccionado":
                // Acciones cuando se selecciona "Vehículos"
                break;
            case "Añadir Vehículo seleccionado":
                break;
            case "Eliminar Vehículo seleccionado":
                // Acciones cuando se selecciona "Eliminar Vehículo"
                break;
            case "Editar Vehículo seleccionado":
                // Acciones cuando se selecciona "Editar Vehículo"
                break;
            case "Usuarios seleccionado":
                // Acciones cuando se selecciona "Usuarios"
                break;
            case "Añadir Usuario seleccionado":
                // Acciones cuando se selecciona "Añadir Usuario"
                break;
            case "Modificar Usuarios seleccionado":
                // Acciones cuando se selecciona "Modificar Usuarios"
                break;
            case "Eliminar Usuarios seleccionado":
                // Acciones cuando se selecciona "Eliminar Usuarios"
                break;
            case "Configuración seleccionada":
                // Acciones cuando se selecciona "Configuración"
                break;
            default:
                break;
        }
    }
}
