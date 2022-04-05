<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio de Sesión</title>

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

<link href="css/estilos.css" rel="stylesheet" type="text/css">
</head>
<body>

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
		
			<a style="color: black" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Logout</a>
			<div class="dropdown-menu text-center">
				<a><img src="img/usuario.png" height="70" width="70"></a><br>
				<a><%=request.getSession().getAttribute("nombre") %></a>
				<div class="dropdown-divider"></div>
				<a href="Deslogeo" class="dropdown-item">Logout</a>
			
			</div>
		</div>
	</nav>


	<div class="wrapper fadeInDown">
		<h1>Conoce a tu animal de Horóscopo Chino</h1>

		<h1><c:out value="Tu animal es: ${animal}" /></h1>
		

	</div>

</body>
</html>