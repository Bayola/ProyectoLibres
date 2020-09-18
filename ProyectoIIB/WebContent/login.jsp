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
	<img src="img/Cabecera.png" width="800px" height="150px"/> <br/>
</head>
<body style="background-color: lightgray;">
	<div style="color: #8d0303;">
	
		<%
			String nombre = request.getParameter("nombre");
		request.setAttribute("nombre", nombre);
		%>
		
		<h2>
			<font color= #8d0303><%=nombre%></font>
		</h2>
		<hr>
		</br>
	</div>

	<!-- Datos -->
	<div style="border: 1px solid #8d0303; margin-left: 300px; margin-right: 300px; padding: 40px;">

		<form method="post" action="Login">
			<div>
			<label>Tipo de Acceso</label>
			<input style="background: lightgray" type="text" name="tipo" value=<%=nombre%>> </input>
			</div>
			<div>&nbsp;</div>
			<div>
				<label>Número de Cédula</label> 
				<input type="text" name="cedula" placeholder="Escribe tu cedula" /> 
			</div>
			<div>&nbsp;</div>
			<div>
				<label>Contraseña</label> 
				<input type="text" name="password" placeholder="Escribe tu contraseña" />
			</div>
			<div>&nbsp;</div>

			<div>
				<input type="submit" value="Ingresar" />
			</div>
			<br>
		</form>
		<form method="post" action="modo.jsp">
				<input type="submit" name="nombre" value="Salir" size="80"/>
			</form>
	</div>
	
	</br>
	<div>
		<!-- Footer -->
		<footer class="footer">
			<img src="img/piePag.png" width="1000px" height="150px"/>
		</footer>
		</center>
	</div>
</body>
</html>