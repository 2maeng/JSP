package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class LoginAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // 현재 세션을 가져옵니다.
        HttpSession session = request.getSession();

        // 회원 데이터에 접근하는 DAO와 회원 정보를 담을 VO를 생성합니다.
        MemberDAO mDAO = new MemberDAO();
        MemberVO mVO = new MemberVO();

        // MemberVO에 로그인 동작을 수행함을 나타내는 "로그인" 값을 설정합니다.
        mVO.setSelect("로그인");
        
        // 사용자가 입력한 아이디와 비밀번호를 MemberVO에 설정합니다.
        mVO.setMid(request.getParameter("mid"));
        mVO.setMpw(request.getParameter("mpw"));
        
        // 입력한 아이디와 비밀번호로 회원 데이터베이스에서 회원을 조회합니다.
        mVO = mDAO.selectOne(mVO);

        // ActionForward 객체를 생성합니다.
        forward = new ActionForward();

        // 회원이 존재하는 경우 (로그인 성공)
        if (mVO != null) {
            // 세션에 회원 정보를 저장합니다.
            session.setAttribute("mid", mVO.getMid());
            session.setAttribute("nickName", mVO.getNickName());
            
            // 이동할 페이지를 설정합니다. (main.do로 이동)
            forward.setRedirect(false); // 리다이렉트를 사용하지 않음 (포워딩)
            forward.setPath("main.do"); // main.do로 이동
            return forward; // 설정된 페이지로 이동합니다.
        }

        // 회원이 존재하지 않는 경우 (로그인 실패)
        // 로그인 실패에 대한 메시지와 함께 goback.jsp 페이지로 이동합니다.
        request.setAttribute("title", "등록된 아이디가 아닙니다..");
        request.setAttribute("text", "회원가입 후 이용해주세요...ㅠ");
        request.setAttribute("icon", "question");
        forward.setPath("goback.jsp");
        return forward;
    }
}
