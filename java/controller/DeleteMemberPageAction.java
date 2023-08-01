package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteMemberPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ActionForward 객체를 생성합니다.
        ActionForward forward = new ActionForward();
        
        // 회원 삭제 페이지로 리다이렉트하기 위해 리다이렉트 여부와 이동할 경로를 설정합니다.
        forward.setRedirect(true);
        forward.setPath("deleteMemberPage.jsp");
        
        return forward;
    }

}
