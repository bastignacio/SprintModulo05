package controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Contacto")
public class Contacto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void ImprimirContacto(String email, String nombre, String asunto, String mensaje) {
		System.out.println("==== Datos del Formulario de Contacto ====");
		System.out.println("Correo Electrónico: " + email);
		System.out.println("Nombre: " + nombre);
		System.out.println("Asunto: " + asunto);
		System.out.println("Mensaje: " + mensaje);
		System.out.println("=========================================");
	}

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