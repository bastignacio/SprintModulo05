package modelo;

/*
 * Clase hija de la clase Padre Usuario llamada Cliente que permite obtener los registros sobre un Usuario de tipo Cliente. 
 */
public class Cliente extends Usuario {

	private int rut;
	private String nombres;
	private String apellidos;
	private int telefono;
	private String afp;
	private int salud;
	private String direccion;
	private String comuna;
	private int edad;
	
	// Constructor vacio de la clase Cliente que no recibe parametros.
	public Cliente() {
		super();
	} // Cierra el constructor vacio de la clase Cliente.

	// Constructor que posee los parametros heredados de la clase Padre Usuario y los parametros propios de la clase hija Cliente
	public Cliente(String nombre, String fecha,int run,int rut, String nombres, String apellidos, int telefono, String afp, int salud, String direccion,
			String comuna, int edad) {
		super();
		this.rut = rut;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.afp = afp;
		this.salud = salud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
	} // Cierra el constructor con parametros de la clase Cliente.

	
	// Getters and Setters de la clase Cliente.
	public int getRut() {
		return rut;
	}

	public void setRut(int rut) {
		this.rut = rut;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getAfp() {
		return afp;
	}

	public void setAfp(String afp) {
		this.afp = afp;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	
/*
* Metodo toString() de la clase Cliente.
* Sobrescribe el metodo ToString para presentar por consola los datos asociados al Usuario Cliente registrado.
*/
	@Override
	public String toString() {
		return "Datos del usuario: \nRut: " + rut + "\nNombres: " + nombres+ "\nApellidos: " + apellidos + "\nTeléfono: " + telefono + "\nAfp: " + afp+ "\nSalud: " + salud+ "\nDirección: " + direccion+ "\nComuna: " + comuna+ "\nEdad: " + edad ;
	}
	
} // Cierra la clase Cliente.
