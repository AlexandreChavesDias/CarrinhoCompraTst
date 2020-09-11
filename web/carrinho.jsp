<%-- 
    Document   : carrinho
    Created on : 14 de jun de 2020, 13:34:54
    Author     : Usuario
alerts - https://sweetalert.js.org/guides/
https://getbootstrap.com/docs/4.3/getting-started/introduction/

--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Carrinho.jsp</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
          <a class="navbar-brand" href="#">Storage SysC Evolua</a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item active">
                <a class="nav-link" href="Controlador?accion=home">Loja Virtual<span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Ofertas do dia</a>
              </li>
              <li class="nav-item">
                  <a class="nav-link" href="Controlador?accion=home">Continuar comprando</a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
<!--                  <a class="dropdown-item" href="#">Action</a>
                  <a class="dropdown-item" href="#">Another action</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#">Something else here</a>-->
                </div>
              </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
              <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
              <ul class="navbar-nav">
                <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Iniciar Seção
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Sobre</a>
                </div>
              </li>
              </ul>
          </div>
        </nav>
        <div class="container mt-4">
            <h3>Carrinho Sysc Evolua</h3>
            <br>
            <div class="row">
                <div class="col-sm-8">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Item</th>
                                <th></th>
                                <th>Nome</th>
                                <th>Descriçao</th>
                                <th>Preço</th>
                                <th>Qtde</th>
                                <th>Sub Total</th>
                                <th>Ação</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${carrinho}">
                            <tr class="text-center">
                                <td>${car.getItem()}</td>
                                <td><img src="ControladorIMG?id=${car.getIdProduto()}" width="50" height="50"></td>
                                <td>${car.getNomes()}</td>
                                <td>${car.getDescricao()}
<!--                                    <img src="ControladorIMG?id=${car.getIdProduto()}" width="50" height="50">-->
                                </td>
<!--                                <img src="ControladorIMG?id=${car.getIdProduto()}" width="100" height="100">-->
                                <td>R$${car.getPrecoCompra()}</td>
                                <td>${car.getQuantidade()}</td>
<!--                                <td>
                                    <input type="hidden" id="idpro" value="${car.getIdProduto()}">
                                    <input type="number" id="Quantidade" value="${car.getQuantidade()}" class="form-control text-center" min="1"> 
                                </td>-->
                                <td>R$${car.getSubTotal()}</td>
                                <td>
                                    <input type="hidden" id="idp" value="${car.getIdProduto()}">
                                    <a href="#" id="btnDelete">Eliminar</a>

                                </td>
                        </tr>                                 
                            </c:forEach>
                        </tbody>
                    </table> 
                </div>
                <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <h3>Gerar Compra</h3>
                        </div>
                        <div class="card-body">
                           <label>Quantidade de cursos: </label>
                            <input type="text" value="${Quantidade}" readonly="" class="form-control">
                            <label>SubTotal:</label>
                            <input type="text" value="R$ ${totalPagar}" readonly="" class="form-control">
                            <label>Desconto:</label>
                            <input type="text" value="R$ 0.00" readonly="" class="form-control">
                            <label>Total Pagar</label>
                            <input type="text" value="R$ ${totalPagar}" readonly="" class="form-control">
                        </div>
                    </div>
<!--                    <div class="card-footer text-center">
                        <a href="#" class="btn btn-info btn-block">Realizar Pagamento</a>
                        <a href="#" class="btn btn-danger btn-block">Gerar Compra</a>
                    </div>-->
                    <div class="card-footer text-center">
                        <div class="row">
                            <div class="col-sm-20">
                                <a href="Controlador?menu=Carrinho&accion=Carrinho" onclick="print()" class="btn btn-success">Gerar Nota</a>
                                <a href="Controlador?menu=Carrinho&accion=GerarCompra" class="btn btn-success">Comprar</a>
<!--                                <input type="submit" name="accion" value="Cancelar" class="btn btn-danger">-->
                                <a href="Controlador?accion=accion=home" class="btn btn-danger">Voltar a comprar</a>
                            </div>
                            <div class="text-center">                                
                                <br> <label class=" col-sm-20 text-right mt-2">@EvoluaSumaré2020</label>                                                       
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>    
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 
        <script src="js/funcoes.js" type="text/javascript"></script>
        
       </body>        
</html>
