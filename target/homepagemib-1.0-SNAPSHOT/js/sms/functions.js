$(document).ready(function() {

	/*Persist sms*/		
	$("#persistShortMessage").click(function() {
		var to = $('#persistSMSto').val();
		var body = $('#persistSMSbody').val();
		
		var json = { "to" : to, "body" : body};	
		
		$.ajax({
	        url: "/persistShortMessage",
	        data: JSON.stringify(json),
	        type: "POST",
	         
	        beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
	        success: function(shortMessage) {
	        	$.get("/listShortMessage",function(data,status){
	    			document.getElementById("messages").innerHTML = data;
	    		});
	        }
	    });
	});
	
	/*Edit login*/		
	$("#editLogin").click(function() {
		var loginName = $('#loginName').val();
		var loginEmail = $('#loginEmail').val();
		var loginPassword = $('#loginPassword').val();
		var loginPhone = $('#loginPhone').val();
		
		var json = { "name" : loginName, "email" : loginEmail, "password" : loginPassword, "phone" : loginPhone};	
		
		$.ajax({
	        url: "/editLogin",
	        data: JSON.stringify(json),
	        type: "POST",
	         
	        beforeSend: function(xhr) {
	            xhr.setRequestHeader("Accept", "application/json");
	            xhr.setRequestHeader("Content-Type", "application/json");
	        },
	        success: function(shortMessage) {
	        	
	        }
	    });
	});
	
	/*List sms*/		
	$("#listShortMessage").click(function() {
		$.get("/listShortMessage",function(data,status){
			document.getElementById("messages").innerHTML = data;
		});
	});
	
	/*List contacts*/		
	$("#listContact").click(function() {
		$.get("/listContact",function(data,status){
			document.getElementById("contacts").innerHTML = data;
		});
	});
	
});