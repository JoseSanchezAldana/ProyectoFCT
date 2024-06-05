package modelo;

public class MantenimientoEntity {
	private int idMantenimiento;
	private int idVehiculo;
	private String tipoMantenimiento;
	private String fechaProgramada;
	
	public MantenimientoEntity (int idMantenimiento, int idVehiculo, String tipoMantenimiento, String fechaProgramada) {
		this.idMantenimiento = idMantenimiento;
		this.idVehiculo = idVehiculo;
		this.tipoMantenimiento = tipoMantenimiento;
		this.fechaProgramada = fechaProgramada;
	}

	public int getIdMantenimiento() {
		return idMantenimiento;
	}

	public void setIdMantenimiento(int idMantenimiento) {
		this.idMantenimiento = idMantenimiento;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getTipoMantenimiento() {
		return tipoMantenimiento;
	}

	public void setTipoMantenimiento(String tipoMantenimiento) {
		this.tipoMantenimiento = tipoMantenimiento;
	}

	public String getFechaProgramada() {
		return fechaProgramada;
	}

	public void setFechaProgramada(String fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}
	
}
