package dao;

import java.sql.SQLException;
import java.util.List;

import modelo.Administrativo;
import modelo.Capacitacion;
import modelo.Cliente;
import modelo.FormularioContacto;
import modelo.Profesional;
import modelo.Usuario;

/**
 * Interfaz para la manipulación de datos en la base de datos.
 * 
 * Esta interfaz define los métodos necesarios para gestionar operaciones
 * relacionadas con capacitaciones, usuarios, formularios de contacto y otros
 * modelos.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
public interface Interfaz {

	/*---- Manipulación de Capacitaciones ----*/

	/**
	 * Almacena una nueva capacitación en la base de datos.
	 * 
	 * @param capacitacion La capacitación a almacenar.
	 * @throws SQLException Si ocurre un error al almacenar la capacitación.
	 */
	void almacenarCapacitacion(Capacitacion capacitacion) throws SQLException;

	/**
	 * Obtiene la lista de capacitaciones almacenadas en la base de datos.
	 * 
	 * @return Una lista de capacitaciones.
	 * @throws SQLException Si ocurre un error al obtener las capacitaciones.
	 */
	List<Capacitacion> obtenerCapacitaciones() throws SQLException;

	/*---- Manipulación de Usuarios ----*/

	/**
	 * Almacena un nuevo usuario en la base de datos.
	 * 
	 * @param usuario El usuario a almacenar.
	 * @return El ID del usuario almacenado.
	 * @throws SQLException Si ocurre un error al almacenar el usuario.
	 */
	int almacenarUsuarios(Usuario usuario) throws SQLException;

	/**
	 * Obtiene la lista de usuarios almacenados en la base de datos.
	 * 
	 * @return Una lista de usuarios.
	 * @throws SQLException Si ocurre un error al obtener los usuarios.
	 */
	List<Usuario> obtenerUsuarios() throws SQLException;

	/**
	 * Almacena un nuevo profesional en la base de datos asociado a un usuario
	 * existente.
	 * 
	 * @param profesional El profesional a almacenar.
	 * @param idUsuario   El ID del usuario asociado.
	 * @throws SQLException Si ocurre un error al almacenar el profesional.
	 */
	void almacenarProfesional(Profesional profesional, int idUsuario) throws SQLException;

	/**
	 * Almacena un nuevo cliente en la base de datos asociado a un usuario
	 * existente.
	 * 
	 * @param cliente   El cliente a almacenar.
	 * @param idUsuario El ID del usuario asociado.
	 * @throws SQLException Si ocurre un error al almacenar el cliente.
	 */
	void almacenarCliente(Cliente cliente, int idUsuario) throws SQLException;

	/**
	 * Almacena un nuevo administrativo en la base de datos asociado a un usuario
	 * existente.
	 * 
	 * @param administrativo El administrativo a almacenar.
	 * @param idUsuario      El ID del usuario asociado.
	 * @throws SQLException Si ocurre un error al almacenar el administrativo.
	 */
	void almacenarAdministrativo(Administrativo administrativo, int idUsuario) throws SQLException;

	/*---- Manipulación de Formulario ----*/

	/**
	 * Almacena un nuevo formulario de contacto en la base de datos.
	 * 
	 * @param formularioContacto El formulario de contacto a almacenar.
	 */
	void almacenarFormularioContacto(FormularioContacto formularioContacto);

	/**
	 * Obtiene un usuario específico a partir de su ID.
	 * 
	 * @param idUsuario El ID del usuario a obtener.
	 * @return El usuario con el ID especificado.
	 * @throws SQLException Si ocurre un error al obtener el usuario.
	 */
	Usuario obtenerUsuarioPorId(int idUsuario) throws SQLException;

	/**
	 * Actualiza la información de un usuario en la base de datos.
	 * 
	 * @param usuario El usuario con la información actualizada.
	 * @throws SQLException Si ocurre un error al actualizar el usuario.
	 */
	void actualizarUsuario(Usuario usuario) throws SQLException;

	/**
	 * Elimina un usuario específico de la base de datos.
	 * 
	 * @param idUsuario El ID del usuario a eliminar.
	 * @throws SQLException Si ocurre un error al eliminar el usuario.
	 */
	void eliminarUsuario(int idUsuario) throws SQLException;

	/**
	 * Obtiene una lista de clientes que se consideran empresas.
	 * 
	 * @return Una lista de clientes que son empresas.
	 * @throws SQLException Si ocurre un error al obtener las empresas.
	 */
	List<Cliente> obtenerEmpresas() throws SQLException;
}
