<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión Tienda perfumes</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="resources/img/apple-icon.png">
    <link rel="shortcut icon" type="image/x-icon" href="resources/img/PERFUMITOS.ico">

    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/templatemo.css">
    <link rel="stylesheet" href="resources/css/custom.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    


    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="resources/css/fontawesome.min.css">
</head>
<body>
    <!-- Barra principal -->
    <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
        <div class="container text-light">
            <div class="w-100 d-flex justify-content-between">
                <div>
                    <i class="fa fa-envelope mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">perfumitos@company.com</a>
                    <i class="fa fa-phone mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">069-069-6640</a>
                </div>

            </div>
        </div>
    </nav>
    <!-- fin barra-->

    <!-- Header -->
    <nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <a class="navbar-brand text-success logo h1 align-self-center" href="index.jsp">
                Perfumi S.A
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.jsp">Gestion Perfumeria</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="contact.jsp">Contactanos</a>
                        </li>
                    </ul>
                </div>
                <div class="navbar align-self-center d-flex">
                    <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
                        <div class="input-group">
                            <input type="text" class="form-control" id="inputMobileSearch" placeholder="Search ...">
                            <div class="input-group-text">
                                <i class="fa fa-fw fa-search"></i>
                            </div>
                        </div>
                    </div>
                    <a class="nav-icon d-none d-lg-inline" href="#" data-bs-toggle="modal" data-bs-target="#templatemo_search">
                        <i class="fa fa-fw fa-search text-dark mr-2"></i>
                    </a>

                    <a class="nav-icon position-relative text-decoration-none" href="#">
                        <i class="fa fa-fw fa-user text-dark mr-3"></i>
                        <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">0</span>
                    </a>
                </div>
            </div>

        </div>
    </nav>
    <!-- Fin Header -->

    <!-- buscrador -->
    <div class="modal fade bg-white" id="templatemo_search" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="w-100 pt-1 mb-5 text-right">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="" method="get" class="modal-content modal-body border-0 p-0">
                <div class="input-group mb-2">
                    <input type="text" class="form-control" id="inputModalSearch" name="q" placeholder="Search ...">
                    <button type="submit" class="input-group-text bg-success text-light">
                        <i class="fa fa-fw fa-search text-white"></i>
                    </button>
                </div>
            </form>
        </div>
    </div>

    <!-- Seleccion de tablas-->
    <section class="container py-5">
        <div class="row text-center pt-5 pb-3">
            
        </div>
        <div class="row">

            <div class="col-md-6 col-lg-3 pb-5 text-center">
                <ul class="text-center h-100 py-5 services-icon-wap shadow">
                    <div class="h1 text-success"><i class="fas fa-glass-martini"></i></div>
                    <a class="h5 mt-4 " href="${pageContext.request.contextPath}/perfumes/findAll" >Perfumes </a>
                </ul>
            </div>

            <div class="col-md-6 col-lg-3 pb-5 text-center">
                <ul class="h-100 py-5 services-icon-wap shadow">
                    <div class="h1 text-success text-center"><i class="fa fa-user"></i></div>
                    <a class="h5 mt-4 text-center" href="${pageContext.request.contextPath}/clientes/findAll" >Clientes</a>             
                </ul>   
            </div>

            <div class="col-md-6 col-lg-3 pb-5 text-center">
                <ul class="h-100 py-5 services-icon-wap shadow">
                    <div class="h1 text-success text-center"><i class="fas fa-th-large"></i></div>
                    <a class="h5 mt-4 text-center"href="${pageContext.request.contextPath}/categorias/findAll" >Categoria</a>
                </ul>
            </div>

            <div class="col-md-6 col-lg-3 pb-5 text-center">
                <ul class="h-100 py-5 text-center services-icon-wap shadow">
                    <div class="h1 text-success text-center"><i class="fas fa-file-invoice"></i></div>
                    <a class="h5 mt-4 text-center"href="${pageContext.request.contextPath}/facturas/findAll" >Facturas</a>
                </ul>
            </div>
            
            <div class="col-md-6 col-lg-3 pb-5 contenedor"> </div>
            
            <div class="col-md-6 col-lg-3 pb-5 text-center">
                <ul class="h-100 py-5 services-icon-wap shadow">
                    <div class="h1 text-success text-center"><i class="fas fa-book-open"></i></div>
                    <a class="h5 mt-4 text-center"href="${pageContext.request.contextPath}/facturasDetalle/findAll" >Factura Detalle</a>
                </ul>   
            </div>
           
            <div class=" col-md-6 col-lg-3 pb-5 text-center">
                <ul class="h-100 py-5 services-icon-wap shadow">
                    <div class="h1 text-success text-center"><i class="fas fa-file-invoice-dollar"></i></div>
                    <a class="h5 mt-4 text-center"href="${pageContext.request.contextPath}/facturacion/principal" >Facturacion</a>
                </ul>
            </div>
        </div>
    </section>
    <!-- fin de tablas -->

    <!-- tabla 1 -->
    <section class="bg-light py-5">
        <div class="container my-4">
            <div class="row text-center py-3">
                <div class=" m-auto">
                    <h1 class="h1 label " style="display: none;" >Formularios</h1>
                    <div  class="embed-responsive embed-responsive-16by9" id="formContainer">
                                  
