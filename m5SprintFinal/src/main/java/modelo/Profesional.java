package modelo;

import java.time.LocalDate;

public class Profesional extends Usuario {

	private String tituloProfesional;
	private LocalDate fechaIngresoProfesional;

	

	public Profesional(int idUsuario, String nombreUsuario, String apellidoUsuario, String runUsuario,
			String correoUsuario, String telefonoUsuario, String tituloProfesional, LocalDate fechaIngresoProfesional) {
		super(idUsuario, nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario);
		this.tituloProfesional = tituloProfesional;
		this.fechaIngresoProfesional = fechaIngresoProfesional;
	}

	public String getTituloProfesional() {
		return tituloProfesional;
	}

	public void setTituloProfesional(String tituloProfesional) {
		this.tituloProfesional = tituloProfesional;
	}

	public LocalDate getFechaIngresoProfesional() {
		return fechaIngresoProfesional;
	}

	public void setFechaIngresoProfesional(LocalDate fechaIngresoProfesional) {
		this.fechaIngresoProfesional = fechaIngresoProfesional;
	}

	@Override
	public String toString() {
		return super.toString() + "Profesional [tituloProfesional=" + tituloProfesional + ", fechaIngresoProfesional="
				+ fechaIngresoProfesional + "]";
	}
	
	
}
