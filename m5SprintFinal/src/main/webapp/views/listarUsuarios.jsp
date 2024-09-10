<%@ page import="java.util.List" %>
<%@ page import="modelo.Usuario" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Usuarios</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <h2 class="mb-4">Listado de Usuarios</h2>

    <!-- Filtro para seleccionar el tipo de usuario -->
    <form method="get" class="mb-4">
        <label for="tipoUsuario" class="form-label">Filtrar por tipo de usuario:</label>
        <select id="tipoUsuario" name="tipoUsuario" class="form-select" onchange="this.form.submit()">
            <option value="cliente" <%= "cliente".equals(request.getParameter("tipoUsuario")) ? "selected" : "" %>>Cliente</option>
            <option value="profesional" <%= "profesional".equals(request.getParameter("tipoUsuario")) ? "selected" : "" %>>Profesional</option>
            <option value="administrativo" <%= "administrativo".equals(request.getParameter("tipoUsuario")) ? "selected" : "" %>>Administrativo</option>
        </select>
    </form>

    <!-- Tabla con los usuarios -->
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>RUN</th>
                <th>Correo</th>
                <th>Teléfono</th>
                <th>Tipo Usuario</th>
                <!-- Mostrar encabezados adicionales según el tipo de usuario -->
                <%
                    String tipoUsuario = request.getParameter("tipoUsuario");
                    if ("cliente".equals(tipoUsuario)) {
                %>
                    <th>Nombre Empresa</th>
                    <th>Rut Empresa</th>
                    <th>Teléfono Empresa</th>
                    <th>Correo Empresa</th>
                    <th>Dirección Empresa</th>
                    <th>Comuna Empresa</th>
                <%
                    } else if ("profesional".equals(tipoUsuario)) {
                %>
                    <th>Título Profesional</th>
                    <th>Fecha Ingreso</th>
                <%
                    } else if ("administrativo".equals(tipoUsuario)) {
                %>
                    <th>Área Administrativo</th>
                    <th>Experiencia Previa</th>
                <%
                    }
                %>
                <th>Acciones</th> <!-- Columna para el botón de modificar -->
            </tr>
        </thead>
        <tbody>
            <%
                List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                if (usuarios != null) {
                    for (Usuario usuario : usuarios) {
                        if (usuario.getTipoUsuario().equals(tipoUsuario)) {
            %>
                        <tr>
                            <td><%= usuario.getIdUsuario() %></td>
                            <td><%= usuario.getNombreUsuario() %></td>
                            <td><%= usuario.getApellidoUsuario() %></td>
                            <td><%= usuario.getRunUsuario() %></td>
                            <td><%= usuario.getCorreoUsuario() %></td>
                            <td><%= usuario.getTelefonoUsuario() %></td>
                            <td><%= usuario.getTipoUsuario() %></td>
                            <!-- Mostrar datos adicionales según tipo de usuario -->
                            <%
                                if ("cliente".equals(usuario.getTipoUsuario())) {
                            %>
                                <td><%= usuario.getCliente().getNombreEmpresa() %></td>
                                <td><%= usuario.getCliente().getRutEmpresa() %></td>
                                <td><%= usuario.getCliente().getTelefonoEmpresa() %></td>
                                <td><%= usuario.getCliente().getCorreoEmpresa() %></td>
                                <td><%= usuario.getCliente().getDireccionEmpresa() %></td>
                                <td><%= usuario.getCliente().getComunaEmpresa() %></td>
                            <%
                                } else if ("profesional".equals(usuario.getTipoUsuario())) {
                            %>
                                <td><%= usuario.getProfesional().getTituloProfesional() %></td>
                                <td><%= usuario.getProfesional().getFechaIngresoProfesional() %></td>
                            <%
                                } else if ("administrativo".equals(usuario.getTipoUsuario())) {
                            %>
                                <td><%= usuario.getAdministrativo().getAreaAdministrativo() %></td>
                                <td><%= usuario.getAdministrativo().getExperienciaPrevia() %></td>
                            <%
                                }
                            %>
                            <!-- Botón de modificar -->
                            <td>
                                <form action="ModificarUsuario" method="get">
                                    <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">
                                    <button type="submit" class="btn btn-warning">Modificar</button>
                                </form>
                            </td>
                        </tr>
            <%
                        }
                    }
                }
            %>
        </tbody>
    </table>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>


