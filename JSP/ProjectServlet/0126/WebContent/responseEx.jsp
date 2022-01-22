<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>response example</h2>
	<p>
		어서오세요. 환영합니다.
	</p>
	<%
		response.sendRedirect("responseCon.jsp");	// 흔적이 안남음. 캐시도 안남음
	%>
</body>
</html>