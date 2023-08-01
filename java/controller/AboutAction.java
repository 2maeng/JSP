package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ActionForward 객체를 생성합니다.
        ActionForward forward = new ActionForward();

        // 리다이렉트 설정을 true로 지정합니다.
        forward.setRedirect(true);

        // about.jsp 페이지로 이동하기 위한 경로를 설정합니다.
        forward.setPath("about.jsp");

        // 설정된 ActionForward 객체를 반환합니다.
        return forward;
    }

}
