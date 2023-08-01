package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = new ActionForward();

        // 현재 세션을 가져옵니다.
        HttpSession session = request.getSession();

        // 세션에서 "mid" 속성을 제거하여 로그아웃합니다.
        session.removeAttribute("mid");

        // ActionForward 객체를 생성합니다.
        forward.setRedirect(true); // 리다이렉트를 사용함 (다른 페이지로 이동)
        forward.setPath("main.do"); // main.do로 리다이렉트 (메인 페이지로 이동)
        return forward; // 설정된 페이지로 리다이렉트합니다.
    }
}
