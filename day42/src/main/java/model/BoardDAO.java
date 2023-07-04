package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static final private String SQL_SELECTALL="SELECT * FROM BOARD";
	static final private String SQL_SELECTONE="SELECT * FROM BOARD WHERE NUM=?";
	static final private String SQL_INSERT="INSERT INTO BOARD (TITLE, CONTENT, WRITER) VALUES(?, ?, ?)";
	static final private String SQL_UPDATE="UPDATE BOARD SET TITLE=?,CONTENT=? WHERE NUM=?";
	static final private String SQL_DELETE="DELETE FROM BOARD WHERE NUM=?";

	public ArrayList<BoardVO> selectAll(BoardVO bVO){
		conn=JDBCUtil.connect();

		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();

		try {
			pstmt=conn.prepareStatement(SQL_SELECTALL);
			rs=pstmt.executeQuery();

			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setNum(rs.getInt("NUM"));
				data.setTitle(rs.getString("TITLE"));
				data.setContent(rs.getString("CONTENT"));
				data.setWriter(rs.getString("WRITER"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.disconnect(rs, pstmt, conn);

		return datas;
	}
	public BoardVO selectOne(BoardVO bVO){
		conn=JDBCUtil.connect();

		BoardVO data = null;
		
		try {
			pstmt=conn.prepareStatement(SQL_SELECTONE);
			pstmt.setInt(1, bVO.getNum());
			rs=pstmt.executeQuery();

			if(rs.next()) {
				data=new BoardVO();
				data.setNum(rs.getInt("NUM"));
				data.setTitle(rs.getString("TITLE"));
				data.setContent(rs.getString("CONTENT"));
				data.setWriter(rs.getString("WRITER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.disconnect(rs, pstmt, conn);

		return data;
	}

	public boolean insert(BoardVO bVO) {
		conn=JDBCUtil.connect();

		try {
			System.out.println("bDAO insert bVO : " + bVO);
			pstmt=conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, bVO.getTitle());
			pstmt.setString(2, bVO.getContent());
			pstmt.setString(3, bVO.getWriter());
			int rs = pstmt.executeUpdate();
			if(rs <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		JDBCUtil.disconnect(pstmt, conn);

		return true;
	}
	
	public boolean update(BoardVO bVO) {
		conn = JDBCUtil.connect();

		try {
			pstmt=conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, bVO.getTitle());
			pstmt.setString(2, bVO.getContent());
			pstmt.setInt(3, bVO.getNum());
			int rs = pstmt.executeUpdate();
			if(rs <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		JDBCUtil.disconnect(pstmt, conn);

		return true;
	}
	public boolean delete(BoardVO bVO) {
		conn = JDBCUtil.connect();

		try {
			pstmt=conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, bVO.getNum());
			int rs = pstmt.executeUpdate();
			if(rs <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		JDBCUtil.disconnect(pstmt, conn);

		return true;
	}
}
