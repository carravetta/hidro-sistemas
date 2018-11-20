
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset="utf-8">
        <title>Historico | Hidro Sistemas</title>
        <link rel="icon" href = "imagens/favicon.png">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="/Bootsrap-4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/site.css">
        <link rel="stylesheet" href="css/pedidos.css">
        <link rel="stylesheet" href="css/historico.css">      
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
                        <a href="#" class="btn btn-primary btn-sm">
                            <span class="glyphicon glyphicon-shopping-cart  "></span>
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
                <li>
                    <a href="#"><span class="glyphicon glyphicon-barcode">   </span> Boletos</a>
                </li>
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
                    <a href="#">
                        <span class="glyphicon glyphicon-plus"> </span> Cadastro de cliente
                    </a>
                 </li>
                </c:if>
            </ul>
        </nav>
        
     <!-- Historico de pedidos -->   
    <section class="container">
    
        <h3 class="titulo-pedidos">Historico Pedidos</h3>
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <c:forEach var="h" items="${historicoPedido}" varStatus = "x">       
                <c:if test = "${h.idPedido != historicoPedido[x.count].idPedido}">
                    <div class="panel panel-default">
                        <div class="panel-heading" role="tab" id="heading1"> 
                           <div class="collapse-btn" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse1"
                                aria-expanded="true" aria-controls="collapse1">
                                <strong >
                                    <span class="pull-left">Pedido: ${h.idPedido} </span> 
                                    <span class="pull-right">Qnt</span>
                                    <div class="text-center">
                                        <span>Data:<fmt:formatDate value="${h.data}" pattern= "dd/MM/yyyy"/></span>  
                                    </div>
                                </strong>
                            </div>
                        </div>

                        <div id="collapse1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading1">
                            <div class="panel-body"> 
                                <table class="table table-bordered table-striped table-responsive table-bordered">
                                    <tbody class="text-center">
                                        <c:forEach var="h1" items="${historicoPedido}" varStatus = "y">
                                            <c:if test = "${h1.idPedido == h.idPedido}">
                                                <tr>
                                                    <td class = "codigo-item">${h1.codigo}</td>
                                                    <td>${h1.descricao}</td>
                                                    <td class = "qnt-item-historico">${h1.quantidade}</td>	
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>       
                </c:if>  
            </c:forEach>
        </div> 
            <!-- variaveis:  -->

	 </section>
        
	 <!-- Fim do Historico -->
    </div> <!--sidebar-->   

    <script src="js/jquery.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="js/pedidos.js"></script>
    <script src="js/main.js"></script>
    <script src="js/historico.js"></script>
    
</body>

</html>