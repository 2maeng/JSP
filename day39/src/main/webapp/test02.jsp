<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Integer cnt = (Integer)application.getAttribute("cnt");
		cnt++;
		application.setAttribute("cnt", cnt);
	%>
	
	오늘의 방문자수는 <%= cnt %>명 입니다.
	
</body>
</html>