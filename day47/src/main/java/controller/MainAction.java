package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bDAO = new BoardDAO();
		ArrayList<BoardVO> datas = bDAO.selectAll(null);
		request.setAttribute("datas", datas);
		
		// Controller로 돌아갈 준비
		// 1. 리다이렉트? 포워드?
		// 2. 어디로 가야되니?
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("main.jsp");
		return forward;
	}
}
