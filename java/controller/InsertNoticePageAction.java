package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertNoticePageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ActionForward 객체를 초기화합니다.
		ActionForward forward = new ActionForward();
		
		// 공지사항 작성 페이지로 리다이렉트하는 액션입니다.
		// 공지사항 작성 페이지의 경로는 "insertNoticePage.jsp"입니다.
		// 따라서 forward 객체를 설정하여 해당 경로로 리다이렉트합니다.
		forward.setRedirect(true);
		forward.setPath("insertNoticePage.jsp");
		
		return forward;
	}

}
