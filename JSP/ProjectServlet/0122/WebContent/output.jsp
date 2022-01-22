<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>표현식 예제</h2>
	<%
	String[] strArray = {"재미있는", "JSP", "아~", "좋다"};
	%>
	
	<table border="1" align="center" width="300">
		<tr> <th>Index</th> <th>내용</tr>
		<% for(int i = 0; i< strArray.length; i++){ %>
		<tr align="center"> <td><%= i %> </td> <td><%= strArray[i] %></td> </tr>
		<% } %>
		
	</table>
</body>
</html>