<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test04.jsp" method="post">
		선택상자 <select name="box">
				<option value="apple">사과</option>
				<option value="banana">바나나</option>
				<option value="kiwi">키위</option>
			</select>
			
		<br>
		체크박스 <input type="checkbox" name="fav" value="영화">영화
			 <input type="checkbox" name="fav" value="드라마">드라마
			 <input type="checkbox" name="fav" value="애니메이션">애니메이션
			 
		<br>
		<input type="submit" value="데이터 전송">
	</form>
</body>
</html>