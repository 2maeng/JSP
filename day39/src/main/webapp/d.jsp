<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList"%>
<!DOCTYPE html>

<%
	ArrayList<String> comments = (ArrayList<String>)application.getAttribute("comments");
	String comment = request.getParameter("comment") + " ["+session.getAttribute("name") + "]";
	
	if(comments == null){
		comments = new ArrayList<String>();
		application.setAttribute("comments", comments);
	}
	
	comments.add(comment);
	
%>

<script>
	alert('글 작성 완료!');
	location.href='a.jsp';
</script>
