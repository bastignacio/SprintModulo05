package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Obtiene los datos del formulario
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    // Validación de credenciales
	    if ("1234".equals(password) && "admin".equals(username)) {
	        // Crea una sesión para el usuario
	        HttpSession session = request.getSession();
	        session.setAttribute("username", username);

	        // Redirige a la página contacto.jsp
	        response.sendRedirect(request.getContextPath() + "/Contacto");
	    } else {
	        // Si el login falla, redirige de nuevo al login con un mensaje de error
	        request.setAttribute("errorMessage", "Nombre de usuario o contraseña incorrectos");
	        getServletContext().getRequestDispatcher("/views/login.jsp").forward(request, response);
	    }
	}
}
