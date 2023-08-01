package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = new ActionForward();

        // ActionForward 객체에 메인 페이지(main.jsp)로 리다이렉트를 설정합니다.
        forward.setRedirect(true); // 리다이렉트를 사용함 (다른 페이지로 이동)
        forward.setPath("main.jsp"); // main.jsp로 리다이렉트 (메인 페이지로 이동)
        return forward; // 설정된 페이지로 리다이렉트합니다.
    }
}
