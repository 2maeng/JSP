package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardSet;
import model.BoardSetDAO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		
		String count=request.getParameter("count");
		if(count == null || count.isEmpty() || count.isBlank() || count.equals("")) {
			count="2";
		}
		int cnt=Integer.parseInt(count);
		
		BoardSetDAO bsDAO=new BoardSetDAO();
		ArrayList<BoardSet> datas=bsDAO.selectAll(null, cnt);
		request.setAttribute("datas", datas);
		request.setAttribute("count", cnt);
		
		return forward;
	}

}
