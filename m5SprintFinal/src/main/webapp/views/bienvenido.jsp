<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prevención de Riesgos PDR</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">


</head>

<style>
/* Estilos básicos */
.card {

color:black;
background: #bac1b5;
border-color: black;
border-radius: 30px;

}

</style>



<body>

	<%@ include file='navbar.jsp'%>


	<div class="container d-flex justify-content-center align-items-center">
		<div class="card text-center p-5">
			<%
        String username = "";
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (javax.servlet.http.Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    username = cookie.getValue();
                    break;
                }
            }
        }
        %>
			<h1 class="display-4">
				¡Bienvenido,
				<%= username %>!
			</h1>
			<p class="lead">Has iniciado sesión exitosamente.</p>
			<a href="${pageContext.request.contextPath}/Logout"
				class="btn btn-light mt-2">Cerrar sesión</a>
		</div>
	</div>




	<%@ include file='footer.jsp'%>
</body>
</html>
