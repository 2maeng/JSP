package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class NoticeListPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ActionForward 객체를 생성합니다.
		ActionForward forward = new ActionForward();
		
		// 현재 페이지의 공지사항 목록을 저장할 ArrayList를 생성합니다.
		ArrayList<BoardVO> currentPageNotices = new ArrayList<BoardVO>();
		
		// BoardDAO와 BoardVO 객체를 생성합니다.
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		// 페이지 파라미터를 가져와서 bVO에 설정합니다.
		if(request.getParameter("page") != null) {
			bVO.setPage(Integer.parseInt(request.getParameter("page")));
		} else {
			bVO.setPage(1);
		}
		int currentPage = bVO.getPage();
		
		// 현재 페이지 정보를 request에 저장합니다.
		request.setAttribute("currentPagent", currentPage);
		
		// 공지사항 목록을 조회하기 위해 bVO에 설정합니다.
		bVO.setSelect("커뮤니티");
		bVO.setCategory(0);
		
		// 전체 공지사항 목록을 조회합니다.
		ArrayList<BoardVO> bdatas = new ArrayList<BoardVO>();
		bdatas = bDAO.selectAll(bVO);
		request.setAttribute("bdatasnt", bdatas);
		
		// 전체 공지사항 개수를 구합니다.
		int totalPosts = bdatas.size();
		
		// 한 페이지에 보여줄 공지사항 개수를 설정합니다. (10개씩 표시)
		int postsPerPage = 10;
		
		// 현재 페이지에 해당하는 공지사항의 시작 인덱스와 끝 인덱스를 계산합니다.
		int startIdx = (currentPage - 1) * postsPerPage;
		int endIdx = Math.min(currentPage * postsPerPage, totalPosts);
		
		// 현재 페이지에 해당하는 공지사항만 currentPageNotices에 추가합니다.
		for (int i = startIdx; i < endIdx; i++) {
		    currentPageNotices.add(bdatas.get(i));
		}
		
		// 현재 페이지의 공지사항 목록을 request에 저장합니다.
		request.setAttribute("currentPageNotices", currentPageNotices);
		
		// forward 객체를 설정하여 noticeListPage.jsp로 포워딩합니다.
		forward.setRedirect(false);
		forward.setPath("noticeListPage.jsp");
		
		return forward;
	}

}
