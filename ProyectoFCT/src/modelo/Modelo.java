package modelo;

public class Modelo {
    
	private String direccionBd = "jdbc:mysql://localhost/proyectofct";
	private String usuarioBd = "root";
	private String passwordBd = "";
	private int idActiveUser = 0;

    public String getDireccionBd() {
        return direccionBd;
    }
    public void setDireccionBd(String direccionBd) {
        this.direccionBd = direccionBd;
    }
    public String getUsuarioBd() {
        return usuarioBd; 
    }
    public void setUsuarioBd(String usuarioBd) {
        this.usuarioBd = usuarioBd;
    }
    public String getPasswordBd() {
        return passwordBd;
    }
    public void setPasswordBd(String passwordBd) {
        this.passwordBd = passwordBd;
    }
	public int getIdActiveUser() {
		return idActiveUser;
	}
	public void setIdActiveUser(int idActiveUser) {
		this.idActiveUser = idActiveUser;
	}
    
}
