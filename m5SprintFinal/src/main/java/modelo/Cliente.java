package modelo;

public class Cliente extends Usuario {

	private String rutEmpresa;
	private String nombreEmpresa;
	private String telefonoEmpresa;
	private String correoEmpresa;
	private String direccionEmpresa;
	private String comunaEmpresa;
	
	
	public Cliente(int idUsuario, String nombreUsuario, String apellidoUsuario, String runUsuario, String correoUsuario,
			String telefonoUsuario, String rutEmpresa, String nombreEmpresa, String telefonoEmpresa,
			String correoEmpresa, String direccionEmpresa, String comunaEmpresa) {
		super(idUsuario, nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario);
		this.rutEmpresa = rutEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.correoEmpresa = correoEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.comunaEmpresa = comunaEmpresa;
	}

	public String getRutEmpresa() {
		return rutEmpresa;
	}

	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

	public String getCorreoEmpresa() {
		return correoEmpresa;
	}

	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}

	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public String getComunaEmpresa() {
		return comunaEmpresa;
	}

	public void setComunaEmpresa(String comunaEmpresa) {
		this.comunaEmpresa = comunaEmpresa;
	}

	@Override
	public String toString() {
		return super.toString() + "Cliente [rutEmpresa=" + rutEmpresa + ", nombreEmpresa=" + nombreEmpresa + ", telefonoEmpresa="
				+ telefonoEmpresa + ", correoEmpresa=" + correoEmpresa + ", direccionEmpresa=" + direccionEmpresa
				+ ", comunaEmpresa=" + comunaEmpresa + "]";
	}

	
	
	

	

}

