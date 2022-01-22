package lab.sam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/app")
public class ApplicationEx extends HttpServlet {
	
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		ServletContext application = request.getServletContext();
		
		String strValue = request.getParameter("value");
		String operator = request.getParameter("operator");
		
		int value = 0;
		if(!strValue.equals("")) {
			value = Integer.parseInt(strValue);
		}
		
		int result = 0;
		
		if(operator.equals("+") || operator.equals("-")) {
			application.setAttribute("keyValue", value);
			application.setAttribute("keyOperator", operator);			
		} else {
			int applicationNumber = (int) application.getAttribute("keyValue");	// getAttribute : Object형
			int parameterNumber = value;
			String strOperator = (String) application.getAttribute("keyOperator");
			
			if(strOperator.equals("+")) {
				result = applicationNumber + parameterNumber;
			} else {
				result = applicationNumber - parameterNumber;
			}
			
			out.printf("%d %s %d = %d<br>",
					applicationNumber, strOperator, parameterNumber, result);
		}
	}
}
