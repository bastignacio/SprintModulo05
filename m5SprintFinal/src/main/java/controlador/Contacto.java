package controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet que maneja la lógica del formulario de contacto. Permite a los
 * usuarios autenticados acceder a la página de contacto, y enviar un mensaje.
 * Además, muestra por consola los datos del formulario.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@WebServlet("/Contacto")
public class Contacto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Método para imprimir los datos del formulario de contacto en la consola.
	 * 
	 * @param email   El correo electrónico ingresado por el usuario.
	 * @param nombre  El nombre ingresado por el usuario.
	 * @param asunto  El asunto del mensaje ingresado por el usuario.
	 * @param mensaje El contenido del mensaje ingresado por el usuario.
	 */
	public void ImprimirContacto(String email, String nombre, String asunto, String mensaje) {
		System.out.println("==== Datos del Formulario de Contacto ====");
		System.out.println("Correo Electrónico: " + email);
		System.out.println("Nombre: " + nombre);
		System.out.println("Asunto: " + asunto);
		System.out.println("Mensaje: " + mensaje);
		System.out.println("=========================================");
	}

	/**
	 * Maneja las solicitudes GET para la página de contacto. Verifica si el usuario
	 * está autenticado antes de redirigirlo al formulario de contacto.
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
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("username") != null) {
			// Usuario autenticado, pasar al JSP
			request.getRequestDispatcher("/views/contacto.jsp").forward(request, response);
		} else {
			// Si no hay sesión activa, redirige al login
			response.sendRedirect(request.getContextPath() + "/login");
		}
	}

	/**
	 * Maneja las solicitudes POST desde el formulario de contacto. Recoge los datos
	 * del formulario, los valida, los imprime en consola y redirige al usuario con
	 * un mensaje de éxito o error.
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
		// Obtener parámetros del formulario
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		String asunto = request.getParameter("asunto");
		String mensaje = request.getParameter("mensaje");

		// Validar que no estén vacíos los campos requeridos
		if (email == null || nombre == null || asunto == null || mensaje == null || email.isEmpty() || nombre.isEmpty()
				|| asunto.isEmpty() || mensaje.isEmpty()) {
			// Redirigir a la página de contacto con un mensaje de error
			request.setAttribute("error", "Todos los campos son obligatorios.");
			request.getRequestDispatcher("/views/contacto.jsp").forward(request, response);
			return;
		}

		// Llamar al método para imprimir los datos por consola
		ImprimirContacto(email, nombre, asunto, mensaje);

		// Después de procesar, redirigir o mostrar mensaje de éxito
		request.setAttribute("success", "¡Tu mensaje ha sido enviado con éxito!");
		request.getRequestDispatcher("/views/contacto.jsp").forward(request, response);
	}
}
