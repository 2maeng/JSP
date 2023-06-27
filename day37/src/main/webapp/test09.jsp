<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="test.MemberVO" %>
	
<jsp:useBean id="mDAO" class="test.MemberDAO" />
<jsp:useBean id="mVO" class="test.MemberVO" />
<jsp:setProperty property="*" name="mVO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"
	integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
	crossorigin="anonymous"></script>
	
</head>
<body>

	<script type="text/javascript">
	<%
	if(request.getMethod().equals("POST")){
		MemberVO data = mDAO.selectOne(mVO);
		if(data != null){
			out.println("alert('" + data.getMid() + "님, 로그인성공!');");
		}
		else {
			out.println("alert('로그인 실패...');");
		}
	}
	%>
	
	</script>

	<form method="post">
		<input type="text" name="mid" placeholder="아이디 입력하세요" required /> <br>
		<input type="password" name="mpw" placeholder="비빌번호 입력하세요" required /> <br> 
		<input type="submit" value="로그인" />
	</form>
		<button class="btn1">회원가입</button>
	

	<hr>
	
	<h2>회원목록</h2>
	<ul>
	<%
		for(MemberVO data : mDAO.selectAll(null)){
		out.println("<li>" + data + "</li>");
		}
	%>
	</ul>

</body>
</html>