<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<title>Menu</title>
<center>
	<img src="img/Cabecera.png" width="800px" height="150px" /> <br />
</head>
<body style="background-color: #e7e7f3;">
	<div style="color: #8d0303;">
		<h1>MENU ADMINISTRADOR</h1>
		<hr>
		</br>
	</div>
	<div>
		<form method="post" action="registrarProfesor.jsp">
			<input type="submit" value="Registrar Profesor" />
		</form>
	</div>
	<br></br>
	<div>
		<form method="post" action="ListarProfesor">
			<input type="submit" value="Lista de Profesores" />
		</form>
	</div>
	<br></br>
	<div>
		<form method="get" action="modo.jsp">
			<input type="submit" value="Salir" />
		</form>
	</div>
	<br></br>
	<div>
		<!-- Footer -->
		<footer class="footer">
			<img src="img/piePag.png" width="1000px" height="150px" />
		</footer>
		</center>
	</div>
</body>
</html>