<!DOCTYPE html>

<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">


<body>
	<div>

		<h2>Find Owners</h2>

		<spring:url value="/employees.html" var="formUrl" />
		<form:form modelAttribute="employee" action="${fn:escapeXml(formUrl)}"
			method="get" class="form-horizontal" id="search-employee-form">
			<fieldset>
				<div>
					<label>Last name </label>
					<form:input path="employeeName" size="30" maxlength="80" />
					<form:errors path="*" />
				</div>
				<div>
					<button type="submit">Find Employee</button>
				</div>
			</fieldset>
		</form:form>




	</div>
</body>

</html>
