<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Detalles</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="resources/img/apple-icon.png">
    <link rel="shortcut icon" href="https://cdn.icon-icons.com/icons2/1124/PNG/512/walletwithbillsoutlinedsymbol_79625.png">


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
				<h1 class="mt-4 text-center text-success ">FACTURA DETALLE</h1>
				<hr/>
				<button class="button-regresar" type="button" onclick="window.location.href='/proyecto-web-perfumitos/about.jsp; return false;'">Menu Perfumitos</button>
<%-- 				<button class="button-agregar"><a href="${pageContext.request.contextPath}/facturasDetalle/findOne?&opcion=1">Agregar</a></button> --%>
				<br>
				
			</div>
	</section>
	<section class="bg-light py-5">
        <div class="container ">
            <div class=" text-center "> 
                <div class=" m-auto">
                    <div class="table-responsive-sm" id="formContainer">
                    <div style="overflow-x:auto;">
						<table class="table table-striped">
							<thead class="table-dark">
								<tr>
									<th> ID </th>
									<th>Cantidad</th>
									<th>Subtotal</th>
									<th>Factura</th>
									<th>Perfume</th>
								<!-- 	<th>Acciones</th> -->
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="item" items="${facDetallesModel}">
									<tr>
										<td>${item.idFacturaDetalle}</td>
										<td>${item.cantidad}</td>
										<td>${item.subtotal}</td>
										<td>${item.factura.numFactura}</td>
										<td>${item.producto.nombre} - ${item.producto.marca}</td>
										<%-- <td>
											<div class="contendor-flexbox">
											<button class="button-mdf "><a href="${pageContext.request.contextPath}/facturasDetalle/findOne?idFacturaDetalle=${item.idFacturaDetalle}&opcion=1"><p style="color: black;">Actualizar</p></a></button>
											<button class="button-dlt "><a href="${pageContext.request.contextPath}/facturasDetalle/findOne?idFacturaDetalle=${item.idFacturaDetalle}&opcion=2"><p style="color: black;">Eliminar</p></a></button>
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
        
                	       <!-- contactos abajo -->
    
    </section>
    <footer class="bg-dark" id="tempaltemo_footer">
      

        <div class="w-100 bg-black py-3">
            <div class="container">
                <div class="row pt-2">
                    <div class="col-12">
                        <center><p class="text-left text-light">
                            Copyright &copy; 2023 Perfumitos S.A
                            
                        </p></center>
                    </div>
                </div>
            </div>
        </div>

    </footer>
    <!-- fin -->
</body>
</html>