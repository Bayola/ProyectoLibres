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
<body style= "background-color: #e7e7f3;"><center>
<img src="img/Cabecera.png" width="800px" height="150px"/> <br />

<div style="color: #8d0303;">
		<h1>LISTA DE TAREAS</h1>
		<hr>
		</br>
	</div>
<form method="post" action="crearTarea.jsp">
			<img src="img/regicon.png" width="40px" height="40px" />
			<input type="submit" name="nombre" value="Nueva Tarea" size="80" />
</form>

<br> 
<br>
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
<td><a href="EditarTareaProfesor?id=<%=t.getId()%>">Calificar</td>
<td><a href="EliminarTarea?id=<%=t.getId()%>">Eliminar</td>
</tr>
<%} %>
</table>
<br>
<form method="post" action="menuProfesor.jsp">
			<input type="submit" value="Regresar" />
		</form>
	</div>
	<br></br>
	<div>
		<form method="get" action="modo.jsp">
			<input type="submit" value="Salir" />
		</form>
	</div>
<br>
<footer class="footer">
		<img src="img/piePag.png" width="1000px" height="150px"/>
	</footer>
</body>
</html>
