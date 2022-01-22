package lab.sam.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class ResponseEncoding implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response,
						FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(request, response);	// 스레드 호출
		response.setContentType("text/html; charset=euc-kr");
		// http servlet에서 나와서 WAS로 넘어가기 전 응답에 대해 적용
	}
}
