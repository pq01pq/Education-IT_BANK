package lab.sam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemLogin extends HttpServlet {

	public void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String enter = request.getParameter("enter");
		
		Cookie[] cookies = request.getCookies();
		
		if(id.equals("") || password.equals("")) {
			enter = "";
		}
		
		if(enter.equals("join")) {
			Cookie idCookie = new Cookie("keyID", id);
			Cookie passwordCookie = new Cookie("keyPassword", password);
			
			passwordCookie.setMaxAge(30*24*60*60);	// 비번 유효기간 30일
			response.addCookie(idCookie);
			response.addCookie(passwordCookie);
			
			out.println("Account submitted. ID : " + id);
			
		} else if(enter.equals("login")) {
			Cookie cookie;
			String idCookie = "";
			String passwordCookie = "";
			
			if(cookies != null) {
				for (Cookie c : cookies) {
					if(c.getName().equals("keyID")) {
						idCookie = c.getValue();
						break;
					}
				}
			}
			
			if(!idCookie.equals("")) {
				for(Cookie c : cookies) {
					if(c.getName().equals("keyPassword")) {
						passwordCookie = c.getValue();
						break;
					}
				}
			}
			
			if(idCookie.equals(id)) {
				if(passwordCookie.equals(password)) {
					out.println("Welcome " + idCookie + ".");
				} else {
					out.println("Wrong password.");
				}
			} else {
				out.println("ID does not exist.");
			}
			
		} else if(enter.equals("quit")) {
			for(Cookie c : cookies) {
				if(c.getValue().equals(id)) {
					c.setMaxAge(0);
					response.addCookie(c);
					break;
				}
			}
			for(Cookie c : cookies) {
				if(c.getValue().equals(password)) {
					c.setMaxAge(0);
					response.addCookie(c);
					break;
				}
			}
			
			out.println("Quit success.");
		}
		else {
			response.sendRedirect("mem-login.html");
		}
			
	}
}
