<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int sum = 0;
		String str = "";
		for(int i = 1; i <= 10; i++){
			sum += i;
			str += i + " + ";
		}
		
		str = str.subSequence(0, str.length() - 3) + " = ";
	%>
	<%= str %> <%= sum %>
</body>
</html>