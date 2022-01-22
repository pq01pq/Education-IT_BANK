<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	
	String name = request.getParameter("name");
	String stringJava = request.getParameter("java");
	String stringJSP = request.getParameter("jsp");
	String stringSpring = request.getParameter("spring");
	
	int java = 0, jsp = 0, spring = 0;
	
	if(!stringJava.equals("")) {
		java = Integer.parseInt(stringJava);
	}
	
	if(!stringJSP.equals("")) {
		jsp = Integer.parseInt(stringJSP);
	}
	
	if(!stringSpring.equals("")) {
		spring = Integer.parseInt(stringSpring);
	}
	
	int sum = java + jsp + spring;
	double average = sum / 3.0;
	
	DecimalFormat df = new DecimalFormat("#.##");
	String stringAverage = df.format(average);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 align="center">성적 출력</h2>
	<table border="1" align="center">
		<tr> <th>이름</th> <td><%= name %></td> </tr>
		<tr> <th>java</th> <td><%= java %>점</td> </tr>
		<tr> <th>jsp</th> <td><%= jsp %>점</td> </tr>
		<tr> <th>spring</th> <td><%= spring %>점</td> </tr>
		<tr> <th>총합</th> <td><%= sum %>점</td> </tr>
		<tr> <th>평균</th> <td><%= stringAverage %>점</td> </tr>
	</table>
</body>
</html>