<%--suppress CssReplaceWithShorthandUnsafely --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hurser XML</title>
	<link rel="stylesheet" href="jabroni.css">
</head>
<body>
<form action="showData" method="post">
	<button type="submit" name="button" value="sax">SAX</button>
	<button type="submit" name="button" value="stax">StAX</button>
	<button type="submit" name="button" value="dom">DOM</button>
</form>
</body>
</html>