package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		BoardDAO bDAO = new BoardDAO();
		ArrayList<BoardVO> datas = bDAO.selectAll(null);
		
		request.setAttribute("datas", datas);
		
		forward.setRedirect(false);
		forward.setPath("b_main.jsp");	
		
		return forward;
	}

}
