package modelo;

public class FormularioContacto {
	
	private String nombreContacto;
	private String apellidoContacto;
	private String rutContacto;
	private String nombreEmpresa;
	private String correoContacto;
	private String detalleContacto;
	
	public FormularioContacto(String nombreContacto, String apellidoContacto, String rutContacto, String nombreEmpresa,
			String correoContacto, String detalleContacto) {
		super();
		this.nombreContacto = nombreContacto;
		this.apellidoContacto = apellidoContacto;
		this.rutContacto = rutContacto;
		this.nombreEmpresa = nombreEmpresa;
		this.correoContacto = correoContacto;
		this.detalleContacto = detalleContacto;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getApellidoContacto() {
		return apellidoContacto;
	}

	public void setApellidoContacto(String apellidoContacto) {
		this.apellidoContacto = apellidoContacto;
	}

	public String getRutContacto() {
		return rutContacto;
	}

	public void setRutContacto(String rutContacto) {
		this.rutContacto = rutContacto;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getCorreoContacto() {
		return correoContacto;
	}

	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;
	}

	public String getDetalleContacto() {
		return detalleContacto;
	}

	public void setDetalleContacto(String detalleContacto) {
		this.detalleContacto = detalleContacto;
	}

	@Override
	public String toString() {
		return "FormularioContacto: Nombre Representante Legal: " + nombreContacto + "\n" +
				", apellido Representante Legal: " + apellidoContacto + "\n" +
				", RUT Empresa: " + rutContacto + "\n" +
				", Nombre Empresa: " + nombreEmpresa + "\n" +
				", Correo Representante Legal=" + correoContacto + "\n" +
				", Detalle contacto: =" + detalleContacto;
	}

	
	
	
	
	

}
