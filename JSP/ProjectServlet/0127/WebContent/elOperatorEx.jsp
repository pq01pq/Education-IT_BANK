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
	<h2>el 연산자 연습</h2>
	문자열 : ${ "Hello EL" }<br>
	정수 : ${ 10 }<br>
	실수 : ${ 3.141592 }<br>
	<hr>
	<%
		pageContext.setAttribute("title", "el 연산자");
	%>
	<table border=1>
		<caption><b>el 연산 예</b></caption>
		<tr> <td>\${ 2 + 5 }</td> <td>${ 2 + 5 }</td> </tr>
		<tr> <td>\${ 4 / 5 }</td> <td>${ 4 / 5 }</td> </tr>
		<tr> <td>\${ 4 div 5 }</td> <td>${ 4 div 5 }</td> </tr>
		<tr> <td>\${ 10 % 3 }</td> <td>${ 10 % 3 }</td> </tr>
		<tr> <td>\${ 10 mod 3 }</td> <td>${ 10 mod 3 }</td> </tr>
		
		<tr> <td>\${ 2 < 3 }</td> <td>${ 2 < 3 }</td> </tr>
		<tr> <td>\${ 2 lt 3 }</td> <td>${ 2 lt 3 }</td> </tr>
		<tr> <td>\${ 2 > 3 }</td> <td>${ 2 > 3 }</td> </tr>
		<tr> <td>\${ 2 gt 3 }</td> <td>${ 2 gt 3 }</td> </tr>
		<tr> <td>\${ 3.14 == 3.15 }</td> <td>${ 3.14 == 3.15 }</td> </tr>
		<tr> <td>\${ 3.14 eq 3.15 }</td> <td>${ 3.14 eq 3.15 }</td> </tr>
		<tr> <td>\${ 3.14 != 3.15 }</td> <td>${ 3.14 != 3.15 }</td> </tr>
		<tr> <td>\${ 3.14 ne 3.15 }</td> <td>${ 3.14 ne 3.15 }</td> </tr>
		<tr> <td>\${ empty title }</td> <td>${ empty title }</td> </tr>
		<tr> <td>\${ empty param.name }</td> <td>${ empty param.name }</td> </tr>
		<!-- title은 현재 페이지의 매개변수, name은 이전 페이지에서 전달받은 매개변수 -->
		<tr> <td>\${ (5 > 3) ? 5 : 3 }</td> <td>${ (5 > 3) ? 5 : 3 }</td> </tr>
		<tr> <td>\${ (5 < 3) ? 5 : 3 }</td> <td>${ (5 < 3) ? 5 : 3 }</td> </tr>
	</table>
	
	<form action="elOperatorEx.jsp" method="post">
		<label>이름 : </label><input type="text" name="name" value="${ param['name'] } "><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>