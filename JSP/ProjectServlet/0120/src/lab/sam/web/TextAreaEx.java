package lab.sam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/textarea")
public class TextAreaEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// get은 url에 정보가 노출됨
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>post 정보 출력</h2>");
		out.printf("<label>이름 : </label>%s<br>", name);
		out.printf("<label>전화번호 : </label>%s<br>", phone);
		out.println("<b>저장되었습니다.</b>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String content = request.getParameter("content");
		
		String passDB = "1234";
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>get 정보 출력</h2>");
		if(password.equals(passDB)) {
			out.printf("<label>이름 : </label>%s<br>", name);
			out.printf("<label>아이디 : </label>%s<br>", id);
			out.printf("<label>성별 : </label>%s<br>", gender);
			
			out.println("<br>------- 경력사항 -------");
			out.printf("<pre>%s</pre>", content);
			out.println("<br>---------------------<br>");
			out.println("<b>저장되었습니다.</b>");
		} else {
			out.printf("<br><b>Incorrect password.</b><br>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
