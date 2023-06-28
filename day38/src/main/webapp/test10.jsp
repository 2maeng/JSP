<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="test.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String member = request.getParameter("mid");
		if(session.getAttribute("member") == null){ // 첫 로그인이야
			session.setAttribute("member", member);
			
		}
		
		ArrayList<ProductVO> pdatas = new ArrayList<ProductVO>();
		pdatas.add(new ProductVO(1, "티셔츠", 2000));
		pdatas.add(new ProductVO(2, "목도리", 3000));
		pdatas.add(new ProductVO(3, "청바지", 4000));
		pdatas.add(new ProductVO(4, "운동화", 5000));
		pdatas.add(new ProductVO(5, "가방", 6000));
	%>
	
	<h1><%= session.getAttribute("member") %>님, 안녕하세요! :D</h1>
	<form action="test11.jsp">
		상품 <select name="product">
		
				<% 
					for(ProductVO data : pdatas){
						
				%>
						<option value="<%= data.getPk() %>"><%= data %></option>
					
				<%
					}
				%>
			</select>
			
		<input type="submit" value="장바구니에 추가하기">
	</form>
	
	<hr>
	
	<a href="test12.jsp">최종 결제하기</a>
</body>
</html>