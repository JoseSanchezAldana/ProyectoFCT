package modelo;

/**
 * La clase VehiculoEntity representa un vehículo en el sistema.
 */
public class VehiculoEntity {
	private int idVehiculos; // El ID del vehículo
	private String marca; // La marca del vehículo
	private String modelo; // El modelo del vehículo
	private String matricula; // La matrícula del vehículo
	private int anoMatriculacion; // El año de matriculación del vehículo

	/**
	 * Constructor para crear un nuevo objeto VehiculoEntity.
	 * 
	 * @param idVehiculos      El ID del vehículo
	 * @param marca            La marca del vehículo
	 * @param modelo           El modelo del vehículo
	 * @param matricula        La matrícula del vehículo
	 * @param anoMatriculacion El año de matriculación del vehículo
	 */
	public VehiculoEntity(int idVehiculos, String marca, String modelo, String matricula, int anoMatriculacion) {
		this.idVehiculos = idVehiculos;
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.anoMatriculacion = anoMatriculacion;
	}

	/**
	 * Obtiene el ID del vehículo.
	 * 
	 * @return El ID del vehículo
	 */
	public int getIdVehiculos() {
		return idVehiculos;
	}

	/**
	 * Obtiene la marca del vehículo.
	 * 
	 * @return La marca del vehículo
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * Obtiene el modelo del vehículo.
	 * 
	 * @return El modelo del vehículo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Establece el ID del vehículo.
	 * 
	 * @param idVehiculos El ID del vehículo a establecer
	 */
	public void setIdVehiculos(int idVehiculos) {
		this.idVehiculos = idVehiculos;
	}

	/**
	 * Establece la marca del vehículo.
	 * 
	 * @param marca La marca del vehículo a establecer
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * Establece el modelo del vehículo.
	 * 
	 * @param modelo El modelo del vehículo a establecer
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * Establece la matrícula del vehículo.
	 * 
	 * @param matricula La matrícula del vehículo a establecer
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Establece el año de matriculación del vehículo.
	 * 
	 * @param anoMatriculacion El año de matriculación del vehículo a establecer
	 */
	public void setAnoMatriculacion(int anoMatriculacion) {
		this.anoMatriculacion = anoMatriculacion;
	}

	/**
	 * Obtiene la matrícula del vehículo.
	 * 
	 * @return La matrícula del vehículo
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Obtiene el año de matriculación del vehículo.
	 * 
	 * @return El año de matriculación del vehículo
	 */
	public int getAnoMatriculacion() {
		return anoMatriculacion;
	}
}
