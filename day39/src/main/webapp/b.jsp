<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.MemberVO"%>
    
<jsp:useBean id="mDAO" class="model.MemberDAO" />
<jsp:useBean id="mVO" class="model.MemberVO" />
<jsp:setProperty property="*" name="mVO" />
<%
	
	// 이 mid와 mpw를 가진 회원 있어?
	mVO = mDAO.selectOne(mVO); // 재활용 하는 풀이 / 상품을 꺼내는 것은 새로만드는 풀이
	if(mVO == null){
		// 없어도 가긴 할건데, 로그인 실패 안내 해줘
		out.println("<script>alert('로그인 실패...');history.go(-1);</script>");
		
	}
	else {
	// 있으면 a.jsp로 가고
		session.setAttribute("name", mVO.getName());
		response.sendRedirect("a.jsp");
	}
	
%>