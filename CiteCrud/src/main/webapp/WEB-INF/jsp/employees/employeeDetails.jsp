<!DOCTYPE html>

<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">



<body>
	<div>


		<h2>Edit Information</h2>

		<table>
			<tr>
				<th>Name</th>
				<td><b><c:out value="${employee.employeeName}" /></b></td>
			</tr>
			<tr>
				<th>Date Of Hire</th>
				<td><c:out value="${employee.employeeDateOfHire}" /></td>
			</tr>
			<tr>
				<th>SuperVisor</th>
				<td><c:out value="${employee.supervisor.employeeName}" /></td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td><spring:url value="{employeeId}/edit.html" var="editUrl">
						<spring:param name="employeeId" value="${employee.employeeId}" />
					</spring:url> <a href="${fn:escapeXml(editUrl)}" class="btn btn-info">Edit
						Employee</a></td>
			</tr>
		</table>



	</div>

</body>

</html>
