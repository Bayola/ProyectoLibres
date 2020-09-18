<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<title>Menu</title>
<center>
	<img src="img/Cabecera.png" width="800px" height="150px"/> <br />
</head>
<body style="background-color: #e7e7f3;">
	<div style="color: #8d0303;">
		<h1>MENU PROFESOR</h1>
		<hr>
		</br>
	</div>
	<div>
		<form method="post" action="ListarEstudiantes">
			<input type="submit" value="Lista de Estudiantes" />
		</form>
	</div>
	<br></br>
<div><form method="post" action="ListarTareasProfesor">
			<img src="img/proficon.png" width="40px" height="40px" />
			<input type="submit" name="nombre" value="Listado de Tareas" size="80"/>
		</form>	<br></br></div>
	<div>
		<form method="post" action="RecursosProfesor">
			<input type="submit" value="Recursos" />
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
		</footer></center>
</div>
</body></center>
</html>
