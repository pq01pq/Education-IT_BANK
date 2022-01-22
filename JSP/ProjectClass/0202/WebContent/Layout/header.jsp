<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p align="right">
		<c:if test="${sessionScope.sid != null }">
			<a href="/Member/logout.jsp">로그아웃 | </a>
			<a href="/Board/board.jsp">게시판 | </a>
		</c:if>
		<c:if test="${sessionScope.sid eq null }">
			<a href="/Member/loginForm.jsp">로그인 | </a>
		</c:if>
		<a href="/index.jsp">홈</a>
	</p>
	<hr>
</body>
</html>