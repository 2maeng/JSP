package test;

// VO랑 DAO가 합쳐져있는 클래스
public class LoginBean {
	private String mid;
	private String mpw;
	private boolean flag;
//	private String result;
	

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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
	
//	public String getResult() {
//		return result;
//	}
//	
//	public void setResult(String result) {
//		this.result = result;
//	}
	
	public void check() {
		
		if(this.mid.equals("admin") && this.mpw.equals("1234")) {
			this.flag = true;
		}
		
	}
	
//	public void login() {
//		if(this.mid == null) {
//			this.result = "";
//		}
//		else if(this.mid.equals("admin") && this.mpw.equals("1234")){
//			this.result = "관리자 페이지입니다.";
//		}
//		else {
//			this.result = "다시 입력하세요";
//		}
//	}
}
