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

public class InterfazImpl implements Interfaz{

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
	            idUsuario = rs.getInt(1);  // Guardar el idUsuario generado
	        }
	    }
	    return idUsuario;  // Devolver el idUsuario
	}
	
	
	@Override
	public void almacenarAdministrativo(Administrativo administrativo) throws SQLException {
		String sql = "INSERT INTO administrativos (areaAdministrativo, experienciaPrevia) VALUES (?,?)";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, administrativo.getAreaAdministrativo());
			statement.setString(2, administrativo.getExperienciaPrevia());
			
			statement.executeUpdate();
		}
	}
	
	@Override
	public void almacenarCliente(Cliente cliente, int idUsuario) throws SQLException {
		String sql = "INSERT INTO clientes (idUsuario, rutEmpresa, nombreEmpresa, telefonoEmpresa, correoEmpresa, direccionEmpresa, comunaEmpresa) VALUES (?,?,?,?,?,?,?)";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			
			statement.setInt(1, idUsuario);  // Aquí colocas el idUsuario
	        statement.setString(2, cliente.getRutEmpresa());
	        statement.setString(3, cliente.getNombreEmpresa());
	        statement.setString(4, cliente.getTelefonoEmpresa());
	        statement.setString(5, cliente.getCorreoEmpresa());
	        statement.setString(6, cliente.getDireccionEmpresa());
	        statement.setString(7, cliente.getComunaEmpresa());
	        
	        System.out.println("SQL: " + sql);  // Verificar la consulta SQL que se está ejecutando
	        
	        if (idUsuario > 0) {
	            System.out.println("idUsuario válido: " + idUsuario);
	        } else {
	            System.out.println("idUsuario no válido");
	        }


		}
	}
	
	@Override
	public void almacenarProfesional(Profesional profesional) throws SQLException {
		String sql = "INSERT INTO profesionales (tituloProfesional, fechaIngresoProfesional) VALUES (?, ?)";
		try (PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setString(1, profesional.getTituloProfesional());
			statement.setString(2, profesional.getFechaIngresoProfesional());
			statement.executeUpdate();
		}
	}

	@Override
	public List<Usuario> obtenerUsuarios() throws SQLException {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT * FROM usuarios";
		try (Statement statement = conn.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setIdUsuario(resultSet.getInt("id"));
				usuario.setNombreUsuario(resultSet.getString("nombreUsuario"));
				usuario.setApellidoUsuario(resultSet.getString("apellidoUsuario"));
				usuario.setRunUsuario(resultSet.getString("runUsuario"));
				usuario.setCorreoUsuario(resultSet.getString("correoUsuario"));
				usuario.setTelefonoUsuario(resultSet.getString("telefonoUsuario"));
				

				usuarios.add(usuario);
			}
		}
		return usuarios;
	}

		
	@Override
	public void almacenarFormularioContacto(FormularioContacto formulario) {
	    if (this.formularioContacto == null) {
	        this.formularioContacto = new ArrayList<>();
	    }
	    this.formularioContacto.add(formulario);
	}





}
