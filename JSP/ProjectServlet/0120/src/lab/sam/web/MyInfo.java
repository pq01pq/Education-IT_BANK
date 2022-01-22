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
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		//String password= request.getParameter("password");
		String[] fruits = request.getParameterValues("fruit");
		String gender = request.getParameter("gender");
		String occupation = request.getParameter("occupation");
		String etc = request.getParameter("etc");
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>%s님의 개인정보 정보 출력</h2>");
		out.printf("<label>아이디 : %s</label> <br>", id);
		out.println("<label>좋아하는 과일 : </label>");
		for(String s : fruits) {
			out.print(s + " ");
		}
		out.printf("<label>성별 : %s</label> <br>", gender);
		out.printf("<label>직업 : %s</label> <br>", occupation);
		out.println("---------------------------<br>");
		out.println("<b>특이사항</b> <br>");
		out.printf("<pre>%s</pre>", etc);
		out.println("---------------------------<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
