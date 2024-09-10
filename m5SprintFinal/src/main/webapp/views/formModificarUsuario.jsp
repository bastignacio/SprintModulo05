<%@ page import="modelo.Profesional" %>
<%@ page import="modelo.Administrativo" %>
<%@ page import="modelo.Cliente" %>
<%@ page import="modelo.Usuario" %>
<% 
    Usuario usuario = (Usuario) request.getAttribute("usuario"); 
%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<%@ include file='navbar.jsp'%>
	
	<div class="container mt-5">
	
    <h2>Modificar Usuario</h2>

    <!-- Formulario para modificar el usuario -->
    <form action="ActualizarUsuario" method="post">
    
        <input type="hidden" name="idUsuario" value="<%= usuario.getIdUsuario() %>">
			
			<%--  
        	
        	DEBUG: PARA MOSTRAR EL ID ALMACENADO EN LA CLASE ADMINISTRATIVO, DEL OBJETO USUARIO, QUE SE EXTRAJO DE LA DB
        	
       		 <%= usuario.getIdUsuario() %> 
       		 
       		 --%>


			<div class="mb-3">
            <label for="nombreUsuario" class="form-label">Nombre:</label>
            <input type="text" class="form-control" id="nombreUsuario" name="nombreUsuario" value="<%= usuario.getNombreUsuario() %>">
        </div>

        <div class="mb-3">
            <label for="apellidoUsuario" class="form-label">Apellido:</label>
            <input type="text" class="form-control" id="apellidoUsuario" name="apellidoUsuario" value="<%= usuario.getApellidoUsuario() %>">
        </div>

        <div class="mb-3">
            <label for="runUsuario" class="form-label">RUN:</label>
            <input type="text" class="form-control" id="runUsuario" name="runUsuario" value="<%= usuario.getRunUsuario() %>">
        </div>

        <div class="mb-3">
            <label for="correoUsuario" class="form-label">Correo:</label>
            <input type="text" class="form-control" id="correoUsuario" name="correoUsuario" value="<%= usuario.getCorreoUsuario() %>">
        </div>

        <div class="mb-3">
            <label for="telefonoUsuario" class="form-label">Teléfono:</label>
            <input type="text" class="form-control" id="telefonoUsuario" name="telefonoUsuario" value="<%= usuario.getTelefonoUsuario() %>">
        </div>

        <div class="mb-3">
            <label for="tipoUsuario" class="form-label">Tipo Usuario:</label>
            <input type="text" class="form-control" id="tipoUsuario" name="tipoUsuario" value="<%= usuario.getTipoUsuario() %>" style="text-transform:uppercase" readonly>
        </div>

        <!-- Mostrar campos dinámicos según el tipo de usuario -->
        <%
            String tipoUsuario = usuario.getTipoUsuario();

            if ("cliente".equals(tipoUsuario)) {
                Cliente cliente = usuario.getCliente();
        %>
                <!-- Campos específicos para Cliente -->
                <div class="mb-3">
                    <label for="nombreEmpresa" class="form-label">Nombre Empresa:</label>
                    <input type="text" class="form-control" id="nombreEmpresa" name="nombreEmpresa" value="<%= cliente.getNombreEmpresa() %>">
                </div>

                <div class="mb-3">
                    <label for="rutEmpresa" class="form-label">RUT Empresa:</label>
                    <input type="text" class="form-control" id="rutEmpresa" name="rutEmpresa" value="<%= cliente.getRutEmpresa() %>">
                </div>

                <div class="mb-3">
                    <label for="telefonoEmpresa" class="form-label">Teléfono Empresa:</label>
                    <input type="text" class="form-control" id="telefonoEmpresa" name="telefonoEmpresa" value="<%= cliente.getTelefonoEmpresa() %>">
                </div>

                <div class="mb-3">
                    <label for="correoEmpresa" class="form-label">Correo Empresa:</label>
                    <input type="text" class="form-control" id="correoEmpresa" name="correoEmpresa" value="<%= cliente.getCorreoEmpresa() %>">
                </div>

                <div class="mb-3">
                    <label for="direccionEmpresa" class="form-label">Dirección Empresa:</label>
                    <input type="text" class="form-control" id="direccionEmpresa" name="direccionEmpresa" value="<%= cliente.getDireccionEmpresa() %>">
                </div>

                <div class="mb-3">
                    <label for="comunaEmpresa" class="form-label">Comuna Empresa:</label>
                    <input type="text" class="form-control" id="comunaEmpresa" name="comunaEmpresa" value="<%= cliente.getComunaEmpresa() %>">
                </div>

        <%
            } else if ("profesional".equals(tipoUsuario)) {
                Profesional profesional = usuario.getProfesional();
        %>
                <!-- Campos específicos para Profesional -->
                <div class="mb-3">
                    <label for="tituloProfesional" class="form-label">Título Profesional:</label>
                    <input type="text" class="form-control" id="tituloProfesional" name="tituloProfesional" value="<%= profesional.getTituloProfesional() %>">
                </div>

                <div class="mb-3">
                    <label for="fechaIngresoProfesional" class="form-label">Fecha Ingreso:</label>
                    <input type="date" class="form-control" id="fechaIngresoProfesional" name="fechaIngresoProfesional" value="<%= profesional.getFechaIngresoProfesional() %>">
                </div>

        <%
            } else if ("administrativo".equals(tipoUsuario)) {
                Administrativo administrativo = usuario.getAdministrativo();
        %>
                <!-- Campos específicos para Administrativo -->
                <div class="mb-3">
                    <label for="areaAdministrativo" class="form-label">Área Administrativa:</label>
                    <input type="text" class="form-control" id="areaAdministrativo" name="areaAdministrativo" value="<%= administrativo.getAreaAdministrativo() %>">
                </div>

                <div class="mb-3">
                    <label for="experienciaPrevia" class="form-label">Experiencia Previa:</label>
                    <input type="text" class="form-control" id="experienciaPrevia" name="experienciaPrevia" value="<%= administrativo.getExperienciaPrevia() %>">
                </div>
        <%
            }
        %>

        <button type="submit" class="btn btn-success">Guardar cambios</button>
    </form>
    

    </div>
    
        <%@ include file='footer.jsp'%>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    
</body>
</html>
