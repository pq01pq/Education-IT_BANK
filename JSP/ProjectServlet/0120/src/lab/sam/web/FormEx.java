package lab.sam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form")
public class FormEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
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
		String country = request.getParameter("country");
		String[] stay = request.getParameterValues("stay");
		String book = request.getParameter("book");
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>예약 정보 출력</h2>");
		out.printf("<label>이름 : %s</label> <br>", name);
		out.printf("<label>아이디 : %s</label> <br>", id);
		out.printf("<label>국적 : %s</label> <br>", country);
		out.println("<b>숙박형태 : </b>");
		for(String s : stay) {
			out.print(s + " ");
		} out.println("<br>");
		out.printf("<label>예약날짜 : %s</label> <br>", book);
		out.println("</body>");
		out.println("</html>");
	}

}
