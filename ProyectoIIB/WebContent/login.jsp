<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="ec.epn.proyecto.modelo.Estudiante"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<title>Login</title>
<center>
	<img src="img/Cabecera.jpg" /> <br />
</head>
<body style="background-color: lightgray;">
	<div style="color: #8d0303;">
		<h1>Usuario</h1>
		<hr>
		</br>
	</div>

	<%!public String obtieneAtributo(HttpServletRequest request, String nombre) {
		String valor = (String) request.getAttribute(nombre);
		if (valor == null) {
			valor = "";
		}
		return valor;
	}%>
	<p style="color: red"><%=obtieneAtributo(request, "valError")%></p>

	<!-- Datos -->
	<div
		style="border: 1px solid black; margin-left: 450px; margin-right: 450px; padding: 40px;">

		<form method="post" action="Login">
			<div>
				<label>Modo</label> <select name="Modalidad">
					<option>Seleccione una opción ...</option>
					<option value="Estudiante">Estudiante</option>
					<option value="Profesor">Profesor</option>
					<option value="Administrador">Administrador</option>
				</select>
			</div>
			</br>
			<div>
				<label>Número de Cédula</label> <input type="text" name="cedula"
					value="<%=obtieneAtributo(request, "valCedula")%>"
					placeholder="Escribe tu cedula" /> <span id="error_nombre"></span>
			</div>
			<div>&nbsp;</div>
			<div>
				<label>Contraseña</label> <input type="text" name="contraseña"
					value="<%=obtieneAtributo(request, "valContraseña")%>"
					placeholder="Escribe tu contraseña" /> <span id="error_contraseña"></span>
			</div>
			<div>&nbsp;</div>

			<% 
			List<Estudiante> estudiante;
			estudiante = (List<Estudiante>) request.getAttribute("estudiante");
			for (Estudiante e : estudiante) {
				String nombreEst = e.getNombre();
				String pwdEst = e.getPassword();
			}
/* 			List<Profesor> profesor;
			profesor = (List<Profesor>) request.getAttribute("profesor");
			for (Profesor p : profesor) {
				String nombrePro = p.getNombre();
				String pwdPro = p.getPassword();
			}
			List<Administrador> administrador;
			administrador = (List<Administrador>) request.getAttribute("administrador");
			for (Administrador a : administrador) {
				String nombreAdm = a.getNombre();
				String pwdAdm = a.getPassword();
			}
 */			%>

			<div>
				<input type="submit" value="Ingresar" />
			</div>
			<br> <br>
			<div>
				¿Eres un nuevo Estudiante? <a href="Registro.jsp"> Registrate</a>
			</div>
		</form>
	</div>
	</br>
</body>
<div>
	<!-- Footer -->
	<footer class="footer">
		<img src="img/piepagina.jpeg" />
	</footer>
	</center>
</div>
</html>