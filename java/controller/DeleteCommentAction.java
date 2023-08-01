package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentDAO;
import model.CommentVO;
import model.ReplyDAO;
import model.ReplyVO;

public class DeleteCommentAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // CommentDAO와 CommentVO 객체를 생성합니다.
        CommentDAO cDAO = new CommentDAO();
        CommentVO cVO = new CommentVO();

        // ReplyDAO와 ReplyVO 객체를 생성합니다.
        ReplyDAO rDAO = new ReplyDAO();
        ReplyVO rVO = new ReplyVO();

        // 요청 파라미터에서 댓글 번호를 가져와서 CommentVO에 설정합니다.
        cVO.setCommentNum(Integer.parseInt(request.getParameter("commentNum")));

        // ReplyVO에 필요한 정보를 설정합니다.
        rVO.setSelect("댓글번호");
        rVO.setCommentNum(Integer.parseInt(request.getParameter("commentNum")));

        // 해당 댓글에 대한 답글이 있는지 확인합니다.
        if (rDAO.selectAll(rVO) != null) {
            // 해당 댓글에 대한 답글이 있는 경우, 댓글을 수정 상태로 변경합니다.
            cVO.setSelect("댓글수정");
            cVO.setComment(null);
            cDAO.update(cVO);
        } else {
            // 해당 댓글에 대한 답글이 없는 경우, 댓글을 삭제합니다.
            cDAO.delete(cVO);
        }

        // 게시글 상세 페이지로 리다이렉트합니다.
        forward = new ActionForward();
        forward.setRedirect(true);
        forward.setPath("boardPage.do?boardNum=" + Integer.parseInt(request.getParameter("boardNum")));

        return forward;
    }

}
