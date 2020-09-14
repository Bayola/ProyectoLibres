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
<body style= "background-color:lightgray;"><center>
<img src="img/Cabecera.jpg" />

<h1> Listado Tareas </h1>
<h2> Modo Estudiante </h2>


<table border="1">
<tr>
<th>   ID   </th>
<th>   Titulo   </th>
<th>   Descripcion   </th>
<th>   Entrega   </th>
<th>   Calificacion   </th>
<th>   Entregado   </th>
<th>   Realizar   </th>
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
<td><%=t.getEntrega()%> </td>
<td><%=t.getCalificacion()%> </td>
<td><%=t.getEntregado()%> </td>
<td><a href="TareasEstudiante?id=<%=t.getId()%>">Realizar Entrega</td>
</tr>
<%} %>
</table>
<br>
<%Tarea t=new Tarea(); %>
<a href="CalificacionesEstudiante?id=<%=t.getId()%>">Ver Calificaciones</a>

</body>
<br>
<br>
<br>
<br>
<br>
<img src="img/piepagina.jpeg" />
</html>
