<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String stringNumber = request.getParameter("number");
String stringExponent = request.getParameter("exponent");

int number = 1, exponent = 1;
if(!stringNumber.equals("")){
	number = Integer.parseInt(stringNumber);
}
if(!stringExponent.equals("")){
	exponent = Integer.parseInt(stringExponent);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int i = 0;
	long product = 1;
	while(i < exponent){
		product *= number;
		if(i < exponent - 1){ %>
			<%=number%>&nbsp;x
		<%} else { %>
			<%=number%>&nbsp;=
		<%}
		i++;
	}%>
	<%= product %>
</body>
</html>