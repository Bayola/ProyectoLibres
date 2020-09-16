<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="ec.epn.proyecto.modelo.Estudiante" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
	<title>Lista de Estudiantes </title>
	 <center><img src="img/Cabecera.jpg" />
	 <br/>	
</head>
<body style= "background-color:lightgray;">
<div style = "color:#8d0303;">
<h1> LISTADO DE ESTUDIANTES </h1><hr></br>
</div>

<table border="1">
<tr>
<th>   Nombre   </th>
<th>   Apellido   </th>
<th>   Cedula   </th>
<th>   Telefono   </th>
<th>   Correo   </th>
</tr>
<%
List<Estudiante> estudiante;
estudiante = (List<Estudiante>)request.getAttribute("estudiante");
for(Estudiante e: estudiante){ %>
<tr>
<td><%=e.getNombre() %></td>
<td><%=e.getApellido() %></td>
<td><%=e.getCedula() %></td>
<td><%=e.getTelefono() %></td>
<td><%=e.getCorreo() %></td>
<td><a href="EliminarEstudiante?id=<%=e.getId()%>">Eliminar</td>
</tr>
<%} %>
</table>
</br>
</br>
<form method="get" action="Login">
		<input type="submit" value="Salir"/>
	</form>	
</br>
</br>
   <div>
        <!-- Footer -->
        <footer class="footer">
			<img src="img/piepagina.jpeg" />
        </footer></center>
    </div>
</body>
</html>