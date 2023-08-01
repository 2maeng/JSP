package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class UpdateMpwAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // 회원 비밀번호를 업데이트하기 위해 MemberDAO와 MemberVO 객체를 생성합니다.
        MemberDAO mDAO = new MemberDAO();
        MemberVO mVO = new MemberVO();

        // 현재 로그인한 사용자의 아이디와 변경할 비밀번호를 받아와서 MemberVO에 설정합니다.
        HttpSession session = request.getSession();
        mVO.setMid((String) session.getAttribute("mid"));
        mVO.setMpw(request.getParameter("mpw"));

        // 회원 비밀번호를 데이터베이스에 업데이트하고, 업데이트 성공 여부를 확인합니다.
        boolean flag = mDAO.update(mVO);

        // 업데이트가 성공한 경우, 로그아웃 페이지로 리다이렉트합니다.
        if (flag) {
            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("logout.do");
        } else {
            // 업데이트가 실패한 경우, 오류 메시지와 함께 이전 페이지로 돌아갑니다.
            request.setAttribute("title", "비밀번호 변경 실패..");
            request.setAttribute("text", "다시한번 확인해주세요..");
            request.setAttribute("icon", "warning");
        }
        return forward;
    }
}
