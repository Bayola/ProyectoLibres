<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>tareasEstudiante</title>
</head>
<body style= "background-color:lightgray;"><center>
   <img src="img/Cabecera.jpg" />
   <br/>
   <h1>   TAREAS ESTUDIANTE </h1><br/></center>
   <br/>
   
 <%! public String obtieneAtributo(HttpServletRequest request, String nombre){
String valor =	(String) request.getAttribute(nombre); 
if(valor==null){
valor="";
}
return valor;
} %>  
		<form method="post" action="ActualizarEntrega">
				<td><b><i>Id:		</i></b></td>
				<td><input type="text" name="id" style="background-color: lightgray;" value="<%=obtieneAtributo(request, "valId")%>"/></td>
				</tr></div><br/>
				<div><tr>
				<td><b><i>Titulo:	</i></b></td>
				<td><input type="text" name="titulo" style="background-color: lightgray;" value="<%=obtieneAtributo(request, "valTitulo")%>"/></td>
				</tr></div><br/>
				<div><tr>
				<td><b><i>Descripcion:</i></b></td>
				<td><input type="text" name="descripcion" style="background-color: lightgray;" value="<%=obtieneAtributo(request, "valDescripcion")%>"/></td>
				</tr></div><br/>
				<br><tr>
				<td><b><i>Entrega:</i></b></td>
				<td><input type="text" name="entrega" size="150" value="<%=obtieneAtributo(request, "valEntrega")%>"/></td>
				</tr></div>
				<br/>
				<br><tr>
				<td><center><input type="submit" value="Guardar"/></center></td>
				</tr>				
		</form>
   <br/>	
	
	
</center>`	
<br>
</body>
 <img src="img/piepagina.jpeg" />
</html>