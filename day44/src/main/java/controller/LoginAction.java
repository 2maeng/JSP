package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();
		
		mVO.setMid(request.getParameter("mid"));
		mVO.setMpw(request.getParameter("mpw"));
	
		mVO = mDAO.selectOne(mVO);
		
		if(mVO != null){
			forward = new ActionForward();
			HttpSession session = request.getSession();
			session.setAttribute("mid", mVO.getMid());
			forward.setRedirect(false);
			forward.setPath("b_main.jsp");
		}
		
		return forward;
	}

}
