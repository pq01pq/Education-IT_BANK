<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Request 컨트롤러를 이용한 요청 처리 작업</h2>
	
	<form action="/web/request/basic01">
		<input type="submit" value="get 요청">
	</form>
	
	<form action="/web/request/basic01" method="post">
		<input type="submit" value="post 요청">
	</form>
</body>
</html>