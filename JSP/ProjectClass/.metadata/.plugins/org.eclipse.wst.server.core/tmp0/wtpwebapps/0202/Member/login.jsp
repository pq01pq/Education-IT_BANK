<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String enter = request.getParameter("enter");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
%>
<jsp:useBean id="bean" class="lab.sam.web.member.MemberBean"/>
<jsp:useBean id="dao" class="lab.sam.web.member.MemberDAO"/>
<jsp:setProperty name="bean" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String url = "/Member/joinForm.jsp";
	String msg = "";
	
	if(enter.equals("가입")){
		url = "/Member/joinForm.jsp";
	} else if(enter.equals("입장")){
		bean = dao.memberCheck(bean);
		String passwordBean = bean.getPassword();
		
		if(passwordBean.equals("")){
			msg = "아이디가 존재하지 않습니다.";
			url = "/Member/loginForm.jsp";
		} else if(passwordBean.equals(password)){
			url = "/index.jsp";
			session.setAttribute("sid", bean.getId());
		} else {
			msg = "비밀번호가 일치하지 않습니다.";
			url = "/Member/loginForm.jsp";
		}
	}
	
	request.setAttribute("message", msg);
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
%>
</body>
</html>