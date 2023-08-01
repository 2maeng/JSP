package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommentDAO;
import model.CommentVO;

public class InsertCommentAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ActionForward 객체를 초기화합니다.
		ActionForward forward = null;
		
		// CommentDAO와 CommentVO 객체를 생성합니다.
		CommentDAO cDAO = new CommentDAO();
		CommentVO cVO = new CommentVO();
		
		// 요청과 관련된 현재 세션을 가져옵니다.
		HttpSession session = request.getSession();
		
		// 세션으로부터 로그인한 사용자의 아이디를 가져와서 CommentVO에 설정
		cVO.setMid((String)session.getAttribute("mid"));
		// request로부터 게시글 번호와 댓글 내용을 가져와서 CommentVO에 설정
		cVO.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		cVO.setComment(request.getParameter("comment"));
		
		// CommentDAO를 사용하여 댓글을 등록하고, 등록 결과를 flag 변수에 저장
		boolean flag = cDAO.insert(cVO);
		
		if(flag) {
			// 등록에 성공하면 해당 게시글 상세 페이지로 리다이렉트
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardPage.do?boardNum=" + cVO.getBoardNum());
		} else {
			// 등록에 실패하면 경고 메시지를 설정하여 이전 페이지에 유지
			request.setAttribute("title", "댓글작성실패.." );
			request.setAttribute("text", "다시한번 확인해주세요.." );
			request.setAttribute("icon", "warning" );
		}
		
		return forward;
	}

}
