package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Evitar crear una nueva sesión
        if (session != null) {
            session.invalidate(); // Invalida la sesión existente
        }
        response.sendRedirect(request.getContextPath() + "/Login"); // Redirige al login
    }
}















/*
 * import java.io.IOException; import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.Cookie; import
 * javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest;
 * import javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * @WebServlet("/Logout") public class Logout extends HttpServlet { private
 * static final long serialVersionUID = 1L;
 * 
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException { //
 * Invalida la sesión actual, si existe HttpSession session =
 * request.getSession(false); if (session != null) { session.invalidate(); }
 * 
 * // Borra la cookie de username Cookie[] cookies = request.getCookies(); if
 * (cookies != null) { for (Cookie cookie : cookies) { if
 * (cookie.getName().equals("username")) { cookie.setValue("");
 * cookie.setMaxAge(0); response.addCookie(cookie); } } }
 * 
 * // Redirige al login response.sendRedirect(request.getContextPath() +
 * "/Login"); } }
 */