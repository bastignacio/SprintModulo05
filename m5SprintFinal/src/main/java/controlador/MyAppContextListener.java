package controlador;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Listener para gestionar el ciclo de vida del contexto de la aplicación.
 * 
 * Este listener se encarga de realizar tareas de limpieza cuando el contexto de
 * la aplicación se destruye, como desregistrar los controladores JDBC y detener
 * el hilo de limpieza de conexiones abandonadas.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
public class MyAppContextListener implements ServletContextListener {

	/**
	 * Maneja el evento de destrucción del contexto. Desregistra todos los
	 * controladores JDBC y detiene el hilo de limpieza de conexiones abandonadas.
	 * 
	 * @param sce El objeto ServletContextEvent que contiene el contexto de la
	 *            aplicación.
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// Anular registro de todos los controladores JDBC para prevenir fugas de
		// memoria
		Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
		while (drivers.hasMoreElements()) {
			java.sql.Driver driver = drivers.nextElement();
			try {
				DriverManager.deregisterDriver(driver);
				System.out.println("Desregistrado el controlador JDBC: " + driver);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Detener el hilo de limpieza de conexiones abandonadas
		try {
			com.mysql.cj.jdbc.AbandonedConnectionCleanupThread.checkedShutdown();
			System.out.println("Hilo de limpieza de conexiones abandonadas detenido.");
		} catch (Exception e) {
			System.out.println("Error al detener el hilo de limpieza de conexiones: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Maneja el evento de inicialización del contexto. En este caso, no se realiza
	 * ninguna acción durante la inicialización.
	 * 
	 * @param sce El objeto ServletContextEvent que contiene el contexto de la
	 *            aplicación.
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// No es necesario hacer nada al inicio del contexto
	}
}
