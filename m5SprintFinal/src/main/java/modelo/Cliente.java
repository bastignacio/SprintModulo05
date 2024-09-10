package modelo;

public class Cliente extends Usuario {
	
	private int idUsuario;
	private String nombreEmpresa;
	private String rutEmpresa;
	private String telefonoEmpresa;
	private String correoEmpresa;
	private String direccionEmpresa;
	private String comunaEmpresa;
	

	public Cliente() {
		super();
	}

	public Cliente(int idUsuario, String nombreUsuario, String apellidoUsuario, String runUsuario, String correoUsuario, String telefonoUsuario, String tipoUsuario, 
			String nombreEmpresa, String rutEmpresa, String telefonoEmpresa,
			String correoEmpresa, String direccionEmpresa, String comunaEmpresa) {
		super(idUsuario, nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario, tipoUsuario);
		this.rutEmpresa = rutEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.correoEmpresa = correoEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.comunaEmpresa = comunaEmpresa;
	}

	public Cliente(String nombreEmpresa, String rutEmpresa, String telefonoEmpresa, String correoEmpresa, String direccionEmpresa, String comunaEmpresa) {
		super();
		this.nombreEmpresa = nombreEmpresa;
		this.rutEmpresa = rutEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.correoEmpresa = correoEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.comunaEmpresa = comunaEmpresa;
	}
	
	

	public Cliente(int idUsuario, String nombreEmpresa, String rutEmpresa, String telefonoEmpresa, String correoEmpresa,
			String direccionEmpresa, String comunaEmpresa) {
		super();
		this.idUsuario = idUsuario;
		this.nombreEmpresa = nombreEmpresa;
		this.rutEmpresa = rutEmpresa;
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
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return super.toString() + "Cliente [rutEmpresa=" + rutEmpresa + ", nombreEmpresa=" + nombreEmpresa
				+ ", telefonoEmpresa=" + telefonoEmpresa + ", correoEmpresa=" + correoEmpresa + ", direccionEmpresa="
				+ direccionEmpresa + ", comunaEmpresa=" + comunaEmpresa + "]";
	}

}
