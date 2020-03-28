<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 	<html>
 	<c:if test="${empty param.tarefa }">
 			 <c:redirect url="http://localhost:8080/hidro-sistemas/exec?tarefa=Catalogo"/>
 	</c:if>
    <head> 
        <title>Catalogo | Hidro Sistemas</title>
		<link rel="icon" href = "imagens/favicon.png">
        <meta charset="utf-8" name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="css/easy-autocomplete.css">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">  
        <link rel="stylesheet" href="css/site.css">
        <link rel="stylesheet" href="css/pedidos.css">
        <link rel="stylesheet" href="css/catalogo.css">
        
    </head>

<body>
	<header class="container-fuid">
		<nav class= "nav-user navbar navbar-default my-flex" role="navigation" id="cabecalho">
		
			<figure>
		    	<img src="http://www.hidrosistemas.com/wp-content/uploads/2015/04/hidrosistemas-logo-300x90.png" alt="Logotipo Hidro Sistemas" class="img-responsive">
		    </figure>
			<div class ="p-2 titulo-principal">
				<h1>Hidro Sistemas</h1>
			</div>
			<div class="p-2 carrinho-compras"> 
				<a href="index.jsp" class="btn btn-info" type="button">
				 <span class="glyphicon glyphicon-user"></span> Login	 
				</a>
			</div> 
			
			<div class="p-2 info-user">
				<a href="SejaUmaRevenda.jsp">Seja uma revenda</a>
			</div>
			
		</nav>

	</header>

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
					<form  action="#" method="POST">
			  			<div class="col-sm-6 col-md-4">
			    			<div class="thumbnail listThumb">
			      				<img src=${produto.link } alt="${produto.descricao }" class="img-produto2 img-thumbnail">
					      		<div class="caption">
						        	<p>${produto.descricao}<p>
						        	
						        	<input type="hidden" name ="codigo" value="${produto.codigo }">						        
						        	<p><button class="btn btn-primary" role="button" type="submit">
						        	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Detalhes</button></p>
					      		</div>
			    			</div>
			  			</div>
				  	</form>
				</c:forEach>
			</div>
			</div>
			<nav aria-label="Page navigation text-center" class="paginacao">
  			<ul class="pagination">
    		<li>
    		<c:choose>
		    	<c:when test="${param.pagina > 1 }">
	      			<a href="exec?tarefa=Catalogo&pagina=${param.pagina - 1}" aria-label="Previous">
	        			<span aria-hidden="true">&laquo;</span>
	      			</a>
      			</c:when>
      			<c:otherwise>
      				<span aria-hidden="true">&laquo;</span>
      			</c:otherwise>
      		</c:choose>
    		</li>
	    		<c:forEach var="i" begin = "1" end="${totalProduto }" step="1">		
		    		<li><a href="exec?tarefa=Catalogo&pagina=${i}">${i}</a></li>
			    </c:forEach>
		    <li>
		    	<c:choose>
		    		<c:when test="${param.pagina < 8 }">
		      			<a href="exec?tarefa=Catalogo&pagina=${param.pagina + 1}" aria-label="Next">
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
					<form  action="#" method="POST">
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
						        	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Detalhes</button></p>
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
			
</body>

    <script src="js/jquery.js"></script>
	<script src="js/jquery.easy-autocomplete.js"></script>
    <script src="js/pedidos.js"></script>
    <script src="js/main.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>