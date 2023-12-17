<%--suppress CssReplaceWithShorthandUnsafely --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Простое веб-приложение</title>
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
			/* Измените последнее число (0.5) для настройки уровня затемнения */
			z-index: 0;
		}

		form {
			text-align: center;
			z-index: 1;
		}

		button {
			display: inline-block;
			padding: 7px 18px;
			border-radius: 3px;
			border-color: transparent;
			text-decoration: none;
			text-transform: uppercase;
			background: rgba(104, 126, 67, 0.5);
			color: #ffffff;
			font-weight: bold;
			cursor: pointer;
			font-size: 14px !important;
			transition: .2s !important;
		}

		button:hover {
			background: rgba(104, 126, 67, 0.9);
			color: #ffffff;
			text-shadow: none;
		}

		button * {
			margin: 0 !important;
			color: #7d4924;
		}
	</style>
</head>
<body>
<form action="showData" method="post">
	<button type="submit" name="button" value="sax">SAX</button>
	<button type="submit" name="button" value="stax">StAX</button>
	<button type="submit" name="button" value="dom">DOM</button>
</form>
</body>
</html>