package modelo;

public class UsuarioEntity {
    private int idUsuario;
    private String nombre;
    private String email;
    private String rol;
    private VehiculoEntity vehiculo; // Assuming this is the class for vehicle details

    // Constructor
    public UsuarioEntity(int idUsuario, String nombre, String email, String rol, VehiculoEntity vehiculo) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.vehiculo = vehiculo;
    }

    // Getters and setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public VehiculoEntity getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoEntity vehiculo) {
        this.vehiculo = vehiculo;
    }
}
