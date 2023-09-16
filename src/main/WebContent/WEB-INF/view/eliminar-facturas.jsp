<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar Facturas</title>
</head>
<body>

	<h1><p style="color:salmon;"Red paragraph text>FACTURAS</p></h1>
	<hr/>
	
	<form action="del" method="get">
		<input type="hidden" id="idFactura" name="idFactura" value="${facturasModel.idFactura}">
		<strong>¿Desea eliminar la Factura?</strong>
		<br><br>
		<button type="submit">Eliminar</button>
		<button type="button" onclick="window.location.href='/proyecto-web-perfumitos/facturas/findAll; return false;'">Cancelar</button>
	</form>
	
</body>
</html>