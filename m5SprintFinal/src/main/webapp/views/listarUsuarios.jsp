<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="es">
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
                        <c:choose>
                            <c:when test="${param.tipoUsuario == 'cliente'}">
                                <th>Nombre Empresa</th>
                                <th>Rut Empresa</th>
                                <th>Teléfono Empresa</th>
                                <th>Correo Empresa</th>
                                <th>Dirección Empresa</th>
                                <th>Comuna Empresa</th>
                            </c:when>
                            <c:when test="${param.tipoUsuario == 'profesional'}">
                                <th>Título Profesional</th>
                                <th>Fecha Ingreso</th>
                            </c:when>
                            <c:when test="${param.tipoUsuario == 'administrativo'}">
                                <th>Área Administrativo</th>
                                <th>Experiencia Previa</th>
                            </c:when>
                        </c:choose>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="usuario" items="${usuarios}">
                        <tr>
                            <td>${usuario.idUsuario}</td>
                            <td>${usuario.nombreUsuario}</td>
                            <td>${usuario.apellidoUsuario}</td>
                            <td>${usuario.runUsuario}</td>
                            <td>${usuario.correoUsuario}</td>
                            <td>${usuario.telefonoUsuario}</td>
                            <td>${usuario.tipoUsuario}</td>
                            <c:choose>
                                <!-- Mostrar columnas de Cliente -->
                                <c:when test="${usuario.tipoUsuario == 'cliente'}">
                                    <td>${usuario.cliente.nombreEmpresa}</td>
                                    <td>${usuario.cliente.rutEmpresa}</td>
                                    <td>${usuario.cliente.telefonoEmpresa}</td>
                                    <td>${usuario.cliente.correoEmpresa}</td>
                                    <td>${usuario.cliente.direccionEmpresa}</td>
                                    <td>${usuario.cliente.comunaEmpresa}</td>
                                </c:when>

                                <!-- Mostrar columnas de Profesional -->
                                <c:when test="${usuario.tipoUsuario == 'profesional'}">
                                    <td>${usuario.profesional.tituloProfesional}</td>
                                    <td>${usuario.profesional.fechaIngresoProfesional}</td>
                                </c:when>

                                <!-- Mostrar columnas de Administrativo -->
                                <c:when test="${usuario.tipoUsuario == 'administrativo'}">
                                    <td>${usuario.administrativo.areaAdministrativo}</td>
                                    <td>${usuario.administrativo.experienciaPrevia}</td>
                                </c:when>
                            </c:choose>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
