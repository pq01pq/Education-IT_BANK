package lab.sam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem")
public class MemberDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request,
						HttpServletResponse response)
						throws ServletException, IOException {
		// 객체 은닉을 위해 getter, setter 사용
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");	// 웹브라우저가 출력할 때 인코딩 방식
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String strAge = request.getParameter("age");
		
		int age = 20;
		if(name.equals("")) {
			name = "김강사";
		}
		if(!strAge.equals("")) {
			age = Integer.parseInt(strAge);
		}
		
		out.println("이름 : " + name + "<br>");
		out.println("나이 : " + age + "살");
	}

}
