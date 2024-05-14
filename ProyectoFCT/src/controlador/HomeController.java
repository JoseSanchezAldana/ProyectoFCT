package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import conexion.ConexionSQL;
import modelo.Modelo;
import vista.HomeWindow;
import vista.LoginWindow;

public class HomeController implements ActionListener {

    private String menuName;

    public HomeController(String menuName) {
        this.menuName = menuName;
    }

    public HomeController(HomeWindow homeView, ConexionSQL conexionSQL, Modelo modelo) {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(menuName + " seleccionado");
        // Aquí se puede agregar la lógica específica para cada menú
    }
}
