<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#filtroNombre").keyup(function() {
			$.get("../rest/cursos/filtro/" + $(this).val(), function(datos) {
				$("table#tabla1 tr").remove();
				if(Array.isArray(datos)) {
					for(var i = 0; i < datos.length; i++) {
						var curso = datos[i];
						generarTabla(curso);
					}
				} else {
					generarTabla(datos);
				}
			});
		});

		function generarTabla(curso) {
			$("#tabla1").append(
				"<tr><td>" + curso.nombre + "</td>" +				
				"<td>" + curso.nivel + "</td>" +				
				"<td><form action='../ServletControlador/borrar' method='post'>" +
				"<input type='hidden' name='nombre' value='" + curso.nombre + "' />" +				
				"<input type='hidden' name='nivel' value='" + curso.nivel + "' />" +				
				"<input type='submit' value='borrar' />" +
				"</form>" +
				"</td>" +
				"</tr>"				
			);
		}
	});
</script>
</head>
<body>
	<table>
		<tr>
			<td>Filtro:</td>
			<td><input type="text" name="filtroNombre" id="filtroNombre" /></td>
		</tr>
	</table>

	<table id="tabla1" border="1px">
		<c:forEach var="curso" items="${listaCursos}">
			<tr>
				<td><c:out value="${curso.nombre}" /></td>
				<td><c:out value="${curso.nivel}" /></td>
				<td>
					<form method="post" action="../ServletControlador/borrar">
						<input type="hidden" name="nombre" value="${curso.nombre}" />
						<input type="hidden" name="nivel" value="${curso.nivel}" />
						<input type="submit" value="borrar" />
					</form> 
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<form action="../ServletControlador/formularioInsertar">
		<input type="submit" value="nuevo" />
	</form>

</body>
</html>