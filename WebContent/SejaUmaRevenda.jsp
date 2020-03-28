<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 	<html>
 	
    <head> 
        <title>Seja uma Revenda | Hidro Sistemas</title>
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
				<a href="exec?tarefa=Catalogo">Catálogo</a>
			</div>	
		</nav>
	</header>

	<section class="container ">
		<legend>Solicitação para tornar-se uma revenda!</legend>
		<p class="revenda">Preencha os campos abaixo, e iremos análisar sua solicitação. Assim que a analise for realizada entraremos em 
		 contato com você atráves dos dados informados abaixo.</p>	
		 <br>
		 <br>	
	<form class="form-horizontal">
	  	<div class="form-group">
		    <label for="inputEmail" class="col-sm-2 control-label">Email</label>
		    <div class="col-sm-10">
		      <input type="email" class="form-control" id="inputEmail3" placeholder="seu@email.com.br">
		    </div>
	  	</div>
	  	<div class="form-group">
		    <label for="razao-social" class="col-sm-2 control-label">Razão Social/Nome</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="razao-social" placeholder="Sua Razão Social ou Nome">
		    </div>
	  	</div>
	   	<div class="form-group">
		    <label for="telefone" class="col-sm-2 control-label">Fone</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" id="telefone" placeholder="(DD) 00000-000">
		    </div>
	  	</div>
	  	<div class="form-group">
		    <label for="cep" class="col-sm-2 control-label">CEP</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" id="cep" placeholder="Seu CEP">
		  	</div>
	  	</div>
	  	<div class="form-group">
		    <label for="rua" class="col-sm-2 control-label">Rua</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="rua">
		  	</div>
	  	</div>
	  	<div class="form-group">
		    <label for="bairro" class="col-sm-2 control-label">Bairro</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="bairro">
		  	</div>
	 	</div>
	  	<div class="form-group">
		    <label for="num" class="col-sm-2 control-label">Número</label>
		    <div class="col-sm-10">
		      <input type="number" class="form-control" id="num">
		  	</div>
	  	</div>
	  	<div class="form-group">
		    <label for="cidade" class="col-sm-2 control-label">Cidade</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" id="cidade">
		  	</div>
	  	</div>
	  	<div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-primary">Enviar</button>
		    </div>
	  	</div>
	</form>
	
	</section>
			
</body>

    <script src="js/jquery.js"></script>
    <script src="js/pedidos.js"></script>
    <script src="js/main.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</html>