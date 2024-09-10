package controlador;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class MyAppContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Anular registro de todos los controladores JDBC para prevenir fugas de memoria
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

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // No es necesario hacer nada al inicio del contexto
    }
}

