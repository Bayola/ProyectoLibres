<%@page import="javax.persistence.Id"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="ec.epn.proyecto.modelo.Tarea" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Calificar</title>
</head>
<body style= "background-color: #e7e7f3;"><center>
<img src="img/Cabecera.png" width="800px" height="150px"/> <br />
<div style="color: #8d0303;">
		<h1>CALIFICAR</h1>
		<hr>
		</br>
	</div>
<%! public String obtieneAtributo(HttpServletRequest request, String nombre){
String valor =	(String) request.getAttribute(nombre); 
if(valor==null){
valor="no entregado";
}return valor;
}%>


<table border="1">
<form method="post" action="ActualizarTareaProfesor">
<%System.out.print(obtieneAtributo(request,"valId" )); %>
<tr>
				<td>Id</td>
				<td><input type="text" style="background-color: lightgray;" name="id" value="<%=obtieneAtributo(request, "valId")%>"/></td>
				</tr>
				<tr>
				<td>Titulo</td>
				<td><input type="text" style="background-color: lightgray;" name="titulo" size=100 value="<%=obtieneAtributo(request, "valTitulo")%>"/></td>
				</tr>
				<tr>
				<td>Descripcion</td>
				<td><input type="text" style="background-color: lightgray;" name="descripcion" size=100 value="<%=obtieneAtributo(request, "valDescripcion")%>"/></td>
				</tr>
				<tr>
				<td>Entrega</td>
				<td><input type="text" style="background-color: lightgray;" name="entrega" size=100 value="<%=obtieneAtributo(request, "valEntrega")%>"/></td>				
				</tr>
				<td>Calificacion</td>
				<td><input type="text" name="calificacion" value="<%=request.getAttribute("valCalificacion")%>"/></td>				
				</tr>
				<tr>
				<td><input type="submit" value="Agregar Calificacion"/></td>
				</tr>
		</form>

</table>
<br>
<br>
<table border="3" style="color: gray"><tr>
<td><a href="ListarTareasProfesor">Cancelar</a></td>
</tr></table>
<br>
<br>
</body>
<footer class="footer">
		<img src="img/piePag.png" width="1000px" height="150px"/>
	</footer>
</html>