<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Perfumes</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="resources/img/apple-icon.png">
    <link rel="shortcut icon" href="https://cdn.icon-icons.com/icons2/503/PNG/512/natural-perfume_icon-icons.com_49224.png">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    


    <style><%@include file="/resources/css/bootstrap.min.css"%></style>
    <style><%@include file="/resources/css/templatemo.css"%></style>
    <style><%@include file="/resources/css/custom.css"%></style>
    <style><%@include file="/resources/css/fontawesome.min.css"%></style>


    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/fontawesome.min.css">
</head>
<body class="bg-light py-5">

<section class="bg-light py-5">
	 		<div class="container my-4">
				<h1 class="mt-4 text-center text-success ">PERFUMES</h1>
				<hr/>
			</div>
</section>
<section>
        <div class="container">
            <div class="row text-center py-3">
                <div class=" m-auto">
                	<div class="label" id="formContainer">
					<form action="add" method="post">
						<input type="hidden" id="idProducto" name="idProducto" value="${perfumesModel.idProducto}">
						<br><br>
						<div class="form-group">
							<label for="nombre">Nombre</label>
							<input class="form-control" type="text" id="nombre" name="nombre" value="${perfumesModel.nombre}">
							<br>
						</div>	
						Marca
						<input class="form-control" type="text" id="marca" name="marca" value="${perfumesModel.marca}">
						<br>
						Descripción
						<input  class="form-control" type="text" id="descripcion" name="descripcion" value="${perfumesModel.descripcion}">
						<br><
						Fabricación
						<input class="form-control" type="text" id="fabricacion" name="fabricacion" value="${perfumesModel.fabricacion}">
						<br>
						Fecha de Fabricación
						<input class="form-control" type="date" id="fechaFabricacion" name="fechaFabricacion" value="${fn:substring(perfumesModel.fechaFabricacion,0,10)}">
						<br>
						Fecha de Expiracion
						<input class="form-control" type="date" id="fechaExpiracion" name="fechaExpiracion" value="${fn:substring(perfumesModel.fechaExpiracion,0,10)}">
						<br>
						Colonia For
						<input class="form-control" type="text" id="coloniaFor" name="coloniaFor" value="${perfumesModel.coloniaFor}">
						<br>
						Tamanio
						<input class="form-control" type="text" id="tamanio" name="tamanio" value="${perfumesModel.tamanio}">
						<br>
						Logo
						<input class="form-control" type="text" id="logo" name="logo" value="${perfumesModel.logo}">
						<br>
						Precio
						<input class="form-control" type="number" step = "any" id="precio" name="precio" value="${perfumesModel.precio}">
						<br>
						Stock
						<input class="form-control" type="number" id="stock" name="stock" value="${perfumesModel.stock}">
						<br>
						Categoria
						<select class="form-control" id="idCategoria" name="idCategoria">
							<c:forEach  var="item" items="${categorias}">
								<option value="${item.idCategoria}" ${perfumesModel.categoria.idCategoria == item.idCategoria ? 'selected': '' }>${item.categoriaConcentacion} - ${item.aroma}</option>
							</c:forEach>
						</select>
						<br><br>
						
						
						<button class="button-mdf-view" type="submit">Guardar</button>
						<button class="button-dlt " type="button" onclick="window.location.href='/proyecto-web-perfumitos/perfumes/findAll; return false;'">Cancelar</button>
					</form>
					</div>
				</div>
          	</div>
     	</div>
     	
     	<!-- contactos abajo -->
    
    <!-- fin -->
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
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</body>
</html>