package model;

public class RecommendVO {
	private int recommendNum; // 추천 번호 (고유 식별자)를 저장하는 멤버 변수
    private String mid; // 추천한 회원의 아이디 (Member ID)를 저장하는 멤버 변수
    private int Fknum; // 게시글의 PK (게시글의 고유 번호)를 저장하는 멤버 변수

	// 추천 번호를 반환하는 메서드
	public int getRecommendNum() {
		return recommendNum;
	}

	// 추천 번호를 설정하는 메서드
	public void setRecommendNum(int recommendNum) {
		this.recommendNum = recommendNum;
	}

	// 추천한 회원의 아이디를 반환하는 메서드
	public String getMid() {
		return mid;
	}

	// 추천한 회원의 아이디를 설정하는 메서드
	public void setMid(String mid) {
		this.mid = mid;
	}

	// 게시글의 PK를 반환하는 메서드
	public int getFknum() {
		return Fknum;
	}

	// 게시글의 PK를 설정하는 메서드
	public void setFknum(int fknum) {
		Fknum = fknum;
	}
}
