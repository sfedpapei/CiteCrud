<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<title>Employees</title>

</head>
<body>
	<h1>List of employees</h1>
	<table cellspacing="5" class="main-table">
		<tr>
			<th>Name</th>
			<th>Department</th>
			<th>Supervisor</th>
		</tr>
		<c:forEach items="#{employees}" var="emp">
			<tr>
				<td><spring:url value="/employees/{employeeId}.html"
						var="employeeUrl">
						<spring:param name="employeeId" value="${emp.employeeId}" />
					</spring:url> <a href="${employeeUrl}"><c:out
							value="${emp.employeeName}"/></a></td>
				<td>${emp.employeeDateOfHire}</td>
				<td>${emp.supervisor.employeeName}</td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="welcome">Go back</a>
</body>
</html>