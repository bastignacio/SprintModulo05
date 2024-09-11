package modelo;

public class Administrativo extends Usuario {

	private int idUsuario;
	private String areaAdministrativo;
	private String experienciaPrevia;

	public Administrativo() {
		super();
	}

	public Administrativo(int idUsuario, String nombreUsuario, String apellidoUsuario, String runUsuario,
			String correoUsuario, String telefonoUsuario, String tipoUsuario, String areaAdministrativo,
			String experienciaPrevia) {
		super(idUsuario, nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario, tipoUsuario);

		this.areaAdministrativo = areaAdministrativo;
		this.experienciaPrevia = experienciaPrevia;
	}

	public Administrativo(String areaAdministrativo, String experienciaPrevia) {
		super();
		this.areaAdministrativo = areaAdministrativo;
		this.experienciaPrevia = experienciaPrevia;
	}

	public Administrativo(int idUsuario, String areaAdministrativo, String experienciaPrevia) {
		super();
		this.idUsuario = idUsuario;
		this.areaAdministrativo = areaAdministrativo;
		this.experienciaPrevia = experienciaPrevia;
	}

	public String getAreaAdministrativo() {
		return areaAdministrativo;
	}

	public void setAreaAdministrativo(String areaAdministrativo) {
		this.areaAdministrativo = areaAdministrativo;
	}

	public String getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(String experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return super.toString() + "Administrativo [areaAdministrativo=" + areaAdministrativo + ", experienciaPrevia="
				+ experienciaPrevia + "]";
	}

}