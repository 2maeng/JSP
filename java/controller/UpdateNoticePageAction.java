package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class UpdateNoticePageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // 공지사항 정보를 가져오기 위해 BoardDAO와 BoardVO 객체를 생성합니다.
        BoardDAO bDAO = new BoardDAO();
        BoardVO bVO = new BoardVO();

        // 파라미터에서 공지사항 번호를 받아와서 BoardVO에 설정합니다.
        bVO.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));

        // 데이터베이스에서 해당 공지사항의 정보를 가져옵니다.
        bVO = bDAO.selectOne(bVO);

        // 해당 공지사항의 정보가 존재하는 경우, 수정 페이지로 정보를 전달합니다.
        if (bVO != null) {
            forward = new ActionForward();
            request.setAttribute("bdata", bVO);
            forward.setRedirect(false);
            forward.setPath("updateNoticePage.jsp?boardNum=" + bVO.getBoardNum());
        }

        return forward;
    }

}
