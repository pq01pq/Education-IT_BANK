<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
private String name = "김강사";
private int age = 28;
String message = name + "와 함께하는 세상은 아름답다.";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>선언문 예제</h2>
	메세지 전달 : <%= message %>
</body>
</html>