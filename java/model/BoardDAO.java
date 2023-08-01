package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
   // SQL 쿼리문
   private final String sql_INSERT = "INSERT INTO BOARD (TITLE, CONTENT, MID, CATEGORY, DATE) VALUES (?, ?, ?, ?, NOW())";
   private final String sql_SELECT_BY_PAGE = "SELECT B.BOARDNUM, B.TITLE, B.CONTENT, B.MID, B.PROHIBITCNT, B.CATEGORY, B.DATE, M.NICKNAME, (SELECT COUNT(CASE WHEN NUM = B.BOARDNUM THEN 1 END) FROM RECOMMEND) AS RCNT FROM BOARD B JOIN MEMBER M ON B.MID = M.MID WHERE B.CATEGORY = 1 OR B.CATEGORY = 2 ORDER BY BOARDNUM DESC";
   private final String sql_SELECTALL_CATEGORY = "SELECT B.BOARDNUM, B.TITLE, B.CONTENT, B.MID, B.PROHIBITCNT, B.CATEGORY, B.DATE, M.NICKNAME, (SELECT COUNT(CASE WHEN NUM = B.BOARDNUM THEN 1 END) FROM RECOMMEND) AS RCNT FROM BOARD B JOIN MEMBER M ON B.MID=M.MID WHERE B.CATEGORY=? ORDER BY BOARDNUM DESC";
   private final String sql_SELECTALL_PROHIBITCNT = "SELECT B.BOARDNUM, B.TITLE, B.CONTENT, B.MID, B.PROHIBITCNT, B.CATEGORY, B.DATE, M.NICKNAME, (SELECT COUNT(CASE WHEN NUM = B.BOARDNUM THEN 1 END) FROM RECOMMEND) AS RCNT FROM BOARD B JOIN MEMBER M ON B.MID=M.MID WHERE B.PROHIBITCNT >= 3 ORDER BY BOARDNUM DESC";
   private final String sql_SELECTALL_MYBOARD = "SELECT B.BOARDNUM, B.TITLE, B.CONTENT, B.MID, B.PROHIBITCNT, B.CATEGORY, B.DATE, M.NICKNAME, (SELECT COUNT(CASE WHEN NUM = B.BOARDNUM THEN 1 END) FROM RECOMMEND) AS RCNT FROM BOARD B JOIN MEMBER M ON B.MID=M.MID WHERE B.MID=? ORDER BY BOARDNUM DESC";
   private final String sql_SELECTONE = "SELECT B.BOARDNUM, B.TITLE, B.CONTENT, B.MID, B.PROHIBITCNT, B.CATEGORY, B.DATE, M.NICKNAME, (SELECT COUNT(CASE WHEN NUM = B.BOARDNUM THEN 1 END) FROM RECOMMEND) AS RCNT FROM BOARD B JOIN MEMBER M ON B.MID=M.MID WHERE B.BOARDNUM=?";
   private final String sql_UPDATE_BOARD = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE BOARDNUM=?";
   private final String sql_UPDATE_PROHIBIT = "UPDATE BOARD SET PROHIBITCNT=(SELECT COUNT(CASE WHEN NUM=? THEN 1 END ) FROM PROHIBIT) WHERE BOARDNUM=?";
   private final String sql_DELETE = "DELETE FROM BOARD WHERE BOARDNUM=?";
   // JDBC(자바 데이터베이스 커넥트) 도구
   Connection conn;
   PreparedStatement pstmt;
   ResultSet rs;
   
   public BoardDAO() {
   }

   public boolean insert(BoardVO bVO) { // DB에 객체정보 저장
      try { // 예외처리
         conn = JDBCUtil.connect(); // 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
         pstmt = conn.prepareStatement(sql_INSERT); // SQL 쿼리문을 입력하는 저장공간 생성

         pstmt.setString(1, bVO.getTitle());
         pstmt.setString(2, bVO.getContent());
         pstmt.setString(3, bVO.getMid());
         pstmt.setInt(4, bVO.getCategory());

         int result = pstmt.executeUpdate(); // SQL 쿼리문 실행 및 결과 저장

         JDBCUtil.disconnect(pstmt, conn); // 사용한 도구 정리

         if (result >= 1) {
            return true;
         }

      } catch (SQLException e) { // 예외발생시
         e.printStackTrace(); // 예외정보 출력
         return false;
      }

      return false; // 저장 실패
   } // insert

   public ArrayList<BoardVO> selectAll(BoardVO bVO) { // 목록 검색
      ArrayList<BoardVO> bdatas = new ArrayList<BoardVO>(); // 정보들을 저장할 배열

      try { // 예외처리
         conn = JDBCUtil.connect();
         if (bVO.getSelect() != null) {
            if (bVO.getSelect().equals("전체커뮤니티")) { // 이름 검색일 경우
               pstmt = conn.prepareStatement(sql_SELECT_BY_PAGE);
            } else if (bVO.getSelect().equals("커뮤니티")) { // 이름 검색일 경우
               pstmt = conn.prepareStatement(sql_SELECTALL_CATEGORY);
               pstmt.setInt(1, bVO.getCategory());
            } else if (bVO.getSelect().equals("신고목록")) { // 라인 검색일 경우
               pstmt = conn.prepareStatement(sql_SELECTALL_PROHIBITCNT);
            } else if (bVO.getSelect().equals("본인글")) { // 라인 검색일 경우
               pstmt = conn.prepareStatement(sql_SELECTALL_MYBOARD);
               pstmt.setString(1, bVO.getMid());
            }
         }

         rs = pstmt.executeQuery(); // SQL 쿼리문 실행

         while (rs.next()) { // 가져온 정보 저장용 객체
            BoardVO bdata = new BoardVO(); // 가져온 정보 저장한 객체 생성
            bdata.setBoardNum(rs.getInt("BOARDNUM"));
            bdata.setTitle(rs.getString("TITLE"));
            bdata.setContent(rs.getString("CONTENT"));
            bdata.setMid(rs.getString("MID"));
            bdata.setProhibitCnt(rs.getInt("PROHIBITCNT"));
            bdata.setCategory(rs.getInt("CATEGORY"));
            bdata.setDate(rs.getDate("DATE"));
            bdata.setNickName(rs.getString("NICKNAME"));
            bdata.setRecommendCnt(rs.getInt("RCNT"));
            bdatas.add(bdata); // 생성한 객체를 배열에 저장
         }

      } catch (SQLException e) { // 예외발생시
         e.printStackTrace();
      }

      JDBCUtil.disconnect(rs, pstmt, conn); // 사용한 도구 정리

      return bdatas; // 검색 결과 리턴
   }

   public BoardVO selectOne(BoardVO bVO) { // 하나의 객체 정보 검색
      BoardVO bdata = null;
      try { // 예외방지
         conn = JDBCUtil.connect();
         pstmt = conn.prepareStatement(sql_SELECTONE); // SQL 쿼리문 입력
         pstmt.setInt(1, bVO.getBoardNum()); // SQL 쿼리문 수정
         rs = pstmt.executeQuery(); // SQL 쿼리문 실행

         if (rs.next()) { // 가져온 정보 저장
            bdata = new BoardVO();
            bdata.setBoardNum(rs.getInt("BOARDNUM"));
            bdata.setTitle(rs.getString("TITLE"));
            bdata.setContent(rs.getString("CONTENT"));
            bdata.setMid(rs.getString("MID"));
            bdata.setProhibitCnt(rs.getInt("PROHIBITCNT"));
            bdata.setCategory(rs.getInt("CATEGORY"));
            bdata.setDate(rs.getDate("DATE"));
            bdata.setNickName(rs.getString("NICKNAME"));
            bdata.setRecommendCnt(rs.getInt("RCNT"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      JDBCUtil.disconnect(rs, pstmt, conn); // 사용한 도구 정리
      
      return bdata; // 검색 결과 리턴
   }

   // 글 수정, 신고 증가, 신고 감소
   public boolean update(BoardVO bVO) {
      try { // 예외처리
         conn = JDBCUtil.connect(); // 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성

         if (bVO.getSelect().equals("글수정")) {
            pstmt = conn.prepareStatement(sql_UPDATE_BOARD);
            pstmt.setString(1, bVO.getTitle());
            pstmt.setString(2, bVO.getContent());
            pstmt.setInt(3, bVO.getBoardNum());
         } else if (bVO.getSelect().equals("신고")) {
            pstmt = conn.prepareStatement(sql_UPDATE_PROHIBIT);
            pstmt.setInt(1, bVO.getBoardNum());
            pstmt.setInt(2, bVO.getBoardNum());
         }

         int result = pstmt.executeUpdate(); // SQL 쿼리문 실행 및 결과 저장

         JDBCUtil.disconnect(pstmt, conn); // 사용한 도구 정리

         if (result >= 1) {
            return true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
         return false;
      }

      return false;
   }

   public boolean delete(BoardVO bVO) {
      try { // 예외처리
         conn = JDBCUtil.connect();
         pstmt = conn.prepareStatement(sql_DELETE); // SQL 쿼리문 입력
         pstmt.setInt(1, bVO.getBoardNum()); // SQL 쿼리문 수정
         int result = pstmt.executeUpdate(); // SQL 쿼리문 실행 및 결과 저장

         JDBCUtil.disconnect(pstmt, conn); // 사용한 도구 정리

         if (result >= 1) {
            return true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
         return false;
      }

      return false;
   }
}


//SELECT B.BOARDNUM, B.TITLE, B.CONTENT, B.MID, B.PROHIBITCNT, B.CATEGORY, B.DATE,
//M.NICKNAME, (SELECT COUNT(CASE WHEN NUM = B.BOARDNUM THEN 1 END) FROM RECOMMEND) AS RCNT
//FROM BOARD B JOIN MEMBER M ON B.MID=M.MID WHERE B.CATEGORY=? ORDER BY BOARDNUM DESC