<iframe class="embed-responsive-item" title="ProyectoPerfumitos" width="1140" height="541.25" src="https://app.powerbi.com/reportEmbed?reportId=7d82911e-05dc-43c8-adb9-c7cabcd86c47&autoAuth=true&ctid=5489579d-44b5-4792-af49-e9be4633a3d5" frameborder="0" allowFullScreen="true"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--End Brands-->
    
    <!-- Start Footer -->
    <footer class="bg-dark" id="tempaltemo_footer">
        <div class="container">
            <div class="row">

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Perfumitos </h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li>
                            <i class="fas fa-map-marker-alt fa-fw"></i>
                           Tumbaco
                        </li>
                        <li>
                            <i class="fa fa-phone fa-fw"></i>
                            <a class="text-decoration-none" href="tel:010-020-0340">Numero</a>
                        </li>
                        <li>
                            <i class="fa fa-envelope fa-fw"></i>
                            <a class="text-decoration-none" href="mailto:info@company.com">perfumitos@company.com</a>
                        </li>
                    </ul>
                </div>

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-success border-bottom pb-3 border-light logo">Productos</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none">Perfumes tales marcas como:</a></li>
                        <li><a class="text-decoration-none">ésika,  cyzone  y  L'Bel</a></li>
   
                    </ul>
                </div>

                <div class="col-md-4 pt-5">
                    <h2 class="h2 text-light border-bottom pb-3 border-light">Group Names</h2>
                    <ul class="list-unstyled text-light footer-link-list">
                        <li><a class="text-decoration-none" href="index.jsp"></a></li>
                        <li><a class="text-decoration-none" >Alejandro Cuti</a></li>
                        <li><a class="text-decoration-none" >José Julian Cueva</a></li>
                        <li><a class="text-decoration-none" >Joseph Saavedra</a></li>
                    </ul>
                </div>  

            </div>
            
            
               <div class="row text-light mb-4">
                <div class="col-12 mb-3">
                    <div class="w-100 my-3 border-top border-light"></div>
                </div>
                <div class="col-auto me-auto">
                    <ul class="list-inline text-left footer-icons">
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                        </li>
                        <li class="list-inline-item border border-light rounded-circle text-center">
                            <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
            
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
    <!-- End Footer -->

    <!-- Start Script -->
    <script src="resources/js/custom.js"></script>
    <script src="resources/js/jquery-1.11.0.min.js"></script>
    <script src="resources/js/jquery-migrate-1.2.1.min.js"></script>
    <script src="resources/js/bootstrap.bundle.min.js"></script>
    <script src="resources/js/templatemo.js"></script>
    <script src="resources/js/tablas.js"></script>
    <!-- End Script -->

                                               
</body>
</html>