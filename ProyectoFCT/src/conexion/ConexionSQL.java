package conexion;

import modelo.VehiculoEntity;
import modelo.AsignacionesEntity;
import modelo.MantenimientoEntity;
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

	/**
	 * Clase que gestiona la conexión a la base de datos MySQL y proporciona métodos
	 * para realizar operaciones CRUD relacionadas con las entidades del sistema.
	 */
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

	/**
	 * Obtiene una lista de todos los vehículos almacenados en la base de datos.
	 *
	 * @return Una lista de objetos VehiculoEntity que representan los vehículos
	 *         almacenados en la base de datos.
	 */
	public List<VehiculoEntity> obtenerVehiculos() {
		List<VehiculoEntity> vehiculos = new ArrayList<>();
		try {
			rs = s.executeQuery("SELECT * FROM vehiculos");
			while (rs.next()) {
				VehiculoEntity vehiculo = new VehiculoEntity(rs.getInt("idVehiculos"), rs.getString("marca"),
						rs.getString("modelo"), rs.getString("matricula"), rs.getInt("ano_matriculacion"));
				vehiculos.add(vehiculo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiculos;
	}

	/**
	 * Obtiene una lista de todos los usuarios almacenados en la base de datos.
	 *
	 * @return Una lista de objetos UsuarioEntity que representan los usuarios
	 *         almacenados en la base de datos.
	 */
	public List<UsuarioEntity> obtenerUsuarios() {
		List<UsuarioEntity> usuarios = new ArrayList<>();
		try {
			rs = s.executeQuery("SELECT * FROM usuarios");
			while (rs.next()) {
				UsuarioEntity usuario = new UsuarioEntity(rs.getInt("idUsuario"), rs.getString("nombre"),
						rs.getString("email"), rs.getString("password"), rs.getString("rol"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	/**
	 * Obtiene una lista de todas las asignaciones de vehículos almacenadas en la
	 * base de datos.
	 *
	 * @return Una lista de objetos AsignacionesEntity que representan las
	 *         asignaciones de vehículos almacenadas en la base de datos.
	 */
	public List<AsignacionesEntity> obtenerAsignaciones() {
		List<AsignacionesEntity> asignaciones = new ArrayList<>();
		try {
			rs = s.executeQuery("SELECT * FROM asignaciones");
			while (rs.next()) {
				AsignacionesEntity asignacion = new AsignacionesEntity(rs.getInt("idAsignacion"),
						rs.getInt("idVehiculo"), rs.getInt("idConductor"), rs.getString("fechaAsignacion"));
				asignaciones.add(asignacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return asignaciones;
	}

	/**
	 * Obtiene una lista de todos los mantenimientos de vehículos almacenados en la
	 * base de datos.
	 *
	 * @return Una lista de objetos MantenimientoEntity que representan los
	 *         mantenimientos de vehículos almacenados en la base de datos.
	 */
	public List<MantenimientoEntity> obtenerMantenimientos() {
		List<MantenimientoEntity> mantenimientos = new ArrayList<>();
		try {
			rs = s.executeQuery("SELECT * FROM mantenimientos");
			while (rs.next()) {
				MantenimientoEntity mantenimiento = new MantenimientoEntity(rs.getInt("idMantenimiento"),
						rs.getInt("idVehiculo"), rs.getString("tipoMantenimiento"), rs.getString("fechaProgramada"));
				mantenimientos.add(mantenimiento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mantenimientos;
	}

	/**
	 * Obtiene una lista de todos los mantenimientos de vehículos asignados a un
	 * usuario específico.
	 *
	 * @param idUsuario El ID del usuario para el que se desean obtener los
	 *                  mantenimientos de vehículos.
	 * @return Una lista de objetos MantenimientoEntity que representan los
	 *         mantenimientos de vehículos asignados al usuario.
	 */
	public List<MantenimientoEntity> obtenerMantenimientosPorUsuario(int idUsuario) {
		List<MantenimientoEntity> mantenimientos = new ArrayList<>();
		String query = "SELECT m.idMantenimiento, m.idVehiculo, m.tipoMantenimiento, m.fechaProgramada "
				+ "FROM mantenimientos m " + "JOIN vehiculos v ON m.idVehiculo = v.idVehiculos "
				+ "JOIN asignaciones a ON v.idVehiculos = a.idVehiculo "
				+ "JOIN usuarios u ON a.idConductor = u.idUsuario " + "WHERE u.idUsuario = ?";

		try {
			ps = conexion.prepareStatement(query);
			ps.setInt(1, idUsuario);
			rs = ps.executeQuery();
			while (rs.next()) {
				MantenimientoEntity mantenimiento = new MantenimientoEntity(rs.getInt("idMantenimiento"),
						rs.getInt("idVehiculo"), rs.getString("tipoMantenimiento"), rs.getString("fechaProgramada"));
				mantenimientos.add(mantenimiento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mantenimientos;
	}

	/**
	 * Crea un nuevo vehículo en la base de datos con la información proporcionada.
	 *
	 * @param vehiculo El objeto VehiculoEntity que contiene la información del
	 *                 vehículo a crear.
	 */
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

	/**
	 * Crea un nuevo usuario en la base de datos con la información proporcionada.
	 *
	 * @param usuario El objeto UsuarioEntity que contiene la información del
	 *                usuario a crear.
	 */
	public void crearUsuario(UsuarioEntity usuario) {
		try {
			String consulta = "INSERT INTO usuarios (nombre, email, password, rol) VALUES (?, ?, ?, ?)";
			ps = conexion.prepareStatement(consulta);
			ps.setString(1, usuario.getNombre());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getPassword());
			ps.setString(4, usuario.getRol());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea una nueva asignación de vehículo en la base de datos con la información
	 * proporcionada.
	 *
	 * @param asignacion El objeto AsignacionesEntity que contiene la información de
	 *                   la asignación a crear.
	 */
	public void crearAsignacion(AsignacionesEntity asignacion) {
		try {
			String consulta = "INSERT INTO asignaciones (idVehiculo, idConductor, fechaAsignacion) VALUES (?, ?, ?)";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, asignacion.getIdVehiculo());
			ps.setInt(2, asignacion.getIdConductor());
			ps.setString(3, asignacion.getFechaAsignacion());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Crea un nuevo registro de mantenimiento en la base de datos con la
	 * información proporcionada.
	 *
	 * @param mantenimiento El objeto MantenimientoEntity que contiene la
	 *                      información del mantenimiento a crear.
	 */
	public void crearMantenimiento(MantenimientoEntity asignacion) {
		try {
			String consulta = "INSERT INTO mantenimientos (idVehiculo, tipoMantenimiento, fechaProgramada) VALUES (?, ?, ?)";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, asignacion.getIdVehiculo());
			ps.setString(2, asignacion.getTipoMantenimiento());
			ps.setString(3, asignacion.getFechaProgramada());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Modifica un registro de vehículo en la base de datos con la información
	 * proporcionada.
	 *
	 * @param vehiculo El objeto VehiculoEntity que contiene la información del
	 *                 vehículo a modificar.
	 * @return true si la modificación se realiza con éxito, false en caso de error.
	 */
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

	/**
	 * Modifica un registro de usuario en la base de datos con la información
	 * proporcionada.
	 *
	 * @param usuario El objeto UsuarioEntity que contiene la información del
	 *                usuario a modificar.
	 * @return true si la modificación se realiza con éxito, false en caso de error.
	 */
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

	/**
	 * Modifica un registro de asignación en la base de datos con la información
	 * proporcionada.
	 *
	 * @param asignacion El objeto AsignacionesEntity que contiene la información de
	 *                   la asignación a modificar.
	 * @return true si la modificación se realiza con éxito, false en caso de error.
	 */
	public boolean modificarAsignacion(AsignacionesEntity asignacion) {
		try {
			String consulta = "UPDATE asignaciones SET idVehiculo = ?, idConductor = ?, fechaAsignacion = ? WHERE idAsignacion = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, asignacion.getIdVehiculo());
			ps.setInt(2, asignacion.getIdConductor());
			ps.setString(3, asignacion.getFechaAsignacion());
			ps.setInt(4, asignacion.getIdAsignacion());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Modifica un registro de mantenimiento en la base de datos con la información
	 * proporcionada.
	 *
	 * @param mantenimiento El objeto MantenimientoEntity que contiene la
	 *                      información del mantenimiento a modificar.
	 * @return true si la modificación se realiza con éxito, false en caso de error.
	 */
	public boolean modificarMantenimiento(MantenimientoEntity mantenimiento) {
		try {
			String consulta = "UPDATE mantenimientos SET idVehiculo = ?, tipoMantenimiento = ?, fechaProgramada = ? WHERE idMantenimiento = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, mantenimiento.getIdVehiculo());
			ps.setString(2, mantenimiento.getTipoMantenimiento());
			ps.setString(3, mantenimiento.getFechaProgramada());
			ps.setInt(4, mantenimiento.getIdMantenimiento());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Elimina un vehículo de la base de datos utilizando su identificador.
	 *
	 * @param idVehiculos El identificador del vehículo a eliminar.
	 */
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

	/**
	 * Elimina un usuario de la base de datos utilizando su identificador.
	 *
	 * @param idUsuario El identificador del usuario a eliminar.
	 */
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

	/**
	 * Elimina una asignación de la base de datos utilizando su identificador.
	 *
	 * @param idAsignacion El identificador de la asignación a eliminar.
	 */
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

	/**
	 * Elimina un registro de mantenimiento de la base de datos utilizando su
	 * identificador.
	 *
	 * @param idMantenimiento El identificador del mantenimiento a eliminar.
	 */
	public void eliminarMantenimiento(int idMantenimiento) {
		try {
			String consulta = "DELETE FROM mantenimientos WHERE idMantenimiento = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, idMantenimiento);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtiene un vehículo de la base de datos utilizando su identificador.
	 *
	 * @param idVehiculo El identificador del vehículo a obtener.
	 * @return El objeto VehiculoEntity correspondiente al vehículo encontrado, o
	 *         null si no se encuentra.
	 */
	public VehiculoEntity obtenerVehiculoPorId(int idVehiculo) {
		VehiculoEntity vehiculo = null;
		try {
			String consulta = "SELECT * FROM vehiculos WHERE idVehiculos = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, idVehiculo);
			rs = ps.executeQuery();
			if (rs.next()) {
				vehiculo = new VehiculoEntity(rs.getInt("idVehiculos"), rs.getString("marca"), rs.getString("modelo"),
						rs.getString("matricula"), rs.getInt("ano_matriculacion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiculo;
	}

	/**
	 * Obtiene un usuario de la base de datos utilizando su identificador.
	 *
	 * @param idUsuario El identificador del usuario a obtener.
	 * @return El objeto UsuarioEntity correspondiente al usuario encontrado, o null
	 *         si no se encuentra.
	 */
	public UsuarioEntity obtenerUsuarioPorId(int idUsuario) {
		UsuarioEntity usuario = null;
		try {
			String consulta = "SELECT * FROM usuarios WHERE idUsuario = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, idUsuario);
			rs = ps.executeQuery();
			if (rs.next()) {
				usuario = new UsuarioEntity(rs.getInt("idUsuario"), rs.getString("nombre"), rs.getString("email"),
						rs.getString("password"), rs.getString("rol"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	/**
	 * Obtiene una asignación de la base de datos utilizando su identificador.
	 *
	 * @param idAsignacion El identificador de la asignación a obtener.
	 * @return El objeto AsignacionesEntity correspondiente a la asignación
	 *         encontrada, o null si no se encuentra.
	 */
	public AsignacionesEntity obtenerAsignacionPorId(int idAsignacion) {
		AsignacionesEntity asignacion = null;
		try {
			String consulta = "SELECT * FROM asignaciones WHERE idAsignacion = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, idAsignacion);
			rs = ps.executeQuery();
			if (rs.next()) {
				asignacion = new AsignacionesEntity(rs.getInt("idAsignacion"), rs.getInt("idVehiculo"),
						rs.getInt("idConductor"), rs.getString("fechaAsignacion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return asignacion;
	}

	/**
	 * Obtiene un mantenimiento de la base de datos utilizando su identificador.
	 *
	 * @param idMantenimiento El identificador del mantenimiento a obtener.
	 * @return El objeto MantenimientoEntity correspondiente al mantenimiento
	 *         encontrado, o null si no se encuentra.
	 */
	public MantenimientoEntity obtenerMantenimientoPorId(int idMantenimiento) {
		MantenimientoEntity mantenimiento = null;
		try {
			String consulta = "SELECT * FROM mantenimientos WHERE idMantenimiento = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, idMantenimiento);
			rs = ps.executeQuery();
			if (rs.next()) {
				mantenimiento = new MantenimientoEntity(rs.getInt("idMantenimiento"), rs.getInt("idVehiculo"),
						rs.getString("tipoMantenimiento"), rs.getString("fechaProgramada"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mantenimiento;
	}

	/**
	 * Obtiene todas las matrículas de los vehículos almacenadas en la base de
	 * datos.
	 *
	 * @return Un array de strings que contiene todas las matrículas de los
	 *         vehículos.
	 */
	public String[] obtenerMatriculasVehiculos() {
		List<String> matriculas = new ArrayList<>();
		try {
			rs = s.executeQuery("SELECT matricula FROM vehiculos");
			while (rs.next()) {
				matriculas.add(rs.getString("matricula"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matriculas.toArray(new String[0]);
	}

	/**
	 * Obtiene todos los correos electrónicos de los usuarios almacenados en la base
	 * de datos.
	 *
	 * @return Un array de strings que contiene todos los correos electrónicos de
	 *         los usuarios.
	 */
	public String[] obtenerEmailUsuarios() {
		List<String> email = new ArrayList<>();
		try {
			rs = s.executeQuery("SELECT email FROM usuarios");
			while (rs.next()) {
				email.add(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return email.toArray(new String[0]);
	}

	/**
	 * Obtiene el ID del vehículo correspondiente a una matrícula específica.
	 *
	 * @param matricula La matrícula del vehículo.
	 * @return El ID del vehículo si se encuentra en la base de datos, de lo
	 *         contrario -1.
	 */
	public int obtenerIdVehiculoPorMatricula(String matricula) {
		int idVehiculo = -1;
		try {
			String consulta = "SELECT idVehiculos FROM vehiculos WHERE matricula = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setString(1, matricula);
			rs = ps.executeQuery();
			if (rs.next()) {
				idVehiculo = rs.getInt("idVehiculos");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idVehiculo;
	}

	/**
	 * Obtiene el ID del usuario correspondiente a un correo electrónico específico.
	 *
	 * @param email El correo electrónico del usuario.
	 * @return El ID del usuario si se encuentra en la base de datos, de lo
	 *         contrario -1.
	 */
	public int obtenerIdUsuarioPorEmail(String email) {
		int idUsuario = -1;
		try {
			String consulta = "SELECT idUsuario FROM usuarios WHERE email = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				idUsuario = rs.getInt("idUsuario");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idUsuario;
	}

	/**
	 * Obtiene el ID del usuario correspondiente a un nombre específico.
	 *
	 * @param nombre El nombre del usuario.
	 * @return El ID del usuario si se encuentra en la base de datos, de lo
	 *         contrario -1.
	 */
	public int obtenerIdUsuarioPorNombre(String nombre) {
		int idUsuario = -1;
		try {
			String consulta = "SELECT idUsuario FROM usuarios WHERE nombre = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setString(1, nombre);
			rs = ps.executeQuery();
			if (rs.next()) {
				idUsuario = rs.getInt("idUsuario");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idUsuario;
	}

	/**
	 * Obtiene una lista de vehículos asignados a un usuario específico.
	 *
	 * @param idUsuario El ID del usuario.
	 * @return Una lista de entidades de vehículos asignados al usuario, o una lista
	 *         vacía si no se encuentran vehículos asignados.
	 */
	public List<VehiculoEntity> obtenerVehiculosAsignadosAUsuario(int idUsuario) {
		List<VehiculoEntity> vehiculos = new ArrayList<>();
		try {
			String consulta = "SELECT v.* FROM vehiculos v " + "JOIN asignaciones a ON v.idVehiculos = a.idVehiculo "
					+ "WHERE a.idConductor = ?";
			ps = conexion.prepareStatement(consulta);
			ps.setInt(1, idUsuario);
			rs = ps.executeQuery();
			while (rs.next()) {
				VehiculoEntity vehiculo = new VehiculoEntity(rs.getInt("idVehiculos"), rs.getString("marca"),
						rs.getString("modelo"), rs.getString("matricula"), rs.getInt("ano_matriculacion"));
				vehiculos.add(vehiculo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiculos;
	}

	/**
	 * Cierra la conexión activa con la base de datos, si está abierta.
	 */
	public void cerrarConexion() {
		try {
			if (conexion != null && !conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Ejecuta una consulta SQL especificada y devuelve el resultado como un
	 * conjunto de resultados ResultSet.
	 *
	 * @param text la consulta SQL a ejecutar
	 * @return un conjunto de resultados ResultSet que contiene los datos producidos
	 *         por la consulta; o null si ocurre algún error durante la ejecución de
	 *         la consulta
	 */
	public ResultSet query(String text) {
		try {
			rs = s.executeQuery(text);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Obtiene el objeto Statement asociado a esta instancia.
	 *
	 * @return el objeto Statement asociado
	 */
	public Statement getS() {
		return s;
	}

	/**
	 * Establece el objeto Statement asociado a esta instancia.
	 *
	 * @param s el objeto Statement a establecer
	 */
	public void setS(Statement s) {
		this.s = s;
	}

	/**
	 * Obtiene el objeto ResultSet asociado a esta instancia.
	 *
	 * @return el objeto ResultSet asociado
	 */
	public ResultSet getRs() {
		return rs;
	}

	/**
	 * Establece el objeto ResultSet asociado a esta instancia.
	 *
	 * @param rs el objeto ResultSet a establecer
	 */
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	/**
	 * Obtiene el objeto PreparedStatement asociado a esta instancia.
	 *
	 * @return el objeto PreparedStatement asociado
	 */
	public PreparedStatement getPs() {
		return ps;
	}

	/**
	 * Establece el objeto PreparedStatement asociado a esta instancia.
	 *
	 * @param ps el objeto PreparedStatement a establecer
	 */
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	/**
	 * Obtiene el objeto Connection asociado a esta instancia.
	 *
	 * @return el objeto Connection asociado
	 */
	public Connection getConexion() {
		return conexion;
	}

	/**
	 * Establece el objeto Connection asociado a esta instancia.
	 *
	 * @param conexion el objeto Connection a establecer
	 */
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

}
