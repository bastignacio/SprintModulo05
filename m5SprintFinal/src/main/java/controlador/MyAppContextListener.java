package controlador;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class MyAppContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Deregistrar el driver JDBC
        Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            java.sql.Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        AbandonedConnectionCleanupThread.checkedShutdown();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Aquí puedes inicializar los recursos necesarios cuando se arranque la aplicación
    }
}
