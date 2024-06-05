package conexion;

import modelo.VehiculoEntity;
import modelo.AsignacionesEntity;
import modelo.UsuarioEntity;

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
    
    public List<UsuarioEntity> obtenerUsuarios() {
        List<UsuarioEntity> usuarios = new ArrayList<>();
        try {
            rs = s.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
            	UsuarioEntity usuario = new UsuarioEntity(
                        rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("rol")
                );
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
    
    public List<AsignacionesEntity> obtenerAsignaciones() {
        List<AsignacionesEntity> asignaciones = new ArrayList<>();
        try {
            rs = s.executeQuery("SELECT * FROM asignaciones");
            while (rs.next()) {
            	AsignacionesEntity asignacion = new AsignacionesEntity(
                        rs.getInt("idAsignacion"),
                        rs.getInt("idVehiculo"),
                        rs.getInt("idConductor"),
                        rs.getString("fechaAsignacion")
                );
            	asignaciones.add(asignacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return asignaciones;
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
    
    public void crearUsuario(UsuarioEntity usuario) {
        try {
            String consulta = "INSERT INTO usuarios (nombre, email, password, rol) VALUES (?, ?, ?, ?)";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, "1234");
            ps.setString(4, usuario.getRol());
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
    
    public boolean modificarUsuario(UsuarioEntity usuario) {
        try {
            String consulta = "UPDATE usuarios SET nombre = ?, email = ?, password = ?, rol = ? WHERE idUsuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getRol());
            ps.setInt(5, usuario.getIdUsuario());
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
    
    public void eliminarUsuario(int idUsuario) {
        try {
            String consulta = "DELETE FROM usuarios WHERE idUsuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idUsuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void eliminarAsignacion(int idAsignacion) {
        try {
            String consulta = "DELETE FROM asignaciones WHERE idAsignacion = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idAsignacion);
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
    
    public UsuarioEntity obtenerUsuarioPorId(int idUsuario) {
        UsuarioEntity usuario = null;
        try {
            String consulta = "SELECT * FROM usuarios WHERE idUsuario = ?";
            ps = conexion.prepareStatement(consulta);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            if (rs.next()) {
            	usuario = new UsuarioEntity(
                    rs.getInt("idUsuario"),
                    rs.getString("nombre"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("rol")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
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
