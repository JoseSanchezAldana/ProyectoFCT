package modelo;

/**
 * The AsignacionesEntity class represents an assignment entity with attributes
 * such as ID, vehicle ID, driver ID, and assignment date.
 */
public class AsignacionesEntity {
	private int idAsignacion; // The ID of the assignment
	private int idVehiculo; // The ID of the vehicle associated with the assignment
	private int idConductor; // The ID of the driver associated with the assignment
	private String fechaAsignacion; // The date of the assignment

	/**
	 * Constructs a new AsignacionesEntity with the specified parameters.
	 * 
	 * @param idAsignacion    The ID of the assignment
	 * @param idVehiculo      The ID of the vehicle associated with the assignment
	 * @param idConductor     The ID of the driver associated with the assignment
	 * @param fechaAsignacion The date of the assignment
	 */
	public AsignacionesEntity(int idAsignacion, int idVehiculo, int idConductor, String fechaAsignacion) {
		this.idAsignacion = idAsignacion;
		this.idVehiculo = idVehiculo;
		this.idConductor = idConductor;
		this.fechaAsignacion = fechaAsignacion;
	}

	/**
	 * Retrieves the ID of the assignment.
	 * 
	 * @return The ID of the assignment
	 */
	public int getIdAsignacion() {
		return idAsignacion;
	}

	/**
	 * Sets the ID of the assignment.
	 * 
	 * @param idAsignacion The ID of the assignment
	 */
	public void setIdAsignacion(int idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	/**
	 * Retrieves the ID of the vehicle associated with the assignment.
	 * 
	 * @return The ID of the vehicle associated with the assignment
	 */
	public int getIdVehiculo() {
		return idVehiculo;
	}

	/**
	 * Sets the ID of the vehicle associated with the assignment.
	 * 
	 * @param idVehiculo The ID of the vehicle associated with the assignment
	 */
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	/**
	 * Retrieves the ID of the driver associated with the assignment.
	 * 
	 * @return The ID of the driver associated with the assignment
	 */
	public int getIdConductor() {
		return idConductor;
	}

	/**
	 * Sets the ID of the driver associated with the assignment.
	 * 
	 * @param idConductor The ID of the driver associated with the assignment
	 */
	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}

	/**
	 * Retrieves the date of the assignment.
	 * 
	 * @return The date of the assignment
	 */
	public String getFechaAsignacion() {
		return fechaAsignacion;
	}

	/**
	 * Sets the date of the assignment.
	 * 
	 * @param fechaAsignacion The date of the assignment
	 */
	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
}
