<%@page import="modelo.Usuario" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contacto - Prevención Segura</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">


</head>

<body>
	<!-- Navbar -->
	
	<%@ include file='navbar.jsp' %>

	<!-- Main content -->
	
	<div class="container my-5">
        <h1 class="display-4">Usuario creado</h1>
        
        <%
            Usuario nuevoUsuario = (Usuario) request.getAttribute("nuevoUsuario");
            if (nuevoUsuario != null) {
        %>
            <div class="card">
                <div class="card-body">
                     <h5 class="card-title"><%= nuevoUsuario.getNombreUsuario() %></h5>
                    <p class="card-text"><strong>Identificador</strong> <%= nuevoUsuario.getIdUsuario() %></p>
                    <p class="card-text"><strong>Nombre:</strong> <%= nuevoUsuario.getNombreUsuario() %></p>
                </div>
            </div>
        <%
            } else {
        %>
            <div class="alert alert-danger" role="alert">
                No se pudo encontrar el usuario.
            </div>
        <%
            }
        %>
        <a href="CrearUsuario" class="btn btn-primary mt-3">Crear otro usuario</a>
    </div>
		
	<!-- Footer -->
	<%@ include file='footer.jsp'%>

	<!-- Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>