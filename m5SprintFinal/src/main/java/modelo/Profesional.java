package modelo;

public class Profesional extends Usuario {

	private int idUsuario;
	private String tituloProfesional;
	private String fechaIngresoProfesional;

	public Profesional() {
		super();
	}

	public Profesional(int idUsuario, String nombreUsuario, String apellidoUsuario, String runUsuario,
			String correoUsuario, String telefonoUsuario, String tipoUsuario, String tituloProfesional,
			String fechaIngresoProfesional) {
		super(idUsuario, nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario, tipoUsuario);
		this.tituloProfesional = tituloProfesional;
		this.fechaIngresoProfesional = fechaIngresoProfesional;
	}

	public Profesional(int idUsuario, String tituloProfesional, String fechaIngresoProfesional) {
		this.idUsuario = idUsuario;
		this.tituloProfesional = tituloProfesional;
		this.fechaIngresoProfesional = fechaIngresoProfesional;
	}

	public Profesional(String tituloProfesional, String fechaIngresoProfesional) {

		this.tituloProfesional = tituloProfesional;
		this.fechaIngresoProfesional = fechaIngresoProfesional;
	}

	public String getTituloProfesional() {
		return tituloProfesional;
	}

	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	public String getFechaIngresoProfesional() {
		return fechaIngresoProfesional;
	}

	public void setFechaIngresoProfesional(String fechaIngresoProfesional) {
		this.fechaIngresoProfesional = fechaIngresoProfesional;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return super.toString() + "Profesional [tituloProfesional=" + tituloProfesional + ", fechaIngresoProfesional="
				+ fechaIngresoProfesional + "]";
	}

}
