<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>

<form action="signup.do" method="post">
	아이디 <input type="text" name="mid"> <br>
	비밀번호 <input type="password" name="mpw"> <br>
	이름 <input type="text" name="name"> <br>
	<input type="submit" value="회원가입">
</form>

<br>

<a href="main.do">메인으로 돌아가기</a>

</body>
</html>