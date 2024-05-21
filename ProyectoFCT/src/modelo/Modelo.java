package modelo;

public class Modelo {
    
    private String direccionBd = "sql8.freesqldatabase.com:3306/sql8707001";
    private String usuarioBd = "sql8707001";
    private String passwordBd = "wktrUhdmv9";

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
}
