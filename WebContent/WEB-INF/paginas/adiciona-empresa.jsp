
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>Cadastro | Hidro Sistemas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <link rel="icon" href = "imagens/favicon.png">
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/site.css">
        <link rel="stylesheet" href="css/pedidos.css">
        <link rel="stylesheet" href="css/adiciona-empresa.css">
        
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
            
<!--             <div class="p-2 carrinho-compras"> -->
<!--                 <a href="#" class="btn btn-primary btn-sm"> -->
<!--                     <span class="glyphicon glyphicon-shopping-cart  "></span> -->
<!--                 </a> -->
<!--             </div> -->
            
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
    <section class = "container"  id="form-dadosEmp">    
        <legend>Dados da Empresa </legend>

        <form class="form-horizontal" method="POST" action="exec?tarefa=CadastraEmpresa">
            <div class="form-group">
                <label for="razao-social" class="col-sm-2 control-label">Razão Social</label>
                <div class="col-sm-6">
                    <input type="text" name = "razaoSocial" class="form-control" id="razao-social">
                </div>
            </div>

            <div class="form-group">
                <label for="fantasia" class="col-sm-2 control-label">Nome Fantasia</label>
                <div class="col-sm-6">
                    <input type="text" name = "fantasia" class="form-control" id="fantasia">
                </div>
            </div>

            <div class="form-group">
                <label for="cnpj" class="col-sm-2 control-label">CNPJ/CPF</label>
                <div class="col-sm-6">
                    <input name = "cnpj" class="form-control" id="cnpj">
                </div>
            </div>
            
            <div class="form-group">
                <label for="insc-est" class="col-sm-2 control-label">Inscrição Estadual</label>
                <div class="col-sm-6">
                    <input type="text" name = "insc-est" class="form-control" id="insc-est">
                </div>
            </div>

            <legend>Endereço de Entrega</legend>

                <div class="form-group ">
                    <label for="cep" class="col-sm-2 control-label">CEP</label>
                    <div class="col-sm-2">
                        <input type="text" name = "cep" class="form-control" id="cep">
                    </div>
                </div>

                <div class="form-group ">
                    <label for="rua" class="col-sm-2 control-label">Rua</label>
                    <div class="col-sm-6">
                        <input type="text" name = "rua" class="form-control" id="rua" data-cep="logradouro">
                    </div>
                </div>

                <div class="form-group ">
                    <label for="numero" class="col-sm-2 control-label">Numero</label>
                    <div class="col-sm-2">
                        <input type="text" name = "numero" class="form-control" id="numero">
                    </div>
                </div>

                <div class="form-group ">
                    <label for="bairro" class="col-sm-2 control-label">Bairro</label>
                    <div class="col-sm-6">
                        <input type="text" name = "bairro" class="form-control" id="bairro" data-cep="bairro">
                    </div>
                 </div>

                <div class="form-group ">
                    <label for="cidade" class="col-sm-2 control-label">Cidade</label>
                    <div class="col-sm-6">
                        <input type="text" name = "cidade" class="form-control" id="cidade" data-cep="cidade">
                    </div>
                </div>

                <div class="form-group ">
                    <label for="estado" class="col-sm-2 control-label">Estado</label>
                    <div class="col-sm-6">
                        <input type="text" name = "estado" class="form-control" id="estado" data-cep="uf">
                    </div>
                 </div>

                 <div class="form-group ">
                    <label for="tel" class="col-sm-2 control-label">Telefone</label>
                    <div class="col-sm-2">
                        <input type="tel" name = "tel" class="form-control" id="tel" placeholder="51 999999999">
                    </div>
                </div>

                <legend>Dados de Login </legend>

                <div class="form-group ">
                    <label for="email" class="col-sm-2 control-label">E-mail</label>
                    <div class="col-sm-4">
                        <input type="email" name = "email" class="form-control" id="email" placeholder="cliente@email.com.br">
                    </div>
                </div>

                <div class="form-group ">
                    <label for="senha" class="col-sm-2 control-label">Senha</label>
                    <div class="col-sm-4">
                        <input type="text" name = "senha" class="form-control" id="senha">
                    </div>
                </div>

                <button type="submit" class="btn btn-primary btn-lg pull-right" id="envia-cadastro">Cadastrar</button>

        </form>
        
    </section>

    </div> <!--sidebar-->   

    <script src="js/jquery.js"></script>
    <script src="js/main.js"></script>
    <script src="js/adiciona-empresa.js"></script>
    <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="js/jquery.cep.min.js"></script>
    <script src="js/jquery.mask.js"></script>
    <script src="/imagens/Imagens produtos/10120209.PNG"></script>

</body>

</html>