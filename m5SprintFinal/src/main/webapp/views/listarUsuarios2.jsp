<%@page import="modelo.Usuario"%>
<%@ page import="java.util.List"%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Usuarios</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="width: 100vw; height: 100vh;">
    <div class="container-fluid mt-4">
        <h2 class="mb-4">Listado de Usuarios</h2>

        <!-- Filtro para seleccionar el tipo de usuario -->
        <div class="row mb-3">
            <div class="col-md-4">
                <label for="tipoUsuario" class="form-label">Filtrar por tipo de usuario</label>
                <select id="tipoUsuario" class="form-select">
                    <option value="todos">Todos</option>
                    <option value="cliente">Cliente</option>
                    <option value="profesional">Profesional</option>
                    <option value="administrativo">Administrativo</option>
                </select>
            </div>
        </div>

        <!-- Tabla con los usuarios -->
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>RUN</th>
                        <th>Correo</th>
                        <th>Teléfono</th>
                        <th>Tipo Usuario</th>
                        <th id="dynamic-columns"></th> <!-- Aquí se añadirán dinámicamente las columnas -->
                    </tr>
                </thead>
                <tbody id="tablaUsuarios">
                    <% 
                        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                        if (usuarios != null) {
                            for (Usuario usuario : usuarios) {
                    %>
                    <tr class="usuario" data-tipo="<%= usuario.getTipoUsuario() %>">
                        <td><%= usuario.getIdUsuario() %></td>
                        <td><%= usuario.getNombreUsuario() %></td>
                        <td><%= usuario.getApellidoUsuario() %></td>
                        <td><%= usuario.getRunUsuario() %></td>
                        <td><%= usuario.getCorreoUsuario() %></td>
                        <td><%= usuario.getTelefonoUsuario() %></td>
                        <td><%= usuario.getTipoUsuario() %></td>
                        <!-- Columnas dinámicas para Cliente -->
                        <td class="detalles-cliente" style="display:none;">
                            <% if ("cliente".equals(usuario.getTipoUsuario())) { %>
                                <%= usuario.getCliente().getNombreEmpresa() != null ? usuario.getCliente().getNombreEmpresa() : "" %>
                            <% } %>
                        </td>
                        <td class="detalles-cliente" style="display:none;">
                            <% if ("cliente".equals(usuario.getTipoUsuario())) { %>
                                <%= usuario.getCliente().getRutEmpresa() != null ? usuario.getCliente().getRutEmpresa() : "" %>
                            <% } %>
                        </td>
                        <td class="detalles-cliente" style="display:none;">
                            <% if ("cliente".equals(usuario.getTipoUsuario())) { %>
                                <%= usuario.getCliente().getTelefonoEmpresa() != null ? usuario.getCliente().getTelefonoEmpresa() : "" %>
                            <% } %>
                        </td>
                        <td class="detalles-cliente" style="display:none;">
                            <% if ("cliente".equals(usuario.getTipoUsuario())) { %>
                                <%= usuario.getCliente().getCorreoEmpresa() != null ? usuario.getCliente().getCorreoEmpresa() : "" %>
                            <% } %>
                        </td>
                        <td class="detalles-cliente" style="display:none;">
                            <% if ("cliente".equals(usuario.getTipoUsuario())) { %>
                                <%= usuario.getCliente().getDireccionEmpresa() != null ? usuario.getCliente().getDireccionEmpresa() : "" %>
                            <% } %>
                        </td>
                        <td class="detalles-cliente" style="display:none;">
                            <% if ("cliente".equals(usuario.getTipoUsuario())) { %>
                                <%= usuario.getCliente().getComunaEmpresa() != null ? usuario.getCliente().getComunaEmpresa() : "" %>
                            <% } %>
                        </td>
                    </tr>
                    <% 
                            }
                        } 
                    %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Script para modificar las columnas dinámicamente -->
    <script>
        document.getElementById('tipoUsuario').addEventListener('change', function() {
            var tipoSeleccionado = this.value;
            var filas = document.querySelectorAll('.usuario');
            var dynamicColumns = document.getElementById('dynamic-columns');
            
            // Limpiar las columnas dinámicas
            dynamicColumns.innerHTML = '';

            filas.forEach(function(fila) {
                var tipoUsuario = fila.getAttribute('data-tipo');
                var detallesCliente = fila.querySelectorAll('.detalles-cliente');

                // Mostrar/ocultar filas según el tipo seleccionado
                if (tipoSeleccionado === 'todos' || tipoUsuario === tipoSeleccionado) {
                    fila.style.display = '';
                } else {
                    fila.style.display = 'none';
                }

                // Mostrar los detalles adicionales según el tipo seleccionado
                if (tipoSeleccionado === 'cliente' && tipoUsuario === 'cliente') {
                    dynamicColumns.innerHTML = `
                        <th>Nombre Empresa</th>
                        <th>Rut Empresa</th>
                        <th>Teléfono Empresa</th>
                        <th>Correo Empresa</th>
                        <th>Dirección Empresa</th>
                        <th>Comuna Empresa</th>
                    `;
                    detallesCliente.forEach(function(detalle) {
                        detalle.style.display = '';
                    });
                } else {
                    detallesCliente.forEach(function(detalle) {
                        detalle.style.display = 'none';
                    });
                }
            });
        });
    </script>
</body>
</html>




