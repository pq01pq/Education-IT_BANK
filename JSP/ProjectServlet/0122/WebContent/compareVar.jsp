<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	long longVar = 123;
	int intVar = 123;
	if(longVar == intVar){ %>
		longVar(<%= longVar %>)과 intVar(<%= intVar %>)는 같다.
<%	} else { %>
		longVar(<%= longVar %>)과 intVar(<%= intVar %>)는 같지 않다.
<%	} %>
	<br>
	<%
	String upperStr = "ABC";
	String lowerStr = "abc";
	if(upperStr.equals(lowerStr)){ %>
		upperStr(<%= upperStr %>)과 lowerStr(<%= lowerStr %>)은 같다.
	<% } else { %>
		upperStr(<%= upperStr %>)과 lowerStr(<%= lowerStr %>)은 같지 않다.
	<% }
	%>
</body>
</html>