package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static Connection conn = null;
    private static final String url = "jdbc:mysql://localhost:3306/sprintmodulo05";
    private static final String user = "root";
    private static final String password = "6969";
    private static final String driver = "com.mysql.cj.jdbc.Driver";  // Actualiza el driver si es necesario

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        try {
            // Si la conexión es nula o está cerrada, se crea una nueva
            if (conn == null || conn.isClosed()) {
                Class.forName(driver);  // Cargar el driver MySQL
                conn = DriverManager.getConnection(url, user, password);  // Crear nueva conexión
                System.out.println("Conexión creada: " + conn);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al obtener la conexión: " + e.getMessage());
            e.printStackTrace();
        }

        return conn;  // Retorna la conexión activa o recién creada
    }
}

