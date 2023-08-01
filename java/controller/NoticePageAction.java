package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;
import model.CommentSet;
import model.CommentSetDAO;
import model.CommentVO;

public class NoticePageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ActionForward 객체를 생성합니다.
		ActionForward forward = null;
		
		// BoardDAO와 BoardVO 객체를 생성합니다.
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		// CommentVO 객체를 생성합니다.
		CommentVO cVO = new CommentVO();
		
		// CommentSetDAO 객체를 생성합니다.
		CommentSetDAO csDAO = new CommentSetDAO();
		
		// 요청 파라미터로부터 게시글 번호를 가져와서 bVO에 설정합니다.
		bVO.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		
		// 댓글 조회를 위해 해당 게시글 번호를 cVO에 설정합니다.
		cVO.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
		
		// 게시글 정보를 조회합니다.
		bVO = bDAO.selectOne(bVO);
		
		// 댓글 개수를 설정합니다. count 파라미터가 비어있거나 없을 경우 기본값은 10입니다.
		String count = request.getParameter("count");
		if(count == null || count.isEmpty() || count.isBlank() || count.equals("")) {
			count = "10";
		}
		
		// 댓글 데이터를 조회합니다.
		ArrayList<CommentSet> csdatas = csDAO.selectAll(cVO, Integer.parseInt(count));
	      
		// 댓글 데이터를 JSP 페이지에서 사용할 수 있도록 request에 저장합니다.
		request.setAttribute("csdatas", csdatas);
		
		// 게시글 데이터가 조회되었을 경우, 게시글 정보를 JSP 페이지에서 사용할 수 있도록 request에 저장합니다.
		if(bVO != null) {
			request.setAttribute("bdata", bVO);
			
			// forward 객체를 설정하여 boardPage.jsp로 포워딩합니다.
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("boardPage.jsp");
		}
		return forward;
	}

}
