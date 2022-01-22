<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주석 예제</h2>
	<%
	String name = "김강사";
	%>
	<!-- HTML 주석 : <%= name %> -->
	<%-- JSP 주석 : <%= name %> --%>
	<%= name /* JAVA 주석 */%>
</body>
</html>