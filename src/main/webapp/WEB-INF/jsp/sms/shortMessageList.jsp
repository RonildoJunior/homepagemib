<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="shortMessageTable" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header ">
			<th>From</th>
			<th>To</th>
			<th>Message</th>
			<th>Price</th>
			<th>Sent</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${shortMessageList}" var="sms">
			<tr>
				<td><label>${sms.from}</label></td>
				<td><label>${sms.to}</label></td>
				<td><label>${sms.body}</label></td>
				<td><label>${sms.price}</label></td>
				<td><label>${sms.registeredFormated}</label></td>
			</tr>
		</c:forEach>
	</tbody>
</table>