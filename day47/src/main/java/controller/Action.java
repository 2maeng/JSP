package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
   // 클래스와 유사한데
   // 클래스는 아니라서 "생성자"가 없음
   // 객체화(인스턴스화) 불가
   // 오직 "메서드 오버라이딩 강제"를 위해 존재함
   
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
   // 디폴트 설정으로 abstract 키워드 존재
   // public 키워드 또한 디폴트 설정
   

}