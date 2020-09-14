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
<body style= "background-color:lightgray;"><center>
<img src="img/Cabecera.jpg" />
<h1> Calificar </h1>
<%! public String obtieneAtributo(HttpServletRequest request, String nombre){
String valor =	(String) request.getAttribute(nombre); 
if(valor==null){
valor="no entregado";
}return valor;
}%>


<table border="1">
<form method="post" action="ActualizarTarea">
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
</body>
<img src="img/piepagina.jpeg" />
</html>