<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("name");
	
	session.removeAttribute("cart");
	
	response.sendRedirect("a.jsp");
%>