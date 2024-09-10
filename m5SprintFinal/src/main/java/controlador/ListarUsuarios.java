package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

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
        Interfaz interfaz = null;
        try {
            interfaz = new InterfazImpl(); // Instanciar la implementación de la interfaz
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error al instanciar InterfazImpl", e);
        }

        // Obtener el tipo de usuario seleccionado en el dropdown
        String tipoUsuario = request.getParameter("tipoUsuario");

        List<Usuario> usuarios = null;
        try {
            usuarios = interfaz.obtenerUsuarios(); // Obtener la lista de usuarios desde la implementación

            // Filtrar la lista de usuarios según el tipo seleccionado
            if (tipoUsuario != null && !tipoUsuario.equals("todos")) {
                usuarios = usuarios.stream()
                    .filter(u -> u.getTipoUsuario().equalsIgnoreCase(tipoUsuario))
                    .collect(Collectors.toList());
            }
            
            // Pasar la lista filtrada al JSP
            request.setAttribute("usuarios", usuarios);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/listarUsuarios.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error al obtener usuarios", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}




