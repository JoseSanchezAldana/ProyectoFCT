package modelo;

/**
 * La clase MantenimientoEntity representa una entidad de mantenimiento con
 * atributos como ID, ID de vehículo, tipo de mantenimiento y fecha programada.
 */
public class MantenimientoEntity {
	private int idMantenimiento; // El ID del mantenimiento
	private int idVehiculo; // El ID del vehículo asociado con el mantenimiento
	private String tipoMantenimiento; // El tipo de mantenimiento
	private String fechaProgramada; // La fecha programada para el mantenimiento

	/**
	 * Construye una nueva instancia de MantenimientoEntity con los parámetros
	 * especificados.
	 * 
	 * @param idMantenimiento   El ID del mantenimiento
	 * @param idVehiculo        El ID del vehículo asociado con el mantenimiento
	 * @param tipoMantenimiento El tipo de mantenimiento
	 * @param fechaProgramada   La fecha programada para el mantenimiento
	 */
	public MantenimientoEntity(int idMantenimiento, int idVehiculo, String tipoMantenimiento, String fechaProgramada) {
		this.idMantenimiento = idMantenimiento;
		this.idVehiculo = idVehiculo;
		this.tipoMantenimiento = tipoMantenimiento;
		this.fechaProgramada = fechaProgramada;
	}

	/**
	 * Obtiene el ID del mantenimiento.
	 * 
	 * @return El ID del mantenimiento
	 */
	public int getIdMantenimiento() {
		return idMantenimiento;
	}

	/**
	 * Establece el ID del mantenimiento.
	 * 
	 * @param idMantenimiento El ID del mantenimiento
	 */
	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	/**
	 * Obtiene el ID del vehículo asociado con el mantenimiento.
	 * 
	 * @return El ID del vehículo asociado con el mantenimiento
	 */
	public int getIdVehiculo() {
		return idVehiculo;
	}

	/**
	 * Establece el ID del vehículo asociado con el mantenimiento.
	 * 
	 * @param idVehiculo El ID del vehículo asociado con el mantenimiento
	 */
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	/**
	 * Obtiene el tipo de mantenimiento.
	 * 
	 * @return El tipo de mantenimiento
	 */
	public String getTipoMantenimiento() {
		return tipoMantenimiento;
	}

	/**
	 * Establece el tipo de mantenimiento.
	 * 
	 * @param tipoMantenimiento El tipo de mantenimiento
	 */
	public void setTipoMantenimiento(String tipoMantenimiento) {
		this.tipoMantenimiento = tipoMantenimiento;
	}

	/**
	 * Obtiene la fecha programada para el mantenimiento.
	 * 
	 * @return La fecha programada para el mantenimiento
	 */
	public String getFechaProgramada() {
		return fechaProgramada;
	}

	/**
	 * Establece la fecha programada para el mantenimiento.
	 * 
	 * @param fechaProgramada La fecha programada para el mantenimiento
	 */
	public void setFechaProgramada(String fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
}
