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
        <link rel="stylesheet" href="bootstrap-4.1/css/bootstrap.min.css">
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

	<c:if test= "${pedidoEnviado != null}">
		<div class="alert alert-success" role="alert" id = "alerta-sucesso">
		<strong>${pedidoEnviado}</strong>
		</div>
	</c:if>

	<!-- Modal em caso de erro nos itens -->
	<c:if test= "${itemInvalido != null }"> 
		<div class="modal fade" tabindex="-1" role="dialog" id= "erro-itens">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title">Erro</h4>
			</div>
			<div class="modal-body">
				<p>${itemInvalido} </p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
			</div>
			</div>
		</div>
		</div>
	</c:if>	

	    <!-- Fim do modal de erro do item -->
		
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
                        <span class="glyphicon glyphicon-plus">   </span> Cadastro de cliente
                    </a>
                  </li>
                </c:if>
            </ul>

        </nav>
	<section class="container tabela pedidos">
	
		<form action="exec?tarefa=InserePedido" method="POST">
				<h3 class="titulo-pedidos">Cotação</h3>
				<div class="container-fluid pedidos-toolbar">
					<div class="btn-toolbar pull-right" role="toolbar">
						<div class="btn-group pull-right">
							<a href="#" class="btn btn-success btn-md" id="adicionar-linha" title="Adicionar linha">
								<span class="glyphicon glyphicon-plus"></span>
							</a>
							<a href="#" class="btn btn-danger btn-md " id="limpa-lista">
								<span class="glyphicon glyphicon-trash" title="Limpar lista"></span>
							</a>
						</div>
					</div> 
				</div>  
			
					<table class="table table-bordered table-striped table-responsive" id="tabela-cotacao">
						<thead class="text-center">
							<th id='thItem'>Item</th>
							<th id='thDesc'>Descrição</th>
							<th id='thQnt'>Qnt</th>
						</thead>
						<tbody class="text-center" id="corpo-tabela">
							<tr>
								<td class="num-item">1</td>
								<td><input name="desc" type='text' class='item input-tabela form-control jsonProdutos'></td>
								<td><input name = "qnt" type="number" class="quantidade-item input-tabela form-control col-lg-2" min="1"></td>
							</tr>
							<tr>
								<td class="num-item">2</td>
								<td><input  name="desc" type='text' class='item input-tabela form-control jsonProdutos'></td>
								<td><input name = "qnt" type="number" class="quantidade-item input-tabela form-control col-lg-2" min="1"></td>
							</tr>
							<tr>
								<td class="num-item">3</td>
								<td><input name="desc" type='text' class='item input-tabela form-control jsonProdutos'></td>
								<td><input name = "qnt" type="number" class="quantidade-item input-tabela form-control col-lg-2" min="1"></td>
							</tr>
							<tr>
								<td class="num-item">4</td>
								<td><input  name="desc" type="text" class="item input-tabela form-control jsonProdutos" ></td>
								<td><input name = "qnt" type="number" class="quantidade-item input-tabela form-control col-lg-2" min="1"></td>
							</tr>
							<tr>
								<td class="num-item">5</td>
								<td><input  name="desc" type="text" class="item input-tabela form-control jsonProdutos" ></td>
								<td><input name = "qnt" type="number" class="quantidade-item input-tabela form-control col-lg-2" min="1"></td>
							</tr>
						</tbody>
					</table>
			
					<a href="#" class="btn btn-primary btn-md pull-right disabled"  data-toggle="modal" data-target=".bs-example-modal-lg" id="gera-cot" role="button">
						<span class="glyphicon glyphicon-ok"></span> GERAR COTAÇÃO
					</a>
			
			<!--Modal de gera cotacao-->
					
				
					<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
						<div class="modal-dialog modal-lg" role="document">  
							<div class="modal-content">
								<div class="modal-body">
									<table class='table table-bordered table-striped table-responsive col-md-2'>
										<tbody>
											<td>
												<p>RAZÃO SOCIAL: HIDROSP SISTEMAS HIDRAULICOS LTDA</p>
												<p>RUA: PANDIA CALOGERAS, 45</p>
												<p>BAIRRO: NITEROI</p>
												<p>CANOAS, RIO GRANDE DO SUL</p>
												<p>E-MAIL: irpcanoas@hidrosistemas.com</p>
											</td>
											<td>
												<p>CNPJ: 82.275.918/0004-50</p>
												<p>INSC. EST: 7020247400042</p>
												<p>CEP: 92120-150</p>
												<p>TEL: 51 3075-7217</p>
											</td>
										</tbody>
									</table>
									<table class='table table-bordered table-striped table-responsive col-md-2'>
										<tbody>
											<td>
												<p>RAZÃO SOCIAL: ${usuarioLogado.razaoSocial}</p>
												<p>RUA: ${usuarioLogado.rua}, ${usuarioLogado.numero}</p>
												<p>BAIRRO: ${usuarioLogado.bairro}</p>
												<p>${usuarioLogado.cidade}, ${usuarioLogado.estado}</p>
												<p>E-MAIL: ${usuarioLogado.email}</p>
											</td>
											<td>
												<p>CNPJ/CPF: ${usuarioLogado.cnpj_cpf}</p>
												<p>INSC. EST: ${usuarioLogado.inscEstadual}</p>
												<p>CEP: ${usuarioLogado.cep}</p>
												<p>TEL: ${usuarioLogado.telefone}</p>
											</td>
										</tbody>
									</table>
								<!--   <span id="info-ped"></span>-->
									<span id="head-ped"></span>
									<span id="itens-ped"></span>
									<button type="submit" class="btn btn-primary btn-md " id="envia-cot">Enviar</button>
								</div>   
							</div>
						</div>
					</div>			    
			</form> 
	</section>
			
<!--FIM Modal de gera cotacao-->
</div> <!--sidebar-->   

    <script src="js/jquery.js"></script>
    <script src="js/jquery.easy-autocomplete.js"></script>
    <script src="js/pedidos.js"></script>
    <script src="js/main.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="bootstrap-4.1/js/bootstrap.min.js"></script>
    
</body>

</html>