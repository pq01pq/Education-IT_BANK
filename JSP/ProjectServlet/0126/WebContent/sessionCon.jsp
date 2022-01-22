<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String uid = request.getParameter("uid");
String password = request.getParameter("password");

session.setAttribute("uid", uid);
session.setMaxInactiveInterval(60*60);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="sessionOutput.jsp" method="post">
		<p>
			<label>좋아하는 가수</label> <br>
			<input type="radio" name="singer" value="엠씨더맥스">엠씨더맥스<br>
			<input type="radio" name="singer" value="SG워너비">SG워너비<br>
			<input type="radio" name="singer" value="비쥬">비쥬<br>
			<input type="radio" name="singer" value="화이트">화이트<br>
			<input type="radio" name="singer" value="노아">노아<br>
		</p>
		<p>
			<select name="song">
				<option>사랑이란 아프려고 하는거죠</option>
				<option>한여름날의 꿈</option>
				<option>누구보다 널 사랑해</option>
				<option>7년간의 사랑</option>
				<option>남겨진 사랑</option>
			</select>
		</p>
		<input type="submit" value="전송">
	</form>
</body>
</html>