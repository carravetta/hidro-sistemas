
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>Perfil | Hidro Sistemas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="icon" href = "imagens/favicon.png">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/site.css">
        <link rel="stylesheet" href="css/pedidos.css">
        <link rel="stylesheet" href="css/verificacao.css">
    </head>
 <body>

    <header class="container-fuid">
        <nav class= "nav-user navbar navbar-default my-flex" role="navigation" id="cabecalho">
        
            <div class ="p-2 titulo-principal">
                <h1>Portal de Pedidos Hidro Sistemas</h1>
            </div>
            
            <div class="p-2 info-user">
                <a href="#">${usuarioLogado.email}</a>
            </div>
            
			<div class="p-2 carrinho-compras"> 
				<a href="exec?tarefa=Carrinho" class="btn btn-info" type="button">
				  Carrinho	 <span class="badge">${carrinho.size()}</span>
				</a>
			</div> 
            
           
        </nav>

    </header>

   <div class="container text-center">
       
        <c:if test= "${pedidoEnviado != null}">
            <div class="sucesso">
                <img src="imagens/sucesso.gif" alt="sucesso"> 
            </div>
            <div>
                <strong>${pedidoEnviado}</strong>
            </div>
        </c:if>

        <div class="hidden sucesso">
            <img src="imagens/sucesso.gif" alt="sucesso"> 
        </div>
        <div class="hidden">
            <strong>Pedido Enviado com sucesso!</strong>
        </div>
       
        <c:if test= "${erroCadastro != null}">
           <div class="erro">
                <img class="erro" src="imagens/erro.png" alt="erro">
            </div>
            <div>
                <strong>${erroCadastro}</strong>
            </div>
        </c:if> 
        
        <c:if test= "${sucessoCadastro != null}">
           <div class="sucesso">
                <img class="erro" src="imagens/sucesso.gif" alt="sucesso">
            </div>
            <div class="text-center">
                <strong>${sucessoCadastro}</strong>
            </div>
        </c:if>    

        
        <a href="exec?tarefa=Principal&pagina=1">
            <span class="btn btn-primary glyphicon glyphicon-home"> Pagina Inicial </span> 
        </a>

   </div> 


    <script src="js/jquery.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>