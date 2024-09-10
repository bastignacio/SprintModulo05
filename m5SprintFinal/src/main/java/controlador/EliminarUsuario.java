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
 * Servlet implementation class EliminarUsuario
 */
@WebServlet("/EliminarUsuario")

public class EliminarUsuario extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        
        // Lógica para eliminar el usuario de la base de datos
        Interfaz interfaz = null;
        
		try {
			interfaz = new InterfazImpl();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        try {
			interfaz.eliminarUsuario(idUsuario);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Redirigir de nuevo a la lista de usuarios
        response.sendRedirect("ListarUsuarios");
    }
}

