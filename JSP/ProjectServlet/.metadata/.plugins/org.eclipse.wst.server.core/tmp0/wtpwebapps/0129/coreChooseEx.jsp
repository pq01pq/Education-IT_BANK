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
	<h2>c:choose 예제</h2>
	<c:set var="uid" value="김강사"/>
	<c:choose>
		<c:when test="${uid == 'admin'}">
			<c:out value="관리자 페이지"/><br>
		</c:when>
		<c:when test="${uid == '김강사'}">
			<c:out value="김강사 페이지"/><br>
		</c:when>
		<c:otherwise>
			${uid}'s Park<br>
		</c:otherwise>
	</c:choose>
	
	<hr>
	
	<c:set var="kangsa" value="${param.ks}"/>
	<c:if test="${empty kangsa}">
		<c:set var="kangsa" value="김강사"/>
	</c:if>
	
	<c:out value="강사 : ${kangsa}"/><br>
	
	<c:choose>
		<c:when test="${kangsa == '김강사'}">
			<c:out value="${kangsa}"/>님의 과목 : JSP
		</c:when>
		<c:when test="${kangsa == '김강오'}">
			<c:out value="${kangsa}"/>님의 과목 : 리눅스
		</c:when>
		<c:otherwise>
			<c:out value="${kangsa}"/> : ${"개설된 과목이 없습니다"}<br>
		</c:otherwise>
	</c:choose>
</body>
</html>