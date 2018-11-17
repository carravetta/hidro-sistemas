<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <title>Login | Hidro Sistemas</title>
    <link rel="icon" href = "imagens/favicon.png">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/easy-autocomplete.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/site.css">
    <link rel="stylesheet" href="css/index.css">
</head>

<body>
    <header>
        <h1 id="titulo-principal" class="text-center">Portal de pedidos Hidro Sistemas</h1>
    </header>

   
        <div class="container banner-hidro ">
            <figure>
                <img src="http://www.hidrosistemas.com/wp-content/uploads/2015/04/hidrosistemas-logo-300x90.png" alt="Logotipo Hidro Sistemas" class="img-responsive">
            </figure>
        </div>  
    

        <section class="container form-login ">
            <form action="exec?tarefa=Login" method="POST" class="control-label">
            	<span class = erro-login>${erroLogin}</span>
                <div class="form-group">    
                    <label for="email" class="control-label">E-mail:</label>
                    <input type="email" name="e-mail" class="form-control input-sm" id="email" placeholder="Seu email" required>
                </div>

                <div class="form-group">
                    <label for="senha" class="control-label">Senha:</label>
                    <input type="password" name ="senha" class="form-control input-sm" id="senha" placeholder="Sua senha" required>
                </div>               
                <button type="submit" class="btn btn-primary pull-right">Entrar</button>

            </form>    
            
        </section>
 

        <script src="js/jquery.js"></script>
        <script src="js/jquery.easy-autocomplete.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
        <script src="js/pedidos.js"></script>
        <script src="js/main.js"></script>

        

</body>

</html>
