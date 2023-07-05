<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="kim" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커스텀 태그02</title>
</head>
<body>
	<!-- 태그 바디에 있는 내용을 tag에서 불러올 수 있어야 함 -->
	<kim:productList border="10" bgcolor="lightpink">상품 목록</kim:productList>
</body>
</html>