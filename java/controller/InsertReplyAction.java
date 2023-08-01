package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ReplyDAO;
import model.ReplyVO;

public class InsertReplyAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ActionForward 객체를 초기화합니다.
		ActionForward forward = null;
		
		// ReplyDAO와 ReplyVO 객체를 생성합니다.
		ReplyDAO rDAO = new ReplyDAO();
		ReplyVO rVO = new ReplyVO();
		
		// 요청과 관련된 현재 세션을 가져옵니다.
		HttpSession session = request.getSession();
		
		// 세션에서 현재 로그인한 사용자의 아이디를 가져옵니다.
		rVO.setMid((String)session.getAttribute("mid"));
		
		// 댓글 번호를 파라미터에서 가져옵니다.
		rVO.setCommentNum(Integer.parseInt(request.getParameter("commentNum")));
		
		// 대댓글 내용을 파라미터에서 가져옵니다.
		rVO.setReply(request.getParameter("reply"));
		
		// 대댓글을 데이터베이스에 추가합니다.
		boolean flag = rDAO.insert(rVO);
		
		// 대댓글이 추가되는 게시글의 번호를 파라미터에서 가져옵니다.
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		System.out.println(request.getParameter("boardNum"));
		
		if (flag) {
			// 대댓글이 성공적으로 추가되었다면 해당 게시글 페이지로 리다이렉트합니다.
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardPage.do?boardNum=" + boardNum);
		} else {
			// 대댓글 추가가 실패한 경우 메시지를 설정하고 현재 페이지에 그대로 남아있도록 합니다.
			request.setAttribute("title", "대댓글작성실패.." );
			request.setAttribute("text", "다시한번 확인해주세요.." );
			request.setAttribute("icon", "warning" );
		}
		
		return forward;
	}
	
}
