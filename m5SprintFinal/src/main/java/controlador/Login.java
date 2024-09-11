package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet para manejar el inicio de sesión de usuarios.
 * 
 * Este servlet procesa tanto las solicitudes GET como POST para gestionar el
 * inicio de sesión de los usuarios. En el método GET, verifica si el usuario ya
 * está autenticado y redirige a la página de bienvenida si es así, o muestra la
 * página de inicio de sesión si no lo está. En el método POST, valida las
 * credenciales del usuario y establece una sesión si las credenciales son
 * correctas. En caso contrario, redirige de nuevo a la página de inicio de
 * sesión con un mensaje de error.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor del servlet Login. Invoca el constructor de la superclase
	 * HttpServlet.
	 */
	public Login() {
		super();
	}

	/**
	 * Maneja las solicitudes GET enviadas a este servlet. Verifica si el usuario ya
	 * está autenticado y redirige a la página de bienvenida si es así. De lo
	 * contrario, muestra la página de inicio de sesión.
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
		HttpSession session = request.getSession(false); // No crea una nueva sesión
		if (session != null && session.getAttribute("username") != null) {
			// Usuario ya autenticado, redirigir a la página de bienvenida
			response.sendRedirect(request.getContextPath() + "/views/bienvenido.jsp");
		} else {
			// Si no hay sesión, mostrar la página de login
			getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

	/**
	 * Maneja las solicitudes POST enviadas a este servlet. Obtiene las credenciales
	 * del formulario, las valida y crea una sesión para el usuario si las
	 * credenciales son correctas. Redirige a la página Index.jsp en caso de éxito o
	 * redirige de nuevo al login con un mensaje de error si las credenciales son
	 * incorrectas.
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
		// Obtiene los datos del formulario
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Validación de credenciales
		if ("1234".equals(password) && "admin".equals(username)) {
			// Crea una sesión para el usuario
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			// Redirige a la página Index.jsp
			response.sendRedirect(request.getContextPath() + "/Index");
		} else {
			// Si el login falla, redirige de nuevo al login con un mensaje de error
			request.setAttribute("errorMessage", "Nombre de usuario o contraseña incorrectos");
			getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}
}
