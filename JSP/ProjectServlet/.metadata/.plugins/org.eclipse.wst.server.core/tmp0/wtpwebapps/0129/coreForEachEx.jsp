<%@page import="java.util.ArrayList"%>
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
	<h2>c:forEach 예제</h2>
	<ul>
		<c:forEach var="num" begin="1" end="10">
			<li>Number : ${num}</li>
		</c:forEach>
	</ul>
	<c:forEach var="num" begin="1" end="10">
		<c:out value="${(num % 2 == 0) ? num : ' '}"/>
	</c:forEach>
	
	<hr>
	
	<c:set var="list" value='<%= new String[] {"1", "2", "3", "4", "5"} %>'/>
	<c:forEach var="num" items="${list}" begin="1" end="3">
		${num}&nbsp;
	</c:forEach>
	
	<hr>	
<%
	ArrayList<String> fruits = new ArrayList<String>();
	fruits.add("사과");
	fruits.add("배");
	fruits.add("딸기");
	fruits.add("참외");
	pageContext.setAttribute("fruit", fruits);
%>
	<ul>
		<c:forEach var="fr" items="${fruit}">
			<li>${fr}</li>
		</c:forEach>
	</ul>
	
	<c:set var="array">사과,배,딸기,참외</c:set>
	<c:forEach var="fr" items="${array}">
		<c:out value="${fr}"/>
	</c:forEach>
	
	<hr>
	
	<c:forTokens var="ar" items="1:하나, 2:둘, 3:삼, 4:넷" delims=",:">		<!-- delimeters -->
		<c:out value="${ar}"/><br>
	</c:forTokens>
</body>
</html>