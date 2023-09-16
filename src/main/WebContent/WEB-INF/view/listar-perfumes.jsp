<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Perfumes</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="resources/img/apple-icon.png">
    <link rel="shortcut icon" href="https://cdn.icon-icons.com/icons2/1450/PNG/512/scienceandfiction-smell_99218.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">


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
				<h1 class="mt-4 text-center text-success ">PERFUMES</h1>
				<hr/>
				<button class="button-regresar my-2 mx-2" type="button" onclick="window.location.href='/proyecto-web-perfumitos/about.jsp; return false;'">Menu Perfumitos</button>
				<button class="button-agregar my-2 mx-2"><a href="${pageContext.request.contextPath}/perfumes/findOne?&opcion=1">Agregar</a></button>
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
	<section class="bg-light ">
        <div class="contenedor ">
            <div class=" text-center "> 
                <div class=" m-auto">
                    <div class="table-responsive-sm" id="formContainer">
                    <div style="overflow-x:auto;">						
                    <table class="table table-striped">
						<thead class="thead-dark">
						<tr >
								<th > ID </th>
								<th>Nombre</th>
								<th>Marca</th>
								<th>Descripción</th>
								<th>Fabricación</th>
								<th >Fecha Fabricación</th>
								<th>Fecha Expiración</th>
								<th>Colonia For</th>
								<th>Tamaño</th>
								<th>ProduLog</th>
								<th>Precio</th>
								<th>Stock</th>
								<th>Categoria</th>
								<th>Acciones</th>
						</tr>
							</thead>
							
							<tbody>
								<c:forEach var="item" items="${perfumesModel}">
									<tr>
										<td>${item.idProducto}</td>
										<td>${item.nombre}</td>
										<td>${item.marca}</td>
										<td>${item.descripcion}</td>
										<td>${item.fabricacion}</td>
										<td>${fn:substring(item.fechaFabricacion,0,10)}</td>
										<td>${fn:substring(item.fechaExpiracion,0,10)}</td>
										<td>${item.coloniaFor}</td>
										<td>${item.tamanio}</td>
										<td><img with = "100" height = "100" src = "${pageContext.request.contextPath}/resources/img/${item.logo}"</td>
										<td>${item.precio}</td>
										<td>${item.stock}</td>
										<td>${item.categoria.categoriaConcentacion}</td>										
										
										<td>
										<div  class="contenedor-flexbox">
											<button class="button-mdf custom-icon-color " ><a  href="${pageContext.request.contextPath}/perfumes/findOne?idProducto=${item.idProducto}&opcion=1"><i class="fas fa-sync-alt fa-spin"></i><!-- <p style="color: black;">Actualizar</p> --></a></button>
											<br><button class="button-dlt-view custom-icon-color"><a href="${pageContext.request.contextPath}/perfumes/findOne?idProducto=${item.idProducto}&opcion=2"><i class="fas fa-trash-alt"></i></p></a></button>
										</div>
										</td>
										
									</tr>
								</c:forEach>
							</tbody>
						</table><br><br><br><br>
						</div>
					</div>
				</div>
            </div>
        </div>
    </section>
    <!-- contactos abajo -->
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

        
  <script src="resources/js/jquery-1.11.0.min.js"></script>
    <script src="resources/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.bundle.min.js"></script>
    <script src="resources/js/templatemo.js"></script>
    <script src="resources/js/custom.js"></script>
</body>
</html>