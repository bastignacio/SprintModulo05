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
        String nombre = request.getParameter("nombreUsuario");
        String apellido = request.getParameter("apellidoUsuario");
        String run = request.getParameter("runUsuario");
        String correo = request.getParameter("correoUsuario");
        String telefono = request.getParameter("telefonoUsuario");
        String tipoUsuario = request.getParameter("tipoUsuario");

        try {
            // Obtener el usuario por su ID
            Usuario usuario = interfaz.obtenerUsuarioPorId(idUsuario);

            // Actualizar los datos del usuario
            usuario.setNombreUsuario(nombre);
            usuario.setApellidoUsuario(apellido);
            usuario.setRunUsuario(run);
            usuario.setCorreoUsuario(correo);
            usuario.setTelefonoUsuario(telefono);
            usuario.setTipoUsuario(tipoUsuario);

            // Si es cliente, profesional o administrativo, actualiza esos campos también
            if ("cliente".equals(tipoUsuario)) {
                String nombreEmpresa = request.getParameter("nombreEmpresa");
                String rutEmpresa = request.getParameter("rutEmpresa");
                String telefonoEmpresa = request.getParameter("telefonoEmpresa");
                String correoEmpresa = request.getParameter("correoEmpresa");
                String direccionEmpresa = request.getParameter("direccionEmpresa");
                String comunaEmpresa = request.getParameter("comunaEmpresa");

                Cliente cliente = usuario.getCliente(); // Obtener objeto cliente
                cliente.setNombreEmpresa(nombreEmpresa);
                cliente.setRutEmpresa(rutEmpresa);
                cliente.setTelefonoEmpresa(telefonoEmpresa);
                cliente.setCorreoEmpresa(correoEmpresa);
                cliente.setDireccionEmpresa(direccionEmpresa);
                cliente.setComunaEmpresa(comunaEmpresa);
            } else if ("profesional".equals(tipoUsuario)) {
                String tituloProfesional = request.getParameter("tituloProfesional");
                String fechaIngreso = String.valueOf(request.getParameter("fechaIngresoProfesional"));

                Profesional profesional = usuario.getProfesional(); // Obtener objeto profesional
                profesional.setTituloProfesional(tituloProfesional);
                profesional.setFechaIngresoProfesional(fechaIngreso);
            } else if ("administrativo".equals(tipoUsuario)) {
                String areaAdministrativa = request.getParameter("areaAdministrativo");
                String experienciaPrevia = request.getParameter("experienciaPrevia");

                Administrativo administrativo = usuario.getAdministrativo(); // Obtener objeto administrativo
                administrativo.setAreaAdministrativo(areaAdministrativa);
                administrativo.setExperienciaPrevia(experienciaPrevia);
            }

            // Actualizar el usuario en la base de datos
            interfaz.actualizarUsuario(usuario);

            // Redirigir nuevamente a la lista de usuarios
            response.sendRedirect("ListarUsuarios");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}

