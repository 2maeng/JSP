<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="lb" class="test.LoginBean" />
<jsp:setProperty property="*" name="lb" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form method="post">
		<input type="text" name="mid" placeholder="아이디 입력하세요" required> 
		<input type="password" name="mpw" placeholder="비빌번호 입력하세요" required>
		<input type="submit" value="로그인">
	</form>
	
	<script type="text/javascript">
		<%
		if(request.getMethod().equals("POST")){
			lb.check();
			if(lb.isFlag()){
		%>
			alert('로그인 성공!');
		<%}
			else{
		%>
			alert('로그인 실패...');
		<%
			}
		}
		%>
	</script>
	
</body>
</html>