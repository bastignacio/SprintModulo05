<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<title>Login</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<%@ include file='navbar.jsp'%>

	<div class="contenedorLogin">
		<section class="vh-99 gradient-custom">
			<div class="container py-5">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-8 col-lg-6 col-xl-5">
						<div class="card bg-dark text-white" style="border-radius: 1rem;">
							<div class="card-body p-5 text-center">

								<div class="mb-md-5 mt-md-4 pb-5">

									<h2 class="fw-bold mb-2 text-uppercase">Inicio de sesión</h2>
									<p class="text-white-50 mb-5">Por favor ingresa tu nombre
										de usuario y tu contraseña</p>

									<!-- Formulario de inicio de sesión -->
									<form action="${pageContext.request.contextPath}/Login"
										method="post">
										<div data-mdb-input-init class="form-outline form-white mb-4">
											<input type="text" id="typeEmailX" name="username"
												class="form-control form-control-lg" required /> <label
												class="form-label" id="username">Nombre de usuario</label>

										</div>

										<div data-mdb-input-init class="form-outline form-white mb-4">
											<input type="password" id="typePasswordX" name="password"
												class="form-control form-control-lg" required /> <label
												class="form-label" for="typePasswordX">Contraseña</label>
										</div>

										<p class="small mb-5 pb-lg-2">
											<a class="text-white-50" href="#!">Olvidaste tu contraseña?</a>
										</p>

										<button data-mdb-button-init data-mdb-ripple-init
											class="btn btn-outline-light btn-lg px-5" type="submit">Ingresar</button>
									</form>

									<div
										class="d-flex justify-content-center text-center mt-4 pt-1">
										<a href="#!" class="text-white"><i
											class="fab fa-facebook-f fa-lg"></i></a> <a href="#!"
											class="text-white"><i
											class="fab fa-twitter fa-lg mx-4 px-2"></i></a> <a href="#!"
											class="text-white"><i class="fab fa-google fa-lg"></i></a>
									</div>

								</div>

								<div>
									<p class="mb-0">
										No tienes una cuenta? <a href="#!" class="text-white-50 fw-bold">Regístrate</a>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
