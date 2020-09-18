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
<body style= "background-color: #e7e7f3;"><center>
<img src="img/Cabecera.png" width="800px" height="150px"/> <br />

<div style="color: #8d0303;">
		<h1>LISTA DE TAREAS</h1>
		<hr>
		<h2> Modo Estudiante </h2>
		<hr>
		</br>
	</div>

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
<td><a href="EditarTareaEstudiante?id=<%=t.getId()%>">Realizar Entrega</td>
</tr>
<%} %>
</table>


<br>
<%Tarea t=new Tarea(); %>
<form style="color: blue" action="ListarCalificacionesEstudiante?id=<%=t.getId()%>" method="post">
<input type="submit" value="Ver calificaciones">
</form>

</body>
<br>
<br>
<div>
		<form method="get" action="cursos.jsp">
			<input type="submit" value="Regresar" />
		</form>
</div>
<br>
<br>
<br>
<footer class="footer">
		<img src="img/piePag.png" width="1000px" height="150px"/>
	</footer>
	</body>
</html>
