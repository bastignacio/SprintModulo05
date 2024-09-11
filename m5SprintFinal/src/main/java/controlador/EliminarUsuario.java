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

/**
 * Servlet para manejar la eliminación de usuarios en la base de datos.
 * 
 * Este servlet procesa las solicitudes POST enviadas desde la interfaz para
 * eliminar un usuario específico.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@WebServlet("/EliminarUsuario")
public class EliminarUsuario extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Maneja las solicitudes POST para eliminar un usuario de la base de datos.
	 * 
	 * @param request  El objeto HttpServletRequest que contiene la solicitud del
	 *                 cliente.
	 * @param response El objeto HttpServletResponse que contiene la respuesta del
	 *                 servlet.
	 * @throws ServletException Si ocurre un error en el procesamiento del servlet.
	 * @throws IOException      Si ocurre un error de E/S.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener el ID del usuario a eliminar desde los parámetros del formulario
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

		// Instancia de la interfaz para interactuar con la base de datos
		Interfaz interfaz = null;

		try {
			// Inicializar la implementación de la interfaz
			interfaz = new InterfazImpl();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("Error initializing InterfazImpl", e);
		}

		try {
			// Llamar al método para eliminar el usuario
			interfaz.eliminarUsuario(idUsuario);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException("Error deleting user", e);
		}

		// Redirigir de nuevo a la lista de usuarios después de la eliminación
		response.sendRedirect("ListarUsuarios");
	}
}
