package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RecommendDAO;
import model.RecommendVO;

@WebServlet("/RcServlet.do")
public class Recommend extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Recommend() {
        super();
    }

    // 이 메서드는 클라이언트 측(AJAX 호출 등)으로부터 HTTP POST 요청을 처리합니다.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // AJAX를 통해 전송된 값을 가져와서 서버 콘솔에 출력합니다.
        System.out.println("ajax 로그 : " + request.getParameter("rcresult"));

        // 클라이언트로 응답을 보내기 위해 PrintWriter 객체를 가져옵니다.
        PrintWriter out = response.getWriter();

        // 추천에 관련된 데이터 액세스 객체와 값 객체의 인스턴스를 생성합니다.
        RecommendDAO rcDAO = new RecommendDAO();
        RecommendVO rcVO = new RecommendVO();

        // 요청과 관련된 현재 세션을 가져옵니다.
        HttpSession session = request.getSession();

        // 세션 속성 "mid"에서 추천 값 객체의 "mid" 속성을 설정합니다.
        rcVO.setMid((String) session.getAttribute("mid"));

        // 클라이언트 측에서 받은 "boardNum" 매개변수를 추천 값 객체의 "fknum" 속성으로 설정합니다.
        rcVO.setFknum(Integer.parseInt(request.getParameter("boardNum")));

        // AJAX를 통해 받은 값(사용자 추천: 0 또는 1)을 확인합니다.
        if (request.getParameter("rcresult").equals("0")) {
            // 추천을 데이터베이스에 추가합니다.
            rcDAO.insert(rcVO);

            // 클라이언트에게 성공 응답을 보냅니다. (1은 성공을 나타냄)
            out.print(1);
        } else if (request.getParameter("rcresult").equals("1")) {
            // 사용자가 이미 추천했을 경우, 데이터베이스에서 해당 추천을 삭제합니다.
            rcVO = rcDAO.selectOne(rcVO);
            rcDAO.delete(rcVO);

            // 클라이언트에게 성공 응답을 보냅니다. (0은 성공을 나타냄)
            out.print(0);
        }
    }

}
