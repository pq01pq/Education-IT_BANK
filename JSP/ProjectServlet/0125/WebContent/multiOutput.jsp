<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String strNum = request.getParameter("number");

int number = 1;
if(!strNum.equals("")){
	number = Integer.parseInt(strNum);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>구구단<%= number %>단</h2>
	<table border="1">
		<tr>
		<% out.println("<th>" + number + "단</th>");
		for(int i = 1; i < 10; i++){ %>
			<td><%= number %> x <%= i %> = <%= number * i %></td>
		<% } %> </tr>
	</table>
</body>
</html>