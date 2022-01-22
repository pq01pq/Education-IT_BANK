<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setAttribute("country", "Korea");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>c:if 예제</h2>
	<c:if test="${country == 'Korea'}">
		국적 : <c:out value="${country}"/><br>
	</c:if>
	
	<c:set var="country" value="ITBank"/>
	<c:if test="${country ne 'Korea'}">
		국적 : <c:out value="${country}"/>
	</c:if>
	
	<hr>
	
	<c:if test="${10 > 20}" var="result">
		${"10이 20보다 크다"}<br>
	</c:if>
	\${10 > 20} : ${result}<br><br>
	
	<c:if test="${20 > 10}" var="result">
		${"20이 10보다 크다"}<br>
	</c:if>
	\${20 > 10} : ${result}<br><br>
</body>
</html>