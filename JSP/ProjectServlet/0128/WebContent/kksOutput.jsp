<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>정보 출력</h2>
	<jsp:useBean id="kks" class="lab.sam.web.KimKangSa" scope="request"/>
								<!-- 자바 클래스 경로 -->
	<table border="1">
			<tr> <th>이름</th> <td><jsp:getProperty name="kks" property="name"/></td> </tr>
			<tr> <th>나이</th> <td><jsp:getProperty name="kks" property="age"/></td> </tr>
		</table>
</body>
</html>