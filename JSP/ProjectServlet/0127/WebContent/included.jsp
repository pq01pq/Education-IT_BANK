<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String schedule = request.getParameter("schedule");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	표현식 : 이름 : <%= name %><br>
	el : 이름 : ${ param.name }<br>
	<hr>
	<h2><%= name %>님의 강의 계획</h2>
	과목 : <%= subject %><br>
	날짜 : <%= schedule %><br>
	<hr>
	과목 : ${ param.subject }<br>
	날짜 : ${ param.schedule }<br>
</body>
</html>