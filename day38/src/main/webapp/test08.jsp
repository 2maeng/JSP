<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
</head>
<body>
	<h1>msg : <%= request.getParameter("msg") %></h1>
	<h1>test : <%= request.getParameter("test") %></h1>
</body>
</html>