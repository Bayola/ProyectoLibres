<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
	<title>Menu Estudiantes</title>
	<link rel="stylesheet" href="estilos.css">
	 <center><img src="img/Cabecera.png" width="800px" height="150px"/><br />
	
</head>
<body style= "background-color: #e7e7f3;">
<div style = "color:#8d0303;">
<h1> CURSOS </h1><hr></br>
</div> </center>
<div>
<form method="post" action="ListarTareasEstudiante">
<div style="margin-left: 225px; margin-right: 100px;">
	<div style = "color:#8d0303; margin-left: 10px; margin-right: 700px;">
	<h1> Tareas </h1><hr></br>
	</div>
	<img src="img/regicon.png" width="35px" height="35px"/><input type="submit" value="Revisar tareas"/>
</div>	
</form>
</div>	
<br/>	
		<br></br>
		
		<form method="post" action="ListarRecurso">
<div style="margin-left: 225px; margin-right: 100px;">
	<div style = "color:#8d0303; margin-left: 10px; margin-right: 700px;">
	<h1> Recursos </h1><hr></br>
	</div>
	<img src="img/regicon.png" width="35px" height="35px"/><input type="submit" value="Listar Recursos"/>
</div>	
</form>
</div>	
<br/>	
<div><center>
		<form method="post" action="modo.jsp">
			<input type="submit" value="Salir" />
		</form>
		</div>
		
    </br>
    </br>
	<div></center>
        <!-- Footer -->
        <footer class="footer"><center>
			<img src="img/piePag.png" width="1000px" height="150px"/>
        </footer></center>
    </div>
    	
</body>
</html>