package lab.sam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sum")
public class SumEx extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
//		int number = Integer.parseInt(request.getParameter("number"));
		int number = 10;
		
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.print("<h2>");
		int sum = 0;
		for(int i = 0; i < number; i++) {
			sum += i + 1;
			out.print(i + 1);
			if(i < number - 1) {
				out.print(" + ");
			}
		}
		out.print(" = " + sum);
		out.print("</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
