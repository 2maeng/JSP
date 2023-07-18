package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;

public class DeleteBoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		bVO.setNum(Integer.parseInt(request.getParameter("num")));
		
		boolean flag = bDAO.delete(bVO);
		
		if(flag){
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
		}
		return forward;
	}

}
