package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaz.Interfaz;
import interfaz.InterfazImpl;
import modelo.Usuario;


@WebServlet("/ListarUsuarios")
public class ListarUsuarios extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Interfaz interfaz = null; // Inicializamos fuera del try-catch
        try {
            // Instanciar la implementación de la interfaz
            interfaz = new InterfazImpl(); // Envolver en try-catch si el constructor lanza SQLException
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error al instanciar InterfazImpl", e);
        }

        try {
            // Obtener la lista de usuarios desde la implementación
            List<Usuario> usuarios = interfaz.obtenerUsuarios();

            // Pasar la lista al JSP
            request.setAttribute("usuarios", usuarios);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/listarUsuarios.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e); // Aquí manejas cualquier error de SQL
        }
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}


