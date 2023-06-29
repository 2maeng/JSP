<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" import="model.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="header">
	<%
	if( session.getAttribute("name") == null ){
	%>
		<form action="b.jsp" method="post"> 
			아이디 <input type="text" name="mid"> <br>
			비밀번호 <input type="password" name="mpw"> <br>
				 <input type="submit" value="로그인">
		</form>
	<%
	}
	else{
	%>
		<%=session.getAttribute("name")%>님, 안녕하세요! :D | <a href="c.jsp">로그아웃</a>
		
		<hr>
		
		<div id="footer">
			<form action="d.jsp">
				<textarea name="comment" rows="7" cols="20" placeholder="내용을 입력해주세요." required></textarea> <br>
				<input type="submit" value="작성"> 
			</form>
		</div>
		
		
	<%
	}
	%>
</div>


<% 
	ArrayList<String> comments = (ArrayList<String>)application.getAttribute("comments");
%>

<hr>

<ul>
	<% 
		if(comments == null){
			out.println("출력할 댓글이 없습니다.");
		}
		else {
			for(String data : comments){
				out.println("<li>" + data + "</li>");
			}
		}
	%>
	
	
</ul>

<hr>

</body>
</html>