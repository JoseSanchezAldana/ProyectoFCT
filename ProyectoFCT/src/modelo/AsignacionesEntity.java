package modelo;

public class AsignacionesEntity {
	private int idAsignacion;
	private int idVehiculo;
	private int idConductor;
	private String fechaAsignacion;

	public AsignacionesEntity (int idAsignacion, int idVehiculo, int idConductor, String fechaAsignacion){
		this.idAsignacion = idAsignacion;
		this.idVehiculo = idVehiculo;
		this.idConductor = idConductor;
		this.fechaAsignacion = fechaAsignacion;
	}

	public int getIdAsignacion() {
		return idAsignacion;
	}

	public void setIdAsignacion(int idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getIdConductor() {
		return idConductor;
	}

	public void setIdConductor(int idConductor) {
		this.idConductor = idConductor;
	}

	public String getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}
	
}
