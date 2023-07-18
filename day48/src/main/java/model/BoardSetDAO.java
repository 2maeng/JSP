package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardSetDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static final private String SQL_SELECTALL = "SELECT * FROM BOARD ORDER BY BID DESC LIMIT 0, ?";
	static final private String SQL_SELECTALL_REPLY = "SELECT * FROM REPLY WHERE = BID ORDER BY RID DESC"; // FK WHERE절

	public ArrayList<BoardSet> selectAll(BoardVO bVO, int count){ // count를 bVO의 멤버변수로 추가하는거 너무 좋음
		conn = JDBCUtil.connect();

		ArrayList<BoardSet> datas = new ArrayList<BoardSet>();

		try {
			pstmt = conn.prepareStatement(SQL_SELECTALL);
			pstmt.setInt(1, count);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardSet bs = new BoardSet();
				BoardVO data = new BoardVO();

				data.setBid(rs.getInt("BID"));
				data.setMid(rs.getString("MID"));
				data.setBcontent(rs.getString("BCONTENT"));

				bs.setBoard(data);
				// 1개의 게시글에
				
				pstmt = conn.prepareStatement(SQL_SELECTALL_REPLY);
				pstmt.setInt(1, data.getBid());
				ResultSet rs2 = pstmt.executeQuery();
				
				ArrayList<ReplyVO> rdatas = new ArrayList<ReplyVO>();
				
				while(rs2.next()) {
					ReplyVO rVO = new ReplyVO();
					rVO.setBid(rs2.getInt("BID"));
					rVO.setDate(rs2.getDate("DATE"));
					rVO.setMid(rs2.getString("MID"));
					rVO.setRid(rs2.getInt("RID"));
					rVO.setRcontent(rs2.getString("RCONTENT"));
					rdatas.add(rVO);
				}
				// 여러개의 댓글
				
				bs.setRdatas(rdatas);
				
				datas.add(bs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.disconnect(rs, pstmt, conn);

		return datas;
	}
}
