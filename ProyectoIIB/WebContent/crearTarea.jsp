<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CrearTarea</title>
</head>
<body style= "background-color:lightgray;"><center>
<img src="img/Cabecera.jpg" />
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
				<tr>
				<td><input type="submit" value="Guardar"/></td>
				<td><button type="reset">Vaciar campos</button>
				</tr>
		</form>
	</table>
	<br>

	<br>
	<br>
	<br>
	<br>
</body>
 <img src="img/piepagina.jpeg" />
</html>