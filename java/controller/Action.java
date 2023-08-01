package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Action 인터페이스는 컨트롤러의 각각의 동작(액션)을 정의하기 위한 인터페이스입니다.
public interface Action {

    // 모든 구현체는 execute 메서드를 오버라이드하여 각각의 동작을 정의해야 합니다.
    // HttpServletRequest 객체와 HttpServletResponse 객체를 인자로 받습니다.
    // ServletException과 IOException을 처리할 수 있도록 선언합니다.
    ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    
}
