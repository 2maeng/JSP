<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="test.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결제 페이지</h1>
		<%= session.getAttribute("member") %>님이 결제하신 상품목록입니다. <br>
	<ul>
		<%
			ArrayList<ProductVO> datas = (ArrayList<ProductVO>)session.getAttribute("datas");
			int total = 0;
			if(datas == null){
				out.println("장바구니가 비어있습니다!");
			}
			else {
				for(ProductVO data : datas){
					out.println("<li>" + data + "</li>");
					total += data.getPrice();
				}
				out.println();
				out.println("총 가격은 " + total + "원 입니다.");
			}
		%>
		
	</ul>
</body>
</html>