<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String uId = request.getParameter("id");
	String uPassword = request.getParameter("password");
	String uColor = request.getParameter("color");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>포워딩 결과</h2>
	아이디 : <%= uId %><br>
	비밀번호 : <%= uPassword %><br>
	좋아하는 색 : <%= uColor %>
	<hr>
	아이디 : ${ param.id }<br>
	비밀번호 : ${ param.password }<br>
	좋아하는 색 : ${ param.color }<br>
</body>
</html>