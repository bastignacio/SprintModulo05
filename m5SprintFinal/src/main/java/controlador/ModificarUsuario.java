package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Interfaz;
import dao.InterfazImpl;
import modelo.Usuario;

/**
 * Servlet para manejar la modificación de usuarios.
 * 
 * Este servlet procesa las solicitudes GET para obtener un usuario específico
 * por su ID y redirige a una página JSP para permitir la edición de los datos
 * del usuario.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Instanciar la implementación de la interfaz
	private Interfaz interfaz;

	// Constructor explícito para inicializar la interfaz
	public ModificarUsuario() {
		try {
			interfaz = new InterfazImpl(); // Aquí manejamos la excepción
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al inicializar InterfazImpl", e); // Puedes elegir cómo manejar el error
		}
	}

	/**
	 * Maneja las solicitudes GET enviadas a este servlet. Obtiene el usuario por su
	 * ID y redirige al JSP para la modificación de datos.
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
			int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
			// Obtener el usuario por ID
			Usuario usuario = interfaz.obtenerUsuarioPorId(idUsuario);
			request.setAttribute("usuario", usuario);

			// Imprimir el ID del usuario para depuración
			System.out.println("ID Usuario recibido en servlet: " + usuario.getIdUsuario());

			// Redirigir al JSP donde se editarán los datos
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/formModificarUsuario.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("Error al obtener el usuario", e);
		}
	}
}
