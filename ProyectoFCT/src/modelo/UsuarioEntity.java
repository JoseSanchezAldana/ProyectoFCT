package modelo;

/**
 * La clase UsuarioEntity representa un usuario en el sistema.
 */
public class UsuarioEntity {
	private int idUsuario; // El ID del usuario
	private String nombre; // El nombre del usuario
	private String email; // El correo electrónico del usuario
	private String password; // La contraseña del usuario
	private String rol; // El rol del usuario en el sistema

	/**
	 * Constructor para crear un nuevo objeto UsuarioEntity.
	 * 
	 * @param idUsuario El ID del usuario
	 * @param nombre    El nombre del usuario
	 * @param email     El correo electrónico del usuario
	 * @param password  La contraseña del usuario
	 * @param rol       El rol del usuario en el sistema
	 */
	public UsuarioEntity(int idUsuario, String nombre, String email, String password, String rol) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	/**
	 * Obtiene el ID del usuario.
	 * 
	 * @return El ID del usuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Establece el ID del usuario.
	 * 
	 * @param idUsuario El ID del usuario
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Obtiene el nombre del usuario.
	 * 
	 * @return El nombre del usuario
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del usuario.
	 * 
	 * @param nombre El nombre del usuario
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el correo electrónico del usuario.
	 * 
	 * @return El correo electrónico del usuario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el correo electrónico del usuario.
	 * 
	 * @param email El correo electrónico del usuario
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 * 
	 * @return La contraseña del usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece la contraseña del usuario.
	 * 
	 * @param password La contraseña del usuario
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Obtiene el rol del usuario en el sistema.
	 * 
	 * @return El rol del usuario
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Establece el rol del usuario en el sistema.
	 * 
	 * @param rol El rol del usuario
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
}
