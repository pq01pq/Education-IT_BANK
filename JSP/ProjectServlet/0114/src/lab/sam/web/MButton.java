package lab.sam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mbutton")
public class MButton extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String strFirstNumber = request.getParameter("firstNumber");
		String strSecondNumber = request.getParameter("secondNumber");
		String operator = request.getParameter("operator");
		
		int firstNumber = 0;
		int secondNumber = 0;
		
		if(!strFirstNumber.equals("")) {
			firstNumber = Integer.parseInt(strFirstNumber);
		}
		if(!strSecondNumber.equals("")) {
			secondNumber = Integer.parseInt(strSecondNumber);
		}
		
		int result = 0;
		if(operator.equals("+")) {
			result = firstNumber + secondNumber;
		} else {
			result = firstNumber - secondNumber;
		}
		
		out.printf("%d %s %d = %d<br>", firstNumber, operator, secondNumber, result);
	}

}
