<%@ page import="java.util.List"%>
<%@ page import="modelo.Capacitacion"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
      
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Nueva Capacitación</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body data-bs-theme="dark">

<%@ include file='navbar.jsp'%>  <!-- Incluir el navbar -->

<div class="container mt-5">
    <div class="row">
        <div class="col-md-8 offset-md-2">
            <h1 class="text-center mb-4">Crear Nueva Capacitación</h1>
            <p class="lead text-center">
                Utiliza el formulario a continuación para registrar una capacitación para tu equipo.
                Asegúrate de completar todos los campos requeridos.
            </p>

            <div class="card shadow-sm p-4">
                <form action="CrearCapacitacion" method="post">
                    <div class="mb-3">
                        <label for="nombreCapacitacion" class="form-label">Nombre de la Capacitación</label>
                        <input type="text" class="form-control" id="nombreCapacitacion" name="nombreCapacitacion" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="detalleCapacitacion" class="form-label">Detalle de la Capacitación</label>
                        <input type="text" class="form-control" id="detalleCapacitacion" name="detalleCapacitacion" required>
                    </div>
                    
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary mt-3">Crear</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

    <%@ include file='footer.jsp'%>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

