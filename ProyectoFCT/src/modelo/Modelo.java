package modelo;

/**
 * La clase Modelo representa la configuración y estado del modelo de la aplicación.
 */
public class Modelo {
    private String direccionBd = "jdbc:mysql://localhost/proyectofct"; // La dirección de la base de datos
    private String usuarioBd = "root"; // El nombre de usuario de la base de datos
    private String passwordBd = ""; // La contraseña de la base de datos
    private int idActiveUser = 0; // El ID del usuario activo
    private String key = "afghklkhghkln"; // La clave de encriptación

    /**
     * Obtiene la dirección de la base de datos.
     * 
     * @return La dirección de la base de datos
     */
    public String getDireccionBd() {
        return direccionBd;
    }

    /**
     * Establece la dirección de la base de datos.
     * 
     * @param direccionBd La dirección de la base de datos
     */
    public void setDireccionBd(String direccionBd) {
        this.direccionBd = direccionBd;
    }

    /**
     * Obtiene el nombre de usuario de la base de datos.
     * 
     * @return El nombre de usuario de la base de datos
     */
    public String getUsuarioBd() {
        return usuarioBd;
    }

    /**
     * Establece el nombre de usuario de la base de datos.
     * 
     * @param usuarioBd El nombre de usuario de la base de datos
     */
    public void setUsuarioBd(String usuarioBd) {
        this.usuarioBd = usuarioBd;
    }

    /**
     * Obtiene la contraseña de la base de datos.
     * 
     * @return La contraseña de la base de datos
     */
    public String getPasswordBd() {
        return passwordBd;
    }

    /**
     * Establece la contraseña de la base de datos.
     * 
     * @param passwordBd La contraseña de la base de datos
     */
    public void setPasswordBd(String passwordBd) {
        this.passwordBd = passwordBd;
    }

    /**
     * Obtiene el ID del usuario activo.
     * 
     * @return El ID del usuario activo
     */
    public int getIdActiveUser() {
        return idActiveUser;
    }

    /**
     * Establece el ID del usuario activo.
     * 
     * @param idActiveUser El ID del usuario activo
     */
    public void setIdActiveUser(int idActiveUser) {
        this.idActiveUser = idActiveUser;
    }

    /**
     * Obtiene la clave de encriptación.
     * 
     * @return La clave de encriptación
     */
    public String getKey() {
        return key;
    }

    /**
     * Establece la clave de encriptación.
     * 
     * @param key La clave de encriptación
     */
    public void setKey(String key) {
        this.key = key;
    }
}
