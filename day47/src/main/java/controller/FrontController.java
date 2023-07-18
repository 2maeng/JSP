package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// not POJO 만들때부터 import 되어있는걸 볼 수 있음

@WebServlet("/Controller")
// 특정 Client(브라우저, 사용자)의 요청에 대해 반응할 수 있음
//	: 필터, 리스너(서블릿을 상속받은 특수한 서블릿)에서 사용한 @
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L; // 직렬화
       
    public FrontController() { // 웹에서는 기본 생성자를 default로 활용하기때문에 꼭 필요함
        super();
    }
    
    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String action = request.getParameter("action");
    	
    	ActionForward forward = null;
    	if(action.equals("main")){
    		
    	}
    	else if(action.equals("board")){
    		
    	}
    	else {
    		// 없는 파라미터
    	}
    	
    	///////////////////////////////
    	// 3. 요청 처리가 완료되면 사용자에게 응답하기
    	// : View로 이동
    	//////////////////////////////
    	if(forward.isRedirect()) {
    		response.sendRedirect(forward.getPath());
    	}
    	else {
    		// 포워드
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
