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
	<h2>c:out 예제</h2>
	<c:out value="Hello JSTL" /><br>
	<c:out value="Hello JSTL">Hello JSTL Too</c:out><br>
	<c:out value="${ null }">Hello JSTL</c:out><br>
	<c:out value="${ null }" />
</body>
</html>