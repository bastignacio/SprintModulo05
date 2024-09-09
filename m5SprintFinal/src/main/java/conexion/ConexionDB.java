package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	
	private static Connection conn = null;
	
	private ConexionDB() {
		
		
		// MODIFICAR VALORES DE LA CONEXIÓN SEGUN EL LOCALHOST DE CADA UNO
		// USER
		// PASSWORD
		
		String url = "jdbc:mysql://localhost:3306/prevencion_riesgos";
		String driver = "com.mysql.jdbc.Driver";
		String user = "root";
		String password = "6969";

		try {
			Class.forName(driver);
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			}
		} catch (Exception ex) {
			// Handle errors for Class.forName
			ex.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (conn == null) {
			new ConexionDB();
			System.out.println("Se creo la conexion"); // DEBUG
			System.out.println("Metodo getConnection: " + conn);

			return conn;
		} else {
			System.out.println("Retorno conexion..."); // DEBUG
			return conn;
		}
	}

	
	

}
