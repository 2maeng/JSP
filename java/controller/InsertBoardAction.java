package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;

public class InsertBoardAction implements Action{

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
		
		// 현재 로그인된 회원의 ID를 세션에서 가져옵니다.
		bVO.setMid((String)session.getAttribute("mid"));
		
		// 게시글 작성 페이지에서 전송된 제목, 내용, 카테고리 정보를 가져옵니다.
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		bVO.setCategory(Integer.parseInt(request.getParameter("category")));
		
		// 게시글을 등록합니다.
		boolean flag = bDAO.insert(bVO);
		
		if(flag) {
			// 게시글 등록이 성공했을 경우, 게시글 목록 페이지로 리다이렉트합니다.
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardListPage.do");
		}
		else {
			// 게시글 등록이 실패했을 경우, 경고 메시지를 설정하고 이전 페이지로 돌아갑니다.
			request.setAttribute("title", "게시글작성실패.." );
			request.setAttribute("text", "다시한번 확인해주세요.." );
			request.setAttribute("icon", "warning" );
		}
		
		return forward;
	}

}
