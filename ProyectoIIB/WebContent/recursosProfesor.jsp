<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="ec.epn.proyecto.modelo.Recurso" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recursos</title>
</head>
<body style= "background-color: #e7e7f3;"><center>
<img src="img/Cabecera.png" width="800px" height="150px"/> <br />
<br/><br/>
	<div style="color: #8d0303;">
		<h1>RECURSOS</h1>
		<hr>
		</br>
	</div>
<div>
		<form method="post" action="crearRecurso.jsp">
		<img src="img/regicon.png" width="40px" height="40px" />
			<input type="submit" value="Nuevo Recurso" />
		</form>
</div>

<br></br>

<table border="1">
<tr>
<th>   N#  </th>
<th>   nombre  </th>
<th>   tipo   </th>

</tr>

<%
List<Recurso> recursos;
recursos= (List<Recurso>)request.getAttribute("recursos");
for(Recurso t: recursos){
	
%>

<tr>
<td><%=t.getId()%></td>
<td><%=t.getNombre()%></td>
<td><%=t.getTipo()%></td>



</tr>
<%} %>
</table>
<br></br>
<div>
		<form method="post" action="ListarRecurso">
			<img src="img/regicon.png" width="40px" height="40px" />
			<input type="submit" value="Listar Recursos" />
		</form>
</div>
<br></br>
<div>
		<form method="post" action="menuProfesor.jsp">
			<input type="submit" value="Regresar" />
		</form>
</div>
<br/>
<div>
	<footer class="footer">
			<img src="img/piePag.png" width="1000px" height="150px" />
		</footer></center>
</div>
</body>
</html>
