<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="ec.epn.proyecto.modelo.Tarea" %>
<meta charset="ISO-8859-1">
<title>calificacion Estudiantes</title>
</head>
<body style= "background-color:#e7e7f3;"><center>
   <img src="img/Cabecera.png" width="800px" height="150px"/> <br/>
   <div style="color: #8d0303;">
   <h1>   CALIFICACION ESTUDIANTES </h1><hr><br/>
   </div>
   </center>
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
DecimalFormat df = new DecimalFormat("0.00"); 

for(Tarea t: tareas){
	double j=t.getCalificacion()*.1;	
%>
	<TR>
		<TD><%=t.getTitulo() %></TD> <TD><%=0.10%></TD> <TD><%=t.getCalificacion() %></TD> <TD><%=df.format(j) %></TD> 
	</TR>
	<%} %>
</TABLE>
<br>

<td><i><b>Nota Final:</b></i></td>
	<br/>
	<%tareas= (List<Tarea>)request.getAttribute("tareas");
	
	int suma=0;
	for(int i=0;i<tareas.size();i++){
	int val = tareas.get(i).getCalificacion();
	suma += val;
	}

	%>
	<input type="text" name="notafinal" value="<%=df.format(suma*.1)%>">
	<br/>
	<br>
<div><form method="get" action="ListarTareasEstudiante">
		<input type="submit" value="Regresar"/>
</form></div>

<div><form method="get" action="modo.jsp">
		<input type="submit" value="Salir"/>
</form></div>


</center>
 <br/>
   <br/>
   <br/>	
<br>
</body>
 <img src="img/piePag.png" width="1000px" height="150px"/>
</html>