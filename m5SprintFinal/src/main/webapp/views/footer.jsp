<!doctype html>
<html lang="es" data-bs-theme="dark">
<meta charset="utf-8">
  <head><script src="/docs/5.3/assets/js/color-modes.js"></script>
<title>Footer</title>

<body>
<div class="container">
	<footer class="py-3 my-4">
		<ul class="nav justify-content-center border-bottom pb-3 mb-3">
			<li class="nav-item"><a href="Index"
				class="nav-link px-2 text-body-secondary">Inicio</a></li>
								<% if (session.getAttribute("username") != null) { %>
			<li class="nav-item"><a href="Contacto"
				class="nav-link px-2 text-body-secondary">Contacto</a></li>
								<!-- Botón de Logout -->
				<li class="nav-item"><a class="nav-link px-2 text-body-secondary" href="${pageContext.request.contextPath}/logout">Logout</a></li>
				
				<% } else { %>
				<li class="nav-item"><a class="nav-link px-2 text-body-secondary" href="Login">Login</a></li>
				<% } %>
		</ul>
		<p class="text-center text-body-secondary">&copy; 2024 Prevención
			de Riesgos PDR</p>
	</footer>
</div>
<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>
