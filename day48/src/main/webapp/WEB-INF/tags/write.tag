<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="type" %>
<%@ attribute name="bid" %>

<c:if test="${empty mid}">
	<input type="text" placeholder="내용을 작성하려면 로그인하세요." disabled size="50">
</c:if>

<c:if test="${not empty mid}">
	<c:choose>
		<c:when test="${type == 'board'}">
			<form action="insertBoard.do" method="post">
				<input type="text" name="mid" value="${mid}" readonly>
				<input type="text" name="bcontent" required placeholder="내용을 작성하세요.">
				<input type="submit" value="글 작성하기">
			</form>
		</c:when>
		<c:when test="${type == 'reply'}">
			<form action="insertReply.do" method="post">
				<input type="text" name="mid" value="${mid}" readonly>
				<input type="hidden" name="bid" value="${bid}">
				<input type="text" name="rcontent" required placeholder="댓글을 입력하세요.">
				<input type="submit" value="댓글 작성하기">
			</form>
		</c:when>
	</c:choose>
</c:if>