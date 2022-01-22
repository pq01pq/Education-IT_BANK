<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>while example</h2>
	<% int i = 0;
	while(i < 5){ %>
		i = <%= i + 1 %>
		<br>
		<% i++;
	} %>
</body>
</html>