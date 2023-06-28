<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="test01.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일부러 만드는 에러</title>
</head>
<body>
	<% 
	String str = "apple";
	int i = Integer.parseInt(str);
	%>
</body>
</html>