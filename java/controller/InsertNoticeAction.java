package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;

public class InsertNoticeAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ActionForward 객체를 초기화합니다.
		ActionForward forward = null;
		
		// BoardDAO와 BoardVO 객체를 생성합니다.
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		// 요청과 관련된 현재 세션을 가져옵니다.
		HttpSession session = request.getSession();
		
		// 세션으로부터 로그인한 사용자의 아이디를 가져와서 BoardVO에 설정
		bVO.setMid((String)session.getAttribute("mid"));
		// request로부터 공지사항의 제목, 내용, 카테고리 정보를 가져와서 BoardVO에 설정
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		bVO.setCategory(Integer.parseInt(request.getParameter("category")));
		
		// BoardDAO를 사용하여 공지사항을 등록하고, 등록 결과를 확인
		boolean flag = bDAO.insert(bVO);
		
		if(flag) {
			// 등록에 성공하면 공지사항 목록 페이지로 리다이렉트
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("noticeListPage.do");
		} else {
			// 등록에 실패하면 경고 메시지를 설정하여 이전 페이지에 유지
			request.setAttribute("title", "공지사항작성실패.." );
			request.setAttribute("text", "다시한번 확인해주세요.." );
			request.setAttribute("icon", "warning" );
		}
		
		return forward;
	}

}
