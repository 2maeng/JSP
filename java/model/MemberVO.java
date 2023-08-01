package model;

public class MemberVO {
	private String mid;       // 회원 아이디를 저장하는 멤버 변수
    private String mpw;       // 회원 비밀번호를 저장하는 멤버 변수
    private String name;      // 회원 이름을 저장하는 멤버 변수
    private String nickName;  // 회원 닉네임을 저장하는 멤버 변수
    private String email;     // 회원 이메일을 저장하는 멤버 변수
    private String select;    // 검색 조건을 저장하는 멤버 변수
	
	// 검색 조건을 반환하는 메서드
	public String getSelect() {
		return select;
	}
	
	// 검색 조건을 설정하는 메서드
	public void setSelect(String select) {
		this.select = select;
	}
	
	// 회원 아이디를 반환하는 메서드
	public String getMid() {
		return mid;
	}
	
	// 회원 아이디를 설정하는 메서드
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	// 회원 비밀번호를 반환하는 메서드
	public String getMpw() {
		return mpw;
	}
	
	// 회원 비밀번호를 설정하는 메서드
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	
	// 회원 이름을 반환하는 메서드
	public String getName() {
		return name;
	}
	
	// 회원 이름을 설정하는 메서드
	public void setName(String name) {
		this.name = name;
	}
	
	// 회원 닉네임을 반환하는 메서드
	public String getNickName() {
		return nickName;
	}
	
	// 회원 닉네임을 설정하는 메서드
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	// 회원 이메일을 반환하는 메서드
	public String getEmail() {
		return email;
	}
	
	// 회원 이메일을 설정하는 메서드
	public void setEmail(String email) {
		this.email = email;
	}
}
