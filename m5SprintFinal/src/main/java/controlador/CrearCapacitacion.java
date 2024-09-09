package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO.ImplementacionInterfaz;
import model.DAO.Interfaz;
import modelo.Capacitacion;

@WebServlet("/CrearCapacitacion")
public class CrearCapacitacion extends HttpServlet {
    private static final long serialVersionUID = 1L;

private Interfaz interfaz;
	
    public CrearCapacitacion() {
        super();
        try {
            // Inicializas la interfaz dentro del constructor con manejo de excepción
            this.interfaz = new ImplementacionInterfaz();
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja la excepción aquí según lo necesites
            throw new RuntimeException("Error initializing ImplementacionInterfaz", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
			request.setAttribute("capacitaciones", interfaz.obtenerCapacitaciones());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
        
       


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
          String nombreCapacitacion = request.getParameter("nombreCapacitacion");
          String detalleCapacitacion = request.getParameter("detalleCapacitacion");
        
          Capacitacion newCapacitacion = new Capacitacion(nombreCapacitacion, detalleCapacitacion);
          
          try {
			interfaz.almacenarCapacitacion(newCapacitacion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
        request.getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
        
        
        
        
        
    }


}
