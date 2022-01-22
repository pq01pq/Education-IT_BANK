package lab.sam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cookie")
public class CookieEx extends HttpServlet {
	
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		
		String strValue = request.getParameter("value");
		String operator = request.getParameter("operator");
		
		int value = 0;
		if(!strValue.equals("")) {
			value = Integer.parseInt(strValue);
		}
		
		int result = 0;
		
		if(operator.equals("+") || operator.equals("-")) {
			Cookie valueCookie = new Cookie("keyValue", strValue);
			Cookie opCookie = new Cookie("keyOp", operator);
			
//			valueCookie.setMaxAge(60*60);
//			opCookie.setMaxAge(60*60);
			
			valueCookie.setPath("/");	// 쿠키를 보내는 경로
			
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			response.sendRedirect("cookie-ex.html");
			
		} else {
			int cookieNumber = 0;
			int parameterNumber = value;
			for(Cookie c : cookies) {
				if(c.getName().equals("keyValue")) {
					cookieNumber = Integer.parseInt(c.getValue());
					break;
				}
			}
			String op = "";
			for(Cookie c : cookies) {
				if(c.getName().contentEquals("keyOp")) {
					op = c.getValue();
				}
			}
			
			if(op.equals("+")) {
				result = cookieNumber + parameterNumber;
			} else {
				result = cookieNumber - parameterNumber;
			}
			
			out.printf("%d %s %d = %d<br>",
					cookieNumber, op, parameterNumber, result);
		}
	}
}
