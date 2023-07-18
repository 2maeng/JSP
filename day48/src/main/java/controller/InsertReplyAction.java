package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReplyDAO;
import model.ReplyVO;

public class InsertReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 ActionForward forward=null;
	      
	      ReplyDAO rDAO=new ReplyDAO();
	      ReplyVO rVO=new ReplyVO();
	      
	      rVO.setMid(request.getParameter("mid"));
	      rVO.setBid(Integer.parseInt(request.getParameter("bid")));
	      rVO.setRcontent(request.getParameter("rcontent"));
	      
	      boolean flag=rDAO.insert(rVO);
	      if(flag) {
	         forward=new ActionForward();
	         forward.setPath("main.do");
	         forward.setRedirect(true);
	      }
	      return forward;
	}

}
