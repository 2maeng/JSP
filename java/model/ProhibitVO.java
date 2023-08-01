package model;

public class ProhibitVO {
	private int prohibitNum; // 금지어 데이터의 고유 번호를 저장하는 멤버 변수
	private String mid; // 금지어를 등록한 회원의 아이디를 저장하는 멤버 변수
	private int Fknum; // 해당 금지어가 적용된 게시글, 댓글 또는 대댓글의 PK(Primary Key)를 저장하는 멤버 변수

	// 금지어 데이터의 고유 번호를 반환하는 메서드
	public int getProhibitNum() {
		return prohibitNum;
	}

	// 금지어 데이터의 고유 번호를 설정하는 메서드
	public void setProhibitNum(int prohibitNum) {
		this.prohibitNum = prohibitNum;
	}

	// 금지어를 등록한 회원의 아이디를 반환하는 메서드
	public String getMid() {
		return mid;
	}

	// 금지어를 등록한 회원의 아이디를 설정하는 메서드
	public void setMid(String mid) {
		this.mid = mid;
	}

	// 해당 금지어가 적용된 게시글, 댓글 또는 대댓글의 PK(Primary Key)를 반환하는 메서드
	public int getFknum() {
		return Fknum;
	}

	// 해당 금지어가 적용된 게시글, 댓글 또는 대댓글의 PK(Primary Key)를 설정하는 메서드
	public void setFknum(int fknum) {
		Fknum = fknum;
	}
}
