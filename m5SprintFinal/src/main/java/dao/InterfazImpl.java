package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexion.ConexionBD;
import modelo.Administrativo;
import modelo.Capacitacion;
import modelo.Cliente;
import modelo.FormularioContacto;
import modelo.Profesional;
import modelo.Usuario;

public class InterfazImpl implements Interfaz {

	private Connection conn;

	private List<FormularioContacto> formularioContacto;

	/**
	 * Conexión a la base de datos en LOCALHOST
	 * 
	 * @throws SQLException
	 * 
	 * @author Ariel Alfaro
	 * @author Bastian Muñoz
	 * @author Bastian Espinosa
	 * @author Joshua Montt
	 * @author Nicolas Gajardo
	 * @version 1.0
	 */

	public InterfazImpl() throws SQLException {
		this.conn = ConexionBD.getConnection();
	}

	public void almacenarCapacitacion(Capacitacion capacitacion) throws SQLException {
		String sql = "INSERT INTO capacitaciones (nombreCapacitacion, detalleCapacitacion) VALUES (?, ?)";

		// Manejo de la conexión y PreparedStatement con try-with-resources
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			// Asignar los parámetros
			ps.setString(1, capacitacion.getNombreCapacitacion());
			ps.setString(2, capacitacion.getDetalleCapacitacion());
			/*
			 * ps.setString(3, capacitacion.getRutEmpresa()); // Comentado si no es
			 * necesario
			 */

			// Ejecutar la actualización en la base de datos
			ps.executeUpdate();
			System.out.println("Capacitación almacenada correctamente.");

		} catch (SQLException e) {
			// Manejar cualquier error durante el almacenamiento de la capacitación
			e.printStackTrace();
			System.out.println("Error al almacenar la capacitación: " + e.getMessage());

			// Lanzar la excepción para que el código que llame este método también pueda
			// manejarla si es necesario
			throw e;
		}
	}

	@Override
	public List<Capacitacion> obtenerCapacitaciones() throws SQLException {
		List<Capacitacion> capacitaciones = new ArrayList<>();
		String sql = "SELECT * FROM capacitaciones";

		// Manejo correcto de la conexión, Statement y ResultSet con try-with-resources
		try (Connection conn = ConexionBD.getConnection(); // Obtener la conexión
				Statement statement = conn.createStatement(); // Crear el Statement
				ResultSet resultSet = statement.executeQuery(sql)) { // Ejecutar la consulta y obtener resultados

			while (resultSet.next()) {
				Capacitacion capacitacion = new Capacitacion();
				capacitacion.setIdCapacitacion(resultSet.getInt("idCapacitacion"));
				capacitacion.setNombreCapacitacion(resultSet.getString("nombreCapacitacion"));
				capacitacion.setDetalleCapacitacion(resultSet.getString("detalleCapacitacion"));

				capacitaciones.add(capacitacion);
			}
		} // Aquí se cerrarán automáticamente la conexión, el statement y el resultset

		return capacitaciones; // Devolver la lista de capacitaciones
	}

	@Override
	public int almacenarUsuarios(Usuario usuario) throws SQLException {
		String sqlInsertUsuario = "INSERT INTO usuarios (nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario, tipoUsuario) VALUES (?, ?, ?, ?, ?, ?)";
		int idUsuario = 0;

		// Manejo de la conexión, PreparedStatement y ResultSet con try-with-resources
		try (Connection conn = ConexionBD.getConnection();
				PreparedStatement ps = conn.prepareStatement(sqlInsertUsuario, Statement.RETURN_GENERATED_KEYS)) {

			// Asignar los parámetros de la consulta
			ps.setString(1, usuario.getNombreUsuario());
			ps.setString(2, usuario.getApellidoUsuario());
			ps.setString(3, usuario.getRunUsuario());
			ps.setString(4, usuario.getCorreoUsuario());
			ps.setString(5, usuario.getTelefonoUsuario());
			ps.setString(6, usuario.getTipoUsuario());

			// Ejecutar la actualización en la base de datos
			ps.executeUpdate();

			// Obtener el idUsuario generado automáticamente
			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					idUsuario = rs.getInt(1); // Guardar el idUsuario generado
				}
			}

		} catch (SQLException e) {
			// Manejar cualquier error durante el almacenamiento del usuario
			e.printStackTrace();
			System.out.println("Error al almacenar el usuario: " + e.getMessage());
			throw e; // Lanzar la excepción para que el código que llame a este método pueda
						// manejarla
		}

		return idUsuario; // Devolver el idUsuario generado
	}

	@Override
	public void almacenarAdministrativo(Administrativo administrativo, int idUsuario) throws SQLException {
		String sql = "INSERT INTO administrativos (idUsuario, areaAdministrativo, experienciaPrevia) VALUES (?,?,?)";

		// Manejo de la conexión y el PreparedStatement con try-with-resources
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {

			// Asignar los valores a los parámetros del PreparedStatement
			statement.setInt(1, idUsuario);
			statement.setString(2, administrativo.getAreaAdministrativo());
			statement.setString(3, administrativo.getExperienciaPrevia());

			// Ejecutar la actualización en la base de datos
			statement.executeUpdate();
			System.out.println("Administrativo almacenado correctamente.");

		} catch (SQLException e) {
			// Manejar cualquier error durante el almacenamiento del administrativo
			e.printStackTrace();
			System.out.println("Error al almacenar el administrativo: " + e.getMessage());
			throw e; // Lanzar la excepción para que el código que llame a este método pueda
						// manejarla
		}
	}

	@Override
	public void almacenarCliente(Cliente cliente, int idUsuario) throws SQLException {
		String sql = "INSERT INTO clientes (idUsuario, nombreEmpresa, rutEmpresa, telefonoEmpresa, correoEmpresa, direccionEmpresa, comunaEmpresa) VALUES (?, ?, ?, ?, ?, ?, ?)";

		// Manejo de la conexión y el PreparedStatement con try-with-resources
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {

			// Asignar los parámetros al PreparedStatement
			statement.setInt(1, idUsuario); // El idUsuario debe estar configurado correctamente
			statement.setString(2, cliente.getNombreEmpresa());
			statement.setString(3, cliente.getRutEmpresa());
			statement.setString(4, cliente.getTelefonoEmpresa());
			statement.setString(5, cliente.getCorreoEmpresa());
			statement.setString(6, cliente.getDireccionEmpresa());
			statement.setString(7, cliente.getComunaEmpresa());

			// Ejecutar la actualización en la base de datos
			int rowsAffected = statement.executeUpdate(); // Retorna la cantidad de filas afectadas

			if (rowsAffected > 0) {
				System.out.println("Cliente almacenado correctamente.");
			} else {
				System.out.println("No se almacenó ningún cliente.");
			}

		} catch (SQLException e) {
			// Manejar cualquier error durante el almacenamiento del cliente
			e.printStackTrace();
			System.out.println("Error al almacenar el cliente: " + e.getMessage());
			throw e; // Lanzar la excepción para que el código que llame a este método pueda
						// manejarla
		}
	}

	@Override
	public void almacenarProfesional(Profesional profesional, int idUsuario) throws SQLException {
		String sql = "INSERT INTO profesionales (idUsuario, tituloProfesional, fechaIngresoProfesional) VALUES (?, ?, ?)";

		// Manejo de la conexión y el PreparedStatement con try-with-resources
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {

			// Asignar los parámetros al PreparedStatement
			statement.setInt(1, idUsuario);
			statement.setString(2, profesional.getTituloProfesional());
			statement.setString(3, profesional.getFechaIngresoProfesional());

			// Ejecutar la actualización en la base de datos
			int rowsAffected = statement.executeUpdate(); // Retorna la cantidad de filas afectadas

			// Verificar si se realizó la inserción correctamente
			if (rowsAffected > 0) {
				System.out.println("Profesional almacenado correctamente.");
			} else {
				System.out.println("No se almacenó ningún profesional.");
			}

		} catch (SQLException e) {
			// Manejar cualquier error durante el almacenamiento del profesional
			e.printStackTrace();
			System.out.println("Error al almacenar el profesional: " + e.getMessage());
			throw e; // Lanzar la excepción para que el código que llame a este método pueda
						// manejarla
		}
	}

	@Override
	public List<Usuario> obtenerUsuarios() throws SQLException {
		List<Usuario> usuarios = new ArrayList<>();

		// Consulta SQL que recupera todos los datos de usuarios, clientes,
		// profesionales y administrativos
		String sql = "SELECT u.idUsuario, u.nombreUsuario, u.apellidoUsuario, u.runUsuario, u.correoUsuario, u.telefonoUsuario, u.tipoUsuario, "
				+ "c.nombreEmpresa, c.rutEmpresa, c.telefonoEmpresa, c.correoEmpresa, c.direccionEmpresa, c.comunaEmpresa, "
				+ "p.tituloProfesional, p.fechaIngresoProfesional, " + "a.areaAdministrativo, a.experienciaPrevia "
				+ "FROM usuarios u " + "LEFT JOIN clientes c ON u.idUsuario = c.idUsuario "
				+ "LEFT JOIN profesionales p ON u.idUsuario = p.idUsuario "
				+ "LEFT JOIN administrativos a ON u.idUsuario = a.idUsuario";

		// Manejo de la conexión, el Statement y el ResultSet con try-with-resources
		try (Connection conn = ConexionBD.getConnection();
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {

			// Iterar sobre los resultados y construir la lista de usuarios
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(resultSet.getInt("idUsuario"));
				usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
				usuario.setApellidoUsuario(resultSet.getString("apellidoUsuario"));
				usuario.setRunUsuario(resultSet.getString("runUsuario"));
				usuario.setCorreoUsuario(resultSet.getString("correoUsuario"));
				usuario.setTelefonoUsuario(resultSet.getString("telefonoUsuario"));
				usuario.setTipoUsuario(resultSet.getString("tipoUsuario"));

				// Filtrar por el tipo de usuario y asignar datos adicionales
				String tipoUsuario = resultSet.getString("tipoUsuario");

				switch (tipoUsuario) {
				case "cliente":
					Cliente cliente = new Cliente();
					cliente.setNombreEmpresa(resultSet.getString("nombreEmpresa"));
					cliente.setRutEmpresa(resultSet.getString("rutEmpresa"));
					cliente.setTelefonoEmpresa(resultSet.getString("telefonoEmpresa"));
					cliente.setCorreoEmpresa(resultSet.getString("correoEmpresa"));
					cliente.setDireccionEmpresa(resultSet.getString("direccionEmpresa"));
					cliente.setComunaEmpresa(resultSet.getString("comunaEmpresa"));
					usuario.setCliente(cliente);
					break;

				case "profesional":
					Profesional profesional = new Profesional();
					profesional.setTituloProfesional(resultSet.getString("tituloProfesional"));
					profesional.setFechaIngresoProfesional(resultSet.getString("fechaIngresoProfesional"));
					usuario.setProfesional(profesional);
					break;

				case "administrativo":
					Administrativo administrativo = new Administrativo();
					administrativo.setAreaAdministrativo(resultSet.getString("areaAdministrativo"));
					administrativo.setExperienciaPrevia(resultSet.getString("experienciaPrevia"));
					usuario.setAdministrativo(administrativo);
					break;
				}

				// Agregar el usuario a la lista
				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			// Manejar la excepción en caso de error durante la consulta
			e.printStackTrace();
			throw e;
		}

		return usuarios; // Devuelve la lista de usuarios
	}

	@Override
	public Usuario obtenerUsuarioPorId(int idUsuario) throws SQLException {
		Usuario usuario = null;

		// Consulta SQL para obtener todos los datos de un usuario por su ID
		String sql = "SELECT u.idUsuario, u.nombreUsuario, u.apellidoUsuario, u.runUsuario, u.correoUsuario, u.telefonoUsuario, u.tipoUsuario, "
				+ "c.nombreEmpresa, c.rutEmpresa, c.telefonoEmpresa, c.correoEmpresa, c.direccionEmpresa, c.comunaEmpresa, "
				+ "p.tituloProfesional, p.fechaIngresoProfesional, " + "a.areaAdministrativo, a.experienciaPrevia "
				+ "FROM usuarios u " + "LEFT JOIN clientes c ON u.idUsuario = c.idUsuario "
				+ "LEFT JOIN profesionales p ON u.idUsuario = p.idUsuario "
				+ "LEFT JOIN administrativos a ON u.idUsuario = a.idUsuario " + "WHERE u.idUsuario = ?";

		// Manejo de la conexión, el PreparedStatement y el ResultSet con
		// try-with-resources
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {

			// Asignar el idUsuario al PreparedStatement
			statement.setInt(1, idUsuario);

			// Ejecutar la consulta
			try (ResultSet resultSet = statement.executeQuery()) {

				if (resultSet.next()) {
					// Crear un nuevo objeto Usuario y asignar los valores generales
					usuario = new Usuario();
					usuario.setIdUsuario(resultSet.getInt("idUsuario"));
					usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
					usuario.setApellidoUsuario(resultSet.getString("apellidoUsuario"));
					usuario.setRunUsuario(resultSet.getString("runUsuario"));
					usuario.setCorreoUsuario(resultSet.getString("correoUsuario"));
					usuario.setTelefonoUsuario(resultSet.getString("telefonoUsuario"));
					usuario.setTipoUsuario(resultSet.getString("tipoUsuario"));

					// Dependiendo del tipo de usuario, asignar los detalles específicos
					String tipoUsuario = resultSet.getString("tipoUsuario");

					switch (tipoUsuario) {
					case "cliente":
						Cliente cliente = new Cliente();
						cliente.setNombreEmpresa(resultSet.getString("nombreEmpresa"));
						cliente.setRutEmpresa(resultSet.getString("rutEmpresa"));
						cliente.setTelefonoEmpresa(resultSet.getString("telefonoEmpresa"));
						cliente.setCorreoEmpresa(resultSet.getString("correoEmpresa"));
						cliente.setDireccionEmpresa(resultSet.getString("direccionEmpresa"));
						cliente.setComunaEmpresa(resultSet.getString("comunaEmpresa"));
						usuario.setCliente(cliente);
						break;

					case "profesional":
						Profesional profesional = new Profesional();
						profesional.setTituloProfesional(resultSet.getString("tituloProfesional"));
						profesional.setFechaIngresoProfesional(resultSet.getString("fechaIngresoProfesional"));
						profesional.setIdUsuario(resultSet.getInt("idUsuario")); // Asegurar que el idUsuario coincida
						usuario.setProfesional(profesional);
						break;

					case "administrativo":
						Administrativo administrativo = new Administrativo();
						administrativo.setAreaAdministrativo(resultSet.getString("areaAdministrativo"));
						administrativo.setExperienciaPrevia(resultSet.getString("experienciaPrevia"));
						usuario.setAdministrativo(administrativo);
						break;
					}
				}
			}

		} catch (SQLException e) {
			// Manejar cualquier error durante la consulta
			e.printStackTrace();
			throw e; // Volver a lanzar la excepción para que el código que llama este método pueda
						// manejarla
		}

		return usuario; // Devolver el objeto Usuario (o null si no se encontró)
	}

	@Override
	public void actualizarUsuario(Usuario usuario) throws SQLException {
		// Validar que el ID del usuario no sea 0 o inválido
		if (usuario.getIdUsuario() == 0) {
			throw new SQLException("El ID de usuario es inválido.");
		}

		// Consulta SQL para actualizar los datos generales del usuario
		String sql = "UPDATE usuarios SET nombreUsuario = ?, apellidoUsuario = ?, runUsuario = ?, "
				+ "correoUsuario = ?, telefonoUsuario = ?, tipoUsuario = ? WHERE idUsuario = ?";

		// Manejo de la conexión y el PreparedStatement con try-with-resources
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {

			// Asignar los valores al PreparedStatement
			statement.setString(1, usuario.getNombreUsuario());
			statement.setString(2, usuario.getApellidoUsuario());
			statement.setString(3, usuario.getRunUsuario());
			statement.setString(4, usuario.getCorreoUsuario());
			statement.setString(5, usuario.getTelefonoUsuario());
			statement.setString(6, usuario.getTipoUsuario());
			statement.setInt(7, usuario.getIdUsuario());

			// Ejecutar la actualización y verificar cuántas filas fueron actualizadas
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 0) {
				throw new SQLException("No se pudo actualizar el usuario con el ID proporcionado.");
			}

		} catch (SQLException e) {
			// Manejar cualquier error durante la actualización del usuario
			e.printStackTrace();
			throw e; // Volver a lanzar la excepción para que el código que llama este método pueda
						// manejarla
		}

		// Actualizar los datos específicos de cliente, profesional o administrativo
		// según el tipo de usuario
		try {
			if ("cliente".equals(usuario.getTipoUsuario())) {
				actualizarCliente(usuario.getCliente());
			} else if ("profesional".equals(usuario.getTipoUsuario())) {
				actualizarProfesional(usuario.getProfesional());
			} else if ("administrativo".equals(usuario.getTipoUsuario())) {
				actualizarAdministrativo(usuario.getAdministrativo());
			}
		} catch (SQLException e) {
			// Manejar errores durante la actualización de datos específicos
			e.printStackTrace();
			throw new SQLException("Error al actualizar los detalles específicos del usuario: " + e.getMessage());
		}
	}

	private void actualizarCliente(Cliente cliente) throws SQLException {
		String sql = "UPDATE clientes SET nombreEmpresa = ?, rutEmpresa = ?, telefonoEmpresa = ?, "
				+ "correoEmpresa = ?, direccionEmpresa = ?, comunaEmpresa = ? WHERE idUsuario = ?";

		// Manejo de la conexión y el PreparedStatement con try-with-resources
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {

			// Asignar los valores al PreparedStatement
			statement.setString(1, cliente.getNombreEmpresa());
			statement.setString(2, cliente.getRutEmpresa());
			statement.setString(3, cliente.getTelefonoEmpresa());
			statement.setString(4, cliente.getCorreoEmpresa());
			statement.setString(5, cliente.getDireccionEmpresa());
			statement.setString(6, cliente.getComunaEmpresa());
			statement.setInt(7, cliente.getIdUsuario());

			// Ejecutar la actualización y verificar cuántas filas fueron actualizadas
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 0) {
				throw new SQLException("No se pudo actualizar el cliente con el ID proporcionado.");
			}

			System.out.println("Cliente actualizado correctamente. Filas afectadas: " + rowsUpdated);
		} catch (SQLException e) {
			// Manejar cualquier error durante la actualización del cliente
			e.printStackTrace();
			throw e;
		}
	}

	private void actualizarProfesional(Profesional profesional) throws SQLException {
		String sql = "UPDATE profesionales SET tituloProfesional = ?, fechaIngresoProfesional = ? WHERE idUsuario = ?";

		// Manejo de la conexión y el PreparedStatement con try-with-resources
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {

			// Asignar los valores al PreparedStatement
			statement.setString(1, profesional.getTituloProfesional());
			statement.setString(2, profesional.getFechaIngresoProfesional());
			statement.setInt(3, profesional.getIdUsuario());

			// Ejecutar la actualización y verificar cuántas filas fueron actualizadas
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 0) {
				throw new SQLException("No se pudo actualizar el profesional con el ID proporcionado.");
			}

			System.out.println("Profesional actualizado correctamente. Filas afectadas: " + rowsUpdated);
		} catch (SQLException e) {
			// Manejar cualquier error durante la actualización del profesional
			e.printStackTrace();
			throw e;
		}
	}

	private void actualizarAdministrativo(Administrativo administrativo) throws SQLException {
		String sql = "UPDATE administrativos SET areaAdministrativo = ?, experienciaPrevia = ? WHERE idUsuario = ?";

		// Manejo de la conexión y el PreparedStatement con try-with-resources
		try (Connection conn = ConexionBD.getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {

			// Asignar los valores al PreparedStatement
			statement.setString(1, administrativo.getAreaAdministrativo());
			statement.setString(2, administrativo.getExperienciaPrevia());
			statement.setInt(3, administrativo.getIdUsuario());

			// Ejecutar la actualización y verificar cuántas filas fueron actualizadas
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated == 0) {
				throw new SQLException("No se pudo actualizar el administrativo con el ID proporcionado.");
			}

			System.out.println("Administrativo actualizado correctamente. Filas afectadas: " + rowsUpdated);
		} catch (SQLException e) {
			// Manejar cualquier error durante la actualización del administrativo
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void almacenarFormularioContacto(FormularioContacto formulario) {
		if (this.formularioContacto == null) {
			this.formularioContacto = new ArrayList<>();
		}
		this.formularioContacto.add(formulario);
	}

	public void eliminarUsuario(int idUsuario) throws SQLException {
		String sql = "DELETE FROM usuarios WHERE idUsuario = ?";

		// Manejo de la conexión y el PreparedStatement con try-with-resources
		try (Connection con = ConexionBD.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			// Asignar el idUsuario al PreparedStatement
			ps.setInt(1, idUsuario);

			// Ejecutar la actualización y verificar cuántas filas fueron afectadas
			int rowsDeleted = ps.executeUpdate();
			if (rowsDeleted == 0) {
				throw new SQLException("No se pudo eliminar el usuario con el ID proporcionado.");
			}

			System.out.println("Usuario eliminado correctamente. Filas afectadas: " + rowsDeleted);
		} catch (SQLException e) {
			// Manejar cualquier error durante la eliminación del usuario
			e.printStackTrace();
			throw e; // Volver a lanzar la excepción para que el código que llama a este método pueda
						// manejarla
		}
	}

	public List<Cliente> obtenerEmpresas() throws SQLException {
		List<Cliente> listaEmpresas = new ArrayList<>();

		String sql = "SELECT * FROM clientes"; // Asume que 'clientes' es la tabla donde guardas los datos de las
												// empresas

		// Manejo de la conexión, el Statement y el ResultSet con try-with-resources
		try (Connection conn = ConexionBD.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			// Iterar sobre el ResultSet y construir la lista de empresas
			while (rs.next()) {
				Cliente empresa = new Cliente();
				empresa.setRutEmpresa(rs.getString("rutEmpresa"));
				empresa.setNombreEmpresa(rs.getString("nombreEmpresa"));
				// Agregar otros campos relevantes según tu modelo
				listaEmpresas.add(empresa);
			}

		} catch (SQLException e) {
			// Manejar cualquier error durante la obtención de las empresas
			e.printStackTrace();
			System.out.println("Error al obtener empresas: " + e.getMessage());
			throw e; // Volver a lanzar la excepción para que el código que llame a este método pueda
						// manejarla
		}

		return listaEmpresas; // Devolver la lista de empresas
	}

}
