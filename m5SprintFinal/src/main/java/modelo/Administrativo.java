package modelo;

public class Administrativo extends Usuario {

	private String areaAdministrativo;
	private int experienciaPrevia;
	

	public Administrativo(int idUsuario, String nombreUsuario, String apellidoUsuario, String runUsuario,
			String correoUsuario, String telefonoUsuario, String areaAdministrativo, int experienciaPrevia) {
		super(idUsuario, nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario);
		
		this.areaAdministrativo = areaAdministrativo;
		this.experienciaPrevia = experienciaPrevia;
	}



	public String getAreaAdministrativo() {
		return areaAdministrativo;
	}

	public void setAreaAdministrativo(String areaAdministrativo) {
		this.areaAdministrativo = areaAdministrativo;
	}

	public int getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public void setExperienciaPrevia(int experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	@Override
	public String toString() {
		return super.toString() + "Administrativo [areaAdministrativo=" + areaAdministrativo + ", experienciaPrevia="
				+ experienciaPrevia + "]";
	}
	
	

}
