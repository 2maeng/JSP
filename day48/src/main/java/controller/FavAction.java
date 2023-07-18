package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class FavAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO	 bVO = new BoardVO();
		
		bVO.setCondition("FAV");
		bVO.setBid(Integer.parseInt(request.getParameter("bid")));
		
		boolean flag = bDAO.update(bVO);
		if(flag) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.isRedirect(true);
		}
		return forward;
	}
	
}
