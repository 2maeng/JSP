package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class BoardListPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ActionForward 객체를 생성합니다.
        ActionForward forward = new ActionForward();
        
        // 현재 페이지에 해당하는 게시글 리스트들을 담을 ArrayList들을 생성합니다.
        ArrayList<BoardVO> currentPageBoards = new ArrayList<BoardVO>();
        ArrayList<BoardVO> currentPageBoardsC1 = new ArrayList<BoardVO>();
        ArrayList<BoardVO> currentPageBoardsC2 = new ArrayList<BoardVO>();

        // BoardDAO와 BoardVO 객체를 생성합니다.
        BoardDAO bDAO = new BoardDAO();
        BoardVO bVO = new BoardVO();
        
        // 요청 파라미터에서 페이지 번호를 가져와서 BoardVO에 설정합니다.
        if (request.getParameter("page") != null) {
            bVO.setPage(Integer.parseInt(request.getParameter("page")));
        } else {
            bVO.setPage(1);
        }
        
        // 현재 페이지 번호를 request에 저장합니다.
        int currentPage = bVO.getPage();
        request.setAttribute("currentPage", currentPage);

        // "전체커뮤니티"에 해당하는 모든 게시글 리스트를 가져옵니다.
        bVO.setSelect("전체커뮤니티");
        ArrayList<BoardVO> bdatas = bDAO.selectAll(bVO);
        request.setAttribute("bdatas", bdatas);
        
        // 한 페이지에 보여줄 게시글 개수를 설정합니다.
        int postsPerPage = 10;
        int totalPosts = bdatas.size();
        
        System.out.println(totalPosts);
        
        // 현재 페이지에 보여줄 게시글 범위를 계산합니다.
        int startIdx = (currentPage - 1) * postsPerPage;
        int endIdx = Math.min(currentPage * postsPerPage, totalPosts);
        
        // 현재 페이지에 해당하는 게시글 리스트를 추출합니다.
        for (int i = startIdx; i < endIdx; i++) {
            currentPageBoards.add(bdatas.get(i));
        }
        request.setAttribute("currentPageBoards", currentPageBoards);

        // "커뮤니티"에 해당하는 카테고리 1에 속하는 게시글 리스트를 가져옵니다.
        bVO.setSelect("커뮤니티");
        bVO.setCategory(1);
        bdatas = bDAO.selectAll(bVO);
        request.setAttribute("bdatasC1", bdatas);
        totalPosts = bdatas.size();
        startIdx = (currentPage - 1) * postsPerPage;
        endIdx = Math.min(currentPage * postsPerPage, totalPosts);
        for (int i = startIdx; i < endIdx; i++) {
            currentPageBoardsC1.add(bdatas.get(i));
        }
        request.setAttribute("currentPageBoardsC1", currentPageBoardsC1);

        // "커뮤니티"에 해당하는 카테고리 2에 속하는 게시글 리스트를 가져옵니다.
        bVO.setSelect("커뮤니티");
        bVO.setCategory(2);
        bdatas = bDAO.selectAll(bVO);
        request.setAttribute("bdatasC2", bdatas);
        totalPosts = bdatas.size();
        startIdx = (currentPage - 1) * postsPerPage;
        endIdx = Math.min(currentPage * postsPerPage, totalPosts);
        for (int i = startIdx; i < endIdx; i++) {
            currentPageBoardsC2.add(bdatas.get(i));
        }
        request.setAttribute("currentPageBoardsC2", currentPageBoardsC2);

        // 선택된 탭을 request에 저장합니다.
        String selectedTab;
        if (request.getParameter("tab") != null) {
            selectedTab = request.getParameter("tab");
        } else {
            selectedTab = "menu0";
        }
        request.setAttribute("selectedTab", selectedTab);

        // 포워딩 정보를 설정합니다.
        forward.setRedirect(false);
        forward.setPath("boardListPage.jsp");

        return forward;
    }

}
