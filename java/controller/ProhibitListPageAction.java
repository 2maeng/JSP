package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

public class ProhibitListPageAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // ActionForward 객체를 초기화합니다.
        ActionForward forward = new ActionForward();

        // 글 신고 목록을 조회하기 위해 BoardDAO와 BoardVO 객체를 생성합니다.
        BoardDAO bDAO = new BoardDAO();
        BoardVO bVO = new BoardVO();

        // BoardVO에 "신고목록" 값을 설정하여 글 신고 목록을 조회합니다.
        bVO.setSelect("신고목록");

        // 글 신고 목록을 조회하여 phbdatas 리스트에 저장합니다.
        ArrayList<BoardVO> phbdatas = bDAO.selectAll(bVO);

        // 글 신고 목록 데이터를 request 객체에 저장합니다.
        request.setAttribute("phdatas", phbdatas);

        // ActionForward 객체에 목적지 경로와 리다이렉트 여부를 설정합니다.
        forward.setRedirect(false); // 리다이렉트를 사용하지 않음 (포워딩)
        forward.setPath("prohibitListPage.jsp"); // prohibitListPage.jsp로 이동
        return forward; // 설정된 페이지로 이동합니다.
    }

}
