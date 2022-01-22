<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	
	String name = request.getParameter("name");
	String color = request.getParameter("color");
	
	String colorKor = null;
	if(color.equals("red")){
		colorKor = "빨강";
	} else if(color.equals("green")){
		colorKor = "초록";
	} else if(color.equals("blue")){
		colorKor = "파랑";
	} else if(color.equals("yellow")){
		colorKor = "노랑";
	} else {
		colorKor = "투명";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= name %>이(가) 좋아하는 색깔은 <%= colorKor %>색입니다.
</body>
</html>