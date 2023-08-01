package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

    // 요청을 처리하는 메서드입니다.
    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 사용자, 브라우저 요청을 추출합니다.
       String uri = request.getRequestURI();
       System.out.println("uri: " + uri);
       String cp = request.getContextPath();
       System.out.println("cp: " + cp);
       String command = uri.substring(cp.length());
       System.out.println("command: " + command);
       System.out.println(" FrontController 클래스 : doAction() 메서드 : command : " + command);
       
       // Action 클래스의 execute() 메서드를 호출합니다.
       ActionForward forward = null;

////////////////////////////////////// 메인 페이지 ///////////////////////////////////////
       if (command.equals("/main.do")) { 
          forward = new MainAction().execute(request, response);
       }
/////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////// 소개 페이지 ///////////////////////////////////////
       else if (command.equals("/about.do")) { 
          forward = new AboutAction().execute(request, response);
       }
/////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////// 준비중 페이지 /////////////////////////////////////       
       else if (command.equals("/preparingPage.do")) {
          forward = new PreparingPageAction().execute(request, response);
       }
/////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////// 마이 페이지 //////////////////////////////////////
       else if (command.equals("/mypage.do")) { // 마이 페이지 이동
          forward = new MypageAction().execute(request, response);
       }
       else if (command.equals("/prohibitListPage.do")) { // 신고글 3개 이상 글 출력
          forward = new ProhibitListPageAction().execute(request, response);
       }
       else if (command.equals("/ownBoardListPage.do")) { // 본인 글 출력
          forward = new OwnBoardListPageAction().execute(request, response);
       }
       else if (command.equals("/updateMpwPage.do")) { // 비밀번호 변경
          forward = new UpdateMpwPageAction().execute(request, response);
       }
       else if (command.equals("/updateMpw.do")) { // 비밀번호 변경
          forward = new UpdateMpwAction().execute(request, response);
       }
       else if (command.equals("/deleteMemberPage.do")) { // 회원탈퇴
          forward = new DeleteMemberPageAction().execute(request, response);
       }
       else if (command.equals("/deleteMember.do")) { // 회원탈퇴
          forward = new DeleteMemberAction().execute(request, response);
       }
////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////// 로그인, 회원가입 //////////////////////////////////
       else if (command.equals("/loginPage.do")) { // 로그인 페이지 이동
          forward = new LoginPageAction().execute(request, response);
       }
       else if (command.equals("/login.do")) { // 로그인
          forward = new LoginAction().execute(request, response);
       }
       else if (command.equals("/logout.do")) { // 로그아웃
          forward = new LogoutAction().execute(request, response);
       }
       else if (command.equals("/signupPage.do")) { // 회원가입 페이지 이동
          forward = new SignupPageAction().execute(request, response);
       }
       else if (command.equals("/signup.do")) { // 회원가입
          forward = new SignupAction().execute(request, response);
       }
////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////// 공지사항 ////////////////////////////////////////
       else if (command.equals("/noticeListPage.do")) { // 공지사항 목록 페이지 이동
          forward = new NoticeListPageAction().execute(request, response);
       }
       else if (command.equals("/noticePage.do")) { // 공지사항 상세 페이지
          forward = new NoticePageAction().execute(request, response);
       }
       else if (command.equals("/insertNoticePage.do")) { // 공지사항 작성 페이지 이동
          forward = new InsertNoticePageAction().execute(request, response);
       }
       else if (command.equals("/insertNotice.do")) { // 공지사항 작성
          forward = new InsertNoticeAction().execute(request, response);
       }
       else if (command.equals("/updateNoticePage.do")) { // 공지사항 수정 페이지 이동
          forward = new UpdateNoticePageAction().execute(request, response);
       }
       else if (command.equals("/updateNotice.do")) { // 공지사항 수정
          forward = new UpdateNoticeAction().execute(request, response);
       }
       else if (command.equals("/deleteNotice.do")) { // 공지사항 삭제
          forward = new DeleteNoticeAction().execute(request, response);
       }
////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////// 커뮤니티 ///////////////////////////////////////
       else if (command.equals("/boardListPage.do")) { // 게시글 목록 페이지 이동
          forward = new BoardListPageAction().execute(request, response);
          System.out.println(forward.getPath());
       }
       else if (command.equals("/boardPage.do")) { // 게시글 상세 페이지 이동
          forward = new BoardPageAction().execute(request, response);
       }
       else if (command.equals("/insertBoardPage.do")) { // 게시글 작성 페이지 이동
          forward = new InsertBoardPageAction().execute(request, response);
       }
       else if (command.equals("/insertBoard.do")) { // 게시글 작성
          forward = new InsertBoardAction().execute(request, response);
       }
       else if (command.equals("/updateBoardPage.do")) { // 게시글 수정 페이지 이동
          forward = new UpdateBoardPageAction().execute(request, response);
       }
       else if (command.equals("/updateBoard.do")) { // 게시글 수정
          forward = new UpdateBoardAction().execute(request, response);
       }
       else if (command.equals("/deleteBoard.do")) { // 게시글 삭제
          forward = new DeleteBoardAction().execute(request, response);
       }
////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////// 댓글 ////////////////////////////////////////
       else if (command.equals("/insertComment.do")) { // 댓글 작성
          forward = new InsertCommentAction().execute(request, response);
       }
       else if (command.equals("/updateCommentPage.do")) { // 댓글 수정 페이지
          forward = new UpdateCommentPageAction().execute(request, response);
       }
       else if (command.equals("/updateComment.do")) { // 댓글 수정
          forward = new UpdateCommentAction().execute(request, response);
       }
       else if (command.equals("/deleteComment.do")) { // 댓글 삭제
          forward = new DeleteCommentAction().execute(request, response);
       }
       else if (command.equals("/insertReply.do")) { // 대댓글 작성
          forward = new InsertReplyAction().execute(request, response);
       }
       else if (command.equals("/updateReplyPage.do")) { // 대댓글 수정 페이지
          forward = new UpdateReplyPageAction().execute(request, response);
       }
       else if (command.equals("/updateReply.do")) { // 대댓글 수정
          forward = new UpdateReplyAction().execute(request, response);
       }
       else if (command.equals("/deleteReply.do")) { // 대댓글 삭제
          forward = new DeleteReplyAction().execute(request, response);
       }
////////////////////////////////////////////////////////////////////////////////////

       // 사용자에게 응답. View로 이동합니다.
       if (forward != null) {
          if (forward.isRedirect()) {
             // 리다이렉트. 데이터 X
             response.sendRedirect(forward.getPath());
          } else {
             // 포워드. 데이터 O
             RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
             dispatcher.forward(request, response);
          }
       } else {
          // 없는 요청
          // flag F
          response.sendRedirect("goback.jsp");
       }
    }
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doAction(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doAction(request, response);
   }

}
