package controller;

public class ActionForward {
	// Controller로 돌아갈 준비
	// 1. 리다이렉트? 포워드?
	// 2. 어디로 가야되니?
	
	private boolean redirect;
	private String path;
	
	public boolean isRedirect() {
		return redirect;
	}
	
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	
}
