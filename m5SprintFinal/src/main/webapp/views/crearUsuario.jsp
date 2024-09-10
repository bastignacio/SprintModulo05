<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Crear Usuario - Prevención Segura</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>

	<!-- Navbar -->
	<%@ include file='navbar.jsp'%>

	<!-- Main content -->
	<div class="container my-5">
	
		<div class="row justify-content-center">
			<div class="col-md-6 text-center">
				<h1 class="display-4">Crear Nuevo Usuario</h1>
				<br>
				<p class="lead">Utiliza el formulario a continuación para
					registrar un nuevo usuario para tu equipo. Asegúrate de completar
					todos los campos requeridos.</p>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6">
					<form action="CrearUsuario" method="post" id="userForm" novalidate>
						<!-- Nombre de usuario -->
						<div class="form-group mb-3">
							<label for="nombreUsuario">Nombre del Usuario:</label> <input
								type="text" class="form-control" id="nombreUsuario"
								name="nombreUsuario" placeholder="Ingrese el nombre del usuario"
								required>
							<div class="invalid-feedback">Por favor, ingrese el nombre
								del usuario.</div>

							<label for="apellidoUsuario" style="margin-top: 15px">Apellido
								del Usuario:</label> <input type="text" class="form-control"
								id="apellidoUsuario" name="apellidoUsuario"
								placeholder="Ingrese el apellido del usuario" required>
							<div class="invalid-feedback">Por favor, ingrese el
								apellido del usuario.</div>

							<label for="runUsuario" style="margin-top: 15px">RUN del
								Usuario:</label> <input type="text" class="form-control" id="runUsuario"
								name="runUsuario" placeholder="Ingrese el RUN del usuario"
								required>
							<div class="invalid-feedback">Por favor, ingrese el RUN del
								usuario.</div>

							<label for="correoUsuario" style="margin-top: 15px">Correo
								del Usuario:</label> <input type="text" class="form-control"
								id="correoUsuario" name="correoUsuario"
								placeholder="Ingrese el correo del usuario" required>
							<div class="invalid-feedback">Por favor, ingrese el correo
								del usuario.</div>

							<label for="telefonoUsuario" style="margin-top: 15px">Telefono
								del Usuario:</label> <input type="text" class="form-control"
								id="telefonoUsuario" name="telefonoUsuario"
								placeholder="Ingrese el teléfono del usuario" required>
							<div class="invalid-feedback">Por favor, ingrese el
								teléfono del usuario.</div>
						</div>

						<!-- Tipo de usuario -->
						<div class="form-group">
							<label for="userType">Tipo de Usuario:</label> <select
								class="form-control" id="userType" name="userType" required>
								<option value="" selected disabled>Seleccione el tipo
									de usuario</option>
								<option value="cliente">Cliente</option>
								<option value="administrativo">Administrativo</option>
								<option value="profesional">Profesional</option>
							</select>
							<div class="invalid-feedback">Por favor, seleccione un tipo
								de usuario.</div>
						</div>

						<div id="clienteFields" class="d-none">
							<div class="mb-3">
								<label for="rut" class="form-label">Rut:</label> <input
									type="number" class="form-control" id="rutEmpresa"
									name="rutEmpresa" placeholder="Ingrese el RUT de la empresa">
								<div class="invalid-feedback">Por favor, ingrese el Rut
									válido</div>
							</div>
							<div class="mb-3">
								<label for="nombre" class="form-label">Nombre:</label> <input
									type="text" class="form-control" id="nombreEmpresa"
									name="nombreEmpresa"
									placeholder="Ingrese el Nombre de la Empresa">
								<div class="invalid-feedback">Por favor, ingrese el nombre
									válido</div>
							</div>
							<div class="mb-3">
								<label for="apellido" class="form-label">Teléfono:</label> <input
									type="text" class="form-control" id="telefonoEmpresa"
									name="telefonoEmpresa"
									placeholder="Ingrese el Teléfono de la Empresa">
								<div class="invalid-feedback">Por favor, ingrese un
									teléfono válido.</div>
							</div>
							<div class="mb-3">
								<label for="correo" class="form-label">Correo:</label> <input
									type="email" class="form-control" id="correoEmpresa"
									name="correoEmpresa"
									placeholder="Ingrese el Correo Electrónico de la Empresa">
								<div class="invalid-feedback">Por favor, ingrese un correo
									válido.</div>
							</div>
							<div class="mb-3">
								<label for="telefono" class="form-label">Dirección:</label> <input
									type="text" class="form-control" id="direccionEmpresa"
									name="direccionEmpresa"
									placeholder="Ingrese la Dirección de la Empresa">
								<div class="invalid-feedback">Por favor, ingrese una
									dirección válida.</div>
							</div>
							<div class="mb-3">
								<label for="direccion" class="form-label">Comuna:</label> <input
									type="text" class="form-control" id="comunaEmpresa"
									name="comunaEmpresa"
									placeholder="Ingrese la comuna de la empresa">
								<div class="invalid-feedback">Por favor, ingrese una
									comuna válida</div>
							</div>

						</div>

						<!-- Campos adicionales para Administrativo -->
						<div id="administrativoFields" class="d-none">
							<div class="form-group">
								<label for="area">Área:</label> <input type="text"
									class="form-control" id="areaAdministrativo"
									name="areaAdministrativo" placeholder="Ingrese el área">
								<div class="invalid-feedback">Por favor, ingrese el área.</div>
							</div>
							<div class="form-group">
								<label for="experiencia">Años de Experiencia:</label> <input
									type="number" class="form-control" id="experienciaPrevia"
									name="experienciaPrevia"
									placeholder="Ingrese los años de experiencia">
								<div class="invalid-feedback">Por favor, ingrese los años
									de experiencia.</div>
							</div>
						</div>

						<!-- Campos adicionales para Profesional -->
						<div id="profesionalFields" class="d-none">
							<div class="form-group">
								<label for="titulo">Título:</label> <input type="text"
									class="form-control" id="tituloProfesional"
									name="tituloProfesional" placeholder="Ingrese el título">
								<div class="invalid-feedback">Por favor, ingrese el
									título.</div>
							</div>
							<div class="form-group">
								<label for="fechaIngreso">Fecha de Ingreso:</label> <input
									type="date" class="form-control" id="fechaIngresoProfesional"
									name="fechaIngresoProfesional">
								<div class="invalid-feedback">Por favor, ingrese la fecha
									de ingreso.</div>
							</div>
						</div>
						
						<br>
						
<!-- 						<div id="successAlert" class="alert alert-success d-none fade show" role="alert">
       					     Usuario registrado exitosamente.
     				   </div> -->
						
						<!-- Botón de envío -->
						<button type="submit" class="btn btn-primary"
							style="margin-top: 15px">Crear Usuario</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<%@ include file='footer.jsp'%>

	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/m5SprintFinal/js/script.js"></script>

</body>
</html>
