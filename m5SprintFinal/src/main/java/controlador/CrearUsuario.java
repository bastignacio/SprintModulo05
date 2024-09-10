package controlador;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Interfaz;
import dao.InterfazImpl;
import modelo.Usuario;
import modelo.Cliente;
import modelo.Profesional;
import modelo.Administrativo;

/**
 * Servlet implementation class CrearUsuario
 */
@WebServlet("/CrearUsuario")
public class CrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private Interfaz interfaz;
	
	public CrearUsuario() {
		super();
		try {
			// Inicializas la interfaz dentro del constructor con manejo de excepción
			this.interfaz = new InterfazImpl();
		} catch (SQLException e) {
			e.printStackTrace(); // Maneja la excepción aquí según lo necesites
			throw new RuntimeException("Error initializing InterfazImpl", e);
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/views/crearUsuario.jsp").forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nombreUsuario = request.getParameter("nombreUsuario");
		String apellidoUsuario = request.getParameter("apellidoUsuario");
		String runUsuario = request.getParameter("runUsuario");
		String correoUsuario = request.getParameter("correoUsuario");
		String telefonoUsuario = request.getParameter("telefonoUsuario");
		
		String tipoUsuario = request.getParameter("userType");

		
		Usuario newUsuario= new Usuario(nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario, tipoUsuario);
				
		int idUsuario = 0;
		
		try {
		    idUsuario = interfaz.almacenarUsuarios(newUsuario);  // Ahora almacenamos y obtenemos el idUsuario
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		switch(tipoUsuario) {
		case "cliente":
			String rutEmpresa = request.getParameter("rutEmpresa");
			String nombreEmpresa = request.getParameter("nombreEmpresa");
			String telefonoEmpresa = request.getParameter("telefonoEmpresa");
			String correoEmpresa = request.getParameter("correoEmpresa");
			String direccionEmpresa = request.getParameter("direccionEmpresa");
			String comunaEmpresa = request.getParameter("comunaEmpresa");	
			
			Cliente newCliente = new Cliente(rutEmpresa, nombreEmpresa, telefonoEmpresa, correoEmpresa, direccionEmpresa, comunaEmpresa);
			
			
			try {
			    interfaz.almacenarCliente(newCliente, idUsuario);
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			
			System.out.println(rutEmpresa + nombreEmpresa);
			
			request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);

			break;
			
		case "administrativo":
			
			String areaAdministrativo = request.getParameter("areaAdministrativo");
			String experienciaPrevia = request.getParameter("experienciaPrevia");
			
			Administrativo newAdministrativo = new Administrativo(areaAdministrativo, experienciaPrevia);
			
			try {
				interfaz.almacenarAdministrativo(newAdministrativo, idUsuario);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);

			
			break;
		case "profesional":
			
			String tituloProfesional = request.getParameter("tituloProfesional");
			String fechaIngresoProfesional = request.getParameter("fechaIngresoProfesional");
			
			Profesional newProfesional = new Profesional(tituloProfesional,fechaIngresoProfesional);
			
			try {
				interfaz.almacenarProfesional(newProfesional, idUsuario);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
			request.getRequestDispatcher("/views/crearUsuario.jsp").forward(request, response);

			break;		
			
		default:
			System.out.println("Tipo de usuario no válido");
		}

	}

}
