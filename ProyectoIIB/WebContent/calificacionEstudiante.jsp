<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="ec.epn.proyecto.modelo.Tarea" %>
<meta charset="ISO-8859-1">
<title>calificacionEstudiantes</title>
</head>
<body style= "background-color:lightgray;"><center>
   <img src="img/Cabecera.jpg" />
   <br/>
   <h1>   CALIFICACION ESTUDIANTES </h1><br/></center>
   <br/>
   <br/>
   <br/>
   
   <center><TABLE border="1" >
	<TR>
		<TD><b>Tarea</b></TD> <TD><b>Ponderacion</b></TD> <TD><b>Calificacion</b></TD><TD><b>Nota Tarea</b></TD>
	</TR>
	<%
List<Tarea> tareas;
tareas= (List<Tarea>)request.getAttribute("tareas");
for(Tarea t: tareas){
	
%>
	<TR>
		<TD><%=t.getTitulo() %></TD> <TD><%=0.10%></TD> <TD><%=t.getCalificacion() %></TD> <TD><%=t.getCalificacion()*0.10%></TD> 
	</TR>
	<%} %>
</TABLE>
<br>

<td><i><b>Nota Final:</b></i></td>
	<br/>
	<%tareas= (List<Tarea>)request.getAttribute("tareas");
	double cal=0;	
	cal=(tareas.get(0).getCalificacion()+tareas.get(1).getCalificacion()+tareas.get(2).getCalificacion()+tareas.get(3).getCalificacion()+
			tareas.get(4).getCalificacion()+tareas.get(5).getCalificacion())*0.1;
	%>
	<input type="text" name="notafinal" value="<%=cal%>">
	<br/>
	<br>
<table border="3" style="color: gray"><tr>
<form method="get" action="ListarCalificacionesEstudiante">
		<input type="submit" value="Salir"/>
</form>
</tr></table>

</center>
 <br/>
   <br/>
   <br/>	
<br>
</body>
 <img src="img/piepagina.jpeg" />
</html>