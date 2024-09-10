package interfaz;

import java.sql.SQLException;
import java.util.List;

import modelo.Administrativo;
import modelo.Capacitacion;
import modelo.Cliente;
import modelo.FormularioContacto;
import modelo.Profesional;
import modelo.Usuario;

public interface Interfaz {
	
	
	/*---- Manipulación de Capacitaciones ----*/
	
	/* Almacenar */
    void almacenarCapacitacion(Capacitacion capacitacion) throws SQLException;
    /* Listar / Obtener */
    List<Capacitacion> obtenerCapacitaciones() throws SQLException;
    
    
    /*---- Manipulación de Usuarios ----*/
    
    /* Almacenar */
    int almacenarUsuarios(Usuario Usuario) throws SQLException;
    /* Listar / Obtener */
    List<Usuario> obtenerUsuarios() throws SQLException;
	/* Editar */
    
	void almacenarProfesional(Profesional profesional) throws SQLException;
	void almacenarCliente(Cliente cliente, int idUsuario) throws SQLException;
	void almacenarAdministrativo(Administrativo administrativo) throws SQLException;
    
    
    /*---- Manipulación de Formulario ----*/
    
    void almacenarFormularioContacto(FormularioContacto formularioContacto);
    
    
    


}
