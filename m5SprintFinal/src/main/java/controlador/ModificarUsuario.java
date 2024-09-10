package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import interfaz.Interfaz;
import interfaz.InterfazImpl;

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Instanciar la implementación de la interfaz
    private Interfaz interfaz;

    // Constructor explícito para inicializar la interfaz
    public ModificarUsuario() {
        try {
            interfaz = new InterfazImpl(); // Aquí manejamos la excepción
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al inicializar InterfazImpl", e); // Puedes elegir cómo manejar el error
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        try {
            // Utilizar el método de tu interfaz para obtener el usuario por ID
            Usuario usuario = interfaz.obtenerUsuarioPorId(idUsuario); // Llamada al método de la interfaz
            request.setAttribute("usuario", usuario);

            // Redirigir al JSP donde se editarán los datos
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/formModificarUsuario.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}




