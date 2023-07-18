package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 아무것도 안 했는데 import 돼있는것 notPOJO

@WebServlet("*.do")
public class Frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Frontcontroller() {
        super();
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// 1. 요청을 추출
    	String uri = request.getRequestURI();
    	String cp = request.getContextPath();
    	String command = uri.substring(cp.length());
    	System.out.println(" FrontController 클래스 : doAction() 메서드 : command : " + command); 
    	
    	// 2. Action 클래스의 execute() 메서드를 호출
    	ActionForward forward = null;
    	if(command.equals("/main.do")) {
    		forward = new MainAction().execute(request, response);
    	}
    	else if(command.equals("/signup.do")) {
    		forward = new SignupAction().execute(request, response);
    	}
    	else if(command.equals("/login.do")) {
    		forward = new LoginAction().execute(request, response);
    	}
    	else if(command.equals("/logout.do")){
    		forward = new LogoutAction().execute(request, response);
    	}
    	else if(command.equals("/insertBoard.do")) {
    		forward = new InsertBoardAction().execute(request, response);
    	}
    	else if(command.equals("/inserReply.do")) {
    		forward = new InsertReplyAction().execute(request, response);
    	}
    	else if(command.equals("/fav.do")) {
    		forward = new FavAction().execute(request, response);
    	}
  
    	// 3. 사용자에게 응답. View로 이동
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			// 리다이렉트. 데이터 X
    			response.sendRedirect(forward.getPath());
    		}
    		else {
    			// 포워드. 데이터 O
    			request.getRequestDispatcher(forward.getPath()).forward(request, response);
    		}
    	}
    	else {
    		// 없는 요청
    		// flag F
    		response.sendRedirect("goback.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

}
