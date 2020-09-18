<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="ec.epn.proyecto.modelo.Recurso" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar recursos</title>
<center><img src="img/Cabecera.png" width="800px" height="150px"/> <br />
</head>
<body>
<body style= "background-color: #e7e7f3;">

<br></br>
<div style="color: #8d0303;">
		<h1>LISTA DE RECURSOS</h1>
		<hr>
		</br>
	</div>
<br></br>

<div><form action="crearRecurso.jsp" method="post">
<input type="submit" value="Nueva Recurso"> 
</form></div><br>


<table border="1">
<tr>
<th>   ID   </th>
<th>   NOMBRE   </th>
<th>   TIPO   </th>
<th>   LINK   </th>

</tr>

<%
List<Recurso> recursos;
recursos= (List<Recurso>)request.getAttribute("recursos");
for(Recurso t: recursos){
	
%>

<tr>
<td><%=t.getId()%></td>
<td><%=t.getNombre() %></td>
<td><%=t.getTipo()%></td>
<td><%=t.getLink()%></td>
<td><a href=<%=t.getLink()%>><%=t.getLink()%></td>
<td><a href=EliminarRecurso?id=<%=t.getId()%>>Eliminar</td>
</tr>
<%} %>
</table><br>

<br></br>
<div><form action="modo.jsp" method="post">
<input type="submit" value="Salir"> 
</form></div><br>

<footer class="footer">
		<img src="img/piePag.png" width="1000px" height="150px"/>
	</footer>
</body>
</html>
