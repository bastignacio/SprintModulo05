package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfaz.Interfaz;
import interfaz.InterfazImpl;
import modelo.Administrativo;
import modelo.Cliente;
import modelo.Profesional;
import modelo.Usuario;

/**
 * Servlet implementation class ActualizarUsuario
 */
@WebServlet("/ActualizarUsuario")
public class ActualizarUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Instancia de la interfaz
    private Interfaz interfaz;

    // Constructor explícito para inicializar la interfaz
    public ActualizarUsuario() {
        try {
            interfaz = new InterfazImpl(); // Inicialización de la interfaz
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al inicializar InterfazImpl", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        System.out.println("ID Usuario para actualizar: " + idUsuario);
        
        String nombre = request.getParameter("nombreUsuario");
        String apellido = request.getParameter("apellidoUsuario");
        String run = request.getParameter("runUsuario");
        String correo = request.getParameter("correoUsuario");
        String telefono = request.getParameter("telefonoUsuario");
        String tipoUsuario = request.getParameter("tipoUsuario");

        try {
            // Obtener el usuario por su ID
            Usuario usuario = interfaz.obtenerUsuarioPorId(idUsuario);

            // Actualizar los datos básicos del usuario
            usuario.setNombreUsuario(nombre);
            usuario.setApellidoUsuario(apellido);
            usuario.setRunUsuario(run);
            usuario.setCorreoUsuario(correo);
            usuario.setTelefonoUsuario(telefono);
            usuario.setTipoUsuario(tipoUsuario);

            // Si el tipo de usuario es profesional, actualiza los datos del profesional
            if ("profesional".equals(tipoUsuario)) {
                String tituloProfesional = request.getParameter("tituloProfesional");
                String fechaIngreso = request.getParameter("fechaIngresoProfesional");

                // Obtener el objeto Profesional del usuario y actualizar los datos
                Profesional profesional = usuario.getProfesional();
                if (profesional == null) {
                    profesional = new Profesional();
                    usuario.setProfesional(profesional); // Si no existe, asignar un nuevo objeto
                }
                profesional.setTituloProfesional(tituloProfesional);
                profesional.setFechaIngresoProfesional(fechaIngreso);

                // Asegurar que el idUsuario también se asigne al objeto profesional
                profesional.setIdUsuario(usuario.getIdUsuario());
            }

            // También puedes agregar aquí bloques para cliente y administrativo si es necesario
            // ...

            // Actualizar el usuario en la base de datos
            interfaz.actualizarUsuario(usuario);

            // Redirigir nuevamente a la lista de usuarios o a alguna página de confirmación
            response.sendRedirect("ListarUsuarios");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}


