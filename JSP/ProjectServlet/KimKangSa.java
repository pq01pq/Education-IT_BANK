import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class KimKangSa extends HttpServlet {
	
	public void service(HttpServletRequest request,
				HttpServletResponse response)
				throws IOException, ServletException {
		//System.out.println("hello servlet");
		PrintWriter pwOut = response.getWriter();
		
		pwOut.println("hello servlet");
	}
	
}