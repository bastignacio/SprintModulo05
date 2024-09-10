package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Interfaz;
import dao.InterfazImpl;
import modelo.Capacitacion;
import modelo.Cliente;

@WebServlet("/CrearCapacitacion")
public class CrearCapacitacion extends HttpServlet {
    private static final long serialVersionUID = 1L;

private Interfaz interfaz;
	
    public CrearCapacitacion() {
        super();
        try {
            // Inicializas la interfaz dentro del constructor con manejo de excepción
            this.interfaz = new InterfazImpl();
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja la excepción aquí según lo necesites
            throw new RuntimeException("Error initializing ImplementacionInterfaz", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// Método para obtener las capacitaciones creadas
    	
        try {
			request.setAttribute("capacitaciones", interfaz.obtenerCapacitaciones());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
     // Método para rescatar las capacitaciones ya almacenadas y asignarlas con nombre "empresa"
        
        try {
            // Obtener la lista de empresas desde la base de datos
            List<Cliente> empresas = interfaz.obtenerEmpresas();  // Asegúrate de que este método exista en tu DAO o servicio
            
            // Pasar la lista de empresas al JSP
            request.setAttribute("empresas", empresas);
        } catch (SQLException e) {
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
