
$(function(){
	alteraAtributosPainel();
	
})

function alteraAtributosPainel(){
	var collapseBtn = $('.panel').find(".collapse-btn");
	var panelHeading = $('.panel').find('#heading1');
	var panelGroup = $('.panel').find('#collapse1');

	collapseBtn.each(function(index, elemnt){
		$(this).attr("href", "#collapse"+index);
		$(this).attr("aria-controls", "#collapse"+index );	
		$(panelHeading[index]).attr("id", "heading"+index);		
		$(panelGroup[index]).attr("id", "collapse"+index);
	});
	
	
}