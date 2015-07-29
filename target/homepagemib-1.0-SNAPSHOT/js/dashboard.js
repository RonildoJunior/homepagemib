$(document).ready(function() {
	
	$("#tabs").tabs();
	
	$("#openShortMessageDialog").click(function() {
		$("#createShortMessageDialog").dialog("open");
	});
	$("#createShortMessageDialog").dialog({
		autoOpen : false,
		modal : true,
		show : {
			effect : "blind",
			duration : 1000
		},
		hide : {
			effect : "explode",
			duration : 1000
		}
	});
	

});