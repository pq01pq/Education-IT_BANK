<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>page context example</h2>
	<p>
		어서오세요. 환영합니다.
	</p>
	<%
	pageContext.forward("outEx.jsp");	// 거쳐왔던 페이지 지워짐
	%>
</body>
</html>