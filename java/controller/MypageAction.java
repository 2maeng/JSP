package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.MemberDAO;
import model.MemberVO;

public class MypageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ActionForward 객체를 초기화합니다.
		ActionForward forward = null;

		// MemberDAO와 MemberVO 객체를 생성합니다.
		MemberDAO mDAO = new MemberDAO();
		MemberVO mVO = new MemberVO();

		// 세션을 가져옵니다.
		HttpSession session = request.getSession();

		// 세션에 저장된 회원 아이디를 가져와서 MemberVO에 설정합니다.
		mVO.setSelect("중복검사");
		mVO.setMid((String)session.getAttribute("mid"));

		// MemberDAO를 통해 회원 정보를 가져옵니다.
		mVO = mDAO.selectOne(mVO);

		// 회원 정보가 존재할 경우에는 마이페이지로 이동합니다.
		if(mVO != null) {
			forward = new ActionForward();
	         
			// 회원 정보를 request에 설정합니다.
			request.setAttribute("mdata", mVO);
	         
			// 마이페이지로 포워딩합니다.
			forward.setRedirect(false);
			forward.setPath("mypage.jsp");
		}
		else {
			// 회원 정보가 없는 경우에는 요청 실패 메시지를 설정하고 경고창을 띄웁니다.
			request.setAttribute("title", "요청실패.." );
			request.setAttribute("text", "다시한번 확인해주세요.." );
			request.setAttribute("icon", "warning" );
		}

		return forward;
	}
	
}
