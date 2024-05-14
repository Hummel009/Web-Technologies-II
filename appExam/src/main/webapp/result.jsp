<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Hurser XML</title>
	<link rel="stylesheet" href="jabroni.css">
</head>
<body>
<div>
	<table>
		<thead>
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="user" items="${result}">
			<tr>
				<td>${user.name()}</td>
				<td>${user.age()}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>