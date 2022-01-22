<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>표현식 객체 예제</h2>
	<%
	Date today = new Date();
	int num1 = 10;
	int num2 = 20;
	
	%>
	
	num1 : <%= num1 %> <br>
	num2 : <%= num2 %> <br>
	sum : <%= num1 + num2 %> <br>
	현재 시간 : <%= today %> <br>
	Integer(num1) : <%= new Integer(num1) %>
</body>
</html>