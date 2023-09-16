<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Facturación</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="resources/img/apple-icon.png">
    <link rel="shortcut icon" href="https://cdn.icon-icons.com/icons2/3087/PNG/512/bill_invoice_payment_receipt_billing_icon_191398.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
	   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
	<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-QV3FyRQCfPzsn8VO2jb5w5tzxwKg8bhZ0B36fFQCMhBdQ6IpFmP6jzZq5LbBq9a6SZ34DGl+eOvo2E0WtrAJhIw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 -->

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
				<h1 class="mt-4 text-center text-success ">FACTURACION</h1>
					<div class="contenedor-flexbox">
						<button class="button-regresar mx-3" type="button" onclick="window.location.href='/proyecto-web-perfumitos/about.jsp; return false;'">Menu Perfumitos</button>
						<br></div>
					<div class="contenedor-flexbox">
						<button class="button button-agr-per mx-3" id="show-button-cliente">Agregar Cliente</button>
						<button class="button button-agr-fac mx-3" id="show-button-perfume">Agregar Perfume</button>
						
					</div>
				<hr>
			</div>
	</section>	
	<section class="bg-light py-3">
        <div class="container ">
            <div class=" text-center "> 
                <div class=" m-auto">
						<div>
						<dialog id="alert-dialog-clientes">
							<form action="findOneCliente" id="formCliente" name="formCliente" method="get">
							<table  class="table  table-striped">
								<thead class="thead-dark">
									<tr>
										<th scope="col">Acciones</th>
										<th scope="col">ID</th>
										<th scope="col">Cédula</th>
										<th scope="col">Nombre</th>
										<th scope="col">Apellido</th>
										<th scope="col">Dirección</th>
										<th scope="col">Teléfono</th>
										<th scope="col">Correo</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${clientesModel}">
										<tr>
											<td>
												<button class="btn btn-success "><a href="${pageContext.request.contextPath}/facturacion/findOneCliente?idCliente=${item.idCliente}">Agregar</a></button>
											</td>
											<td>${item.idCliente}</td>
											<td>${item.cedula}</td>
											<td>${item.nombre}</td>
											<td>${item.apellido}</td>
											<td>${item.direccion}</td>
											<td>${item.telefono}</td>
											<td>${item.correo}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</form>	
						  <button class="btn btn-danger" onClick="this.parentElement.close()">Cerrar</button>
						</dialog>
						</div>
						
						<div>
						<dialog id="alert-dialog-perfumes">
							<form action="findOneProducto" id="formPerfume" name="formPerfume" method="get">
							<table  class="table  table-striped">
								<thead class="thead-dark">
									<tr>
										<th scope="col">Acciones</th>
										<th scope="col">Logo</th>
										<th  scope="col">ID Perfumes</th>
										<th scope="col">Nombre</th>
										<th scope="col">Marca</th>
										<th scope="col">Descripcion</th>
										<th scope="col">Fabricacion</th>
										<th scope="col">Fecha Fabricacion</th>
										<th scope="col">fecha Expiracion</th>
										<th scope="col">Colonia For</th>
										<th scope="col">Tamaño</th>
										<th scope="col">Precio</th>
										<th scope="col">Stock</th>
										<th scope="col">Categoria</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${perfumesModel}">
										<tr>
											<td>
												<button class="btn btn-success"><a href="${pageContext.request.contextPath}/facturacion/findOneProducto?idProducto=${item.idProducto}">Agregar</a></button>
											</td>
											<td><img with="100" height="100" src="${pageContext.request.contextPath}/resources/img/${item.logo}"</td>
											<td>${item.idProducto}</td>
											<td>${item.nombre}</td>
											<td>${item.marca}</td>
											<td>${item.descripcion}</td>
											<td>${item.fabricacion}</td>
											<td>${item.fechaFabricacion}</td>
											<td>${item.fechaExpiracion}</td>
											<td>${item.coloniaFor}</td>
											<td>${item.tamanio}</td>
											<td>${item.precio}</td>
											<td>${item.stock}</td>
											<td>${item.categoria.categoriaConcentacion}</td>										
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</form>	
						  <button class="btn btn-danger" onClick="this.parentElement.close()">Cerrar</button>
						</dialog>
						</div>
						
						
			<form action="addDetalle" id="formDetalles" name="formDetalles"  method="post">	
				<div class="container">
				    <div class="row form-outline">
				        Num Factura:
						<input type="text" id="numFactura" name="numFactura" value="${numFactura}"  disabled />
									Fecha:
									<input type="date" id="fechaActual" name="fechaActual" value="${fn:substring(fechaActual,0,10)}" disabled />
									<div><br></div>
						<div class="col-md-4">
				           	<div class="form-group">
									Total Neto:
									<input  class="form-outline" type="number" step="any" id="totalNeto" name="totalNeto" value="${totalNeto}" placeholder="00.00" disabled/>
							</div>
       			 		</div>
						<div class="col-md-4">
				           	<div class="form-group">
									IVA:
									<input  class="form-outline" type="number" step="any" id="iva" name="iva" value="${iva}" placeholder="00.00" disabled/>
							</div>
       			 		</div>
						<div class="col-md-4">
				           	<div class="form-group">
									Total:
									<input  class="form-outline" type="number" step="any" id="total" name="total" value="${total}" placeholder="00.00" disabled/>
							</div>
       			 		</div>
									<div><button class="btn btn-success col-md-6 my-3" type="submit" onclick="${pageContext.request.contextPath}/facturacion/addDetalle?list=${list}">COMPRAR</button></div>		
									<br><br><br>
						
									<h3>Cliente</h3>
						
										<input type="hidden" id="idCliente" name="idCliente" value="${cliente.idCliente}">
							
										Cedula
										<input type="text" id="cedula" name="cedula" value="${cliente.cedula}" disabled>
							
										Nombre
										<input type="text" id="nombre" name="nombre" value="${cliente.nombre}" disabled>
										Apellido
										<input type="text" id="apellido" name="apellido" value="${cliente.apellido}" disabled>
							
										Direccion
										<input type="text" id="direccion" name="direccion" value="${cliente.direccion}" disabled>
							
										Telefono
										<input type="number" id="telefono" name="telefono" value="${cliente.telefono}" disabled>
							
										Correo
										<input type="email" id="correo" name="correo" value="${cliente.correo}" disabled>		
								</div>
							</form>
						</div>
					</div>		
				</div>		
	   </section>
	   
	<section class="bg-light py-3">
        <div class="container ">
            <div class=" text-center "> 
                <div class=" m-auto">					
						<div class="container mt-5">
						    <div class="row">
						        <div class="col-md-6">
						<form action="addDetalleTemporal" id="formDetallesTemporal" name="formDetallesTemporal"  method="get">		
								<br>
											<h3> Agregar Detalles </h3>
											<c:forEach var="item" items="${list}">
													
												<input type="hidden" value="${item.idFacturaDetalle}">
												<label class="row justify-content-center">Cantidad</label> 
												<input class="form-outline" type="number" value="${item.cantidad}" disabled>	
												<label class="row justify-content-center">Descripcion</label> 	
												<input class="form-outline" type="text" value="${item.producto.nombre}" disabled>
												<label class="row justify-content-center">Precio</label>
												<input class="form-outline" type="number" step="any" value="${item.producto.precio}" disabled>
												<label class="row justify-content-center">Subtotal</label> 
												<input class="form-outline" type="number" step="any" value="${item.subtotal}" disabled>
												<label class="row justify-content-center">Stock</label>						
												<input class="form-outline" type="number" step="any" value="${item.producto.stock}" disabled>
												<br> <br>
												<button class="btn btn-warning" type="button" onclick="document.getElementById('opcionDetalle').value='1';
																			  document.getElementById('idFDList').value=${item.idFacturaDetalle};
																			  document.getElementById('name').value='${item.producto.nombre}';
																			  document.getElementById('marca').value='${item.producto.marca}';
																			  document.getElementById('cantidad').value=${item.cantidad};
																			  document.getElementById('stock').value=${item.producto.stock};
																			  document.getElementById('logo').src='${pageContext.request.contextPath}/resources/img/${item.producto.logo}';										  
																			  document.getElementById('name').style.display='block';										  
																			  document.getElementById('marca').style.display='block';
																			  document.getElementById('logo').style.display='block';									
																			  document.getElementById('cantidad').style.display='block';
																			  document.getElementById('stock').style.display='block';	  										  
																			  document.getElementById('btnGuardarPerfume').style.display='block';
												 							">Editar</button>
												 <button class="btn btn-danger" type="button" onclick="document.getElementById('opcionDetalle').value='2';
																			  document.getElementById('idFDList').value=${item.idFacturaDetalle};
																			  document.getElementById('formDetallesTemporal').submit(); 										  										  
															 				">Eliminar</button>
												<br/>		
											</c:forEach>
									</div>	
								<div class="col-md-6">
									<h3><label hidden="true">Perfumes</label></h3>
										
										<input type="hidden" id="opcionDetalle" name="opcionDetalle" value="1" />
										<br/>
										<!-- id -->		
										<input type="hidden" id="idFDList" name="idFDList" value="" />
										<br/><br/>		
										<div>
											<div style="float:left">
												<img style="display: none;" id="logo" name="logo" width="250" height="250" src="" />
											</div>
											<div>
												<label hidden="true">NOMBRE</label>
												<input style="display: none;" type="text" id="name" name="name" value="" disabled />
												<br/>
												<label hidden="true">MARCA</label>
												<input style="display: none;" type="text" id="marca" name="marca" value="" disabled />
												<br/>
												<label hidden="true">STOCK</label>
												<input style="display: none;" type="number" id="stock" name="stock" value="" disabled />
												<br/>
												<label hidden="true">CANTIDAD</label>
												<input style="display: none;" type="number" id="cantidad" name="cantidad" value="" />
												<br/>  
												
												<button class="btn btn-success" style="display: none;" id="btnGuardarPerfume" name="btnGuardarPerfume" type="button" onclick="document.getElementById('opcionDetalle').value='1';
																			   document.getElementById('name').style.display='none';	
																			   document.getElementById('marca').style.display='none';							   
																			   document.getElementById('logo').style.display='none';
																			   document.getElementById('cantidad').style.display='none';
																			   document.getElementById('btnGuardarPerfume').style.display='none';
																			   document.getElementById('formDetallesTemporal').submit();
																			   ">Guardar</button>
										</div>
									</div>
								</div>		
							</div>
						</form>
					</div>
				</div>
			</div>			
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

	<script src="${pageContext.request.contextPath}/resources/js/jquery-3.7.1.js"></script>
	<script>
	
		const showButtonCliente = document.querySelector("#show-button-cliente");
		showButtonCliente.addEventListener("click", function () {
		  const alertDialogCliente = document.querySelector("#alert-dialog-clientes");
		  alertDialogCliente.showModal();
		});
		
		
		const showButtonPerfume = document.querySelector("#show-button-perfume");
		showButtonPerfume.addEventListener("click", function () {
		  const alertDialogPerfume = document.querySelector("#alert-dialog-perfumes");
		  alertDialogPerfume.showModal();
		});
	</script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>