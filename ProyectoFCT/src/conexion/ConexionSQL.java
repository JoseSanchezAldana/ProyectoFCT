package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Modelo;

public class ConexionSQL {

    private java.sql.Statement s;
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection conexion;
    private Modelo modelo;

    public ConexionSQL(Modelo modelo) {
        this.modelo = modelo;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Database URL, username, and password
            String url = "jdbc:mysql://" + modelo.getDireccionBd();
            String user = modelo.getUsuarioBd();
            String password = modelo.getPasswordBd();
            
            // Establish the connection
            conexion = DriverManager.getConnection(url, user, password);
            s = conexion.createStatement();
            System.out.println("Connection successful.");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Driver not found.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            System.err.println("Connection failed.");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to connect to the server.", "CONNECTION ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void insertarVehiculo(String marca, String modelo, int ano_matriculacion) {
        try {
            String consulta = "INSERT INTO vehiculos (marca, modelo, ano_matriculacion) VALUES (?, ?, ?)";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, marca);
            ps.setString(2, modelo);
            ps.setInt(3, ano_matriculacion);
            ps.executeUpdate();
            System.out.println("Vehicle inserted successfully.");
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
