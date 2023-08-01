package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 회원가입 페이지로 이동하기 위해 ActionForward 객체를 생성하고 설정합니다.
		ActionForward forward = new ActionForward();
		forward.setRedirect(true); // 리다이렉트 방식으로 이동합니다.
		forward.setPath("signupPage.jsp"); // 회원가입 페이지의 경로를 설정합니다.

		return forward;
	}

}
