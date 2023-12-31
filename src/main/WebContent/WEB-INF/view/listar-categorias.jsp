<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado Categoria</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="resources/img/apple-icon.png">
    <link rel="shortcut icon" href="https://cdn.icon-icons.com/icons2/912/PNG/512/settings-for-categories_icon-icons.com_71570.png">
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
	
				<h1 class="mt-4 text-center text-success ">CATEGORIAS</h1>
				<hr/>
				<button class="button-regresar my-2 mx-2" type="button" onclick="window.location.href='/proyecto-web-perfumitos/about.jsp; return false;'">Menu Perfumitos</button>
				<button class="button-agregar my-2 mx-2"><a href="${pageContext.request.contextPath}/categorias/findOne?&opcion=1">Agregar</a></button>
				<br>
				
				<form action="findAllBusqueda" method="get">
				<br>
					<div class="contenedor">		
						<input  class="cuadro-texto mx-2" type="search" id="busqueda" name="busqueda">
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
						<div style="overflow-x:auto;">
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th> ID </th>
									<th>Concentacion</th>
									<th>Aroma</th>
									<th>Descripcion</th>
									<th>Durabilidad</th>
									<th>Acciones</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach var="item" items="${categoriasModel}">
									<tr>
										<td>${item.idCategoria}</td>
										<td>${item.categoriaConcentacion}</td>
										<td>${item.aroma}</td>
										<td>${item.descripcion}</td>
										<td>${item.durabilidad}</td>
										<td>
											<div class="contenedor-flexbox">
												<button class="button-mdf custom-icon-color"><a href="${pageContext.request.contextPath}/categorias/findOne?idCategoria=${item.idCategoria}&opcion=1"><i class="fas fa-sync-alt fa-spin"></i></a></button>
												<button class="button-dlt-view custom-icon-color"><a href="${pageContext.request.contextPath}/categorias/findOne?idCategoria=${item.idCategoria}&opcion=2"><i class="fas fa-trash-alt"></i></a></button>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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
</body>
</html>