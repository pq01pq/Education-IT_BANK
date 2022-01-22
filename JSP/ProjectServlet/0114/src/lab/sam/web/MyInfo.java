package lab.sam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/info")
public class MyInfo extends HttpServlet {
	
	public void service(HttpServletRequest request,
						HttpServletResponse response) 
						throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String paramTitle = request.getParameter("title");
		String paramContent = request.getParameter("content");
		
		String title = "김강사 소개서";
		String content = "ITBank JSP 강사";
		
		if(!paramTitle.equals("") && !paramContent.equals("")) {
			title = paramTitle;
			content = paramContent;
		}
		
		out.println("제목 : " + title + "<br>");
		out.println("내용 : " + content);
	}
}
