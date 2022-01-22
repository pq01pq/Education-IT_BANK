<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String idDB = "kks";
String uid = (String) session.getAttribute("uid");

String singer = request.getParameter("singer");
String song = request.getParameter("song");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	if(uid.equals(idDB)) { %>
		<h2><%= uid %>님의 정보</h2>
		좋아하는 가수 : <%= singer %><br>
		좋아하는 노래 : <%= song %>
<%		session.invalidate();
	} else { %>
		로그인하세요.
<%	} %>
</body>
</html>