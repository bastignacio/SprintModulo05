<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Prevención de Riesgos PDR</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">


</head>

<body data-bs-theme="dark">


	<!-- Se agrega el navbar creado en otro archivo jsp para poder trabajar de forma modular -->
	<%@ include file='navbar.jsp'%>

	<!-- Container con estilo m (margin) y (arriba y abajo) de tamaño 5.  -->
	<div class="container my-5">

		<br>
		<div class="row">
			<div class="col-md-6">
				<h1 class="display-3">Bienvenido a Prevención Segura</h1>
				<p class="lead">En Prevención Segura, nos especializamos en
					identificar y mitigar los riesgos laborales para garantizar la
					seguridad y bienestar de su equipo.</p>
				<p>Nuestra misión es ofrecer soluciones efectivas que protejan a
					su organización, cumpliendo con todas las normativas vigentes y
					promoviendo un ambiente de trabajo seguro.</p>
				<a href="#" class="btn btn-outline-light btn-lg px-5">Conoce más</a>
			</div>
			<div class="col-md-6">
				<img
					src="${pageContext.request.contextPath}/img/Prevencionistas.png"
					alt="Prevención Segura" class="img-fluid">

			</div>
		</div>
	</div>

	<!-- Footer -->
	<%@ include file='footer.jsp'%>
	<!-- Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
