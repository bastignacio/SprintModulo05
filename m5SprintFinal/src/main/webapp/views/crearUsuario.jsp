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
		<div class="row">
			<div class="col-md-6">
				<h1 class="display-4">Crear Nuevo Usuario</h1>
				<p class="lead">Utiliza el formulario a continuación para
					registrar un nuevo usuario para tu equipo. Asegúrate de completar
					todos los campos requeridos.</p>
			</div><form id="userForm" novalidate>
                <!-- Nombre de usuario -->
                <div class="form-group">
                    <label for="username">Nombre de Usuario:</label>
                    <input type="text" class="form-control" id="username" placeholder="Ingrese el nombre de usuario" required>
                    <div class="invalid-feedback">Por favor, ingrese el nombre de usuario.</div>
                </div>
    
                <!-- Tipo de usuario -->
                <div class="form-group">
                    <label for="userType">Tipo de Usuario:</label>
                    <select class="form-control" id="userType" required>
                        <option value="" selected disabled>Seleccione el tipo de usuario</option>
                        <option value="cliente">Cliente</option>
                        <option value="administrativo">Administrativo</option>
                        <option value="profesional">Profesional</option>
                    </select>
                    <div class="invalid-feedback">Por favor, seleccione un tipo de usuario.</div>
                </div>
    
                <div id="clienteFields" class="d-none">
                    <div class="mb-3">
                        <label for="rut" class="form-label">Rut:</label>
                        <input type="number" class="form-control" id="rut" placeholder="Ingrese el Rut">
                        <div class="invalid-feedback">Por favor, ingrese el Rut.</div>
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" placeholder="Ingrese el nombre">
                        <div class="invalid-feedback">Por favor, ingrese el nombre.</div>
                    </div>
                    <div class="mb-3">
                        <label for="apellido" class="form-label">Apellido:</label>
                        <input type="text" class="form-control" id="apellido" placeholder="Ingrese el apellido">
                        <div class="invalid-feedback">Por favor, ingrese el apellido.</div>
                    </div>
                    <div class="mb-3">
                        <label for="correo" class="form-label">Correo:</label>
                        <input type="email" class="form-control" id="correo" placeholder="Ingrese el correo electrónico">
                        <div class="invalid-feedback">Por favor, ingrese un correo válido.</div>
                    </div>
                    <div class="mb-3">
                        <label for="telefono" class="form-label">Teléfono:</label>
                        <input type="number" class="form-control" id="telefono" placeholder="Ingrese el teléfono">
                        <div class="invalid-feedback">Por favor, ingrese el teléfono.</div>
                    </div>
                    <div class="mb-3">
                        <label for="direccion" class="form-label">Dirección:</label>
                        <input type="text" class="form-control" id="direccion" placeholder="Ingrese la dirección">
                        <div class="invalid-feedback">Por favor, ingrese la dirección.</div>
                    </div>
                    <div class="mb-3">
                        <label for="comuna" class="form-label">Comuna:</label>
                        <input type="text" class="form-control" id="comuna" placeholder="Ingrese la comuna">
                        <div class="invalid-feedback">Por favor, ingrese la comuna.</div>
                    </div>
                </div>
    
                <!-- Campos adicionales para Administrativo -->
                <div id="administrativoFields" class="d-none">
                    <div class="form-group">
                        <label for="area">Área:</label>
                        <input type="text" class="form-control" id="area" placeholder="Ingrese el área">
                        <div class="invalid-feedback">Por favor, ingrese el área.</div>
                    </div>
                    <div class="form-group">
                        <label for="experiencia">Años de Experiencia:</label>
                        <input type="number" class="form-control" id="experiencia" placeholder="Ingrese los años de experiencia">
                        <div class="invalid-feedback">Por favor, ingrese los años de experiencia.</div>
                    </div>
                </div>
    
                <!-- Campos adicionales para Profesional -->
                <div id="profesionalFields" class="d-none">
                    <div class="form-group">
                        <label for="titulo">Título:</label>
                        <input type="text" class="form-control" id="titulo" placeholder="Ingrese el título">
                        <div class="invalid-feedback">Por favor, ingrese el título.</div>
                    </div>
                    <div class="form-group">
                        <label for="fechaIngreso">Fecha de Ingreso:</label>
                        <input type="date" class="form-control" id="fechaIngreso">
                        <div class="invalid-feedback">Por favor, ingrese la fecha de ingreso.</div>
                    </div>
                </div>
    
                <!-- Botón de envío -->
                <button type="submit" class="btn btn-primary">Crear Usuario</button>
            </form>
        </div>
	</div>

	<!-- Footer -->
	<%@ include file='footer.jsp'%>

	<!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>