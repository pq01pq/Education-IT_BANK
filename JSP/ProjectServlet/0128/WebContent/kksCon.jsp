<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int age = Integer.parseInt(request.getParameter("age"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 객체 생성</h2>
	<jsp:useBean id="kks" class="lab.sam.web.KimKangSa" scope="request"/>
	<jsp:setProperty property="name" name="kks" value="${ param.name }"/>
	<jsp:setProperty property="age" name="kks" value="<%= age %>"/>
	<jsp:forward page="kksOutput.jsp"/>
</body>
</html>