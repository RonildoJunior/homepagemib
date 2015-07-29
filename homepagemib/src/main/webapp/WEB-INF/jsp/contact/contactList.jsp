<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table id="shortMessageTable" class="ui-widget ui-widget-content">
	<thead>
		<tr class="ui-widget-header ">
			<th>Name</th>
			<th>Phone</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${contactList}" var="contact">
			<tr>
				<td><label>${contact.name}</label></td>
				<td><label>${contact.phone}</label></td>
			</tr>
		</c:forEach>
	</tbody>
</table>