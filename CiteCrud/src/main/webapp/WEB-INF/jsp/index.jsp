<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<title>Welcome to CiteCrud app!</title>
</head>
<body>
	<h1>Welcome to the CiteCrud App!</h1>

	<ul>

		<li><a href="employees">List employees</a></li>
	</ul>
	Today is:
	<fmt:formatDate value="${today}" pattern="dd-MM-yyyy" />
</body>
</html>