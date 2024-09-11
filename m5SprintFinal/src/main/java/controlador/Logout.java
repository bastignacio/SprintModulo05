package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet para manejar el cierre de sesión de usuarios.
 * 
 * Este servlet procesa las solicitudes GET para cerrar la sesión del usuario
 * actual invalidando la sesión existente y redirigiendo al usuario a la página
 * de inicio de sesión.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Maneja las solicitudes GET enviadas a este servlet. Invalida la sesión actual
	 * si existe y redirige al usuario a la página de inicio de sesión.
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
		HttpSession session = request.getSession(false); // Evitar crear una nueva sesión
		if (session != null) {
			session.invalidate(); // Invalida la sesión existente
		}
		response.sendRedirect(request.getContextPath() + "/Login"); // Redirige al login
	}
}
