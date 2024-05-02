package conexion;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Modelo;

public class ConexionSQL {

	private java.sql.Statement s;
	private ResultSet rs;
	private PreparedStatement ps;
	private Connection conexion;
	private Modelo modelo;

	public ConexionSQL(Modelo modelo) throws ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		try {
			conexion = DriverManager.getConnection(modelo.getDireccionBd(), modelo.getUsuarioBd(),
					modelo.getPasswordBd());
			s = conexion.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Fallo al conectar con el servidor.", "FALLO CONECTIVIDAD",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void insertarDatosPrueba(int idPrueba) {
		try {
			String consulta = "INSERT INTO prueba (id) VALUES (?)";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, idPrueba);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public java.sql.Statement getS() {
		return s;
	}

	public void setS(java.sql.Statement s) {
		this.s = s;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public ResultSet query(String text) {
		try {
			rs = s.executeQuery(text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
