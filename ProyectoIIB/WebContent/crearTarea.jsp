<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CrearTarea</title>
</head>
<body style= "background-color: #e7e7f3;"><center>
<img src="img/Cabecera.png" width="800px" height="150px"/> <br />

<h1> Crear Tarea </h1>

<%! public String obtieneAtributo(HttpServletRequest request, String nombre){
String valor =	(String) request.getAttribute(nombre); 
if(valor==null){
valor="";
}
return valor;
} %>

<p style="color:red"><%=obtieneAtributo(request, "valError")%></p>
	<table border="0">
		<form method="post" action="CrearTarea">
			<tr>
				<td>Titulo</td>
				<td><input type="text" name="titulo" value="<%=obtieneAtributo(request, "valTitulo")%>"/></td>
				</tr>
							<tr>
				<td>Descripcion</td>
				<td><input type="text" name="descripcion" value="<%=obtieneAtributo(request, "valDescripcion")%>"/></td>
				</tr>
				<tr><br>
				<td><input type="submit" value="Guardar"/></td>
				<td><button type="reset">Vaciar campos</button>
				</tr>
		</form>
	</table>
	<br>
	<br>
	<br>
<table border="3" style="color: gray"><tr>
<td><a href="ListarTareasProfesor">Ir a Listado de Tareas</a></td>
</tr></table>
	<br>
	<br>
	<br>
	<br>
</body>
<img src="img/piePag.png" width="1000px" height="150px"/>
</html>