<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="ec.epn.proyecto.modelo.Profesor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
	<title>Lista de Profesores </title>
	 <center><img src="img/Cabecera.jpg" />
	 <br/>	
</head>
<body style= "background-color:lightgray;">
<div style = "color:#8d0303;">
<h1> LISTADO DE PROFESORES </h1><hr></br>
</div>

<table border="1">
<tr>
<th>   ID   </th>
<th>   Nombre   </th>
<th>   Apellido   </th>
<th>   Cedula   </th>
<th>   Telefono   </th>
<th>   Correo   </th>
</tr>

<%
List<Profesor> profesor;
profesor = (List<Profesor>)request.getAttribute("profesor");
for(Profesor e: profesor){ %>
<tr>
<td><%=e.getId()%></td>
<td><%=e.getNombre() %></td>
<td><%=e.getApellido() %></td>
<td><%=e.getCedula() %></td>
<td><%=e.getTelefono() %></td>
<td><%=e.getCorreo() %></td>
<td><a href="EliminarEstudiante?id=<%=e.getId()%>">Eliminar</td>
</tr>
<%} %>
</table>
<form method="get" action="Login">
		<input type="submit" value="Salir"/>
	</form>	
</br>
   <div>
        <!-- Footer -->
        <footer class="footer">
			<img src="img/piepagina.jpeg" />
        </footer></center>
    </div>
</body>
</html>