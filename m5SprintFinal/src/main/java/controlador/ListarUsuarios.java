package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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
 * Servlet para listar los usuarios.
 * 
 * Este servlet maneja las solicitudes GET para recuperar una lista de usuarios
 * desde la base de datos. También permite filtrar la lista de usuarios según el
 * tipo seleccionado en el dropdown. Maneja las solicitudes POST redirigiéndolas
 * al método doGet para procesarlas de la misma manera.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@WebServlet("/ListarUsuarios")
public class ListarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Maneja las solicitudes GET enviadas a este servlet. Recupera la lista de
	 * usuarios desde la base de datos y filtra la lista según el tipo de usuario
	 * seleccionado. Luego, redirige a la vista correspondiente.
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
		Interfaz interfaz = null;
		try {
			interfaz = new InterfazImpl(); // Instanciar la implementación de la interfaz
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("Error al instanciar InterfazImpl", e);
		}

		// Obtener el tipo de usuario seleccionado en el dropdown
		String tipoUsuario = request.getParameter("tipoUsuario");

		List<Usuario> usuarios = null;
		try {
			usuarios = interfaz.obtenerUsuarios(); // Obtener la lista de usuarios desde la implementación

			// Filtrar la lista de usuarios según el tipo seleccionado
			if (tipoUsuario != null && !tipoUsuario.equals("todos")) {
				usuarios = usuarios.stream().filter(u -> u.getTipoUsuario().equalsIgnoreCase(tipoUsuario))
						.collect(Collectors.toList());
			}

			// Pasar la lista filtrada al JSP
			request.setAttribute("usuarios", usuarios);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/listarUsuarios.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("Error al obtener usuarios", e);
		}
	}

	/**
	 * Maneja las solicitudes POST enviadas a este servlet. Redirige las solicitudes
	 * POST a través del método doGet para manejar la navegación y filtrado de
	 * usuarios.
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
		doGet(request, response);
	}
}
