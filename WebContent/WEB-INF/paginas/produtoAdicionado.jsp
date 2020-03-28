<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 	<html>
    <head>
        <title>Carrinho | Hidro Sistemas</title>
		<link rel="icon" href = "imagens/favicon.png">
        <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="css/easy-autocomplete.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/site.css">
        <link rel="stylesheet" href="css/pedidos.css">
        <link rel="stylesheet" href="css/produtoAdicionado.css">
        
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
			<div class="p-2" id="content">
				<nav class="navbar navbar-expand-lg navbar-light bg-light">           
					<button type="button" id="sidebarCollapse" class="btn btn-info btn-md btn-menu">
						<span class="glyphicon glyphicon-th-list"></span>
					</button>
				</nav>
			</div>
			
		</nav>

	</header>
		
    <div class="wrapper">
        <nav id="sidebar" class="active">
            <div class="sidebar-header">
                <h3>Hidro Sistemas</h3>
            </div>

            <ul class="list-unstyled components">
               <h3><span class="glyphicon glyphicon-cog"> </span> Opções</h3>
                <li>
                    <a href="exec?tarefa=Principal&pagina=1"><span class="glyphicon glyphicon-usd"> </span> Pedido</a>
               </li>  
               <li>
                    <a href="exec?tarefa=Perfil"><span class="glyphicon glyphicon-user"> </span> Perfil</a>
               </li>    
               <li>
                   <a href="exec?tarefa=Historico" class="historico-btn"><span class="glyphicon glyphicon-list-alt">  </span> Histórico</a>
                </li>
<!--                 <li> -->
<!--                     <a href="#" data-toggle="tooltip" data-placement="right" title="Em breve"> -->
<!-- 						<span class="glyphicon glyphicon-barcode">   </span> Boletos -->
<!-- 					</a> -->
<!--                 </li> -->
                <li>
                    <a href="#">
                            <span class="glyphicon glyphicon-send">   </span> Contate-nos
                    </a>
                </li>
                <li>
                    <a href="http://www.hidrosistemas.com" target="blank_">
                        <span class="glyphicon glyphicon-info-sign">   </span> Sobre
                    </a>
                </li>
                <li>
	                    <a  href="exec?tarefa=Logout">
	                        <span class="glyphicon glyphicon-log-out">   </span> Sair
	                    </a>
                </li>
                <c:if test = "${usuarioLogado.admin }"> 
              	  <h3><span class="glyphicon glyphicon-pencil"> </span> Administrador</h3>
              	  <li>
                    <a href="exec?tarefa=AdicionaEmpresa">
                        <span class="glyphicon glyphicon-plus">   </span> Cadastro de cliente
                    </a>
                  </li>
                </c:if>
            </ul>

        </nav>
	<section class="container">
		<legend>Produto Adicionado ao Carrinho</legend>
		<div class="well">
			<div class="row">
				<div class="col-sm-6 col-md-4">
			  		<div class="thumbnail">
				      	<img src="${ultimoItem.link }" alt="${ultimoItem.descricao }">
				      	<div class="caption">
				        	<h3>${ultimoItem.descricao }</h3>			 
				      	</div>
			    	</div>
		  		</div>
		</div>
			<c:choose>
				<c:when test="${empty pesquisaProduto }">
					<form action="exec?tarefa=Principal&pagina=${ultimaPagina }" method="POST">
						<div class="input-group col-xs-2 qnt">
						  <span class="input-group-addon" id="basic-addon1">Quantidade:	</span>
						  <input type="number" name="qnt" class="form-control" value="1" aria-describedby="basic-addon1" min="1">
						</div>
						<p><button class="btn btn-primary" role="submit">Continuar Comprando</button></p>
						<!-- <p><a href="exec?tarefa=Carrinho" class="btn btn-primary" role="submit">
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>Carrinho</a></p> -->
					</form>
				</c:when>
				<c:otherwise>
					<form action="exec?tarefa=PesquisaProduto&pagina=${ultimaPagina }" method="POST">
						<div class="input-group col-xs-2 qnt">
						  <span class="input-group-addon" id="basic-addon1">Quantidade:	</span>
						  <input type="number" name="qnt" class="form-control" value="1" aria-describedby="basic-addon1" min="1">
						</div>
						<p><button class="btn btn-primary" role="submit">Continuar Comprando</button></p>
						<!-- <p><a href="exec?tarefa=Carrinho" class="btn btn-primary" role="submit">
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>Carrinho</a></p> -->
					</form>
				
				</c:otherwise>
			</c:choose>
		</div>
		
		<c:if test = "${!empty listaGrupo }">
			<legend>Itens Relacionados</legend>
			<div class="row">
			<c:forEach var="produto" items = "${listaGrupo}" >
				<form  action="exec?tarefa=AddCarrinho" method="POST">
		  			<div class="col-sm-6 col-md-4">
		    			<div class="thumbnail listThumb">
		      				<img src=${produto.link } alt="${produto.descricao }" class="img-produto2 img-thumbnail">
				      		<div class="caption">
					        	<p>${produto.descricao}<p>
					        	<input type="hidden" name ="descricao" value="${produto.descricao }">
					        	<input type="hidden" name ="codigo" value="${produto.codigo }">
					        	<input type="hidden" name ="link" value= "${produto.link }">
					        	<input type="hidden" name ="fantasia" value="${produto.fantasia }">
					        	<input type="hidden" name ="unidade" value= "${produto.unidade }">
					        	<input type="hidden" name ="grupo" value= "${produto.grupo }">
					        	<p><button class="btn btn-primary" role="button" type="submit">
					        	<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add Carrinho</button></p>
				      		</div>
		    			</div>
		  			</div>
			  	</form>
			</c:forEach>
		</div>	
	</c:if>		
	</section>
			
</div>   

</body>

    <script src="js/jquery.js"></script>
	<script src="js/jquery.easy-autocomplete.js"></script>
    <script src="js/pedidos.js"></script>
    <script src="js/main.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>