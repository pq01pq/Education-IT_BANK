<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String color = request.getParameter("color");
	String password = "1234";
	String uPassword = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>포워딩 페이지</h2>
	왔다가 그냥 가는 페이지. 흔적이라도...(안남음)
<%
	if(!uPassword.equals(password)){
		String path = "infoInput.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	} else {
%>
	<!-- 포워딩할때 매개변수를 직접 전달할 수 있음 -->
	<jsp:forward page="infoOutput.jsp">
		<jsp:param value="<%= color %>" name="color"/>
	</jsp:forward>
<%	} %>
</body>
</html>