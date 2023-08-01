package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CommentDAO;
import model.CommentVO;
import model.ReplyDAO;
import model.ReplyVO;

public class UpdateReplyAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // 대댓글을 업데이트하기 위해 ReplyDAO와 ReplyVO 객체를 생성합니다.
        ReplyDAO rDAO = new ReplyDAO();
        ReplyVO rVO = new ReplyVO();

        // 댓글을 업데이트하기 위해 CommentDAO와 CommentVO 객체를 생성합니다.
        CommentDAO cDAO = new CommentDAO();
        CommentVO cVO = new CommentVO();

        // 파라미터에서 대댓글 번호와 수정된 대댓글 내용을 받아와서 ReplyVO에 설정합니다.
        rVO.setSelect("대댓글수정");
        rVO.setReplyNum(Integer.parseInt(request.getParameter("replyNum")));
        rVO.setReply(request.getParameter("reply"));

        // 대댓글을 데이터베이스에 업데이트하고, 업데이트 성공 여부를 확인합니다.
        boolean flag = rDAO.update(rVO);

        // 업데이트가 성공한 경우, 수정된 대댓글이 포함된 댓글이 속한 게시글 페이지로 리다이렉트합니다.
        if (flag) {
            rVO = rDAO.selectOne(rVO);
            cVO.setCommentNum(rVO.getCommentNum());
            cVO = cDAO.selectOne(cVO);

            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("boardPage.do?boardNum=" + cVO.getBoardNum());
        } else {
            // 업데이트가 실패한 경우, 오류 메시지와 함께 이전 페이지로 돌아갑니다.
            request.setAttribute("title", "대댓글 수정 실패..");
            request.setAttribute("text", "다시한번 확인해주세요..");
            request.setAttribute("icon", "warning");
        }

        return forward;
    }

}
