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
        <link rel="stylesheet" href="css/carrinhoCompras.css">
        
        
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
		<legend>Carrinho de Compras</legend>
			<form action = "exec?tarefa=EnviaPedido" method="POST">
				<table class="table table-striped">
					<thead class="text-center">
						<th>#</th>
						<th>Descrição</th>
						<th>Quantidade</th>
						<th> <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></th>
					</thead>
					<tbody>
					<c:forEach var="produto" items = "${carrinho }" varStatus="id">
						<tr class="text-center">
							<td>${id.count }</td>
							<td>${produto.descricao}</td>
							<td class="col-xs-1">
								<input name = "qnt" value='${produto.quantidade }' type="number" class="active quantidade-item input-tabela form-control col-lg-2" min="1">
							</td>
							<td>
								<a href="exec?tarefa=DeletaItemCarrinho&item=${id.count }" type="button" class="btn btn-default" aria-label="Left Align">
	  								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
								</a>
							<td>
						</tr>	
					</c:forEach>			
					</tbody>
				</table>
				<c:choose>
				<c:when test="${!empty carrinho }">
					<button type="submit" data-toggle="modal" data-target=".bs-example-modal-lg" class="btn btn-primary" aria-label="Rigth Align">
	  					<span class="glyphicon glyphicon-send" aria-hidden="true"> Enviar</span>
					</button>
					<div class="modal fade bs-example-modal-lg" aria-labelledby="myLargeModalLabel">
 						<div class="modal-dialog modal-lg" >
    						<div>
      							<img class="imagem-loading" src="./imagens/loadingtwo.gif" />
    						</div>
  						</div>
					</div>
					
				</c:when>
				<c:otherwise>
					<button type="submit" class="btn btn-primary disabled" aria-label="Rigth Align">
	  					<span class="glyphicon glyphicon-send" aria-hidden="true"> Enviar</span>
					</button>
				</c:otherwise>
				</c:choose>
				<br>
			</form>
			<p><a href="exec?tarefa=Principal&pagina=${ultimaPagina }" class="btn btn-primary cnt-comprando" role="button">Continuar Comprando</a></p>
	</section>
			
</div>   

</body>

    <script src="js/jquery.js"></script>
	<script src="js/jquery.easy-autocomplete.js"></script>
    <script src="js/pedidos.js"></script>
    <script src="js/main.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>