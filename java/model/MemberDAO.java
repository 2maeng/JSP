package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	// SQL 쿼리문
	private final String sql_INSERT = "INSERT INTO MEMBER (MID, MPW, NAME, NICKNAME, EMAIL) VALUES (?, ?, ?, ?, ?)";
	private final String sql_SELECTONE_DUPLICATE = "SELECT MID,MPW,NAME,NICKNAME,EMAIL FROM MEMBER WHERE MID=?";	// 중복검사
	private final String sql_SELECTONE_DUPLICATE_NICKNAME = "SELECT MID,MPW,NAME,NICKNAME,EMAIL FROM MEMBER WHERE NICKNAME=?";	// 닉네임중복검사
	private final String sql_SELECTONE_DUPLICATE_EMAIL = "SELECT MID,MPW,NAME,NICKNAME,EMAIL FROM MEMBER WHERE EMAIL=?";	// 이메일중복검사
	private final String sql_SELECTONE_LOGIN = "SELECT MID,MPW,NAME,NICKNAME,EMAIL FROM MEMBER WHERE MID=? AND MPW=?";	// 로그인
	private final String sql_UPDATE = "UPDATE MEMBER SET MPW=? WHERE MID=?";
	private final String sql_DELETE = "DELETE FROM MEMBER WHERE MID=?";
	// JDBC(자바 데이터베이스 커넥트) 도구
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public boolean insert(MemberVO mVO) { // DB에 객체정보 저장
		try { // 의도하지 않은 프로그램종료 예방
			// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();
			// SQL 쿼리문을 입력하는 저장공간 생성
			pstmt = conn.prepareStatement(sql_INSERT);

			// SQL 쿼리문 수정
			pstmt.setString(1, mVO.getMid());
			pstmt.setString(2, mVO.getMpw());
			pstmt.setString(3, mVO.getName());
			pstmt.setString(4, mVO.getNickName());
			pstmt.setString(5, mVO.getEmail());

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
		return false; // 저장 실패
	} // insert

	public ArrayList<MemberVO> selectAll(MemberVO mVO) { 
		return null;
	}

	public MemberVO selectOne(MemberVO mVO) { 
		MemberVO mdata = null; // 저장할 공간
		try { // 예외방지
			// 데이터베이스 로그인 == 자바와 DB를 연결하는 객체 생성
			conn = JDBCUtil.connect();
			// SQL 쿼리문 입력
			if(mVO.getSelect().equals("중복검사")) {
				pstmt = conn.prepareStatement(sql_SELECTONE_DUPLICATE);
				pstmt.setString(1, mVO.getMid());
			}
			else if(mVO.getSelect().equals("닉네임중복검사")) {
				pstmt = conn.prepareStatement(sql_SELECTONE_DUPLICATE_NICKNAME);
				pstmt.setString(1, mVO.getNickName());
			}
			else if(mVO.getSelect().equals("이메일중복검사")) {
				pstmt = conn.prepareStatement(sql_SELECTONE_DUPLICATE_EMAIL);
				pstmt.setString(1, mVO.getEmail());
			}
			else if(mVO.getSelect().equals("로그인")) {
				pstmt = conn.prepareStatement(sql_SELECTONE_LOGIN);
				pstmt.setString(1, mVO.getMid());
				pstmt.setString(2, mVO.getMpw());
			}
			// SQL 쿼리문 실행
			rs = pstmt.executeQuery();

			// 가져온 정보 저장
			if (rs.next()) {
				mdata = new MemberVO();
				mdata.setMid(rs.getString("MID"));
				mdata.setMpw(rs.getString("MPW"));
				mdata.setName(rs.getString("NAME"));
				mdata.setNickName(rs.getString("NICKNAME"));
				mdata.setEmail(rs.getString("EMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		JDBCUtil.disconnect(rs, pstmt, conn);
		// 검색 결과 리턴
		return mdata;
	}

	public boolean update(MemberVO mVO) {
		try { 
			conn = JDBCUtil.connect();
			// SQL 쿼리문 입력
			pstmt = conn.prepareStatement(sql_UPDATE);
			// SQL 쿼리문 수정
			pstmt.setString(1, mVO.getMpw());
			pstmt.setString(2, mVO.getMid());

			// SQL 쿼리문 실행 및 결과 저장
			int result = pstmt.executeUpdate();
			// 사용한 도구 정리
			JDBCUtil.disconnect(pstmt, conn);

			// 성공 리턴1
			if (result >= 1) {
				return true;
			}
		} catch (SQLException e) { // 의도하지 않은 오류가 발생했을 경우
			e.printStackTrace(); // 예외정보 출력
			return false;
		}		
		return false;
	}

	public boolean delete(MemberVO mVO) {
		try { 
			conn = JDBCUtil.connect();
			// SQL 쿼리문 입력
			pstmt = conn.prepareStatement(sql_DELETE);
			// SQL 쿼리문 수정
			pstmt.setString(1, mVO.getMid());

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
