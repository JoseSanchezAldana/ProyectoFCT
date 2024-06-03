package modelo;

public class VehiculoEntity {
    private int idVehiculos;
    private String marca;
    private String modelo;
    private String matricula;
    private int anoMatriculacion;

    public VehiculoEntity(int idVehiculos, String marca, String modelo, String matricula, int anoMatriculacion) {
        this.idVehiculos = idVehiculos;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.anoMatriculacion = anoMatriculacion;
    }

    public int getIdVehiculos() {
        return idVehiculos;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getAnoMatriculacion() {
        return anoMatriculacion;
    }
}
