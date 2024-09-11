package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Interfaz;
import dao.InterfazImpl;
import modelo.Usuario;
import modelo.Cliente;
import modelo.Profesional;
import modelo.Administrativo;

/**
 * Servlet que maneja la creación de usuarios en el sistema. Permite al usuario
 * crear nuevos usuarios y asignarles diferentes tipos de roles, como cliente,
 * administrativo o profesional.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Instancia de la interfaz para manejar la base de datos
	private Interfaz interfaz;

	/**
	 * Constructor del servlet. Inicializa la interfaz con manejo de excepciones.
	 */
	public CrearUsuario() {
		super();
		try {
			// Inicializa la interfaz dentro del constructor con manejo de excepción
			this.interfaz = new InterfazImpl();
		} catch (SQLException e) {
			e.printStackTrace(); // Maneja la excepción según sea necesario
			throw new RuntimeException("Error initializing InterfazImpl", e);
		}
	}

	/**
	 * Maneja las solicitudes GET. Redirige al JSP de creación de usuarios.
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
		// Redirige al JSP para la creación de usuarios
		getServletContext().getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
	}

	/**
	 * Maneja las solicitudes POST para crear un nuevo usuario. Recoge los datos del
	 * formulario, crea un nuevo usuario y lo almacena en la base de datos. Luego,
	 * dependiendo del tipo de usuario, también crea y almacena información
	 * adicional.
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

		// Obtener los datos básicos del formulario
		String nombreUsuario = request.getParameter("nombreUsuario");
		String apellidoUsuario = request.getParameter("apellidoUsuario");
		String runUsuario = request.getParameter("runUsuario");
		String correoUsuario = request.getParameter("correoUsuario");
		String telefonoUsuario = request.getParameter("telefonoUsuario");
		String tipoUsuario = request.getParameter("userType");

		// Crear un nuevo objeto Usuario
		Usuario newUsuario = new Usuario(nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario,
				tipoUsuario);

		int idUsuario = 0;

		try {
			// Almacenar el nuevo usuario y obtener su ID
			idUsuario = interfaz.almacenarUsuarios(newUsuario);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Dependiendo del tipo de usuario, crear y almacenar información adicional
		switch (tipoUsuario) {
		case "cliente":
			String rutEmpresa = request.getParameter("rutEmpresa");
			String nombreEmpresa = request.getParameter("nombreEmpresa");
			String telefonoEmpresa = request.getParameter("telefonoEmpresa");
			String correoEmpresa = request.getParameter("correoEmpresa");
			String direccionEmpresa = request.getParameter("direccionEmpresa");
			String comunaEmpresa = request.getParameter("comunaEmpresa");

			// Crear un nuevo objeto Cliente
			Cliente newCliente = new Cliente(rutEmpresa, nombreEmpresa, telefonoEmpresa, correoEmpresa,
					direccionEmpresa, comunaEmpresa);

			try {
				// Almacenar el nuevo cliente asociado al usuario
				interfaz.almacenarCliente(newCliente, idUsuario);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
			break;

		case "administrativo":
			String areaAdministrativo = request.getParameter("areaAdministrativo");
			String experienciaPrevia = request.getParameter("experienciaPrevia");

			// Crear un nuevo objeto Administrativo
			Administrativo newAdministrativo = new Administrativo(areaAdministrativo, experienciaPrevia);

			try {
				// Almacenar el nuevo administrativo asociado al usuario
				interfaz.almacenarAdministrativo(newAdministrativo, idUsuario);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
			break;

		case "profesional":
			String tituloProfesional = request.getParameter("tituloProfesional");
			String fechaIngresoProfesional = request.getParameter("fechaIngresoProfesional");

			// Crear un nuevo objeto Profesional
			Profesional newProfesional = new Profesional(tituloProfesional, fechaIngresoProfesional);

			try {
				// Almacenar el nuevo profesional asociado al usuario
				interfaz.almacenarProfesional(newProfesional, idUsuario);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);
			break;

		default:
			System.out.println("Tipo de usuario no válido");
		}
	}
}
