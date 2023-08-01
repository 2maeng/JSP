package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReplyDAO;
import model.ReplyVO;

public class UpdateReplyPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // 대댓글 정보를 가져오기 위해 ReplyDAO와 ReplyVO 객체를 생성합니다.
        ReplyDAO rDAO = new ReplyDAO();
        ReplyVO rVO = new ReplyVO();

        // 파라미터에서 대댓글 번호를 받아와서 ReplyVO에 설정합니다.
        rVO.setReplyNum(Integer.parseInt(request.getParameter("replyNum")));

        // 데이터베이스에서 해당 대댓글의 정보를 가져옵니다.
        rVO = rDAO.selectOne(rVO);

        // 해당 대댓글의 정보가 존재하는 경우, 수정 페이지로 정보를 전달합니다.
        if (rVO != null) {
            forward = new ActionForward();
            request.setAttribute("replyNum", rVO.getReplyNum());
            forward.setRedirect(false);
            forward.setPath("updateReplyPage.jsp");
        }

        return forward;
    }

}
