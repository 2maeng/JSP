<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.sendRedirect("controller.jsp?action=main");
	// controller 없이는 main 페이지로 이동이 불가능하다!
	// 왜?
	// datas가 없으니까!!!
%>