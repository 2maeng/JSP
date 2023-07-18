package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;

public class BoardAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = null;
		
		BoardDAO bDAO = new BoardDAO();
		BoardVO bVO = new BoardVO();
		
		bVO.setNum(Integer.parseInt(request.getParameter("num")));
		bVO = bDAO.selectOne(bVO);
		
		if(bVO != null){
			request.setAttribute("data", bVO);
			
			forward = new ActionForward(); // CUD 없는 데이터를 보려할때 forward가 null이다.
			
			forward.setPath("d_board.jsp");
			forward.setRedirect(false);
		}
		return forward;
	}

}
