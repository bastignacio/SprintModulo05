<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="auto">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
<!-- 			<button onclick="cambiarTema()" class="btn rounded-fill">
				<i id="dl-icon" class="bi bi-moon-fill"></i>
			</button> -->
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

					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownCrear" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">Crear</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownCrear">
							<li><a class="dropdown-item" href="CrearCapacitacion">Crear Capacitación</a></li>
							<li><a class="dropdown-item" href="CrearUsuario">Crear Usuario</a></li>
						</ul>
					</li>

					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownListar" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">Listar</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownListar">
							<li><a class="dropdown-item" href="ListarCapacitacion">Listar Capacitación</a></li>
							<li><a class="dropdown-item" href="ListarUsuarios">Listar Usuarios</a></li>
						</ul>
					</li>

					<!-- Botón de Logout -->
					<li class="nav-item"><a class="nav-link" href="Logout">Logout</a></li>
					
					<li class="nav-item invisible-item">
    					<a class="nav-link" href="#">......</a>
					</li>
					

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

	<!-- Asegúrate de incluir los scripts en el orden correcto -->

</body>
</html>
