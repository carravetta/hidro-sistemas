function montaLinha(){ // botao adicionar linha
    var tr = $("<tr>");
    var tdItem = $("<td>");
    var tdDescricao = $("<td>");
    var tdQuantidade = $("<td>");
    var numItem =  $("#corpo-tabela").find("tr").length+1;
    var inputDescricao = $("<input name = 'desc' type='text' class='item input-tabela form-control jsonProdutos'>");
    var inputQuantidade = $("<input name = 'qnt' type='number' class='quantidade-item input-tabela form-control col-lg-2' min='1'>");
   
    tdItem.append(numItem);
    tdDescricao.append(inputDescricao);
    tdQuantidade.append(inputQuantidade);
   
    tr.append(tdItem);
    tr.append(tdDescricao);
    tr.append(tdQuantidade);

    
    return tr;  

}

function autocompleteOptions(){
	var options = {

	  		  url: "/hidro-sistemas/JSONProdutos.json",
	  		  getValue: "descricao",
	  		  template: {
	  		        type: "description",
	  		        fields: {
	  		            description: "unidade"
	  		        }
	  		    },
	  		    
	  		  list: {	
	  			  
	  			maxNumberOfElements: 50,
	  			showAnimation: {
	  				type: "fade", 
	  				time: 400,
	  				callback: function() {}
	  			},
	  			hideAnimation: {
	  				type: "slide", 
	  				time: 400,
	  				callback: function() {}
	  			},
	  		    match: {
	  		      enabled: true
	  		    }
	  		  },
	  		};

	return options;
}


function insereLinha(){ // botao insere linhas
    var corpoTabela = $("#corpo-tabela");
    var linha = montaLinha();
        corpoTabela.append(linha);
   $(".jsonProdutos").easyAutocomplete(autocompleteOptions());
    
}

function limpaLista(){ // botao limpa lista
    var linha = $("#corpo-tabela").find("tr");

    linha.each(function(){
        var td = $(this).find("td");
        var input = td.find("input").val("");
        
    });

}

// functions montagem de cotação modal

function montaItensPedido(){
   
    var montaCabecalho = "<table class='table table-bordered table-striped table-responsive col-md-2'id='itens-ped'>"+
    "<thead>"+
        "<th>Item</th>"+
        "<th>Descricao</th>"+
        "<th>Quantidade</th>"+
    "</thead>"+
    "<tbody class='text-center' id='lista-itens'>";

    $("#head-ped").append(montaCabecalho);
    
    var tabela = $("#corpo-tabela").find("tr");
    var cont = 1;
    var listaItens = $("#lista-itens");

    tabela.each(function(){
        
        var numItem = cont++;
        var descricao = $(this).find(".item");
        var quantidade = $(this).find(".quantidade-item");

    if(descricao.val().length != 0){

    var montaLista = "<tr>"+
                        "<td>"+numItem+"</td>"+
                        "<td>"+descricao.val()+"</td>"+
                        "<td>"+quantidade.val()+"</td>"+
                     "</tr>";
       
    listaItens.append(montaLista);
    }
    });
    
   
}
    

function montaInfoPedido(){
    var data = new Date;

    var info =  "<table class='table table-bordered table-striped table-responsive col-md-2' id='info-ped'>"+
        "<tbody>"+
            "<tr>"+
                "<td>"+
                    "<strong>Número do Pedido: <span id='num-ped'>234</span></strong>"+
                "</td>"+
                "<td>"+ 
                    "<strong>Dt. Emissão: <span id='data-ped'>17/08/2018</span> </strong>"+
               "</td>"+
            "</tr>"+
        "</tbody>"+
    "</table>";

    $("#info-ped").append(info);
}

// fim das functions de montagem de cotação



function verificaInputs(){
	var contaInput = 0;
	var contaInputErro = 0;
	
	var inputDesc = new Array();
	var inputQnt = new Array();

	$('.item').each(function()
		{
			inputDesc.push($(this).val());
		        
		});
	
	$('.quantidade-item').each(function()
		{
			inputQnt.push($(this).val());
		        
		});
		
	for(var i = 0; i<inputDesc.length; i++){
		if(inputDesc[i] != "" && inputQnt[i] != "")
			{
				$("#gera-cot").removeClass("disabled");
				$("#gera-cot").attr("aria-disabled", "false");
				contaInput++;
				
			}
		
		if(inputDesc[i] != "")
			{
				if( inputQnt[i] == ""){
					$("#gera-cot").addClass("disabled");
					$("#gera-cot").attr("aria-disabled", "true");
					contaInputErro++;
					
				}
			}
		if(inputQnt[i] != "")
		{
			if( inputDesc[i] == ""){// como verificar se esta nulo?
				$("#gera-cot").addClass("disabled");
				$("#gera-cot").attr("aria-disabled", "true");
				contaInputErro++;
				
			}
		}
		
		if(inputDesc[i] == "" && inputQnt[i] == ""){
			if(contaInput>0 && contaInputErro==0){
				$("#gera-cot").removeClass("disabled");
				
			}
		}
	}
}

	