package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class DeleteNoticeAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = null;

        // BoardDAO와 BoardVO 객체를 생성합니다.
        BoardDAO bDAO = new BoardDAO();
        BoardVO bVO = new BoardVO();

        // 요청 파라미터에서 공지사항 번호를 가져와서 BoardVO에 설정합니다.
        bVO.setBoardNum(Integer.parseInt(request.getParameter("boardNum")));

        // 공지사항을 삭제하고 그 결과를 flag 변수에 저장합니다.
        boolean flag = bDAO.delete(bVO);

        // 삭제가 성공적으로 이루어졌을 경우
        if (flag) {
            // ActionForward 객체를 생성하고, 리다이렉트 여부와 이동할 경로를 설정합니다.
            forward = new ActionForward();
            forward.setRedirect(true);
            forward.setPath("noticeListPage.do");
        }
        // 삭제가 실패했을 경우
        else {
            // 삭제 실패 메시지를 설정하기 위해 필요한 데이터를 request에 저장합니다.
            request.setAttribute("title", "공지사항삭제실패..");
            request.setAttribute("text", "다시 한번 확인해주세요..");
            request.setAttribute("icon", "warning");
        }

        // 설정된 ActionForward 객체를 반환합니다.
        return forward;
    }

}
