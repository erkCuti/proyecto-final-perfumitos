<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar Detalles</title>
</head>
<body>

	<h1><p style="color:fuchsia;"Red paragraph text>DETALLES</p></h1>
	<hr/>
	
	<form action="del" method="get">
		<input type="hidden" id="idFacturaDetalle" name="idFacturaDetalle" value="${facDetallesModel.idFacturaDetalle}">
		<strong>¿Desea eliminar la Fac-Detalle?</strong>
		<br><br>
		<button type="submit">Eliminar</button>
		<button type="button" onclick="window.location.href='/proyecto-web-perfumitos/facturasDetalle/findAll; return false;'">Cancelar</button>
	</form>

</body>
</html>