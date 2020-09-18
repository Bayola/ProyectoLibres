<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<title>Datos Profesor</title>
<center>
	<img src="img/Cabecera.png" width="800px" height="150px"/> <br />
</head>
<body style="background-color: #e7e7f3;">
	<div style="color: #8d0303;">
		<h1>DATOS DE PROFESOR</h1>
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
		style="border: 1px solid black; margin-left: 500px; margin-right: 500px; padding: 20px;">

		<form method="post" action="ActualizarProfesor">
			<div>
				<label>Id </label> <input style="background: lightgray" type="text" name="id" value="<%=obtieneAtributo(request, "valId")%>" /> 
			</div>
			<div>&nbsp;</div>
			<div>
				<label>Nombres</label> <input type="text" name="nombre" value="<%=obtieneAtributo(request, "valNombre")%>" /> 
			</div>
			<div>&nbsp;</div>
			<div>
				<label>Apellidos</label> <input id="apellidos"
					class="form-control form-control-md" type="text" name="apellido" value="<%=obtieneAtributo(request, "valApellido")%>" /> 
			</div>
			<div>&nbsp;</div>
			<div>
				<label>Teléfono</label> <input type="text" name="telefono" value="<%=obtieneAtributo(request, "valTelefono")%>" /> 
			</div>
			<div>&nbsp;</div>
			<div>
				<label>Correo</label> <input type="text" name="correo" value="<%=obtieneAtributo(request, "valCorreo")%>" />
			</div>
			<div>&nbsp;</div>
			<div>
				<input type="submit" value="Guardar" />
			</div>
		</form>
		
		<form method="post" action="menuAdministrador.jsp">
			<input type="submit" value="Salir" />
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