<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CrearRecurso</title>
</head>
<body style="background-color: #e7e7f3;">
	<center>
		<img src="img/Cabecera.png" width="800px" height="150px"/><hr> <br />
		<div style = "color:#8d0303;">
		<h1>Crear Recurso</h1>
		<hr>
		</div>

		<%!public String obtieneAtributo(HttpServletRequest request, String nombre) {
		String valor = (String) request.getAttribute(nombre);
		if (valor == null) {
			valor = "";
		}
		return valor;
	}%>

		<p style="color: red"><%=obtieneAtributo(request, "valError")%></p>
		<table border="0">
			<form method="post" action="CrearRecurso">
				<tr>
					<td>Nombre</td>
					<td><input type="text" name="nombre"
						value="<%=obtieneAtributo(request, "valNombre")%>" /></td>
				</tr>
				<tr>
					<td>Tipo</td>
					<td><input type="text" name="tipo"
						value="<%=obtieneAtributo(request, "valTipo")%>" /></td>
				</tr>
				<tr>
					<td>Link</td>
					<td><input type="text" name="link"
						value="<%=obtieneAtributo(request, "valLink")%>" /></td>
				</tr>
				<tr>
					<br></br>
					<td><input type="submit" value="Guardar" /> <br></br>
					<td><button type="reset">Vaciar campos</button> <br></br>
				</tr>
			</form>
		</table>
		<br>
		<div>
		<form method="post" action="RecursosProfesor">
			<input type="submit" value="Regresar" />
		</form>
		</div>
		<br></br>
</div>
</body>
<img src="img/piePag.png" width="1000px" height="150px"/>
</html>