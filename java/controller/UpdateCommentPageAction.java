package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentDAO;
import model.CommentVO;

public class UpdateCommentPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // 댓글 정보를 조회하기 위해 CommentDAO와 CommentVO 객체를 생성합니다.
        CommentDAO cDAO = new CommentDAO();
        CommentVO cVO = new CommentVO();

        // 선택한 댓글의 번호를 파라미터에서 받아와서 CommentVO에 설정합니다.
        cVO.setCommentNum(Integer.parseInt(request.getParameter("commentNum")));

        // 해당 댓글의 정보를 데이터베이스에서 조회합니다.
        cVO = cDAO.selectOne(cVO);

        // 조회된 댓글 정보가 있을 경우 수정 페이지로 이동합니다.
        if (cVO != null) {
            forward = new ActionForward();
            // 조회된 댓글의 번호를 request 객체에 설정합니다.
            request.setAttribute("commentNum", cVO.getCommentNum());
            // 수정 페이지로 리다이렉트하지 않고, 수정할 댓글의 정보를 전달하여 이동합니다.
            forward.setRedirect(false);
            forward.setPath("updateCommentPage.jsp");
        }

        return forward;
    }
}
