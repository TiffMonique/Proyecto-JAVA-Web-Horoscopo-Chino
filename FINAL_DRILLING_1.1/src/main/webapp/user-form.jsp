<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Agregar Usuario</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
	crossorigin="anonymous"></script>
<link href="css/estilos.css" rel="stylesheet" type="text/css">
<link href="css/estiloAreaPrivada.css" rel="stylesheet" type="text/css">


</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-light"
		style="background-color: #92badd;">
		<a class="navbar-brand" href="#">Horóscopo Chino</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="#">Tu
						Horóscopo Chino</a></li>


			</ul>
		</div>



		<div class="dropdown">

			<a style="color: black" href="#" class="nav-link dropdown-toggle"
				data-toggle="dropdown">Logout</a>
			<div class="dropdown-menu text-center">
				<a><img src="img/usuario.png" height="70" width="70"></a><br>
				<a>${nombre}</a>
				<div class="dropdown-divider"></div>
				<a href="Deslogueo" class="dropdown-item">Logout</a>

			</div>
		</div>
	</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${usuarios != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${usuarios == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${usuarios != null}">
            			Editar Usuarios
            		</c:if>
						<c:if test="${usuarios == null}">
            			Agregar nuevo Usuario
            		</c:if>
					</h2>
				</caption>

				<c:if test="${usarios != null}">
					<input type="hidden" name="id" value="<c:out value='${usuarios.id}' />" />
				</c:if>
	 
				<fieldset class="form-group">
					<label>Nombre</label> <input type="text"
						value="<c:out value='${usuarios.nombre}' />" class="form-control"
						name="nombre" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Nombre de Usuario</label> <input type="text"
						value="<c:out value='${usuarios.username}' />" class="form-control"
						name="username">
				</fieldset>

				<fieldset class="form-group">
					<label>Correo Electronico</label>
					 <input type="email"
						value="<c:out value='${usuarios.email}' />" class="form-control"
						name="email">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Fecha de Nacimiento</label> <input 
						value="<c:out value='${usuarios.fecha_nacimiento}' />" class="form-control"
						name="fecha_nacimiento"
						type="date" id="fecha_nacimiento">
				</fieldset>

				<fieldset class="form-group">
					<label>Contraseña</label> <input 
						value="<c:out value='${usuarios.password}' />" class="form-control"
						type="password" id="password" 
						name="pass">
				</fieldset>

				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>