<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");

StackTraceElement[] stes = exception.getStackTrace();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>
		서버가 해당 요청을 충족시키지 못하게 하는 예기치 않은 조건을 맞닥뜨렸습니다.
	</p>
	<p>
		에러 타입 : <%= exception.getClass().getName() %><br>
		에러 메세지 : <%= exception.getMessage() %><br>
		에러 경로 :<br>
	<%	exception.printStackTrace(response.getWriter()); %>
	<%	for(int i = stes.length; i > 0; i--){ %>
		<%= stes[i - 1].toString() %><br>
	<%	} %>
	</p>
</body>
</html>