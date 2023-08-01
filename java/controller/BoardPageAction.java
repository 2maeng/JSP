package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;
import model.CommentSet;
import model.CommentSetDAO;
import model.CommentVO;
import model.ProhibitDAO;
import model.ProhibitVO;
import model.RecommendDAO;
import model.RecommendVO;

public class BoardPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;
        
        // BoardDAO와 BoardVO 객체를 생성합니다.
        BoardDAO bDAO = new BoardDAO();
        BoardVO bVO = new BoardVO();
        
        // RecommendDAO와 RecommendVO 객체를 생성합니다.
        RecommendDAO rcDAO = new RecommendDAO();
        RecommendVO rcVO = new RecommendVO();
        
        // ProhibitDAO와 ProhibitVO 객체를 생성합니다.
        ProhibitDAO pDAO = new ProhibitDAO();
        ProhibitVO pVO = new ProhibitVO();
        
        // CommentVO 객체를 생성합니다.
        CommentVO cVO = new CommentVO();
        
        // CommentSetDAO 객체를 생성합니다.
        CommentSetDAO csDAO = new CommentSetDAO();
        
        // HttpSession을 가져옵니다.
        HttpSession session = request.getSession();
        
        // 세션에서 로그인한 사용자의 아이디를 가져와서 RecommendVO와 ProhibitVO에 설정합니다.
        rcVO.setMid((String) session.getAttribute("mid"));
        pVO.setMid((String) session.getAttribute("mid"));
        
        // 요청 파라미터에서 게시글 번호를 가져와서 RecommendVO와 ProhibitVO에 설정합니다.
        rcVO.setFknum(Integer.parseInt(request.getParameter("boardNum")));
        pVO.setFknum(Integer.parseInt(request.getParameter("boardNum")));
        
        // 요청 파라미터에서 게시글 번호를 가져와서 CommentVO와 BoardVO에 설정합니다.
        cVO.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
        bVO.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
        
        // 요청 파라미터에서 표시할 댓글 수를 가져옵니다. 기본값은 10입니다.
        String count = request.getParameter("count");
        
        // count가 null, 빈 문자열, 빈 공백 문자열이면 기본값으로 설정합니다.
        if (count == null || count.isEmpty() || count.isBlank() || count.equals("")) {
            count = "10";
        }
        
        // CommentSetDAO를 통해 해당 게시글에 대한 댓글 리스트를 가져옵니다.
        ArrayList<CommentSet> csdatas = csDAO.selectAll(cVO, Integer.parseInt(count));
        
        // 댓글 리스트를 request에 저장합니다.
        request.setAttribute("csdatas", csdatas);
        
        // RecommendDAO를 통해 해당 게시글에 대한 사용자의 추천 여부를 확인합니다.
        rcVO = rcDAO.selectOne(rcVO);
        // ProhibitDAO를 통해 해당 게시글에 대한 사용자의 신고 여부를 확인합니다.
        pVO = pDAO.selectOne(pVO);
        // BoardDAO를 통해 해당 게시글의 상세 정보를 가져옵니다.
        bVO = bDAO.selectOne(bVO);
        
        // 추천 여부에 따라 request에 "recommend" 속성을 설정합니다.
        if (rcVO != null) {
            request.setAttribute("recommend", 1);
        } else {
            request.setAttribute("recommend", 0);
        }
        
        // 신고 여부에 따라 request에 "prohibit" 속성을 설정합니다.
        if (pVO != null) {
            request.setAttribute("prohibit", 1);
        } else {
            request.setAttribute("prohibit", 0);
        }
        
        // 해당 게시글의 상세 정보를 request에 저장하고, boardPage.jsp로 이동합니다.
        if (bVO != null) {
            request.setAttribute("bdata", bVO);
            
            // CUD(생성, 수정, 삭제) 없는 데이터를 보려 할 때 forward는 null입니다.
            forward = new ActionForward();
            forward.setRedirect(false);
            forward.setPath("boardPage.jsp");
        }
        
        // 해당 게시글이 없는 경우에는 메시지와 함께 경고 페이지를 보여줍니다.
        else {
            request.setAttribute("title", "잘못된 접근입니다.");
            request.setAttribute("text", "다시 한번 확인해주세요.");
            request.setAttribute("icon", "warning");
        }
        
        // 설정된 ActionForward 객체를 반환합니다.
        return forward;
    }

}
