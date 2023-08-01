package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class UpdateBoardAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 사용자가 선택한 게시글 번호를 로그로 출력하여 확인합니다.
        System.out.println("로그 UpdateBoardAction 클래스 ActionForward() 메서드 : boardNum: " + request.getParameter("boardNum"));

        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // 게시글 정보를 업데이트하기 위해 BoardDAO와 BoardVO 객체를 생성합니다.
        BoardDAO bDAO = new BoardDAO();
        BoardVO bVO = new BoardVO();

        // 사용자가 수정하고자 하는 게시글 정보를 파라미터에서 받아와서 BoardVO에 설정합니다.
        bVO.setSelect("글수정");
        bVO.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));
        bVO.setTitle(request.getParameter("title"));
        bVO.setContent(request.getParameter("content"));

        // 게시글을 데이터베이스에 업데이트하고, 업데이트 성공 여부를 확인합니다.
        boolean flag = bDAO.update(bVO);

        // 업데이트가 성공한 경우, 수정된 게시글 상세 페이지로 리다이렉트합니다.
        if (flag) {
            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("boardPage.do?boardNum=" + Integer.parseInt(request.getParameter("boardNum")));
        } else {
            // 업데이트가 실패한 경우, 오류 메시지와 함께 이전 페이지로 돌아갑니다.
            request.setAttribute("title", "게시글 수정 실패..");
            request.setAttribute("text", "다시 한 번 확인해주세요..");
            request.setAttribute("icon", "warning");
        }

        return forward;
    }
}
