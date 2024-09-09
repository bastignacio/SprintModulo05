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
		<div class="row">
			<div class="col-md-6">
				<h1 class="display-4">Contáctanos</h1>
				<p class="lead">Estamos aquí para ayudarte. Si tienes alguna
					pregunta o deseas más información sobre nuestros servicios, por
					favor, llena el siguiente formulario y nos pondremos en contacto
					contigo lo antes posible.</p>
			</div>
			<div class="col-md-6">
				<form>
					<div class="mb-3">
						<label for="name" class="form-label">Nombre</label> <input
							type="text" class="form-control" id="name"
							placeholder="Tu nombre completo">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Correo electrónico</label> <input
							type="email" class="form-control" id="email"
							placeholder="nombre@ejemplo.com">
					</div>
					<div class="mb-3">
						<label for="subject" class="form-label">Asunto</label> <input
							type="text" class="form-control" id="subject"
							placeholder="Motivo de tu mensaje">
					</div>
					<div class="mb-3">
						<label for="message" class="form-label">Mensaje</label>
						<textarea class="form-control" id="message" rows="4"
							placeholder="Escribe tu mensaje aquí"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Enviar</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<%@ include file='footer.jsp'%>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>