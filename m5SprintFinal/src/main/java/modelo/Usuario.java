package modelo;

public class Usuario {

	private int idUsuario;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String runUsuario;
	private String correoUsuario;
	private String telefonoUsuario;
	private String tipoUsuario;

	private Cliente cliente;
	private Profesional profesional;
	private Administrativo administrativo;

	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nombreUsuario, String apellidoUsuario, String runUsuario, String correoUsuario,
			String telefonoUsuario, String tipoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.runUsuario = runUsuario;
		this.correoUsuario = correoUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.tipoUsuario = tipoUsuario;

	}

	public Usuario(String nombreUsuario, String apellidoUsuario, String runUsuario, String correoUsuario,
			String telefonoUsuario, String tipoUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.runUsuario = runUsuario;
		this.correoUsuario = correoUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.tipoUsuario = tipoUsuario;

	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getRunUsuario() {
		return runUsuario;
	}

	public void setRunUsuario(String runUsuario) {
		this.runUsuario = runUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;

	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Administrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}

	@Override
	public String toString() {

		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidoUsuario="
				+ apellidoUsuario + ", runUsuario=" + runUsuario + ", correoUsuario=" + correoUsuario
				+ ", telefonoUsuario=" + telefonoUsuario + "]";
	}

}
