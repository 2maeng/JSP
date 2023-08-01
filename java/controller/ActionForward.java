package controller;

// ActionForward 클래스는 컨트롤러에서 액션의 실행 결과를 나타내는 클래스입니다.
public class ActionForward {

    // 리다이렉트 여부를 나타내는 변수입니다.
    private boolean redirect;

    // 이동할 경로를 나타내는 변수입니다.
    private String path;
    
    // 리다이렉트 여부를 반환하는 메서드입니다.
    public boolean isRedirect() {
        return redirect;
    }
    
    // 리다이렉트 여부를 설정하는 메서드입니다.
    public void setRedirect(boolean redirect) {
        this.redirect = redirect;
    }
    
    // 이동할 경로를 반환하는 메서드입니다.
    public String getPath() {
        return path;
    }
    
    // 이동할 경로를 설정하는 메서드입니다.
    public void setPath(String path) {
        this.path = path;
    }
    
}
