<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>정보 입력</h2>
	<form action="infoForward.jsp" method="post">
		<label>아이디 : </label><input type="text" name="id"><br>
		<label>비밀번호 : </label><input type="password" name="password"><br>
		<label>좋아하는 색</label><br>
		빨강색<input type="radio" name="color" value="red">
		주황색<input type="radio" name="color" value="orange">
		노랑색<input type="radio" name="color" value="yellow">
		초록색<input type="radio" name="color" value="green">
		파랑색<input type="radio" name="color" value="blue"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>