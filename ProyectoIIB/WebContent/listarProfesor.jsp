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
	 <center><img src="img/Cabecera.png" width="800px" height="150px"/> <br />
</head>
<body style= "background-color: #e7e7f3;">
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
<td><a href="EditarProfesor?id=<%=e.getId()%>">Editar</td>
<td><a href="EliminarProfesor?id=<%=e.getId()%>">Eliminar</td>
</tr>
<%} %>
</table>
<br/>
<br/>
<form method="post" action="menuAdministrador.jsp">
		<input type="submit" value="Regresar"/>
	</form>	
<br/>
<form method="get" action="modo.jsp">
		<input type="submit" value="Salir"/>
	</form>	
<br/>
<br/>
<br/>
<br/>
   <div>
        <!-- Footer -->
        <footer class="footer">
		<img src="img/piePag.png" width="1000px" height="150px"/>
	</footer></center>
    </div>
</body>
</html>