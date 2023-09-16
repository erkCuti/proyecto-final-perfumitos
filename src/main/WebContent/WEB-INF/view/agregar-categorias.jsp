<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Categoria</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="resources/img/apple-icon.png">
    <link rel="shortcut icon" href="https://cdn.icon-icons.com/icons2/912/PNG/512/edit-category_icon-icons.com_71665.png">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">


    <style><%@include file="/resources/css/bootstrap.min.css"%></style>
    <style><%@include file="/resources/css/templatemo.css"%></style>
    <style><%@include file="/resources/css/custom.css"%></style>
    <style><%@include file="/resources/css/fontawesome.min.css"%></style>


    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/fontawesome.min.css">
</head>
</head>
<body class="bg-light py-5">

<section class="bg-light py-5">
	 		<div class="container my-4">
				<h1 class="mt-4 text-center text-success ">CATEGORIAS</h1>
				<hr/>
			</div>
</section>

		<section>
        <div class="container">
            <div class="row text-center py-3">
                <div class=" m-auto">
                	<div class="label" id="formContainer">
								<form action="add" method="post">
									<input class="form-control" type="hidden" id="idCategoria" name="idCategoria" value="${categoriasModel.idCategoria}">
									<br><br>
									Concentracion
									<input class="form-control" type="text" id="categoriaConcentacion" name="categoriaConcentacion" value="${categoriasModel.categoriaConcentacion}">
									<br><br>
									Aroma
									<input class="form-control" type="text" id="aroma" name="aroma" value="${categoriasModel.aroma}">
									<br><br>
									Descripción
									<input class="form-control" type="text" id="descripcion" name="descripcion" value="${categoriasModel.descripcion}">
									<br><br>
									Durabilidad
									<input class="form-control" type="text" id="durabilidad" name="durabilidad" value="${categoriasModel.durabilidad}">
									<br><br>
									
									<button class="button-mdf-view" type="submit">Guardar</button>
									<button class="button-dlt " type="button" onclick="window.location.href='/proyecto-web-perfumitos/categorias/findAll; return false;'">Cancelar</button>
		
								</form>
						</div>
					</div>
	          	</div>
	       	</div>
	       	
	       	
	
    <!-- fin -->
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
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body >
</html>