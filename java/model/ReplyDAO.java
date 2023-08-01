package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyDAO {
	// SQL 쿼리문
	private final String sql_INSERT = "INSERT INTO REPLY (REPLY, COMMENTNUM, MID) VALUES (?, ?, ?)";
	private final String sql_SELECTALL = "SELECT R.REPLYNUM, R.REPLY, R.COMMENTNUM, R.MID, R.PROHIBITCNT, M.NICKNAME FROM REPLY R LEFT JOIN MEMBER M ON R.MID=M.MID ORDER BY R.REPLYNUM ASC";
	private final String sql_SELECTALL_COMMENTNUM = "SELECT R.REPLYNUM, R.REPLY, R.COMMENTNUM, R.MID, R.PROHIBITCNT, M.NICKNAME FROM REPLY R LEFT JOIN MEMBER M ON R.MID=M.MID WHERE COMMENTNUM=?";
	private final String sql_SELECTONE = "SELECT R.REPLYNUM, R.REPLY, R.COMMENTNUM, R.MID, R.PROHIBITCNT, M.NICKNAME FROM REPLY R LEFT JOIN MEMBER M ON R.MID=M.MID WHERE R.REPLYNUM=?";
	private final String sql_UPDATE_REPLY = "UPDATE REPLY SET REPLY=? WHERE REPLYNUM=?";
	private final String sql_UPDATE_PROHIBIT = "UPDATE REPLY SET PROHIBITCNT=(SELECT COUNT(CASE WHEN NUM=? THEN 1 END ) FROM PROHIBIT) WHERE REPLYNUM=?";
	private final String sql_DELETE = "DELETE FROM REPLY WHERE REPLYNUM=?";
	
	// JDBC(자바 데이터베이스 커넥트) 도구
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public ReplyDAO() {

	}

	public boolean insert(ReplyVO rVO) { // DB에 객체정보 저장
		try { // 의도하지 않은 프로그램종료 예방
			conn = JDBCUtil.connect();
			// SQL 쿼리문을 입력하는 저장공간 생성
			pstmt = conn.prepareStatement(sql_INSERT);

			// SQL 쿼리문 수정
			pstmt.setString(1, rVO.getReply());
			pstmt.setInt(2, rVO.getCommentNum());
			pstmt.setString(3, rVO.getMid());

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

	public ArrayList<ReplyVO> selectAll(ReplyVO rVO) { // 목록 검색
		ArrayList<ReplyVO> rdatas = new ArrayList<ReplyVO>(); // 정보들을 저장할 배열

		try { // 예외처리
			conn = JDBCUtil.connect();
			// SQL 쿼리문 입력
			if(rVO.getSelect()!=null) {
				if(rVO.getSelect().equals("전체출력")) {
					pstmt = conn.prepareStatement(sql_SELECTALL);
				}
				else if(rVO.getSelect().equals("댓글번호")) {
					pstmt = conn.prepareStatement(sql_SELECTALL_COMMENTNUM);
					pstmt.setInt(1, rVO.getCommentNum());
				}
			}
			// SQL 쿼리문 실행
			rs = pstmt.executeQuery();
			// 가져온 정보 저장용 객체
			while (rs.next()) {
				//"SELECT REPLYNUM,REPLY,COMMENTNUM,MID,PROHIBITCNT FROM REPLY";
				ReplyVO rdata=new ReplyVO();
				rdata.setReplyNum(rs.getInt("REPLYNUM"));
				rdata.setReply(rs.getString("REPLY"));
				rdata.setCommentNum(rs.getInt("COMMENTNUM"));
				rdata.setMid(rs.getString("MID"));
				rdata.setProhibitCnt(rs.getInt("PROHIBITCNT"));
				rdata.setNickName(rs.getString("NICKNAME"));
				rdatas.add(rdata);
			}
			// 사용한 도구 정리
			JDBCUtil.disconnect(rs, pstmt, conn);
			// 검색 결과 리턴
			return rdatas;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ReplyVO selectOne(ReplyVO rVO) { // 하나의 객체 정보 검색
		ReplyVO rdata = null; // 저장할 공간
		try { // 예외방지
			conn = JDBCUtil.connect();
			// SQL 쿼리문 입력
			pstmt = conn.prepareStatement(sql_SELECTONE);
			// SQL 쿼리문 수정
			pstmt.setInt(1, rVO.getReplyNum());

			// SQL 쿼리문 실행
			rs = pstmt.executeQuery();

			// 가져온 정보 저장
			if (rs.next()) {
				rdata=new ReplyVO();
				rdata.setReplyNum(rs.getInt("REPLYNUM"));
				rdata.setReply(rs.getString("REPLY"));
				rdata.setCommentNum(rs.getInt("COMMENTNUM"));
				rdata.setMid(rs.getString("MID"));
				rdata.setProhibitCnt(rs.getInt("PROHIBITCNT"));
				rdata.setNickName(rs.getString("NICKNAME"));
			}
			// 사용한 도구 정리
			JDBCUtil.disconnect(rs, pstmt, conn);

			return rdata;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean update(ReplyVO rVO) {
		try { // 예외처리
			conn = JDBCUtil.connect();
			// SQL 쿼리문 입력
			if(rVO.getSelect().equals("대댓글수정")) {
				pstmt = conn.prepareStatement(sql_UPDATE_REPLY);
				pstmt.setString(1, rVO.getReply());
				pstmt.setInt(2, rVO.getReplyNum());
			}
			else if(rVO.getSelect().equals("신고")) {
				pstmt = conn.prepareStatement(sql_UPDATE_PROHIBIT);
				pstmt.setInt(1, rVO.getReplyNum());
				pstmt.setInt(2, rVO.getReplyNum());
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

	public boolean delete(ReplyVO rVO) {
		try { // 의도하지 않은 프로그램종료 예방
			conn = JDBCUtil.connect();
			// SQL 쿼리문 입력
			pstmt = conn.prepareStatement(sql_DELETE);
			// SQL 쿼리문 수정
			pstmt.setInt(1, rVO.getReplyNum());

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