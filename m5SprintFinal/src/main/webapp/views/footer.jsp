<!doctype html>
<html lang="es" data-bs-theme="dark">
<meta charset="utf-8">
<head>
<title>Footer</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">


</head>
<body>
<div class="container-fluid">
	<footer class="py-3 my-4">
		<ul class="nav justify-content-center border-bottom pb-3 mb-3">
			<li class="nav-item"><a href="Index"
				class="nav-link px-2 text-body-secondary">Inicio</a></li>
								<% if (session.getAttribute("username") != null) { %>
			<li class="nav-item"><a href="Contacto"
				class="nav-link px-2 text-body-secondary">Contacto</a></li>
								<!-- BotÃ³n de Logout -->
				<li class="nav-item"><a class="nav-link px-2 text-body-secondary" href="Logout">Logout</a></li>
				
				<% } else { %>
				<li class="nav-item"><a class="nav-link px-2 text-body-secondary" href="Login">Login</a></li>
				<% } %>
		</ul>
		<p class="text-center text-body-secondary">&copy; 2024 Prevención de Riesgos PDR</p>
	</footer>
</div>

</body>
</html>
