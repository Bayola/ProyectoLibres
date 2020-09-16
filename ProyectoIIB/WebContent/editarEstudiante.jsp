<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
	<title>Datos Estudiante</title>
	 <center><img src="img/Cabecera.jpg" />
	 <br/>	
</head>
<body style= "background-color:lightgray;">
<div style = "color:#8d0303;">
	<h1>DATOS DE ESTUDIANTE </h1><hr></br>
</div>

<%! public String obtieneAtributo(HttpServletRequest request, String nombre){
String valor =	(String) request.getAttribute(nombre); 
if(valor==null){
valor="";
}return valor;
}%>
<p style="color:red"><%=obtieneAtributo(request, "valError")%></p>
<!-- Datos -->
<div style="border: 1px solid black; margin-left: 500px; margin-right: 500px; padding: 20px;">

<form method="post" action="EditarEstudiante">
<%System.out.print(obtieneAtributo(request,"valId" )); %>
	<div class="col-md-11" style="margin: 1%">
 		<label>Nombres</label>
 		<input id="nombre" class="form-control form-control-md" type="text" name="nombre" value="<%=obtieneAtributo(request, "valNombre")%>"
        	   placeholder="Escribe tus nombres"/>
 		<span id="error_nombre"></span>
	</div>
	<div>&nbsp;</div>
	<div class="col-md-11" style="margin: 1%">
 		<label>Apellidos</label>
 		<input id="apellidos" class="form-control form-control-md" type="text" name="apellidos" value="<%=obtieneAtributo(request, "valApellido")%>"
        	   placeholder="Escribe tus apellidos"/>
 		<span id="error_apellido"></span>
	</div>
	<div>&nbsp;</div>
	<div class="col-md-11" style="margin: 1%">
 		<label>Teléfono</label>
 		<input id="telefono" class="form-control form-control-md" type="text" name="telefono" value="<%=obtieneAtributo(request, "valTelefono")%>"
        	   placeholder="Escribe tu telefono"/>
 		<span id="error_telefono"></span>
	</div>
	<div>&nbsp;</div>
	<div class="col-md-11" style="margin: 1%">
 		<label>Correo</label>
 		<input id="correo" class="form-control form-control-md" type="text" name="correo" value="<%=obtieneAtributo(request, "valCorreo")%>"
        	   placeholder="Escribe tu correo"/>
 		<span id="error_correo"></span>
	</div>
	<div>&nbsp;</div>
	<div>
	<input type="submit" value="Guardar"/>
	</div>
</form>
<form method="post" action="Curso.jsp">
	<input type="submit" value="Salir"/>
</form>
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