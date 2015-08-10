$(document).ready(function() {	
	 
	$("#dialog-message").dialog({
		autoOpen : false,
		modal : true,
		buttons : {
			Ok : function() {
				$(this).dialog("close");
			}
		}
	});

	
	/*Login*/		
	$("#signinBtn").click(function() {
		var email = $('#email').val();
		var password = $('#password').val();
		
		var json = { "email" : email, "password" : password};	
		
		$.ajax({
	        url: "/signin",
	        data: JSON.stringify(json),
	        type: "POST",
	         
	        beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
	        success: function(data) {
	        	if(data.message == "success"){
	        		window.location.replace("/dashboardIndex");
	        	}else{
	        		document.getElementById("dialog_message_label").innerHTML = data.message;
	    			$("#dialog-message").dialog("open");
	        	}
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	            alert("XMLHttpRequest="+XMLHttpRequest.responseText+"\ntextStatus="+textStatus+"\nerrorThrown="+errorThrown);
	        }
	    });
	});

	/*Persist an login*/		
	$("#signupBtn").click(function() {
		var email = $('#email').val();
		var password = $('#password').val();
		var json = { "email" : email, "password" : password};
		
		$.ajax({
	        url: "/signup",
	        data: JSON.stringify(json),
	        type: "POST",
	         
	        beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
	        success: function(data) {
	        	if(data.message == "success"){
	        		window.location.replace("/dashboardIndex");
	        	}else{
	        		document.getElementById("dialog_message_label").innerHTML = data.message;
	    			$("#dialog-message").dialog("open");
	        	}
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	            alert("XMLHttpRequest="+XMLHttpRequest.responseText+"\ntextStatus="+textStatus+"\nerrorThrown="+errorThrown);
	        }
	    });
		
	});
});