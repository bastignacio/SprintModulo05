package modelo;


/*
 * Clase hija de la clase Padre Usuario llamada Administrativo que permite obtener los registros sobre un Usuario de tipo Administrativo. 
 */
public class Administrativo extends Usuario {
	private String area;
	private String experiencia;
	
	// Constructor vacio de la clase Administrativo que no recibe parametros.
	public Administrativo() {
		super();
		
	}// Cierra el constructor vacio Administrativo.
	
	// Constructor que posee los parametros heredados de la clase Padre Usuario y los parametros propios de la clase hija Administrativo
	public Administrativo(String nombre, String fecha, int run, String area, String experiencia) {
		super();
		this.area = area;
		this.experiencia = experiencia;
	} // Cierra el constructor con parametros de Administrativo.
	

	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}
	
/*
* Metodo toString() de la clase Administrativo.
* Sobrescribe el metodo ToString para presentar por consola los datos asociados al Usuario Administrativo registrado.
*/
	@Override
	public String toString() {
		return "Datos del Administrativo: \nÁrea: " + area + "\nExperiencia: " + experiencia;
	}
	
	
	
} // Cierra la clase Administrativo.