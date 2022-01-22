<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<caption><font size="5"><b>구 구 단</b></font></caption>
		<tr>
		<% for(int i = 2; i < 10; i++){ %>
			<th><%= i %>단</th>
		<% } %>
		</tr>
		
		<% for(int i = 1; i < 10; i++){ %>
		<tr>
			<% for(int j = 2; j < 10; j++){ %>
				<td><%= j %> x <%= i %> = <%= j * i %></td>
			<% } %>
		</tr>
		 <% } %>
	</table>
</body>
</html>