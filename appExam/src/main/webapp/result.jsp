<%--suppress CssReplaceWithShorthandUnsafely --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Результат</title>
	<style>
		body {
			display: flex;
			align-items: center;
			justify-content: center;
			height: 100vh;
			margin: 0;
			position: relative;
			overflow: hidden;
		}

		body::before {
			content: "";
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			background-size: cover;
			background-image: url('https://img.freepik.com/premium-photo/visualization-big-data-concept-network-connectivity-abstract-green-background-with-lines-dots-different-colors-3d-rendering_710001-576.jpg');
			background-position: center;
		}

		body::after {
			content: "";
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 100%;
			background: rgba(0, 0, 0, 0.5);
			z-index: 0;
		}

		div {
			text-align: center;
			z-index: 1;
		}

		table {
			border-collapse: collapse;
			width: 100%;
			max-width: 800px;
			margin: 0 auto;
		}

		th, td {
			padding: 8px;
			text-align: left;
			border-bottom: 1px solid #ddd;
		}

		th {
			background-color: #bcbcbc;
		}

		td {
			background: #ffffff;
		}

		tr:hover {
			background-color: #f5f5f5;
		}
	</style>
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
				<td>${user.getName()}</td>
				<td>${user.getAge()}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>