<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.sendRedirect("main.do");
	// URL : main.do
	// .do로 끝남 -> FrontController(FC)로 가주세요!~~
	// .jsp로 끝남 -> 해당 페이지(View)를 보여주세요!~~

	// controller.jsp?action=main  VS  main.do
	// action이라는 파라미터를 1개 갖고다녀야함
	// 상대적으로 무거움
%>