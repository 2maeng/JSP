package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	static final private String SQL_SELECTONE = "SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	static final private String SQL_INSERT = "INSERT INTO MEMBER (MID,MPW,NAME) VALUES(?,?,?)";

	public MemberVO selectOne(MemberVO mVO){
		conn=JDBCUtil.connect();
		MemberVO data=null;
		
		try {
			pstmt=conn.prepareStatement(SQL_SELECTONE);
			pstmt.setString(1, mVO.getMid());
			pstmt.setString(2, mVO.getMpw());
			rs=pstmt.executeQuery();

			if(rs.next()) {
				data=new MemberVO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
				data.setName(rs.getString("NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JDBCUtil.disconnect(rs, pstmt, conn);

		return data;
	}

	public boolean insert(MemberVO mVO) {
		conn=JDBCUtil.connect();

		try {
			pstmt=conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, mVO.getMid());
			pstmt.setString(2, mVO.getMpw());
			pstmt.setString(3, mVO.getName());
			int rs=pstmt.executeUpdate();
			if(rs<=0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	public boolean update(MemberVO mVO) {
		return false;
	}
	public boolean delete(MemberVO mVO) {
		return false;
	}

}
