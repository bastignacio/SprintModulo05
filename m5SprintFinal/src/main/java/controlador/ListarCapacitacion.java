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

/**
 * Servlet para listar las capacitaciones disponibles.
 * 
 * Este servlet maneja las solicitudes GET para recuperar una lista de
 * capacitaciones desde la base de datos y redirige a la vista correspondiente.
 * También maneja las solicitudes POST redirigiéndolas a la misma vista.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@WebServlet("/ListarCapacitacion")
public class ListarCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Interfaz interfaz;

	public ListarCapacitacion() {
		super();
		try {
			// Inicializa la interfaz dentro del constructor con manejo de excepción
			interfaz = new InterfazImpl();
		} catch (SQLException e) {
			e.printStackTrace(); // Maneja la excepción aquí según lo necesites
			throw new RuntimeException("Error initializing InterfazImpl", e);
		}
	}

	/**
	 * Maneja las solicitudes GET enviadas a este servlet. Recupera la lista de
	 * capacitaciones desde la base de datos y redirige a la vista correspondiente.
	 * 
	 * @param request  El objeto HttpServletRequest que contiene la solicitud del
	 *                 cliente.
	 * @param response El objeto HttpServletResponse que contiene la respuesta del
	 *                 servlet.
	 * @throws ServletException Si ocurre un error en el procesamiento del servlet.
	 * @throws IOException      Si ocurre un error de entrada/salida.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Capacitacion> capacitaciones = interfaz.obtenerCapacitaciones();
			request.setAttribute("capacitaciones", capacitaciones);
			request.getRequestDispatcher("views/listarCapacitacion.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace(); // Imprime el error para depuración
			throw new ServletException("Error al obtener capacitaciones", e); // Lanza una excepción envuelta en
																				// ServletException
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	/*
	 * En conclusión, no es obligatorio desde una perspectiva de buenas prácticas,
	 * pero puede ser útil en algunos casos para proteger el código de futuros
	 * errores o para mejorar la claridad del comportamiento del servlet.
	 */

	/**
	 * Maneja las solicitudes POST enviadas a este servlet. Redirige las solicitudes
	 * POST a través del método doGet para manejar la navegación.
	 * 
	 * @param request  El objeto HttpServletRequest que contiene la solicitud del
	 *                 cliente.
	 * @param response El objeto HttpServletResponse que contiene la respuesta del
	 *                 servlet.
	 * @throws ServletException Si ocurre un error en el procesamiento del servlet.
	 * @throws IOException      Si ocurre un error de entrada/salida.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Redirige las solicitudes POST a doGet
		doGet(request, response);
	}
}
