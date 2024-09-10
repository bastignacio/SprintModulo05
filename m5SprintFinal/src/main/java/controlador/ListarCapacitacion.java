package controlador;

import java.io.IOException;
import java.sql.SQLException;
//import java.util.List;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaz.Interfaz;
import interfaz.InterfazImpl;
import modelo.Capacitacion;


@WebServlet("/ListarCapacitacion")
public class ListarCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Interfaz interfaz;
	
    public ListarCapacitacion() {
        super();
        try {
            // Inicializas la interfaz dentro del constructor con manejo de excepción
            interfaz = new InterfazImpl();
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja la excepción aquí según lo necesites
            throw new RuntimeException("Error initializing ImplementacionInterfaz", e);
        }
    }
	
		
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Capacitacion> capacitaciones = interfaz.obtenerCapacitaciones();
            request.setAttribute("capacitaciones", capacitaciones);
            request.getRequestDispatcher("views/listarCapacitacion.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();  // Imprime el error para depuración
            throw new ServletException("Error al obtener capacitaciones", e);  // Lanza una excepción envuelta en ServletException
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	/*
	 * En conclusión, no es obligatorio desde una perspectiva de buenas prácticas,
	 * pero puede ser útil en algunos casos para proteger el código de futuros
	 * errores o para mejorar la claridad del comportamiento del servlet.
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);  // Redirigir las solicitudes POST a doGet
		
	}

}
