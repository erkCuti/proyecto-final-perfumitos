<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Clientes</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="resources/img/apple-icon.png">
    <link rel="shortcut icon" href="https://cdn.icon-icons.com/icons2/1585/PNG/512/3709746-customer-evaluation-review-satisfaction-system_108070.png">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">


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
				<h1 class="mt-4 text-center text-success ">CLIENTES</h1>
				<hr/>
			</div>
</section>
<section class="bg-light py-5">
        <div class="container">
            <div class="row text-center py-3">
                <div class=" m-auto">
                	<div class="label" id="formContainer">
						<form action="add" method="post">
							<input class="form-control" type="hidden" id="idCliente" name="idCliente" value="${clientesModel.idCliente}">
							<br><br>
							Cedula
							<input class="form-control" type="text" id="cedula" name="cedula" value="${clientesModel.cedula}">
							<br><br>
							Nombre
							<input class="form-control" type="text" id="nombre" name="nombre" value="${clientesModel.nombre}">
							<br><br>
							Apellido
							<input class="form-control" type="text" id="apellido" name="apellido" value="${clientesModel.apellido}">
							<br><br>
							Direccion
							<input class="form-control" type="text" id="direccion" name="direccion" value="${clientesModel.direccion}">
							<br><br>
							Telefono
							<input class="form-control" type="number" id="telefono" name="telefono" value="${clientesModel.telefono}">
							<br><br>
							Correo
							<input class="form-control" type="email" id="correo" name="correo" value="${clientesModel.correo}">
							<br><br>
							<button class="button-mdf-view" type="submit">Guardar</button>
							<button class="button-dlt " type="button" onclick="window.location.href='/proyecto-web-perfumitos/clientes/findAll; return false;'">Cancelar</button>
						</form>
						<footer class="bg-dark" id="tempaltemo_footer">
					</div>
				</div>
          	</div>
     	</div>
</section>
      

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
</html>