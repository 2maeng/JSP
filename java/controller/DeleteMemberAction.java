package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class DeleteMemberAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;
        
        // MemberDAO와 MemberVO 객체를 생성합니다.
        MemberDAO mDAO = new MemberDAO();
        MemberVO mVO = new MemberVO();
        
        // 현재 세션을 가져와서 MemberVO에 설정합니다.
        HttpSession session = request.getSession();
        mVO.setMid((String)session.getAttribute("mid"));
        
        // 회원 탈퇴를 수행하고 그 결과를 flag 변수에 저장합니다.
        boolean flag = mDAO.delete(mVO);
        
        // 회원 탈퇴가 성공적으로 이루어졌을 경우
        if (flag) {
            // ActionForward 객체를 생성하고, 로그아웃 페이지로 리다이렉트하도록 설정합니다.
            forward = new ActionForward();
            forward.setPath("logout.do");
            forward.setRedirect(true);
        }
        // 회원 탈퇴가 실패했을 경우
        else {
            // 탈퇴 실패 메시지를 설정하기 위해 필요한 데이터를 request에 저장합니다.
            request.setAttribute("title", "탈퇴실패..");
            request.setAttribute("text", "다시 한번 확인해주세요..");
            request.setAttribute("icon", "warning");
        }
        
        // 설정된 ActionForward 객체를 반환합니다.
        return forward;
    }
}
