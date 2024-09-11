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
import modelo.Administrativo;
import modelo.Cliente;
import modelo.Profesional;
import modelo.Usuario;

/**
 * Servlet que maneja la actualización de usuarios en el sistema. Este servlet
 * procesa la solicitud para actualizar los datos de un usuario, ya sea
 * Profesional, Administrativo o Cliente.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@WebServlet("/ActualizarUsuario")
public class ActualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Instancia de la interfaz para la manipulación de datos en la base de datos
	private Interfaz interfaz;

	/**
	 * Constructor que inicializa la interfaz para la interacción con la base de
	 * datos. Lanza una excepción en caso de que haya un error al inicializar la
	 * conexión a la base de datos.
	 */
	public ActualizarUsuario() {
		try {
			interfaz = new InterfazImpl(); // Inicialización de la interfaz para interactuar con la base de datos
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al inicializar InterfazImpl", e);
		}
	}

	/**
	 * Maneja la solicitud POST para actualizar los datos de un usuario. Este método
	 * obtiene los datos del usuario desde el formulario y actualiza los registros
	 * correspondientes en la base de datos.
	 * 
	 * @param request  El objeto HttpServletRequest que contiene la solicitud del
	 *                 cliente.
	 * @param response El objeto HttpServletResponse que contiene la respuesta del
	 *                 servlet.
	 * @throws ServletException Si ocurre un error de procesamiento del servlet.
	 * @throws IOException      Si ocurre un error de E/S.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener los parámetros enviados desde el formulario
		int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
		System.out.println("ID Usuario para actualizar: " + idUsuario);

		String nombre = request.getParameter("nombreUsuario");
		String apellido = request.getParameter("apellidoUsuario");
		String run = request.getParameter("runUsuario");
		String correo = request.getParameter("correoUsuario");
		String telefono = request.getParameter("telefonoUsuario");
		String tipoUsuario = request.getParameter("tipoUsuario");

		try {
			// Obtener el usuario de la base de datos por su ID
			Usuario usuario = interfaz.obtenerUsuarioPorId(idUsuario);

			// Actualizar los datos básicos del usuario
			usuario.setNombreUsuario(nombre);
			usuario.setApellidoUsuario(apellido);
			usuario.setRunUsuario(run);
			usuario.setCorreoUsuario(correo);
			usuario.setTelefonoUsuario(telefono);
			usuario.setTipoUsuario(tipoUsuario);

			// Verificar el tipo de usuario y actualizar sus datos específicos
			if ("profesional".equals(tipoUsuario)) {
				String tituloProfesional = request.getParameter("tituloProfesional");
				String fechaIngreso = request.getParameter("fechaIngresoProfesional");

				// Obtener o crear el objeto Profesional asociado al usuario y actualizar los
				// datos
				Profesional profesional = usuario.getProfesional();
				if (profesional == null) {
					profesional = new Profesional();
					usuario.setProfesional(profesional); // Crear y asignar un nuevo objeto si no existe
				}
				profesional.setTituloProfesional(tituloProfesional);
				profesional.setFechaIngresoProfesional(fechaIngreso);
				profesional.setIdUsuario(usuario.getIdUsuario());

			} else if ("administrativo".equals(tipoUsuario)) {
				// Actualizar datos del Administrativo
				String areaAdministrativo = request.getParameter("areaAdministrativo");
				String experienciaPrevia = request.getParameter("experienciaPrevia");

				Administrativo administrativo = usuario.getAdministrativo();
				if (administrativo == null) {
					administrativo = new Administrativo();
					usuario.setAdministrativo(administrativo); // Crear y asignar un nuevo objeto si no existe
				}
				administrativo.setAreaAdministrativo(areaAdministrativo);
				administrativo.setExperienciaPrevia(experienciaPrevia);
				administrativo.setIdUsuario(usuario.getIdUsuario());

			} else if ("cliente".equals(tipoUsuario)) {
				// Actualizar datos del Cliente
				String nombreEmpresa = request.getParameter("nombreEmpresa");
				String rutEmpresa = request.getParameter("rutEmpresa");
				String telefonoEmpresa = request.getParameter("telefonoEmpresa");
				String correoEmpresa = request.getParameter("correoEmpresa");
				String direccionEmpresa = request.getParameter("direccionEmpresa");
				String comunaEmpresa = request.getParameter("comunaEmpresa");

				Cliente cliente = usuario.getCliente();
				if (cliente == null) {
					cliente = new Cliente();
					usuario.setCliente(cliente); // Crear y asignar un nuevo objeto si no existe
				}
				cliente.setNombreEmpresa(nombreEmpresa);
				cliente.setRutEmpresa(rutEmpresa);
				cliente.setTelefonoEmpresa(telefonoEmpresa);
				cliente.setCorreoEmpresa(correoEmpresa);
				cliente.setDireccionEmpresa(direccionEmpresa);
				cliente.setComunaEmpresa(comunaEmpresa);
				cliente.setIdUsuario(usuario.getIdUsuario());
			}

			// Actualizar el usuario en la base de datos
			interfaz.actualizarUsuario(usuario);

			// Redirigir a la lista de usuarios o a una página de confirmación
			response.sendRedirect("ListarUsuarios");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
