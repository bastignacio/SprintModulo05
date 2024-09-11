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

/**
 * Servlet que maneja la creación de capacitaciones. Permite al usuario ver y
 * crear nuevas capacitaciones, además de mostrar la lista de empresas.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@WebServlet("/CrearCapacitacion")
public class CrearCapacitacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Instancia de la interfaz para manejar la base de datos
	private Interfaz interfaz;

	/**
	 * Constructor del servlet. Inicializa la interfaz con manejo de excepciones.
	 */
	public CrearCapacitacion() {
		super();
		try {
			// Inicializa la interfaz dentro del constructor con manejo de excepción
			this.interfaz = new InterfazImpl();
		} catch (SQLException e) {
			e.printStackTrace(); // Maneja la excepción según sea necesario
			throw new RuntimeException("Error initializing ImplementacionInterfaz", e);
		}
	}

	/**
	 * Maneja las solicitudes GET. Carga las capacitaciones y empresas para mostrar
	 * en el JSP.
	 * 
	 * @param request  El objeto HttpServletRequest que contiene la solicitud del
	 *                 cliente.
	 * @param response El objeto HttpServletResponse que contiene la respuesta del
	 *                 servlet.
	 * @throws ServletException Si ocurre un error al procesar el servlet.
	 * @throws IOException      Si ocurre un error de E/S.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Obtener las capacitaciones desde la base de datos y asignarlas a la solicitud
			request.setAttribute("capacitaciones", interfaz.obtenerCapacitaciones());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			// Obtener la lista de empresas desde la base de datos
			List<Cliente> empresas = interfaz.obtenerEmpresas(); // Asegúrate de que este método exista en tu DAO o
																	// servicio

			// Pasar la lista de empresas al JSP
			request.setAttribute("empresas", empresas);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Redirigir a la vista de creación de capacitaciones
		request.getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
	}

	/**
	 * Maneja las solicitudes POST para crear una nueva capacitación. Recoge los
	 * datos del formulario, crea una nueva capacitación y la almacena en la base de
	 * datos.
	 * 
	 * @param request  El objeto HttpServletRequest que contiene la solicitud del
	 *                 cliente.
	 * @param response El objeto HttpServletResponse que contiene la respuesta del
	 *                 servlet.
	 * @throws ServletException Si ocurre un error al procesar el servlet.
	 * @throws IOException      Si ocurre un error de E/S.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Obtener los datos del formulario
		String nombreCapacitacion = request.getParameter("nombreCapacitacion");
		String detalleCapacitacion = request.getParameter("detalleCapacitacion");

		// Crear un nuevo objeto de Capacitacion
		Capacitacion newCapacitacion = new Capacitacion(nombreCapacitacion, detalleCapacitacion);

		try {
			// Almacenar la nueva capacitación en la base de datos
			interfaz.almacenarCapacitacion(newCapacitacion);

			// Agregar mensaje de éxito
			request.setAttribute("success", "Capacitación creada exitosamente.");
		} catch (SQLException e) {
			e.printStackTrace();

			// Agregar mensaje de error
			request.setAttribute("error", "Error al crear la capacitación. Por favor, inténtelo de nuevo.");
		}

		// Redirigir de nuevo a la página de creación de capacitaciones
		request.getRequestDispatcher("/views/crearCapacitacion.jsp").forward(request, response);
	}
}
