package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentDAO {
   // SQL 쿼리문
   private final String sql_INSERT = "INSERT INTO COMMENT (COMMENT, BOARDNUM, MID) VALUES (?, ?, ?)";
   private final String sql_SELECTALL = "SELECT C.COMMENTNUM, C.COMMENT, C.BOARDNUM, C.MID, C.PROHIBITCNT, M.NICKNAME FROM COMMENT C LEFT JOIN MEMBER M ON C.MID=M.MID ORDER BY C.COMMENTNUM DESC";
   private final String sql_SELECTONE = "SELECT C.COMMENTNUM, C.COMMENT, C.BOARDNUM, C.MID, C.PROHIBITCNT, M.NICKNAME FROM COMMENT C LEFT JOIN MEMBER M ON C.MID=M.MID WHERE C.COMMENTNUM=?";
   private final String sql_UPDATE_COMMENT = "UPDATE COMMENT SET COMMENT=? WHERE COMMENTNUM=?";
   private final String sql_UPDATE_PROHIBIT = "UPDATE COMMENT SET PROHIBITCNT=(SELECT COUNT(CASE WHEN NUM=? THEN 1 END ) FROM PROHIBIT) WHERE COMMENTNUM=?";
   private final String sql_DELETE = "DELETE FROM COMMENT WHERE COMMENTNUM=?";
   // JDBC(자바 데이터베이스 커넥트) 도구
   Connection conn;
   PreparedStatement pstmt;
   ResultSet rs;
   public CommentDAO() {

   }
   public boolean insert(CommentVO cVO) { // DB에 객체정보 저장
      try { // 의도하지 않은 프로그램종료 예방
         conn = JDBCUtil.connect();
         // SQL 쿼리문을 입력하는 저장공간 생성
         pstmt = conn.prepareStatement(sql_INSERT);
         // SQL 쿼리문 수정
         pstmt.setString(1, cVO.getComment());
         pstmt.setInt(2, cVO.getBoardNum());
         pstmt.setString(3, cVO.getMid());
         // SQL 쿼리문 실행 및 결과 저장
         int result = pstmt.executeUpdate();
         // 사용한 도구 정리
         JDBCUtil.disconnect(pstmt, conn);
         // 검색 결과 리턴
         if (result >= 1) {
            return true;
         }
      } catch (SQLException e) { // 의도하지 않은 오류가 발생했을 경우
         e.printStackTrace(); // 예외정보 출력
         return false;
      }
      return false;
   } // insert

   public ArrayList<CommentVO> selectAll(CommentVO cVO) { // 목록 검색
      ArrayList<CommentVO> cdatas = new ArrayList<CommentVO>(); // 정보들을 저장할 배열

      try { // 예외처리
         conn = JDBCUtil.connect();
         pstmt = conn.prepareStatement(sql_SELECTALL);
         rs = pstmt.executeQuery();
         while (rs.next()) {
            CommentVO cdata=new CommentVO();
            cdata.setCommentNum(rs.getInt("COMMENTNUM"));
            cdata.setComment(rs.getString("COMMENT"));
            cdata.setBoardNum(rs.getInt("BOARDNUM"));
            cdata.setMid(rs.getString("MID"));
            cdata.setProhibitCnt(rs.getInt("PROHIBITCNT"));
            cdata.setNickName(rs.getString("NICKNAME"));
            cdatas.add(cdata);
         }
         // 사용한 도구 정리
         JDBCUtil.disconnect(rs, pstmt, conn);

         // 검색 결과 리턴
         return cdatas;

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return null;

   }

   public CommentVO selectOne(CommentVO cVO) { // 하나의 객체 정보 검색
	   CommentVO cdata = null; // 저장할 공간
		try { // 예외방지
			conn = JDBCUtil.connect();
			// SQL 쿼리문 입력
			pstmt = conn.prepareStatement(sql_SELECTONE);
			// SQL 쿼리문 수정
			pstmt.setInt(1, cVO.getCommentNum());

			// SQL 쿼리문 실행
			rs = pstmt.executeQuery();
//			C.COMMENTNUM, C.COMMENT, C.BOARDNUM, C.MID, C.PROHIBITCNT, M.NICKNAME
			// 가져온 정보 저장
			if (rs.next()) {
				cdata=new CommentVO();
				cdata.setCommentNum(rs.getInt("COMMENTNUM"));
				cdata.setComment(rs.getString("COMMENT"));
				cdata.setBoardNum(rs.getInt("BOARDNUM"));
				cdata.setMid(rs.getString("MID"));
				cdata.setProhibitCnt(rs.getInt("PROHIBITCNT"));
				cdata.setNickName(rs.getString("NICKNAME"));
			}
			// 사용한 도구 정리
			JDBCUtil.disconnect(rs, pstmt, conn);

			return cdata;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
   }

   public boolean update(CommentVO cVO) {
      try { // 예외처리
         // 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
         conn = JDBCUtil.connect();

         // SQL 쿼리문 입력
         if(cVO.getSelect().equals("댓글수정")) {
            pstmt = conn.prepareStatement(sql_UPDATE_COMMENT);
            pstmt.setString(1, cVO.getComment());
            pstmt.setInt(2, cVO.getCommentNum());
         }
         else if(cVO.getSelect().equals("신고")) {
            pstmt = conn.prepareStatement(sql_UPDATE_PROHIBIT);
            pstmt.setInt(1, cVO.getCommentNum());
            pstmt.setInt(2, cVO.getCommentNum());
         }
         // SQL 쿼리문 실행 및 결과 저장
         int result = pstmt.executeUpdate();
         // 사용한 도구 정리
         JDBCUtil.disconnect(pstmt, conn);
         // 검색 결과 리턴
         if (result >= 1) {
            return true;
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }

   public boolean delete(CommentVO cVO) {

      try { // 의도하지 않은 프로그램종료 예방
         // 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
         conn = JDBCUtil.connect();

         // SQL 쿼리문 입력
         pstmt = conn.prepareStatement(sql_DELETE);
         // SQL 쿼리문 수정
         pstmt.setInt(1, cVO.getCommentNum());

         // SQL 쿼리문 실행 및 결과 저장
         int result = pstmt.executeUpdate();

         // 사용한 도구 정리
         JDBCUtil.disconnect(pstmt, conn);

         // 성공 리턴
         if (result >= 1) {
            return true;
         }
      } catch (SQLException e) { // 의도하지 않은 오류가 발생했을 경우
         e.printStackTrace(); // 예외정보 출력
         return false;
      }      
      return false;
   }
}

//SELECT C.COMMENTNUM, C.COMMENT, C.BOARDNUM, C.MID, C.PROHIBITCNT, M.NICKNAME 
//FROM COMMENT C LEFT JOIN MEMBER M ON C.MID=M.MID ORDER BY C.COMMENTNUM DESC

