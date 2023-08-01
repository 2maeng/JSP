package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;

public class OwnBoardListPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ActionForward 객체를 생성합니다.
		ActionForward forward = new ActionForward();
		
		// BoardDAO와 BoardVO 객체를 생성합니다.
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		// 현재 세션 정보를 가져옵니다.
		HttpSession session = request.getSession();
		
		// 본인이 작성한 글을 조회하기 위해 "본인글"을 select 조건으로 설정하고, 현재 세션에 저장된 회원 ID를 가져옵니다.
		bVO.setSelect("본인글");
		bVO.setMid((String)session.getAttribute("mid"));
		
		// 본인이 작성한 모든 게시글을 조회합니다.
		ArrayList<BoardVO> bdatas = bDAO.selectAll(bVO);
		
		// 조회된 게시글 데이터를 JSP 페이지에서 사용할 수 있도록 request에 저장합니다.
		request.setAttribute("bdatas", bdatas);
		
		// forward 객체를 설정하여 ownBoardListPage.jsp로 포워딩합니다.
		forward.setRedirect(false);
		forward.setPath("ownBoardListPage.jsp");
		
		return forward;
	}
	
}
