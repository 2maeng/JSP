<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>보통의 마이페이지</title>
</head>
<body>

<form action="controller.jsp" method="post">
	<input type="hidden" name="action" value="mypage">
	<input type="hidden" name="mid" value="${ mid }">
	비밀번호를 확인하겠습니다. <br>
	비밀번호를 입력해주세요. <br>
	<input type="password" name="mpw">
	<input type="submit" value="비밀번호 확인">
</form>

</body>
</html>