<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contacto - Prevención Segura</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<!-- Navbar -->
	<%@ include file='navbar.jsp'%>

	<!-- Contenido principal -->
	<div
		class="container-fluid d-flex justify-content-center align-items-center min-vh-50">
		<div class="col-md-6 col-lg-4">
			<h1>Contáctanos</h1>
			<p>Estamos aquí para ayudarte. Si tienes alguna pregunta o deseas
				más información sobre nuestros servicios, por favor, llena el
				siguiente formulario y nos pondremos en contacto contigo lo antes
				posible.</p>

			<!-- Formulario de contacto -->
			<form class="mt-4" method="post"
				action="${pageContext.request.contextPath}/Contacto">
				<div class="mb-3">
					<label for="email" class="form-label">Correo electrónico</label> <input
						type="email" class="form-control" id="email" name="email"
						placeholder="nombre@ejemplo.com" required autofocus>
				</div>

				<div class="mb-3">
					<label for="name" class="form-label">Nombre</label> <input
						type="text" class="form-control" id="nombre" name="nombre"
						placeholder="Ingrese su nombre completo" required>
				</div>

				<div class="mb-3">
					<label for="asunto" class="form-label">Asunto</label> <input
						type="text" class="form-control" name="asunto" id="asunto"
						placeholder="Ingrese el asunto" required>
				</div>

				<div class="mb-3">
					<label for="message" class="form-label">Mensaje</label>
					<textarea id="mensaje" name="mensaje" class="form-control"
						placeholder="Ingrese su mensaje" rows="5" required></textarea>
				</div>

				<div>
					<button type="submit" class="btn btn-outline-light btn-lg px-10">Enviar
						mensaje</button>
				</div>
			</form>
		</div>
	</div>
<!-- 	Verificación de éxito y error al rellenar el formulario -->
	<br>
	<%
	if (request.getAttribute("error") != null) {
	%>
	<div class="alert alert-danger" role="alert">
		<div
			class="col-md-12 d-flex justify-content-center align-items-center">
			<%=request.getAttribute("error")%>
		</div>
	</div>
	<%
	}
	%>

	<%
	if (request.getAttribute("success") != null) {
	%>
	<div class="alert alert-success" role="alert">
		<div
			class="col-md-12 d-flex justify-content-center align-items-center">
			<%=request.getAttribute("success")%>
		</div>
	</div>
	<%
	}
	%>

	<!-- Footer -->
	<%@ include file='footer.jsp'%>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
