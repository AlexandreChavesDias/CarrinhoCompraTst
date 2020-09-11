<%-- 
    Document   : index
    Created on : 14 de jun de 2020, 13:15:45
    Author     : Usuario
    https://getbootstrap.com/docs/4.3/getting-started/introduction/
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page - index.jsp</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
<!-- pagina do bootstrap - navbar -->
<!--https://getbootstrap.com/docs/4.3/components/navbar/-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <a class="navbar-brand" href="#">Storage SysC Evolua</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link" href="Controlador?accion=home">Loja Virtual <span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Ofertas do dia</a>
              </li>
              <li class="nav-item">
                  <a class="nav-link" href="Controlador?accion=Carrinho" <i class="fas fa-cart-plus">(<label style="color: orange">${contador}</label>)</i>Carrinho de compras</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
<!--                  <a class="dropdown-item" href="#">Action</a>
                  <a class="dropdown-item" href="#">Another action</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#">Something else here</a>-->
                </div>
              </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
              <input class="form-control mr-sm-2" type="search" placeholder="Digite o curso" aria-label="Search">
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar Curso</button>
            </form>
              <ul class="navbar-nav">
                <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Login
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
              </li>
              </ul>
          </div>
        </nav>
        <div class=""container mt-2>
            <div class="row">
                <c:forEach var="p" items="${produtos}" >
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header text-center">
<!--                            <label>${p.getNome()}</label>-->
                             <h2>${p.getNome()}</h2>
                        </div>
                            <div class="card-body text-center">
                                <h1>R$ ${p.getPreco()}</h1>
<!--                                      <img src="ControladorIMG?id=${p.getId()}" width="200" height="180">-->
                            </div>
                            <div class="card-body text-center">
<!--                                <i>R$${p.getPreco()}</i>-->
                                      <img src="ControladorIMG?id=${p.getId()}" width="200" height="200">
                            </div>
                        <div class="card-footer text-center">
                            <label>${p.getDescricao()}</label>
                            <div>
<!--                                <a href="Controlador?accion=AddCarrinho&id=${p.getId()}" class="btn btn-outline-info">Add ao carrinho</a>-->
                                <a href="Controlador?accion=Comprar&id=${p.getId()}" class="btn btn-danger">Comprar</a>
                            </div>
                        </div>
                        <br>
                    </div>
                </div>                      
                </c:forEach>
            </div>
        </div>        
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
