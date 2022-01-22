<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String password = request.getParameter("password");
	String confirmPassword = request.getParameter("confirmPassword");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	if(password.equals(confirmPassword)){ %>
	<jsp:useBean id="member" class="lab.sam.web.MemberBean" scope="request"/>
	<jsp:setProperty property="id" name="member" value="${ param.id }"/>
	<jsp:setProperty property="password" name="member" value="${ param.password }"/>
	<jsp:setProperty property="name" name="member" value="${ param.name }"/>
	<jsp:setProperty property="email" name="member" value="${ param.email }"/>
	<jsp:setProperty property="phoneNumber" name="member" value="${ param.phoneNumber }"/>
	<jsp:forward page="memberOutput.jsp"/>
<%	} else {
		String path = "memberInput.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	} %>
</body>
</html>