package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;

public class UpdateBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		HttpSession session=request.getSession();
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		bVO.setNum(Integer.parseInt(request.getParameter("num")));
		
		boolean flag = bDAO.update(bVO);
		
		if(flag){
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("board.do?num=" + bVO.getNum());
		}
		return forward;
	}
	
}
