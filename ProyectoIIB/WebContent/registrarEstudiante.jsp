<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import= "ec.epn.proyecto.modelo.Estudiante" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
	<title>Registro </title>
	 <center><img src="img/Cabecera.jpg" />
	 <br/>	
</head>
<body style= "background-color:lightgray;">
<div style = "color:#8d0303;">
<h1> REGISTRO DATOS </h1><hr></br>
</div>

<%! public String obtieneAtributo(HttpServletRequest request, String nombre){
String valor =	(String) request.getAttribute(nombre); 
if(valor==null){
		valor="";
	}return valor;
}%>
<p style="color:red"><%=obtieneAtributo(request, "valError")%></p>

<!-- Datos -->
<div style="border: 1px solid black; margin-left: 450px; margin-right: 450px; padding: 20px;">

<form method="post" action="RegistrarEstudiante">
<%System.out.print(obtieneAtributo(request,"valId" )); %>

	<div class="col-md-11" style="margin: 1%">
 		<label>Número de Cédula</label>
 		<input type="text" name="cedula" value="<%=obtieneAtributo(request, "valCedula")%>"
        	   placeholder="Escribe tu cedula"/> 		
	</div>
	<div>&nbsp;</div>
	<div>
 		<label>Nombres</label>
 		<input type="text" name="nombre" value="<%=obtieneAtributo(request, "valNombre")%>"
        	   placeholder="Escribe tus nombres"/>
	</div>
	<div>&nbsp;</div>
	<div class="col-md-11" style="margin: 1%">
 		<label>Apellidos</label>
 		<input type="text" name="apellido" value="<%=obtieneAtributo(request, "valApellido")%>"
        	   placeholder="Escribe tus apellidos"/>
	</div>
	<div>&nbsp;</div>
	<div class="col-md-11" style="margin: 1%">
 		<label>Teléfono</label>
 		<input type="text" name="telefono" value="<%=obtieneAtributo(request, "valTelefono")%>"
        	   placeholder="Escribe tu telefono"/>
	</div>
	<div>&nbsp;</div>
	<div class="col-md-11" style="margin: 1%">
 		<label>Correo</label>
 		<input type="text" name="correo" value="<%=obtieneAtributo(request, "valCorreo")%>"
        	   placeholder="Escribe tu correo"/>
	</div>
	<div>&nbsp;</div>
	<div class="col-md-11" style="margin: 1%">
 		<label>Contraseña</label>
 		<input type="text" name="password" value="<%=obtieneAtributo(request, "valPassword")%>"
        	   placeholder="Escribe tu contraseña"/>
	</div>
	<div>&nbsp;</div>
	<div>
		<input type="submit" value="Guardar"/>
	</div>
</form>
<br>
<div>
<form method="get" action="Login">
		<input type="submit" value="Salir"/>
</form>
</div>

</div>
</br>
   <div>
        <!-- Footer -->
        <footer class="footer">
			<img src="img/piepagina.jpeg" />
        </footer></center>
</div>
</body>

</html>