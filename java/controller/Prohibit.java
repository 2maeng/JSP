package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BoardDAO;
import model.BoardVO;
import model.ProhibitDAO;
import model.ProhibitVO;

@WebServlet("/PhServlet.do")
public class Prohibit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Prohibit() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // AJAX 요청으로부터 전송된 "phresult" 파라미터를 서버 콘솔에 출력합니다.
        System.out.println("ajax 로그 : " + request.getParameter("phresult"));

        // 클라이언트로 응답을 보낼 PrintWriter 객체를 가져옵니다.
        PrintWriter out = response.getWriter();

        // 글 신고에 관련된 데이터 액세스 객체와 값 객체의 인스턴스를 생성합니다.
        ProhibitDAO pDAO = new ProhibitDAO();
        ProhibitVO pVO = new ProhibitVO();

        // 게시판 데이터에 접근하는 데이터 액세스 객체와 값 객체의 인스턴스를 생성합니다.
        BoardDAO bDAO = new BoardDAO();
        BoardVO bVO = new BoardVO();

        // 현재 세션을 가져옵니다.
        HttpSession session = request.getSession();

        // 글 신고 정보를 설정합니다.
        pVO.setMid((String) session.getAttribute("mid"));
        pVO.setFknum(Integer.parseInt(request.getParameter("boardNum")));

        // 게시판 데이터를 신고 상태로 업데이트하기 위한 설정입니다.
        bVO.setSelect("신고");
        bVO.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));

        // AJAX 요청으로부터 받은 "phresult" 값을 확인합니다.
        if (request.getParameter("phresult").equals("0")) {
            // "phresult" 값이 "0"이면 글을 신고하고, 해당 글의 신고 상태를 업데이트합니다.
            pDAO.insert(pVO);
            bDAO.update(bVO);
            out.print(1); // 클라이언트에게 성공 응답을 보냅니다. (1은 성공을 나타냄)
        } else if (request.getParameter("phresult").equals("1")) {
            // "phresult" 값이 "1"이면 글 신고를 취소하고, 해당 글의 신고 상태를 업데이트합니다.
            pVO = pDAO.selectOne(pVO);
            pDAO.delete(pVO);
            bDAO.update(bVO);
            out.print(0); // 클라이언트에게 성공 응답을 보냅니다. (0은 성공을 나타냄)
        }
    }
}
