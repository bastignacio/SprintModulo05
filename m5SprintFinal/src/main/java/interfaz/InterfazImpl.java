package interfaz;

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
	 */

	public InterfazImpl() throws SQLException {
		this.conn = ConexionBD.getConnection();
	}

	@Override
	public void almacenarCapacitacion(Capacitacion capacitacion) throws SQLException {
		String sql = "INSERT INTO capacitaciones (nombre, detalle) VALUES (?, ?)";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, capacitacion.getNombreCapacitacion());
			statement.setString(2, capacitacion.getDetalleCapacitacion());
			statement.executeUpdate();
		}
	}

	@Override
	public List<Capacitacion> obtenerCapacitaciones() throws SQLException {
		List<Capacitacion> capacitaciones = new ArrayList<>();
		String sql = "SELECT * FROM capacitaciones";
		try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				Capacitacion capacitacion = new Capacitacion();

				capacitacion.setIdCapacitacion(resultSet.getInt("idCapacitacion"));
				capacitacion.setNombreCapacitacion(resultSet.getString("nombreCapacitacion"));
				capacitacion.setDetalleCapacitacion(resultSet.getString("detalleCapacitacion"));

				capacitaciones.add(capacitacion);
			}
		}
		return capacitaciones;
	}

	@Override
	public int almacenarUsuarios(Usuario usuario) throws SQLException {
		String sqlInsertUsuario = "INSERT INTO usuarios (nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario, tipoUsuario) VALUES (?, ?, ?, ?, ?, ?)";
		int idUsuario = 0;
		try (PreparedStatement ps = conn.prepareStatement(sqlInsertUsuario, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, usuario.getNombreUsuario());
			ps.setString(2, usuario.getApellidoUsuario());
			ps.setString(3, usuario.getRunUsuario());
			ps.setString(4, usuario.getCorreoUsuario());
			ps.setString(5, usuario.getTelefonoUsuario());
			ps.setString(6, usuario.getTipoUsuario());

			ps.executeUpdate();

			// Obtener el idUsuario generado automáticamente
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				idUsuario = rs.getInt(1); // Guardar el idUsuario generado
			}
		}
		return idUsuario; // Devolver el idUsuario
	}

	@Override
	public void almacenarAdministrativo(Administrativo administrativo, int idUsuario) throws SQLException {
		String sql = "INSERT INTO administrativos (idUsuario, areaAdministrativo, experienciaPrevia) VALUES (?,?,?)";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, idUsuario);
			statement.setString(2, administrativo.getAreaAdministrativo());
			statement.setString(3, administrativo.getExperienciaPrevia());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(); // Imprime la excepción en caso de error
		}
	}

	@Override
	public void almacenarCliente(Cliente cliente, int idUsuario) throws SQLException {
		String sql = "INSERT INTO clientes (idUsuario, rutEmpresa, nombreEmpresa, telefonoEmpresa, correoEmpresa, direccionEmpresa, comunaEmpresa) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, idUsuario); // El idUsuario debe estar configurado correctamente
			statement.setString(2, cliente.getRutEmpresa());
			statement.setString(3, cliente.getNombreEmpresa());
			statement.setString(4, cliente.getTelefonoEmpresa());
			statement.setString(5, cliente.getCorreoEmpresa());
			statement.setString(6, cliente.getDireccionEmpresa());
			statement.setString(7, cliente.getComunaEmpresa());

			statement.executeUpdate(); // Solo ejecuta la consulta, sin verificar las filas afectadas
		} catch (SQLException e) {
			e.printStackTrace(); // Imprime la excepción en caso de error
		}

	}

	@Override
	public void almacenarProfesional(Profesional profesional, int idUsuario) throws SQLException {
		String sql = "INSERT INTO profesionales (idUsuario, tituloProfesional, fechaIngresoProfesional) VALUES (?, ?, ?)";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, idUsuario);
			statement.setString(2, profesional.getTituloProfesional());
			statement.setString(3, profesional.getFechaIngresoProfesional());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace(); // Imprime la excepción en caso de error
		}
	}

	@Override
	public List<Usuario> obtenerUsuarios() throws SQLException {
	    List<Usuario> usuarios = new ArrayList<>();
	    
	    // Consulta SQL que recupera todos los datos de usuarios, clientes, profesionales y administrativos
	    String sql = "SELECT u.idUsuario, u.nombreUsuario, u.apellidoUsuario, u.runUsuario, u.correoUsuario, u.telefonoUsuario, u.tipoUsuario, " +
	                 "c.nombreEmpresa, c.rutEmpresa, c.telefonoEmpresa, c.correoEmpresa, c.direccionEmpresa, c.comunaEmpresa, " +
	                 "p.tituloProfesional, p.fechaIngresoProfesional, " +
	                 "a.areaAdministrativo, a.experienciaPrevia " +
	                 "FROM usuarios u " +
	                 "LEFT JOIN clientes c ON u.idUsuario = c.idUsuario " +
	                 "LEFT JOIN profesionales p ON u.idUsuario = p.idUsuario " +
	                 "LEFT JOIN administrativos a ON u.idUsuario = a.idUsuario";
	    
	    // Ejecutar la consulta
	    try (Statement statement = conn.createStatement();
	         ResultSet resultSet = statement.executeQuery(sql)) {
	        
	        while (resultSet.next()) {
	            // Crear un objeto Usuario y asignar los valores
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
	                    // Si el usuario es cliente, asignar los valores de cliente
	                    Cliente cliente = new Cliente();
	                    cliente.setNombreEmpresa(resultSet.getString("nombreEmpresa"));
	                    cliente.setRutEmpresa(resultSet.getString("rutEmpresa"));
	                    cliente.setTelefonoEmpresa(resultSet.getString("telefonoEmpresa"));
	                    cliente.setCorreoEmpresa(resultSet.getString("correoEmpresa"));
	                    cliente.setDireccionEmpresa(resultSet.getString("direccionEmpresa"));
	                    cliente.setComunaEmpresa(resultSet.getString("comunaEmpresa"));
	                    usuario.setCliente(cliente);  // Aquí asignas el cliente al usuario
	                    break;
	                    
	                case "profesional":
	                    // Si el usuario es profesional, asignar los valores de profesional
	                    Profesional profesional = new Profesional();
	                    profesional.setTituloProfesional(resultSet.getString("tituloProfesional"));
	                    profesional.setFechaIngresoProfesional(resultSet.getString("fechaIngresoProfesional"));
	                    usuario.setProfesional(profesional);
	                    break;
	                    
	                case "administrativo":
	                    // Si el usuario es administrativo, asignar los valores de administrativo
	                    Administrativo administrativo = new Administrativo();
	                    administrativo.setAreaAdministrativo(resultSet.getString("areaAdministrativo"));
	                    administrativo.setExperienciaPrevia(resultSet.getString("experienciaPrevia"));
	                    usuario.setAdministrativo(administrativo);
	                    break;
	            }

	            // Agregar el usuario a la lista
	            usuarios.add(usuario);
	        }
	    }
	    
	    return usuarios; // Devuelve la lista de usuarios
	}


	@Override
	public void almacenarFormularioContacto(FormularioContacto formulario) {
		if (this.formularioContacto == null) {
			this.formularioContacto = new ArrayList<>();
		}
		this.formularioContacto.add(formulario);
	}

}
