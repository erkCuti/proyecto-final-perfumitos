<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar Clientes</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="resources/img/apple-icon.png">
    <link rel="shortcut icon" href="https://cdn.icon-icons.com/icons2/69/PNG/128/file_delete_remove_13907.png">
    <link rel="shortcut icon" type="image/x-icon" href="resources/img/PERFUMITOS.ico">

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
				</div><br><br>
</section>
<section class="bg-light py-5">
        <div class="container">
            <div class="row text-center py-3">
                <div class=" m-auto">	
					<form action="del" method="get">
						<input type="hidden" id="idCliente" name="idCliente" value="${clientesModel.idCliente}">
						<strong class="h1">¿Desea eliminar el Cliente?</strong>
						<br><br>
						<button class="button-dlt " type="submit">Eliminar</button>
						<button class="button-cncl"  type="button" onclick="window.location.href='/proyecto-web-perfumitos/clientes/findAll; return false;'">Cancelar</button>
					</form>
				</div>
	         </div>
	     </div><br><br><br><br><br><br><br>
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
</body>
</html>