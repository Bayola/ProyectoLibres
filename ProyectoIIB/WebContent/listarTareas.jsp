<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="ec.epn.proyecto.modelo.Tarea" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar tareas</title>
</head>
<body>
<body style= "background-color:lightgray;"><center>
<img src="img/Cabecera.jpg" />

<h1> Listado Tareas </h1>
<a href="crearTarea.jsp">Nueva Tarea</a>
<p>Registro exitoso</p> 

<table border="1">
<tr>
<th>   ID   </th>
<th>   Titulo   </th>
<th>   Descripcion   </th>
<th>   Calificacion   </th>
<th>   Calificar   </th>
<th>   Eliminar   </th>
</tr>

<%
List<Tarea> tareas;
tareas= (List<Tarea>)request.getAttribute("tareas");
for(Tarea t: tareas){
	
%>

<tr>
<td><%=t.getId()%></td>
<td><%=t.getTitulo() %></td>
<td><%=t.getDescripcion()%></td>
<td><%=t.getCalificacion()%></td>
<td><a href="EditarTarea?id=<%=t.getId()%>">Calificar</td>
<td><a href="EliminarTarea?id=<%=t.getId()%>">Eliminar</td>
</tr>
<%} %>
</table>

</body>
</html>
