package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommentDAO;
import model.CommentVO;

public class UpdateCommentAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // 댓글 정보를 수정하기 위해 CommentDAO와 CommentVO 객체를 생성합니다.
        CommentDAO cDAO = new CommentDAO();
        CommentVO cVO = new CommentVO();

        // 댓글 번호와 수정한 댓글 내용을 받아서 CommentVO에 설정합니다.
        cVO.setSelect("댓글수정");
        cVO.setCommentNum(Integer.parseInt(request.getParameter("commentNum")));
        cVO.setComment(request.getParameter("comment"));

        // 댓글을 데이터베이스에 수정하고, 수정 성공 여부를 확인합니다.
        boolean flag = cDAO.update(cVO);

        // 수정된 댓글 정보를 다시 조회합니다.
        cVO = cDAO.selectOne(cVO);

        // 댓글 수정이 성공적으로 이루어지면 해당 게시글 페이지로 리다이렉트합니다.
        if (flag) {
            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("boardPage.do?boardNum=" + cVO.getBoardNum());
        }

        // 댓글 수정이 실패한 경우 에러 메시지를 설정하고 반환합니다.
        request.setAttribute("title", "댓글 수정 실패..");
        request.setAttribute("text", "다시한번 확인해주세요..");
        request.setAttribute("icon", "warning");
        return forward;
    }
}
