
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>Perfil | Hidro Sistemas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="icon" href = "imagens/favicon.png">
        <link rel="stylesheet" href="css/site.css">
                <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        
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

    <div class="wrapper">
        <nav id="sidebar" class="active">
            <div class="sidebar-header">
                <h3>Hidro Sistemas</h3>
            </div>

            <ul class="list-unstyled components">
               <h3><span class="glyphicon glyphicon-cog"> </span> Opções</h3>
                <li>
                    <a href="exec?tarefa=DigitaPedido"><span class="glyphicon glyphicon-usd"> </span> Pedido</a>
               </li>  
               <li>
                    <a href="exec?tarefa=Perfil"><span class="glyphicon glyphicon-user"> </span> Perfil</a>
               </li>    
               <li>
                   <a href="exec?tarefa=Historico"><span class="glyphicon glyphicon-list-alt">  </span> Histórico</a>
                </li>
<!--                 <li> -->
<!--                     <a href="#"><span class="glyphicon glyphicon-barcode">   </span> Boletos</a> -->
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
                 </c:if>
            </ul>

        </nav>
    <div class = "container">    
		<h3 class = "titulo-pedidos">Perfil do Usuario </h3>
		<aside>
			<ul>
				<li>E-mail: ${usuarioLogado.email}</li>
				<li>Empresa: ${usuarioLogado.fantasia}</li>
				<li>CNPJ: ${usuarioLogado.cnpj_cpf}</li>
				<li>Isnc. Estadual: ${usuarioLogado.inscEstadual}</li>
				<li>Telefone: ${usuarioLogado.telefone}</li>
			</ul>			
		</aside>
	</div>

    </div> <!--sidebar-->   

    <script src="js/jquery.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>