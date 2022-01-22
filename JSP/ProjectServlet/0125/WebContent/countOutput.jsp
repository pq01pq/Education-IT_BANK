<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html; charset=utf-8");

String strCnt = request.getParameter("count");
int count = 0;
if(!strCnt.equals("")){
	count = Integer.parseInt(strCnt);
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
	for(int i = 1; i <= count; i++){%>
		<%= i %>&nbsp;
	<% } %>
	<br>
	
</body>
</html>