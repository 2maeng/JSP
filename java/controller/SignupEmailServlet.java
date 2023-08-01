package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signupSuccess.do")
public class SignupEmailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public SignupEmailServlet() {
        super();
    }
    
    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // SMTP 서버 설정을 위한 Properties 객체 생성 및 설정
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        // SMTP 서버에 인증하기 위한 Session 생성
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rkdtmdcks012@gmail.com", "plfuxryfkbhhzaej");
            }
        });
        
        // 회원가입한 사용자의 이메일 주소를 가져옵니다.
        String receiver = (String) request.getAttribute("email");
        String name = (String) request.getAttribute("name");
        
        // 이메일 제목과 내용 설정
        String title = "[헬스해듀오] 더 나은 몸과 마음을 위한 당신만의 여정";
        String content = "<h2>" + name + "님의 회원가입을 진심으로 축하드립니다~!!</h2><br>"
                        + "헬스해듀오 관리자입니다. 헬스해듀오로 발걸음해주셔서 정말 감사합니다.<br>"
                        + "앞으로 더 나은 헬스해듀오가 되겠습니다~^^";
        
        // 이메일 메시지 생성
        Message message = new MimeMessage(session);
        
        try {
            message.setFrom(new InternetAddress("rkdtmdcks012@gmail.com", "관리자", "utf-8"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(title);
            message.setContent(content, "text/html; charset=utf-8");
            
            // 이메일 전송
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 회원가입 성공 후 메인 페이지로 이동
        String path = "main.do";
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }
}
