package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class SignupAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // 회원 데이터에 접근하는 DAO와 회원 정보를 담을 VO를 생성합니다.
        MemberDAO mDAO = new MemberDAO();
        MemberVO mVO = new MemberVO();

        // 현재 세션을 가져옵니다.
        HttpSession session = request.getSession();

        // 입력한 회원 정보를 MemberVO에 설정합니다.
        mVO.setSelect("중복검사");
        mVO.setMid(request.getParameter("mid"));
        mVO.setMpw(request.getParameter("mpw"));
        mVO.setName(request.getParameter("name"));
        mVO.setNickName(request.getParameter("nickName"));
        mVO.setEmail(request.getParameter("email"));

        // 아이디 중복 검사를 수행합니다.
        MemberVO mdata = mDAO.selectOne(mVO);

        // 아이디가 중복된 경우
        if (mdata != null) {
            forward = new ActionForward();
            request.setAttribute("title", "중복된 아이디입니다..");
            request.setAttribute("text", "다른 아이디를 입력해주세요..");
            request.setAttribute("icon", "warning");
            forward.setPath("goback.jsp");
            return forward;
        }

        // 닉네임 중복 검사를 수행합니다.
        mVO.setSelect("닉네임중복검사");
        mdata = mDAO.selectOne(mVO);

        // 닉네임이 중복된 경우
        if (mdata != null) {
            forward = new ActionForward();
            request.setAttribute("title", "중복된 닉네임입니다..");
            request.setAttribute("text", "다른 닉네임을 입력해주세요..");
            request.setAttribute("icon", "warning");
            forward.setPath("goback.jsp");
            return forward;
        }

        // 이메일 중복 검사를 수행합니다.
        mVO.setSelect("이메일중복검사");
        mdata = mDAO.selectOne(mVO);

        // 이메일이 중복된 경우
        if (mdata != null) {
            forward = new ActionForward();
            request.setAttribute("title", "중복된 이메일입니다..");
            request.setAttribute("text", "다시한번 확인해주세요..");
            request.setAttribute("icon", "warning");
            forward.setPath("goback.jsp");
            return forward;
        }

        // 회원 정보를 데이터베이스에 삽입합니다.
        boolean flag = mDAO.insert(mVO);

        if (flag) {
            // 회원가입 성공 시 세션에 이름과 이메일을 저장하고, 회원가입 성공 페이지로 이동합니다.
            request.setAttribute("name", request.getParameter("name"));
            request.setAttribute("email", request.getParameter("email"));
            forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("signupSuccess.do");
            return forward;
        }

        // 회원가입 실패 시 에러 메시지를 표시합니다.
        request.setAttribute("title", "회원가입실패..");
        request.setAttribute("text", "다시한번 확인해주세요");
        request.setAttribute("icon", "warning");
        return forward;
    }

}
