<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.BoardVO, java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="bVO" class="model.BoardVO" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>

<script type="text/javascript">
	function check(){
		var ans=prompt('비밀번호를 입력하세요.');
		location.href='controller.jsp?action=mypage&mpw='+ans;
	}
</script>

	<c:if test="${ mid == null }">
		<a href="controller.jsp?action=signupPage">회원가입</a>
		<form action="controller.jsp" method="post">
			<input type="hidden" name="action" value="login">
			<input type="text" name="mid">
			<input type="password" name="mpw">
			<input type="submit" value="로그인">
		</form>	
	</c:if>
	
	<c:if test="${ mid != null }">
		<a href='controller.jsp?action=mypagePage'> ${ mid } 님의 마이페이지</a> <a href='controller.jsp?action=logout'>로그아웃</a>
	</c:if>

<hr>

<table border="1">
	<tr>
		<th>글 번호</th><th>글 제목</th><th>작성자</th>
	</tr>
	<c:forEach var="data" items="${ datas }">
		<tr>
			<td><a href="controller.jsp?action=board&num=${ data.num }">${ data.num }</a></td>
			<td>${ data.title }</td>
			<td>${ data.writer }</td>
		</tr>
	</c:forEach>
</table>
<br>

	<c:if test="${ mid != null }">
		<a href='controller.jsp?action=insertBoardPage'>게시글 작성</a>
	</c:if>

</body>
</html>