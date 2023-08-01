package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

@WebFilter({ "*.do", "*.jsp" })
public class EncFilter extends HttpFilter implements Filter {
    private String encoding;

    public EncFilter() {
        super();
    }

    // 필터가 파괴될 때 호출되는 메서드입니다.
    public void destroy() {
    }

    // 실제 필터링 작업이 수행되는 메서드입니다.
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 요청과 응답의 인코딩을 설정합니다.
        request.setCharacterEncoding(this.encoding);
        response.setCharacterEncoding(this.encoding);

        // 다음 필터로 요청과 응답을 전달합니다. (체인의 다음 필터 또는 서블릿)
        chain.doFilter(request, response);
    }

    // 필터가 초기화될 때 호출되는 메서드입니다.
    public void init(FilterConfig fConfig) throws ServletException {
        // 필터 초기화 시 인코딩 정보를 가져와서 멤버 변수에 저장합니다.
        this.encoding = fConfig.getServletContext().getInitParameter("encoding");
    }
}
