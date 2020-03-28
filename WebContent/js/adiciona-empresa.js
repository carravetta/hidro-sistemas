$(function(){

    $("#cep").cep();

    $("#cnpj").mask("000.000.000-000", {
        onKeyPress: function(cnpj, e, field, options){            
            var masks = ['00.000.000/0000-00', '000.000.000-000'];
            var mask = (cnpj.length<=14) ? masks[1] : masks[0];            
            $('#cnpj').mask(mask, options);
        }
    });

    $("#insc-est").mask("000/0000000");

    $("#tel").mask("(00) 00000-0000", {
        onKeyPress: function(tel, e, field, options){            
            var masks = ["(00) 00000-0000", "(00) 0000-00000"];
            var mask = (tel.length>14) ? masks[0] : masks[1]; 
            console.log(tel.length);
                       
            $('#tel').mask(mask, options);
        }
    });
});