package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PreparingPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ActionForward 객체를 생성하여 준비중 페이지로 리다이렉트합니다.
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("preparingPage.jsp");
		
		return forward;
	}

}
