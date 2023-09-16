<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Facturas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="resources/img/apple-icon.png">
    <link rel="shortcut icon" href="https://cdn.icon-icons.com/icons2/616/PNG/512/bag_cash_check_credit_icon-icons.com_56601.png">


    <style><%@include file="/resources/css/bootstrap.min.css"%></style>
    <style><%@include file="/resources/css/templatemo.css"%></style>
    <style><%@include file="/resources/css/custom.css"%></style>
    <style><%@include file="/resources/css/fontawesome.min.css"%></style>


    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/fontawesome.min.css">
</head>
<body>

	<section class="bg-light py-5">
	 		<div class="container my-4">
				<h1 class="mt-4 text-center text-success ">FACTURAS</h1>
				<hr/>
				<button class="button-regresar" type="button" onclick="window.location.href='/proyecto-web-perfumitos/about.jsp; return false;'">Menu Perfumitos</button>
				<%-- <button class="button-agregar"><a href="${pageContext.request.contextPath}/facturas/findOne?&opcion=1">Agregar</a></button> --%>
				<br>
				
				<form action="findAllBusqueda" method="get">
				<br>
					<div class="contenedor">
						<input class="cuadro-texto " type="search" id="busqueda" name="busqueda">
						<button class="button-container2 button container" type="submit">Buscar</button>
					</div>
				</form>
			</div>
		</section>
	<section class="bg-light py-5">
        <div class="container ">
            <div class=" text-center "> 
                <div class=" m-auto">
                    <div class="table-responsive-sm" id="formContainer">
						<table class="table table-striped">
						<div style="overflow-x:auto;">
							<thead class="table-dark">
								<tr>
									<th> ID </th>
									<th>N° Factura</th>
									<th>Fecha</th>
									<th>Total Neto</th>
									<th>IVA</th>
									<th>Total</th>
									<th>Cliente</th>
									<!-- <th>Acciones</p></th> -->
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="item" items="${facturasModel}">
									<tr>
										<td>${item.idFactura}</td>
										<td>${item.numFactura}</td>
										<td>${item.fecha}</td>
										<td>${item.totalNeto}</td>
										<td>${item.iva}</td>
										<td>${item.total}</td>
										<td>${item.cliente.cedula} - ${item.cliente.nombre} ${item.cliente.apellido}</td>
										<%-- <td>
											<div class="contenedor-flexbox">
											<button class="button-mdf "><a href="${pageContext.request.contextPath}/facturas/findOne?idFactura=${item.idFactura}&opcion=1"><p style="color: black;">Actualizar</p></a></button>
											<button class="button-dlt "><a href="${pageContext.request.contextPath}/facturas/findOne?idFactura=${item.idFactura}&opcion=2"><p style="color: black;">Eliminar</p></a></button>
											</div>
										</td> --%>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
					</div>
				</div>
            </div>
        </div>
        
      <br><br><br><br> 
        	       <!-- contactos abajo -->
    
    <!-- fin -->
    </section>
	<footer class="bg-dark" id="tempaltemo_footer">
      

        <div class="w-100 bg-black py-3">
            <div class="container">
                <div class="row pt-2">
                    <div class="">
                        <center><p class="text-left text-light">
                            Copyright &copy; 2023 Perfumitos S.A
                            
                        </p></center>
                    </div>
                </div>
            </div>
        </div>

    </footer>
	
</body>
</html>