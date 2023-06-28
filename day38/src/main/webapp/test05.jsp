<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작 페이지</title>
</head>
<body>
	<form action="test06.jsp" method="post">
		forward 액션 데이터를 전송하기 <br>
		<input type="text" name="msg">
		<input type="submit" value="전송">
	</form>
	
	<hr>
	
	<form action="test07.jsp" method="post">
		response.sendRedirect()로 액션 데이터를 전송하기 <br>
		<input type="text" name="msg">
		<input type="submit" value="전송">
	</form>
</body>
</html>