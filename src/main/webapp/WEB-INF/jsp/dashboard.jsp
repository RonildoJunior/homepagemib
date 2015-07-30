<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<!-- JQuery CSS -->
<link rel="stylesheet" type="text/css" href="external/jqueryui/jquery-ui.css">

<!-- Project CSS -->
<link rel="stylesheet" type="text/css" href="css/mibUser.css">

<!-- JQuery Libs -->
<script src="/external/jquery/jquery.js"></script>
<script src="/external/jqueryui/jquery-ui.js"></script>

<!-- Project Libs -->
<script src="/js/dashboard.js"></script>
<script src="/js/sms/functions.js"></script>

</head>
<body>

	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">Your Contacts</a></li>
			<li><a href="#tabs-2">Your Messages</a></li>
			<li><a href="#tabs-3">Your Account</a></li>
		</ul>
		<div id="tabs-1">
			<div id="contacts"></div>
			<input id="listContact" type="button" value="List your contacts" />
		</div>
		
		<div id="tabs-2">
			<div id="messages"></div>
			<input id="listShortMessage" type="button" value="List your messages" />
			<input id="openShortMessageDialog" type="button" value="Send one message" />
			
			<div id="createShortMessageDialog" title="Create SMS">
				<fieldset>
					<label for="persistSMSto">to</label>
					<input id="persistSMSto" />
					
					<label for="persistSMSbody">Message</label>
					<input id="persistSMSbody" />
				</fieldset>
				<hr>
				<input id="persistShortMessage" type="button" value="Send" />
			</div>
		</div>
		
		<div id="tabs-3">
			<fieldset>
				<label for="loginName">Name</label>
				<input id="loginName" type="text" value="${user_session_key.name}" />
				
				<label for="loginEmail">Email</label>
				<input id="loginEmail" type="text" value="${user_session_key.email}" disabled />
				
				<label for="loginPassword">Password</label>
				<input id="loginPassword" type="text" value="${user_session_key.password}" />
				
				<label for="loginPhone">Phone</label>
				<input id="loginPhone" type="text" value="${user_session_key.phone}" />
				
				<label for="accountBalance">Balance</label>
				<input id="accountBalance" type="text" value="${user_account_session_key.balance}" disabled />
			</fieldset>
			<input id="editLogin" type="button" value="Save" />
		</div>	
	</div>

</body>
</html>