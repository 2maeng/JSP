<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="border" %>

<h2><jsp:doBody /></h2>

<hr>

<table border="${border}">
	<tr>
		<th>글 번호</th><th>글 제목</th><th>작성자</th>
	</tr>
	<c:forEach var="v" items="${datas}">
	<tr>
		<td><a href="board.do?num=${v.num}">${v.num}</a></td>
		<td>${v.title}</td>
		<td>${v.writer}</td>
	</tr>
	</c:forEach>
</table>