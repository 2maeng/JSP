package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class UpdateBoardPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // 게시글 정보를 담을 BoardVO와 데이터베이스 액세스를 위한 BoardDAO 객체를 생성합니다.
        BoardVO bVO = new BoardVO();
        BoardDAO bDAO = new BoardDAO();

        // 요청 파라미터로부터 수정할 게시글의 번호를 가져와서 BoardVO에 설정합니다.
        bVO.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));

        // 해당 게시글의 정보를 데이터베이스에서 조회합니다.
        bVO = bDAO.selectOne(bVO);

        // 조회된 게시글 정보가 있을 경우 수정 페이지로 이동합니다.
        if (bVO != null) {
            forward = new ActionForward();

            // 조회된 게시글 정보를 request 객체에 설정합니다.
            request.setAttribute("bdata", bVO);

            // 수정 페이지로 리다이렉트하지 않고, 해당 게시글의 번호를 파라미터로 전달하여 이동합니다.
            forward.setRedirect(false);
            forward.setPath("updateBoardPage.jsp?boardNum=" + bVO.getBoardNum());
        }
        return forward;
    }
}
