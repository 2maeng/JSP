<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty mid}">
	<li><a href="logout.do">로그아웃</a></li>
</c:if>
<c:if test="${empty mid}">
	<li><a href="javascript:signup()">회원가입</a></li>
	<li>
		<form action="login.do" method="post">
			<input type="text" name="mid" required placeholder="아이디 입력">
			<input type="password" name="mpw" required placeholder="비밀번호 입력">
			<input type="submit" value="로그인">
		</form>
	</li>
</c:if>