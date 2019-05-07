<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<%
		String id = request.getAttribute("id").toString();
		String name = request.getAttribute("name").toString();
		out.print("Id: " + id);
		out.print("<br/>Name: " + name);
	%>
</body>
</html>