package controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Contacto")
public class Contacto extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            // Usuario autenticado, pasar al JSP
            request.getRequestDispatcher("/views/contacto.jsp").forward(request, response);
        } else {
            // Si no hay sesión activa, redirige al login
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }
}


