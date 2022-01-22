<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("sid");
	session.invalidate();
	
	String msg = "로그아웃 되었습니다.";
	request.setAttribute("message", msg);
	
	pageContext.forward("/index.jsp?pageId=logout");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>