<%@ tag language="java" pageEncoding="UTF-8"%>

<%-- border와 bgcolor라는 변수가 생긴 것 --%>
<%@ attribute name="border" %>
<%@ attribute name="bgcolor" %>

<jsp:useBean id="pb" class="test.ProductBean" />

<h1>상품 목록</h1>
<h1><jsp:doBody /></h1>
<hr>	
<table border="${ border }" bgcolor="${ bgcolor }">
	<% for(String data : pb.getPdatas()){ %>
	<tr><td><%= data %></td></tr>
	<%} %>
</table>