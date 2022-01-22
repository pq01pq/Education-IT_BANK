package lab.sam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sam")	// 웹브라우저에 url을 넘겨줌
public class KimKangSa extends HttpServlet {
	
	public void service(HttpServletRequest request,
						HttpServletResponse response)
						throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String stringCount = request.getParameter("count");
		// count : url에 입력하는 변수. ex) url에 http://localhost:8088/sam?count=10 입력
		
		int count = 1;
		//int count = 10;
		if(stringCount != null && !stringCount.equals("")) {
			count = Integer.parseInt(stringCount);
		}
		for(int i = 0; i < count; i++) {
			out.println((i + 1) + " : 안녕 servlet<br>");	// 줄바꾸기 하려면 html 줄바꾸기 <br> 입력
		}
	}
}
