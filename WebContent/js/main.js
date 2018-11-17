$(function () {


    //Ação de mostrar/esconder sidebar
    $('#sidebarCollapse').click( function () {
        $('#sidebar').toggleClass('active');
    });

    //Ação de adicionar linhas
    $("#adicionar-linha").click(function(event){
        event.preventDefault();
       insereLinha();
    });

    $("#limpa-lista").click(function(event){
        event.preventDefault();
       limpaLista();
    });


    $("#gera-cot").on("click", function(event){
    	
    	$("#dados").html("");
    	$("#dadosCli").html("");
    	$("#info-ped").html("");
    	$("#head-ped").html("");
    	$("#itens-ped").html("");
        event.preventDefault();
        montaInfoPedido();
        montaItensPedido();
    });   
    	
    $(".jsonProdutos").easyAutocomplete(autocompleteOptions());
    
	$("input").on("change" , function(){
		verificaInputs();
	})
	
	$('#erro-itens').modal('show');
	
	$('#envia-cot').one('click', function(){
		$('#envia-cot').addClass('disabled');
		$('#envia-cot').attr("aria-disabled", "true");
	});
	
	setInterval(function(){
		$('#alerta-sucesso').alert('close')
	}, 2000);
    
    $('.button-collapse').click(function(){
      console.log("click");
      
        
    })
    
});