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
	<c:set var="id" value="김강사"/>
	아이디 : ${ id }<br>
	<c:remove var="id"/>
	아이디 : ${ id }<br>
	
	<hr>
	<!-- 예외처리 -->
	<c:catch var="msg">
		<c:out value="<%= 0/0 %>"/>
	</c:catch>
	에러 메세지 : <c:out value="${ msg }"/>
</body>
</html>