<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.BoardVO" %>
<%
	request.setCharacterEncoding("UTF-8");
	// "필터"
	// "인코딩 필터"
%>
<jsp:useBean id="bDAO" class="model.BoardDAO" />
<jsp:useBean id="mDAO" class="model.MemberDAO" />
<jsp:useBean id="mVO" class="model.MemberVO" />
<jsp:setProperty property="*" name="mVO" />
<jsp:useBean id="bVO" class="model.BoardVO" />
<jsp:setProperty property="*" name="bVO" />
<%
	String action=request.getParameter("action");

	System.out.println("로그: controller.jsp");
	System.out.println("action: "+action);
	System.out.println("bVO: "+bVO);
	System.out.println("mVO: "+mVO);

	if(action.equals("main")){
		ArrayList<BoardVO> datas=bDAO.selectAll(null);
		request.setAttribute("datas", datas);
		request.getRequestDispatcher("b_main.jsp").forward(request, response);
	}
	else if(action.equals("board")){
		bVO=bDAO.selectOne(bVO);
		if(bVO!=null){
			request.setAttribute("data", bVO);
			request.getRequestDispatcher("d_board.jsp").forward(request, response);
		}
	}
	else if(action.equals("login")){
		mVO = mDAO.selectOne(mVO); // mVO에 mid,mpw가 setter에 의해 저장됨
		if(mVO==null){
			out.println("<script>alert('로그인 실패...');history.go(-1);</script>");
		}
		else{
			session.setAttribute("mid", mVO.getMid());
			response.sendRedirect("controller.jsp?action=main");
		}
	}
	else if(action.equals("logout")){
		session.removeAttribute("mid");
		response.sendRedirect("controller.jsp?action=main");
	}
	else if(action.equals("signupPage")){
		response.sendRedirect("e_signup.jsp");
	}
	else if(action.equals("signup")){
		boolean flag=mDAO.insert(mVO);
		if(flag){
			out.println("<script>alert('회원가입 성공! 로그인후에 이용하세요! :D');location.href='controller.jsp?action=main';</script>");
		}
		else{
			out.println("<script>alert('회원가입 실패...');history.go(-1);</script>");
		}
	}
	else if(action.equals("insertBoardPage")){
		response.sendRedirect("c_insertBoard.jsp");
	}
	else if(action.equals("insertBoard")){
		boolean flag=bDAO.insert(bVO);
		if(flag){
			out.println("<script>alert('게시글 작성 성공!');location.href='controller.jsp?action=main';</script>");
		}
		else{
			out.println("<script>alert('게시글 작성 실패...');history.go(-1);</script>");
		}
	}
	else if(action.equals("updateBoard")){
		boolean flag=bDAO.update(bVO);
		if(flag){
			out.println("<script>alert('게시글 변경 성공!');location.href='controller.jsp?action=board&num="+bVO.getNum()+"';</script>");
		}
		else{
			out.println("<script>alert('게시글 변경 실패...');history.go(-1);</script>");
		}
	}
	else if(action.equals("deleteBoard")){
		boolean flag=bDAO.delete(bVO);
		if(flag){
			response.sendRedirect("controller.jsp?action=main");
		}
		else{
			out.println("<script>alert('게시글 삭제 실패...');history.go(-1);</script>");
		}
	}
	else if(action.equals("mypagePage")){
		response.sendRedirect("mypage.jsp");
	}
	else if(action.equals("mypage")){
		///// mVO.setMid((String)session.getAttribute("mid"));
		mVO=mDAO.selectOne(mVO);
		if(mVO!=null){
			request.setAttribute("data", mVO);
			request.getRequestDispatcher("f_mypage.jsp").forward(request, response);
		}
		else{
			out.println("<script>alert('비밀번호 불일치...');history.go(-1);</script>");
		}
	}
	else if(action.equals("updateMember")){
		boolean flag=mDAO.update(mVO);
		if(flag){
			out.println("<script>alert('회원정보 변경 성공! 로그인후에 이용하세요! :D');location.href='controller.jsp?action=logout';</script>");
		}
		else{
			out.println("<script>alert('회원정보 변경 실패...');history.go(-1);</script>");
		}
	}
	else if(action.equals("deleteMember")){
		boolean flag=mDAO.delete(mVO);
		if(flag){
			out.println("<script>alert('회원탈퇴 성공!');location.href='controller.jsp?action=logout';</script>");
		}
		else{
			out.println("<script>alert('회원탈퇴 실패...');history.go(-1);</script>");
		}
	}
	else{
		out.println("<script>alert('action 파라미터의 값을 확인해주세요!');history.go(-1);</script>");
	}
%>