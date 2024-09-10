<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="auto">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
 
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
        <button onclick="cambiarTema()" class="btn rounded-fill"><i id="dl-icon" class="bi bi-moon-fill"></i></button>
		<a class="navbar-brand" href="Index">Prevención Segura</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ms-auto">
 
				<li class="nav-item"><a class="nav-link" aria-current="page"
					href="Index">Inicio</a></li>
 
				<%
				if (session.getAttribute("username") != null) {
				%>
				<li class="nav-item"><a class="nav-link" href="Contacto">Contacto</a></li>
 
 
 
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Crear </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="CrearCapacitacion">Crear
								Capacitación</a></li>
						<li><a class="dropdown-item" href="CrearUsuario">Crear
								Usuario</a></li>
					</ul></li>
 
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						Listar </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="ListarCapacitacion">Listar
								Capacitación</a></li>
						<li><a class="dropdown-item" href="ListarUsuarios">Listar
								Usuarios</a></li>
					</ul></li>
 
				<!-- Botón de Logout -->
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/logout">Logout</a></li>
 
 
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="Login">Login</a></li>
				<%
				}
				%>
 
 
			</ul>
		</div>
	</div>
</nav>
 
<script src="${pageContext.request.contextPath}/js/navbar.js"></script>
<script src=https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js></script>
</html>