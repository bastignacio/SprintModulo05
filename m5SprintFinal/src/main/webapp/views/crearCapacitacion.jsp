<%@ page import="java.util.List"%>
<%@ page import="modelo.Capacitacion"%>
<%@ page import="modelo.Cliente"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Crear Nueva Capacitación</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<!-- Navbar o cualquier otra parte de tu página -->
	<%@ include file='navbar.jsp'%>

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-6 col-md-8">
				<h2 class="text-center mb-4">Crear Nueva Capacitación</h2>
				<p class="text-center">Utiliza el formulario a continuación para
					registrar una capacitación para tu equipo. Asegúrate de completar
					todos los campos requeridos.</p>

				<!-- Formulario para crear la capacitación -->
				<form action="CrearCapacitacion" method="post">
					<div class="mb-3">
						<label for="nombreCapacitacion" class="form-label">Nombre
							de la Capacitación</label> <input type="text" class="form-control"
							id="nombreCapacitacion" name="nombreCapacitacion" required>
					</div>

					<div class="mb-3">
						<label for="detalleCapacitacion" class="form-label">Detalle
							de la Capacitación</label>
						<textarea class="form-control" id="detalleCapacitacion"
							name="detalleCapacitacion" rows="3" required></textarea>
					</div>

					<div class="mb-3">
						<label for="rutEmpresa" class="form-label">RUT de la
							Empresa</label> <select class="form-select" id="rutEmpresa"
							name="rutEmpresa" required>
							<option value="">Seleccione una empresa...</option>
							<%
							// Aquí es donde iteras sobre las empresas sin JSTL
							List<Cliente> empresas = (List<Cliente>) request.getAttribute("empresas");
							if (empresas != null) {
								for (Cliente empresa : empresas) {
							%>
							<option value="<%=empresa.getRutEmpresa()%>"><%=empresa.getNombreEmpresa()%></option>
							<%
							}
							}
							%>
						</select>
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary mt-3">Crear</button>
					</div>
				</form>
			</div>
		</div>
	</div>
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


	<!-- Footer o cualquier otra parte de tu página -->
	<%@ include file='footer.jsp'%>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>


