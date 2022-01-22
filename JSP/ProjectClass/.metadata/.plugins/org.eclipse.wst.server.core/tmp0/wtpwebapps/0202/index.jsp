<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String message = "";
	String pageId = (String) request.getParameter("pageId");
	
	if(pageId == null){
		message = "환영합니다.";
	} else{
		message = (String) request.getAttribute("message");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/Layout/header.jsp" %>
	<p align="center">
		<b><%= message %></b>
	</p>
	<%@ include file="/Layout/footer.jsp" %>
	
</body>
</html>