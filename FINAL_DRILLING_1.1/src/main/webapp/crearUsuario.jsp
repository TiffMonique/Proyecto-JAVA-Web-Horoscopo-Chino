<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio de Sesi�n</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
<link href="css/estilos.css" rel="stylesheet" type="text/css">
<link href="css/estiloAreaPrivada.css" rel="stylesheet" type="text/css">

<link href="css/estilos.css" rel="stylesheet" type="text/css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #92badd;;">
  <a class="navbar-brand" href="#">Hor�scopo Chino</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Tu Hor�scopo Chino</a>
      </li>
    

    </ul>
  </div>
</nav>


<div class="wrapper fadeInDown">
  <div id="formContent">
    

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="img/usuario.png" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form method="post" action="crearUsuario">
    	<input type="hidden" name="operacion" id="operacion" value="crear">
    	<label for="idUsuario" style="display: none;"> Id Usuario </label>  
    	<input type="hidden" name="idUsuario" id="idUsuario" value="0">
    	  
    	<input type="text" id="nombre" class="fadeIn second" name="nombre" placeholder="Nombre">
    	
    	.  <input type="text" id="username" class="fadeIn second" name="username" placeholder="Nombre de usuario">
    	
    	<input type="email" id="email" class="fadeIn second" name="email" placeholder="Correo Electronico">
    	
    
     
      <input type="date" id="fecha_nacimiento" class="fadeIn second" name="fecha_nacimiento" placeholder="Fecha de Nacimiento">
     
      <input type="password" id="password" class="fadeIn third" name="password" placeholder="Contrase�a">
      
      <input type="password" id="repitaPassword" class="fadeIn third" name="repitaPassword" placeholder="Repita Contrase�a">
      
      <label for="animal" style="display: none;"> Animal </label>  
    	<input type="hidden" name="animal" id="animal" value="0">
      
      <input type="submit" class="fadeIn fourth" value="Ingresar" id="botonEnviar">
      
    </form>


  </div>
</div>

</body>
</html>