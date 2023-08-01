package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMpwPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ActionForward 객체를 초기화합니다.
        ActionForward forward = new ActionForward();

        // 비밀번호 변경 페이지로 리다이렉트합니다.
        forward.setRedirect(true);
        forward.setPath("updateMpwPage.jsp");

        return forward;
    }
}
