<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 확인</h2>
	<jsp:useBean id="member" class="lab.sam.web.MemberBean" scope="request"/>
	아이디 : <jsp:getProperty property="id" name="member"/><br>
	이름 : <jsp:getProperty property="name" name="member"/><br>
	이메일 : <jsp:getProperty property="email" name="member"/><br>
	전화번호 : <jsp:getProperty property="phoneNumber" name="member"/><br>
</body>
</html>