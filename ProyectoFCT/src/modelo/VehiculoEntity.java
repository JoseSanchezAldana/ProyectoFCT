package modelo;

public class VehiculoEntity {
	private String marca;
	private String modelo;
	private String matricula;
	private int anioMatriculacion;

	public VehiculoEntity(String marca, String modelo, String matricula, int anioMatriculacion) {
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.anioMatriculacion = anioMatriculacion;
	}

	// Getters and setters for the fields
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getAnioMatriculacion() {
		return anioMatriculacion;
	}

	public void setAnioMatriculacion(int anioMatriculacion) {
		this.anioMatriculacion = anioMatriculacion;
	}
}
