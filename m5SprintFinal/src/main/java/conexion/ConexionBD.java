package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a la base de datos MySQL.
 * 
 * Esta clase proporciona un método estático para obtener una conexión a la base
 * de datos utilizando los parámetros configurados. Asegura que solo se cree una
 * instancia de la conexión y la reutiliza mientras esté activa.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
public class ConexionBD {
	private static Connection conn = null;
	private static final String url = "jdbc:mysql://localhost:3306/sprintmodulo05";
	private static final String user = "root";
	private static final String password = "6969";
	private static final String driver = "com.mysql.cj.jdbc.Driver"; // Actualiza el driver si es necesario

	/**
	 * Obtiene la conexión a la base de datos.
	 * 
	 * Si la conexión es nula o está cerrada, se crea una nueva conexión.
	 * 
	 * @return La conexión activa a la base de datos.
	 * @throws SQLException Si ocurre un error al obtener la conexión.
	 */
	public static Connection getConnection() throws SQLException {
		try {
			// Si la conexión es nula o está cerrada, se crea una nueva
			if (conn == null || conn.isClosed()) {
				Class.forName(driver); // Cargar el driver MySQL
				conn = DriverManager.getConnection(url, user, password); // Crear nueva conexión
				System.out.println("Conexión creada: " + conn);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el driver: " + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al obtener la conexión: " + e.getMessage());
			e.printStackTrace();
		}

		return conn; // Retorna la conexión activa o recién creada
	}
}
