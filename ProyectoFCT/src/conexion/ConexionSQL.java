package conexion;

import modelo.VehiculoEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ConexionSQL {

    private Statement s;
    private ResultSet rs;
    private PreparedStatement ps;
    private Connection conexion;

    public ConexionSQL(String url, String user, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conexion = DriverManager.getConnection(url, user, password);
            s = conexion.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fallo al conectar con el servidor.", "FALLO CONECTIVIDAD",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public List<VehiculoEntity> obtenerVehiculos() {
        List<VehiculoEntity> vehiculos = new ArrayList<>();
        try {
            rs = s.executeQuery("SELECT * FROM vehiculos");
            while (rs.next()) {
            	VehiculoEntity vehiculo = new VehiculoEntity(
                        rs.getInt("idVehiculos"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("matricula"),
                        rs.getInt("ano_matriculacion")
                );
                vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    public void crearVehiculo(VehiculoEntity vehiculo) {
        try {
            String consulta = "INSERT INTO vehiculos (marca, modelo, matricula, ano_matriculacion) VALUES (?, ?, ?, ?)";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getMatricula());
            ps.setInt(4, vehiculo.getAnoMatriculacion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean modificarVehiculo(VehiculoEntity vehiculo) {
        try {
            String consulta = "UPDATE vehiculos SET marca = ?, modelo = ?, matricula = ?, ano_matriculacion = ? WHERE idVehiculos = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, vehiculo.getMarca());
            ps.setString(2, vehiculo.getModelo());
            ps.setString(3, vehiculo.getMatricula());
            ps.setInt(4, vehiculo.getAnoMatriculacion());
            ps.setInt(5, vehiculo.getIdVehiculos());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return true;
    }

    public void eliminarVehiculo(int idVehiculos) {
        try {
            String consulta = "DELETE FROM vehiculos WHERE idVehiculos = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idVehiculos);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public VehiculoEntity obtenerVehiculoPorId(int idVehiculo) {
        VehiculoEntity vehiculo = null;
        try {
            String consulta = "SELECT * FROM vehiculos WHERE idVehiculos = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idVehiculo);
            rs = ps.executeQuery();
            if (rs.next()) {
                vehiculo = new VehiculoEntity(
                    rs.getInt("idVehiculos"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("matricula"),
                    rs.getInt("ano_matriculacion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculo;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet query(String text) {
		try {
			rs = s.executeQuery(text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public Statement getS() {
		return s;
	}

	public void setS(Statement s) {
		this.s = s;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

}
