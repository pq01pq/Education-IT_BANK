<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/Layout/header.jsp" %>
	<form action="/Member/login.jsp" method="post">
		<p align="center">
			${ message }
		</p>
		<table border="1" align="center">
			<tr><td colspan="2">로그인</td></tr>
			<tr><th>아이디</th><td><input type="text" name="id"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="password"></td></tr>
			<tr><td colspan="2" align="center">
				<input type="submit" name="enter" value="입장">
				<input type="submit" name="enter" value="가입">
			</td></tr>
		</table>
	</form>
	<%@ include file="/Layout/footer.jsp" %>
</body>
</html>