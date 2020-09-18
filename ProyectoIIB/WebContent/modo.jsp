<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="ec.epn.proyecto.modelo.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<title>Login</title>
<center>
	<!-- Definimos una imagen como cabecera -->
	<img src="img/Cabecera.png" width="800px" height="150px"/> <br />
</head>
<body style="background-color: #e7e7f3;">
	<div style="color: #8d0303;">
		<h1>USUARIO</h1>
		<hr>
		</br>
	</div>

	<!-- Datos -->
	<div style="border: 1px solid #8d0303; margin-left: 300px; margin-right: 300px; padding: 10px;">
		<div style="color: #8d0303;"><h3>Elija el tipo de usuario</h3>
		<hr><br/></div>
		<br>
		<tr><td>
		<form method="post" action="login.jsp">
			<img src="img/admicon.png" width="40px" height="40px" />
			<input type="submit" name="nombre" value="Administrador" size="80" />
		</form>
		</td>
		<td>
		<form method="post" action="login.jsp">
			<img src="img/esticon.png" width="40px" height="40px" />
			<input type="submit" name="nombre" value="Estudiante" size="80" />
		</form>
		</td>
		<td>
		<form method="post" action="login.jsp">
			<img src="img/proficon.png" width="40px" height="40px" />
			<input type="submit" name="nombre" value="Profesor" size="80"/>
		</form>
		</td></tr>
	</div>
	<br>
	<div
		style="border: 1px solid #8d0303; margin-left: 300px; margin-right: 300px; padding: 10px;">
		<form method="post" action="registrarEstudiante.jsp">
			<div style="color: #8d0303;"><h3>Estudiantes Nuevos</h3><hr><br/></div>
			<img src="img/regicon.png" width="40px" height="40px" />
			<input type="submit" name="nombre" value="Registro" size="80" />
		</form>
		<br>
	</div>
	</br>
</body>
<div>
	<!-- Footer -->
	<footer class="footer">
		<img src="img/piePag.png" width="1000px" height="150px"/>
	</footer>
	</center>
</div>
</html>