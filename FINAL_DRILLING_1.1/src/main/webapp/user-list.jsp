<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Listar Usuarios</title>
	
	
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

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Lista de Usuarios</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">
					Agregar Usuario</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Nombre de usuario</th>
						<th>Email</th>
						<th>Animal</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="Usuarios" items="${listUser}">

						<tr>
							<td><c:out value="${Usuarios.id}" /></td>
							<td><c:out value="${Usuarios.nombre}" /></td>
							<td><c:out value="${Usuarios.username}" /></td>
							<td><c:out value="${Usuarios.email}" /></td>
							<td><c:out value="${Usuarios.animal}" /></td>
							<td><a href="edit?id=<c:out value='${Usuarios.id}' />">Editar</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteUser?id=<c:out value='${Usuarios.id}' />">Borrar</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>