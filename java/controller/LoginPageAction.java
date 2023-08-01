package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ActionForward 객체를 생성하고 초기화합니다.
        ActionForward forward = new ActionForward();
        
        // 로그인 페이지로 리다이렉트합니다.
        forward.setRedirect(true); // 로그인 페이지로 리다이렉트 (새로운 요청)
        forward.setPath("loginPage.jsp"); // 로그인 페이지의 경로

        // 설정된 페이지로 이동합니다. (로그인 페이지로 이동)
        return forward;
    }
}
