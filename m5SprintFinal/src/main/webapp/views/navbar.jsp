<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
</head>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<br>
	<div class="container-fluid">
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

				<% if (session.getAttribute("username") != null) { %>
				<li class="nav-item"><a class="nav-link" href="Contacto">Contacto</a></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"> Crear </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="CrearCapacitacion">Crear Capacitación</a></li>
						<li><a class="dropdown-item" href="CrearUsuario">Crear Usuario</a></li>
						<li><a class="dropdown-item" href="#">Crear Pago</a></li>
						<li><a class="dropdown-item" href="#">Crear Asesorías</a></li>
					</ul></li>
					
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false"> Listar </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="ListarCapacitacion">Listar Capacitación</a></li>
						<li><a class="dropdown-item" href="ListarUsuarios">Listar Usuarios</a></li>
						<li><a class="dropdown-item" href="#">Listar Visitas</a></li>
						<li><a class="dropdown-item" href="#">Listar Pagos</a></li>
						<li><a class="dropdown-item" href="#">Listar Asesorias</a></li>
					</ul></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false"> Editar </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="ListarCapacitacion">Editar Cliente</a></li>
						<li><a class="dropdown-item" href="ListarUsuario">Editar Administrativo</a></li>
						<li><a class="dropdown-item" href="#">Editar Profesional</a></li>
					</ul></li>
					
				<li class="nav-item"><a class="nav-link" aria-current="page" href="#">Administrar Asistentes</a></li>
				<li class="nav-item"><a class="nav-link" aria-current="page" href="#">Gestionar Accidentes</a></li>
				<li class="nav-item"><a class="nav-link" aria-current="page" href="#">Administrar Chequeos</a></li>
				<li class="nav-item"><a class="nav-link" aria-current="page" href="#">Responder Checklist</a></li>
				<li class="nav-item"><a class="nav-link" aria-current="page" href="#">Reportes</a></li>


				<!-- Botón de Logout -->
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a></li>
				
				<% } else { %>
				<li class="nav-item"><a class="nav-link" href="Login">Login</a></li>
				<% } %>


			</ul>
		</div>
	</div>
</nav>

</html>