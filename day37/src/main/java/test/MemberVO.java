package test;

public class MemberVO {
	private String mid;
	private String mpw;
	
	public MemberVO() {
		this("", "");
	}
	
	public MemberVO(String mid, String mpw) {
		this.mid = mid;
		this.mpw = mpw;
	}
	
	public String getMid() {
		return mid;
	}
	
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	public String getMpw() {
		return mpw;
	}
	
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	@Override
	public String toString() {
		return this.mid + "님";
	}
	
	
	
}
