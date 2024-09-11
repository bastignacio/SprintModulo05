package modelo;

public class Capacitacion {

	private int idCapacitacion;
	private String rutEmpresa;
	private String nombreCapacitacion;
	private String detalleCapacitacion;

	public Capacitacion() {
		super();
	}

	public Capacitacion(int idCapacitacion, String nombreCapacitacion, String detalleCapacitacion) {
		super();
		this.idCapacitacion = idCapacitacion;
		this.nombreCapacitacion = nombreCapacitacion;
		this.detalleCapacitacion = detalleCapacitacion;
	}

	public Capacitacion(String nombreCapacitacion, String detalleCapacitacion) {
		this.nombreCapacitacion = nombreCapacitacion;
		this.detalleCapacitacion = detalleCapacitacion;
	}

	public Capacitacion(int idCapacitacion, String rutEmpresa, String nombreCapacitacion, String detalleCapacitacion) {
		super();
		this.idCapacitacion = idCapacitacion;
		this.rutEmpresa = rutEmpresa;
		this.nombreCapacitacion = nombreCapacitacion;
		this.detalleCapacitacion = detalleCapacitacion;
	}

	public int getIdCapacitacion() {
		return idCapacitacion;
	}

	public void setIdCapacitacion(int idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	public String getNombreCapacitacion() {
		return nombreCapacitacion;
	}

	public void setNombreCapacitacion(String nombreCapacitacion) {
		this.nombreCapacitacion = nombreCapacitacion;
	}

	public String getDetalleCapacitacion() {
		return detalleCapacitacion;
	}

	public void setDetalleCapacitacion(String detalleCapacitacion) {
		this.detalleCapacitacion = detalleCapacitacion;
	}

	public String getRutEmpresa() {
		return rutEmpresa;
	}

	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}

	@Override
	public String toString() {
		return "Capacitacion [idCapacitacion=" + idCapacitacion + ", nombreCapacitacion=" + nombreCapacitacion
				+ ", detalleCapacitacion=" + detalleCapacitacion + "]";
	}

}