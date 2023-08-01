package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentSetDAO {
	// 댓글과 대댓글 정보를 함께 조회하는 SQL 쿼리문
	private final String SQL_SELECTALL = "SELECT C.COMMENTNUM, C.COMMENT, C.BOARDNUM, C.MID, C.PROHIBITCNT, M.NICKNAME FROM COMMENT C LEFT JOIN MEMBER M ON C.MID=M.MID WHERE C.BOARDNUM=? ORDER BY C.COMMENTNUM DESC LIMIT 0,?";
	// 대댓글을 조회하는 SQL 쿼리문
	private final String SQL_SELECTALL_REPLY = "SELECT R.REPLYNUM, R.REPLY, R.COMMENTNUM, R.MID, R.PROHIBITCNT, M.NICKNAME FROM REPLY R LEFT JOIN MEMBER M ON R.MID=M.MID WHERE R.COMMENTNUM=? ORDER BY R.REPLYNUM ASC";
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 댓글과 대댓글 정보를 함께 조회하는 메서드
	public ArrayList<CommentSet> selectAll(CommentVO cVO,int count){
		conn = JDBCUtil.connect();
		ArrayList<CommentSet> csdatas = new ArrayList<CommentSet>(); // 정보들을 저장할 배열

		try { // 예외처리
			pstmt = conn.prepareStatement(SQL_SELECTALL);
			pstmt.setInt(1, cVO.getBoardNum());
			pstmt.setInt(2, count);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				CommentSet cs=new CommentSet();
				CommentVO cdata =new CommentVO();
				cdata.setCommentNum(rs.getInt("COMMENTNUM"));
				cdata.setComment(rs.getString("COMMENT"));
				cdata.setBoardNum(rs.getInt("BOARDNUM"));
				cdata.setMid(rs.getString("MID"));
				cdata.setProhibitCnt(rs.getInt("PROHIBITCNT"));
				cdata.setNickName(rs.getString("NICKNAME"));
				cs.setComment(cdata);
				// 댓글에 대한 대댓글 조회
				pstmt=conn.prepareStatement(SQL_SELECTALL_REPLY);
	            pstmt.setInt(1, cdata.getCommentNum());
	            ResultSet rs2=pstmt.executeQuery();
				ArrayList<ReplyVO> rdatas=new ArrayList<ReplyVO>();
				while(rs2.next()) {
					// 대댓글 정보 저장
					ReplyVO rdata=new ReplyVO();
					rdata.setReplyNum(rs2.getInt("REPLYNUM"));
					rdata.setReply(rs2.getString("REPLY"));
					rdata.setCommentNum(rs2.getInt("COMMENTNUM"));
					rdata.setMid(rs2.getString("MID"));
					rdata.setProhibitCnt(rs2.getInt("PROHIBITCNT"));
					rdata.setNickName(rs2.getString("NICKNAME"));
					rdatas.add(rdata);
				}
				/////
				cs.setRdatas(rdatas);
				csdatas.add(cs);
			}
			JDBCUtil.disconnect(rs, pstmt, conn);
			return csdatas;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
