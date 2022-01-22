package lab.sam.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")	// /* : 모든 것을 대상으로
public class RequestEncoding implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response,
						FilterChain chain) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		// http servlet으로 넘겨주기 전 요청에 대해 적용
		chain.doFilter(request, response);	// 스레드 호출
	}
}
