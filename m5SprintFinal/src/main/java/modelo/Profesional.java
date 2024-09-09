package modelo;

public class Profesional extends Usuario {

	private String titulo;
	private String fechaIngreso;
	
	public Profesional() {
		super();
	} // Cierra el constructor vacio de la clase Profesional.

	public Profesional(String nombre, String fecha, int run,String titulo, String fechaIngreso) {
		super();
		this.titulo = titulo;
		this.fechaIngreso = fechaIngreso;
	} // Cierra el constructor con parametros de la clase Profesional.

	// Getters and Setters de la clase Profesional.
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	// Metodo toString() de la Clase Profesional.
	@Override
	public String toString() {
		return "Datos del profesional: \nTítulo: "+ titulo + "\nFecha de Ingreso: "+fechaIngreso;
	}
	
} // Cierra la clase Profesional.

