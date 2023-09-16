<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Detalles</title>
</head>
<body>

	<h1><p style="color:fuchsia;"Red paragraph text>DETALLES</p></h1>
	<hr/>
	
	<form action="add" method="post">
		<input type="hidden" id="idFacturaDetalle" name="idFacturaDetalle" value="${facDetallesModel.idFacturaDetalle}">
		<br><br>
		Cantidad
		<input type="number" id="cantidad" name="cantidad" value="${facDetallesModel.cantidad}">
		<br><br>
		Subtotal
		<input type="number" step = "any" id="subtotal" name="subtotal" value="${facDetallesModel.subtotal}">
		<br><br>

		Factura
		<select id="idFactura" name="idFactura">
			<c:forEach var="item" items="${facturas}">
				<option value="${item.idFactura}" ${facDetallesModel.factura.idFactura == item.idFactura ? 'selected': '' }>${item.numFactura}</option>
			</c:forEach>
		</select>
		<br><br>
		
		Producto - Perfume
		<select id="idProducto" name="idProducto">
			<c:forEach var="item" items="${perfumes}">
				<option value="${item.idProducto}" ${facDetallesModel.producto.idProducto == item.idProducto ? 'selected': '' }>${item.nombre} - ${item.marca}</option>
			</c:forEach>
		</select>
		<br><br>
		
		
		<button type="submit">Guardar</button>
		<button type="button" onclick="window.location.href='/proyecto-web-perfumitos/facturasDetalle/findAll; return false;'">Cancelar</button>
	</form>

</body>
</html>