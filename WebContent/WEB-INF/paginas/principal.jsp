<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 	<html>
    <head>
        <title>Pedidos | Hidro Sistemas</title>
		<link rel="icon" href = "imagens/favicon.png">
        <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="css/easy-autocomplete.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/site.css">
        <link rel="stylesheet" href="css/pedidos.css">
        
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

	<!-- Modal em caso de erros -->
	<c:if test= "${itemInvalido != null }"> 
		<div class="modal fade" tabindex="-1" role="dialog" id= "erro-itens">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title waring">Erro</h4>
			</div>
			<div class="modal-body">
				<p class = "text-danger">${itemInvalido} </p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
			</div>
			</div>
		</div>
		</div>
	</c:if>	


	<c:if test= "${falhaCadastro != null }"> 
		<div class="modal fade" tabindex="-1" role="dialog" id= "erro-itens">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title waring">Erro</h4>
			</div>
			<div class="modal-body">
				<p class = "text-danger">${falhaCadastro} </p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
			</div>
			</div>
		</div>
		</div>
	</c:if>	
	    <!-- Fim do modal de erros-->
		
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
		<legend>Lista de Produtos</legend>
		<div class="row">
			<form action = "exec?tarefa=PesquisaProduto" method = "POST">
				<div class = "col-xs-3" >
					<div class="input-group input-group-lg">
				  		<span class="input-group-addon glyphicon glyphicon-search" id="sizing-addon2"></span>
				  		<input type="text" name="pesquisa" class="form-control input-sm" placeholder="Pesquisar" aria-describedby="sizing-addon1">
					</div>	
				</div>	
			</form>
				<div class="dropdown col-md-offset-8">
				  <button class="btn btn-primary btn-lg dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    Filtrar por:
				    <span class="caret"></span>
				  </button>
				  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				    <li><a href="#">Aspersor</a></li>
				    <li><a href="#">Bocal</a></li>
				    <li><a href="#">Conexões</a></li>
				    <li><a href="#">Controladores</a></li>
				    <li><a href="#">FG</a></li>
				    <li><a href="#">PVC</a></li>
				    <li role="separator" class="divider"></li>
				    <li><a href="#">Geral</a></li>
				  </ul>
				</div>
		</div>
		
	
		
		<c:if test="${listaDePesquisa != null }">
			<div class="listaPesquisa">
				<form action="exec?tarefa=PesquisaProduto&Pagina=1" method="POST">
					<c:forEach var = "pesquisa" items = "${listaDePesquisa }" varStatus = "id">
						<input type="hidden" name="excluirPesquisa" value = "${id.count -1}">
							<button class="btn btn-info " type="submit">
				  				${pesquisa } <span>&times;</span>
							</button>
					</c:forEach>
				</form>
			</div>
		</c:if>
		
		<br>
		<br>
	<c:choose>
		<c:when test="${empty pesquisaProduto }">
			<div class="row">
				<c:forEach var="produto" items = "${listaProdutos}" >
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
			<nav aria-label="Page navigation text-center" class="paginacao">
  			<ul class="pagination">
    		<li>
    		<c:choose>
		    	<c:when test="${param.pagina > 1 }">
	      			<a href="exec?tarefa=Pricipal&pagina=${param.pagina - 1}" aria-label="Previous">
	        			<span aria-hidden="true">&laquo;</span>
	      			</a>
      			</c:when>
      			<c:otherwise>
      				<span aria-hidden="true">&laquo;</span>
      			</c:otherwise>
      		</c:choose>
    		</li>
	    		<c:forEach var="i" begin = "1" end="${totalProduto }" step="1">		
		    		<li><a href="exec?tarefa=Principal&pagina=${i}">${i}</a></li>
			    </c:forEach>
		    <li>
		    	<c:choose>
		    		<c:when test="${param.pagina < 8 }">
		      			<a href="exec?tarefa=Principal&pagina=${param.pagina + 1}" aria-label="Next">
		        		<span aria-hidden="true">&raquo;</span>
		      			</a>
		      		</c:when>	
		      		<c:otherwise>
		        		<span aria-hidden="true">&raquo;</span>
		      		</c:otherwise>
      			</c:choose>
    		</li>
  		</ul>
	</nav>
		</c:when>	
		<c:otherwise>
			<div class="row">
				<c:forEach var="produto" items = "${pesquisaProduto}" >
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
			
			<nav aria-label="Page navigation text-center" class="paginacao">
	  			<ul class="pagination">
		    		<li>
			    		<c:choose>
					    	<c:when test="${param.pagina > 1 }">
				      			<a href="exec?tarefa=PesquisaProduto&pagina=${param.pagina - 1}" aria-label="Previous">
				        			<span aria-hidden="true">&laquo;</span>
				      			</a>
			      			</c:when>
			      			
			      			<c:otherwise>
			      				<span aria-hidden="true">&laquo;</span>
			      			</c:otherwise>	
			      		</c:choose> 
			      		   		
		    		</li>		    		
			    		<c:forEach var="i" begin = "1" end="${totalProduto }" step="1">		
				    		<li><a href="exec?tarefa=PesquisaProduto&pagina=${i}">${i}</a></li>
					    </c:forEach>
				    <li>  
				    	<c:choose>				    	
				    		<c:when test="${param.pagina < totalProduto }">
				      			<a href="exec?tarefa=PesquisaProduto&pagina=${param.pagina + 1}" aria-label="Next">
				        		<span aria-hidden="true">&raquo;</span>
				      			</a>
				      		</c:when>	
				      		
				      		<c:otherwise>
				        		<span aria-hidden="true">&raquo;</span>
				      		</c:otherwise>		      		
		      			</c:choose>		      			
		    		</li>
		    		
	  			</ul>
			</nav>
		</c:otherwise>
	</c:choose>

	</section>

	</div> <!--sidebar-->   

</body>

    <script src="js/jquery.js"></script>
	<script src="js/jquery.easy-autocomplete.js"></script>
    <script src="js/pedidos.js"></script>
    <script src="js/main.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>