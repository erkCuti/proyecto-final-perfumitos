<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Detalles</title>
</head>
<body>

	<h1><p style="color:salmon;"Red paragraph text>FACTURAS</p></h1>
	<hr/>
	
	<form action="add" method="post">
		<input type="hidden" id="idFactura" name="idFactura" value="${facturasModel.idFactura}">
		<br><br>
		N° Factura
		<input type="text" id="numFactura" name="numFactura" value="${facturasModel.numFactura}">
		<br><br>
		Fecha Venta
		<input type="date" id="fecha" name="fecha" value="${fn:substring(facturasModel.fecha,0,10)}">
		<br><br>
		Total Neto
		<input type="number" step = "any" id="totalNeto" name="totalNeto" value="${facturasModel.totalNeto}">
		<br><br>
		IVA
		<input type="number" step = "any" id="iva" name="iva" value="${facturasModel.iva}">
		<br><br>
		Total
		<input type="number" step = "any" id="total" name="total" value="${facturasModel.total}">
		<br><br>

		Cliente
		<select id="idCliente" name="idCliente">
			<c:forEach var="item" items="${clientes}">
				<option value="${item.idCliente}" ${facturasModel.cliente.idCliente == item.idCliente ? 'selected': '' }>${item.cedula} - ${item.nombre} ${item.apellido}</option>
			</c:forEach>
		</select>
		<br><br>
		
		
		<button type="submit">Guardar</button>
		<button type="button" onclick="window.location.href='/proyecto-web-perfumitos/facturas/findAll; return false;'">Cancelar</button>
	</form>
	
</body>
</html>