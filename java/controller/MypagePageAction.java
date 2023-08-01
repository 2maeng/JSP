package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MypagePageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ActionForward 객체를 생성합니다.
		ActionForward forward = new ActionForward();
		
		// 마이페이지로 이동하기 위해 redirect를 true로 설정하고, 경로를 "mypage.jsp"로 설정합니다.
		forward.setRedirect(true);
		forward.setPath("mypage.jsp");
		
		return forward;
	}
	
}
