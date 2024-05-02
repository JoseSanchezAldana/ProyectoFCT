package controlador;

import conexion.ConexionSQL;
import modelo.Modelo;

public class Main {
	static ConexionSQL conexionSQL;

	public static void main(String[] args) throws ClassNotFoundException {
		Modelo modelo = new Modelo();
		conexionSQL = new ConexionSQL(modelo);
		System.out.println("Hola mundo");
		conexionSQL.insertarDatosPrueba(1);
	}

}
